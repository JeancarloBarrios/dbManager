
grammar JDSQL;
//   Reserve Words and Terminals
CREATE: 'create'|'CREATE'|'Create';
DATABASE: 'database'|'DATABASE'|'Database';
DATABASES: 'databases'|'DATABASES'|'Databases';
ALTER: 'alter'|'ALTER'|'Alter';
RENAMETO: 'RENAME TO'|'Rename To'|'rename to';
DROP: 'drop'|'DROP'|'Drop';
SHOW: 'show'|'SHOW'|'Show';
USE: 'use'|'USE'|'Use';
TABLE: 'TABLE'|'Table'|'table';
INT: 'int'|'INT'|'Int';
FLOAT: 'FLOAT'|'Float'|'float';
DATE:'DATE'|'Date'|'date';
CHAR:'CHAR'|'Char'|'char';
CONSTRAINT: 'CONSTRAINT'|'Constraint'|'constraint';
PRIMARY: 'PRIMARY'|'Primary'|'primary';
KEY: 'KEY'|'Key'|'key';
FOREIGN: 'FOREIGN'|'Foreign'|'foreign';
CHECK:'CHECK'|'Check'|'check';
REFERENCES:'REFERENCES'|'References'|'references';
TABLES:'TABLES'|'Tables'|'tables';
COLUMN:'COLUMN'|'Column'|'column';
COLUMNS: 'COLUMNS'|'Columns'|'columns';
FROM:'FROM'|'From'|'from';
ADD:'ADD'|'Add'|'add';
AND: 'AND'|'And'|'and';
OR: 'OR'|'Or'|'or';
NOT: 'NOT'|'Not'|'not';
INSERT:'INSERT'|'Insert'|'insert';
INTO:'INTO'|'Into'|'into';
WHERE:'WHERE'|'Where'|'where';
UPDATE:'UPDATE'|'Update'|'update';
SET:'SET'|'Set'|'set';
DELETE:'DELETE'|'Delete'|'delete';
SELECT: 'SELECT'|'Select'|'select';
ORDER:'ORDER'|'Order'|'order';
BY: 'BY'|'By'|'by';
ASC: 'ASC'|'Asc'|'asc';
NULL: 'NULL'|'Null'|'null';
DESC: 'DESC'|'Desc'|'desc';
VALUES: 'VALUES'|'Values'|'values';
fragment LETTER: ('a'..'z'|'A'..'Z') ;
fragment DIGIT : '0'..'9' ;

WS : [ \t\r\n\f]+  ->channel(HIDDEN);
DATE_VAL: '\''DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT'\'' ;
NUM: DIGIT(DIGIT)* ;
ID : LETTER( LETTER | DIGIT | '_' | '-') * ;
CHAR_VAL: '\'' ~('\r' | '\n' | '\'')* '\'' ;
FLOAT_VAL: NUM'.'NUM;
/*---------------------------------------------------------- */

/* ----------------------Grammar------------------------- */
query: ddlQuery | dmlQuery ;
/*-----Data Definition Language QUERIES---- */
ddlQuery:   createDbStmt|
			alterDbStmt|
			dropDbStmt|
			showDbStmt|
			useDbStmt|
			createTableStmt|
			alterTableStmt|
			dropTableStmt|
			showTableStmt|
			showColumnsStmt;

createDbStmt: CREATE DATABASE ID;

alterDbStmt: ALTER DATABASE dbName RENAMETO newDbName;
	dbName: ID;
	newDbName:ID;

dropDbStmt: DROP DATABASE ID;
showDbStmt: SHOW DATABASES;
useDbStmt: USE DATABASE ID;

createTableStmt: CREATE TABLE tableName '('    (columnDecl (','columnDecl)* ) (   (',' CONSTRAINT colConstraint)*)?   ')';  //Revisar Constraints: por tabla
	tableName: ID;

	columnDecl: colName tipo  ;
		tipo: INT|FLOAT|DATE|CHAR'('NUM')'; //Formato DATE: �AAAA-MM-DD�
		colName: ID;

		colConstraint:  (pkNombre PRIMARY KEY '(' (localids(','localids)*)')'
						|fkNombre FOREIGN KEY '(' (localids (','localids)* ) ')' REFERENCES idTabla '('(refids(','refids)*)')'
						|chNombre CHECK '(' expression ')' );
			localids: ID;
			refids:ID;
			chNombre: ID;
			idTabla: ID ;
			fkNombre:ID;
			pkNombre: ID;
			 //PENDIENTE

alterTableStmt: ALTER TABLE alterName RENAMETO newName #renameAlter | ALTER TABLE alterName accion (','accion)*     #accionAlter ;
	alterName: ID;
	newName: ID;
	accion: ADD COLUMN columnName tipo  (singleColConstraint)* |
			ADD CONSTRAINT colConstraint| /* constraint de tabla  */
			DROP COLUMN columnName|
			DROP CONSTRAINT ID;
		columnName: ID;

	singleColConstraint: CONSTRAINT pkNombre PRIMARY KEY|
						 CONSTRAINT fkNombre REFERENCES idTabla '(' refids ')' |
						 CONSTRAINT chNombre CHECK '(' expression ')';


dropTableStmt: DROP TABLE ID;
showTableStmt: SHOW TABLES;
showColumnsStmt: SHOW COLUMNS FROM ID;

expression: andexpr | expression OR andexpr;
	andexpr: factor | andexpr AND factor;
	factor: primary | NOT primary;
	primary: compareExpr | '(' expression ')';
	compareExpr : term  rel_op term;
	term: column | NUM | FLOAT_VAL | DATE_VAL | CHAR_VAL | NULL;

column: ID| table'.'ID;
table: ID;
rel_op : '<' | '>' | '<=' | '>=' | '=' | '<>' ;


/* Data modeling Language---- */

dmlQuery: multiInsert | updateStmt | deleteStmt| selectStmt;

multiInsert: (insertStmt)(';' insertStmt)* ;
insertStmt: INSERT INTO table (columnList)? VALUES valueList ;
	columnList:  '('  colName (','colName)* ')';
	valueList: '(' val(',' val)* ')' ;
	val: NUM | FLOAT_VAL | DATE_VAL | CHAR_VAL | NULL;

updateStmt: UPDATE table SET columnsUpdate '=' val (',' columnsUpdate '=' val)* (WHERE expression)? ;
	columnsUpdate:ID ;


deleteStmt: DELETE FROM table (WHERE expression)?;

selectStmt: SELECT ('*'| selectList) FROM table(','table)* (WHERE expression)? (orderExpr)? ;
	selectList: ID(','ID)*;
	orderExpr: ORDER BY (orderTerm(','orderTerm)*);
	orderTerm: colName(ASC|DESC)? ;
