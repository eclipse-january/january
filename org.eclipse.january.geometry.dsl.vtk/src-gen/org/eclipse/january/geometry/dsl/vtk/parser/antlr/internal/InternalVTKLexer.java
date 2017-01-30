package org.eclipse.january.geometry.dsl.vtk.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalVTKLexer extends Lexer {
    public static final int RULE_ENDLINE=4;
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int RULE_DOUBLE=6;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=8;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_INT=5;
    public static final int RULE_ML_COMMENT=11;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators

    public InternalVTKLexer() {;} 
    public InternalVTKLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalVTKLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalVTK.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVTK.g:11:7: ( 'POLYGONS' )
            // InternalVTK.g:11:9: 'POLYGONS'
            {
            match("POLYGONS"); 


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
            // InternalVTK.g:12:7: ( 'TRIANGLE_STRIPS' )
            // InternalVTK.g:12:9: 'TRIANGLE_STRIPS'
            {
            match("TRIANGLE_STRIPS"); 


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
            // InternalVTK.g:13:7: ( 'POINTS' )
            // InternalVTK.g:13:9: 'POINTS'
            {
            match("POINTS"); 


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
            // InternalVTK.g:14:7: ( '-' )
            // InternalVTK.g:14:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVTK.g:15:7: ( '.' )
            // InternalVTK.g:15:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVTK.g:16:7: ( '/' )
            // InternalVTK.g:16:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVTK.g:17:7: ( '\\\\' )
            // InternalVTK.g:17:9: '\\\\'
            {
            match('\\'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVTK.g:18:7: ( ':' )
            // InternalVTK.g:18:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVTK.g:19:7: ( '_' )
            // InternalVTK.g:19:9: '_'
            {
            match('_'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "RULE_DOUBLE"
    public final void mRULE_DOUBLE() throws RecognitionException {
        try {
            int _type = RULE_DOUBLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVTK.g:678:13: ( ( '-' | '+' )? ( RULE_INT )? '.' RULE_INT ( ( 'E' | 'e' ) ( '-' | '+' )? RULE_INT )? )
            // InternalVTK.g:678:15: ( '-' | '+' )? ( RULE_INT )? '.' RULE_INT ( ( 'E' | 'e' ) ( '-' | '+' )? RULE_INT )?
            {
            // InternalVTK.g:678:15: ( '-' | '+' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='+'||LA1_0=='-') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalVTK.g:
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

            // InternalVTK.g:678:26: ( RULE_INT )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalVTK.g:678:26: RULE_INT
                    {
                    mRULE_INT(); 

                    }
                    break;

            }

            match('.'); 
            mRULE_INT(); 
            // InternalVTK.g:678:49: ( ( 'E' | 'e' ) ( '-' | '+' )? RULE_INT )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='E'||LA4_0=='e') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalVTK.g:678:50: ( 'E' | 'e' ) ( '-' | '+' )? RULE_INT
                    {
                    if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // InternalVTK.g:678:60: ( '-' | '+' )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='+'||LA3_0=='-') ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // InternalVTK.g:
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

    // $ANTLR start "RULE_ENDLINE"
    public final void mRULE_ENDLINE() throws RecognitionException {
        try {
            int _type = RULE_ENDLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVTK.g:680:14: ( ( ( '\\r' )? '\\n' | '\\r' ) )
            // InternalVTK.g:680:16: ( ( '\\r' )? '\\n' | '\\r' )
            {
            // InternalVTK.g:680:16: ( ( '\\r' )? '\\n' | '\\r' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\r') ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1=='\n') ) {
                    alt6=1;
                }
                else {
                    alt6=2;}
            }
            else if ( (LA6_0=='\n') ) {
                alt6=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalVTK.g:680:17: ( '\\r' )? '\\n'
                    {
                    // InternalVTK.g:680:17: ( '\\r' )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0=='\r') ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // InternalVTK.g:680:17: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;
                case 2 :
                    // InternalVTK.g:680:28: '\\r'
                    {
                    match('\r'); 

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
    // $ANTLR end "RULE_ENDLINE"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVTK.g:682:17: ( '#' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalVTK.g:682:19: '#' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match('#'); 
            // InternalVTK.g:682:23: (~ ( ( '\\n' | '\\r' ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\u0000' && LA7_0<='\t')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalVTK.g:682:23: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // InternalVTK.g:682:39: ( ( '\\r' )? '\\n' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\n'||LA9_0=='\r') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalVTK.g:682:40: ( '\\r' )? '\\n'
                    {
                    // InternalVTK.g:682:40: ( '\\r' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='\r') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // InternalVTK.g:682:40: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

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
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVTK.g:684:9: ( ( ' ' | '\\t' | 'ASCII' | 'DATASET POLYDATA' )+ )
            // InternalVTK.g:684:11: ( ' ' | '\\t' | 'ASCII' | 'DATASET POLYDATA' )+
            {
            // InternalVTK.g:684:11: ( ' ' | '\\t' | 'ASCII' | 'DATASET POLYDATA' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=5;
                switch ( input.LA(1) ) {
                case ' ':
                    {
                    alt10=1;
                    }
                    break;
                case '\t':
                    {
                    alt10=2;
                    }
                    break;
                case 'A':
                    {
                    alt10=3;
                    }
                    break;
                case 'D':
                    {
                    alt10=4;
                    }
                    break;

                }

                switch (alt10) {
            	case 1 :
            	    // InternalVTK.g:684:12: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;
            	case 2 :
            	    // InternalVTK.g:684:16: '\\t'
            	    {
            	    match('\t'); 

            	    }
            	    break;
            	case 3 :
            	    // InternalVTK.g:684:21: 'ASCII'
            	    {
            	    match("ASCII"); 


            	    }
            	    break;
            	case 4 :
            	    // InternalVTK.g:684:29: 'DATASET POLYDATA'
            	    {
            	    match("DATASET POLYDATA"); 


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVTK.g:686:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalVTK.g:686:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalVTK.g:686:11: ( '^' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='^') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalVTK.g:686:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalVTK.g:686:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='0' && LA12_0<='9')||(LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='z')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalVTK.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVTK.g:688:10: ( ( '0' .. '9' )+ )
            // InternalVTK.g:688:12: ( '0' .. '9' )+
            {
            // InternalVTK.g:688:12: ( '0' .. '9' )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='0' && LA13_0<='9')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalVTK.g:688:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVTK.g:690:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalVTK.g:690:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalVTK.g:690:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='\"') ) {
                alt16=1;
            }
            else if ( (LA16_0=='\'') ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalVTK.g:690:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalVTK.g:690:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop14:
                    do {
                        int alt14=3;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0=='\\') ) {
                            alt14=1;
                        }
                        else if ( ((LA14_0>='\u0000' && LA14_0<='!')||(LA14_0>='#' && LA14_0<='[')||(LA14_0>=']' && LA14_0<='\uFFFF')) ) {
                            alt14=2;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalVTK.g:690:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalVTK.g:690:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalVTK.g:690:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalVTK.g:690:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop15:
                    do {
                        int alt15=3;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0=='\\') ) {
                            alt15=1;
                        }
                        else if ( ((LA15_0>='\u0000' && LA15_0<='&')||(LA15_0>='(' && LA15_0<='[')||(LA15_0>=']' && LA15_0<='\uFFFF')) ) {
                            alt15=2;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalVTK.g:690:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalVTK.g:690:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    match('\''); 

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
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVTK.g:692:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalVTK.g:692:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalVTK.g:692:24: ( options {greedy=false; } : . )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0=='*') ) {
                    int LA17_1 = input.LA(2);

                    if ( (LA17_1=='/') ) {
                        alt17=2;
                    }
                    else if ( ((LA17_1>='\u0000' && LA17_1<='.')||(LA17_1>='0' && LA17_1<='\uFFFF')) ) {
                        alt17=1;
                    }


                }
                else if ( ((LA17_0>='\u0000' && LA17_0<=')')||(LA17_0>='+' && LA17_0<='\uFFFF')) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalVTK.g:692:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVTK.g:694:16: ( . )
            // InternalVTK.g:694:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalVTK.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | RULE_DOUBLE | RULE_ENDLINE | RULE_SL_COMMENT | RULE_WS | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_ANY_OTHER )
        int alt18=18;
        alt18 = dfa18.predict(input);
        switch (alt18) {
            case 1 :
                // InternalVTK.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // InternalVTK.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // InternalVTK.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // InternalVTK.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // InternalVTK.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // InternalVTK.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // InternalVTK.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // InternalVTK.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // InternalVTK.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // InternalVTK.g:1:64: RULE_DOUBLE
                {
                mRULE_DOUBLE(); 

                }
                break;
            case 11 :
                // InternalVTK.g:1:76: RULE_ENDLINE
                {
                mRULE_ENDLINE(); 

                }
                break;
            case 12 :
                // InternalVTK.g:1:89: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 13 :
                // InternalVTK.g:1:105: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 14 :
                // InternalVTK.g:1:113: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 15 :
                // InternalVTK.g:1:121: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 16 :
                // InternalVTK.g:1:130: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 17 :
                // InternalVTK.g:1:142: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 18 :
                // InternalVTK.g:1:158: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA18 dfa18 = new DFA18(this);
    static final String DFA18_eotS =
        "\1\uffff\2\30\1\32\1\34\1\36\2\uffff\1\41\1\26\1\42\5\uffff\2\30\1\26\1\uffff\2\26\1\uffff\1\30\1\uffff\1\30\11\uffff\1\42\3\uffff\2\30\1\uffff\15\30\1\46\2\30\1\100\5\30\1\uffff\2\30\1\105\1\30\1\uffff\6\30\1\115\1\uffff";
    static final String DFA18_eofS =
        "\116\uffff";
    static final String DFA18_minS =
        "\1\0\1\117\1\122\1\56\1\60\1\52\2\uffff\1\60\2\56\5\uffff\1\123\2\101\1\uffff\2\0\1\uffff\1\111\1\uffff\1\111\11\uffff\1\56\3\uffff\1\103\1\124\1\uffff\1\131\1\116\1\101\1\111\1\101\1\107\1\124\1\116\1\111\1\123\1\117\1\123\1\107\1\60\1\105\1\116\1\60\1\114\1\123\1\101\1\124\1\123\1\uffff\1\105\1\40\1\60\1\137\1\uffff\1\123\1\124\1\122\1\111\1\120\1\123\1\60\1\uffff";
    static final String DFA18_maxS =
        "\1\uffff\1\117\1\122\2\71\1\52\2\uffff\1\172\2\71\5\uffff\1\123\1\101\1\172\1\uffff\2\uffff\1\uffff\1\114\1\uffff\1\111\11\uffff\1\71\3\uffff\1\103\1\124\1\uffff\1\131\1\116\1\101\1\111\1\101\1\107\1\124\1\116\1\111\1\123\1\117\1\123\1\107\1\172\1\105\1\116\1\172\1\114\1\123\1\101\1\124\1\123\1\uffff\1\105\1\40\1\172\1\137\1\uffff\1\123\1\124\1\122\1\111\1\120\1\123\1\172\1\uffff";
    static final String DFA18_acceptS =
        "\6\uffff\1\7\1\10\3\uffff\2\13\1\14\2\15\3\uffff\1\16\2\uffff\1\22\1\uffff\1\16\1\uffff\1\4\1\12\1\5\1\21\1\6\1\7\1\10\1\11\1\17\1\uffff\1\13\1\14\1\15\2\uffff\1\20\26\uffff\1\3\4\uffff\1\1\7\uffff\1\2";
    static final String DFA18_specialS =
        "\1\0\23\uffff\1\2\1\1\70\uffff}>";
    static final String[] DFA18_transitionS = {
            "\11\26\1\17\1\14\2\26\1\13\22\26\1\16\1\26\1\24\1\15\3\26\1\25\3\26\1\11\1\26\1\3\1\4\1\5\12\12\1\7\6\26\1\20\2\23\1\21\13\23\1\1\3\23\1\2\6\23\1\26\1\6\1\26\1\22\1\10\1\26\32\23\uff85\26",
            "\1\27",
            "\1\31",
            "\1\33\1\uffff\12\33",
            "\12\33",
            "\1\35",
            "",
            "",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\33\1\uffff\12\33",
            "\1\33\1\uffff\12\43",
            "",
            "",
            "",
            "",
            "",
            "\1\47",
            "\1\50",
            "\32\30\4\uffff\1\30\1\uffff\32\30",
            "",
            "\0\51",
            "\0\51",
            "",
            "\1\53\2\uffff\1\52",
            "",
            "\1\54",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\33\1\uffff\12\43",
            "",
            "",
            "",
            "\1\55",
            "\1\56",
            "",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\12\30\7\uffff\1\74\2\30\1\75\26\30\4\uffff\1\30\1\uffff\32\30",
            "\1\76",
            "\1\77",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\101",
            "\1\47",
            "\1\50",
            "\1\102",
            "\1\103",
            "",
            "\1\104",
            "\1\46",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\106",
            "",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | RULE_DOUBLE | RULE_ENDLINE | RULE_SL_COMMENT | RULE_WS | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA18_0 = input.LA(1);

                        s = -1;
                        if ( (LA18_0=='P') ) {s = 1;}

                        else if ( (LA18_0=='T') ) {s = 2;}

                        else if ( (LA18_0=='-') ) {s = 3;}

                        else if ( (LA18_0=='.') ) {s = 4;}

                        else if ( (LA18_0=='/') ) {s = 5;}

                        else if ( (LA18_0=='\\') ) {s = 6;}

                        else if ( (LA18_0==':') ) {s = 7;}

                        else if ( (LA18_0=='_') ) {s = 8;}

                        else if ( (LA18_0=='+') ) {s = 9;}

                        else if ( ((LA18_0>='0' && LA18_0<='9')) ) {s = 10;}

                        else if ( (LA18_0=='\r') ) {s = 11;}

                        else if ( (LA18_0=='\n') ) {s = 12;}

                        else if ( (LA18_0=='#') ) {s = 13;}

                        else if ( (LA18_0==' ') ) {s = 14;}

                        else if ( (LA18_0=='\t') ) {s = 15;}

                        else if ( (LA18_0=='A') ) {s = 16;}

                        else if ( (LA18_0=='D') ) {s = 17;}

                        else if ( (LA18_0=='^') ) {s = 18;}

                        else if ( ((LA18_0>='B' && LA18_0<='C')||(LA18_0>='E' && LA18_0<='O')||(LA18_0>='Q' && LA18_0<='S')||(LA18_0>='U' && LA18_0<='Z')||(LA18_0>='a' && LA18_0<='z')) ) {s = 19;}

                        else if ( (LA18_0=='\"') ) {s = 20;}

                        else if ( (LA18_0=='\'') ) {s = 21;}

                        else if ( ((LA18_0>='\u0000' && LA18_0<='\b')||(LA18_0>='\u000B' && LA18_0<='\f')||(LA18_0>='\u000E' && LA18_0<='\u001F')||LA18_0=='!'||(LA18_0>='$' && LA18_0<='&')||(LA18_0>='(' && LA18_0<='*')||LA18_0==','||(LA18_0>=';' && LA18_0<='@')||LA18_0=='['||LA18_0==']'||LA18_0=='`'||(LA18_0>='{' && LA18_0<='\uFFFF')) ) {s = 22;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA18_21 = input.LA(1);

                        s = -1;
                        if ( ((LA18_21>='\u0000' && LA18_21<='\uFFFF')) ) {s = 41;}

                        else s = 22;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA18_20 = input.LA(1);

                        s = -1;
                        if ( ((LA18_20>='\u0000' && LA18_20<='\uFFFF')) ) {s = 41;}

                        else s = 22;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 18, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}