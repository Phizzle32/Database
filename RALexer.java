// Generated from RA.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RALexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LBRACKET=1, RBRACKET=2, LPAREN=3, RPAREN=4, SEMI=5, COMMA=6, UNION=7, 
		MINUS=8, INTERSECT=9, TIMES=10, JOIN=11, PROJECT=12, SELECT=13, RENAME=14, 
		AND=15, NUMBER=16, STRING=17, COMPARISON=18, NAME=19, WS=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"VALID_NAME_START", "VALID_NAME_CHAR", "LBRACKET", "RBRACKET", "LPAREN", 
			"RPAREN", "SEMI", "COMMA", "UNION", "MINUS", "INTERSECT", "TIMES", "JOIN", 
			"PROJECT", "SELECT", "RENAME", "AND", "NUMBER", "STRING", "COMPARISON", 
			"NAME", "WS"
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


	public RALexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RA.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u00ef\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\5\2\61\n\2"+
		"\3\3\3\3\5\3\65\n\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nM\n\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\5\13Y\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\fm\n\f\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\5\ry\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\5\16\u0083\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\5\17\u0093\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\5\20\u00a1\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\5\21\u00af\n\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\5\22\u00b7\n\22\3\23\6\23\u00ba\n\23\r\23\16\23\u00bb\3\23\7\23\u00bf"+
		"\n\23\f\23\16\23\u00c2\13\23\3\23\3\23\6\23\u00c6\n\23\r\23\16\23\u00c7"+
		"\5\23\u00ca\n\23\3\24\3\24\3\24\3\24\7\24\u00d0\n\24\f\24\16\24\u00d3"+
		"\13\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00e0"+
		"\n\25\3\26\3\26\7\26\u00e4\n\26\f\26\16\26\u00e7\13\26\3\27\6\27\u00ea"+
		"\n\27\r\27\16\27\u00eb\3\27\3\27\2\2\30\3\2\5\2\7\3\t\4\13\5\r\6\17\7"+
		"\21\b\23\t\25\n\27\13\31\f\33\r\35\16\37\17!\20#\21%\22\'\23)\24+\25-"+
		"\26\3\2\6\4\2C\\c|\4\2\62;aa\5\2\f\f\17\17))\5\2\13\f\17\17\"\"\2\u0103"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\3\60\3\2\2\2\5\64\3\2\2\2\7\66\3"+
		"\2\2\2\t8\3\2\2\2\13:\3\2\2\2\r<\3\2\2\2\17>\3\2\2\2\21@\3\2\2\2\23L\3"+
		"\2\2\2\25X\3\2\2\2\27l\3\2\2\2\31x\3\2\2\2\33\u0082\3\2\2\2\35\u0092\3"+
		"\2\2\2\37\u00a0\3\2\2\2!\u00ae\3\2\2\2#\u00b6\3\2\2\2%\u00c9\3\2\2\2\'"+
		"\u00cb\3\2\2\2)\u00df\3\2\2\2+\u00e1\3\2\2\2-\u00e9\3\2\2\2/\61\t\2\2"+
		"\2\60/\3\2\2\2\61\4\3\2\2\2\62\65\5\3\2\2\63\65\t\3\2\2\64\62\3\2\2\2"+
		"\64\63\3\2\2\2\65\6\3\2\2\2\66\67\7]\2\2\67\b\3\2\2\289\7_\2\29\n\3\2"+
		"\2\2:;\7*\2\2;\f\3\2\2\2<=\7+\2\2=\16\3\2\2\2>?\7=\2\2?\20\3\2\2\2@A\7"+
		".\2\2A\22\3\2\2\2BC\7W\2\2CD\7P\2\2DE\7K\2\2EF\7Q\2\2FM\7P\2\2GH\7w\2"+
		"\2HI\7p\2\2IJ\7k\2\2JK\7q\2\2KM\7p\2\2LB\3\2\2\2LG\3\2\2\2M\24\3\2\2\2"+
		"NO\7O\2\2OP\7K\2\2PQ\7P\2\2QR\7W\2\2RY\7U\2\2ST\7o\2\2TU\7k\2\2UV\7p\2"+
		"\2VW\7w\2\2WY\7u\2\2XN\3\2\2\2XS\3\2\2\2Y\26\3\2\2\2Z[\7K\2\2[\\\7P\2"+
		"\2\\]\7V\2\2]^\7G\2\2^_\7T\2\2_`\7U\2\2`a\7G\2\2ab\7E\2\2bm\7V\2\2cd\7"+
		"k\2\2de\7p\2\2ef\7v\2\2fg\7g\2\2gh\7t\2\2hi\7u\2\2ij\7g\2\2jk\7e\2\2k"+
		"m\7v\2\2lZ\3\2\2\2lc\3\2\2\2m\30\3\2\2\2no\7V\2\2op\7K\2\2pq\7O\2\2qr"+
		"\7G\2\2ry\7U\2\2st\7v\2\2tu\7k\2\2uv\7o\2\2vw\7g\2\2wy\7u\2\2xn\3\2\2"+
		"\2xs\3\2\2\2y\32\3\2\2\2z{\7L\2\2{|\7Q\2\2|}\7K\2\2}\u0083\7P\2\2~\177"+
		"\7l\2\2\177\u0080\7q\2\2\u0080\u0081\7k\2\2\u0081\u0083\7p\2\2\u0082z"+
		"\3\2\2\2\u0082~\3\2\2\2\u0083\34\3\2\2\2\u0084\u0085\7R\2\2\u0085\u0086"+
		"\7T\2\2\u0086\u0087\7Q\2\2\u0087\u0088\7L\2\2\u0088\u0089\7G\2\2\u0089"+
		"\u008a\7E\2\2\u008a\u0093\7V\2\2\u008b\u008c\7r\2\2\u008c\u008d\7t\2\2"+
		"\u008d\u008e\7q\2\2\u008e\u008f\7l\2\2\u008f\u0090\7g\2\2\u0090\u0091"+
		"\7e\2\2\u0091\u0093\7v\2\2\u0092\u0084\3\2\2\2\u0092\u008b\3\2\2\2\u0093"+
		"\36\3\2\2\2\u0094\u0095\7U\2\2\u0095\u0096\7G\2\2\u0096\u0097\7N\2\2\u0097"+
		"\u0098\7G\2\2\u0098\u0099\7E\2\2\u0099\u00a1\7V\2\2\u009a\u009b\7u\2\2"+
		"\u009b\u009c\7g\2\2\u009c\u009d\7n\2\2\u009d\u009e\7g\2\2\u009e\u009f"+
		"\7e\2\2\u009f\u00a1\7v\2\2\u00a0\u0094\3\2\2\2\u00a0\u009a\3\2\2\2\u00a1"+
		" \3\2\2\2\u00a2\u00a3\7T\2\2\u00a3\u00a4\7G\2\2\u00a4\u00a5\7P\2\2\u00a5"+
		"\u00a6\7C\2\2\u00a6\u00a7\7O\2\2\u00a7\u00af\7G\2\2\u00a8\u00a9\7t\2\2"+
		"\u00a9\u00aa\7g\2\2\u00aa\u00ab\7p\2\2\u00ab\u00ac\7c\2\2\u00ac\u00ad"+
		"\7o\2\2\u00ad\u00af\7g\2\2\u00ae\u00a2\3\2\2\2\u00ae\u00a8\3\2\2\2\u00af"+
		"\"\3\2\2\2\u00b0\u00b1\7C\2\2\u00b1\u00b2\7P\2\2\u00b2\u00b7\7F\2\2\u00b3"+
		"\u00b4\7c\2\2\u00b4\u00b5\7p\2\2\u00b5\u00b7\7f\2\2\u00b6\u00b0\3\2\2"+
		"\2\u00b6\u00b3\3\2\2\2\u00b7$\3\2\2\2\u00b8\u00ba\4\62;\2\u00b9\u00b8"+
		"\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc"+
		"\u00ca\3\2\2\2\u00bd\u00bf\4\62;\2\u00be\u00bd\3\2\2\2\u00bf\u00c2\3\2"+
		"\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c3\3\2\2\2\u00c2"+
		"\u00c0\3\2\2\2\u00c3\u00c5\7\60\2\2\u00c4\u00c6\4\62;\2\u00c5\u00c4\3"+
		"\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8"+
		"\u00ca\3\2\2\2\u00c9\u00b9\3\2\2\2\u00c9\u00c0\3\2\2\2\u00ca&\3\2\2\2"+
		"\u00cb\u00d1\7)\2\2\u00cc\u00d0\n\4\2\2\u00cd\u00ce\7)\2\2\u00ce\u00d0"+
		"\7)\2\2\u00cf\u00cc\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1"+
		"\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d4\3\2\2\2\u00d3\u00d1\3\2"+
		"\2\2\u00d4\u00d5\7)\2\2\u00d5(\3\2\2\2\u00d6\u00e0\7>\2\2\u00d7\u00d8"+
		"\7>\2\2\u00d8\u00e0\7?\2\2\u00d9\u00e0\7@\2\2\u00da\u00db\7@\2\2\u00db"+
		"\u00e0\7?\2\2\u00dc\u00e0\7?\2\2\u00dd\u00de\7>\2\2\u00de\u00e0\7@\2\2"+
		"\u00df\u00d6\3\2\2\2\u00df\u00d7\3\2\2\2\u00df\u00d9\3\2\2\2\u00df\u00da"+
		"\3\2\2\2\u00df\u00dc\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0*\3\2\2\2\u00e1"+
		"\u00e5\5\3\2\2\u00e2\u00e4\5\5\3\2\u00e3\u00e2\3\2\2\2\u00e4\u00e7\3\2"+
		"\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6,\3\2\2\2\u00e7\u00e5"+
		"\3\2\2\2\u00e8\u00ea\t\5\2\2\u00e9\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb"+
		"\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\b\27"+
		"\2\2\u00ee.\3\2\2\2\27\2\60\64LXlx\u0082\u0092\u00a0\u00ae\u00b6\u00bb"+
		"\u00c0\u00c7\u00c9\u00cf\u00d1\u00df\u00e5\u00eb\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}