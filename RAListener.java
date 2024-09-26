// Generated from RA.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RAParser}.
 */
public interface RAListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RAParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(RAParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RAParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(RAParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RAParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(RAParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link RAParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(RAParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link RAParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(RAParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link RAParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(RAParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link RAParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(RAParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link RAParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(RAParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link RAParser#alist}.
	 * @param ctx the parse tree
	 */
	void enterAlist(RAParser.AlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link RAParser#alist}.
	 * @param ctx the parse tree
	 */
	void exitAlist(RAParser.AlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link RAParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(RAParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RAParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(RAParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RAParser#simplecondition}.
	 * @param ctx the parse tree
	 */
	void enterSimplecondition(RAParser.SimpleconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RAParser#simplecondition}.
	 * @param ctx the parse tree
	 */
	void exitSimplecondition(RAParser.SimpleconditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RAParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterOperand(RAParser.OperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link RAParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitOperand(RAParser.OperandContext ctx);
}