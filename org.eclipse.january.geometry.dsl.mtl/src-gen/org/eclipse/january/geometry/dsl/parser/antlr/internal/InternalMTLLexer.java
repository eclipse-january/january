package org.eclipse.january.geometry.dsl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMTLLexer extends Lexer {
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int RULE_DOUBLE=7;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_ID=6;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=4;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=10;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators

    public InternalMTLLexer() {;} 
    public InternalMTLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalMTLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalMTL.g"; }

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMTL.g:11:7: ( 'newmtl' )
            // InternalMTL.g:11:9: 'newmtl'
            {
            match("newmtl"); 


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
            // InternalMTL.g:12:7: ( 'Ka' )
            // InternalMTL.g:12:9: 'Ka'
            {
            match("Ka"); 


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
            // InternalMTL.g:13:7: ( 'Kd' )
            // InternalMTL.g:13:9: 'Kd'
            {
            match("Kd"); 


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
            // InternalMTL.g:14:7: ( 'Ks' )
            // InternalMTL.g:14:9: 'Ks'
            {
            match("Ks"); 


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
            // InternalMTL.g:15:7: ( 'Ns' )
            // InternalMTL.g:15:9: 'Ns'
            {
            match("Ns"); 


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
            // InternalMTL.g:16:7: ( 'd' )
            // InternalMTL.g:16:9: 'd'
            {
            match('d'); 

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
            // InternalMTL.g:17:7: ( 'Tr' )
            // InternalMTL.g:17:9: 'Tr'
            {
            match("Tr"); 


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
            // InternalMTL.g:18:7: ( 'illum' )
            // InternalMTL.g:18:9: 'illum'
            {
            match("illum"); 


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
            // InternalMTL.g:19:7: ( 'map_Ka' )
            // InternalMTL.g:19:9: 'map_Ka'
            {
            match("map_Ka"); 


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
            // InternalMTL.g:20:7: ( 'map_Kd' )
            // InternalMTL.g:20:9: 'map_Kd'
            {
            match("map_Kd"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMTL.g:21:7: ( 'map_Ks' )
            // InternalMTL.g:21:9: 'map_Ks'
            {
            match("map_Ks"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMTL.g:22:7: ( 'map_Ns' )
            // InternalMTL.g:22:9: 'map_Ns'
            {
            match("map_Ns"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMTL.g:23:7: ( 'map_d' )
            // InternalMTL.g:23:9: 'map_d'
            {
            match("map_d"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMTL.g:24:7: ( 'map_bump' )
            // InternalMTL.g:24:9: 'map_bump'
            {
            match("map_bump"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMTL.g:25:7: ( '-' )
            // InternalMTL.g:25:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMTL.g:26:7: ( '.' )
            // InternalMTL.g:26:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMTL.g:27:7: ( '/' )
            // InternalMTL.g:27:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMTL.g:28:7: ( '\\\\' )
            // InternalMTL.g:28:9: '\\\\'
            {
            match('\\'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMTL.g:29:7: ( ':' )
            // InternalMTL.g:29:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMTL.g:30:7: ( '_' )
            // InternalMTL.g:30:9: '_'
            {
            match('_'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMTL.g:1123:17: ( '#' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalMTL.g:1123:19: '#' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match('#'); 
            // InternalMTL.g:1123:23: (~ ( ( '\\n' | '\\r' ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMTL.g:1123:23: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop1;
                }
            } while (true);

            // InternalMTL.g:1123:39: ( ( '\\r' )? '\\n' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\n'||LA3_0=='\r') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalMTL.g:1123:40: ( '\\r' )? '\\n'
                    {
                    // InternalMTL.g:1123:40: ( '\\r' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0=='\r') ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // InternalMTL.g:1123:40: '\\r'
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

    // $ANTLR start "RULE_DOUBLE"
    public final void mRULE_DOUBLE() throws RecognitionException {
        try {
            int _type = RULE_DOUBLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMTL.g:1125:13: ( ( '-' | '+' )? ( RULE_INT )? '.' RULE_INT ( ( 'E' | 'e' ) ( '-' | '+' )? RULE_INT )? )
            // InternalMTL.g:1125:15: ( '-' | '+' )? ( RULE_INT )? '.' RULE_INT ( ( 'E' | 'e' ) ( '-' | '+' )? RULE_INT )?
            {
            // InternalMTL.g:1125:15: ( '-' | '+' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='+'||LA4_0=='-') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalMTL.g:
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

            // InternalMTL.g:1125:26: ( RULE_INT )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalMTL.g:1125:26: RULE_INT
                    {
                    mRULE_INT(); 

                    }
                    break;

            }

            match('.'); 
            mRULE_INT(); 
            // InternalMTL.g:1125:49: ( ( 'E' | 'e' ) ( '-' | '+' )? RULE_INT )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='E'||LA7_0=='e') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalMTL.g:1125:50: ( 'E' | 'e' ) ( '-' | '+' )? RULE_INT
                    {
                    if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // InternalMTL.g:1125:60: ( '-' | '+' )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='+'||LA6_0=='-') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalMTL.g:
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

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMTL.g:1127:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalMTL.g:1127:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalMTL.g:1127:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\t' && LA8_0<='\n')||LA8_0=='\r'||LA8_0==' ') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalMTL.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
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
            // InternalMTL.g:1129:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalMTL.g:1129:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalMTL.g:1129:11: ( '^' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='^') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalMTL.g:1129:11: '^'
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

            // InternalMTL.g:1129:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='0' && LA10_0<='9')||(LA10_0>='A' && LA10_0<='Z')||LA10_0=='_'||(LA10_0>='a' && LA10_0<='z')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalMTL.g:
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
            	    break loop10;
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
            // InternalMTL.g:1131:10: ( ( '0' .. '9' )+ )
            // InternalMTL.g:1131:12: ( '0' .. '9' )+
            {
            // InternalMTL.g:1131:12: ( '0' .. '9' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalMTL.g:1131:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
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
            // InternalMTL.g:1133:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalMTL.g:1133:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalMTL.g:1133:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='\"') ) {
                alt14=1;
            }
            else if ( (LA14_0=='\'') ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalMTL.g:1133:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalMTL.g:1133:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop12:
                    do {
                        int alt12=3;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0=='\\') ) {
                            alt12=1;
                        }
                        else if ( ((LA12_0>='\u0000' && LA12_0<='!')||(LA12_0>='#' && LA12_0<='[')||(LA12_0>=']' && LA12_0<='\uFFFF')) ) {
                            alt12=2;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalMTL.g:1133:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalMTL.g:1133:28: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop12;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalMTL.g:1133:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalMTL.g:1133:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop13:
                    do {
                        int alt13=3;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0=='\\') ) {
                            alt13=1;
                        }
                        else if ( ((LA13_0>='\u0000' && LA13_0<='&')||(LA13_0>='(' && LA13_0<='[')||(LA13_0>=']' && LA13_0<='\uFFFF')) ) {
                            alt13=2;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalMTL.g:1133:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalMTL.g:1133:61: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop13;
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
            // InternalMTL.g:1135:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalMTL.g:1135:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalMTL.g:1135:24: ( options {greedy=false; } : . )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0=='*') ) {
                    int LA15_1 = input.LA(2);

                    if ( (LA15_1=='/') ) {
                        alt15=2;
                    }
                    else if ( ((LA15_1>='\u0000' && LA15_1<='.')||(LA15_1>='0' && LA15_1<='\uFFFF')) ) {
                        alt15=1;
                    }


                }
                else if ( ((LA15_0>='\u0000' && LA15_0<=')')||(LA15_0>='+' && LA15_0<='\uFFFF')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalMTL.g:1135:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop15;
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
            // InternalMTL.g:1137:16: ( . )
            // InternalMTL.g:1137:18: .
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
        // InternalMTL.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | RULE_SL_COMMENT | RULE_DOUBLE | RULE_WS | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_ANY_OTHER )
        int alt16=28;
        alt16 = dfa16.predict(input);
        switch (alt16) {
            case 1 :
                // InternalMTL.g:1:10: T__12
                {
                mT__12(); 

                }
                break;
            case 2 :
                // InternalMTL.g:1:16: T__13
                {
                mT__13(); 

                }
                break;
            case 3 :
                // InternalMTL.g:1:22: T__14
                {
                mT__14(); 

                }
                break;
            case 4 :
                // InternalMTL.g:1:28: T__15
                {
                mT__15(); 

                }
                break;
            case 5 :
                // InternalMTL.g:1:34: T__16
                {
                mT__16(); 

                }
                break;
            case 6 :
                // InternalMTL.g:1:40: T__17
                {
                mT__17(); 

                }
                break;
            case 7 :
                // InternalMTL.g:1:46: T__18
                {
                mT__18(); 

                }
                break;
            case 8 :
                // InternalMTL.g:1:52: T__19
                {
                mT__19(); 

                }
                break;
            case 9 :
                // InternalMTL.g:1:58: T__20
                {
                mT__20(); 

                }
                break;
            case 10 :
                // InternalMTL.g:1:64: T__21
                {
                mT__21(); 

                }
                break;
            case 11 :
                // InternalMTL.g:1:70: T__22
                {
                mT__22(); 

                }
                break;
            case 12 :
                // InternalMTL.g:1:76: T__23
                {
                mT__23(); 

                }
                break;
            case 13 :
                // InternalMTL.g:1:82: T__24
                {
                mT__24(); 

                }
                break;
            case 14 :
                // InternalMTL.g:1:88: T__25
                {
                mT__25(); 

                }
                break;
            case 15 :
                // InternalMTL.g:1:94: T__26
                {
                mT__26(); 

                }
                break;
            case 16 :
                // InternalMTL.g:1:100: T__27
                {
                mT__27(); 

                }
                break;
            case 17 :
                // InternalMTL.g:1:106: T__28
                {
                mT__28(); 

                }
                break;
            case 18 :
                // InternalMTL.g:1:112: T__29
                {
                mT__29(); 

                }
                break;
            case 19 :
                // InternalMTL.g:1:118: T__30
                {
                mT__30(); 

                }
                break;
            case 20 :
                // InternalMTL.g:1:124: T__31
                {
                mT__31(); 

                }
                break;
            case 21 :
                // InternalMTL.g:1:130: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 22 :
                // InternalMTL.g:1:146: RULE_DOUBLE
                {
                mRULE_DOUBLE(); 

                }
                break;
            case 23 :
                // InternalMTL.g:1:158: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 24 :
                // InternalMTL.g:1:166: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 25 :
                // InternalMTL.g:1:174: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 26 :
                // InternalMTL.g:1:183: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 27 :
                // InternalMTL.g:1:195: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 28 :
                // InternalMTL.g:1:211: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA16 dfa16 = new DFA16(this);
    static final String DFA16_eotS =
        "\1\uffff\3\30\1\35\3\30\1\42\1\43\1\45\2\uffff\1\50\1\uffff\1\26\1\52\1\uffff\1\26\1\uffff\2\26\1\uffff\1\30\1\uffff\1\57\1\60\1\61\1\62\1\uffff\1\63\2\30\12\uffff\1\52\2\uffff\1\30\5\uffff\6\30\1\100\2\30\1\105\1\30\1\107\1\uffff\1\110\1\111\1\112\1\113\1\uffff\1\30\5\uffff\1\30\1\116\1\uffff";
    static final String DFA16_eofS =
        "\117\uffff";
    static final String DFA16_minS =
        "\1\0\1\145\1\141\1\163\1\60\1\162\1\154\1\141\1\56\1\60\1\52\2\uffff\1\60\1\uffff\2\56\1\uffff\1\101\1\uffff\2\0\1\uffff\1\167\1\uffff\4\60\1\uffff\1\60\1\154\1\160\12\uffff\1\56\2\uffff\1\155\5\uffff\1\165\1\137\1\164\1\155\1\113\1\154\1\60\1\141\1\163\1\60\1\165\1\60\1\uffff\4\60\1\uffff\1\155\5\uffff\1\160\1\60\1\uffff";
    static final String DFA16_maxS =
        "\1\uffff\1\145\2\163\1\172\1\162\1\154\1\141\2\71\1\52\2\uffff\1\172\1\uffff\2\71\1\uffff\1\172\1\uffff\2\uffff\1\uffff\1\167\1\uffff\4\172\1\uffff\1\172\1\154\1\160\12\uffff\1\71\2\uffff\1\155\5\uffff\1\165\1\137\1\164\1\155\1\144\1\154\1\172\2\163\1\172\1\165\1\172\1\uffff\4\172\1\uffff\1\155\5\uffff\1\160\1\172\1\uffff";
    static final String DFA16_acceptS =
        "\13\uffff\1\22\1\23\1\uffff\1\25\2\uffff\1\27\1\uffff\1\30\2\uffff\1\34\1\uffff\1\30\4\uffff\1\6\3\uffff\1\26\1\17\1\20\1\33\1\21\1\22\1\23\1\24\1\25\1\31\1\uffff\1\27\1\32\1\uffff\1\2\1\3\1\4\1\5\1\7\14\uffff\1\10\4\uffff\1\15\1\uffff\1\1\1\11\1\12\1\13\1\14\2\uffff\1\16";
    static final String DFA16_specialS =
        "\1\2\23\uffff\1\0\1\1\71\uffff}>";
    static final String[] DFA16_transitionS = {
            "\11\26\2\21\2\26\1\21\22\26\1\21\1\26\1\24\1\16\3\26\1\25\3\26\1\17\1\26\1\10\1\11\1\12\12\20\1\14\6\26\12\23\1\2\2\23\1\3\5\23\1\5\6\23\1\26\1\13\1\26\1\22\1\15\1\26\3\23\1\4\4\23\1\6\3\23\1\7\1\1\14\23\uff85\26",
            "\1\27",
            "\1\31\2\uffff\1\32\16\uffff\1\33",
            "\1\34",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\36",
            "\1\37",
            "\1\40",
            "\1\41\1\uffff\12\41",
            "\12\41",
            "\1\44",
            "",
            "",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "",
            "\1\41\1\uffff\12\41",
            "\1\41\1\uffff\12\53",
            "",
            "\32\30\4\uffff\1\30\1\uffff\32\30",
            "",
            "\0\55",
            "\0\55",
            "",
            "\1\56",
            "",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\64",
            "\1\65",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\41\1\uffff\12\53",
            "",
            "",
            "\1\66",
            "",
            "",
            "",
            "",
            "",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73\2\uffff\1\74\23\uffff\1\76\1\uffff\1\75",
            "\1\77",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\101\2\uffff\1\102\16\uffff\1\103",
            "\1\104",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\106",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "",
            "\1\114",
            "",
            "",
            "",
            "",
            "",
            "\1\115",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            ""
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | RULE_SL_COMMENT | RULE_DOUBLE | RULE_WS | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA16_20 = input.LA(1);

                        s = -1;
                        if ( ((LA16_20>='\u0000' && LA16_20<='\uFFFF')) ) {s = 45;}

                        else s = 22;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA16_21 = input.LA(1);

                        s = -1;
                        if ( ((LA16_21>='\u0000' && LA16_21<='\uFFFF')) ) {s = 45;}

                        else s = 22;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA16_0 = input.LA(1);

                        s = -1;
                        if ( (LA16_0=='n') ) {s = 1;}

                        else if ( (LA16_0=='K') ) {s = 2;}

                        else if ( (LA16_0=='N') ) {s = 3;}

                        else if ( (LA16_0=='d') ) {s = 4;}

                        else if ( (LA16_0=='T') ) {s = 5;}

                        else if ( (LA16_0=='i') ) {s = 6;}

                        else if ( (LA16_0=='m') ) {s = 7;}

                        else if ( (LA16_0=='-') ) {s = 8;}

                        else if ( (LA16_0=='.') ) {s = 9;}

                        else if ( (LA16_0=='/') ) {s = 10;}

                        else if ( (LA16_0=='\\') ) {s = 11;}

                        else if ( (LA16_0==':') ) {s = 12;}

                        else if ( (LA16_0=='_') ) {s = 13;}

                        else if ( (LA16_0=='#') ) {s = 14;}

                        else if ( (LA16_0=='+') ) {s = 15;}

                        else if ( ((LA16_0>='0' && LA16_0<='9')) ) {s = 16;}

                        else if ( ((LA16_0>='\t' && LA16_0<='\n')||LA16_0=='\r'||LA16_0==' ') ) {s = 17;}

                        else if ( (LA16_0=='^') ) {s = 18;}

                        else if ( ((LA16_0>='A' && LA16_0<='J')||(LA16_0>='L' && LA16_0<='M')||(LA16_0>='O' && LA16_0<='S')||(LA16_0>='U' && LA16_0<='Z')||(LA16_0>='a' && LA16_0<='c')||(LA16_0>='e' && LA16_0<='h')||(LA16_0>='j' && LA16_0<='l')||(LA16_0>='o' && LA16_0<='z')) ) {s = 19;}

                        else if ( (LA16_0=='\"') ) {s = 20;}

                        else if ( (LA16_0=='\'') ) {s = 21;}

                        else if ( ((LA16_0>='\u0000' && LA16_0<='\b')||(LA16_0>='\u000B' && LA16_0<='\f')||(LA16_0>='\u000E' && LA16_0<='\u001F')||LA16_0=='!'||(LA16_0>='$' && LA16_0<='&')||(LA16_0>='(' && LA16_0<='*')||LA16_0==','||(LA16_0>=';' && LA16_0<='@')||LA16_0=='['||LA16_0==']'||LA16_0=='`'||(LA16_0>='{' && LA16_0<='\uFFFF')) ) {s = 22;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 16, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}