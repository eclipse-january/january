package org.eclipse.january.geometry.xtext.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.eclipse.january.geometry.xtext.services.OBJGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalOBJParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NORMAL", "RULE_STRING", "RULE_ID", "RULE_DOUBLE", "RULE_INT", "RULE_COMMENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'g'", "'v'", "'vt'", "'f'", "'/'", "'-'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=11;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int RULE_DOUBLE=7;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=6;
    public static final int RULE_NORMAL=4;
    public static final int RULE_WS=12;
    public static final int RULE_COMMENT=9;
    public static final int RULE_ANY_OTHER=13;
    public static final int RULE_INT=8;
    public static final int RULE_ML_COMMENT=10;

    // delegates
    // delegators


        public InternalOBJParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalOBJParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalOBJParser.tokenNames; }
    public String getGrammarFileName() { return "InternalOBJ.g"; }


    	private OBJGrammarAccess grammarAccess;

    	public void setGrammarAccess(OBJGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleGeometry"
    // InternalOBJ.g:53:1: entryRuleGeometry : ruleGeometry EOF ;
    public final void entryRuleGeometry() throws RecognitionException {
        try {
            // InternalOBJ.g:54:1: ( ruleGeometry EOF )
            // InternalOBJ.g:55:1: ruleGeometry EOF
            {
             before(grammarAccess.getGeometryRule()); 
            pushFollow(FOLLOW_1);
            ruleGeometry();

            state._fsp--;

             after(grammarAccess.getGeometryRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGeometry"


    // $ANTLR start "ruleGeometry"
    // InternalOBJ.g:62:1: ruleGeometry : ( ( rule__Geometry__Group__0 ) ) ;
    public final void ruleGeometry() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:66:2: ( ( ( rule__Geometry__Group__0 ) ) )
            // InternalOBJ.g:67:2: ( ( rule__Geometry__Group__0 ) )
            {
            // InternalOBJ.g:67:2: ( ( rule__Geometry__Group__0 ) )
            // InternalOBJ.g:68:3: ( rule__Geometry__Group__0 )
            {
             before(grammarAccess.getGeometryAccess().getGroup()); 
            // InternalOBJ.g:69:3: ( rule__Geometry__Group__0 )
            // InternalOBJ.g:69:4: rule__Geometry__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Geometry__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGeometryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGeometry"


    // $ANTLR start "entryRuleVertexSource"
    // InternalOBJ.g:78:1: entryRuleVertexSource : ruleVertexSource EOF ;
    public final void entryRuleVertexSource() throws RecognitionException {
        try {
            // InternalOBJ.g:79:1: ( ruleVertexSource EOF )
            // InternalOBJ.g:80:1: ruleVertexSource EOF
            {
             before(grammarAccess.getVertexSourceRule()); 
            pushFollow(FOLLOW_1);
            ruleVertexSource();

            state._fsp--;

             after(grammarAccess.getVertexSourceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVertexSource"


    // $ANTLR start "ruleVertexSource"
    // InternalOBJ.g:87:1: ruleVertexSource : ( ( rule__VertexSource__Group__0 ) ) ;
    public final void ruleVertexSource() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:91:2: ( ( ( rule__VertexSource__Group__0 ) ) )
            // InternalOBJ.g:92:2: ( ( rule__VertexSource__Group__0 ) )
            {
            // InternalOBJ.g:92:2: ( ( rule__VertexSource__Group__0 ) )
            // InternalOBJ.g:93:3: ( rule__VertexSource__Group__0 )
            {
             before(grammarAccess.getVertexSourceAccess().getGroup()); 
            // InternalOBJ.g:94:3: ( rule__VertexSource__Group__0 )
            // InternalOBJ.g:94:4: rule__VertexSource__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__VertexSource__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVertexSourceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVertexSource"


    // $ANTLR start "entryRulePolyShape"
    // InternalOBJ.g:103:1: entryRulePolyShape : rulePolyShape EOF ;
    public final void entryRulePolyShape() throws RecognitionException {
        try {
            // InternalOBJ.g:104:1: ( rulePolyShape EOF )
            // InternalOBJ.g:105:1: rulePolyShape EOF
            {
             before(grammarAccess.getPolyShapeRule()); 
            pushFollow(FOLLOW_1);
            rulePolyShape();

            state._fsp--;

             after(grammarAccess.getPolyShapeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePolyShape"


    // $ANTLR start "rulePolyShape"
    // InternalOBJ.g:112:1: rulePolyShape : ( ( rule__PolyShape__Group__0 ) ) ;
    public final void rulePolyShape() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:116:2: ( ( ( rule__PolyShape__Group__0 ) ) )
            // InternalOBJ.g:117:2: ( ( rule__PolyShape__Group__0 ) )
            {
            // InternalOBJ.g:117:2: ( ( rule__PolyShape__Group__0 ) )
            // InternalOBJ.g:118:3: ( rule__PolyShape__Group__0 )
            {
             before(grammarAccess.getPolyShapeAccess().getGroup()); 
            // InternalOBJ.g:119:3: ( rule__PolyShape__Group__0 )
            // InternalOBJ.g:119:4: rule__PolyShape__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PolyShape__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPolyShapeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePolyShape"


    // $ANTLR start "entryRuleFace"
    // InternalOBJ.g:128:1: entryRuleFace : ruleFace EOF ;
    public final void entryRuleFace() throws RecognitionException {
        try {
            // InternalOBJ.g:129:1: ( ruleFace EOF )
            // InternalOBJ.g:130:1: ruleFace EOF
            {
             before(grammarAccess.getFaceRule()); 
            pushFollow(FOLLOW_1);
            ruleFace();

            state._fsp--;

             after(grammarAccess.getFaceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFace"


    // $ANTLR start "ruleFace"
    // InternalOBJ.g:137:1: ruleFace : ( ( rule__Face__Group__0 ) ) ;
    public final void ruleFace() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:141:2: ( ( ( rule__Face__Group__0 ) ) )
            // InternalOBJ.g:142:2: ( ( rule__Face__Group__0 ) )
            {
            // InternalOBJ.g:142:2: ( ( rule__Face__Group__0 ) )
            // InternalOBJ.g:143:3: ( rule__Face__Group__0 )
            {
             before(grammarAccess.getFaceAccess().getGroup()); 
            // InternalOBJ.g:144:3: ( rule__Face__Group__0 )
            // InternalOBJ.g:144:4: rule__Face__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Face__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFaceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFace"


    // $ANTLR start "entryRuleVertex"
    // InternalOBJ.g:153:1: entryRuleVertex : ruleVertex EOF ;
    public final void entryRuleVertex() throws RecognitionException {
        try {
            // InternalOBJ.g:154:1: ( ruleVertex EOF )
            // InternalOBJ.g:155:1: ruleVertex EOF
            {
             before(grammarAccess.getVertexRule()); 
            pushFollow(FOLLOW_1);
            ruleVertex();

            state._fsp--;

             after(grammarAccess.getVertexRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVertex"


    // $ANTLR start "ruleVertex"
    // InternalOBJ.g:162:1: ruleVertex : ( ( rule__Vertex__Group__0 ) ) ;
    public final void ruleVertex() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:166:2: ( ( ( rule__Vertex__Group__0 ) ) )
            // InternalOBJ.g:167:2: ( ( rule__Vertex__Group__0 ) )
            {
            // InternalOBJ.g:167:2: ( ( rule__Vertex__Group__0 ) )
            // InternalOBJ.g:168:3: ( rule__Vertex__Group__0 )
            {
             before(grammarAccess.getVertexAccess().getGroup()); 
            // InternalOBJ.g:169:3: ( rule__Vertex__Group__0 )
            // InternalOBJ.g:169:4: rule__Vertex__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Vertex__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVertexAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVertex"


    // $ANTLR start "entryRuleTextureVertex"
    // InternalOBJ.g:178:1: entryRuleTextureVertex : ruleTextureVertex EOF ;
    public final void entryRuleTextureVertex() throws RecognitionException {
        try {
            // InternalOBJ.g:179:1: ( ruleTextureVertex EOF )
            // InternalOBJ.g:180:1: ruleTextureVertex EOF
            {
             before(grammarAccess.getTextureVertexRule()); 
            pushFollow(FOLLOW_1);
            ruleTextureVertex();

            state._fsp--;

             after(grammarAccess.getTextureVertexRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTextureVertex"


    // $ANTLR start "ruleTextureVertex"
    // InternalOBJ.g:187:1: ruleTextureVertex : ( ( rule__TextureVertex__Group__0 ) ) ;
    public final void ruleTextureVertex() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:191:2: ( ( ( rule__TextureVertex__Group__0 ) ) )
            // InternalOBJ.g:192:2: ( ( rule__TextureVertex__Group__0 ) )
            {
            // InternalOBJ.g:192:2: ( ( rule__TextureVertex__Group__0 ) )
            // InternalOBJ.g:193:3: ( rule__TextureVertex__Group__0 )
            {
             before(grammarAccess.getTextureVertexAccess().getGroup()); 
            // InternalOBJ.g:194:3: ( rule__TextureVertex__Group__0 )
            // InternalOBJ.g:194:4: rule__TextureVertex__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TextureVertex__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTextureVertexAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTextureVertex"


    // $ANTLR start "entryRuleEInt"
    // InternalOBJ.g:203:1: entryRuleEInt : ruleEInt EOF ;
    public final void entryRuleEInt() throws RecognitionException {
        try {
            // InternalOBJ.g:204:1: ( ruleEInt EOF )
            // InternalOBJ.g:205:1: ruleEInt EOF
            {
             before(grammarAccess.getEIntRule()); 
            pushFollow(FOLLOW_1);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getEIntRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // InternalOBJ.g:212:1: ruleEInt : ( ( rule__EInt__Group__0 ) ) ;
    public final void ruleEInt() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:216:2: ( ( ( rule__EInt__Group__0 ) ) )
            // InternalOBJ.g:217:2: ( ( rule__EInt__Group__0 ) )
            {
            // InternalOBJ.g:217:2: ( ( rule__EInt__Group__0 ) )
            // InternalOBJ.g:218:3: ( rule__EInt__Group__0 )
            {
             before(grammarAccess.getEIntAccess().getGroup()); 
            // InternalOBJ.g:219:3: ( rule__EInt__Group__0 )
            // InternalOBJ.g:219:4: rule__EInt__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EInt__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEIntAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEInt"


    // $ANTLR start "entryRuleEString"
    // InternalOBJ.g:228:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalOBJ.g:229:1: ( ruleEString EOF )
            // InternalOBJ.g:230:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEStringRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalOBJ.g:237:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:241:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalOBJ.g:242:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalOBJ.g:242:2: ( ( rule__EString__Alternatives ) )
            // InternalOBJ.g:243:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalOBJ.g:244:3: ( rule__EString__Alternatives )
            // InternalOBJ.g:244:4: rule__EString__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EString__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEStringAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleEDouble"
    // InternalOBJ.g:253:1: entryRuleEDouble : ruleEDouble EOF ;
    public final void entryRuleEDouble() throws RecognitionException {
        try {
            // InternalOBJ.g:254:1: ( ruleEDouble EOF )
            // InternalOBJ.g:255:1: ruleEDouble EOF
            {
             before(grammarAccess.getEDoubleRule()); 
            pushFollow(FOLLOW_1);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getEDoubleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEDouble"


    // $ANTLR start "ruleEDouble"
    // InternalOBJ.g:262:1: ruleEDouble : ( ( rule__EDouble__Alternatives ) ) ;
    public final void ruleEDouble() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:266:2: ( ( ( rule__EDouble__Alternatives ) ) )
            // InternalOBJ.g:267:2: ( ( rule__EDouble__Alternatives ) )
            {
            // InternalOBJ.g:267:2: ( ( rule__EDouble__Alternatives ) )
            // InternalOBJ.g:268:3: ( rule__EDouble__Alternatives )
            {
             before(grammarAccess.getEDoubleAccess().getAlternatives()); 
            // InternalOBJ.g:269:3: ( rule__EDouble__Alternatives )
            // InternalOBJ.g:269:4: rule__EDouble__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EDouble__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEDoubleAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEDouble"


    // $ANTLR start "rule__VertexSource__Alternatives_4"
    // InternalOBJ.g:277:1: rule__VertexSource__Alternatives_4 : ( ( ( rule__VertexSource__Group_4_0__0 ) ) | ( ( rule__VertexSource__Group_4_1__0 ) ) | ( RULE_NORMAL ) );
    public final void rule__VertexSource__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:281:1: ( ( ( rule__VertexSource__Group_4_0__0 ) ) | ( ( rule__VertexSource__Group_4_1__0 ) ) | ( RULE_NORMAL ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt1=1;
                }
                break;
            case 16:
                {
                alt1=2;
                }
                break;
            case RULE_NORMAL:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalOBJ.g:282:2: ( ( rule__VertexSource__Group_4_0__0 ) )
                    {
                    // InternalOBJ.g:282:2: ( ( rule__VertexSource__Group_4_0__0 ) )
                    // InternalOBJ.g:283:3: ( rule__VertexSource__Group_4_0__0 )
                    {
                     before(grammarAccess.getVertexSourceAccess().getGroup_4_0()); 
                    // InternalOBJ.g:284:3: ( rule__VertexSource__Group_4_0__0 )
                    // InternalOBJ.g:284:4: rule__VertexSource__Group_4_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__VertexSource__Group_4_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getVertexSourceAccess().getGroup_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOBJ.g:288:2: ( ( rule__VertexSource__Group_4_1__0 ) )
                    {
                    // InternalOBJ.g:288:2: ( ( rule__VertexSource__Group_4_1__0 ) )
                    // InternalOBJ.g:289:3: ( rule__VertexSource__Group_4_1__0 )
                    {
                     before(grammarAccess.getVertexSourceAccess().getGroup_4_1()); 
                    // InternalOBJ.g:290:3: ( rule__VertexSource__Group_4_1__0 )
                    // InternalOBJ.g:290:4: rule__VertexSource__Group_4_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__VertexSource__Group_4_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getVertexSourceAccess().getGroup_4_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOBJ.g:294:2: ( RULE_NORMAL )
                    {
                    // InternalOBJ.g:294:2: ( RULE_NORMAL )
                    // InternalOBJ.g:295:3: RULE_NORMAL
                    {
                     before(grammarAccess.getVertexSourceAccess().getNORMALTerminalRuleCall_4_2()); 
                    match(input,RULE_NORMAL,FOLLOW_2); 
                     after(grammarAccess.getVertexSourceAccess().getNORMALTerminalRuleCall_4_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VertexSource__Alternatives_4"


    // $ANTLR start "rule__Face__Alternatives_1_1_1"
    // InternalOBJ.g:304:1: rule__Face__Alternatives_1_1_1 : ( ( ( rule__Face__TextureIndicesAssignment_1_1_1_0 ) ) | ( ( rule__Face__Group_1_1_1_1__0 ) ) | ( ( rule__Face__Group_1_1_1_2__0 ) ) );
    public final void rule__Face__Alternatives_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:308:1: ( ( ( rule__Face__TextureIndicesAssignment_1_1_1_0 ) ) | ( ( rule__Face__Group_1_1_1_1__0 ) ) | ( ( rule__Face__Group_1_1_1_2__0 ) ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 19:
                {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==RULE_INT) ) {
                    int LA2_2 = input.LA(3);

                    if ( (LA2_2==EOF||LA2_2==RULE_INT||LA2_2==14||LA2_2==17||LA2_2==19) ) {
                        alt2=1;
                    }
                    else if ( (LA2_2==18) ) {
                        alt2=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA2_2 = input.LA(2);

                if ( (LA2_2==EOF||LA2_2==RULE_INT||LA2_2==14||LA2_2==17||LA2_2==19) ) {
                    alt2=1;
                }
                else if ( (LA2_2==18) ) {
                    alt2=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;
                }
                }
                break;
            case 18:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalOBJ.g:309:2: ( ( rule__Face__TextureIndicesAssignment_1_1_1_0 ) )
                    {
                    // InternalOBJ.g:309:2: ( ( rule__Face__TextureIndicesAssignment_1_1_1_0 ) )
                    // InternalOBJ.g:310:3: ( rule__Face__TextureIndicesAssignment_1_1_1_0 )
                    {
                     before(grammarAccess.getFaceAccess().getTextureIndicesAssignment_1_1_1_0()); 
                    // InternalOBJ.g:311:3: ( rule__Face__TextureIndicesAssignment_1_1_1_0 )
                    // InternalOBJ.g:311:4: rule__Face__TextureIndicesAssignment_1_1_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Face__TextureIndicesAssignment_1_1_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getFaceAccess().getTextureIndicesAssignment_1_1_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOBJ.g:315:2: ( ( rule__Face__Group_1_1_1_1__0 ) )
                    {
                    // InternalOBJ.g:315:2: ( ( rule__Face__Group_1_1_1_1__0 ) )
                    // InternalOBJ.g:316:3: ( rule__Face__Group_1_1_1_1__0 )
                    {
                     before(grammarAccess.getFaceAccess().getGroup_1_1_1_1()); 
                    // InternalOBJ.g:317:3: ( rule__Face__Group_1_1_1_1__0 )
                    // InternalOBJ.g:317:4: rule__Face__Group_1_1_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Face__Group_1_1_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getFaceAccess().getGroup_1_1_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOBJ.g:321:2: ( ( rule__Face__Group_1_1_1_2__0 ) )
                    {
                    // InternalOBJ.g:321:2: ( ( rule__Face__Group_1_1_1_2__0 ) )
                    // InternalOBJ.g:322:3: ( rule__Face__Group_1_1_1_2__0 )
                    {
                     before(grammarAccess.getFaceAccess().getGroup_1_1_1_2()); 
                    // InternalOBJ.g:323:3: ( rule__Face__Group_1_1_1_2__0 )
                    // InternalOBJ.g:323:4: rule__Face__Group_1_1_1_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Face__Group_1_1_1_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getFaceAccess().getGroup_1_1_1_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Face__Alternatives_1_1_1"


    // $ANTLR start "rule__EString__Alternatives"
    // InternalOBJ.g:331:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:335:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_STRING) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_ID) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalOBJ.g:336:2: ( RULE_STRING )
                    {
                    // InternalOBJ.g:336:2: ( RULE_STRING )
                    // InternalOBJ.g:337:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOBJ.g:342:2: ( RULE_ID )
                    {
                    // InternalOBJ.g:342:2: ( RULE_ID )
                    // InternalOBJ.g:343:3: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EString__Alternatives"


    // $ANTLR start "rule__EDouble__Alternatives"
    // InternalOBJ.g:352:1: rule__EDouble__Alternatives : ( ( RULE_DOUBLE ) | ( ruleEInt ) );
    public final void rule__EDouble__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:356:1: ( ( RULE_DOUBLE ) | ( ruleEInt ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_DOUBLE) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_INT||LA4_0==19) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalOBJ.g:357:2: ( RULE_DOUBLE )
                    {
                    // InternalOBJ.g:357:2: ( RULE_DOUBLE )
                    // InternalOBJ.g:358:3: RULE_DOUBLE
                    {
                     before(grammarAccess.getEDoubleAccess().getDOUBLETerminalRuleCall_0()); 
                    match(input,RULE_DOUBLE,FOLLOW_2); 
                     after(grammarAccess.getEDoubleAccess().getDOUBLETerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOBJ.g:363:2: ( ruleEInt )
                    {
                    // InternalOBJ.g:363:2: ( ruleEInt )
                    // InternalOBJ.g:364:3: ruleEInt
                    {
                     before(grammarAccess.getEDoubleAccess().getEIntParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleEInt();

                    state._fsp--;

                     after(grammarAccess.getEDoubleAccess().getEIntParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Alternatives"


    // $ANTLR start "rule__Geometry__Group__0"
    // InternalOBJ.g:373:1: rule__Geometry__Group__0 : rule__Geometry__Group__0__Impl rule__Geometry__Group__1 ;
    public final void rule__Geometry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:377:1: ( rule__Geometry__Group__0__Impl rule__Geometry__Group__1 )
            // InternalOBJ.g:378:2: rule__Geometry__Group__0__Impl rule__Geometry__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Geometry__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Geometry__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Geometry__Group__0"


    // $ANTLR start "rule__Geometry__Group__0__Impl"
    // InternalOBJ.g:385:1: rule__Geometry__Group__0__Impl : ( ( rule__Geometry__VertexSourceAssignment_0 )? ) ;
    public final void rule__Geometry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:389:1: ( ( ( rule__Geometry__VertexSourceAssignment_0 )? ) )
            // InternalOBJ.g:390:1: ( ( rule__Geometry__VertexSourceAssignment_0 )? )
            {
            // InternalOBJ.g:390:1: ( ( rule__Geometry__VertexSourceAssignment_0 )? )
            // InternalOBJ.g:391:2: ( rule__Geometry__VertexSourceAssignment_0 )?
            {
             before(grammarAccess.getGeometryAccess().getVertexSourceAssignment_0()); 
            // InternalOBJ.g:392:2: ( rule__Geometry__VertexSourceAssignment_0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=RULE_STRING && LA5_0<=RULE_ID)) ) {
                alt5=1;
            }
            else if ( (LA5_0==14) ) {
                int LA5_2 = input.LA(2);

                if ( (LA5_2==RULE_STRING) ) {
                    alt5=1;
                }
                else if ( (LA5_2==EOF||LA5_2==RULE_NORMAL||LA5_2==RULE_ID||(LA5_2>=14 && LA5_2<=16)) ) {
                    alt5=1;
                }
            }
            switch (alt5) {
                case 1 :
                    // InternalOBJ.g:392:3: rule__Geometry__VertexSourceAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Geometry__VertexSourceAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGeometryAccess().getVertexSourceAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Geometry__Group__0__Impl"


    // $ANTLR start "rule__Geometry__Group__1"
    // InternalOBJ.g:400:1: rule__Geometry__Group__1 : rule__Geometry__Group__1__Impl ;
    public final void rule__Geometry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:404:1: ( rule__Geometry__Group__1__Impl )
            // InternalOBJ.g:405:2: rule__Geometry__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Geometry__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Geometry__Group__1"


    // $ANTLR start "rule__Geometry__Group__1__Impl"
    // InternalOBJ.g:411:1: rule__Geometry__Group__1__Impl : ( ( rule__Geometry__NodesAssignment_1 )* ) ;
    public final void rule__Geometry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:415:1: ( ( ( rule__Geometry__NodesAssignment_1 )* ) )
            // InternalOBJ.g:416:1: ( ( rule__Geometry__NodesAssignment_1 )* )
            {
            // InternalOBJ.g:416:1: ( ( rule__Geometry__NodesAssignment_1 )* )
            // InternalOBJ.g:417:2: ( rule__Geometry__NodesAssignment_1 )*
            {
             before(grammarAccess.getGeometryAccess().getNodesAssignment_1()); 
            // InternalOBJ.g:418:2: ( rule__Geometry__NodesAssignment_1 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==14) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalOBJ.g:418:3: rule__Geometry__NodesAssignment_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__Geometry__NodesAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getGeometryAccess().getNodesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Geometry__Group__1__Impl"


    // $ANTLR start "rule__VertexSource__Group__0"
    // InternalOBJ.g:427:1: rule__VertexSource__Group__0 : rule__VertexSource__Group__0__Impl rule__VertexSource__Group__1 ;
    public final void rule__VertexSource__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:431:1: ( rule__VertexSource__Group__0__Impl rule__VertexSource__Group__1 )
            // InternalOBJ.g:432:2: rule__VertexSource__Group__0__Impl rule__VertexSource__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__VertexSource__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VertexSource__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VertexSource__Group__0"


    // $ANTLR start "rule__VertexSource__Group__0__Impl"
    // InternalOBJ.g:439:1: rule__VertexSource__Group__0__Impl : ( () ) ;
    public final void rule__VertexSource__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:443:1: ( ( () ) )
            // InternalOBJ.g:444:1: ( () )
            {
            // InternalOBJ.g:444:1: ( () )
            // InternalOBJ.g:445:2: ()
            {
             before(grammarAccess.getVertexSourceAccess().getVertexSourceAction_0()); 
            // InternalOBJ.g:446:2: ()
            // InternalOBJ.g:446:3: 
            {
            }

             after(grammarAccess.getVertexSourceAccess().getVertexSourceAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VertexSource__Group__0__Impl"


    // $ANTLR start "rule__VertexSource__Group__1"
    // InternalOBJ.g:454:1: rule__VertexSource__Group__1 : rule__VertexSource__Group__1__Impl rule__VertexSource__Group__2 ;
    public final void rule__VertexSource__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:458:1: ( rule__VertexSource__Group__1__Impl rule__VertexSource__Group__2 )
            // InternalOBJ.g:459:2: rule__VertexSource__Group__1__Impl rule__VertexSource__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__VertexSource__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VertexSource__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VertexSource__Group__1"


    // $ANTLR start "rule__VertexSource__Group__1__Impl"
    // InternalOBJ.g:466:1: rule__VertexSource__Group__1__Impl : ( ( rule__VertexSource__MaterialFilesAssignment_1 )* ) ;
    public final void rule__VertexSource__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:470:1: ( ( ( rule__VertexSource__MaterialFilesAssignment_1 )* ) )
            // InternalOBJ.g:471:1: ( ( rule__VertexSource__MaterialFilesAssignment_1 )* )
            {
            // InternalOBJ.g:471:1: ( ( rule__VertexSource__MaterialFilesAssignment_1 )* )
            // InternalOBJ.g:472:2: ( rule__VertexSource__MaterialFilesAssignment_1 )*
            {
             before(grammarAccess.getVertexSourceAccess().getMaterialFilesAssignment_1()); 
            // InternalOBJ.g:473:2: ( rule__VertexSource__MaterialFilesAssignment_1 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=RULE_STRING && LA7_0<=RULE_ID)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalOBJ.g:473:3: rule__VertexSource__MaterialFilesAssignment_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__VertexSource__MaterialFilesAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getVertexSourceAccess().getMaterialFilesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VertexSource__Group__1__Impl"


    // $ANTLR start "rule__VertexSource__Group__2"
    // InternalOBJ.g:481:1: rule__VertexSource__Group__2 : rule__VertexSource__Group__2__Impl rule__VertexSource__Group__3 ;
    public final void rule__VertexSource__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:485:1: ( rule__VertexSource__Group__2__Impl rule__VertexSource__Group__3 )
            // InternalOBJ.g:486:2: rule__VertexSource__Group__2__Impl rule__VertexSource__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__VertexSource__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VertexSource__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VertexSource__Group__2"


    // $ANTLR start "rule__VertexSource__Group__2__Impl"
    // InternalOBJ.g:493:1: rule__VertexSource__Group__2__Impl : ( 'g' ) ;
    public final void rule__VertexSource__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:497:1: ( ( 'g' ) )
            // InternalOBJ.g:498:1: ( 'g' )
            {
            // InternalOBJ.g:498:1: ( 'g' )
            // InternalOBJ.g:499:2: 'g'
            {
             before(grammarAccess.getVertexSourceAccess().getGKeyword_2()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getVertexSourceAccess().getGKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VertexSource__Group__2__Impl"


    // $ANTLR start "rule__VertexSource__Group__3"
    // InternalOBJ.g:508:1: rule__VertexSource__Group__3 : rule__VertexSource__Group__3__Impl rule__VertexSource__Group__4 ;
    public final void rule__VertexSource__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:512:1: ( rule__VertexSource__Group__3__Impl rule__VertexSource__Group__4 )
            // InternalOBJ.g:513:2: rule__VertexSource__Group__3__Impl rule__VertexSource__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__VertexSource__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VertexSource__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VertexSource__Group__3"


    // $ANTLR start "rule__VertexSource__Group__3__Impl"
    // InternalOBJ.g:520:1: rule__VertexSource__Group__3__Impl : ( ( ruleEString )? ) ;
    public final void rule__VertexSource__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:524:1: ( ( ( ruleEString )? ) )
            // InternalOBJ.g:525:1: ( ( ruleEString )? )
            {
            // InternalOBJ.g:525:1: ( ( ruleEString )? )
            // InternalOBJ.g:526:2: ( ruleEString )?
            {
             before(grammarAccess.getVertexSourceAccess().getEStringParserRuleCall_3()); 
            // InternalOBJ.g:527:2: ( ruleEString )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=RULE_STRING && LA8_0<=RULE_ID)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalOBJ.g:527:3: ruleEString
                    {
                    pushFollow(FOLLOW_2);
                    ruleEString();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVertexSourceAccess().getEStringParserRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VertexSource__Group__3__Impl"


    // $ANTLR start "rule__VertexSource__Group__4"
    // InternalOBJ.g:535:1: rule__VertexSource__Group__4 : rule__VertexSource__Group__4__Impl ;
    public final void rule__VertexSource__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:539:1: ( rule__VertexSource__Group__4__Impl )
            // InternalOBJ.g:540:2: rule__VertexSource__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VertexSource__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VertexSource__Group__4"


    // $ANTLR start "rule__VertexSource__Group__4__Impl"
    // InternalOBJ.g:546:1: rule__VertexSource__Group__4__Impl : ( ( rule__VertexSource__Alternatives_4 )* ) ;
    public final void rule__VertexSource__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:550:1: ( ( ( rule__VertexSource__Alternatives_4 )* ) )
            // InternalOBJ.g:551:1: ( ( rule__VertexSource__Alternatives_4 )* )
            {
            // InternalOBJ.g:551:1: ( ( rule__VertexSource__Alternatives_4 )* )
            // InternalOBJ.g:552:2: ( rule__VertexSource__Alternatives_4 )*
            {
             before(grammarAccess.getVertexSourceAccess().getAlternatives_4()); 
            // InternalOBJ.g:553:2: ( rule__VertexSource__Alternatives_4 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_NORMAL||(LA9_0>=15 && LA9_0<=16)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalOBJ.g:553:3: rule__VertexSource__Alternatives_4
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__VertexSource__Alternatives_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getVertexSourceAccess().getAlternatives_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VertexSource__Group__4__Impl"


    // $ANTLR start "rule__VertexSource__Group_4_0__0"
    // InternalOBJ.g:562:1: rule__VertexSource__Group_4_0__0 : rule__VertexSource__Group_4_0__0__Impl rule__VertexSource__Group_4_0__1 ;
    public final void rule__VertexSource__Group_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:566:1: ( rule__VertexSource__Group_4_0__0__Impl rule__VertexSource__Group_4_0__1 )
            // InternalOBJ.g:567:2: rule__VertexSource__Group_4_0__0__Impl rule__VertexSource__Group_4_0__1
            {
            pushFollow(FOLLOW_9);
            rule__VertexSource__Group_4_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VertexSource__Group_4_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VertexSource__Group_4_0__0"


    // $ANTLR start "rule__VertexSource__Group_4_0__0__Impl"
    // InternalOBJ.g:574:1: rule__VertexSource__Group_4_0__0__Impl : ( 'v' ) ;
    public final void rule__VertexSource__Group_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:578:1: ( ( 'v' ) )
            // InternalOBJ.g:579:1: ( 'v' )
            {
            // InternalOBJ.g:579:1: ( 'v' )
            // InternalOBJ.g:580:2: 'v'
            {
             before(grammarAccess.getVertexSourceAccess().getVKeyword_4_0_0()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getVertexSourceAccess().getVKeyword_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VertexSource__Group_4_0__0__Impl"


    // $ANTLR start "rule__VertexSource__Group_4_0__1"
    // InternalOBJ.g:589:1: rule__VertexSource__Group_4_0__1 : rule__VertexSource__Group_4_0__1__Impl ;
    public final void rule__VertexSource__Group_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:593:1: ( rule__VertexSource__Group_4_0__1__Impl )
            // InternalOBJ.g:594:2: rule__VertexSource__Group_4_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VertexSource__Group_4_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VertexSource__Group_4_0__1"


    // $ANTLR start "rule__VertexSource__Group_4_0__1__Impl"
    // InternalOBJ.g:600:1: rule__VertexSource__Group_4_0__1__Impl : ( ( rule__VertexSource__VerticesAssignment_4_0_1 ) ) ;
    public final void rule__VertexSource__Group_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:604:1: ( ( ( rule__VertexSource__VerticesAssignment_4_0_1 ) ) )
            // InternalOBJ.g:605:1: ( ( rule__VertexSource__VerticesAssignment_4_0_1 ) )
            {
            // InternalOBJ.g:605:1: ( ( rule__VertexSource__VerticesAssignment_4_0_1 ) )
            // InternalOBJ.g:606:2: ( rule__VertexSource__VerticesAssignment_4_0_1 )
            {
             before(grammarAccess.getVertexSourceAccess().getVerticesAssignment_4_0_1()); 
            // InternalOBJ.g:607:2: ( rule__VertexSource__VerticesAssignment_4_0_1 )
            // InternalOBJ.g:607:3: rule__VertexSource__VerticesAssignment_4_0_1
            {
            pushFollow(FOLLOW_2);
            rule__VertexSource__VerticesAssignment_4_0_1();

            state._fsp--;


            }

             after(grammarAccess.getVertexSourceAccess().getVerticesAssignment_4_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VertexSource__Group_4_0__1__Impl"


    // $ANTLR start "rule__VertexSource__Group_4_1__0"
    // InternalOBJ.g:616:1: rule__VertexSource__Group_4_1__0 : rule__VertexSource__Group_4_1__0__Impl rule__VertexSource__Group_4_1__1 ;
    public final void rule__VertexSource__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:620:1: ( rule__VertexSource__Group_4_1__0__Impl rule__VertexSource__Group_4_1__1 )
            // InternalOBJ.g:621:2: rule__VertexSource__Group_4_1__0__Impl rule__VertexSource__Group_4_1__1
            {
            pushFollow(FOLLOW_9);
            rule__VertexSource__Group_4_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VertexSource__Group_4_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VertexSource__Group_4_1__0"


    // $ANTLR start "rule__VertexSource__Group_4_1__0__Impl"
    // InternalOBJ.g:628:1: rule__VertexSource__Group_4_1__0__Impl : ( 'vt' ) ;
    public final void rule__VertexSource__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:632:1: ( ( 'vt' ) )
            // InternalOBJ.g:633:1: ( 'vt' )
            {
            // InternalOBJ.g:633:1: ( 'vt' )
            // InternalOBJ.g:634:2: 'vt'
            {
             before(grammarAccess.getVertexSourceAccess().getVtKeyword_4_1_0()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getVertexSourceAccess().getVtKeyword_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VertexSource__Group_4_1__0__Impl"


    // $ANTLR start "rule__VertexSource__Group_4_1__1"
    // InternalOBJ.g:643:1: rule__VertexSource__Group_4_1__1 : rule__VertexSource__Group_4_1__1__Impl ;
    public final void rule__VertexSource__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:647:1: ( rule__VertexSource__Group_4_1__1__Impl )
            // InternalOBJ.g:648:2: rule__VertexSource__Group_4_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VertexSource__Group_4_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VertexSource__Group_4_1__1"


    // $ANTLR start "rule__VertexSource__Group_4_1__1__Impl"
    // InternalOBJ.g:654:1: rule__VertexSource__Group_4_1__1__Impl : ( ( rule__VertexSource__TextureCoordinatesAssignment_4_1_1 ) ) ;
    public final void rule__VertexSource__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:658:1: ( ( ( rule__VertexSource__TextureCoordinatesAssignment_4_1_1 ) ) )
            // InternalOBJ.g:659:1: ( ( rule__VertexSource__TextureCoordinatesAssignment_4_1_1 ) )
            {
            // InternalOBJ.g:659:1: ( ( rule__VertexSource__TextureCoordinatesAssignment_4_1_1 ) )
            // InternalOBJ.g:660:2: ( rule__VertexSource__TextureCoordinatesAssignment_4_1_1 )
            {
             before(grammarAccess.getVertexSourceAccess().getTextureCoordinatesAssignment_4_1_1()); 
            // InternalOBJ.g:661:2: ( rule__VertexSource__TextureCoordinatesAssignment_4_1_1 )
            // InternalOBJ.g:661:3: rule__VertexSource__TextureCoordinatesAssignment_4_1_1
            {
            pushFollow(FOLLOW_2);
            rule__VertexSource__TextureCoordinatesAssignment_4_1_1();

            state._fsp--;


            }

             after(grammarAccess.getVertexSourceAccess().getTextureCoordinatesAssignment_4_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VertexSource__Group_4_1__1__Impl"


    // $ANTLR start "rule__PolyShape__Group__0"
    // InternalOBJ.g:670:1: rule__PolyShape__Group__0 : rule__PolyShape__Group__0__Impl rule__PolyShape__Group__1 ;
    public final void rule__PolyShape__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:674:1: ( rule__PolyShape__Group__0__Impl rule__PolyShape__Group__1 )
            // InternalOBJ.g:675:2: rule__PolyShape__Group__0__Impl rule__PolyShape__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__PolyShape__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PolyShape__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PolyShape__Group__0"


    // $ANTLR start "rule__PolyShape__Group__0__Impl"
    // InternalOBJ.g:682:1: rule__PolyShape__Group__0__Impl : ( 'g' ) ;
    public final void rule__PolyShape__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:686:1: ( ( 'g' ) )
            // InternalOBJ.g:687:1: ( 'g' )
            {
            // InternalOBJ.g:687:1: ( 'g' )
            // InternalOBJ.g:688:2: 'g'
            {
             before(grammarAccess.getPolyShapeAccess().getGKeyword_0()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getPolyShapeAccess().getGKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PolyShape__Group__0__Impl"


    // $ANTLR start "rule__PolyShape__Group__1"
    // InternalOBJ.g:697:1: rule__PolyShape__Group__1 : rule__PolyShape__Group__1__Impl rule__PolyShape__Group__2 ;
    public final void rule__PolyShape__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:701:1: ( rule__PolyShape__Group__1__Impl rule__PolyShape__Group__2 )
            // InternalOBJ.g:702:2: rule__PolyShape__Group__1__Impl rule__PolyShape__Group__2
            {
            pushFollow(FOLLOW_11);
            rule__PolyShape__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PolyShape__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PolyShape__Group__1"


    // $ANTLR start "rule__PolyShape__Group__1__Impl"
    // InternalOBJ.g:709:1: rule__PolyShape__Group__1__Impl : ( ( rule__PolyShape__NameAssignment_1 ) ) ;
    public final void rule__PolyShape__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:713:1: ( ( ( rule__PolyShape__NameAssignment_1 ) ) )
            // InternalOBJ.g:714:1: ( ( rule__PolyShape__NameAssignment_1 ) )
            {
            // InternalOBJ.g:714:1: ( ( rule__PolyShape__NameAssignment_1 ) )
            // InternalOBJ.g:715:2: ( rule__PolyShape__NameAssignment_1 )
            {
             before(grammarAccess.getPolyShapeAccess().getNameAssignment_1()); 
            // InternalOBJ.g:716:2: ( rule__PolyShape__NameAssignment_1 )
            // InternalOBJ.g:716:3: rule__PolyShape__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__PolyShape__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPolyShapeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PolyShape__Group__1__Impl"


    // $ANTLR start "rule__PolyShape__Group__2"
    // InternalOBJ.g:724:1: rule__PolyShape__Group__2 : rule__PolyShape__Group__2__Impl ;
    public final void rule__PolyShape__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:728:1: ( rule__PolyShape__Group__2__Impl )
            // InternalOBJ.g:729:2: rule__PolyShape__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PolyShape__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PolyShape__Group__2"


    // $ANTLR start "rule__PolyShape__Group__2__Impl"
    // InternalOBJ.g:735:1: rule__PolyShape__Group__2__Impl : ( ( rule__PolyShape__Group_2__0 )* ) ;
    public final void rule__PolyShape__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:739:1: ( ( ( rule__PolyShape__Group_2__0 )* ) )
            // InternalOBJ.g:740:1: ( ( rule__PolyShape__Group_2__0 )* )
            {
            // InternalOBJ.g:740:1: ( ( rule__PolyShape__Group_2__0 )* )
            // InternalOBJ.g:741:2: ( rule__PolyShape__Group_2__0 )*
            {
             before(grammarAccess.getPolyShapeAccess().getGroup_2()); 
            // InternalOBJ.g:742:2: ( rule__PolyShape__Group_2__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==17) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalOBJ.g:742:3: rule__PolyShape__Group_2__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__PolyShape__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getPolyShapeAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PolyShape__Group__2__Impl"


    // $ANTLR start "rule__PolyShape__Group_2__0"
    // InternalOBJ.g:751:1: rule__PolyShape__Group_2__0 : rule__PolyShape__Group_2__0__Impl rule__PolyShape__Group_2__1 ;
    public final void rule__PolyShape__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:755:1: ( rule__PolyShape__Group_2__0__Impl rule__PolyShape__Group_2__1 )
            // InternalOBJ.g:756:2: rule__PolyShape__Group_2__0__Impl rule__PolyShape__Group_2__1
            {
            pushFollow(FOLLOW_9);
            rule__PolyShape__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PolyShape__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PolyShape__Group_2__0"


    // $ANTLR start "rule__PolyShape__Group_2__0__Impl"
    // InternalOBJ.g:763:1: rule__PolyShape__Group_2__0__Impl : ( 'f' ) ;
    public final void rule__PolyShape__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:767:1: ( ( 'f' ) )
            // InternalOBJ.g:768:1: ( 'f' )
            {
            // InternalOBJ.g:768:1: ( 'f' )
            // InternalOBJ.g:769:2: 'f'
            {
             before(grammarAccess.getPolyShapeAccess().getFKeyword_2_0()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getPolyShapeAccess().getFKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PolyShape__Group_2__0__Impl"


    // $ANTLR start "rule__PolyShape__Group_2__1"
    // InternalOBJ.g:778:1: rule__PolyShape__Group_2__1 : rule__PolyShape__Group_2__1__Impl ;
    public final void rule__PolyShape__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:782:1: ( rule__PolyShape__Group_2__1__Impl )
            // InternalOBJ.g:783:2: rule__PolyShape__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PolyShape__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PolyShape__Group_2__1"


    // $ANTLR start "rule__PolyShape__Group_2__1__Impl"
    // InternalOBJ.g:789:1: rule__PolyShape__Group_2__1__Impl : ( ( rule__PolyShape__FacesAssignment_2_1 ) ) ;
    public final void rule__PolyShape__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:793:1: ( ( ( rule__PolyShape__FacesAssignment_2_1 ) ) )
            // InternalOBJ.g:794:1: ( ( rule__PolyShape__FacesAssignment_2_1 ) )
            {
            // InternalOBJ.g:794:1: ( ( rule__PolyShape__FacesAssignment_2_1 ) )
            // InternalOBJ.g:795:2: ( rule__PolyShape__FacesAssignment_2_1 )
            {
             before(grammarAccess.getPolyShapeAccess().getFacesAssignment_2_1()); 
            // InternalOBJ.g:796:2: ( rule__PolyShape__FacesAssignment_2_1 )
            // InternalOBJ.g:796:3: rule__PolyShape__FacesAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__PolyShape__FacesAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getPolyShapeAccess().getFacesAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PolyShape__Group_2__1__Impl"


    // $ANTLR start "rule__Face__Group__0"
    // InternalOBJ.g:805:1: rule__Face__Group__0 : rule__Face__Group__0__Impl rule__Face__Group__1 ;
    public final void rule__Face__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:809:1: ( rule__Face__Group__0__Impl rule__Face__Group__1 )
            // InternalOBJ.g:810:2: rule__Face__Group__0__Impl rule__Face__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__Face__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Face__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Face__Group__0"


    // $ANTLR start "rule__Face__Group__0__Impl"
    // InternalOBJ.g:817:1: rule__Face__Group__0__Impl : ( () ) ;
    public final void rule__Face__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:821:1: ( ( () ) )
            // InternalOBJ.g:822:1: ( () )
            {
            // InternalOBJ.g:822:1: ( () )
            // InternalOBJ.g:823:2: ()
            {
             before(grammarAccess.getFaceAccess().getFaceAction_0()); 
            // InternalOBJ.g:824:2: ()
            // InternalOBJ.g:824:3: 
            {
            }

             after(grammarAccess.getFaceAccess().getFaceAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Face__Group__0__Impl"


    // $ANTLR start "rule__Face__Group__1"
    // InternalOBJ.g:832:1: rule__Face__Group__1 : rule__Face__Group__1__Impl ;
    public final void rule__Face__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:836:1: ( rule__Face__Group__1__Impl )
            // InternalOBJ.g:837:2: rule__Face__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Face__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Face__Group__1"


    // $ANTLR start "rule__Face__Group__1__Impl"
    // InternalOBJ.g:843:1: rule__Face__Group__1__Impl : ( ( rule__Face__Group_1__0 )* ) ;
    public final void rule__Face__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:847:1: ( ( ( rule__Face__Group_1__0 )* ) )
            // InternalOBJ.g:848:1: ( ( rule__Face__Group_1__0 )* )
            {
            // InternalOBJ.g:848:1: ( ( rule__Face__Group_1__0 )* )
            // InternalOBJ.g:849:2: ( rule__Face__Group_1__0 )*
            {
             before(grammarAccess.getFaceAccess().getGroup_1()); 
            // InternalOBJ.g:850:2: ( rule__Face__Group_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_INT||LA11_0==19) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalOBJ.g:850:3: rule__Face__Group_1__0
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__Face__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getFaceAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Face__Group__1__Impl"


    // $ANTLR start "rule__Face__Group_1__0"
    // InternalOBJ.g:859:1: rule__Face__Group_1__0 : rule__Face__Group_1__0__Impl rule__Face__Group_1__1 ;
    public final void rule__Face__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:863:1: ( rule__Face__Group_1__0__Impl rule__Face__Group_1__1 )
            // InternalOBJ.g:864:2: rule__Face__Group_1__0__Impl rule__Face__Group_1__1
            {
            pushFollow(FOLLOW_14);
            rule__Face__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Face__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Face__Group_1__0"


    // $ANTLR start "rule__Face__Group_1__0__Impl"
    // InternalOBJ.g:871:1: rule__Face__Group_1__0__Impl : ( ( rule__Face__VertexIndicesAssignment_1_0 ) ) ;
    public final void rule__Face__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:875:1: ( ( ( rule__Face__VertexIndicesAssignment_1_0 ) ) )
            // InternalOBJ.g:876:1: ( ( rule__Face__VertexIndicesAssignment_1_0 ) )
            {
            // InternalOBJ.g:876:1: ( ( rule__Face__VertexIndicesAssignment_1_0 ) )
            // InternalOBJ.g:877:2: ( rule__Face__VertexIndicesAssignment_1_0 )
            {
             before(grammarAccess.getFaceAccess().getVertexIndicesAssignment_1_0()); 
            // InternalOBJ.g:878:2: ( rule__Face__VertexIndicesAssignment_1_0 )
            // InternalOBJ.g:878:3: rule__Face__VertexIndicesAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Face__VertexIndicesAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getFaceAccess().getVertexIndicesAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Face__Group_1__0__Impl"


    // $ANTLR start "rule__Face__Group_1__1"
    // InternalOBJ.g:886:1: rule__Face__Group_1__1 : rule__Face__Group_1__1__Impl ;
    public final void rule__Face__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:890:1: ( rule__Face__Group_1__1__Impl )
            // InternalOBJ.g:891:2: rule__Face__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Face__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Face__Group_1__1"


    // $ANTLR start "rule__Face__Group_1__1__Impl"
    // InternalOBJ.g:897:1: rule__Face__Group_1__1__Impl : ( ( rule__Face__Group_1_1__0 )? ) ;
    public final void rule__Face__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:901:1: ( ( ( rule__Face__Group_1_1__0 )? ) )
            // InternalOBJ.g:902:1: ( ( rule__Face__Group_1_1__0 )? )
            {
            // InternalOBJ.g:902:1: ( ( rule__Face__Group_1_1__0 )? )
            // InternalOBJ.g:903:2: ( rule__Face__Group_1_1__0 )?
            {
             before(grammarAccess.getFaceAccess().getGroup_1_1()); 
            // InternalOBJ.g:904:2: ( rule__Face__Group_1_1__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==18) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalOBJ.g:904:3: rule__Face__Group_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Face__Group_1_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFaceAccess().getGroup_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Face__Group_1__1__Impl"


    // $ANTLR start "rule__Face__Group_1_1__0"
    // InternalOBJ.g:913:1: rule__Face__Group_1_1__0 : rule__Face__Group_1_1__0__Impl rule__Face__Group_1_1__1 ;
    public final void rule__Face__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:917:1: ( rule__Face__Group_1_1__0__Impl rule__Face__Group_1_1__1 )
            // InternalOBJ.g:918:2: rule__Face__Group_1_1__0__Impl rule__Face__Group_1_1__1
            {
            pushFollow(FOLLOW_15);
            rule__Face__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Face__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Face__Group_1_1__0"


    // $ANTLR start "rule__Face__Group_1_1__0__Impl"
    // InternalOBJ.g:925:1: rule__Face__Group_1_1__0__Impl : ( '/' ) ;
    public final void rule__Face__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:929:1: ( ( '/' ) )
            // InternalOBJ.g:930:1: ( '/' )
            {
            // InternalOBJ.g:930:1: ( '/' )
            // InternalOBJ.g:931:2: '/'
            {
             before(grammarAccess.getFaceAccess().getSolidusKeyword_1_1_0()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getFaceAccess().getSolidusKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Face__Group_1_1__0__Impl"


    // $ANTLR start "rule__Face__Group_1_1__1"
    // InternalOBJ.g:940:1: rule__Face__Group_1_1__1 : rule__Face__Group_1_1__1__Impl ;
    public final void rule__Face__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:944:1: ( rule__Face__Group_1_1__1__Impl )
            // InternalOBJ.g:945:2: rule__Face__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Face__Group_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Face__Group_1_1__1"


    // $ANTLR start "rule__Face__Group_1_1__1__Impl"
    // InternalOBJ.g:951:1: rule__Face__Group_1_1__1__Impl : ( ( rule__Face__Alternatives_1_1_1 ) ) ;
    public final void rule__Face__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:955:1: ( ( ( rule__Face__Alternatives_1_1_1 ) ) )
            // InternalOBJ.g:956:1: ( ( rule__Face__Alternatives_1_1_1 ) )
            {
            // InternalOBJ.g:956:1: ( ( rule__Face__Alternatives_1_1_1 ) )
            // InternalOBJ.g:957:2: ( rule__Face__Alternatives_1_1_1 )
            {
             before(grammarAccess.getFaceAccess().getAlternatives_1_1_1()); 
            // InternalOBJ.g:958:2: ( rule__Face__Alternatives_1_1_1 )
            // InternalOBJ.g:958:3: rule__Face__Alternatives_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Face__Alternatives_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getFaceAccess().getAlternatives_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Face__Group_1_1__1__Impl"


    // $ANTLR start "rule__Face__Group_1_1_1_1__0"
    // InternalOBJ.g:967:1: rule__Face__Group_1_1_1_1__0 : rule__Face__Group_1_1_1_1__0__Impl rule__Face__Group_1_1_1_1__1 ;
    public final void rule__Face__Group_1_1_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:971:1: ( rule__Face__Group_1_1_1_1__0__Impl rule__Face__Group_1_1_1_1__1 )
            // InternalOBJ.g:972:2: rule__Face__Group_1_1_1_1__0__Impl rule__Face__Group_1_1_1_1__1
            {
            pushFollow(FOLLOW_14);
            rule__Face__Group_1_1_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Face__Group_1_1_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Face__Group_1_1_1_1__0"


    // $ANTLR start "rule__Face__Group_1_1_1_1__0__Impl"
    // InternalOBJ.g:979:1: rule__Face__Group_1_1_1_1__0__Impl : ( ( rule__Face__TextureIndicesAssignment_1_1_1_1_0 ) ) ;
    public final void rule__Face__Group_1_1_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:983:1: ( ( ( rule__Face__TextureIndicesAssignment_1_1_1_1_0 ) ) )
            // InternalOBJ.g:984:1: ( ( rule__Face__TextureIndicesAssignment_1_1_1_1_0 ) )
            {
            // InternalOBJ.g:984:1: ( ( rule__Face__TextureIndicesAssignment_1_1_1_1_0 ) )
            // InternalOBJ.g:985:2: ( rule__Face__TextureIndicesAssignment_1_1_1_1_0 )
            {
             before(grammarAccess.getFaceAccess().getTextureIndicesAssignment_1_1_1_1_0()); 
            // InternalOBJ.g:986:2: ( rule__Face__TextureIndicesAssignment_1_1_1_1_0 )
            // InternalOBJ.g:986:3: rule__Face__TextureIndicesAssignment_1_1_1_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Face__TextureIndicesAssignment_1_1_1_1_0();

            state._fsp--;


            }

             after(grammarAccess.getFaceAccess().getTextureIndicesAssignment_1_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Face__Group_1_1_1_1__0__Impl"


    // $ANTLR start "rule__Face__Group_1_1_1_1__1"
    // InternalOBJ.g:994:1: rule__Face__Group_1_1_1_1__1 : rule__Face__Group_1_1_1_1__1__Impl rule__Face__Group_1_1_1_1__2 ;
    public final void rule__Face__Group_1_1_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:998:1: ( rule__Face__Group_1_1_1_1__1__Impl rule__Face__Group_1_1_1_1__2 )
            // InternalOBJ.g:999:2: rule__Face__Group_1_1_1_1__1__Impl rule__Face__Group_1_1_1_1__2
            {
            pushFollow(FOLLOW_9);
            rule__Face__Group_1_1_1_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Face__Group_1_1_1_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Face__Group_1_1_1_1__1"


    // $ANTLR start "rule__Face__Group_1_1_1_1__1__Impl"
    // InternalOBJ.g:1006:1: rule__Face__Group_1_1_1_1__1__Impl : ( '/' ) ;
    public final void rule__Face__Group_1_1_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1010:1: ( ( '/' ) )
            // InternalOBJ.g:1011:1: ( '/' )
            {
            // InternalOBJ.g:1011:1: ( '/' )
            // InternalOBJ.g:1012:2: '/'
            {
             before(grammarAccess.getFaceAccess().getSolidusKeyword_1_1_1_1_1()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getFaceAccess().getSolidusKeyword_1_1_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Face__Group_1_1_1_1__1__Impl"


    // $ANTLR start "rule__Face__Group_1_1_1_1__2"
    // InternalOBJ.g:1021:1: rule__Face__Group_1_1_1_1__2 : rule__Face__Group_1_1_1_1__2__Impl ;
    public final void rule__Face__Group_1_1_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1025:1: ( rule__Face__Group_1_1_1_1__2__Impl )
            // InternalOBJ.g:1026:2: rule__Face__Group_1_1_1_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Face__Group_1_1_1_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Face__Group_1_1_1_1__2"


    // $ANTLR start "rule__Face__Group_1_1_1_1__2__Impl"
    // InternalOBJ.g:1032:1: rule__Face__Group_1_1_1_1__2__Impl : ( ruleEInt ) ;
    public final void rule__Face__Group_1_1_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1036:1: ( ( ruleEInt ) )
            // InternalOBJ.g:1037:1: ( ruleEInt )
            {
            // InternalOBJ.g:1037:1: ( ruleEInt )
            // InternalOBJ.g:1038:2: ruleEInt
            {
             before(grammarAccess.getFaceAccess().getEIntParserRuleCall_1_1_1_1_2()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getFaceAccess().getEIntParserRuleCall_1_1_1_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Face__Group_1_1_1_1__2__Impl"


    // $ANTLR start "rule__Face__Group_1_1_1_2__0"
    // InternalOBJ.g:1048:1: rule__Face__Group_1_1_1_2__0 : rule__Face__Group_1_1_1_2__0__Impl rule__Face__Group_1_1_1_2__1 ;
    public final void rule__Face__Group_1_1_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1052:1: ( rule__Face__Group_1_1_1_2__0__Impl rule__Face__Group_1_1_1_2__1 )
            // InternalOBJ.g:1053:2: rule__Face__Group_1_1_1_2__0__Impl rule__Face__Group_1_1_1_2__1
            {
            pushFollow(FOLLOW_9);
            rule__Face__Group_1_1_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Face__Group_1_1_1_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Face__Group_1_1_1_2__0"


    // $ANTLR start "rule__Face__Group_1_1_1_2__0__Impl"
    // InternalOBJ.g:1060:1: rule__Face__Group_1_1_1_2__0__Impl : ( '/' ) ;
    public final void rule__Face__Group_1_1_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1064:1: ( ( '/' ) )
            // InternalOBJ.g:1065:1: ( '/' )
            {
            // InternalOBJ.g:1065:1: ( '/' )
            // InternalOBJ.g:1066:2: '/'
            {
             before(grammarAccess.getFaceAccess().getSolidusKeyword_1_1_1_2_0()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getFaceAccess().getSolidusKeyword_1_1_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Face__Group_1_1_1_2__0__Impl"


    // $ANTLR start "rule__Face__Group_1_1_1_2__1"
    // InternalOBJ.g:1075:1: rule__Face__Group_1_1_1_2__1 : rule__Face__Group_1_1_1_2__1__Impl ;
    public final void rule__Face__Group_1_1_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1079:1: ( rule__Face__Group_1_1_1_2__1__Impl )
            // InternalOBJ.g:1080:2: rule__Face__Group_1_1_1_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Face__Group_1_1_1_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Face__Group_1_1_1_2__1"


    // $ANTLR start "rule__Face__Group_1_1_1_2__1__Impl"
    // InternalOBJ.g:1086:1: rule__Face__Group_1_1_1_2__1__Impl : ( ruleEInt ) ;
    public final void rule__Face__Group_1_1_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1090:1: ( ( ruleEInt ) )
            // InternalOBJ.g:1091:1: ( ruleEInt )
            {
            // InternalOBJ.g:1091:1: ( ruleEInt )
            // InternalOBJ.g:1092:2: ruleEInt
            {
             before(grammarAccess.getFaceAccess().getEIntParserRuleCall_1_1_1_2_1()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getFaceAccess().getEIntParserRuleCall_1_1_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Face__Group_1_1_1_2__1__Impl"


    // $ANTLR start "rule__Vertex__Group__0"
    // InternalOBJ.g:1102:1: rule__Vertex__Group__0 : rule__Vertex__Group__0__Impl rule__Vertex__Group__1 ;
    public final void rule__Vertex__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1106:1: ( rule__Vertex__Group__0__Impl rule__Vertex__Group__1 )
            // InternalOBJ.g:1107:2: rule__Vertex__Group__0__Impl rule__Vertex__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__Vertex__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Vertex__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Vertex__Group__0"


    // $ANTLR start "rule__Vertex__Group__0__Impl"
    // InternalOBJ.g:1114:1: rule__Vertex__Group__0__Impl : ( () ) ;
    public final void rule__Vertex__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1118:1: ( ( () ) )
            // InternalOBJ.g:1119:1: ( () )
            {
            // InternalOBJ.g:1119:1: ( () )
            // InternalOBJ.g:1120:2: ()
            {
             before(grammarAccess.getVertexAccess().getVertexAction_0()); 
            // InternalOBJ.g:1121:2: ()
            // InternalOBJ.g:1121:3: 
            {
            }

             after(grammarAccess.getVertexAccess().getVertexAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Vertex__Group__0__Impl"


    // $ANTLR start "rule__Vertex__Group__1"
    // InternalOBJ.g:1129:1: rule__Vertex__Group__1 : rule__Vertex__Group__1__Impl rule__Vertex__Group__2 ;
    public final void rule__Vertex__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1133:1: ( rule__Vertex__Group__1__Impl rule__Vertex__Group__2 )
            // InternalOBJ.g:1134:2: rule__Vertex__Group__1__Impl rule__Vertex__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__Vertex__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Vertex__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Vertex__Group__1"


    // $ANTLR start "rule__Vertex__Group__1__Impl"
    // InternalOBJ.g:1141:1: rule__Vertex__Group__1__Impl : ( ( rule__Vertex__XAssignment_1 ) ) ;
    public final void rule__Vertex__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1145:1: ( ( ( rule__Vertex__XAssignment_1 ) ) )
            // InternalOBJ.g:1146:1: ( ( rule__Vertex__XAssignment_1 ) )
            {
            // InternalOBJ.g:1146:1: ( ( rule__Vertex__XAssignment_1 ) )
            // InternalOBJ.g:1147:2: ( rule__Vertex__XAssignment_1 )
            {
             before(grammarAccess.getVertexAccess().getXAssignment_1()); 
            // InternalOBJ.g:1148:2: ( rule__Vertex__XAssignment_1 )
            // InternalOBJ.g:1148:3: rule__Vertex__XAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Vertex__XAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getVertexAccess().getXAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Vertex__Group__1__Impl"


    // $ANTLR start "rule__Vertex__Group__2"
    // InternalOBJ.g:1156:1: rule__Vertex__Group__2 : rule__Vertex__Group__2__Impl rule__Vertex__Group__3 ;
    public final void rule__Vertex__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1160:1: ( rule__Vertex__Group__2__Impl rule__Vertex__Group__3 )
            // InternalOBJ.g:1161:2: rule__Vertex__Group__2__Impl rule__Vertex__Group__3
            {
            pushFollow(FOLLOW_9);
            rule__Vertex__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Vertex__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Vertex__Group__2"


    // $ANTLR start "rule__Vertex__Group__2__Impl"
    // InternalOBJ.g:1168:1: rule__Vertex__Group__2__Impl : ( ( rule__Vertex__YAssignment_2 ) ) ;
    public final void rule__Vertex__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1172:1: ( ( ( rule__Vertex__YAssignment_2 ) ) )
            // InternalOBJ.g:1173:1: ( ( rule__Vertex__YAssignment_2 ) )
            {
            // InternalOBJ.g:1173:1: ( ( rule__Vertex__YAssignment_2 ) )
            // InternalOBJ.g:1174:2: ( rule__Vertex__YAssignment_2 )
            {
             before(grammarAccess.getVertexAccess().getYAssignment_2()); 
            // InternalOBJ.g:1175:2: ( rule__Vertex__YAssignment_2 )
            // InternalOBJ.g:1175:3: rule__Vertex__YAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Vertex__YAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getVertexAccess().getYAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Vertex__Group__2__Impl"


    // $ANTLR start "rule__Vertex__Group__3"
    // InternalOBJ.g:1183:1: rule__Vertex__Group__3 : rule__Vertex__Group__3__Impl ;
    public final void rule__Vertex__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1187:1: ( rule__Vertex__Group__3__Impl )
            // InternalOBJ.g:1188:2: rule__Vertex__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Vertex__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Vertex__Group__3"


    // $ANTLR start "rule__Vertex__Group__3__Impl"
    // InternalOBJ.g:1194:1: rule__Vertex__Group__3__Impl : ( ( rule__Vertex__ZAssignment_3 ) ) ;
    public final void rule__Vertex__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1198:1: ( ( ( rule__Vertex__ZAssignment_3 ) ) )
            // InternalOBJ.g:1199:1: ( ( rule__Vertex__ZAssignment_3 ) )
            {
            // InternalOBJ.g:1199:1: ( ( rule__Vertex__ZAssignment_3 ) )
            // InternalOBJ.g:1200:2: ( rule__Vertex__ZAssignment_3 )
            {
             before(grammarAccess.getVertexAccess().getZAssignment_3()); 
            // InternalOBJ.g:1201:2: ( rule__Vertex__ZAssignment_3 )
            // InternalOBJ.g:1201:3: rule__Vertex__ZAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Vertex__ZAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getVertexAccess().getZAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Vertex__Group__3__Impl"


    // $ANTLR start "rule__TextureVertex__Group__0"
    // InternalOBJ.g:1210:1: rule__TextureVertex__Group__0 : rule__TextureVertex__Group__0__Impl rule__TextureVertex__Group__1 ;
    public final void rule__TextureVertex__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1214:1: ( rule__TextureVertex__Group__0__Impl rule__TextureVertex__Group__1 )
            // InternalOBJ.g:1215:2: rule__TextureVertex__Group__0__Impl rule__TextureVertex__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__TextureVertex__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextureVertex__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextureVertex__Group__0"


    // $ANTLR start "rule__TextureVertex__Group__0__Impl"
    // InternalOBJ.g:1222:1: rule__TextureVertex__Group__0__Impl : ( ( rule__TextureVertex__XAssignment_0 ) ) ;
    public final void rule__TextureVertex__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1226:1: ( ( ( rule__TextureVertex__XAssignment_0 ) ) )
            // InternalOBJ.g:1227:1: ( ( rule__TextureVertex__XAssignment_0 ) )
            {
            // InternalOBJ.g:1227:1: ( ( rule__TextureVertex__XAssignment_0 ) )
            // InternalOBJ.g:1228:2: ( rule__TextureVertex__XAssignment_0 )
            {
             before(grammarAccess.getTextureVertexAccess().getXAssignment_0()); 
            // InternalOBJ.g:1229:2: ( rule__TextureVertex__XAssignment_0 )
            // InternalOBJ.g:1229:3: rule__TextureVertex__XAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__TextureVertex__XAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getTextureVertexAccess().getXAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextureVertex__Group__0__Impl"


    // $ANTLR start "rule__TextureVertex__Group__1"
    // InternalOBJ.g:1237:1: rule__TextureVertex__Group__1 : rule__TextureVertex__Group__1__Impl rule__TextureVertex__Group__2 ;
    public final void rule__TextureVertex__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1241:1: ( rule__TextureVertex__Group__1__Impl rule__TextureVertex__Group__2 )
            // InternalOBJ.g:1242:2: rule__TextureVertex__Group__1__Impl rule__TextureVertex__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__TextureVertex__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextureVertex__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextureVertex__Group__1"


    // $ANTLR start "rule__TextureVertex__Group__1__Impl"
    // InternalOBJ.g:1249:1: rule__TextureVertex__Group__1__Impl : ( ( rule__TextureVertex__YAssignment_1 ) ) ;
    public final void rule__TextureVertex__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1253:1: ( ( ( rule__TextureVertex__YAssignment_1 ) ) )
            // InternalOBJ.g:1254:1: ( ( rule__TextureVertex__YAssignment_1 ) )
            {
            // InternalOBJ.g:1254:1: ( ( rule__TextureVertex__YAssignment_1 ) )
            // InternalOBJ.g:1255:2: ( rule__TextureVertex__YAssignment_1 )
            {
             before(grammarAccess.getTextureVertexAccess().getYAssignment_1()); 
            // InternalOBJ.g:1256:2: ( rule__TextureVertex__YAssignment_1 )
            // InternalOBJ.g:1256:3: rule__TextureVertex__YAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__TextureVertex__YAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTextureVertexAccess().getYAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextureVertex__Group__1__Impl"


    // $ANTLR start "rule__TextureVertex__Group__2"
    // InternalOBJ.g:1264:1: rule__TextureVertex__Group__2 : rule__TextureVertex__Group__2__Impl ;
    public final void rule__TextureVertex__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1268:1: ( rule__TextureVertex__Group__2__Impl )
            // InternalOBJ.g:1269:2: rule__TextureVertex__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TextureVertex__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextureVertex__Group__2"


    // $ANTLR start "rule__TextureVertex__Group__2__Impl"
    // InternalOBJ.g:1275:1: rule__TextureVertex__Group__2__Impl : ( ( rule__TextureVertex__ZAssignment_2 )? ) ;
    public final void rule__TextureVertex__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1279:1: ( ( ( rule__TextureVertex__ZAssignment_2 )? ) )
            // InternalOBJ.g:1280:1: ( ( rule__TextureVertex__ZAssignment_2 )? )
            {
            // InternalOBJ.g:1280:1: ( ( rule__TextureVertex__ZAssignment_2 )? )
            // InternalOBJ.g:1281:2: ( rule__TextureVertex__ZAssignment_2 )?
            {
             before(grammarAccess.getTextureVertexAccess().getZAssignment_2()); 
            // InternalOBJ.g:1282:2: ( rule__TextureVertex__ZAssignment_2 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=RULE_DOUBLE && LA13_0<=RULE_INT)||LA13_0==19) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalOBJ.g:1282:3: rule__TextureVertex__ZAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__TextureVertex__ZAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTextureVertexAccess().getZAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextureVertex__Group__2__Impl"


    // $ANTLR start "rule__EInt__Group__0"
    // InternalOBJ.g:1291:1: rule__EInt__Group__0 : rule__EInt__Group__0__Impl rule__EInt__Group__1 ;
    public final void rule__EInt__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1295:1: ( rule__EInt__Group__0__Impl rule__EInt__Group__1 )
            // InternalOBJ.g:1296:2: rule__EInt__Group__0__Impl rule__EInt__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__EInt__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EInt__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__0"


    // $ANTLR start "rule__EInt__Group__0__Impl"
    // InternalOBJ.g:1303:1: rule__EInt__Group__0__Impl : ( ( '-' )? ) ;
    public final void rule__EInt__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1307:1: ( ( ( '-' )? ) )
            // InternalOBJ.g:1308:1: ( ( '-' )? )
            {
            // InternalOBJ.g:1308:1: ( ( '-' )? )
            // InternalOBJ.g:1309:2: ( '-' )?
            {
             before(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
            // InternalOBJ.g:1310:2: ( '-' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==19) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalOBJ.g:1310:3: '-'
                    {
                    match(input,19,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__0__Impl"


    // $ANTLR start "rule__EInt__Group__1"
    // InternalOBJ.g:1318:1: rule__EInt__Group__1 : rule__EInt__Group__1__Impl ;
    public final void rule__EInt__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1322:1: ( rule__EInt__Group__1__Impl )
            // InternalOBJ.g:1323:2: rule__EInt__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EInt__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__1"


    // $ANTLR start "rule__EInt__Group__1__Impl"
    // InternalOBJ.g:1329:1: rule__EInt__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__EInt__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1333:1: ( ( RULE_INT ) )
            // InternalOBJ.g:1334:1: ( RULE_INT )
            {
            // InternalOBJ.g:1334:1: ( RULE_INT )
            // InternalOBJ.g:1335:2: RULE_INT
            {
             before(grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__1__Impl"


    // $ANTLR start "rule__Geometry__VertexSourceAssignment_0"
    // InternalOBJ.g:1345:1: rule__Geometry__VertexSourceAssignment_0 : ( ruleVertexSource ) ;
    public final void rule__Geometry__VertexSourceAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1349:1: ( ( ruleVertexSource ) )
            // InternalOBJ.g:1350:2: ( ruleVertexSource )
            {
            // InternalOBJ.g:1350:2: ( ruleVertexSource )
            // InternalOBJ.g:1351:3: ruleVertexSource
            {
             before(grammarAccess.getGeometryAccess().getVertexSourceVertexSourceParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleVertexSource();

            state._fsp--;

             after(grammarAccess.getGeometryAccess().getVertexSourceVertexSourceParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Geometry__VertexSourceAssignment_0"


    // $ANTLR start "rule__Geometry__NodesAssignment_1"
    // InternalOBJ.g:1360:1: rule__Geometry__NodesAssignment_1 : ( rulePolyShape ) ;
    public final void rule__Geometry__NodesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1364:1: ( ( rulePolyShape ) )
            // InternalOBJ.g:1365:2: ( rulePolyShape )
            {
            // InternalOBJ.g:1365:2: ( rulePolyShape )
            // InternalOBJ.g:1366:3: rulePolyShape
            {
             before(grammarAccess.getGeometryAccess().getNodesPolyShapeParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            rulePolyShape();

            state._fsp--;

             after(grammarAccess.getGeometryAccess().getNodesPolyShapeParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Geometry__NodesAssignment_1"


    // $ANTLR start "rule__VertexSource__MaterialFilesAssignment_1"
    // InternalOBJ.g:1375:1: rule__VertexSource__MaterialFilesAssignment_1 : ( ruleEString ) ;
    public final void rule__VertexSource__MaterialFilesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1379:1: ( ( ruleEString ) )
            // InternalOBJ.g:1380:2: ( ruleEString )
            {
            // InternalOBJ.g:1380:2: ( ruleEString )
            // InternalOBJ.g:1381:3: ruleEString
            {
             before(grammarAccess.getVertexSourceAccess().getMaterialFilesEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getVertexSourceAccess().getMaterialFilesEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VertexSource__MaterialFilesAssignment_1"


    // $ANTLR start "rule__VertexSource__VerticesAssignment_4_0_1"
    // InternalOBJ.g:1390:1: rule__VertexSource__VerticesAssignment_4_0_1 : ( ruleVertex ) ;
    public final void rule__VertexSource__VerticesAssignment_4_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1394:1: ( ( ruleVertex ) )
            // InternalOBJ.g:1395:2: ( ruleVertex )
            {
            // InternalOBJ.g:1395:2: ( ruleVertex )
            // InternalOBJ.g:1396:3: ruleVertex
            {
             before(grammarAccess.getVertexSourceAccess().getVerticesVertexParserRuleCall_4_0_1_0()); 
            pushFollow(FOLLOW_2);
            ruleVertex();

            state._fsp--;

             after(grammarAccess.getVertexSourceAccess().getVerticesVertexParserRuleCall_4_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VertexSource__VerticesAssignment_4_0_1"


    // $ANTLR start "rule__VertexSource__TextureCoordinatesAssignment_4_1_1"
    // InternalOBJ.g:1405:1: rule__VertexSource__TextureCoordinatesAssignment_4_1_1 : ( ruleTextureVertex ) ;
    public final void rule__VertexSource__TextureCoordinatesAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1409:1: ( ( ruleTextureVertex ) )
            // InternalOBJ.g:1410:2: ( ruleTextureVertex )
            {
            // InternalOBJ.g:1410:2: ( ruleTextureVertex )
            // InternalOBJ.g:1411:3: ruleTextureVertex
            {
             before(grammarAccess.getVertexSourceAccess().getTextureCoordinatesTextureVertexParserRuleCall_4_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTextureVertex();

            state._fsp--;

             after(grammarAccess.getVertexSourceAccess().getTextureCoordinatesTextureVertexParserRuleCall_4_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VertexSource__TextureCoordinatesAssignment_4_1_1"


    // $ANTLR start "rule__PolyShape__NameAssignment_1"
    // InternalOBJ.g:1420:1: rule__PolyShape__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__PolyShape__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1424:1: ( ( ruleEString ) )
            // InternalOBJ.g:1425:2: ( ruleEString )
            {
            // InternalOBJ.g:1425:2: ( ruleEString )
            // InternalOBJ.g:1426:3: ruleEString
            {
             before(grammarAccess.getPolyShapeAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getPolyShapeAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PolyShape__NameAssignment_1"


    // $ANTLR start "rule__PolyShape__FacesAssignment_2_1"
    // InternalOBJ.g:1435:1: rule__PolyShape__FacesAssignment_2_1 : ( ruleFace ) ;
    public final void rule__PolyShape__FacesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1439:1: ( ( ruleFace ) )
            // InternalOBJ.g:1440:2: ( ruleFace )
            {
            // InternalOBJ.g:1440:2: ( ruleFace )
            // InternalOBJ.g:1441:3: ruleFace
            {
             before(grammarAccess.getPolyShapeAccess().getFacesFaceParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFace();

            state._fsp--;

             after(grammarAccess.getPolyShapeAccess().getFacesFaceParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PolyShape__FacesAssignment_2_1"


    // $ANTLR start "rule__Face__VertexIndicesAssignment_1_0"
    // InternalOBJ.g:1450:1: rule__Face__VertexIndicesAssignment_1_0 : ( ruleEInt ) ;
    public final void rule__Face__VertexIndicesAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1454:1: ( ( ruleEInt ) )
            // InternalOBJ.g:1455:2: ( ruleEInt )
            {
            // InternalOBJ.g:1455:2: ( ruleEInt )
            // InternalOBJ.g:1456:3: ruleEInt
            {
             before(grammarAccess.getFaceAccess().getVertexIndicesEIntParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getFaceAccess().getVertexIndicesEIntParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Face__VertexIndicesAssignment_1_0"


    // $ANTLR start "rule__Face__TextureIndicesAssignment_1_1_1_0"
    // InternalOBJ.g:1465:1: rule__Face__TextureIndicesAssignment_1_1_1_0 : ( ruleEInt ) ;
    public final void rule__Face__TextureIndicesAssignment_1_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1469:1: ( ( ruleEInt ) )
            // InternalOBJ.g:1470:2: ( ruleEInt )
            {
            // InternalOBJ.g:1470:2: ( ruleEInt )
            // InternalOBJ.g:1471:3: ruleEInt
            {
             before(grammarAccess.getFaceAccess().getTextureIndicesEIntParserRuleCall_1_1_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getFaceAccess().getTextureIndicesEIntParserRuleCall_1_1_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Face__TextureIndicesAssignment_1_1_1_0"


    // $ANTLR start "rule__Face__TextureIndicesAssignment_1_1_1_1_0"
    // InternalOBJ.g:1480:1: rule__Face__TextureIndicesAssignment_1_1_1_1_0 : ( ruleEInt ) ;
    public final void rule__Face__TextureIndicesAssignment_1_1_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1484:1: ( ( ruleEInt ) )
            // InternalOBJ.g:1485:2: ( ruleEInt )
            {
            // InternalOBJ.g:1485:2: ( ruleEInt )
            // InternalOBJ.g:1486:3: ruleEInt
            {
             before(grammarAccess.getFaceAccess().getTextureIndicesEIntParserRuleCall_1_1_1_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getFaceAccess().getTextureIndicesEIntParserRuleCall_1_1_1_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Face__TextureIndicesAssignment_1_1_1_1_0"


    // $ANTLR start "rule__Vertex__XAssignment_1"
    // InternalOBJ.g:1495:1: rule__Vertex__XAssignment_1 : ( ruleEDouble ) ;
    public final void rule__Vertex__XAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1499:1: ( ( ruleEDouble ) )
            // InternalOBJ.g:1500:2: ( ruleEDouble )
            {
            // InternalOBJ.g:1500:2: ( ruleEDouble )
            // InternalOBJ.g:1501:3: ruleEDouble
            {
             before(grammarAccess.getVertexAccess().getXEDoubleParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getVertexAccess().getXEDoubleParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Vertex__XAssignment_1"


    // $ANTLR start "rule__Vertex__YAssignment_2"
    // InternalOBJ.g:1510:1: rule__Vertex__YAssignment_2 : ( ruleEDouble ) ;
    public final void rule__Vertex__YAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1514:1: ( ( ruleEDouble ) )
            // InternalOBJ.g:1515:2: ( ruleEDouble )
            {
            // InternalOBJ.g:1515:2: ( ruleEDouble )
            // InternalOBJ.g:1516:3: ruleEDouble
            {
             before(grammarAccess.getVertexAccess().getYEDoubleParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getVertexAccess().getYEDoubleParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Vertex__YAssignment_2"


    // $ANTLR start "rule__Vertex__ZAssignment_3"
    // InternalOBJ.g:1525:1: rule__Vertex__ZAssignment_3 : ( ruleEDouble ) ;
    public final void rule__Vertex__ZAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1529:1: ( ( ruleEDouble ) )
            // InternalOBJ.g:1530:2: ( ruleEDouble )
            {
            // InternalOBJ.g:1530:2: ( ruleEDouble )
            // InternalOBJ.g:1531:3: ruleEDouble
            {
             before(grammarAccess.getVertexAccess().getZEDoubleParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getVertexAccess().getZEDoubleParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Vertex__ZAssignment_3"


    // $ANTLR start "rule__TextureVertex__XAssignment_0"
    // InternalOBJ.g:1540:1: rule__TextureVertex__XAssignment_0 : ( ruleEDouble ) ;
    public final void rule__TextureVertex__XAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1544:1: ( ( ruleEDouble ) )
            // InternalOBJ.g:1545:2: ( ruleEDouble )
            {
            // InternalOBJ.g:1545:2: ( ruleEDouble )
            // InternalOBJ.g:1546:3: ruleEDouble
            {
             before(grammarAccess.getTextureVertexAccess().getXEDoubleParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getTextureVertexAccess().getXEDoubleParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextureVertex__XAssignment_0"


    // $ANTLR start "rule__TextureVertex__YAssignment_1"
    // InternalOBJ.g:1555:1: rule__TextureVertex__YAssignment_1 : ( ruleEDouble ) ;
    public final void rule__TextureVertex__YAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1559:1: ( ( ruleEDouble ) )
            // InternalOBJ.g:1560:2: ( ruleEDouble )
            {
            // InternalOBJ.g:1560:2: ( ruleEDouble )
            // InternalOBJ.g:1561:3: ruleEDouble
            {
             before(grammarAccess.getTextureVertexAccess().getYEDoubleParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getTextureVertexAccess().getYEDoubleParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextureVertex__YAssignment_1"


    // $ANTLR start "rule__TextureVertex__ZAssignment_2"
    // InternalOBJ.g:1570:1: rule__TextureVertex__ZAssignment_2 : ( ruleEDouble ) ;
    public final void rule__TextureVertex__ZAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1574:1: ( ( ruleEDouble ) )
            // InternalOBJ.g:1575:2: ( ruleEDouble )
            {
            // InternalOBJ.g:1575:2: ( ruleEDouble )
            // InternalOBJ.g:1576:3: ruleEDouble
            {
             before(grammarAccess.getTextureVertexAccess().getZEDoubleParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getTextureVertexAccess().getZEDoubleParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextureVertex__ZAssignment_2"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004060L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000018070L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000018012L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000080180L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080182L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x00000000000C0180L});

}