package org.eclipse.january.geometry.dsl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalIGESLexer extends Lexer {
    public static final int RULE_HOLLERITH=10;
    public static final int RULE_ENDLINE=7;
    public static final int RULE_WS=5;
    public static final int RULE_STRING=9;
    public static final int RULE_SEPARATOR=8;
    public static final int RULE_DELIMITER=4;
    public static final int T__15=15;
    public static final int RULE_DOUBLE=11;
    public static final int T__16=16;
    public static final int RULE_INT=6;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators

    public InternalIGESLexer() {;} 
    public InternalIGESLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalIGESLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalIGES.g"; }

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalIGES.g:11:7: ( 'G' )
            // InternalIGES.g:11:9: 'G'
            {
            match('G'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalIGES.g:12:7: ( 'D' )
            // InternalIGES.g:12:9: 'D'
            {
            match('D'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalIGES.g:13:7: ( 'P' )
            // InternalIGES.g:13:9: 'P'
            {
            match('P'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalIGES.g:14:7: ( 'S' )
            // InternalIGES.g:14:9: 'S'
            {
            match('S'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalIGES.g:15:7: ( 'T' )
            // InternalIGES.g:15:9: 'T'
            {
            match('T'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalIGES.g:1586:10: ( ( '0' .. '9' )+ )
            // InternalIGES.g:1586:12: ( '0' .. '9' )+
            {
            // InternalIGES.g:1586:12: ( '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalIGES.g:1586:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_DOUBLE"
    public final void mRULE_DOUBLE() throws RecognitionException {
        try {
            int _type = RULE_DOUBLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalIGES.g:1588:13: ( ( '+' | '-' )? RULE_INT '.' ( RULE_INT )? ( ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT )? )
            // InternalIGES.g:1588:15: ( '+' | '-' )? RULE_INT '.' ( RULE_INT )? ( ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT )?
            {
            // InternalIGES.g:1588:15: ( '+' | '-' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='+'||LA2_0=='-') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalIGES.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            mRULE_INT(); 
            match('.'); 
            // InternalIGES.g:1588:39: ( RULE_INT )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalIGES.g:1588:39: RULE_INT
                    {
                    mRULE_INT(); 

                    }
                    break;

            }

            // InternalIGES.g:1588:49: ( ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='E'||LA5_0=='e') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalIGES.g:1588:50: ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT
                    {
                    if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // InternalIGES.g:1588:60: ( '+' | '-' )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0=='+'||LA4_0=='-') ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // InternalIGES.g:
                            {
                            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}


                            }
                            break;

                    }

                    mRULE_INT(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DOUBLE"

    // $ANTLR start "RULE_HOLLERITH"
    public final void mRULE_HOLLERITH() throws RecognitionException {
        try {
            int _type = RULE_HOLLERITH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalIGES.g:1590:16: ( RULE_INT 'H' . )
            // InternalIGES.g:1590:18: RULE_INT 'H' .
            {
            mRULE_INT(); 
            match('H'); 
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_HOLLERITH"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalIGES.g:1592:13: ( ( 'A..Z' | 'a' .. 'z' | '0' .. '9' | '\"' )+ )
            // InternalIGES.g:1592:15: ( 'A..Z' | 'a' .. 'z' | '0' .. '9' | '\"' )+
            {
            // InternalIGES.g:1592:15: ( 'A..Z' | 'a' .. 'z' | '0' .. '9' | '\"' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=5;
                switch ( input.LA(1) ) {
                case 'A':
                    {
                    alt6=1;
                    }
                    break;
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt6=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    {
                    alt6=3;
                    }
                    break;
                case '\"':
                    {
                    alt6=4;
                    }
                    break;

                }

                switch (alt6) {
            	case 1 :
            	    // InternalIGES.g:1592:16: 'A..Z'
            	    {
            	    match("A..Z"); 


            	    }
            	    break;
            	case 2 :
            	    // InternalIGES.g:1592:23: 'a' .. 'z'
            	    {
            	    matchRange('a','z'); 

            	    }
            	    break;
            	case 3 :
            	    // InternalIGES.g:1592:32: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;
            	case 4 :
            	    // InternalIGES.g:1592:41: '\"'
            	    {
            	    match('\"'); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalIGES.g:1594:9: ( ( ' ' | '\\t' | '\\r' )+ )
            // InternalIGES.g:1594:11: ( ' ' | '\\t' | '\\r' )+
            {
            // InternalIGES.g:1594:11: ( ' ' | '\\t' | '\\r' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\t'||LA7_0=='\r'||LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalIGES.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ENDLINE"
    public final void mRULE_ENDLINE() throws RecognitionException {
        try {
            int _type = RULE_ENDLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalIGES.g:1596:14: ( ( '\\r' )? '\\n' )
            // InternalIGES.g:1596:16: ( '\\r' )? '\\n'
            {
            // InternalIGES.g:1596:16: ( '\\r' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\r') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalIGES.g:1596:16: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ENDLINE"

    // $ANTLR start "RULE_DELIMITER"
    public final void mRULE_DELIMITER() throws RecognitionException {
        try {
            int _type = RULE_DELIMITER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalIGES.g:1598:16: ( . )
            // InternalIGES.g:1598:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DELIMITER"

    // $ANTLR start "RULE_SEPARATOR"
    public final void mRULE_SEPARATOR() throws RecognitionException {
        try {
            int _type = RULE_SEPARATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalIGES.g:1600:16: ( . )
            // InternalIGES.g:1600:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SEPARATOR"

    public void mTokens() throws RecognitionException {
        // InternalIGES.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | RULE_INT | RULE_DOUBLE | RULE_HOLLERITH | RULE_STRING | RULE_WS | RULE_ENDLINE | RULE_DELIMITER | RULE_SEPARATOR )
        int alt9=13;
        alt9 = dfa9.predict(input);
        switch (alt9) {
            case 1 :
                // InternalIGES.g:1:10: T__12
                {
                mT__12(); 

                }
                break;
            case 2 :
                // InternalIGES.g:1:16: T__13
                {
                mT__13(); 

                }
                break;
            case 3 :
                // InternalIGES.g:1:22: T__14
                {
                mT__14(); 

                }
                break;
            case 4 :
                // InternalIGES.g:1:28: T__15
                {
                mT__15(); 

                }
                break;
            case 5 :
                // InternalIGES.g:1:34: T__16
                {
                mT__16(); 

                }
                break;
            case 6 :
                // InternalIGES.g:1:40: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 7 :
                // InternalIGES.g:1:49: RULE_DOUBLE
                {
                mRULE_DOUBLE(); 

                }
                break;
            case 8 :
                // InternalIGES.g:1:61: RULE_HOLLERITH
                {
                mRULE_HOLLERITH(); 

                }
                break;
            case 9 :
                // InternalIGES.g:1:76: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 10 :
                // InternalIGES.g:1:88: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 11 :
                // InternalIGES.g:1:96: RULE_ENDLINE
                {
                mRULE_ENDLINE(); 

                }
                break;
            case 12 :
                // InternalIGES.g:1:109: RULE_DELIMITER
                {
                mRULE_DELIMITER(); 

                }
                break;
            case 13 :
                // InternalIGES.g:1:124: RULE_SEPARATOR
                {
                mRULE_SEPARATOR(); 

                }
                break;

        }

    }


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\6\uffff\1\24\2\31\2\uffff\1\32\11\uffff\1\24\6\uffff";
    static final String DFA9_eofS =
        "\34\uffff";
    static final String DFA9_minS =
        "\1\0\5\uffff\1\42\1\60\1\56\2\uffff\1\12\11\uffff\1\42\6\uffff";
    static final String DFA9_maxS =
        "\1\uffff\5\uffff\1\172\1\71\1\56\2\uffff\1\12\11\uffff\1\172\6\uffff";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\3\uffff\2\11\1\uffff\1\12\1\13\1\14\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\10\1\7\1\11\1\14\1\12\1\13";
    static final String DFA9_specialS =
        "\1\0\33\uffff}>";
    static final String[] DFA9_transitionS = {
            "\11\16\1\14\1\15\2\16\1\13\22\16\1\14\1\16\1\12\10\16\1\7\1\16\1\7\2\16\12\6\7\16\1\10\2\16\1\2\2\16\1\1\10\16\1\3\2\16\1\4\1\5\14\16\32\11\uff85\16",
            "",
            "",
            "",
            "",
            "",
            "\1\30\13\uffff\1\27\1\uffff\12\25\7\uffff\1\30\6\uffff\1\26\30\uffff\32\30",
            "\12\27",
            "\1\30",
            "",
            "",
            "\1\33",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\30\13\uffff\1\27\1\uffff\12\25\7\uffff\1\30\6\uffff\1\26\30\uffff\32\30",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__12 | T__13 | T__14 | T__15 | T__16 | RULE_INT | RULE_DOUBLE | RULE_HOLLERITH | RULE_STRING | RULE_WS | RULE_ENDLINE | RULE_DELIMITER | RULE_SEPARATOR );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA9_0 = input.LA(1);

                        s = -1;
                        if ( (LA9_0=='G') ) {s = 1;}

                        else if ( (LA9_0=='D') ) {s = 2;}

                        else if ( (LA9_0=='P') ) {s = 3;}

                        else if ( (LA9_0=='S') ) {s = 4;}

                        else if ( (LA9_0=='T') ) {s = 5;}

                        else if ( ((LA9_0>='0' && LA9_0<='9')) ) {s = 6;}

                        else if ( (LA9_0=='+'||LA9_0=='-') ) {s = 7;}

                        else if ( (LA9_0=='A') ) {s = 8;}

                        else if ( ((LA9_0>='a' && LA9_0<='z')) ) {s = 9;}

                        else if ( (LA9_0=='\"') ) {s = 10;}

                        else if ( (LA9_0=='\r') ) {s = 11;}

                        else if ( (LA9_0=='\t'||LA9_0==' ') ) {s = 12;}

                        else if ( (LA9_0=='\n') ) {s = 13;}

                        else if ( ((LA9_0>='\u0000' && LA9_0<='\b')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\u001F')||LA9_0=='!'||(LA9_0>='#' && LA9_0<='*')||LA9_0==','||(LA9_0>='.' && LA9_0<='/')||(LA9_0>=':' && LA9_0<='@')||(LA9_0>='B' && LA9_0<='C')||(LA9_0>='E' && LA9_0<='F')||(LA9_0>='H' && LA9_0<='O')||(LA9_0>='Q' && LA9_0<='R')||(LA9_0>='U' && LA9_0<='`')||(LA9_0>='{' && LA9_0<='\uFFFF')) ) {s = 14;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 9, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}