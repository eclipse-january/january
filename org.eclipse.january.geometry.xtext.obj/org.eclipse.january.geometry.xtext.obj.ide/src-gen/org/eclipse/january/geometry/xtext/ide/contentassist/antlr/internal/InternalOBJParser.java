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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NORMAL", "RULE_STRING", "RULE_ID", "RULE_DOUBLE", "RULE_INT", "RULE_COMMENT", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ANY_OTHER", "'off'", "'.'", "'/'", "'\\\\'", "':'", "'mtllib'", "'g'", "'v'", "'vt'", "'usemtl'", "'f'", "'s'", "'-'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=12;
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
    public static final int RULE_WS=10;
    public static final int RULE_COMMENT=9;
    public static final int RULE_ANY_OTHER=13;
    public static final int T__26=26;
    public static final int RULE_INT=8;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=11;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

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


    // $ANTLR start "entryRuleMaterial"
    // InternalOBJ.g:203:1: entryRuleMaterial : ruleMaterial EOF ;
    public final void entryRuleMaterial() throws RecognitionException {
        try {
            // InternalOBJ.g:204:1: ( ruleMaterial EOF )
            // InternalOBJ.g:205:1: ruleMaterial EOF
            {
             before(grammarAccess.getMaterialRule()); 
            pushFollow(FOLLOW_1);
            ruleMaterial();

            state._fsp--;

             after(grammarAccess.getMaterialRule()); 
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
    // $ANTLR end "entryRuleMaterial"


    // $ANTLR start "ruleMaterial"
    // InternalOBJ.g:212:1: ruleMaterial : ( ( rule__Material__Group__0 ) ) ;
    public final void ruleMaterial() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:216:2: ( ( ( rule__Material__Group__0 ) ) )
            // InternalOBJ.g:217:2: ( ( rule__Material__Group__0 ) )
            {
            // InternalOBJ.g:217:2: ( ( rule__Material__Group__0 ) )
            // InternalOBJ.g:218:3: ( rule__Material__Group__0 )
            {
             before(grammarAccess.getMaterialAccess().getGroup()); 
            // InternalOBJ.g:219:3: ( rule__Material__Group__0 )
            // InternalOBJ.g:219:4: rule__Material__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Material__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMaterialAccess().getGroup()); 

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
    // $ANTLR end "ruleMaterial"


    // $ANTLR start "entryRuleEInt"
    // InternalOBJ.g:228:1: entryRuleEInt : ruleEInt EOF ;
    public final void entryRuleEInt() throws RecognitionException {
        try {
            // InternalOBJ.g:229:1: ( ruleEInt EOF )
            // InternalOBJ.g:230:1: ruleEInt EOF
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
    // InternalOBJ.g:237:1: ruleEInt : ( ( rule__EInt__Group__0 ) ) ;
    public final void ruleEInt() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:241:2: ( ( ( rule__EInt__Group__0 ) ) )
            // InternalOBJ.g:242:2: ( ( rule__EInt__Group__0 ) )
            {
            // InternalOBJ.g:242:2: ( ( rule__EInt__Group__0 ) )
            // InternalOBJ.g:243:3: ( rule__EInt__Group__0 )
            {
             before(grammarAccess.getEIntAccess().getGroup()); 
            // InternalOBJ.g:244:3: ( rule__EInt__Group__0 )
            // InternalOBJ.g:244:4: rule__EInt__Group__0
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
    // InternalOBJ.g:253:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalOBJ.g:254:1: ( ruleEString EOF )
            // InternalOBJ.g:255:1: ruleEString EOF
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
    // InternalOBJ.g:262:1: ruleEString : ( ( ( rule__EString__Alternatives ) ) ( ( rule__EString__Alternatives )* ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:266:2: ( ( ( ( rule__EString__Alternatives ) ) ( ( rule__EString__Alternatives )* ) ) )
            // InternalOBJ.g:267:2: ( ( ( rule__EString__Alternatives ) ) ( ( rule__EString__Alternatives )* ) )
            {
            // InternalOBJ.g:267:2: ( ( ( rule__EString__Alternatives ) ) ( ( rule__EString__Alternatives )* ) )
            // InternalOBJ.g:268:3: ( ( rule__EString__Alternatives ) ) ( ( rule__EString__Alternatives )* )
            {
            // InternalOBJ.g:268:3: ( ( rule__EString__Alternatives ) )
            // InternalOBJ.g:269:4: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalOBJ.g:270:4: ( rule__EString__Alternatives )
            // InternalOBJ.g:270:5: rule__EString__Alternatives
            {
            pushFollow(FOLLOW_3);
            rule__EString__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEStringAccess().getAlternatives()); 

            }

            // InternalOBJ.g:273:3: ( ( rule__EString__Alternatives )* )
            // InternalOBJ.g:274:4: ( rule__EString__Alternatives )*
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalOBJ.g:275:4: ( rule__EString__Alternatives )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_ID)||(LA1_0>=15 && LA1_0<=18)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalOBJ.g:275:5: rule__EString__Alternatives
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__EString__Alternatives();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getEStringAccess().getAlternatives()); 

            }


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
    // InternalOBJ.g:285:1: entryRuleEDouble : ruleEDouble EOF ;
    public final void entryRuleEDouble() throws RecognitionException {
        try {
            // InternalOBJ.g:286:1: ( ruleEDouble EOF )
            // InternalOBJ.g:287:1: ruleEDouble EOF
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
    // InternalOBJ.g:294:1: ruleEDouble : ( ( rule__EDouble__Alternatives ) ) ;
    public final void ruleEDouble() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:298:2: ( ( ( rule__EDouble__Alternatives ) ) )
            // InternalOBJ.g:299:2: ( ( rule__EDouble__Alternatives ) )
            {
            // InternalOBJ.g:299:2: ( ( rule__EDouble__Alternatives ) )
            // InternalOBJ.g:300:3: ( rule__EDouble__Alternatives )
            {
             before(grammarAccess.getEDoubleAccess().getAlternatives()); 
            // InternalOBJ.g:301:3: ( rule__EDouble__Alternatives )
            // InternalOBJ.g:301:4: rule__EDouble__Alternatives
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


    // $ANTLR start "rule__VertexSource__Alternatives_3"
    // InternalOBJ.g:309:1: rule__VertexSource__Alternatives_3 : ( ( ( rule__VertexSource__Group_3_0__0 ) ) | ( ( rule__VertexSource__Group_3_1__0 ) ) | ( RULE_NORMAL ) );
    public final void rule__VertexSource__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:313:1: ( ( ( rule__VertexSource__Group_3_0__0 ) ) | ( ( rule__VertexSource__Group_3_1__0 ) ) | ( RULE_NORMAL ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt2=1;
                }
                break;
            case 22:
                {
                alt2=2;
                }
                break;
            case RULE_NORMAL:
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
                    // InternalOBJ.g:314:2: ( ( rule__VertexSource__Group_3_0__0 ) )
                    {
                    // InternalOBJ.g:314:2: ( ( rule__VertexSource__Group_3_0__0 ) )
                    // InternalOBJ.g:315:3: ( rule__VertexSource__Group_3_0__0 )
                    {
                     before(grammarAccess.getVertexSourceAccess().getGroup_3_0()); 
                    // InternalOBJ.g:316:3: ( rule__VertexSource__Group_3_0__0 )
                    // InternalOBJ.g:316:4: rule__VertexSource__Group_3_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__VertexSource__Group_3_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getVertexSourceAccess().getGroup_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOBJ.g:320:2: ( ( rule__VertexSource__Group_3_1__0 ) )
                    {
                    // InternalOBJ.g:320:2: ( ( rule__VertexSource__Group_3_1__0 ) )
                    // InternalOBJ.g:321:3: ( rule__VertexSource__Group_3_1__0 )
                    {
                     before(grammarAccess.getVertexSourceAccess().getGroup_3_1()); 
                    // InternalOBJ.g:322:3: ( rule__VertexSource__Group_3_1__0 )
                    // InternalOBJ.g:322:4: rule__VertexSource__Group_3_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__VertexSource__Group_3_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getVertexSourceAccess().getGroup_3_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOBJ.g:326:2: ( RULE_NORMAL )
                    {
                    // InternalOBJ.g:326:2: ( RULE_NORMAL )
                    // InternalOBJ.g:327:3: RULE_NORMAL
                    {
                     before(grammarAccess.getVertexSourceAccess().getNORMALTerminalRuleCall_3_2()); 
                    match(input,RULE_NORMAL,FOLLOW_2); 
                     after(grammarAccess.getVertexSourceAccess().getNORMALTerminalRuleCall_3_2()); 

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
    // $ANTLR end "rule__VertexSource__Alternatives_3"


    // $ANTLR start "rule__PolyShape__Alternatives_2"
    // InternalOBJ.g:336:1: rule__PolyShape__Alternatives_2 : ( ( ( rule__PolyShape__Group_2_0__0 ) ) | ( ( rule__PolyShape__Group_2_1__0 ) ) );
    public final void rule__PolyShape__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:340:1: ( ( ( rule__PolyShape__Group_2_0__0 ) ) | ( ( rule__PolyShape__Group_2_1__0 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==24) ) {
                alt3=1;
            }
            else if ( (LA3_0==25) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalOBJ.g:341:2: ( ( rule__PolyShape__Group_2_0__0 ) )
                    {
                    // InternalOBJ.g:341:2: ( ( rule__PolyShape__Group_2_0__0 ) )
                    // InternalOBJ.g:342:3: ( rule__PolyShape__Group_2_0__0 )
                    {
                     before(grammarAccess.getPolyShapeAccess().getGroup_2_0()); 
                    // InternalOBJ.g:343:3: ( rule__PolyShape__Group_2_0__0 )
                    // InternalOBJ.g:343:4: rule__PolyShape__Group_2_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PolyShape__Group_2_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPolyShapeAccess().getGroup_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOBJ.g:347:2: ( ( rule__PolyShape__Group_2_1__0 ) )
                    {
                    // InternalOBJ.g:347:2: ( ( rule__PolyShape__Group_2_1__0 ) )
                    // InternalOBJ.g:348:3: ( rule__PolyShape__Group_2_1__0 )
                    {
                     before(grammarAccess.getPolyShapeAccess().getGroup_2_1()); 
                    // InternalOBJ.g:349:3: ( rule__PolyShape__Group_2_1__0 )
                    // InternalOBJ.g:349:4: rule__PolyShape__Group_2_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PolyShape__Group_2_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPolyShapeAccess().getGroup_2_1()); 

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
    // $ANTLR end "rule__PolyShape__Alternatives_2"


    // $ANTLR start "rule__PolyShape__Alternatives_2_1_1"
    // InternalOBJ.g:357:1: rule__PolyShape__Alternatives_2_1_1 : ( ( ruleEInt ) | ( 'off' ) );
    public final void rule__PolyShape__Alternatives_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:361:1: ( ( ruleEInt ) | ( 'off' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_INT||LA4_0==26) ) {
                alt4=1;
            }
            else if ( (LA4_0==14) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalOBJ.g:362:2: ( ruleEInt )
                    {
                    // InternalOBJ.g:362:2: ( ruleEInt )
                    // InternalOBJ.g:363:3: ruleEInt
                    {
                     before(grammarAccess.getPolyShapeAccess().getEIntParserRuleCall_2_1_1_0()); 
                    pushFollow(FOLLOW_2);
                    ruleEInt();

                    state._fsp--;

                     after(grammarAccess.getPolyShapeAccess().getEIntParserRuleCall_2_1_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOBJ.g:368:2: ( 'off' )
                    {
                    // InternalOBJ.g:368:2: ( 'off' )
                    // InternalOBJ.g:369:3: 'off'
                    {
                     before(grammarAccess.getPolyShapeAccess().getOffKeyword_2_1_1_1()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getPolyShapeAccess().getOffKeyword_2_1_1_1()); 

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
    // $ANTLR end "rule__PolyShape__Alternatives_2_1_1"


    // $ANTLR start "rule__Face__Alternatives_1_1_1"
    // InternalOBJ.g:378:1: rule__Face__Alternatives_1_1_1 : ( ( ( rule__Face__TextureIndicesAssignment_1_1_1_0 ) ) | ( ( rule__Face__Group_1_1_1_1__0 ) ) | ( ( rule__Face__Group_1_1_1_2__0 ) ) );
    public final void rule__Face__Alternatives_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:382:1: ( ( ( rule__Face__TextureIndicesAssignment_1_1_1_0 ) ) | ( ( rule__Face__Group_1_1_1_1__0 ) ) | ( ( rule__Face__Group_1_1_1_2__0 ) ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 26:
                {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==RULE_INT) ) {
                    int LA5_2 = input.LA(3);

                    if ( (LA5_2==EOF||LA5_2==RULE_INT||LA5_2==20||(LA5_2>=23 && LA5_2<=26)) ) {
                        alt5=1;
                    }
                    else if ( (LA5_2==16) ) {
                        alt5=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA5_2 = input.LA(2);

                if ( (LA5_2==EOF||LA5_2==RULE_INT||LA5_2==20||(LA5_2>=23 && LA5_2<=26)) ) {
                    alt5=1;
                }
                else if ( (LA5_2==16) ) {
                    alt5=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 2, input);

                    throw nvae;
                }
                }
                break;
            case 16:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalOBJ.g:383:2: ( ( rule__Face__TextureIndicesAssignment_1_1_1_0 ) )
                    {
                    // InternalOBJ.g:383:2: ( ( rule__Face__TextureIndicesAssignment_1_1_1_0 ) )
                    // InternalOBJ.g:384:3: ( rule__Face__TextureIndicesAssignment_1_1_1_0 )
                    {
                     before(grammarAccess.getFaceAccess().getTextureIndicesAssignment_1_1_1_0()); 
                    // InternalOBJ.g:385:3: ( rule__Face__TextureIndicesAssignment_1_1_1_0 )
                    // InternalOBJ.g:385:4: rule__Face__TextureIndicesAssignment_1_1_1_0
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
                    // InternalOBJ.g:389:2: ( ( rule__Face__Group_1_1_1_1__0 ) )
                    {
                    // InternalOBJ.g:389:2: ( ( rule__Face__Group_1_1_1_1__0 ) )
                    // InternalOBJ.g:390:3: ( rule__Face__Group_1_1_1_1__0 )
                    {
                     before(grammarAccess.getFaceAccess().getGroup_1_1_1_1()); 
                    // InternalOBJ.g:391:3: ( rule__Face__Group_1_1_1_1__0 )
                    // InternalOBJ.g:391:4: rule__Face__Group_1_1_1_1__0
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
                    // InternalOBJ.g:395:2: ( ( rule__Face__Group_1_1_1_2__0 ) )
                    {
                    // InternalOBJ.g:395:2: ( ( rule__Face__Group_1_1_1_2__0 ) )
                    // InternalOBJ.g:396:3: ( rule__Face__Group_1_1_1_2__0 )
                    {
                     before(grammarAccess.getFaceAccess().getGroup_1_1_1_2()); 
                    // InternalOBJ.g:397:3: ( rule__Face__Group_1_1_1_2__0 )
                    // InternalOBJ.g:397:4: rule__Face__Group_1_1_1_2__0
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
    // InternalOBJ.g:405:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) | ( '.' ) | ( '/' ) | ( '\\\\' ) | ( ':' ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:409:1: ( ( RULE_STRING ) | ( RULE_ID ) | ( '.' ) | ( '/' ) | ( '\\\\' ) | ( ':' ) )
            int alt6=6;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt6=1;
                }
                break;
            case RULE_ID:
                {
                alt6=2;
                }
                break;
            case 15:
                {
                alt6=3;
                }
                break;
            case 16:
                {
                alt6=4;
                }
                break;
            case 17:
                {
                alt6=5;
                }
                break;
            case 18:
                {
                alt6=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalOBJ.g:410:2: ( RULE_STRING )
                    {
                    // InternalOBJ.g:410:2: ( RULE_STRING )
                    // InternalOBJ.g:411:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOBJ.g:416:2: ( RULE_ID )
                    {
                    // InternalOBJ.g:416:2: ( RULE_ID )
                    // InternalOBJ.g:417:3: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOBJ.g:422:2: ( '.' )
                    {
                    // InternalOBJ.g:422:2: ( '.' )
                    // InternalOBJ.g:423:3: '.'
                    {
                     before(grammarAccess.getEStringAccess().getFullStopKeyword_2()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getFullStopKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOBJ.g:428:2: ( '/' )
                    {
                    // InternalOBJ.g:428:2: ( '/' )
                    // InternalOBJ.g:429:3: '/'
                    {
                     before(grammarAccess.getEStringAccess().getSolidusKeyword_3()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSolidusKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalOBJ.g:434:2: ( '\\\\' )
                    {
                    // InternalOBJ.g:434:2: ( '\\\\' )
                    // InternalOBJ.g:435:3: '\\\\'
                    {
                     before(grammarAccess.getEStringAccess().getReverseSolidusKeyword_4()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getReverseSolidusKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalOBJ.g:440:2: ( ':' )
                    {
                    // InternalOBJ.g:440:2: ( ':' )
                    // InternalOBJ.g:441:3: ':'
                    {
                     before(grammarAccess.getEStringAccess().getColonKeyword_5()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getColonKeyword_5()); 

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
    // InternalOBJ.g:450:1: rule__EDouble__Alternatives : ( ( RULE_DOUBLE ) | ( ruleEInt ) );
    public final void rule__EDouble__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:454:1: ( ( RULE_DOUBLE ) | ( ruleEInt ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_DOUBLE) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_INT||LA7_0==26) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalOBJ.g:455:2: ( RULE_DOUBLE )
                    {
                    // InternalOBJ.g:455:2: ( RULE_DOUBLE )
                    // InternalOBJ.g:456:3: RULE_DOUBLE
                    {
                     before(grammarAccess.getEDoubleAccess().getDOUBLETerminalRuleCall_0()); 
                    match(input,RULE_DOUBLE,FOLLOW_2); 
                     after(grammarAccess.getEDoubleAccess().getDOUBLETerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOBJ.g:461:2: ( ruleEInt )
                    {
                    // InternalOBJ.g:461:2: ( ruleEInt )
                    // InternalOBJ.g:462:3: ruleEInt
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
    // InternalOBJ.g:471:1: rule__Geometry__Group__0 : rule__Geometry__Group__0__Impl rule__Geometry__Group__1 ;
    public final void rule__Geometry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:475:1: ( rule__Geometry__Group__0__Impl rule__Geometry__Group__1 )
            // InternalOBJ.g:476:2: rule__Geometry__Group__0__Impl rule__Geometry__Group__1
            {
            pushFollow(FOLLOW_4);
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
    // InternalOBJ.g:483:1: rule__Geometry__Group__0__Impl : ( ( rule__Geometry__VertexSourceAssignment_0 )? ) ;
    public final void rule__Geometry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:487:1: ( ( ( rule__Geometry__VertexSourceAssignment_0 )? ) )
            // InternalOBJ.g:488:1: ( ( rule__Geometry__VertexSourceAssignment_0 )? )
            {
            // InternalOBJ.g:488:1: ( ( rule__Geometry__VertexSourceAssignment_0 )? )
            // InternalOBJ.g:489:2: ( rule__Geometry__VertexSourceAssignment_0 )?
            {
             before(grammarAccess.getGeometryAccess().getVertexSourceAssignment_0()); 
            // InternalOBJ.g:490:2: ( rule__Geometry__VertexSourceAssignment_0 )?
            int alt8=2;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // InternalOBJ.g:490:3: rule__Geometry__VertexSourceAssignment_0
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
    // InternalOBJ.g:498:1: rule__Geometry__Group__1 : rule__Geometry__Group__1__Impl ;
    public final void rule__Geometry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:502:1: ( rule__Geometry__Group__1__Impl )
            // InternalOBJ.g:503:2: rule__Geometry__Group__1__Impl
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
    // InternalOBJ.g:509:1: rule__Geometry__Group__1__Impl : ( ( rule__Geometry__NodesAssignment_1 )* ) ;
    public final void rule__Geometry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:513:1: ( ( ( rule__Geometry__NodesAssignment_1 )* ) )
            // InternalOBJ.g:514:1: ( ( rule__Geometry__NodesAssignment_1 )* )
            {
            // InternalOBJ.g:514:1: ( ( rule__Geometry__NodesAssignment_1 )* )
            // InternalOBJ.g:515:2: ( rule__Geometry__NodesAssignment_1 )*
            {
             before(grammarAccess.getGeometryAccess().getNodesAssignment_1()); 
            // InternalOBJ.g:516:2: ( rule__Geometry__NodesAssignment_1 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==20||(LA9_0>=23 && LA9_0<=25)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalOBJ.g:516:3: rule__Geometry__NodesAssignment_1
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Geometry__NodesAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // InternalOBJ.g:525:1: rule__VertexSource__Group__0 : rule__VertexSource__Group__0__Impl rule__VertexSource__Group__1 ;
    public final void rule__VertexSource__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:529:1: ( rule__VertexSource__Group__0__Impl rule__VertexSource__Group__1 )
            // InternalOBJ.g:530:2: rule__VertexSource__Group__0__Impl rule__VertexSource__Group__1
            {
            pushFollow(FOLLOW_6);
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
    // InternalOBJ.g:537:1: rule__VertexSource__Group__0__Impl : ( () ) ;
    public final void rule__VertexSource__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:541:1: ( ( () ) )
            // InternalOBJ.g:542:1: ( () )
            {
            // InternalOBJ.g:542:1: ( () )
            // InternalOBJ.g:543:2: ()
            {
             before(grammarAccess.getVertexSourceAccess().getVertexSourceAction_0()); 
            // InternalOBJ.g:544:2: ()
            // InternalOBJ.g:544:3: 
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
    // InternalOBJ.g:552:1: rule__VertexSource__Group__1 : rule__VertexSource__Group__1__Impl rule__VertexSource__Group__2 ;
    public final void rule__VertexSource__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:556:1: ( rule__VertexSource__Group__1__Impl rule__VertexSource__Group__2 )
            // InternalOBJ.g:557:2: rule__VertexSource__Group__1__Impl rule__VertexSource__Group__2
            {
            pushFollow(FOLLOW_6);
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
    // InternalOBJ.g:564:1: rule__VertexSource__Group__1__Impl : ( ( rule__VertexSource__Group_1__0 )* ) ;
    public final void rule__VertexSource__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:568:1: ( ( ( rule__VertexSource__Group_1__0 )* ) )
            // InternalOBJ.g:569:1: ( ( rule__VertexSource__Group_1__0 )* )
            {
            // InternalOBJ.g:569:1: ( ( rule__VertexSource__Group_1__0 )* )
            // InternalOBJ.g:570:2: ( rule__VertexSource__Group_1__0 )*
            {
             before(grammarAccess.getVertexSourceAccess().getGroup_1()); 
            // InternalOBJ.g:571:2: ( rule__VertexSource__Group_1__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==19) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalOBJ.g:571:3: rule__VertexSource__Group_1__0
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__VertexSource__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getVertexSourceAccess().getGroup_1()); 

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
    // InternalOBJ.g:579:1: rule__VertexSource__Group__2 : rule__VertexSource__Group__2__Impl rule__VertexSource__Group__3 ;
    public final void rule__VertexSource__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:583:1: ( rule__VertexSource__Group__2__Impl rule__VertexSource__Group__3 )
            // InternalOBJ.g:584:2: rule__VertexSource__Group__2__Impl rule__VertexSource__Group__3
            {
            pushFollow(FOLLOW_6);
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
    // InternalOBJ.g:591:1: rule__VertexSource__Group__2__Impl : ( ( rule__VertexSource__Group_2__0 )? ) ;
    public final void rule__VertexSource__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:595:1: ( ( ( rule__VertexSource__Group_2__0 )? ) )
            // InternalOBJ.g:596:1: ( ( rule__VertexSource__Group_2__0 )? )
            {
            // InternalOBJ.g:596:1: ( ( rule__VertexSource__Group_2__0 )? )
            // InternalOBJ.g:597:2: ( rule__VertexSource__Group_2__0 )?
            {
             before(grammarAccess.getVertexSourceAccess().getGroup_2()); 
            // InternalOBJ.g:598:2: ( rule__VertexSource__Group_2__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==20) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalOBJ.g:598:3: rule__VertexSource__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__VertexSource__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVertexSourceAccess().getGroup_2()); 

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
    // InternalOBJ.g:606:1: rule__VertexSource__Group__3 : rule__VertexSource__Group__3__Impl ;
    public final void rule__VertexSource__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:610:1: ( rule__VertexSource__Group__3__Impl )
            // InternalOBJ.g:611:2: rule__VertexSource__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VertexSource__Group__3__Impl();

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
    // InternalOBJ.g:617:1: rule__VertexSource__Group__3__Impl : ( ( ( rule__VertexSource__Alternatives_3 ) ) ( ( rule__VertexSource__Alternatives_3 )* ) ) ;
    public final void rule__VertexSource__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:621:1: ( ( ( ( rule__VertexSource__Alternatives_3 ) ) ( ( rule__VertexSource__Alternatives_3 )* ) ) )
            // InternalOBJ.g:622:1: ( ( ( rule__VertexSource__Alternatives_3 ) ) ( ( rule__VertexSource__Alternatives_3 )* ) )
            {
            // InternalOBJ.g:622:1: ( ( ( rule__VertexSource__Alternatives_3 ) ) ( ( rule__VertexSource__Alternatives_3 )* ) )
            // InternalOBJ.g:623:2: ( ( rule__VertexSource__Alternatives_3 ) ) ( ( rule__VertexSource__Alternatives_3 )* )
            {
            // InternalOBJ.g:623:2: ( ( rule__VertexSource__Alternatives_3 ) )
            // InternalOBJ.g:624:3: ( rule__VertexSource__Alternatives_3 )
            {
             before(grammarAccess.getVertexSourceAccess().getAlternatives_3()); 
            // InternalOBJ.g:625:3: ( rule__VertexSource__Alternatives_3 )
            // InternalOBJ.g:625:4: rule__VertexSource__Alternatives_3
            {
            pushFollow(FOLLOW_8);
            rule__VertexSource__Alternatives_3();

            state._fsp--;


            }

             after(grammarAccess.getVertexSourceAccess().getAlternatives_3()); 

            }

            // InternalOBJ.g:628:2: ( ( rule__VertexSource__Alternatives_3 )* )
            // InternalOBJ.g:629:3: ( rule__VertexSource__Alternatives_3 )*
            {
             before(grammarAccess.getVertexSourceAccess().getAlternatives_3()); 
            // InternalOBJ.g:630:3: ( rule__VertexSource__Alternatives_3 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_NORMAL||(LA12_0>=21 && LA12_0<=22)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalOBJ.g:630:4: rule__VertexSource__Alternatives_3
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__VertexSource__Alternatives_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getVertexSourceAccess().getAlternatives_3()); 

            }


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


    // $ANTLR start "rule__VertexSource__Group_1__0"
    // InternalOBJ.g:640:1: rule__VertexSource__Group_1__0 : rule__VertexSource__Group_1__0__Impl rule__VertexSource__Group_1__1 ;
    public final void rule__VertexSource__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:644:1: ( rule__VertexSource__Group_1__0__Impl rule__VertexSource__Group_1__1 )
            // InternalOBJ.g:645:2: rule__VertexSource__Group_1__0__Impl rule__VertexSource__Group_1__1
            {
            pushFollow(FOLLOW_9);
            rule__VertexSource__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VertexSource__Group_1__1();

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
    // $ANTLR end "rule__VertexSource__Group_1__0"


    // $ANTLR start "rule__VertexSource__Group_1__0__Impl"
    // InternalOBJ.g:652:1: rule__VertexSource__Group_1__0__Impl : ( 'mtllib' ) ;
    public final void rule__VertexSource__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:656:1: ( ( 'mtllib' ) )
            // InternalOBJ.g:657:1: ( 'mtllib' )
            {
            // InternalOBJ.g:657:1: ( 'mtllib' )
            // InternalOBJ.g:658:2: 'mtllib'
            {
             before(grammarAccess.getVertexSourceAccess().getMtllibKeyword_1_0()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getVertexSourceAccess().getMtllibKeyword_1_0()); 

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
    // $ANTLR end "rule__VertexSource__Group_1__0__Impl"


    // $ANTLR start "rule__VertexSource__Group_1__1"
    // InternalOBJ.g:667:1: rule__VertexSource__Group_1__1 : rule__VertexSource__Group_1__1__Impl ;
    public final void rule__VertexSource__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:671:1: ( rule__VertexSource__Group_1__1__Impl )
            // InternalOBJ.g:672:2: rule__VertexSource__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VertexSource__Group_1__1__Impl();

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
    // $ANTLR end "rule__VertexSource__Group_1__1"


    // $ANTLR start "rule__VertexSource__Group_1__1__Impl"
    // InternalOBJ.g:678:1: rule__VertexSource__Group_1__1__Impl : ( ( rule__VertexSource__MaterialFilesAssignment_1_1 ) ) ;
    public final void rule__VertexSource__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:682:1: ( ( ( rule__VertexSource__MaterialFilesAssignment_1_1 ) ) )
            // InternalOBJ.g:683:1: ( ( rule__VertexSource__MaterialFilesAssignment_1_1 ) )
            {
            // InternalOBJ.g:683:1: ( ( rule__VertexSource__MaterialFilesAssignment_1_1 ) )
            // InternalOBJ.g:684:2: ( rule__VertexSource__MaterialFilesAssignment_1_1 )
            {
             before(grammarAccess.getVertexSourceAccess().getMaterialFilesAssignment_1_1()); 
            // InternalOBJ.g:685:2: ( rule__VertexSource__MaterialFilesAssignment_1_1 )
            // InternalOBJ.g:685:3: rule__VertexSource__MaterialFilesAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__VertexSource__MaterialFilesAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getVertexSourceAccess().getMaterialFilesAssignment_1_1()); 

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
    // $ANTLR end "rule__VertexSource__Group_1__1__Impl"


    // $ANTLR start "rule__VertexSource__Group_2__0"
    // InternalOBJ.g:694:1: rule__VertexSource__Group_2__0 : rule__VertexSource__Group_2__0__Impl rule__VertexSource__Group_2__1 ;
    public final void rule__VertexSource__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:698:1: ( rule__VertexSource__Group_2__0__Impl rule__VertexSource__Group_2__1 )
            // InternalOBJ.g:699:2: rule__VertexSource__Group_2__0__Impl rule__VertexSource__Group_2__1
            {
            pushFollow(FOLLOW_9);
            rule__VertexSource__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VertexSource__Group_2__1();

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
    // $ANTLR end "rule__VertexSource__Group_2__0"


    // $ANTLR start "rule__VertexSource__Group_2__0__Impl"
    // InternalOBJ.g:706:1: rule__VertexSource__Group_2__0__Impl : ( 'g' ) ;
    public final void rule__VertexSource__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:710:1: ( ( 'g' ) )
            // InternalOBJ.g:711:1: ( 'g' )
            {
            // InternalOBJ.g:711:1: ( 'g' )
            // InternalOBJ.g:712:2: 'g'
            {
             before(grammarAccess.getVertexSourceAccess().getGKeyword_2_0()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getVertexSourceAccess().getGKeyword_2_0()); 

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
    // $ANTLR end "rule__VertexSource__Group_2__0__Impl"


    // $ANTLR start "rule__VertexSource__Group_2__1"
    // InternalOBJ.g:721:1: rule__VertexSource__Group_2__1 : rule__VertexSource__Group_2__1__Impl ;
    public final void rule__VertexSource__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:725:1: ( rule__VertexSource__Group_2__1__Impl )
            // InternalOBJ.g:726:2: rule__VertexSource__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VertexSource__Group_2__1__Impl();

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
    // $ANTLR end "rule__VertexSource__Group_2__1"


    // $ANTLR start "rule__VertexSource__Group_2__1__Impl"
    // InternalOBJ.g:732:1: rule__VertexSource__Group_2__1__Impl : ( ( ruleEString )? ) ;
    public final void rule__VertexSource__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:736:1: ( ( ( ruleEString )? ) )
            // InternalOBJ.g:737:1: ( ( ruleEString )? )
            {
            // InternalOBJ.g:737:1: ( ( ruleEString )? )
            // InternalOBJ.g:738:2: ( ruleEString )?
            {
             before(grammarAccess.getVertexSourceAccess().getEStringParserRuleCall_2_1()); 
            // InternalOBJ.g:739:2: ( ruleEString )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=RULE_STRING && LA13_0<=RULE_ID)||(LA13_0>=15 && LA13_0<=18)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalOBJ.g:739:3: ruleEString
                    {
                    pushFollow(FOLLOW_2);
                    ruleEString();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVertexSourceAccess().getEStringParserRuleCall_2_1()); 

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
    // $ANTLR end "rule__VertexSource__Group_2__1__Impl"


    // $ANTLR start "rule__VertexSource__Group_3_0__0"
    // InternalOBJ.g:748:1: rule__VertexSource__Group_3_0__0 : rule__VertexSource__Group_3_0__0__Impl rule__VertexSource__Group_3_0__1 ;
    public final void rule__VertexSource__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:752:1: ( rule__VertexSource__Group_3_0__0__Impl rule__VertexSource__Group_3_0__1 )
            // InternalOBJ.g:753:2: rule__VertexSource__Group_3_0__0__Impl rule__VertexSource__Group_3_0__1
            {
            pushFollow(FOLLOW_10);
            rule__VertexSource__Group_3_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VertexSource__Group_3_0__1();

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
    // $ANTLR end "rule__VertexSource__Group_3_0__0"


    // $ANTLR start "rule__VertexSource__Group_3_0__0__Impl"
    // InternalOBJ.g:760:1: rule__VertexSource__Group_3_0__0__Impl : ( 'v' ) ;
    public final void rule__VertexSource__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:764:1: ( ( 'v' ) )
            // InternalOBJ.g:765:1: ( 'v' )
            {
            // InternalOBJ.g:765:1: ( 'v' )
            // InternalOBJ.g:766:2: 'v'
            {
             before(grammarAccess.getVertexSourceAccess().getVKeyword_3_0_0()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getVertexSourceAccess().getVKeyword_3_0_0()); 

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
    // $ANTLR end "rule__VertexSource__Group_3_0__0__Impl"


    // $ANTLR start "rule__VertexSource__Group_3_0__1"
    // InternalOBJ.g:775:1: rule__VertexSource__Group_3_0__1 : rule__VertexSource__Group_3_0__1__Impl ;
    public final void rule__VertexSource__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:779:1: ( rule__VertexSource__Group_3_0__1__Impl )
            // InternalOBJ.g:780:2: rule__VertexSource__Group_3_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VertexSource__Group_3_0__1__Impl();

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
    // $ANTLR end "rule__VertexSource__Group_3_0__1"


    // $ANTLR start "rule__VertexSource__Group_3_0__1__Impl"
    // InternalOBJ.g:786:1: rule__VertexSource__Group_3_0__1__Impl : ( ( rule__VertexSource__VerticesAssignment_3_0_1 ) ) ;
    public final void rule__VertexSource__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:790:1: ( ( ( rule__VertexSource__VerticesAssignment_3_0_1 ) ) )
            // InternalOBJ.g:791:1: ( ( rule__VertexSource__VerticesAssignment_3_0_1 ) )
            {
            // InternalOBJ.g:791:1: ( ( rule__VertexSource__VerticesAssignment_3_0_1 ) )
            // InternalOBJ.g:792:2: ( rule__VertexSource__VerticesAssignment_3_0_1 )
            {
             before(grammarAccess.getVertexSourceAccess().getVerticesAssignment_3_0_1()); 
            // InternalOBJ.g:793:2: ( rule__VertexSource__VerticesAssignment_3_0_1 )
            // InternalOBJ.g:793:3: rule__VertexSource__VerticesAssignment_3_0_1
            {
            pushFollow(FOLLOW_2);
            rule__VertexSource__VerticesAssignment_3_0_1();

            state._fsp--;


            }

             after(grammarAccess.getVertexSourceAccess().getVerticesAssignment_3_0_1()); 

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
    // $ANTLR end "rule__VertexSource__Group_3_0__1__Impl"


    // $ANTLR start "rule__VertexSource__Group_3_1__0"
    // InternalOBJ.g:802:1: rule__VertexSource__Group_3_1__0 : rule__VertexSource__Group_3_1__0__Impl rule__VertexSource__Group_3_1__1 ;
    public final void rule__VertexSource__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:806:1: ( rule__VertexSource__Group_3_1__0__Impl rule__VertexSource__Group_3_1__1 )
            // InternalOBJ.g:807:2: rule__VertexSource__Group_3_1__0__Impl rule__VertexSource__Group_3_1__1
            {
            pushFollow(FOLLOW_10);
            rule__VertexSource__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VertexSource__Group_3_1__1();

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
    // $ANTLR end "rule__VertexSource__Group_3_1__0"


    // $ANTLR start "rule__VertexSource__Group_3_1__0__Impl"
    // InternalOBJ.g:814:1: rule__VertexSource__Group_3_1__0__Impl : ( 'vt' ) ;
    public final void rule__VertexSource__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:818:1: ( ( 'vt' ) )
            // InternalOBJ.g:819:1: ( 'vt' )
            {
            // InternalOBJ.g:819:1: ( 'vt' )
            // InternalOBJ.g:820:2: 'vt'
            {
             before(grammarAccess.getVertexSourceAccess().getVtKeyword_3_1_0()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getVertexSourceAccess().getVtKeyword_3_1_0()); 

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
    // $ANTLR end "rule__VertexSource__Group_3_1__0__Impl"


    // $ANTLR start "rule__VertexSource__Group_3_1__1"
    // InternalOBJ.g:829:1: rule__VertexSource__Group_3_1__1 : rule__VertexSource__Group_3_1__1__Impl ;
    public final void rule__VertexSource__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:833:1: ( rule__VertexSource__Group_3_1__1__Impl )
            // InternalOBJ.g:834:2: rule__VertexSource__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VertexSource__Group_3_1__1__Impl();

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
    // $ANTLR end "rule__VertexSource__Group_3_1__1"


    // $ANTLR start "rule__VertexSource__Group_3_1__1__Impl"
    // InternalOBJ.g:840:1: rule__VertexSource__Group_3_1__1__Impl : ( ( rule__VertexSource__TextureCoordinatesAssignment_3_1_1 ) ) ;
    public final void rule__VertexSource__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:844:1: ( ( ( rule__VertexSource__TextureCoordinatesAssignment_3_1_1 ) ) )
            // InternalOBJ.g:845:1: ( ( rule__VertexSource__TextureCoordinatesAssignment_3_1_1 ) )
            {
            // InternalOBJ.g:845:1: ( ( rule__VertexSource__TextureCoordinatesAssignment_3_1_1 ) )
            // InternalOBJ.g:846:2: ( rule__VertexSource__TextureCoordinatesAssignment_3_1_1 )
            {
             before(grammarAccess.getVertexSourceAccess().getTextureCoordinatesAssignment_3_1_1()); 
            // InternalOBJ.g:847:2: ( rule__VertexSource__TextureCoordinatesAssignment_3_1_1 )
            // InternalOBJ.g:847:3: rule__VertexSource__TextureCoordinatesAssignment_3_1_1
            {
            pushFollow(FOLLOW_2);
            rule__VertexSource__TextureCoordinatesAssignment_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getVertexSourceAccess().getTextureCoordinatesAssignment_3_1_1()); 

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
    // $ANTLR end "rule__VertexSource__Group_3_1__1__Impl"


    // $ANTLR start "rule__PolyShape__Group__0"
    // InternalOBJ.g:856:1: rule__PolyShape__Group__0 : rule__PolyShape__Group__0__Impl rule__PolyShape__Group__1 ;
    public final void rule__PolyShape__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:860:1: ( rule__PolyShape__Group__0__Impl rule__PolyShape__Group__1 )
            // InternalOBJ.g:861:2: rule__PolyShape__Group__0__Impl rule__PolyShape__Group__1
            {
            pushFollow(FOLLOW_4);
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
    // InternalOBJ.g:868:1: rule__PolyShape__Group__0__Impl : ( ( rule__PolyShape__Group_0__0 )? ) ;
    public final void rule__PolyShape__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:872:1: ( ( ( rule__PolyShape__Group_0__0 )? ) )
            // InternalOBJ.g:873:1: ( ( rule__PolyShape__Group_0__0 )? )
            {
            // InternalOBJ.g:873:1: ( ( rule__PolyShape__Group_0__0 )? )
            // InternalOBJ.g:874:2: ( rule__PolyShape__Group_0__0 )?
            {
             before(grammarAccess.getPolyShapeAccess().getGroup_0()); 
            // InternalOBJ.g:875:2: ( rule__PolyShape__Group_0__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==20) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalOBJ.g:875:3: rule__PolyShape__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PolyShape__Group_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPolyShapeAccess().getGroup_0()); 

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
    // InternalOBJ.g:883:1: rule__PolyShape__Group__1 : rule__PolyShape__Group__1__Impl rule__PolyShape__Group__2 ;
    public final void rule__PolyShape__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:887:1: ( rule__PolyShape__Group__1__Impl rule__PolyShape__Group__2 )
            // InternalOBJ.g:888:2: rule__PolyShape__Group__1__Impl rule__PolyShape__Group__2
            {
            pushFollow(FOLLOW_4);
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
    // InternalOBJ.g:895:1: rule__PolyShape__Group__1__Impl : ( ( rule__PolyShape__Group_1__0 )? ) ;
    public final void rule__PolyShape__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:899:1: ( ( ( rule__PolyShape__Group_1__0 )? ) )
            // InternalOBJ.g:900:1: ( ( rule__PolyShape__Group_1__0 )? )
            {
            // InternalOBJ.g:900:1: ( ( rule__PolyShape__Group_1__0 )? )
            // InternalOBJ.g:901:2: ( rule__PolyShape__Group_1__0 )?
            {
             before(grammarAccess.getPolyShapeAccess().getGroup_1()); 
            // InternalOBJ.g:902:2: ( rule__PolyShape__Group_1__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==23) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalOBJ.g:902:3: rule__PolyShape__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PolyShape__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPolyShapeAccess().getGroup_1()); 

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
    // InternalOBJ.g:910:1: rule__PolyShape__Group__2 : rule__PolyShape__Group__2__Impl ;
    public final void rule__PolyShape__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:914:1: ( rule__PolyShape__Group__2__Impl )
            // InternalOBJ.g:915:2: rule__PolyShape__Group__2__Impl
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
    // InternalOBJ.g:921:1: rule__PolyShape__Group__2__Impl : ( ( ( rule__PolyShape__Alternatives_2 ) ) ( ( rule__PolyShape__Alternatives_2 )* ) ) ;
    public final void rule__PolyShape__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:925:1: ( ( ( ( rule__PolyShape__Alternatives_2 ) ) ( ( rule__PolyShape__Alternatives_2 )* ) ) )
            // InternalOBJ.g:926:1: ( ( ( rule__PolyShape__Alternatives_2 ) ) ( ( rule__PolyShape__Alternatives_2 )* ) )
            {
            // InternalOBJ.g:926:1: ( ( ( rule__PolyShape__Alternatives_2 ) ) ( ( rule__PolyShape__Alternatives_2 )* ) )
            // InternalOBJ.g:927:2: ( ( rule__PolyShape__Alternatives_2 ) ) ( ( rule__PolyShape__Alternatives_2 )* )
            {
            // InternalOBJ.g:927:2: ( ( rule__PolyShape__Alternatives_2 ) )
            // InternalOBJ.g:928:3: ( rule__PolyShape__Alternatives_2 )
            {
             before(grammarAccess.getPolyShapeAccess().getAlternatives_2()); 
            // InternalOBJ.g:929:3: ( rule__PolyShape__Alternatives_2 )
            // InternalOBJ.g:929:4: rule__PolyShape__Alternatives_2
            {
            pushFollow(FOLLOW_5);
            rule__PolyShape__Alternatives_2();

            state._fsp--;


            }

             after(grammarAccess.getPolyShapeAccess().getAlternatives_2()); 

            }

            // InternalOBJ.g:932:2: ( ( rule__PolyShape__Alternatives_2 )* )
            // InternalOBJ.g:933:3: ( rule__PolyShape__Alternatives_2 )*
            {
             before(grammarAccess.getPolyShapeAccess().getAlternatives_2()); 
            // InternalOBJ.g:934:3: ( rule__PolyShape__Alternatives_2 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==24) ) {
                    alt16=1;
                }
                else if ( (LA16_0==25) ) {
                    switch ( input.LA(2) ) {
                    case 26:
                        {
                        int LA16_4 = input.LA(3);

                        if ( (LA16_4==RULE_INT) ) {
                            alt16=1;
                        }


                        }
                        break;
                    case RULE_INT:
                        {
                        alt16=1;
                        }
                        break;
                    case 14:
                        {
                        alt16=1;
                        }
                        break;

                    }

                }


                switch (alt16) {
            	case 1 :
            	    // InternalOBJ.g:934:4: rule__PolyShape__Alternatives_2
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__PolyShape__Alternatives_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getPolyShapeAccess().getAlternatives_2()); 

            }


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


    // $ANTLR start "rule__PolyShape__Group_0__0"
    // InternalOBJ.g:944:1: rule__PolyShape__Group_0__0 : rule__PolyShape__Group_0__0__Impl rule__PolyShape__Group_0__1 ;
    public final void rule__PolyShape__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:948:1: ( rule__PolyShape__Group_0__0__Impl rule__PolyShape__Group_0__1 )
            // InternalOBJ.g:949:2: rule__PolyShape__Group_0__0__Impl rule__PolyShape__Group_0__1
            {
            pushFollow(FOLLOW_9);
            rule__PolyShape__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PolyShape__Group_0__1();

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
    // $ANTLR end "rule__PolyShape__Group_0__0"


    // $ANTLR start "rule__PolyShape__Group_0__0__Impl"
    // InternalOBJ.g:956:1: rule__PolyShape__Group_0__0__Impl : ( 'g' ) ;
    public final void rule__PolyShape__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:960:1: ( ( 'g' ) )
            // InternalOBJ.g:961:1: ( 'g' )
            {
            // InternalOBJ.g:961:1: ( 'g' )
            // InternalOBJ.g:962:2: 'g'
            {
             before(grammarAccess.getPolyShapeAccess().getGKeyword_0_0()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getPolyShapeAccess().getGKeyword_0_0()); 

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
    // $ANTLR end "rule__PolyShape__Group_0__0__Impl"


    // $ANTLR start "rule__PolyShape__Group_0__1"
    // InternalOBJ.g:971:1: rule__PolyShape__Group_0__1 : rule__PolyShape__Group_0__1__Impl ;
    public final void rule__PolyShape__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:975:1: ( rule__PolyShape__Group_0__1__Impl )
            // InternalOBJ.g:976:2: rule__PolyShape__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PolyShape__Group_0__1__Impl();

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
    // $ANTLR end "rule__PolyShape__Group_0__1"


    // $ANTLR start "rule__PolyShape__Group_0__1__Impl"
    // InternalOBJ.g:982:1: rule__PolyShape__Group_0__1__Impl : ( ( rule__PolyShape__NameAssignment_0_1 ) ) ;
    public final void rule__PolyShape__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:986:1: ( ( ( rule__PolyShape__NameAssignment_0_1 ) ) )
            // InternalOBJ.g:987:1: ( ( rule__PolyShape__NameAssignment_0_1 ) )
            {
            // InternalOBJ.g:987:1: ( ( rule__PolyShape__NameAssignment_0_1 ) )
            // InternalOBJ.g:988:2: ( rule__PolyShape__NameAssignment_0_1 )
            {
             before(grammarAccess.getPolyShapeAccess().getNameAssignment_0_1()); 
            // InternalOBJ.g:989:2: ( rule__PolyShape__NameAssignment_0_1 )
            // InternalOBJ.g:989:3: rule__PolyShape__NameAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__PolyShape__NameAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getPolyShapeAccess().getNameAssignment_0_1()); 

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
    // $ANTLR end "rule__PolyShape__Group_0__1__Impl"


    // $ANTLR start "rule__PolyShape__Group_1__0"
    // InternalOBJ.g:998:1: rule__PolyShape__Group_1__0 : rule__PolyShape__Group_1__0__Impl rule__PolyShape__Group_1__1 ;
    public final void rule__PolyShape__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1002:1: ( rule__PolyShape__Group_1__0__Impl rule__PolyShape__Group_1__1 )
            // InternalOBJ.g:1003:2: rule__PolyShape__Group_1__0__Impl rule__PolyShape__Group_1__1
            {
            pushFollow(FOLLOW_9);
            rule__PolyShape__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PolyShape__Group_1__1();

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
    // $ANTLR end "rule__PolyShape__Group_1__0"


    // $ANTLR start "rule__PolyShape__Group_1__0__Impl"
    // InternalOBJ.g:1010:1: rule__PolyShape__Group_1__0__Impl : ( 'usemtl' ) ;
    public final void rule__PolyShape__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1014:1: ( ( 'usemtl' ) )
            // InternalOBJ.g:1015:1: ( 'usemtl' )
            {
            // InternalOBJ.g:1015:1: ( 'usemtl' )
            // InternalOBJ.g:1016:2: 'usemtl'
            {
             before(grammarAccess.getPolyShapeAccess().getUsemtlKeyword_1_0()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getPolyShapeAccess().getUsemtlKeyword_1_0()); 

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
    // $ANTLR end "rule__PolyShape__Group_1__0__Impl"


    // $ANTLR start "rule__PolyShape__Group_1__1"
    // InternalOBJ.g:1025:1: rule__PolyShape__Group_1__1 : rule__PolyShape__Group_1__1__Impl ;
    public final void rule__PolyShape__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1029:1: ( rule__PolyShape__Group_1__1__Impl )
            // InternalOBJ.g:1030:2: rule__PolyShape__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PolyShape__Group_1__1__Impl();

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
    // $ANTLR end "rule__PolyShape__Group_1__1"


    // $ANTLR start "rule__PolyShape__Group_1__1__Impl"
    // InternalOBJ.g:1036:1: rule__PolyShape__Group_1__1__Impl : ( ( rule__PolyShape__MaterialAssignment_1_1 ) ) ;
    public final void rule__PolyShape__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1040:1: ( ( ( rule__PolyShape__MaterialAssignment_1_1 ) ) )
            // InternalOBJ.g:1041:1: ( ( rule__PolyShape__MaterialAssignment_1_1 ) )
            {
            // InternalOBJ.g:1041:1: ( ( rule__PolyShape__MaterialAssignment_1_1 ) )
            // InternalOBJ.g:1042:2: ( rule__PolyShape__MaterialAssignment_1_1 )
            {
             before(grammarAccess.getPolyShapeAccess().getMaterialAssignment_1_1()); 
            // InternalOBJ.g:1043:2: ( rule__PolyShape__MaterialAssignment_1_1 )
            // InternalOBJ.g:1043:3: rule__PolyShape__MaterialAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__PolyShape__MaterialAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getPolyShapeAccess().getMaterialAssignment_1_1()); 

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
    // $ANTLR end "rule__PolyShape__Group_1__1__Impl"


    // $ANTLR start "rule__PolyShape__Group_2_0__0"
    // InternalOBJ.g:1052:1: rule__PolyShape__Group_2_0__0 : rule__PolyShape__Group_2_0__0__Impl rule__PolyShape__Group_2_0__1 ;
    public final void rule__PolyShape__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1056:1: ( rule__PolyShape__Group_2_0__0__Impl rule__PolyShape__Group_2_0__1 )
            // InternalOBJ.g:1057:2: rule__PolyShape__Group_2_0__0__Impl rule__PolyShape__Group_2_0__1
            {
            pushFollow(FOLLOW_10);
            rule__PolyShape__Group_2_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PolyShape__Group_2_0__1();

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
    // $ANTLR end "rule__PolyShape__Group_2_0__0"


    // $ANTLR start "rule__PolyShape__Group_2_0__0__Impl"
    // InternalOBJ.g:1064:1: rule__PolyShape__Group_2_0__0__Impl : ( 'f' ) ;
    public final void rule__PolyShape__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1068:1: ( ( 'f' ) )
            // InternalOBJ.g:1069:1: ( 'f' )
            {
            // InternalOBJ.g:1069:1: ( 'f' )
            // InternalOBJ.g:1070:2: 'f'
            {
             before(grammarAccess.getPolyShapeAccess().getFKeyword_2_0_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getPolyShapeAccess().getFKeyword_2_0_0()); 

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
    // $ANTLR end "rule__PolyShape__Group_2_0__0__Impl"


    // $ANTLR start "rule__PolyShape__Group_2_0__1"
    // InternalOBJ.g:1079:1: rule__PolyShape__Group_2_0__1 : rule__PolyShape__Group_2_0__1__Impl ;
    public final void rule__PolyShape__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1083:1: ( rule__PolyShape__Group_2_0__1__Impl )
            // InternalOBJ.g:1084:2: rule__PolyShape__Group_2_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PolyShape__Group_2_0__1__Impl();

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
    // $ANTLR end "rule__PolyShape__Group_2_0__1"


    // $ANTLR start "rule__PolyShape__Group_2_0__1__Impl"
    // InternalOBJ.g:1090:1: rule__PolyShape__Group_2_0__1__Impl : ( ( rule__PolyShape__FacesAssignment_2_0_1 ) ) ;
    public final void rule__PolyShape__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1094:1: ( ( ( rule__PolyShape__FacesAssignment_2_0_1 ) ) )
            // InternalOBJ.g:1095:1: ( ( rule__PolyShape__FacesAssignment_2_0_1 ) )
            {
            // InternalOBJ.g:1095:1: ( ( rule__PolyShape__FacesAssignment_2_0_1 ) )
            // InternalOBJ.g:1096:2: ( rule__PolyShape__FacesAssignment_2_0_1 )
            {
             before(grammarAccess.getPolyShapeAccess().getFacesAssignment_2_0_1()); 
            // InternalOBJ.g:1097:2: ( rule__PolyShape__FacesAssignment_2_0_1 )
            // InternalOBJ.g:1097:3: rule__PolyShape__FacesAssignment_2_0_1
            {
            pushFollow(FOLLOW_2);
            rule__PolyShape__FacesAssignment_2_0_1();

            state._fsp--;


            }

             after(grammarAccess.getPolyShapeAccess().getFacesAssignment_2_0_1()); 

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
    // $ANTLR end "rule__PolyShape__Group_2_0__1__Impl"


    // $ANTLR start "rule__PolyShape__Group_2_1__0"
    // InternalOBJ.g:1106:1: rule__PolyShape__Group_2_1__0 : rule__PolyShape__Group_2_1__0__Impl rule__PolyShape__Group_2_1__1 ;
    public final void rule__PolyShape__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1110:1: ( rule__PolyShape__Group_2_1__0__Impl rule__PolyShape__Group_2_1__1 )
            // InternalOBJ.g:1111:2: rule__PolyShape__Group_2_1__0__Impl rule__PolyShape__Group_2_1__1
            {
            pushFollow(FOLLOW_11);
            rule__PolyShape__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PolyShape__Group_2_1__1();

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
    // $ANTLR end "rule__PolyShape__Group_2_1__0"


    // $ANTLR start "rule__PolyShape__Group_2_1__0__Impl"
    // InternalOBJ.g:1118:1: rule__PolyShape__Group_2_1__0__Impl : ( 's' ) ;
    public final void rule__PolyShape__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1122:1: ( ( 's' ) )
            // InternalOBJ.g:1123:1: ( 's' )
            {
            // InternalOBJ.g:1123:1: ( 's' )
            // InternalOBJ.g:1124:2: 's'
            {
             before(grammarAccess.getPolyShapeAccess().getSKeyword_2_1_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getPolyShapeAccess().getSKeyword_2_1_0()); 

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
    // $ANTLR end "rule__PolyShape__Group_2_1__0__Impl"


    // $ANTLR start "rule__PolyShape__Group_2_1__1"
    // InternalOBJ.g:1133:1: rule__PolyShape__Group_2_1__1 : rule__PolyShape__Group_2_1__1__Impl ;
    public final void rule__PolyShape__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1137:1: ( rule__PolyShape__Group_2_1__1__Impl )
            // InternalOBJ.g:1138:2: rule__PolyShape__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PolyShape__Group_2_1__1__Impl();

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
    // $ANTLR end "rule__PolyShape__Group_2_1__1"


    // $ANTLR start "rule__PolyShape__Group_2_1__1__Impl"
    // InternalOBJ.g:1144:1: rule__PolyShape__Group_2_1__1__Impl : ( ( rule__PolyShape__Alternatives_2_1_1 ) ) ;
    public final void rule__PolyShape__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1148:1: ( ( ( rule__PolyShape__Alternatives_2_1_1 ) ) )
            // InternalOBJ.g:1149:1: ( ( rule__PolyShape__Alternatives_2_1_1 ) )
            {
            // InternalOBJ.g:1149:1: ( ( rule__PolyShape__Alternatives_2_1_1 ) )
            // InternalOBJ.g:1150:2: ( rule__PolyShape__Alternatives_2_1_1 )
            {
             before(grammarAccess.getPolyShapeAccess().getAlternatives_2_1_1()); 
            // InternalOBJ.g:1151:2: ( rule__PolyShape__Alternatives_2_1_1 )
            // InternalOBJ.g:1151:3: rule__PolyShape__Alternatives_2_1_1
            {
            pushFollow(FOLLOW_2);
            rule__PolyShape__Alternatives_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getPolyShapeAccess().getAlternatives_2_1_1()); 

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
    // $ANTLR end "rule__PolyShape__Group_2_1__1__Impl"


    // $ANTLR start "rule__Face__Group__0"
    // InternalOBJ.g:1160:1: rule__Face__Group__0 : rule__Face__Group__0__Impl rule__Face__Group__1 ;
    public final void rule__Face__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1164:1: ( rule__Face__Group__0__Impl rule__Face__Group__1 )
            // InternalOBJ.g:1165:2: rule__Face__Group__0__Impl rule__Face__Group__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalOBJ.g:1172:1: rule__Face__Group__0__Impl : ( () ) ;
    public final void rule__Face__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1176:1: ( ( () ) )
            // InternalOBJ.g:1177:1: ( () )
            {
            // InternalOBJ.g:1177:1: ( () )
            // InternalOBJ.g:1178:2: ()
            {
             before(grammarAccess.getFaceAccess().getFaceAction_0()); 
            // InternalOBJ.g:1179:2: ()
            // InternalOBJ.g:1179:3: 
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
    // InternalOBJ.g:1187:1: rule__Face__Group__1 : rule__Face__Group__1__Impl ;
    public final void rule__Face__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1191:1: ( rule__Face__Group__1__Impl )
            // InternalOBJ.g:1192:2: rule__Face__Group__1__Impl
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
    // InternalOBJ.g:1198:1: rule__Face__Group__1__Impl : ( ( rule__Face__Group_1__0 )* ) ;
    public final void rule__Face__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1202:1: ( ( ( rule__Face__Group_1__0 )* ) )
            // InternalOBJ.g:1203:1: ( ( rule__Face__Group_1__0 )* )
            {
            // InternalOBJ.g:1203:1: ( ( rule__Face__Group_1__0 )* )
            // InternalOBJ.g:1204:2: ( rule__Face__Group_1__0 )*
            {
             before(grammarAccess.getFaceAccess().getGroup_1()); 
            // InternalOBJ.g:1205:2: ( rule__Face__Group_1__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_INT||LA17_0==26) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalOBJ.g:1205:3: rule__Face__Group_1__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__Face__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // InternalOBJ.g:1214:1: rule__Face__Group_1__0 : rule__Face__Group_1__0__Impl rule__Face__Group_1__1 ;
    public final void rule__Face__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1218:1: ( rule__Face__Group_1__0__Impl rule__Face__Group_1__1 )
            // InternalOBJ.g:1219:2: rule__Face__Group_1__0__Impl rule__Face__Group_1__1
            {
            pushFollow(FOLLOW_13);
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
    // InternalOBJ.g:1226:1: rule__Face__Group_1__0__Impl : ( ( rule__Face__VertexIndicesAssignment_1_0 ) ) ;
    public final void rule__Face__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1230:1: ( ( ( rule__Face__VertexIndicesAssignment_1_0 ) ) )
            // InternalOBJ.g:1231:1: ( ( rule__Face__VertexIndicesAssignment_1_0 ) )
            {
            // InternalOBJ.g:1231:1: ( ( rule__Face__VertexIndicesAssignment_1_0 ) )
            // InternalOBJ.g:1232:2: ( rule__Face__VertexIndicesAssignment_1_0 )
            {
             before(grammarAccess.getFaceAccess().getVertexIndicesAssignment_1_0()); 
            // InternalOBJ.g:1233:2: ( rule__Face__VertexIndicesAssignment_1_0 )
            // InternalOBJ.g:1233:3: rule__Face__VertexIndicesAssignment_1_0
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
    // InternalOBJ.g:1241:1: rule__Face__Group_1__1 : rule__Face__Group_1__1__Impl ;
    public final void rule__Face__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1245:1: ( rule__Face__Group_1__1__Impl )
            // InternalOBJ.g:1246:2: rule__Face__Group_1__1__Impl
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
    // InternalOBJ.g:1252:1: rule__Face__Group_1__1__Impl : ( ( rule__Face__Group_1_1__0 )? ) ;
    public final void rule__Face__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1256:1: ( ( ( rule__Face__Group_1_1__0 )? ) )
            // InternalOBJ.g:1257:1: ( ( rule__Face__Group_1_1__0 )? )
            {
            // InternalOBJ.g:1257:1: ( ( rule__Face__Group_1_1__0 )? )
            // InternalOBJ.g:1258:2: ( rule__Face__Group_1_1__0 )?
            {
             before(grammarAccess.getFaceAccess().getGroup_1_1()); 
            // InternalOBJ.g:1259:2: ( rule__Face__Group_1_1__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==16) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalOBJ.g:1259:3: rule__Face__Group_1_1__0
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
    // InternalOBJ.g:1268:1: rule__Face__Group_1_1__0 : rule__Face__Group_1_1__0__Impl rule__Face__Group_1_1__1 ;
    public final void rule__Face__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1272:1: ( rule__Face__Group_1_1__0__Impl rule__Face__Group_1_1__1 )
            // InternalOBJ.g:1273:2: rule__Face__Group_1_1__0__Impl rule__Face__Group_1_1__1
            {
            pushFollow(FOLLOW_14);
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
    // InternalOBJ.g:1280:1: rule__Face__Group_1_1__0__Impl : ( '/' ) ;
    public final void rule__Face__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1284:1: ( ( '/' ) )
            // InternalOBJ.g:1285:1: ( '/' )
            {
            // InternalOBJ.g:1285:1: ( '/' )
            // InternalOBJ.g:1286:2: '/'
            {
             before(grammarAccess.getFaceAccess().getSolidusKeyword_1_1_0()); 
            match(input,16,FOLLOW_2); 
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
    // InternalOBJ.g:1295:1: rule__Face__Group_1_1__1 : rule__Face__Group_1_1__1__Impl ;
    public final void rule__Face__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1299:1: ( rule__Face__Group_1_1__1__Impl )
            // InternalOBJ.g:1300:2: rule__Face__Group_1_1__1__Impl
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
    // InternalOBJ.g:1306:1: rule__Face__Group_1_1__1__Impl : ( ( rule__Face__Alternatives_1_1_1 ) ) ;
    public final void rule__Face__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1310:1: ( ( ( rule__Face__Alternatives_1_1_1 ) ) )
            // InternalOBJ.g:1311:1: ( ( rule__Face__Alternatives_1_1_1 ) )
            {
            // InternalOBJ.g:1311:1: ( ( rule__Face__Alternatives_1_1_1 ) )
            // InternalOBJ.g:1312:2: ( rule__Face__Alternatives_1_1_1 )
            {
             before(grammarAccess.getFaceAccess().getAlternatives_1_1_1()); 
            // InternalOBJ.g:1313:2: ( rule__Face__Alternatives_1_1_1 )
            // InternalOBJ.g:1313:3: rule__Face__Alternatives_1_1_1
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
    // InternalOBJ.g:1322:1: rule__Face__Group_1_1_1_1__0 : rule__Face__Group_1_1_1_1__0__Impl rule__Face__Group_1_1_1_1__1 ;
    public final void rule__Face__Group_1_1_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1326:1: ( rule__Face__Group_1_1_1_1__0__Impl rule__Face__Group_1_1_1_1__1 )
            // InternalOBJ.g:1327:2: rule__Face__Group_1_1_1_1__0__Impl rule__Face__Group_1_1_1_1__1
            {
            pushFollow(FOLLOW_13);
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
    // InternalOBJ.g:1334:1: rule__Face__Group_1_1_1_1__0__Impl : ( ( rule__Face__TextureIndicesAssignment_1_1_1_1_0 ) ) ;
    public final void rule__Face__Group_1_1_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1338:1: ( ( ( rule__Face__TextureIndicesAssignment_1_1_1_1_0 ) ) )
            // InternalOBJ.g:1339:1: ( ( rule__Face__TextureIndicesAssignment_1_1_1_1_0 ) )
            {
            // InternalOBJ.g:1339:1: ( ( rule__Face__TextureIndicesAssignment_1_1_1_1_0 ) )
            // InternalOBJ.g:1340:2: ( rule__Face__TextureIndicesAssignment_1_1_1_1_0 )
            {
             before(grammarAccess.getFaceAccess().getTextureIndicesAssignment_1_1_1_1_0()); 
            // InternalOBJ.g:1341:2: ( rule__Face__TextureIndicesAssignment_1_1_1_1_0 )
            // InternalOBJ.g:1341:3: rule__Face__TextureIndicesAssignment_1_1_1_1_0
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
    // InternalOBJ.g:1349:1: rule__Face__Group_1_1_1_1__1 : rule__Face__Group_1_1_1_1__1__Impl rule__Face__Group_1_1_1_1__2 ;
    public final void rule__Face__Group_1_1_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1353:1: ( rule__Face__Group_1_1_1_1__1__Impl rule__Face__Group_1_1_1_1__2 )
            // InternalOBJ.g:1354:2: rule__Face__Group_1_1_1_1__1__Impl rule__Face__Group_1_1_1_1__2
            {
            pushFollow(FOLLOW_10);
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
    // InternalOBJ.g:1361:1: rule__Face__Group_1_1_1_1__1__Impl : ( '/' ) ;
    public final void rule__Face__Group_1_1_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1365:1: ( ( '/' ) )
            // InternalOBJ.g:1366:1: ( '/' )
            {
            // InternalOBJ.g:1366:1: ( '/' )
            // InternalOBJ.g:1367:2: '/'
            {
             before(grammarAccess.getFaceAccess().getSolidusKeyword_1_1_1_1_1()); 
            match(input,16,FOLLOW_2); 
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
    // InternalOBJ.g:1376:1: rule__Face__Group_1_1_1_1__2 : rule__Face__Group_1_1_1_1__2__Impl ;
    public final void rule__Face__Group_1_1_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1380:1: ( rule__Face__Group_1_1_1_1__2__Impl )
            // InternalOBJ.g:1381:2: rule__Face__Group_1_1_1_1__2__Impl
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
    // InternalOBJ.g:1387:1: rule__Face__Group_1_1_1_1__2__Impl : ( ruleEInt ) ;
    public final void rule__Face__Group_1_1_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1391:1: ( ( ruleEInt ) )
            // InternalOBJ.g:1392:1: ( ruleEInt )
            {
            // InternalOBJ.g:1392:1: ( ruleEInt )
            // InternalOBJ.g:1393:2: ruleEInt
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
    // InternalOBJ.g:1403:1: rule__Face__Group_1_1_1_2__0 : rule__Face__Group_1_1_1_2__0__Impl rule__Face__Group_1_1_1_2__1 ;
    public final void rule__Face__Group_1_1_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1407:1: ( rule__Face__Group_1_1_1_2__0__Impl rule__Face__Group_1_1_1_2__1 )
            // InternalOBJ.g:1408:2: rule__Face__Group_1_1_1_2__0__Impl rule__Face__Group_1_1_1_2__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalOBJ.g:1415:1: rule__Face__Group_1_1_1_2__0__Impl : ( '/' ) ;
    public final void rule__Face__Group_1_1_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1419:1: ( ( '/' ) )
            // InternalOBJ.g:1420:1: ( '/' )
            {
            // InternalOBJ.g:1420:1: ( '/' )
            // InternalOBJ.g:1421:2: '/'
            {
             before(grammarAccess.getFaceAccess().getSolidusKeyword_1_1_1_2_0()); 
            match(input,16,FOLLOW_2); 
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
    // InternalOBJ.g:1430:1: rule__Face__Group_1_1_1_2__1 : rule__Face__Group_1_1_1_2__1__Impl ;
    public final void rule__Face__Group_1_1_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1434:1: ( rule__Face__Group_1_1_1_2__1__Impl )
            // InternalOBJ.g:1435:2: rule__Face__Group_1_1_1_2__1__Impl
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
    // InternalOBJ.g:1441:1: rule__Face__Group_1_1_1_2__1__Impl : ( ruleEInt ) ;
    public final void rule__Face__Group_1_1_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1445:1: ( ( ruleEInt ) )
            // InternalOBJ.g:1446:1: ( ruleEInt )
            {
            // InternalOBJ.g:1446:1: ( ruleEInt )
            // InternalOBJ.g:1447:2: ruleEInt
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
    // InternalOBJ.g:1457:1: rule__Vertex__Group__0 : rule__Vertex__Group__0__Impl rule__Vertex__Group__1 ;
    public final void rule__Vertex__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1461:1: ( rule__Vertex__Group__0__Impl rule__Vertex__Group__1 )
            // InternalOBJ.g:1462:2: rule__Vertex__Group__0__Impl rule__Vertex__Group__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalOBJ.g:1469:1: rule__Vertex__Group__0__Impl : ( () ) ;
    public final void rule__Vertex__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1473:1: ( ( () ) )
            // InternalOBJ.g:1474:1: ( () )
            {
            // InternalOBJ.g:1474:1: ( () )
            // InternalOBJ.g:1475:2: ()
            {
             before(grammarAccess.getVertexAccess().getVertexAction_0()); 
            // InternalOBJ.g:1476:2: ()
            // InternalOBJ.g:1476:3: 
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
    // InternalOBJ.g:1484:1: rule__Vertex__Group__1 : rule__Vertex__Group__1__Impl rule__Vertex__Group__2 ;
    public final void rule__Vertex__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1488:1: ( rule__Vertex__Group__1__Impl rule__Vertex__Group__2 )
            // InternalOBJ.g:1489:2: rule__Vertex__Group__1__Impl rule__Vertex__Group__2
            {
            pushFollow(FOLLOW_10);
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
    // InternalOBJ.g:1496:1: rule__Vertex__Group__1__Impl : ( ( rule__Vertex__XAssignment_1 ) ) ;
    public final void rule__Vertex__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1500:1: ( ( ( rule__Vertex__XAssignment_1 ) ) )
            // InternalOBJ.g:1501:1: ( ( rule__Vertex__XAssignment_1 ) )
            {
            // InternalOBJ.g:1501:1: ( ( rule__Vertex__XAssignment_1 ) )
            // InternalOBJ.g:1502:2: ( rule__Vertex__XAssignment_1 )
            {
             before(grammarAccess.getVertexAccess().getXAssignment_1()); 
            // InternalOBJ.g:1503:2: ( rule__Vertex__XAssignment_1 )
            // InternalOBJ.g:1503:3: rule__Vertex__XAssignment_1
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
    // InternalOBJ.g:1511:1: rule__Vertex__Group__2 : rule__Vertex__Group__2__Impl rule__Vertex__Group__3 ;
    public final void rule__Vertex__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1515:1: ( rule__Vertex__Group__2__Impl rule__Vertex__Group__3 )
            // InternalOBJ.g:1516:2: rule__Vertex__Group__2__Impl rule__Vertex__Group__3
            {
            pushFollow(FOLLOW_10);
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
    // InternalOBJ.g:1523:1: rule__Vertex__Group__2__Impl : ( ( rule__Vertex__YAssignment_2 ) ) ;
    public final void rule__Vertex__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1527:1: ( ( ( rule__Vertex__YAssignment_2 ) ) )
            // InternalOBJ.g:1528:1: ( ( rule__Vertex__YAssignment_2 ) )
            {
            // InternalOBJ.g:1528:1: ( ( rule__Vertex__YAssignment_2 ) )
            // InternalOBJ.g:1529:2: ( rule__Vertex__YAssignment_2 )
            {
             before(grammarAccess.getVertexAccess().getYAssignment_2()); 
            // InternalOBJ.g:1530:2: ( rule__Vertex__YAssignment_2 )
            // InternalOBJ.g:1530:3: rule__Vertex__YAssignment_2
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
    // InternalOBJ.g:1538:1: rule__Vertex__Group__3 : rule__Vertex__Group__3__Impl ;
    public final void rule__Vertex__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1542:1: ( rule__Vertex__Group__3__Impl )
            // InternalOBJ.g:1543:2: rule__Vertex__Group__3__Impl
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
    // InternalOBJ.g:1549:1: rule__Vertex__Group__3__Impl : ( ( rule__Vertex__ZAssignment_3 ) ) ;
    public final void rule__Vertex__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1553:1: ( ( ( rule__Vertex__ZAssignment_3 ) ) )
            // InternalOBJ.g:1554:1: ( ( rule__Vertex__ZAssignment_3 ) )
            {
            // InternalOBJ.g:1554:1: ( ( rule__Vertex__ZAssignment_3 ) )
            // InternalOBJ.g:1555:2: ( rule__Vertex__ZAssignment_3 )
            {
             before(grammarAccess.getVertexAccess().getZAssignment_3()); 
            // InternalOBJ.g:1556:2: ( rule__Vertex__ZAssignment_3 )
            // InternalOBJ.g:1556:3: rule__Vertex__ZAssignment_3
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
    // InternalOBJ.g:1565:1: rule__TextureVertex__Group__0 : rule__TextureVertex__Group__0__Impl rule__TextureVertex__Group__1 ;
    public final void rule__TextureVertex__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1569:1: ( rule__TextureVertex__Group__0__Impl rule__TextureVertex__Group__1 )
            // InternalOBJ.g:1570:2: rule__TextureVertex__Group__0__Impl rule__TextureVertex__Group__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalOBJ.g:1577:1: rule__TextureVertex__Group__0__Impl : ( ( rule__TextureVertex__XAssignment_0 ) ) ;
    public final void rule__TextureVertex__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1581:1: ( ( ( rule__TextureVertex__XAssignment_0 ) ) )
            // InternalOBJ.g:1582:1: ( ( rule__TextureVertex__XAssignment_0 ) )
            {
            // InternalOBJ.g:1582:1: ( ( rule__TextureVertex__XAssignment_0 ) )
            // InternalOBJ.g:1583:2: ( rule__TextureVertex__XAssignment_0 )
            {
             before(grammarAccess.getTextureVertexAccess().getXAssignment_0()); 
            // InternalOBJ.g:1584:2: ( rule__TextureVertex__XAssignment_0 )
            // InternalOBJ.g:1584:3: rule__TextureVertex__XAssignment_0
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
    // InternalOBJ.g:1592:1: rule__TextureVertex__Group__1 : rule__TextureVertex__Group__1__Impl rule__TextureVertex__Group__2 ;
    public final void rule__TextureVertex__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1596:1: ( rule__TextureVertex__Group__1__Impl rule__TextureVertex__Group__2 )
            // InternalOBJ.g:1597:2: rule__TextureVertex__Group__1__Impl rule__TextureVertex__Group__2
            {
            pushFollow(FOLLOW_10);
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
    // InternalOBJ.g:1604:1: rule__TextureVertex__Group__1__Impl : ( ( rule__TextureVertex__YAssignment_1 ) ) ;
    public final void rule__TextureVertex__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1608:1: ( ( ( rule__TextureVertex__YAssignment_1 ) ) )
            // InternalOBJ.g:1609:1: ( ( rule__TextureVertex__YAssignment_1 ) )
            {
            // InternalOBJ.g:1609:1: ( ( rule__TextureVertex__YAssignment_1 ) )
            // InternalOBJ.g:1610:2: ( rule__TextureVertex__YAssignment_1 )
            {
             before(grammarAccess.getTextureVertexAccess().getYAssignment_1()); 
            // InternalOBJ.g:1611:2: ( rule__TextureVertex__YAssignment_1 )
            // InternalOBJ.g:1611:3: rule__TextureVertex__YAssignment_1
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
    // InternalOBJ.g:1619:1: rule__TextureVertex__Group__2 : rule__TextureVertex__Group__2__Impl ;
    public final void rule__TextureVertex__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1623:1: ( rule__TextureVertex__Group__2__Impl )
            // InternalOBJ.g:1624:2: rule__TextureVertex__Group__2__Impl
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
    // InternalOBJ.g:1630:1: rule__TextureVertex__Group__2__Impl : ( ( rule__TextureVertex__ZAssignment_2 )? ) ;
    public final void rule__TextureVertex__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1634:1: ( ( ( rule__TextureVertex__ZAssignment_2 )? ) )
            // InternalOBJ.g:1635:1: ( ( rule__TextureVertex__ZAssignment_2 )? )
            {
            // InternalOBJ.g:1635:1: ( ( rule__TextureVertex__ZAssignment_2 )? )
            // InternalOBJ.g:1636:2: ( rule__TextureVertex__ZAssignment_2 )?
            {
             before(grammarAccess.getTextureVertexAccess().getZAssignment_2()); 
            // InternalOBJ.g:1637:2: ( rule__TextureVertex__ZAssignment_2 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=RULE_DOUBLE && LA19_0<=RULE_INT)||LA19_0==26) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalOBJ.g:1637:3: rule__TextureVertex__ZAssignment_2
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


    // $ANTLR start "rule__Material__Group__0"
    // InternalOBJ.g:1646:1: rule__Material__Group__0 : rule__Material__Group__0__Impl rule__Material__Group__1 ;
    public final void rule__Material__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1650:1: ( rule__Material__Group__0__Impl rule__Material__Group__1 )
            // InternalOBJ.g:1651:2: rule__Material__Group__0__Impl rule__Material__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__Material__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Material__Group__1();

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
    // $ANTLR end "rule__Material__Group__0"


    // $ANTLR start "rule__Material__Group__0__Impl"
    // InternalOBJ.g:1658:1: rule__Material__Group__0__Impl : ( () ) ;
    public final void rule__Material__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1662:1: ( ( () ) )
            // InternalOBJ.g:1663:1: ( () )
            {
            // InternalOBJ.g:1663:1: ( () )
            // InternalOBJ.g:1664:2: ()
            {
             before(grammarAccess.getMaterialAccess().getMaterialAction_0()); 
            // InternalOBJ.g:1665:2: ()
            // InternalOBJ.g:1665:3: 
            {
            }

             after(grammarAccess.getMaterialAccess().getMaterialAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Material__Group__0__Impl"


    // $ANTLR start "rule__Material__Group__1"
    // InternalOBJ.g:1673:1: rule__Material__Group__1 : rule__Material__Group__1__Impl ;
    public final void rule__Material__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1677:1: ( rule__Material__Group__1__Impl )
            // InternalOBJ.g:1678:2: rule__Material__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Material__Group__1__Impl();

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
    // $ANTLR end "rule__Material__Group__1"


    // $ANTLR start "rule__Material__Group__1__Impl"
    // InternalOBJ.g:1684:1: rule__Material__Group__1__Impl : ( ( rule__Material__NameAssignment_1 ) ) ;
    public final void rule__Material__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1688:1: ( ( ( rule__Material__NameAssignment_1 ) ) )
            // InternalOBJ.g:1689:1: ( ( rule__Material__NameAssignment_1 ) )
            {
            // InternalOBJ.g:1689:1: ( ( rule__Material__NameAssignment_1 ) )
            // InternalOBJ.g:1690:2: ( rule__Material__NameAssignment_1 )
            {
             before(grammarAccess.getMaterialAccess().getNameAssignment_1()); 
            // InternalOBJ.g:1691:2: ( rule__Material__NameAssignment_1 )
            // InternalOBJ.g:1691:3: rule__Material__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Material__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMaterialAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__Material__Group__1__Impl"


    // $ANTLR start "rule__EInt__Group__0"
    // InternalOBJ.g:1700:1: rule__EInt__Group__0 : rule__EInt__Group__0__Impl rule__EInt__Group__1 ;
    public final void rule__EInt__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1704:1: ( rule__EInt__Group__0__Impl rule__EInt__Group__1 )
            // InternalOBJ.g:1705:2: rule__EInt__Group__0__Impl rule__EInt__Group__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalOBJ.g:1712:1: rule__EInt__Group__0__Impl : ( ( '-' )? ) ;
    public final void rule__EInt__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1716:1: ( ( ( '-' )? ) )
            // InternalOBJ.g:1717:1: ( ( '-' )? )
            {
            // InternalOBJ.g:1717:1: ( ( '-' )? )
            // InternalOBJ.g:1718:2: ( '-' )?
            {
             before(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
            // InternalOBJ.g:1719:2: ( '-' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==26) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalOBJ.g:1719:3: '-'
                    {
                    match(input,26,FOLLOW_2); 

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
    // InternalOBJ.g:1727:1: rule__EInt__Group__1 : rule__EInt__Group__1__Impl ;
    public final void rule__EInt__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1731:1: ( rule__EInt__Group__1__Impl )
            // InternalOBJ.g:1732:2: rule__EInt__Group__1__Impl
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
    // InternalOBJ.g:1738:1: rule__EInt__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__EInt__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1742:1: ( ( RULE_INT ) )
            // InternalOBJ.g:1743:1: ( RULE_INT )
            {
            // InternalOBJ.g:1743:1: ( RULE_INT )
            // InternalOBJ.g:1744:2: RULE_INT
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
    // InternalOBJ.g:1754:1: rule__Geometry__VertexSourceAssignment_0 : ( ruleVertexSource ) ;
    public final void rule__Geometry__VertexSourceAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1758:1: ( ( ruleVertexSource ) )
            // InternalOBJ.g:1759:2: ( ruleVertexSource )
            {
            // InternalOBJ.g:1759:2: ( ruleVertexSource )
            // InternalOBJ.g:1760:3: ruleVertexSource
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
    // InternalOBJ.g:1769:1: rule__Geometry__NodesAssignment_1 : ( rulePolyShape ) ;
    public final void rule__Geometry__NodesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1773:1: ( ( rulePolyShape ) )
            // InternalOBJ.g:1774:2: ( rulePolyShape )
            {
            // InternalOBJ.g:1774:2: ( rulePolyShape )
            // InternalOBJ.g:1775:3: rulePolyShape
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


    // $ANTLR start "rule__VertexSource__MaterialFilesAssignment_1_1"
    // InternalOBJ.g:1784:1: rule__VertexSource__MaterialFilesAssignment_1_1 : ( ruleEString ) ;
    public final void rule__VertexSource__MaterialFilesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1788:1: ( ( ruleEString ) )
            // InternalOBJ.g:1789:2: ( ruleEString )
            {
            // InternalOBJ.g:1789:2: ( ruleEString )
            // InternalOBJ.g:1790:3: ruleEString
            {
             before(grammarAccess.getVertexSourceAccess().getMaterialFilesEStringParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getVertexSourceAccess().getMaterialFilesEStringParserRuleCall_1_1_0()); 

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
    // $ANTLR end "rule__VertexSource__MaterialFilesAssignment_1_1"


    // $ANTLR start "rule__VertexSource__VerticesAssignment_3_0_1"
    // InternalOBJ.g:1799:1: rule__VertexSource__VerticesAssignment_3_0_1 : ( ruleVertex ) ;
    public final void rule__VertexSource__VerticesAssignment_3_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1803:1: ( ( ruleVertex ) )
            // InternalOBJ.g:1804:2: ( ruleVertex )
            {
            // InternalOBJ.g:1804:2: ( ruleVertex )
            // InternalOBJ.g:1805:3: ruleVertex
            {
             before(grammarAccess.getVertexSourceAccess().getVerticesVertexParserRuleCall_3_0_1_0()); 
            pushFollow(FOLLOW_2);
            ruleVertex();

            state._fsp--;

             after(grammarAccess.getVertexSourceAccess().getVerticesVertexParserRuleCall_3_0_1_0()); 

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
    // $ANTLR end "rule__VertexSource__VerticesAssignment_3_0_1"


    // $ANTLR start "rule__VertexSource__TextureCoordinatesAssignment_3_1_1"
    // InternalOBJ.g:1814:1: rule__VertexSource__TextureCoordinatesAssignment_3_1_1 : ( ruleTextureVertex ) ;
    public final void rule__VertexSource__TextureCoordinatesAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1818:1: ( ( ruleTextureVertex ) )
            // InternalOBJ.g:1819:2: ( ruleTextureVertex )
            {
            // InternalOBJ.g:1819:2: ( ruleTextureVertex )
            // InternalOBJ.g:1820:3: ruleTextureVertex
            {
             before(grammarAccess.getVertexSourceAccess().getTextureCoordinatesTextureVertexParserRuleCall_3_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTextureVertex();

            state._fsp--;

             after(grammarAccess.getVertexSourceAccess().getTextureCoordinatesTextureVertexParserRuleCall_3_1_1_0()); 

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
    // $ANTLR end "rule__VertexSource__TextureCoordinatesAssignment_3_1_1"


    // $ANTLR start "rule__PolyShape__NameAssignment_0_1"
    // InternalOBJ.g:1829:1: rule__PolyShape__NameAssignment_0_1 : ( ruleEString ) ;
    public final void rule__PolyShape__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1833:1: ( ( ruleEString ) )
            // InternalOBJ.g:1834:2: ( ruleEString )
            {
            // InternalOBJ.g:1834:2: ( ruleEString )
            // InternalOBJ.g:1835:3: ruleEString
            {
             before(grammarAccess.getPolyShapeAccess().getNameEStringParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getPolyShapeAccess().getNameEStringParserRuleCall_0_1_0()); 

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
    // $ANTLR end "rule__PolyShape__NameAssignment_0_1"


    // $ANTLR start "rule__PolyShape__MaterialAssignment_1_1"
    // InternalOBJ.g:1844:1: rule__PolyShape__MaterialAssignment_1_1 : ( ruleMaterial ) ;
    public final void rule__PolyShape__MaterialAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1848:1: ( ( ruleMaterial ) )
            // InternalOBJ.g:1849:2: ( ruleMaterial )
            {
            // InternalOBJ.g:1849:2: ( ruleMaterial )
            // InternalOBJ.g:1850:3: ruleMaterial
            {
             before(grammarAccess.getPolyShapeAccess().getMaterialMaterialParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMaterial();

            state._fsp--;

             after(grammarAccess.getPolyShapeAccess().getMaterialMaterialParserRuleCall_1_1_0()); 

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
    // $ANTLR end "rule__PolyShape__MaterialAssignment_1_1"


    // $ANTLR start "rule__PolyShape__FacesAssignment_2_0_1"
    // InternalOBJ.g:1859:1: rule__PolyShape__FacesAssignment_2_0_1 : ( ruleFace ) ;
    public final void rule__PolyShape__FacesAssignment_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1863:1: ( ( ruleFace ) )
            // InternalOBJ.g:1864:2: ( ruleFace )
            {
            // InternalOBJ.g:1864:2: ( ruleFace )
            // InternalOBJ.g:1865:3: ruleFace
            {
             before(grammarAccess.getPolyShapeAccess().getFacesFaceParserRuleCall_2_0_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFace();

            state._fsp--;

             after(grammarAccess.getPolyShapeAccess().getFacesFaceParserRuleCall_2_0_1_0()); 

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
    // $ANTLR end "rule__PolyShape__FacesAssignment_2_0_1"


    // $ANTLR start "rule__Face__VertexIndicesAssignment_1_0"
    // InternalOBJ.g:1874:1: rule__Face__VertexIndicesAssignment_1_0 : ( ruleEInt ) ;
    public final void rule__Face__VertexIndicesAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1878:1: ( ( ruleEInt ) )
            // InternalOBJ.g:1879:2: ( ruleEInt )
            {
            // InternalOBJ.g:1879:2: ( ruleEInt )
            // InternalOBJ.g:1880:3: ruleEInt
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
    // InternalOBJ.g:1889:1: rule__Face__TextureIndicesAssignment_1_1_1_0 : ( ruleEInt ) ;
    public final void rule__Face__TextureIndicesAssignment_1_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1893:1: ( ( ruleEInt ) )
            // InternalOBJ.g:1894:2: ( ruleEInt )
            {
            // InternalOBJ.g:1894:2: ( ruleEInt )
            // InternalOBJ.g:1895:3: ruleEInt
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
    // InternalOBJ.g:1904:1: rule__Face__TextureIndicesAssignment_1_1_1_1_0 : ( ruleEInt ) ;
    public final void rule__Face__TextureIndicesAssignment_1_1_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1908:1: ( ( ruleEInt ) )
            // InternalOBJ.g:1909:2: ( ruleEInt )
            {
            // InternalOBJ.g:1909:2: ( ruleEInt )
            // InternalOBJ.g:1910:3: ruleEInt
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
    // InternalOBJ.g:1919:1: rule__Vertex__XAssignment_1 : ( ruleEDouble ) ;
    public final void rule__Vertex__XAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1923:1: ( ( ruleEDouble ) )
            // InternalOBJ.g:1924:2: ( ruleEDouble )
            {
            // InternalOBJ.g:1924:2: ( ruleEDouble )
            // InternalOBJ.g:1925:3: ruleEDouble
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
    // InternalOBJ.g:1934:1: rule__Vertex__YAssignment_2 : ( ruleEDouble ) ;
    public final void rule__Vertex__YAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1938:1: ( ( ruleEDouble ) )
            // InternalOBJ.g:1939:2: ( ruleEDouble )
            {
            // InternalOBJ.g:1939:2: ( ruleEDouble )
            // InternalOBJ.g:1940:3: ruleEDouble
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
    // InternalOBJ.g:1949:1: rule__Vertex__ZAssignment_3 : ( ruleEDouble ) ;
    public final void rule__Vertex__ZAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1953:1: ( ( ruleEDouble ) )
            // InternalOBJ.g:1954:2: ( ruleEDouble )
            {
            // InternalOBJ.g:1954:2: ( ruleEDouble )
            // InternalOBJ.g:1955:3: ruleEDouble
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
    // InternalOBJ.g:1964:1: rule__TextureVertex__XAssignment_0 : ( ruleEDouble ) ;
    public final void rule__TextureVertex__XAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1968:1: ( ( ruleEDouble ) )
            // InternalOBJ.g:1969:2: ( ruleEDouble )
            {
            // InternalOBJ.g:1969:2: ( ruleEDouble )
            // InternalOBJ.g:1970:3: ruleEDouble
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
    // InternalOBJ.g:1979:1: rule__TextureVertex__YAssignment_1 : ( ruleEDouble ) ;
    public final void rule__TextureVertex__YAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1983:1: ( ( ruleEDouble ) )
            // InternalOBJ.g:1984:2: ( ruleEDouble )
            {
            // InternalOBJ.g:1984:2: ( ruleEDouble )
            // InternalOBJ.g:1985:3: ruleEDouble
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
    // InternalOBJ.g:1994:1: rule__TextureVertex__ZAssignment_2 : ( ruleEDouble ) ;
    public final void rule__TextureVertex__ZAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1998:1: ( ( ruleEDouble ) )
            // InternalOBJ.g:1999:2: ( ruleEDouble )
            {
            // InternalOBJ.g:1999:2: ( ruleEDouble )
            // InternalOBJ.g:2000:3: ruleEDouble
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


    // $ANTLR start "rule__Material__NameAssignment_1"
    // InternalOBJ.g:2009:1: rule__Material__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Material__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:2013:1: ( ( ruleEString ) )
            // InternalOBJ.g:2014:2: ( ruleEString )
            {
            // InternalOBJ.g:2014:2: ( ruleEString )
            // InternalOBJ.g:2015:3: ruleEString
            {
             before(grammarAccess.getMaterialAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getMaterialAccess().getNameEStringParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__Material__NameAssignment_1"

    // Delegated rules


    protected DFA8 dfa8 = new DFA8(this);
    static final String dfa_1s = "\20\uffff";
    static final String dfa_2s = "\1\3\17\uffff";
    static final String dfa_3s = "\1\4\1\uffff\1\4\1\uffff\14\4";
    static final String dfa_4s = "\1\31\1\uffff\1\26\1\uffff\14\31";
    static final String dfa_5s = "\1\uffff\1\1\1\uffff\1\2\14\uffff";
    static final String dfa_6s = "\20\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\16\uffff\1\1\1\2\2\1\3\3",
            "",
            "\1\1\1\4\1\5\10\uffff\1\6\1\7\1\10\1\11\2\uffff\2\1",
            "",
            "\1\1\1\12\1\13\10\uffff\1\14\1\15\1\16\1\17\2\uffff\2\1\3\3",
            "\1\1\1\12\1\13\10\uffff\1\14\1\15\1\16\1\17\2\uffff\2\1\3\3",
            "\1\1\1\12\1\13\10\uffff\1\14\1\15\1\16\1\17\2\uffff\2\1\3\3",
            "\1\1\1\12\1\13\10\uffff\1\14\1\15\1\16\1\17\2\uffff\2\1\3\3",
            "\1\1\1\12\1\13\10\uffff\1\14\1\15\1\16\1\17\2\uffff\2\1\3\3",
            "\1\1\1\12\1\13\10\uffff\1\14\1\15\1\16\1\17\2\uffff\2\1\3\3",
            "\1\1\1\12\1\13\10\uffff\1\14\1\15\1\16\1\17\2\uffff\2\1\3\3",
            "\1\1\1\12\1\13\10\uffff\1\14\1\15\1\16\1\17\2\uffff\2\1\3\3",
            "\1\1\1\12\1\13\10\uffff\1\14\1\15\1\16\1\17\2\uffff\2\1\3\3",
            "\1\1\1\12\1\13\10\uffff\1\14\1\15\1\16\1\17\2\uffff\2\1\3\3",
            "\1\1\1\12\1\13\10\uffff\1\14\1\15\1\16\1\17\2\uffff\2\1\3\3",
            "\1\1\1\12\1\13\10\uffff\1\14\1\15\1\16\1\17\2\uffff\2\1\3\3"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "490:2: ( rule__Geometry__VertexSourceAssignment_0 )?";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000078062L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000003900000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000003900002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000780010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000780012L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000078060L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000004000180L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000004004180L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000004000182L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000004010180L});

}