// Generated from RA.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RAParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LBRACKET=1, RBRACKET=2, LPAREN=3, RPAREN=4, SEMI=5, COMMA=6, UNION=7, 
		MINUS=8, INTERSECT=9, TIMES=10, JOIN=11, PROJECT=12, SELECT=13, RENAME=14, 
		AND=15, NUMBER=16, STRING=17, COMPARISON=18, NAME=19, WS=20;
	public static final int
		RULE_query = 0, RULE_expr = 1, RULE_factor = 2, RULE_term = 3, RULE_alist = 4, 
		RULE_condition = 5, RULE_simplecondition = 6, RULE_operand = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"query", "expr", "factor", "term", "alist", "condition", "simplecondition", 
			"operand"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'['", "']'", "'('", "')'", "';'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LBRACKET", "RBRACKET", "LPAREN", "RPAREN", "SEMI", "COMMA", "UNION", 
			"MINUS", "INTERSECT", "TIMES", "JOIN", "PROJECT", "SELECT", "RENAME", 
			"AND", "NUMBER", "STRING", "COMPARISON", "NAME", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "RA.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RAParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class QueryContext extends ParserRuleContext {
		public RANode value;
		public ExprContext e;
		public TerminalNode SEMI() { return getToken(RAParser.SEMI, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RAListener ) ((RAListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RAListener ) ((RAListener)listener).exitQuery(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			((QueryContext)_localctx).e = expr();
			setState(17);
			match(SEMI);

			    ((QueryContext)_localctx).value =  ((QueryContext)_localctx).e.value;
			  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public RANode value;
		public FactorContext e1;
		public ExprContext e2;
		public TerminalNode UNION() { return getToken(RAParser.UNION, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(RAParser.MINUS, 0); }
		public TerminalNode INTERSECT() { return getToken(RAParser.INTERSECT, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RAListener ) ((RAListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RAListener ) ((RAListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		try {
			setState(38);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(20);
				((ExprContext)_localctx).e1 = factor();
				setState(21);
				match(UNION);
				setState(22);
				((ExprContext)_localctx).e2 = expr();

				    RANode node = new RANode();
				    node.setLchild(((ExprContext)_localctx).e1.value);
				    node.setRchild(((ExprContext)_localctx).e2.value);
				    node.setRnodetype("union");
				    ((ExprContext)_localctx).value =  node;
				  
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				((ExprContext)_localctx).e1 = factor();
				setState(26);
				match(MINUS);
				setState(27);
				((ExprContext)_localctx).e2 = expr();

				    RANode node = new RANode();
				    node.setLchild(((ExprContext)_localctx).e1.value);
				    node.setRchild(((ExprContext)_localctx).e2.value);
				    node.setRnodetype("minus");
				    ((ExprContext)_localctx).value =  node;
				  
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(30);
				((ExprContext)_localctx).e1 = factor();
				setState(31);
				match(INTERSECT);
				setState(32);
				((ExprContext)_localctx).e2 = expr();

				    RANode node = new RANode();
				    node.setLchild(((ExprContext)_localctx).e1.value);
				    node.setRchild(((ExprContext)_localctx).e2.value);
				    node.setRnodetype("intersect");
				    ((ExprContext)_localctx).value =  node;
				  
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(35);
				((ExprContext)_localctx).e1 = factor();

				    ((ExprContext)_localctx).value =  ((ExprContext)_localctx).e1.value;
				  
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public RANode value;
		public TermContext e1;
		public ExprContext e2;
		public TerminalNode TIMES() { return getToken(RAParser.TIMES, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode JOIN() { return getToken(RAParser.JOIN, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RAListener ) ((RAListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RAListener ) ((RAListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_factor);
		try {
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				((FactorContext)_localctx).e1 = term();
				setState(41);
				match(TIMES);
				setState(42);
				((FactorContext)_localctx).e2 = expr();

				    RANode node = new RANode();
				    node.setLchild(((FactorContext)_localctx).e1.value);
				    node.setRchild(((FactorContext)_localctx).e2.value);
				    node.setRnodetype("times");
				    ((FactorContext)_localctx).value =  node;
				  
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				((FactorContext)_localctx).e1 = term();
				setState(46);
				match(JOIN);
				setState(47);
				((FactorContext)_localctx).e2 = expr();

				    RANode node = new RANode();
				    node.setLchild(((FactorContext)_localctx).e1.value);
				    node.setRchild(((FactorContext)_localctx).e2.value);
				    node.setRnodetype("join");
				    ((FactorContext)_localctx).value =  node;
				  
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				((FactorContext)_localctx).e1 = term();

				    ((FactorContext)_localctx).value =  ((FactorContext)_localctx).e1.value;
				  
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public RANode value;
		public Token n;
		public AlistContext as;
		public ExprContext e1;
		public ConditionContext c;
		public ExprContext e;
		public TerminalNode NAME() { return getToken(RAParser.NAME, 0); }
		public TerminalNode PROJECT() { return getToken(RAParser.PROJECT, 0); }
		public TerminalNode LBRACKET() { return getToken(RAParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(RAParser.RBRACKET, 0); }
		public TerminalNode LPAREN() { return getToken(RAParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(RAParser.RPAREN, 0); }
		public AlistContext alist() {
			return getRuleContext(AlistContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RENAME() { return getToken(RAParser.RENAME, 0); }
		public TerminalNode SELECT() { return getToken(RAParser.SELECT, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RAListener ) ((RAListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RAListener ) ((RAListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_term);
		try {
			setState(89);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				((TermContext)_localctx).n = match(NAME);

				    RANode node = new RANode();
				    node.setLchild(null);
				    node.setRchild(null);
				    node.setRnodetype("relation");
				    node.setRelationName((((TermContext)_localctx).n!=null?((TermContext)_localctx).n.getText():null).toUpperCase());
				    ((TermContext)_localctx).value =  node;
				  
				}
				break;
			case PROJECT:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				match(PROJECT);
				setState(58);
				match(LBRACKET);
				setState(59);
				((TermContext)_localctx).as = alist(0);
				setState(60);
				match(RBRACKET);
				setState(61);
				match(LPAREN);
				setState(62);
				((TermContext)_localctx).e1 = expr();
				setState(63);
				match(RPAREN);

				    RANode node = new RANode();
				    node.setLchild(((TermContext)_localctx).e1.value);
				    node.setRnodetype("project");
				    node.setAttributes(((TermContext)_localctx).as.value);
				    ((TermContext)_localctx).value =  node;
				  
				}
				break;
			case RENAME:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				match(RENAME);
				setState(67);
				match(LBRACKET);
				setState(68);
				((TermContext)_localctx).as = alist(0);
				setState(69);
				match(RBRACKET);
				setState(70);
				match(LPAREN);
				setState(71);
				((TermContext)_localctx).e1 = expr();
				setState(72);
				match(RPAREN);

				    RANode node = new RANode();
				    node.setLchild(((TermContext)_localctx).e1.value);
				    node.setRnodetype("rename");
				    node.setAttributes(((TermContext)_localctx).as.value);
				    ((TermContext)_localctx).value =  node;
				  
				}
				break;
			case SELECT:
				enterOuterAlt(_localctx, 4);
				{
				setState(75);
				match(SELECT);
				setState(76);
				match(LBRACKET);
				setState(77);
				((TermContext)_localctx).c = condition(0);
				setState(78);
				match(RBRACKET);
				setState(79);
				match(LPAREN);
				setState(80);
				((TermContext)_localctx).e1 = expr();
				setState(81);
				match(RPAREN);

				    RANode node = new RANode();
				    node.setLchild(((TermContext)_localctx).e1.value);
				    node.setRnodetype("select");
				    node.setConditions(((TermContext)_localctx).c.value);
				    ((TermContext)_localctx).value =  node;
				  
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 5);
				{
				setState(84);
				match(LPAREN);
				setState(85);
				((TermContext)_localctx).e = expr();
				setState(86);
				match(RPAREN);

				    ((TermContext)_localctx).value =  ((TermContext)_localctx).e.value;
				  
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlistContext extends ParserRuleContext {
		public ArrayList<String> value;
		public AlistContext as;
		public Token n;
		public TerminalNode NAME() { return getToken(RAParser.NAME, 0); }
		public TerminalNode COMMA() { return getToken(RAParser.COMMA, 0); }
		public AlistContext alist() {
			return getRuleContext(AlistContext.class,0);
		}
		public AlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RAListener ) ((RAListener)listener).enterAlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RAListener ) ((RAListener)listener).exitAlist(this);
		}
	}

	public final AlistContext alist() throws RecognitionException {
		return alist(0);
	}

	private AlistContext alist(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AlistContext _localctx = new AlistContext(_ctx, _parentState);
		AlistContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_alist, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(92);
			((AlistContext)_localctx).n = match(NAME);

			    ArrayList<String> a = new ArrayList<String>();
			    a.add((((AlistContext)_localctx).n!=null?((AlistContext)_localctx).n.getText():null).toUpperCase());
			    ((AlistContext)_localctx).value =  a;
			  
			}
			_ctx.stop = _input.LT(-1);
			setState(101);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AlistContext(_parentctx, _parentState);
					_localctx.as = _prevctx;
					_localctx.as = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_alist);
					setState(95);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(96);
					match(COMMA);
					setState(97);
					((AlistContext)_localctx).n = match(NAME);

					              ((AlistContext)_localctx).as.value.add((((AlistContext)_localctx).n!=null?((AlistContext)_localctx).n.getText():null).toUpperCase());
					              ((AlistContext)_localctx).value =  ((AlistContext)_localctx).as.value;
					            
					}
					} 
				}
				setState(103);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public ArrayList<Condition> value;
		public ConditionContext c;
		public SimpleconditionContext sc;
		public SimpleconditionContext simplecondition() {
			return getRuleContext(SimpleconditionContext.class,0);
		}
		public TerminalNode AND() { return getToken(RAParser.AND, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RAListener ) ((RAListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RAListener ) ((RAListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		return condition(0);
	}

	private ConditionContext condition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionContext _localctx = new ConditionContext(_ctx, _parentState);
		ConditionContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_condition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(105);
			((ConditionContext)_localctx).sc = simplecondition();

			    ArrayList<Condition> a = new ArrayList<Condition>();
			    a.add(((ConditionContext)_localctx).sc.value);
			    ((ConditionContext)_localctx).value =  a;
			  
			}
			_ctx.stop = _input.LT(-1);
			setState(115);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConditionContext(_parentctx, _parentState);
					_localctx.c = _prevctx;
					_localctx.c = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_condition);
					setState(108);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(109);
					match(AND);
					setState(110);
					((ConditionContext)_localctx).sc = simplecondition();

					              ((ConditionContext)_localctx).c.value.add(((ConditionContext)_localctx).sc.value);
					              ((ConditionContext)_localctx).value =  ((ConditionContext)_localctx).c.value;
					            
					}
					} 
				}
				setState(117);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class SimpleconditionContext extends ParserRuleContext {
		public Condition value;
		public OperandContext o1;
		public Token c;
		public OperandContext o2;
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public TerminalNode COMPARISON() { return getToken(RAParser.COMPARISON, 0); }
		public SimpleconditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simplecondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RAListener ) ((RAListener)listener).enterSimplecondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RAListener ) ((RAListener)listener).exitSimplecondition(this);
		}
	}

	public final SimpleconditionContext simplecondition() throws RecognitionException {
		SimpleconditionContext _localctx = new SimpleconditionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_simplecondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			((SimpleconditionContext)_localctx).o1 = operand();
			setState(119);
			((SimpleconditionContext)_localctx).c = match(COMPARISON);
			setState(120);
			((SimpleconditionContext)_localctx).o2 = operand();

			    ((SimpleconditionContext)_localctx).value =  new Condition(((SimpleconditionContext)_localctx).o1.value.substring(3),((SimpleconditionContext)_localctx).o1.value.substring(0,3),
			                           (((SimpleconditionContext)_localctx).c!=null?((SimpleconditionContext)_localctx).c.getText():null),
			                           ((SimpleconditionContext)_localctx).o2.value.substring(3),((SimpleconditionContext)_localctx).o2.value.substring(0,3));
			  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperandContext extends ParserRuleContext {
		public String value;
		public Token n;
		public Token s;
		public Token num;
		public TerminalNode NAME() { return getToken(RAParser.NAME, 0); }
		public TerminalNode STRING() { return getToken(RAParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(RAParser.NUMBER, 0); }
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RAListener ) ((RAListener)listener).enterOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RAListener ) ((RAListener)listener).exitOperand(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_operand);
		try {
			setState(129);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				((OperandContext)_localctx).n = match(NAME);

				    ((OperandContext)_localctx).value =  "col"+(((OperandContext)_localctx).n!=null?((OperandContext)_localctx).n.getText():null).toUpperCase();
				  
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				((OperandContext)_localctx).s = match(STRING);

				    ((OperandContext)_localctx).value =  "str"+(((OperandContext)_localctx).s!=null?((OperandContext)_localctx).s.getText():null).substring(1,(((OperandContext)_localctx).s!=null?((OperandContext)_localctx).s.getText():null).length()-1);
				  
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 3);
				{
				setState(127);
				((OperandContext)_localctx).num = match(NUMBER);

				    ((OperandContext)_localctx).value =  "num"+(((OperandContext)_localctx).num!=null?((OperandContext)_localctx).num.getText():null);
				  
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return alist_sempred((AlistContext)_localctx, predIndex);
		case 5:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean alist_sempred(AlistContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26\u0086\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\5\3)\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4"+
		"8\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\5\5\\\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6f\n\6\f\6\16\6i\13\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7t\n\7\f\7\16\7w\13\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0084\n\t\3\t\2\4\n\f\n\2\4\6\b\n"+
		"\f\16\20\2\2\2\u008a\2\22\3\2\2\2\4(\3\2\2\2\6\67\3\2\2\2\b[\3\2\2\2\n"+
		"]\3\2\2\2\fj\3\2\2\2\16x\3\2\2\2\20\u0083\3\2\2\2\22\23\5\4\3\2\23\24"+
		"\7\7\2\2\24\25\b\2\1\2\25\3\3\2\2\2\26\27\5\6\4\2\27\30\7\t\2\2\30\31"+
		"\5\4\3\2\31\32\b\3\1\2\32)\3\2\2\2\33\34\5\6\4\2\34\35\7\n\2\2\35\36\5"+
		"\4\3\2\36\37\b\3\1\2\37)\3\2\2\2 !\5\6\4\2!\"\7\13\2\2\"#\5\4\3\2#$\b"+
		"\3\1\2$)\3\2\2\2%&\5\6\4\2&\'\b\3\1\2\')\3\2\2\2(\26\3\2\2\2(\33\3\2\2"+
		"\2( \3\2\2\2(%\3\2\2\2)\5\3\2\2\2*+\5\b\5\2+,\7\f\2\2,-\5\4\3\2-.\b\4"+
		"\1\2.8\3\2\2\2/\60\5\b\5\2\60\61\7\r\2\2\61\62\5\4\3\2\62\63\b\4\1\2\63"+
		"8\3\2\2\2\64\65\5\b\5\2\65\66\b\4\1\2\668\3\2\2\2\67*\3\2\2\2\67/\3\2"+
		"\2\2\67\64\3\2\2\28\7\3\2\2\29:\7\25\2\2:\\\b\5\1\2;<\7\16\2\2<=\7\3\2"+
		"\2=>\5\n\6\2>?\7\4\2\2?@\7\5\2\2@A\5\4\3\2AB\7\6\2\2BC\b\5\1\2C\\\3\2"+
		"\2\2DE\7\20\2\2EF\7\3\2\2FG\5\n\6\2GH\7\4\2\2HI\7\5\2\2IJ\5\4\3\2JK\7"+
		"\6\2\2KL\b\5\1\2L\\\3\2\2\2MN\7\17\2\2NO\7\3\2\2OP\5\f\7\2PQ\7\4\2\2Q"+
		"R\7\5\2\2RS\5\4\3\2ST\7\6\2\2TU\b\5\1\2U\\\3\2\2\2VW\7\5\2\2WX\5\4\3\2"+
		"XY\7\6\2\2YZ\b\5\1\2Z\\\3\2\2\2[9\3\2\2\2[;\3\2\2\2[D\3\2\2\2[M\3\2\2"+
		"\2[V\3\2\2\2\\\t\3\2\2\2]^\b\6\1\2^_\7\25\2\2_`\b\6\1\2`g\3\2\2\2ab\f"+
		"\3\2\2bc\7\b\2\2cd\7\25\2\2df\b\6\1\2ea\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh"+
		"\3\2\2\2h\13\3\2\2\2ig\3\2\2\2jk\b\7\1\2kl\5\16\b\2lm\b\7\1\2mu\3\2\2"+
		"\2no\f\3\2\2op\7\21\2\2pq\5\16\b\2qr\b\7\1\2rt\3\2\2\2sn\3\2\2\2tw\3\2"+
		"\2\2us\3\2\2\2uv\3\2\2\2v\r\3\2\2\2wu\3\2\2\2xy\5\20\t\2yz\7\24\2\2z{"+
		"\5\20\t\2{|\b\b\1\2|\17\3\2\2\2}~\7\25\2\2~\u0084\b\t\1\2\177\u0080\7"+
		"\23\2\2\u0080\u0084\b\t\1\2\u0081\u0082\7\22\2\2\u0082\u0084\b\t\1\2\u0083"+
		"}\3\2\2\2\u0083\177\3\2\2\2\u0083\u0081\3\2\2\2\u0084\21\3\2\2\2\b(\67"+
		"[gu\u0083";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}