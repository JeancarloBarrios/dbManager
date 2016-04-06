// Generated from JDSQL.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JDSQLParser}.
 */
public interface JDSQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(JDSQLParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(JDSQLParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#ddlQuery}.
	 * @param ctx the parse tree
	 */
	void enterDdlQuery(JDSQLParser.DdlQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#ddlQuery}.
	 * @param ctx the parse tree
	 */
	void exitDdlQuery(JDSQLParser.DdlQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#createDbStmt}.
	 * @param ctx the parse tree
	 */
	void enterCreateDbStmt(JDSQLParser.CreateDbStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#createDbStmt}.
	 * @param ctx the parse tree
	 */
	void exitCreateDbStmt(JDSQLParser.CreateDbStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#alterDbStmt}.
	 * @param ctx the parse tree
	 */
	void enterAlterDbStmt(JDSQLParser.AlterDbStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#alterDbStmt}.
	 * @param ctx the parse tree
	 */
	void exitAlterDbStmt(JDSQLParser.AlterDbStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#dbName}.
	 * @param ctx the parse tree
	 */
	void enterDbName(JDSQLParser.DbNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#dbName}.
	 * @param ctx the parse tree
	 */
	void exitDbName(JDSQLParser.DbNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#newDbName}.
	 * @param ctx the parse tree
	 */
	void enterNewDbName(JDSQLParser.NewDbNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#newDbName}.
	 * @param ctx the parse tree
	 */
	void exitNewDbName(JDSQLParser.NewDbNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#dropDbStmt}.
	 * @param ctx the parse tree
	 */
	void enterDropDbStmt(JDSQLParser.DropDbStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#dropDbStmt}.
	 * @param ctx the parse tree
	 */
	void exitDropDbStmt(JDSQLParser.DropDbStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#showDbStmt}.
	 * @param ctx the parse tree
	 */
	void enterShowDbStmt(JDSQLParser.ShowDbStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#showDbStmt}.
	 * @param ctx the parse tree
	 */
	void exitShowDbStmt(JDSQLParser.ShowDbStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#useDbStmt}.
	 * @param ctx the parse tree
	 */
	void enterUseDbStmt(JDSQLParser.UseDbStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#useDbStmt}.
	 * @param ctx the parse tree
	 */
	void exitUseDbStmt(JDSQLParser.UseDbStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#createTableStmt}.
	 * @param ctx the parse tree
	 */
	void enterCreateTableStmt(JDSQLParser.CreateTableStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#createTableStmt}.
	 * @param ctx the parse tree
	 */
	void exitCreateTableStmt(JDSQLParser.CreateTableStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#tableName}.
	 * @param ctx the parse tree
	 */
	void enterTableName(JDSQLParser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#tableName}.
	 * @param ctx the parse tree
	 */
	void exitTableName(JDSQLParser.TableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#columnDecl}.
	 * @param ctx the parse tree
	 */
	void enterColumnDecl(JDSQLParser.ColumnDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#columnDecl}.
	 * @param ctx the parse tree
	 */
	void exitColumnDecl(JDSQLParser.ColumnDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(JDSQLParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(JDSQLParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#colName}.
	 * @param ctx the parse tree
	 */
	void enterColName(JDSQLParser.ColNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#colName}.
	 * @param ctx the parse tree
	 */
	void exitColName(JDSQLParser.ColNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#colConstraint}.
	 * @param ctx the parse tree
	 */
	void enterColConstraint(JDSQLParser.ColConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#colConstraint}.
	 * @param ctx the parse tree
	 */
	void exitColConstraint(JDSQLParser.ColConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#localids}.
	 * @param ctx the parse tree
	 */
	void enterLocalids(JDSQLParser.LocalidsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#localids}.
	 * @param ctx the parse tree
	 */
	void exitLocalids(JDSQLParser.LocalidsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#refids}.
	 * @param ctx the parse tree
	 */
	void enterRefids(JDSQLParser.RefidsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#refids}.
	 * @param ctx the parse tree
	 */
	void exitRefids(JDSQLParser.RefidsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#chNombre}.
	 * @param ctx the parse tree
	 */
	void enterChNombre(JDSQLParser.ChNombreContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#chNombre}.
	 * @param ctx the parse tree
	 */
	void exitChNombre(JDSQLParser.ChNombreContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#idTabla}.
	 * @param ctx the parse tree
	 */
	void enterIdTabla(JDSQLParser.IdTablaContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#idTabla}.
	 * @param ctx the parse tree
	 */
	void exitIdTabla(JDSQLParser.IdTablaContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#fkNombre}.
	 * @param ctx the parse tree
	 */
	void enterFkNombre(JDSQLParser.FkNombreContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#fkNombre}.
	 * @param ctx the parse tree
	 */
	void exitFkNombre(JDSQLParser.FkNombreContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#pkNombre}.
	 * @param ctx the parse tree
	 */
	void enterPkNombre(JDSQLParser.PkNombreContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#pkNombre}.
	 * @param ctx the parse tree
	 */
	void exitPkNombre(JDSQLParser.PkNombreContext ctx);
	/**
	 * Enter a parse tree produced by the {@code renameAlter}
	 * labeled alternative in {@link JDSQLParser#alterTableStmt}.
	 * @param ctx the parse tree
	 */
	void enterRenameAlter(JDSQLParser.RenameAlterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code renameAlter}
	 * labeled alternative in {@link JDSQLParser#alterTableStmt}.
	 * @param ctx the parse tree
	 */
	void exitRenameAlter(JDSQLParser.RenameAlterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code accionAlter}
	 * labeled alternative in {@link JDSQLParser#alterTableStmt}.
	 * @param ctx the parse tree
	 */
	void enterAccionAlter(JDSQLParser.AccionAlterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code accionAlter}
	 * labeled alternative in {@link JDSQLParser#alterTableStmt}.
	 * @param ctx the parse tree
	 */
	void exitAccionAlter(JDSQLParser.AccionAlterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#alterName}.
	 * @param ctx the parse tree
	 */
	void enterAlterName(JDSQLParser.AlterNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#alterName}.
	 * @param ctx the parse tree
	 */
	void exitAlterName(JDSQLParser.AlterNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#newName}.
	 * @param ctx the parse tree
	 */
	void enterNewName(JDSQLParser.NewNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#newName}.
	 * @param ctx the parse tree
	 */
	void exitNewName(JDSQLParser.NewNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#accion}.
	 * @param ctx the parse tree
	 */
	void enterAccion(JDSQLParser.AccionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#accion}.
	 * @param ctx the parse tree
	 */
	void exitAccion(JDSQLParser.AccionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#columnName}.
	 * @param ctx the parse tree
	 */
	void enterColumnName(JDSQLParser.ColumnNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#columnName}.
	 * @param ctx the parse tree
	 */
	void exitColumnName(JDSQLParser.ColumnNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#singleColConstraint}.
	 * @param ctx the parse tree
	 */
	void enterSingleColConstraint(JDSQLParser.SingleColConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#singleColConstraint}.
	 * @param ctx the parse tree
	 */
	void exitSingleColConstraint(JDSQLParser.SingleColConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#dropTableStmt}.
	 * @param ctx the parse tree
	 */
	void enterDropTableStmt(JDSQLParser.DropTableStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#dropTableStmt}.
	 * @param ctx the parse tree
	 */
	void exitDropTableStmt(JDSQLParser.DropTableStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#showTableStmt}.
	 * @param ctx the parse tree
	 */
	void enterShowTableStmt(JDSQLParser.ShowTableStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#showTableStmt}.
	 * @param ctx the parse tree
	 */
	void exitShowTableStmt(JDSQLParser.ShowTableStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#showColumnsStmt}.
	 * @param ctx the parse tree
	 */
	void enterShowColumnsStmt(JDSQLParser.ShowColumnsStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#showColumnsStmt}.
	 * @param ctx the parse tree
	 */
	void exitShowColumnsStmt(JDSQLParser.ShowColumnsStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(JDSQLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(JDSQLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#andexpr}.
	 * @param ctx the parse tree
	 */
	void enterAndexpr(JDSQLParser.AndexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#andexpr}.
	 * @param ctx the parse tree
	 */
	void exitAndexpr(JDSQLParser.AndexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(JDSQLParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(JDSQLParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(JDSQLParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(JDSQLParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#compareExpr}.
	 * @param ctx the parse tree
	 */
	void enterCompareExpr(JDSQLParser.CompareExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#compareExpr}.
	 * @param ctx the parse tree
	 */
	void exitCompareExpr(JDSQLParser.CompareExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(JDSQLParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(JDSQLParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#column}.
	 * @param ctx the parse tree
	 */
	void enterColumn(JDSQLParser.ColumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#column}.
	 * @param ctx the parse tree
	 */
	void exitColumn(JDSQLParser.ColumnContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#table}.
	 * @param ctx the parse tree
	 */
	void enterTable(JDSQLParser.TableContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#table}.
	 * @param ctx the parse tree
	 */
	void exitTable(JDSQLParser.TableContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void enterRel_op(JDSQLParser.Rel_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void exitRel_op(JDSQLParser.Rel_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#dmlQuery}.
	 * @param ctx the parse tree
	 */
	void enterDmlQuery(JDSQLParser.DmlQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#dmlQuery}.
	 * @param ctx the parse tree
	 */
	void exitDmlQuery(JDSQLParser.DmlQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#multiInsert}.
	 * @param ctx the parse tree
	 */
	void enterMultiInsert(JDSQLParser.MultiInsertContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#multiInsert}.
	 * @param ctx the parse tree
	 */
	void exitMultiInsert(JDSQLParser.MultiInsertContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#insertStmt}.
	 * @param ctx the parse tree
	 */
	void enterInsertStmt(JDSQLParser.InsertStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#insertStmt}.
	 * @param ctx the parse tree
	 */
	void exitInsertStmt(JDSQLParser.InsertStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#columnList}.
	 * @param ctx the parse tree
	 */
	void enterColumnList(JDSQLParser.ColumnListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#columnList}.
	 * @param ctx the parse tree
	 */
	void exitColumnList(JDSQLParser.ColumnListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#valueList}.
	 * @param ctx the parse tree
	 */
	void enterValueList(JDSQLParser.ValueListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#valueList}.
	 * @param ctx the parse tree
	 */
	void exitValueList(JDSQLParser.ValueListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#val}.
	 * @param ctx the parse tree
	 */
	void enterVal(JDSQLParser.ValContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#val}.
	 * @param ctx the parse tree
	 */
	void exitVal(JDSQLParser.ValContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#updateStmt}.
	 * @param ctx the parse tree
	 */
	void enterUpdateStmt(JDSQLParser.UpdateStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#updateStmt}.
	 * @param ctx the parse tree
	 */
	void exitUpdateStmt(JDSQLParser.UpdateStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#columnsUpdate}.
	 * @param ctx the parse tree
	 */
	void enterColumnsUpdate(JDSQLParser.ColumnsUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#columnsUpdate}.
	 * @param ctx the parse tree
	 */
	void exitColumnsUpdate(JDSQLParser.ColumnsUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#deleteStmt}.
	 * @param ctx the parse tree
	 */
	void enterDeleteStmt(JDSQLParser.DeleteStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#deleteStmt}.
	 * @param ctx the parse tree
	 */
	void exitDeleteStmt(JDSQLParser.DeleteStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#selectStmt}.
	 * @param ctx the parse tree
	 */
	void enterSelectStmt(JDSQLParser.SelectStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#selectStmt}.
	 * @param ctx the parse tree
	 */
	void exitSelectStmt(JDSQLParser.SelectStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#selectList}.
	 * @param ctx the parse tree
	 */
	void enterSelectList(JDSQLParser.SelectListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#selectList}.
	 * @param ctx the parse tree
	 */
	void exitSelectList(JDSQLParser.SelectListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#orderExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrderExpr(JDSQLParser.OrderExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#orderExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrderExpr(JDSQLParser.OrderExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDSQLParser#orderTerm}.
	 * @param ctx the parse tree
	 */
	void enterOrderTerm(JDSQLParser.OrderTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDSQLParser#orderTerm}.
	 * @param ctx the parse tree
	 */
	void exitOrderTerm(JDSQLParser.OrderTermContext ctx);
}