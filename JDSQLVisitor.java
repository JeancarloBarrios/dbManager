// Generated from JDSQL.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JDSQLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JDSQLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(JDSQLParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#ddlQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDdlQuery(JDSQLParser.DdlQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#createDbStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateDbStmt(JDSQLParser.CreateDbStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#alterDbStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterDbStmt(JDSQLParser.AlterDbStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#dbName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDbName(JDSQLParser.DbNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#newDbName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewDbName(JDSQLParser.NewDbNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#dropDbStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropDbStmt(JDSQLParser.DropDbStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#showDbStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowDbStmt(JDSQLParser.ShowDbStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#useDbStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUseDbStmt(JDSQLParser.UseDbStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#createTableStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTableStmt(JDSQLParser.CreateTableStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(JDSQLParser.TableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#columnDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnDecl(JDSQLParser.ColumnDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(JDSQLParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#colName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColName(JDSQLParser.ColNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#colConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColConstraint(JDSQLParser.ColConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#localids}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalids(JDSQLParser.LocalidsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#refids}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefids(JDSQLParser.RefidsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#chNombre}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChNombre(JDSQLParser.ChNombreContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#idTabla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdTabla(JDSQLParser.IdTablaContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#fkNombre}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFkNombre(JDSQLParser.FkNombreContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#pkNombre}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPkNombre(JDSQLParser.PkNombreContext ctx);
	/**
	 * Visit a parse tree produced by the {@code renameAlter}
	 * labeled alternative in {@link JDSQLParser#alterTableStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameAlter(JDSQLParser.RenameAlterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code accionAlter}
	 * labeled alternative in {@link JDSQLParser#alterTableStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccionAlter(JDSQLParser.AccionAlterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#alterName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterName(JDSQLParser.AlterNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#newName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewName(JDSQLParser.NewNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#accion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccion(JDSQLParser.AccionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#columnName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnName(JDSQLParser.ColumnNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#singleColConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleColConstraint(JDSQLParser.SingleColConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#dropTableStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTableStmt(JDSQLParser.DropTableStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#showTableStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowTableStmt(JDSQLParser.ShowTableStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#showColumnsStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowColumnsStmt(JDSQLParser.ShowColumnsStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(JDSQLParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#andexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndexpr(JDSQLParser.AndexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(JDSQLParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(JDSQLParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#compareExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExpr(JDSQLParser.CompareExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(JDSQLParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#column}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn(JDSQLParser.ColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable(JDSQLParser.TableContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#rel_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRel_op(JDSQLParser.Rel_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#dmlQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDmlQuery(JDSQLParser.DmlQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#multiInsert}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiInsert(JDSQLParser.MultiInsertContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#insertStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertStmt(JDSQLParser.InsertStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#columnList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnList(JDSQLParser.ColumnListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#valueList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueList(JDSQLParser.ValueListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVal(JDSQLParser.ValContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#updateStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateStmt(JDSQLParser.UpdateStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#columnsUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnsUpdate(JDSQLParser.ColumnsUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#deleteStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteStmt(JDSQLParser.DeleteStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#selectStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectStmt(JDSQLParser.SelectStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#selectList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectList(JDSQLParser.SelectListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#orderExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderExpr(JDSQLParser.OrderExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDSQLParser#orderTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderTerm(JDSQLParser.OrderTermContext ctx);
}