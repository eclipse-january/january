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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_DOUBLE", "RULE_SL_COMMENT", "RULE_WS", "RULE_ML_COMMENT", "RULE_ANY_OTHER", "'off'", "'.'", "'/'", "'\\\\'", "':'", "'_'", "'-'", "'mtllib'", "'g'", "'v'", "'vt'", "'vn'", "'usemtl'", "'f'", "'s'"
    };
    public static final int RULE_STRING=4;
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
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__26=26;
    public static final int RULE_INT=6;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=10;
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
    // InternalOBJ.g:62:1: ruleGeometry : ( ( rule__Geometry__Alternatives )* ) ;
    public final void ruleGeometry() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:66:2: ( ( ( rule__Geometry__Alternatives )* ) )
            // InternalOBJ.g:67:2: ( ( rule__Geometry__Alternatives )* )
            {
            // InternalOBJ.g:67:2: ( ( rule__Geometry__Alternatives )* )
            // InternalOBJ.g:68:3: ( rule__Geometry__Alternatives )*
            {
             before(grammarAccess.getGeometryAccess().getAlternatives()); 
            // InternalOBJ.g:69:3: ( rule__Geometry__Alternatives )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=19 && LA1_0<=26)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalOBJ.g:69:4: rule__Geometry__Alternatives
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Geometry__Alternatives();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getGeometryAccess().getAlternatives()); 

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
            pushFollow(FOLLOW_4);
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
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=RULE_STRING && LA2_0<=RULE_INT)||(LA2_0>=13 && LA2_0<=18)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalOBJ.g:275:5: rule__EString__Alternatives
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__EString__Alternatives();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
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


    // $ANTLR start "rule__Geometry__Alternatives"
    // InternalOBJ.g:309:1: rule__Geometry__Alternatives : ( ( ( rule__Geometry__VertexSourcesAssignment_0 ) ) | ( ( rule__Geometry__NodesAssignment_1 ) ) );
    public final void rule__Geometry__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:313:1: ( ( ( rule__Geometry__VertexSourcesAssignment_0 ) ) | ( ( rule__Geometry__NodesAssignment_1 ) ) )
            int alt3=2;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // InternalOBJ.g:314:2: ( ( rule__Geometry__VertexSourcesAssignment_0 ) )
                    {
                    // InternalOBJ.g:314:2: ( ( rule__Geometry__VertexSourcesAssignment_0 ) )
                    // InternalOBJ.g:315:3: ( rule__Geometry__VertexSourcesAssignment_0 )
                    {
                     before(grammarAccess.getGeometryAccess().getVertexSourcesAssignment_0()); 
                    // InternalOBJ.g:316:3: ( rule__Geometry__VertexSourcesAssignment_0 )
                    // InternalOBJ.g:316:4: rule__Geometry__VertexSourcesAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Geometry__VertexSourcesAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getGeometryAccess().getVertexSourcesAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOBJ.g:320:2: ( ( rule__Geometry__NodesAssignment_1 ) )
                    {
                    // InternalOBJ.g:320:2: ( ( rule__Geometry__NodesAssignment_1 ) )
                    // InternalOBJ.g:321:3: ( rule__Geometry__NodesAssignment_1 )
                    {
                     before(grammarAccess.getGeometryAccess().getNodesAssignment_1()); 
                    // InternalOBJ.g:322:3: ( rule__Geometry__NodesAssignment_1 )
                    // InternalOBJ.g:322:4: rule__Geometry__NodesAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Geometry__NodesAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getGeometryAccess().getNodesAssignment_1()); 

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
    // $ANTLR end "rule__Geometry__Alternatives"


    // $ANTLR start "rule__VertexSource__Alternatives_3"
    // InternalOBJ.g:330:1: rule__VertexSource__Alternatives_3 : ( ( ( rule__VertexSource__Group_3_0__0 ) ) | ( ( rule__VertexSource__Group_3_1__0 ) ) | ( ( rule__VertexSource__Group_3_2__0 ) ) );
    public final void rule__VertexSource__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:334:1: ( ( ( rule__VertexSource__Group_3_0__0 ) ) | ( ( rule__VertexSource__Group_3_1__0 ) ) | ( ( rule__VertexSource__Group_3_2__0 ) ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt4=1;
                }
                break;
            case 22:
                {
                alt4=2;
                }
                break;
            case 23:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalOBJ.g:335:2: ( ( rule__VertexSource__Group_3_0__0 ) )
                    {
                    // InternalOBJ.g:335:2: ( ( rule__VertexSource__Group_3_0__0 ) )
                    // InternalOBJ.g:336:3: ( rule__VertexSource__Group_3_0__0 )
                    {
                     before(grammarAccess.getVertexSourceAccess().getGroup_3_0()); 
                    // InternalOBJ.g:337:3: ( rule__VertexSource__Group_3_0__0 )
                    // InternalOBJ.g:337:4: rule__VertexSource__Group_3_0__0
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
                    // InternalOBJ.g:341:2: ( ( rule__VertexSource__Group_3_1__0 ) )
                    {
                    // InternalOBJ.g:341:2: ( ( rule__VertexSource__Group_3_1__0 ) )
                    // InternalOBJ.g:342:3: ( rule__VertexSource__Group_3_1__0 )
                    {
                     before(grammarAccess.getVertexSourceAccess().getGroup_3_1()); 
                    // InternalOBJ.g:343:3: ( rule__VertexSource__Group_3_1__0 )
                    // InternalOBJ.g:343:4: rule__VertexSource__Group_3_1__0
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
                    // InternalOBJ.g:347:2: ( ( rule__VertexSource__Group_3_2__0 ) )
                    {
                    // InternalOBJ.g:347:2: ( ( rule__VertexSource__Group_3_2__0 ) )
                    // InternalOBJ.g:348:3: ( rule__VertexSource__Group_3_2__0 )
                    {
                     before(grammarAccess.getVertexSourceAccess().getGroup_3_2()); 
                    // InternalOBJ.g:349:3: ( rule__VertexSource__Group_3_2__0 )
                    // InternalOBJ.g:349:4: rule__VertexSource__Group_3_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__VertexSource__Group_3_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getVertexSourceAccess().getGroup_3_2()); 

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


    // $ANTLR start "rule__PolyShape__Alternatives_4"
    // InternalOBJ.g:357:1: rule__PolyShape__Alternatives_4 : ( ( ( rule__PolyShape__Group_4_0__0 ) ) | ( ( rule__PolyShape__Group_4_1__0 ) ) );
    public final void rule__PolyShape__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:361:1: ( ( ( rule__PolyShape__Group_4_0__0 ) ) | ( ( rule__PolyShape__Group_4_1__0 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==25) ) {
                alt5=1;
            }
            else if ( (LA5_0==26) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalOBJ.g:362:2: ( ( rule__PolyShape__Group_4_0__0 ) )
                    {
                    // InternalOBJ.g:362:2: ( ( rule__PolyShape__Group_4_0__0 ) )
                    // InternalOBJ.g:363:3: ( rule__PolyShape__Group_4_0__0 )
                    {
                     before(grammarAccess.getPolyShapeAccess().getGroup_4_0()); 
                    // InternalOBJ.g:364:3: ( rule__PolyShape__Group_4_0__0 )
                    // InternalOBJ.g:364:4: rule__PolyShape__Group_4_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PolyShape__Group_4_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPolyShapeAccess().getGroup_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOBJ.g:368:2: ( ( rule__PolyShape__Group_4_1__0 ) )
                    {
                    // InternalOBJ.g:368:2: ( ( rule__PolyShape__Group_4_1__0 ) )
                    // InternalOBJ.g:369:3: ( rule__PolyShape__Group_4_1__0 )
                    {
                     before(grammarAccess.getPolyShapeAccess().getGroup_4_1()); 
                    // InternalOBJ.g:370:3: ( rule__PolyShape__Group_4_1__0 )
                    // InternalOBJ.g:370:4: rule__PolyShape__Group_4_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PolyShape__Group_4_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPolyShapeAccess().getGroup_4_1()); 

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
    // $ANTLR end "rule__PolyShape__Alternatives_4"


    // $ANTLR start "rule__PolyShape__Alternatives_4_1_1"
    // InternalOBJ.g:378:1: rule__PolyShape__Alternatives_4_1_1 : ( ( ruleEInt ) | ( 'off' ) );
    public final void rule__PolyShape__Alternatives_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:382:1: ( ( ruleEInt ) | ( 'off' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_INT||LA6_0==18) ) {
                alt6=1;
            }
            else if ( (LA6_0==12) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalOBJ.g:383:2: ( ruleEInt )
                    {
                    // InternalOBJ.g:383:2: ( ruleEInt )
                    // InternalOBJ.g:384:3: ruleEInt
                    {
                     before(grammarAccess.getPolyShapeAccess().getEIntParserRuleCall_4_1_1_0()); 
                    pushFollow(FOLLOW_2);
                    ruleEInt();

                    state._fsp--;

                     after(grammarAccess.getPolyShapeAccess().getEIntParserRuleCall_4_1_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOBJ.g:389:2: ( 'off' )
                    {
                    // InternalOBJ.g:389:2: ( 'off' )
                    // InternalOBJ.g:390:3: 'off'
                    {
                     before(grammarAccess.getPolyShapeAccess().getOffKeyword_4_1_1_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getPolyShapeAccess().getOffKeyword_4_1_1_1()); 

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
    // $ANTLR end "rule__PolyShape__Alternatives_4_1_1"


    // $ANTLR start "rule__Face__Alternatives_1_1_1"
    // InternalOBJ.g:399:1: rule__Face__Alternatives_1_1_1 : ( ( ( rule__Face__TextureIndicesAssignment_1_1_1_0 ) ) | ( ( rule__Face__Group_1_1_1_1__0 ) ) | ( ( rule__Face__Group_1_1_1_2__0 ) ) );
    public final void rule__Face__Alternatives_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:403:1: ( ( ( rule__Face__TextureIndicesAssignment_1_1_1_0 ) ) | ( ( rule__Face__Group_1_1_1_1__0 ) ) | ( ( rule__Face__Group_1_1_1_2__0 ) ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 18:
                {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_INT) ) {
                    int LA7_2 = input.LA(3);

                    if ( (LA7_2==EOF||LA7_2==RULE_INT||(LA7_2>=18 && LA7_2<=26)) ) {
                        alt7=1;
                    }
                    else if ( (LA7_2==14) ) {
                        alt7=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA7_2 = input.LA(2);

                if ( (LA7_2==EOF||LA7_2==RULE_INT||(LA7_2>=18 && LA7_2<=26)) ) {
                    alt7=1;
                }
                else if ( (LA7_2==14) ) {
                    alt7=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 2, input);

                    throw nvae;
                }
                }
                break;
            case 14:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalOBJ.g:404:2: ( ( rule__Face__TextureIndicesAssignment_1_1_1_0 ) )
                    {
                    // InternalOBJ.g:404:2: ( ( rule__Face__TextureIndicesAssignment_1_1_1_0 ) )
                    // InternalOBJ.g:405:3: ( rule__Face__TextureIndicesAssignment_1_1_1_0 )
                    {
                     before(grammarAccess.getFaceAccess().getTextureIndicesAssignment_1_1_1_0()); 
                    // InternalOBJ.g:406:3: ( rule__Face__TextureIndicesAssignment_1_1_1_0 )
                    // InternalOBJ.g:406:4: rule__Face__TextureIndicesAssignment_1_1_1_0
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
                    // InternalOBJ.g:410:2: ( ( rule__Face__Group_1_1_1_1__0 ) )
                    {
                    // InternalOBJ.g:410:2: ( ( rule__Face__Group_1_1_1_1__0 ) )
                    // InternalOBJ.g:411:3: ( rule__Face__Group_1_1_1_1__0 )
                    {
                     before(grammarAccess.getFaceAccess().getGroup_1_1_1_1()); 
                    // InternalOBJ.g:412:3: ( rule__Face__Group_1_1_1_1__0 )
                    // InternalOBJ.g:412:4: rule__Face__Group_1_1_1_1__0
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
                    // InternalOBJ.g:416:2: ( ( rule__Face__Group_1_1_1_2__0 ) )
                    {
                    // InternalOBJ.g:416:2: ( ( rule__Face__Group_1_1_1_2__0 ) )
                    // InternalOBJ.g:417:3: ( rule__Face__Group_1_1_1_2__0 )
                    {
                     before(grammarAccess.getFaceAccess().getGroup_1_1_1_2()); 
                    // InternalOBJ.g:418:3: ( rule__Face__Group_1_1_1_2__0 )
                    // InternalOBJ.g:418:4: rule__Face__Group_1_1_1_2__0
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
    // InternalOBJ.g:426:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) | ( RULE_INT ) | ( '.' ) | ( '/' ) | ( '\\\\' ) | ( ':' ) | ( '_' ) | ( '-' ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:430:1: ( ( RULE_STRING ) | ( RULE_ID ) | ( RULE_INT ) | ( '.' ) | ( '/' ) | ( '\\\\' ) | ( ':' ) | ( '_' ) | ( '-' ) )
            int alt8=9;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt8=1;
                }
                break;
            case RULE_ID:
                {
                alt8=2;
                }
                break;
            case RULE_INT:
                {
                alt8=3;
                }
                break;
            case 13:
                {
                alt8=4;
                }
                break;
            case 14:
                {
                alt8=5;
                }
                break;
            case 15:
                {
                alt8=6;
                }
                break;
            case 16:
                {
                alt8=7;
                }
                break;
            case 17:
                {
                alt8=8;
                }
                break;
            case 18:
                {
                alt8=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalOBJ.g:431:2: ( RULE_STRING )
                    {
                    // InternalOBJ.g:431:2: ( RULE_STRING )
                    // InternalOBJ.g:432:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOBJ.g:437:2: ( RULE_ID )
                    {
                    // InternalOBJ.g:437:2: ( RULE_ID )
                    // InternalOBJ.g:438:3: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOBJ.g:443:2: ( RULE_INT )
                    {
                    // InternalOBJ.g:443:2: ( RULE_INT )
                    // InternalOBJ.g:444:3: RULE_INT
                    {
                     before(grammarAccess.getEStringAccess().getINTTerminalRuleCall_2()); 
                    match(input,RULE_INT,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getINTTerminalRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOBJ.g:449:2: ( '.' )
                    {
                    // InternalOBJ.g:449:2: ( '.' )
                    // InternalOBJ.g:450:3: '.'
                    {
                     before(grammarAccess.getEStringAccess().getFullStopKeyword_3()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getFullStopKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalOBJ.g:455:2: ( '/' )
                    {
                    // InternalOBJ.g:455:2: ( '/' )
                    // InternalOBJ.g:456:3: '/'
                    {
                     before(grammarAccess.getEStringAccess().getSolidusKeyword_4()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSolidusKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalOBJ.g:461:2: ( '\\\\' )
                    {
                    // InternalOBJ.g:461:2: ( '\\\\' )
                    // InternalOBJ.g:462:3: '\\\\'
                    {
                     before(grammarAccess.getEStringAccess().getReverseSolidusKeyword_5()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getReverseSolidusKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalOBJ.g:467:2: ( ':' )
                    {
                    // InternalOBJ.g:467:2: ( ':' )
                    // InternalOBJ.g:468:3: ':'
                    {
                     before(grammarAccess.getEStringAccess().getColonKeyword_6()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getColonKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalOBJ.g:473:2: ( '_' )
                    {
                    // InternalOBJ.g:473:2: ( '_' )
                    // InternalOBJ.g:474:3: '_'
                    {
                     before(grammarAccess.getEStringAccess().get_Keyword_7()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().get_Keyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalOBJ.g:479:2: ( '-' )
                    {
                    // InternalOBJ.g:479:2: ( '-' )
                    // InternalOBJ.g:480:3: '-'
                    {
                     before(grammarAccess.getEStringAccess().getHyphenMinusKeyword_8()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getHyphenMinusKeyword_8()); 

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
    // InternalOBJ.g:489:1: rule__EDouble__Alternatives : ( ( RULE_DOUBLE ) | ( ruleEInt ) );
    public final void rule__EDouble__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:493:1: ( ( RULE_DOUBLE ) | ( ruleEInt ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_DOUBLE) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_INT||LA9_0==18) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalOBJ.g:494:2: ( RULE_DOUBLE )
                    {
                    // InternalOBJ.g:494:2: ( RULE_DOUBLE )
                    // InternalOBJ.g:495:3: RULE_DOUBLE
                    {
                     before(grammarAccess.getEDoubleAccess().getDOUBLETerminalRuleCall_0()); 
                    match(input,RULE_DOUBLE,FOLLOW_2); 
                     after(grammarAccess.getEDoubleAccess().getDOUBLETerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOBJ.g:500:2: ( ruleEInt )
                    {
                    // InternalOBJ.g:500:2: ( ruleEInt )
                    // InternalOBJ.g:501:3: ruleEInt
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


    // $ANTLR start "rule__VertexSource__Group__0"
    // InternalOBJ.g:510:1: rule__VertexSource__Group__0 : rule__VertexSource__Group__0__Impl rule__VertexSource__Group__1 ;
    public final void rule__VertexSource__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:514:1: ( rule__VertexSource__Group__0__Impl rule__VertexSource__Group__1 )
            // InternalOBJ.g:515:2: rule__VertexSource__Group__0__Impl rule__VertexSource__Group__1
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
    // InternalOBJ.g:522:1: rule__VertexSource__Group__0__Impl : ( () ) ;
    public final void rule__VertexSource__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:526:1: ( ( () ) )
            // InternalOBJ.g:527:1: ( () )
            {
            // InternalOBJ.g:527:1: ( () )
            // InternalOBJ.g:528:2: ()
            {
             before(grammarAccess.getVertexSourceAccess().getVertexSourceAction_0()); 
            // InternalOBJ.g:529:2: ()
            // InternalOBJ.g:529:3: 
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
    // InternalOBJ.g:537:1: rule__VertexSource__Group__1 : rule__VertexSource__Group__1__Impl rule__VertexSource__Group__2 ;
    public final void rule__VertexSource__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:541:1: ( rule__VertexSource__Group__1__Impl rule__VertexSource__Group__2 )
            // InternalOBJ.g:542:2: rule__VertexSource__Group__1__Impl rule__VertexSource__Group__2
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
    // InternalOBJ.g:549:1: rule__VertexSource__Group__1__Impl : ( ( rule__VertexSource__Group_1__0 )* ) ;
    public final void rule__VertexSource__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:553:1: ( ( ( rule__VertexSource__Group_1__0 )* ) )
            // InternalOBJ.g:554:1: ( ( rule__VertexSource__Group_1__0 )* )
            {
            // InternalOBJ.g:554:1: ( ( rule__VertexSource__Group_1__0 )* )
            // InternalOBJ.g:555:2: ( rule__VertexSource__Group_1__0 )*
            {
             before(grammarAccess.getVertexSourceAccess().getGroup_1()); 
            // InternalOBJ.g:556:2: ( rule__VertexSource__Group_1__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==19) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalOBJ.g:556:3: rule__VertexSource__Group_1__0
            	    {
            	    pushFollow(FOLLOW_6);
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
    // InternalOBJ.g:564:1: rule__VertexSource__Group__2 : rule__VertexSource__Group__2__Impl rule__VertexSource__Group__3 ;
    public final void rule__VertexSource__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:568:1: ( rule__VertexSource__Group__2__Impl rule__VertexSource__Group__3 )
            // InternalOBJ.g:569:2: rule__VertexSource__Group__2__Impl rule__VertexSource__Group__3
            {
            pushFollow(FOLLOW_5);
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
    // InternalOBJ.g:576:1: rule__VertexSource__Group__2__Impl : ( ( rule__VertexSource__Group_2__0 )? ) ;
    public final void rule__VertexSource__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:580:1: ( ( ( rule__VertexSource__Group_2__0 )? ) )
            // InternalOBJ.g:581:1: ( ( rule__VertexSource__Group_2__0 )? )
            {
            // InternalOBJ.g:581:1: ( ( rule__VertexSource__Group_2__0 )? )
            // InternalOBJ.g:582:2: ( rule__VertexSource__Group_2__0 )?
            {
             before(grammarAccess.getVertexSourceAccess().getGroup_2()); 
            // InternalOBJ.g:583:2: ( rule__VertexSource__Group_2__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==20) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalOBJ.g:583:3: rule__VertexSource__Group_2__0
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
    // InternalOBJ.g:591:1: rule__VertexSource__Group__3 : rule__VertexSource__Group__3__Impl ;
    public final void rule__VertexSource__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:595:1: ( rule__VertexSource__Group__3__Impl )
            // InternalOBJ.g:596:2: rule__VertexSource__Group__3__Impl
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
    // InternalOBJ.g:602:1: rule__VertexSource__Group__3__Impl : ( ( ( rule__VertexSource__Alternatives_3 ) ) ( ( rule__VertexSource__Alternatives_3 )* ) ) ;
    public final void rule__VertexSource__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:606:1: ( ( ( ( rule__VertexSource__Alternatives_3 ) ) ( ( rule__VertexSource__Alternatives_3 )* ) ) )
            // InternalOBJ.g:607:1: ( ( ( rule__VertexSource__Alternatives_3 ) ) ( ( rule__VertexSource__Alternatives_3 )* ) )
            {
            // InternalOBJ.g:607:1: ( ( ( rule__VertexSource__Alternatives_3 ) ) ( ( rule__VertexSource__Alternatives_3 )* ) )
            // InternalOBJ.g:608:2: ( ( rule__VertexSource__Alternatives_3 ) ) ( ( rule__VertexSource__Alternatives_3 )* )
            {
            // InternalOBJ.g:608:2: ( ( rule__VertexSource__Alternatives_3 ) )
            // InternalOBJ.g:609:3: ( rule__VertexSource__Alternatives_3 )
            {
             before(grammarAccess.getVertexSourceAccess().getAlternatives_3()); 
            // InternalOBJ.g:610:3: ( rule__VertexSource__Alternatives_3 )
            // InternalOBJ.g:610:4: rule__VertexSource__Alternatives_3
            {
            pushFollow(FOLLOW_7);
            rule__VertexSource__Alternatives_3();

            state._fsp--;


            }

             after(grammarAccess.getVertexSourceAccess().getAlternatives_3()); 

            }

            // InternalOBJ.g:613:2: ( ( rule__VertexSource__Alternatives_3 )* )
            // InternalOBJ.g:614:3: ( rule__VertexSource__Alternatives_3 )*
            {
             before(grammarAccess.getVertexSourceAccess().getAlternatives_3()); 
            // InternalOBJ.g:615:3: ( rule__VertexSource__Alternatives_3 )*
            loop12:
            do {
                int alt12=2;
                alt12 = dfa12.predict(input);
                switch (alt12) {
            	case 1 :
            	    // InternalOBJ.g:615:4: rule__VertexSource__Alternatives_3
            	    {
            	    pushFollow(FOLLOW_7);
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
    // InternalOBJ.g:625:1: rule__VertexSource__Group_1__0 : rule__VertexSource__Group_1__0__Impl rule__VertexSource__Group_1__1 ;
    public final void rule__VertexSource__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:629:1: ( rule__VertexSource__Group_1__0__Impl rule__VertexSource__Group_1__1 )
            // InternalOBJ.g:630:2: rule__VertexSource__Group_1__0__Impl rule__VertexSource__Group_1__1
            {
            pushFollow(FOLLOW_8);
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
    // InternalOBJ.g:637:1: rule__VertexSource__Group_1__0__Impl : ( 'mtllib' ) ;
    public final void rule__VertexSource__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:641:1: ( ( 'mtllib' ) )
            // InternalOBJ.g:642:1: ( 'mtllib' )
            {
            // InternalOBJ.g:642:1: ( 'mtllib' )
            // InternalOBJ.g:643:2: 'mtllib'
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
    // InternalOBJ.g:652:1: rule__VertexSource__Group_1__1 : rule__VertexSource__Group_1__1__Impl ;
    public final void rule__VertexSource__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:656:1: ( rule__VertexSource__Group_1__1__Impl )
            // InternalOBJ.g:657:2: rule__VertexSource__Group_1__1__Impl
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
    // InternalOBJ.g:663:1: rule__VertexSource__Group_1__1__Impl : ( ( rule__VertexSource__MaterialFilesAssignment_1_1 ) ) ;
    public final void rule__VertexSource__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:667:1: ( ( ( rule__VertexSource__MaterialFilesAssignment_1_1 ) ) )
            // InternalOBJ.g:668:1: ( ( rule__VertexSource__MaterialFilesAssignment_1_1 ) )
            {
            // InternalOBJ.g:668:1: ( ( rule__VertexSource__MaterialFilesAssignment_1_1 ) )
            // InternalOBJ.g:669:2: ( rule__VertexSource__MaterialFilesAssignment_1_1 )
            {
             before(grammarAccess.getVertexSourceAccess().getMaterialFilesAssignment_1_1()); 
            // InternalOBJ.g:670:2: ( rule__VertexSource__MaterialFilesAssignment_1_1 )
            // InternalOBJ.g:670:3: rule__VertexSource__MaterialFilesAssignment_1_1
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
    // InternalOBJ.g:679:1: rule__VertexSource__Group_2__0 : rule__VertexSource__Group_2__0__Impl rule__VertexSource__Group_2__1 ;
    public final void rule__VertexSource__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:683:1: ( rule__VertexSource__Group_2__0__Impl rule__VertexSource__Group_2__1 )
            // InternalOBJ.g:684:2: rule__VertexSource__Group_2__0__Impl rule__VertexSource__Group_2__1
            {
            pushFollow(FOLLOW_8);
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
    // InternalOBJ.g:691:1: rule__VertexSource__Group_2__0__Impl : ( 'g' ) ;
    public final void rule__VertexSource__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:695:1: ( ( 'g' ) )
            // InternalOBJ.g:696:1: ( 'g' )
            {
            // InternalOBJ.g:696:1: ( 'g' )
            // InternalOBJ.g:697:2: 'g'
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
    // InternalOBJ.g:706:1: rule__VertexSource__Group_2__1 : rule__VertexSource__Group_2__1__Impl ;
    public final void rule__VertexSource__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:710:1: ( rule__VertexSource__Group_2__1__Impl )
            // InternalOBJ.g:711:2: rule__VertexSource__Group_2__1__Impl
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
    // InternalOBJ.g:717:1: rule__VertexSource__Group_2__1__Impl : ( ( ruleEString )? ) ;
    public final void rule__VertexSource__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:721:1: ( ( ( ruleEString )? ) )
            // InternalOBJ.g:722:1: ( ( ruleEString )? )
            {
            // InternalOBJ.g:722:1: ( ( ruleEString )? )
            // InternalOBJ.g:723:2: ( ruleEString )?
            {
             before(grammarAccess.getVertexSourceAccess().getEStringParserRuleCall_2_1()); 
            // InternalOBJ.g:724:2: ( ruleEString )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=RULE_STRING && LA13_0<=RULE_INT)||(LA13_0>=13 && LA13_0<=18)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalOBJ.g:724:3: ruleEString
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
    // InternalOBJ.g:733:1: rule__VertexSource__Group_3_0__0 : rule__VertexSource__Group_3_0__0__Impl rule__VertexSource__Group_3_0__1 ;
    public final void rule__VertexSource__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:737:1: ( rule__VertexSource__Group_3_0__0__Impl rule__VertexSource__Group_3_0__1 )
            // InternalOBJ.g:738:2: rule__VertexSource__Group_3_0__0__Impl rule__VertexSource__Group_3_0__1
            {
            pushFollow(FOLLOW_9);
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
    // InternalOBJ.g:745:1: rule__VertexSource__Group_3_0__0__Impl : ( 'v' ) ;
    public final void rule__VertexSource__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:749:1: ( ( 'v' ) )
            // InternalOBJ.g:750:1: ( 'v' )
            {
            // InternalOBJ.g:750:1: ( 'v' )
            // InternalOBJ.g:751:2: 'v'
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
    // InternalOBJ.g:760:1: rule__VertexSource__Group_3_0__1 : rule__VertexSource__Group_3_0__1__Impl ;
    public final void rule__VertexSource__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:764:1: ( rule__VertexSource__Group_3_0__1__Impl )
            // InternalOBJ.g:765:2: rule__VertexSource__Group_3_0__1__Impl
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
    // InternalOBJ.g:771:1: rule__VertexSource__Group_3_0__1__Impl : ( ( rule__VertexSource__VerticesAssignment_3_0_1 ) ) ;
    public final void rule__VertexSource__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:775:1: ( ( ( rule__VertexSource__VerticesAssignment_3_0_1 ) ) )
            // InternalOBJ.g:776:1: ( ( rule__VertexSource__VerticesAssignment_3_0_1 ) )
            {
            // InternalOBJ.g:776:1: ( ( rule__VertexSource__VerticesAssignment_3_0_1 ) )
            // InternalOBJ.g:777:2: ( rule__VertexSource__VerticesAssignment_3_0_1 )
            {
             before(grammarAccess.getVertexSourceAccess().getVerticesAssignment_3_0_1()); 
            // InternalOBJ.g:778:2: ( rule__VertexSource__VerticesAssignment_3_0_1 )
            // InternalOBJ.g:778:3: rule__VertexSource__VerticesAssignment_3_0_1
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
    // InternalOBJ.g:787:1: rule__VertexSource__Group_3_1__0 : rule__VertexSource__Group_3_1__0__Impl rule__VertexSource__Group_3_1__1 ;
    public final void rule__VertexSource__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:791:1: ( rule__VertexSource__Group_3_1__0__Impl rule__VertexSource__Group_3_1__1 )
            // InternalOBJ.g:792:2: rule__VertexSource__Group_3_1__0__Impl rule__VertexSource__Group_3_1__1
            {
            pushFollow(FOLLOW_9);
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
    // InternalOBJ.g:799:1: rule__VertexSource__Group_3_1__0__Impl : ( 'vt' ) ;
    public final void rule__VertexSource__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:803:1: ( ( 'vt' ) )
            // InternalOBJ.g:804:1: ( 'vt' )
            {
            // InternalOBJ.g:804:1: ( 'vt' )
            // InternalOBJ.g:805:2: 'vt'
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
    // InternalOBJ.g:814:1: rule__VertexSource__Group_3_1__1 : rule__VertexSource__Group_3_1__1__Impl ;
    public final void rule__VertexSource__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:818:1: ( rule__VertexSource__Group_3_1__1__Impl )
            // InternalOBJ.g:819:2: rule__VertexSource__Group_3_1__1__Impl
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
    // InternalOBJ.g:825:1: rule__VertexSource__Group_3_1__1__Impl : ( ( rule__VertexSource__TextureCoordinatesAssignment_3_1_1 ) ) ;
    public final void rule__VertexSource__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:829:1: ( ( ( rule__VertexSource__TextureCoordinatesAssignment_3_1_1 ) ) )
            // InternalOBJ.g:830:1: ( ( rule__VertexSource__TextureCoordinatesAssignment_3_1_1 ) )
            {
            // InternalOBJ.g:830:1: ( ( rule__VertexSource__TextureCoordinatesAssignment_3_1_1 ) )
            // InternalOBJ.g:831:2: ( rule__VertexSource__TextureCoordinatesAssignment_3_1_1 )
            {
             before(grammarAccess.getVertexSourceAccess().getTextureCoordinatesAssignment_3_1_1()); 
            // InternalOBJ.g:832:2: ( rule__VertexSource__TextureCoordinatesAssignment_3_1_1 )
            // InternalOBJ.g:832:3: rule__VertexSource__TextureCoordinatesAssignment_3_1_1
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


    // $ANTLR start "rule__VertexSource__Group_3_2__0"
    // InternalOBJ.g:841:1: rule__VertexSource__Group_3_2__0 : rule__VertexSource__Group_3_2__0__Impl rule__VertexSource__Group_3_2__1 ;
    public final void rule__VertexSource__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:845:1: ( rule__VertexSource__Group_3_2__0__Impl rule__VertexSource__Group_3_2__1 )
            // InternalOBJ.g:846:2: rule__VertexSource__Group_3_2__0__Impl rule__VertexSource__Group_3_2__1
            {
            pushFollow(FOLLOW_9);
            rule__VertexSource__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VertexSource__Group_3_2__1();

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
    // $ANTLR end "rule__VertexSource__Group_3_2__0"


    // $ANTLR start "rule__VertexSource__Group_3_2__0__Impl"
    // InternalOBJ.g:853:1: rule__VertexSource__Group_3_2__0__Impl : ( 'vn' ) ;
    public final void rule__VertexSource__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:857:1: ( ( 'vn' ) )
            // InternalOBJ.g:858:1: ( 'vn' )
            {
            // InternalOBJ.g:858:1: ( 'vn' )
            // InternalOBJ.g:859:2: 'vn'
            {
             before(grammarAccess.getVertexSourceAccess().getVnKeyword_3_2_0()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getVertexSourceAccess().getVnKeyword_3_2_0()); 

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
    // $ANTLR end "rule__VertexSource__Group_3_2__0__Impl"


    // $ANTLR start "rule__VertexSource__Group_3_2__1"
    // InternalOBJ.g:868:1: rule__VertexSource__Group_3_2__1 : rule__VertexSource__Group_3_2__1__Impl rule__VertexSource__Group_3_2__2 ;
    public final void rule__VertexSource__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:872:1: ( rule__VertexSource__Group_3_2__1__Impl rule__VertexSource__Group_3_2__2 )
            // InternalOBJ.g:873:2: rule__VertexSource__Group_3_2__1__Impl rule__VertexSource__Group_3_2__2
            {
            pushFollow(FOLLOW_9);
            rule__VertexSource__Group_3_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VertexSource__Group_3_2__2();

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
    // $ANTLR end "rule__VertexSource__Group_3_2__1"


    // $ANTLR start "rule__VertexSource__Group_3_2__1__Impl"
    // InternalOBJ.g:880:1: rule__VertexSource__Group_3_2__1__Impl : ( ruleEDouble ) ;
    public final void rule__VertexSource__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:884:1: ( ( ruleEDouble ) )
            // InternalOBJ.g:885:1: ( ruleEDouble )
            {
            // InternalOBJ.g:885:1: ( ruleEDouble )
            // InternalOBJ.g:886:2: ruleEDouble
            {
             before(grammarAccess.getVertexSourceAccess().getEDoubleParserRuleCall_3_2_1()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getVertexSourceAccess().getEDoubleParserRuleCall_3_2_1()); 

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
    // $ANTLR end "rule__VertexSource__Group_3_2__1__Impl"


    // $ANTLR start "rule__VertexSource__Group_3_2__2"
    // InternalOBJ.g:895:1: rule__VertexSource__Group_3_2__2 : rule__VertexSource__Group_3_2__2__Impl rule__VertexSource__Group_3_2__3 ;
    public final void rule__VertexSource__Group_3_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:899:1: ( rule__VertexSource__Group_3_2__2__Impl rule__VertexSource__Group_3_2__3 )
            // InternalOBJ.g:900:2: rule__VertexSource__Group_3_2__2__Impl rule__VertexSource__Group_3_2__3
            {
            pushFollow(FOLLOW_9);
            rule__VertexSource__Group_3_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VertexSource__Group_3_2__3();

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
    // $ANTLR end "rule__VertexSource__Group_3_2__2"


    // $ANTLR start "rule__VertexSource__Group_3_2__2__Impl"
    // InternalOBJ.g:907:1: rule__VertexSource__Group_3_2__2__Impl : ( ruleEDouble ) ;
    public final void rule__VertexSource__Group_3_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:911:1: ( ( ruleEDouble ) )
            // InternalOBJ.g:912:1: ( ruleEDouble )
            {
            // InternalOBJ.g:912:1: ( ruleEDouble )
            // InternalOBJ.g:913:2: ruleEDouble
            {
             before(grammarAccess.getVertexSourceAccess().getEDoubleParserRuleCall_3_2_2()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getVertexSourceAccess().getEDoubleParserRuleCall_3_2_2()); 

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
    // $ANTLR end "rule__VertexSource__Group_3_2__2__Impl"


    // $ANTLR start "rule__VertexSource__Group_3_2__3"
    // InternalOBJ.g:922:1: rule__VertexSource__Group_3_2__3 : rule__VertexSource__Group_3_2__3__Impl ;
    public final void rule__VertexSource__Group_3_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:926:1: ( rule__VertexSource__Group_3_2__3__Impl )
            // InternalOBJ.g:927:2: rule__VertexSource__Group_3_2__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VertexSource__Group_3_2__3__Impl();

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
    // $ANTLR end "rule__VertexSource__Group_3_2__3"


    // $ANTLR start "rule__VertexSource__Group_3_2__3__Impl"
    // InternalOBJ.g:933:1: rule__VertexSource__Group_3_2__3__Impl : ( ruleEDouble ) ;
    public final void rule__VertexSource__Group_3_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:937:1: ( ( ruleEDouble ) )
            // InternalOBJ.g:938:1: ( ruleEDouble )
            {
            // InternalOBJ.g:938:1: ( ruleEDouble )
            // InternalOBJ.g:939:2: ruleEDouble
            {
             before(grammarAccess.getVertexSourceAccess().getEDoubleParserRuleCall_3_2_3()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getVertexSourceAccess().getEDoubleParserRuleCall_3_2_3()); 

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
    // $ANTLR end "rule__VertexSource__Group_3_2__3__Impl"


    // $ANTLR start "rule__PolyShape__Group__0"
    // InternalOBJ.g:949:1: rule__PolyShape__Group__0 : rule__PolyShape__Group__0__Impl rule__PolyShape__Group__1 ;
    public final void rule__PolyShape__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:953:1: ( rule__PolyShape__Group__0__Impl rule__PolyShape__Group__1 )
            // InternalOBJ.g:954:2: rule__PolyShape__Group__0__Impl rule__PolyShape__Group__1
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
    // InternalOBJ.g:961:1: rule__PolyShape__Group__0__Impl : ( () ) ;
    public final void rule__PolyShape__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:965:1: ( ( () ) )
            // InternalOBJ.g:966:1: ( () )
            {
            // InternalOBJ.g:966:1: ( () )
            // InternalOBJ.g:967:2: ()
            {
             before(grammarAccess.getPolyShapeAccess().getPolyShapeAction_0()); 
            // InternalOBJ.g:968:2: ()
            // InternalOBJ.g:968:3: 
            {
            }

             after(grammarAccess.getPolyShapeAccess().getPolyShapeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PolyShape__Group__0__Impl"


    // $ANTLR start "rule__PolyShape__Group__1"
    // InternalOBJ.g:976:1: rule__PolyShape__Group__1 : rule__PolyShape__Group__1__Impl rule__PolyShape__Group__2 ;
    public final void rule__PolyShape__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:980:1: ( rule__PolyShape__Group__1__Impl rule__PolyShape__Group__2 )
            // InternalOBJ.g:981:2: rule__PolyShape__Group__1__Impl rule__PolyShape__Group__2
            {
            pushFollow(FOLLOW_10);
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
    // InternalOBJ.g:988:1: rule__PolyShape__Group__1__Impl : ( ( rule__PolyShape__Group_1__0 )* ) ;
    public final void rule__PolyShape__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:992:1: ( ( ( rule__PolyShape__Group_1__0 )* ) )
            // InternalOBJ.g:993:1: ( ( rule__PolyShape__Group_1__0 )* )
            {
            // InternalOBJ.g:993:1: ( ( rule__PolyShape__Group_1__0 )* )
            // InternalOBJ.g:994:2: ( rule__PolyShape__Group_1__0 )*
            {
             before(grammarAccess.getPolyShapeAccess().getGroup_1()); 
            // InternalOBJ.g:995:2: ( rule__PolyShape__Group_1__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==19) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalOBJ.g:995:3: rule__PolyShape__Group_1__0
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__PolyShape__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

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
    // InternalOBJ.g:1003:1: rule__PolyShape__Group__2 : rule__PolyShape__Group__2__Impl rule__PolyShape__Group__3 ;
    public final void rule__PolyShape__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1007:1: ( rule__PolyShape__Group__2__Impl rule__PolyShape__Group__3 )
            // InternalOBJ.g:1008:2: rule__PolyShape__Group__2__Impl rule__PolyShape__Group__3
            {
            pushFollow(FOLLOW_10);
            rule__PolyShape__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PolyShape__Group__3();

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
    // InternalOBJ.g:1015:1: rule__PolyShape__Group__2__Impl : ( ( rule__PolyShape__Group_2__0 )? ) ;
    public final void rule__PolyShape__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1019:1: ( ( ( rule__PolyShape__Group_2__0 )? ) )
            // InternalOBJ.g:1020:1: ( ( rule__PolyShape__Group_2__0 )? )
            {
            // InternalOBJ.g:1020:1: ( ( rule__PolyShape__Group_2__0 )? )
            // InternalOBJ.g:1021:2: ( rule__PolyShape__Group_2__0 )?
            {
             before(grammarAccess.getPolyShapeAccess().getGroup_2()); 
            // InternalOBJ.g:1022:2: ( rule__PolyShape__Group_2__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==20) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalOBJ.g:1022:3: rule__PolyShape__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PolyShape__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

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


    // $ANTLR start "rule__PolyShape__Group__3"
    // InternalOBJ.g:1030:1: rule__PolyShape__Group__3 : rule__PolyShape__Group__3__Impl rule__PolyShape__Group__4 ;
    public final void rule__PolyShape__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1034:1: ( rule__PolyShape__Group__3__Impl rule__PolyShape__Group__4 )
            // InternalOBJ.g:1035:2: rule__PolyShape__Group__3__Impl rule__PolyShape__Group__4
            {
            pushFollow(FOLLOW_10);
            rule__PolyShape__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PolyShape__Group__4();

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
    // $ANTLR end "rule__PolyShape__Group__3"


    // $ANTLR start "rule__PolyShape__Group__3__Impl"
    // InternalOBJ.g:1042:1: rule__PolyShape__Group__3__Impl : ( ( rule__PolyShape__Group_3__0 )? ) ;
    public final void rule__PolyShape__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1046:1: ( ( ( rule__PolyShape__Group_3__0 )? ) )
            // InternalOBJ.g:1047:1: ( ( rule__PolyShape__Group_3__0 )? )
            {
            // InternalOBJ.g:1047:1: ( ( rule__PolyShape__Group_3__0 )? )
            // InternalOBJ.g:1048:2: ( rule__PolyShape__Group_3__0 )?
            {
             before(grammarAccess.getPolyShapeAccess().getGroup_3()); 
            // InternalOBJ.g:1049:2: ( rule__PolyShape__Group_3__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==24) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalOBJ.g:1049:3: rule__PolyShape__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PolyShape__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPolyShapeAccess().getGroup_3()); 

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
    // $ANTLR end "rule__PolyShape__Group__3__Impl"


    // $ANTLR start "rule__PolyShape__Group__4"
    // InternalOBJ.g:1057:1: rule__PolyShape__Group__4 : rule__PolyShape__Group__4__Impl ;
    public final void rule__PolyShape__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1061:1: ( rule__PolyShape__Group__4__Impl )
            // InternalOBJ.g:1062:2: rule__PolyShape__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PolyShape__Group__4__Impl();

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
    // $ANTLR end "rule__PolyShape__Group__4"


    // $ANTLR start "rule__PolyShape__Group__4__Impl"
    // InternalOBJ.g:1068:1: rule__PolyShape__Group__4__Impl : ( ( ( rule__PolyShape__Alternatives_4 ) ) ( ( rule__PolyShape__Alternatives_4 )* ) ) ;
    public final void rule__PolyShape__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1072:1: ( ( ( ( rule__PolyShape__Alternatives_4 ) ) ( ( rule__PolyShape__Alternatives_4 )* ) ) )
            // InternalOBJ.g:1073:1: ( ( ( rule__PolyShape__Alternatives_4 ) ) ( ( rule__PolyShape__Alternatives_4 )* ) )
            {
            // InternalOBJ.g:1073:1: ( ( ( rule__PolyShape__Alternatives_4 ) ) ( ( rule__PolyShape__Alternatives_4 )* ) )
            // InternalOBJ.g:1074:2: ( ( rule__PolyShape__Alternatives_4 ) ) ( ( rule__PolyShape__Alternatives_4 )* )
            {
            // InternalOBJ.g:1074:2: ( ( rule__PolyShape__Alternatives_4 ) )
            // InternalOBJ.g:1075:3: ( rule__PolyShape__Alternatives_4 )
            {
             before(grammarAccess.getPolyShapeAccess().getAlternatives_4()); 
            // InternalOBJ.g:1076:3: ( rule__PolyShape__Alternatives_4 )
            // InternalOBJ.g:1076:4: rule__PolyShape__Alternatives_4
            {
            pushFollow(FOLLOW_10);
            rule__PolyShape__Alternatives_4();

            state._fsp--;


            }

             after(grammarAccess.getPolyShapeAccess().getAlternatives_4()); 

            }

            // InternalOBJ.g:1079:2: ( ( rule__PolyShape__Alternatives_4 )* )
            // InternalOBJ.g:1080:3: ( rule__PolyShape__Alternatives_4 )*
            {
             before(grammarAccess.getPolyShapeAccess().getAlternatives_4()); 
            // InternalOBJ.g:1081:3: ( rule__PolyShape__Alternatives_4 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==25) ) {
                    alt17=1;
                }
                else if ( (LA17_0==26) ) {
                    switch ( input.LA(2) ) {
                    case 18:
                        {
                        int LA17_4 = input.LA(3);

                        if ( (LA17_4==RULE_INT) ) {
                            alt17=1;
                        }


                        }
                        break;
                    case RULE_INT:
                        {
                        alt17=1;
                        }
                        break;
                    case 12:
                        {
                        alt17=1;
                        }
                        break;

                    }

                }


                switch (alt17) {
            	case 1 :
            	    // InternalOBJ.g:1081:4: rule__PolyShape__Alternatives_4
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__PolyShape__Alternatives_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getPolyShapeAccess().getAlternatives_4()); 

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
    // $ANTLR end "rule__PolyShape__Group__4__Impl"


    // $ANTLR start "rule__PolyShape__Group_1__0"
    // InternalOBJ.g:1091:1: rule__PolyShape__Group_1__0 : rule__PolyShape__Group_1__0__Impl rule__PolyShape__Group_1__1 ;
    public final void rule__PolyShape__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1095:1: ( rule__PolyShape__Group_1__0__Impl rule__PolyShape__Group_1__1 )
            // InternalOBJ.g:1096:2: rule__PolyShape__Group_1__0__Impl rule__PolyShape__Group_1__1
            {
            pushFollow(FOLLOW_8);
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
    // InternalOBJ.g:1103:1: rule__PolyShape__Group_1__0__Impl : ( 'mtllib' ) ;
    public final void rule__PolyShape__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1107:1: ( ( 'mtllib' ) )
            // InternalOBJ.g:1108:1: ( 'mtllib' )
            {
            // InternalOBJ.g:1108:1: ( 'mtllib' )
            // InternalOBJ.g:1109:2: 'mtllib'
            {
             before(grammarAccess.getPolyShapeAccess().getMtllibKeyword_1_0()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getPolyShapeAccess().getMtllibKeyword_1_0()); 

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
    // InternalOBJ.g:1118:1: rule__PolyShape__Group_1__1 : rule__PolyShape__Group_1__1__Impl ;
    public final void rule__PolyShape__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1122:1: ( rule__PolyShape__Group_1__1__Impl )
            // InternalOBJ.g:1123:2: rule__PolyShape__Group_1__1__Impl
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
    // InternalOBJ.g:1129:1: rule__PolyShape__Group_1__1__Impl : ( ( rule__PolyShape__MaterialFilesAssignment_1_1 ) ) ;
    public final void rule__PolyShape__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1133:1: ( ( ( rule__PolyShape__MaterialFilesAssignment_1_1 ) ) )
            // InternalOBJ.g:1134:1: ( ( rule__PolyShape__MaterialFilesAssignment_1_1 ) )
            {
            // InternalOBJ.g:1134:1: ( ( rule__PolyShape__MaterialFilesAssignment_1_1 ) )
            // InternalOBJ.g:1135:2: ( rule__PolyShape__MaterialFilesAssignment_1_1 )
            {
             before(grammarAccess.getPolyShapeAccess().getMaterialFilesAssignment_1_1()); 
            // InternalOBJ.g:1136:2: ( rule__PolyShape__MaterialFilesAssignment_1_1 )
            // InternalOBJ.g:1136:3: rule__PolyShape__MaterialFilesAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__PolyShape__MaterialFilesAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getPolyShapeAccess().getMaterialFilesAssignment_1_1()); 

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


    // $ANTLR start "rule__PolyShape__Group_2__0"
    // InternalOBJ.g:1145:1: rule__PolyShape__Group_2__0 : rule__PolyShape__Group_2__0__Impl rule__PolyShape__Group_2__1 ;
    public final void rule__PolyShape__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1149:1: ( rule__PolyShape__Group_2__0__Impl rule__PolyShape__Group_2__1 )
            // InternalOBJ.g:1150:2: rule__PolyShape__Group_2__0__Impl rule__PolyShape__Group_2__1
            {
            pushFollow(FOLLOW_8);
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
    // InternalOBJ.g:1157:1: rule__PolyShape__Group_2__0__Impl : ( 'g' ) ;
    public final void rule__PolyShape__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1161:1: ( ( 'g' ) )
            // InternalOBJ.g:1162:1: ( 'g' )
            {
            // InternalOBJ.g:1162:1: ( 'g' )
            // InternalOBJ.g:1163:2: 'g'
            {
             before(grammarAccess.getPolyShapeAccess().getGKeyword_2_0()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getPolyShapeAccess().getGKeyword_2_0()); 

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
    // InternalOBJ.g:1172:1: rule__PolyShape__Group_2__1 : rule__PolyShape__Group_2__1__Impl ;
    public final void rule__PolyShape__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1176:1: ( rule__PolyShape__Group_2__1__Impl )
            // InternalOBJ.g:1177:2: rule__PolyShape__Group_2__1__Impl
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
    // InternalOBJ.g:1183:1: rule__PolyShape__Group_2__1__Impl : ( ( rule__PolyShape__NameAssignment_2_1 )? ) ;
    public final void rule__PolyShape__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1187:1: ( ( ( rule__PolyShape__NameAssignment_2_1 )? ) )
            // InternalOBJ.g:1188:1: ( ( rule__PolyShape__NameAssignment_2_1 )? )
            {
            // InternalOBJ.g:1188:1: ( ( rule__PolyShape__NameAssignment_2_1 )? )
            // InternalOBJ.g:1189:2: ( rule__PolyShape__NameAssignment_2_1 )?
            {
             before(grammarAccess.getPolyShapeAccess().getNameAssignment_2_1()); 
            // InternalOBJ.g:1190:2: ( rule__PolyShape__NameAssignment_2_1 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=RULE_STRING && LA18_0<=RULE_INT)||(LA18_0>=13 && LA18_0<=18)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalOBJ.g:1190:3: rule__PolyShape__NameAssignment_2_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__PolyShape__NameAssignment_2_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPolyShapeAccess().getNameAssignment_2_1()); 

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


    // $ANTLR start "rule__PolyShape__Group_3__0"
    // InternalOBJ.g:1199:1: rule__PolyShape__Group_3__0 : rule__PolyShape__Group_3__0__Impl rule__PolyShape__Group_3__1 ;
    public final void rule__PolyShape__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1203:1: ( rule__PolyShape__Group_3__0__Impl rule__PolyShape__Group_3__1 )
            // InternalOBJ.g:1204:2: rule__PolyShape__Group_3__0__Impl rule__PolyShape__Group_3__1
            {
            pushFollow(FOLLOW_8);
            rule__PolyShape__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PolyShape__Group_3__1();

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
    // $ANTLR end "rule__PolyShape__Group_3__0"


    // $ANTLR start "rule__PolyShape__Group_3__0__Impl"
    // InternalOBJ.g:1211:1: rule__PolyShape__Group_3__0__Impl : ( 'usemtl' ) ;
    public final void rule__PolyShape__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1215:1: ( ( 'usemtl' ) )
            // InternalOBJ.g:1216:1: ( 'usemtl' )
            {
            // InternalOBJ.g:1216:1: ( 'usemtl' )
            // InternalOBJ.g:1217:2: 'usemtl'
            {
             before(grammarAccess.getPolyShapeAccess().getUsemtlKeyword_3_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getPolyShapeAccess().getUsemtlKeyword_3_0()); 

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
    // $ANTLR end "rule__PolyShape__Group_3__0__Impl"


    // $ANTLR start "rule__PolyShape__Group_3__1"
    // InternalOBJ.g:1226:1: rule__PolyShape__Group_3__1 : rule__PolyShape__Group_3__1__Impl ;
    public final void rule__PolyShape__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1230:1: ( rule__PolyShape__Group_3__1__Impl )
            // InternalOBJ.g:1231:2: rule__PolyShape__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PolyShape__Group_3__1__Impl();

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
    // $ANTLR end "rule__PolyShape__Group_3__1"


    // $ANTLR start "rule__PolyShape__Group_3__1__Impl"
    // InternalOBJ.g:1237:1: rule__PolyShape__Group_3__1__Impl : ( ( rule__PolyShape__MaterialAssignment_3_1 ) ) ;
    public final void rule__PolyShape__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1241:1: ( ( ( rule__PolyShape__MaterialAssignment_3_1 ) ) )
            // InternalOBJ.g:1242:1: ( ( rule__PolyShape__MaterialAssignment_3_1 ) )
            {
            // InternalOBJ.g:1242:1: ( ( rule__PolyShape__MaterialAssignment_3_1 ) )
            // InternalOBJ.g:1243:2: ( rule__PolyShape__MaterialAssignment_3_1 )
            {
             before(grammarAccess.getPolyShapeAccess().getMaterialAssignment_3_1()); 
            // InternalOBJ.g:1244:2: ( rule__PolyShape__MaterialAssignment_3_1 )
            // InternalOBJ.g:1244:3: rule__PolyShape__MaterialAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__PolyShape__MaterialAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getPolyShapeAccess().getMaterialAssignment_3_1()); 

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
    // $ANTLR end "rule__PolyShape__Group_3__1__Impl"


    // $ANTLR start "rule__PolyShape__Group_4_0__0"
    // InternalOBJ.g:1253:1: rule__PolyShape__Group_4_0__0 : rule__PolyShape__Group_4_0__0__Impl rule__PolyShape__Group_4_0__1 ;
    public final void rule__PolyShape__Group_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1257:1: ( rule__PolyShape__Group_4_0__0__Impl rule__PolyShape__Group_4_0__1 )
            // InternalOBJ.g:1258:2: rule__PolyShape__Group_4_0__0__Impl rule__PolyShape__Group_4_0__1
            {
            pushFollow(FOLLOW_9);
            rule__PolyShape__Group_4_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PolyShape__Group_4_0__1();

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
    // $ANTLR end "rule__PolyShape__Group_4_0__0"


    // $ANTLR start "rule__PolyShape__Group_4_0__0__Impl"
    // InternalOBJ.g:1265:1: rule__PolyShape__Group_4_0__0__Impl : ( 'f' ) ;
    public final void rule__PolyShape__Group_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1269:1: ( ( 'f' ) )
            // InternalOBJ.g:1270:1: ( 'f' )
            {
            // InternalOBJ.g:1270:1: ( 'f' )
            // InternalOBJ.g:1271:2: 'f'
            {
             before(grammarAccess.getPolyShapeAccess().getFKeyword_4_0_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getPolyShapeAccess().getFKeyword_4_0_0()); 

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
    // $ANTLR end "rule__PolyShape__Group_4_0__0__Impl"


    // $ANTLR start "rule__PolyShape__Group_4_0__1"
    // InternalOBJ.g:1280:1: rule__PolyShape__Group_4_0__1 : rule__PolyShape__Group_4_0__1__Impl ;
    public final void rule__PolyShape__Group_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1284:1: ( rule__PolyShape__Group_4_0__1__Impl )
            // InternalOBJ.g:1285:2: rule__PolyShape__Group_4_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PolyShape__Group_4_0__1__Impl();

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
    // $ANTLR end "rule__PolyShape__Group_4_0__1"


    // $ANTLR start "rule__PolyShape__Group_4_0__1__Impl"
    // InternalOBJ.g:1291:1: rule__PolyShape__Group_4_0__1__Impl : ( ( rule__PolyShape__FacesAssignment_4_0_1 ) ) ;
    public final void rule__PolyShape__Group_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1295:1: ( ( ( rule__PolyShape__FacesAssignment_4_0_1 ) ) )
            // InternalOBJ.g:1296:1: ( ( rule__PolyShape__FacesAssignment_4_0_1 ) )
            {
            // InternalOBJ.g:1296:1: ( ( rule__PolyShape__FacesAssignment_4_0_1 ) )
            // InternalOBJ.g:1297:2: ( rule__PolyShape__FacesAssignment_4_0_1 )
            {
             before(grammarAccess.getPolyShapeAccess().getFacesAssignment_4_0_1()); 
            // InternalOBJ.g:1298:2: ( rule__PolyShape__FacesAssignment_4_0_1 )
            // InternalOBJ.g:1298:3: rule__PolyShape__FacesAssignment_4_0_1
            {
            pushFollow(FOLLOW_2);
            rule__PolyShape__FacesAssignment_4_0_1();

            state._fsp--;


            }

             after(grammarAccess.getPolyShapeAccess().getFacesAssignment_4_0_1()); 

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
    // $ANTLR end "rule__PolyShape__Group_4_0__1__Impl"


    // $ANTLR start "rule__PolyShape__Group_4_1__0"
    // InternalOBJ.g:1307:1: rule__PolyShape__Group_4_1__0 : rule__PolyShape__Group_4_1__0__Impl rule__PolyShape__Group_4_1__1 ;
    public final void rule__PolyShape__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1311:1: ( rule__PolyShape__Group_4_1__0__Impl rule__PolyShape__Group_4_1__1 )
            // InternalOBJ.g:1312:2: rule__PolyShape__Group_4_1__0__Impl rule__PolyShape__Group_4_1__1
            {
            pushFollow(FOLLOW_11);
            rule__PolyShape__Group_4_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PolyShape__Group_4_1__1();

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
    // $ANTLR end "rule__PolyShape__Group_4_1__0"


    // $ANTLR start "rule__PolyShape__Group_4_1__0__Impl"
    // InternalOBJ.g:1319:1: rule__PolyShape__Group_4_1__0__Impl : ( 's' ) ;
    public final void rule__PolyShape__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1323:1: ( ( 's' ) )
            // InternalOBJ.g:1324:1: ( 's' )
            {
            // InternalOBJ.g:1324:1: ( 's' )
            // InternalOBJ.g:1325:2: 's'
            {
             before(grammarAccess.getPolyShapeAccess().getSKeyword_4_1_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getPolyShapeAccess().getSKeyword_4_1_0()); 

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
    // $ANTLR end "rule__PolyShape__Group_4_1__0__Impl"


    // $ANTLR start "rule__PolyShape__Group_4_1__1"
    // InternalOBJ.g:1334:1: rule__PolyShape__Group_4_1__1 : rule__PolyShape__Group_4_1__1__Impl ;
    public final void rule__PolyShape__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1338:1: ( rule__PolyShape__Group_4_1__1__Impl )
            // InternalOBJ.g:1339:2: rule__PolyShape__Group_4_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PolyShape__Group_4_1__1__Impl();

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
    // $ANTLR end "rule__PolyShape__Group_4_1__1"


    // $ANTLR start "rule__PolyShape__Group_4_1__1__Impl"
    // InternalOBJ.g:1345:1: rule__PolyShape__Group_4_1__1__Impl : ( ( rule__PolyShape__Alternatives_4_1_1 ) ) ;
    public final void rule__PolyShape__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1349:1: ( ( ( rule__PolyShape__Alternatives_4_1_1 ) ) )
            // InternalOBJ.g:1350:1: ( ( rule__PolyShape__Alternatives_4_1_1 ) )
            {
            // InternalOBJ.g:1350:1: ( ( rule__PolyShape__Alternatives_4_1_1 ) )
            // InternalOBJ.g:1351:2: ( rule__PolyShape__Alternatives_4_1_1 )
            {
             before(grammarAccess.getPolyShapeAccess().getAlternatives_4_1_1()); 
            // InternalOBJ.g:1352:2: ( rule__PolyShape__Alternatives_4_1_1 )
            // InternalOBJ.g:1352:3: rule__PolyShape__Alternatives_4_1_1
            {
            pushFollow(FOLLOW_2);
            rule__PolyShape__Alternatives_4_1_1();

            state._fsp--;


            }

             after(grammarAccess.getPolyShapeAccess().getAlternatives_4_1_1()); 

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
    // $ANTLR end "rule__PolyShape__Group_4_1__1__Impl"


    // $ANTLR start "rule__Face__Group__0"
    // InternalOBJ.g:1361:1: rule__Face__Group__0 : rule__Face__Group__0__Impl rule__Face__Group__1 ;
    public final void rule__Face__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1365:1: ( rule__Face__Group__0__Impl rule__Face__Group__1 )
            // InternalOBJ.g:1366:2: rule__Face__Group__0__Impl rule__Face__Group__1
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
    // InternalOBJ.g:1373:1: rule__Face__Group__0__Impl : ( () ) ;
    public final void rule__Face__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1377:1: ( ( () ) )
            // InternalOBJ.g:1378:1: ( () )
            {
            // InternalOBJ.g:1378:1: ( () )
            // InternalOBJ.g:1379:2: ()
            {
             before(grammarAccess.getFaceAccess().getFaceAction_0()); 
            // InternalOBJ.g:1380:2: ()
            // InternalOBJ.g:1380:3: 
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
    // InternalOBJ.g:1388:1: rule__Face__Group__1 : rule__Face__Group__1__Impl ;
    public final void rule__Face__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1392:1: ( rule__Face__Group__1__Impl )
            // InternalOBJ.g:1393:2: rule__Face__Group__1__Impl
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
    // InternalOBJ.g:1399:1: rule__Face__Group__1__Impl : ( ( rule__Face__Group_1__0 )* ) ;
    public final void rule__Face__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1403:1: ( ( ( rule__Face__Group_1__0 )* ) )
            // InternalOBJ.g:1404:1: ( ( rule__Face__Group_1__0 )* )
            {
            // InternalOBJ.g:1404:1: ( ( rule__Face__Group_1__0 )* )
            // InternalOBJ.g:1405:2: ( rule__Face__Group_1__0 )*
            {
             before(grammarAccess.getFaceAccess().getGroup_1()); 
            // InternalOBJ.g:1406:2: ( rule__Face__Group_1__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_INT||LA19_0==18) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalOBJ.g:1406:3: rule__Face__Group_1__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__Face__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
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
    // InternalOBJ.g:1415:1: rule__Face__Group_1__0 : rule__Face__Group_1__0__Impl rule__Face__Group_1__1 ;
    public final void rule__Face__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1419:1: ( rule__Face__Group_1__0__Impl rule__Face__Group_1__1 )
            // InternalOBJ.g:1420:2: rule__Face__Group_1__0__Impl rule__Face__Group_1__1
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
    // InternalOBJ.g:1427:1: rule__Face__Group_1__0__Impl : ( ( rule__Face__VertexIndicesAssignment_1_0 ) ) ;
    public final void rule__Face__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1431:1: ( ( ( rule__Face__VertexIndicesAssignment_1_0 ) ) )
            // InternalOBJ.g:1432:1: ( ( rule__Face__VertexIndicesAssignment_1_0 ) )
            {
            // InternalOBJ.g:1432:1: ( ( rule__Face__VertexIndicesAssignment_1_0 ) )
            // InternalOBJ.g:1433:2: ( rule__Face__VertexIndicesAssignment_1_0 )
            {
             before(grammarAccess.getFaceAccess().getVertexIndicesAssignment_1_0()); 
            // InternalOBJ.g:1434:2: ( rule__Face__VertexIndicesAssignment_1_0 )
            // InternalOBJ.g:1434:3: rule__Face__VertexIndicesAssignment_1_0
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
    // InternalOBJ.g:1442:1: rule__Face__Group_1__1 : rule__Face__Group_1__1__Impl ;
    public final void rule__Face__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1446:1: ( rule__Face__Group_1__1__Impl )
            // InternalOBJ.g:1447:2: rule__Face__Group_1__1__Impl
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
    // InternalOBJ.g:1453:1: rule__Face__Group_1__1__Impl : ( ( rule__Face__Group_1_1__0 )? ) ;
    public final void rule__Face__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1457:1: ( ( ( rule__Face__Group_1_1__0 )? ) )
            // InternalOBJ.g:1458:1: ( ( rule__Face__Group_1_1__0 )? )
            {
            // InternalOBJ.g:1458:1: ( ( rule__Face__Group_1_1__0 )? )
            // InternalOBJ.g:1459:2: ( rule__Face__Group_1_1__0 )?
            {
             before(grammarAccess.getFaceAccess().getGroup_1_1()); 
            // InternalOBJ.g:1460:2: ( rule__Face__Group_1_1__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==14) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalOBJ.g:1460:3: rule__Face__Group_1_1__0
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
    // InternalOBJ.g:1469:1: rule__Face__Group_1_1__0 : rule__Face__Group_1_1__0__Impl rule__Face__Group_1_1__1 ;
    public final void rule__Face__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1473:1: ( rule__Face__Group_1_1__0__Impl rule__Face__Group_1_1__1 )
            // InternalOBJ.g:1474:2: rule__Face__Group_1_1__0__Impl rule__Face__Group_1_1__1
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
    // InternalOBJ.g:1481:1: rule__Face__Group_1_1__0__Impl : ( '/' ) ;
    public final void rule__Face__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1485:1: ( ( '/' ) )
            // InternalOBJ.g:1486:1: ( '/' )
            {
            // InternalOBJ.g:1486:1: ( '/' )
            // InternalOBJ.g:1487:2: '/'
            {
             before(grammarAccess.getFaceAccess().getSolidusKeyword_1_1_0()); 
            match(input,14,FOLLOW_2); 
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
    // InternalOBJ.g:1496:1: rule__Face__Group_1_1__1 : rule__Face__Group_1_1__1__Impl ;
    public final void rule__Face__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1500:1: ( rule__Face__Group_1_1__1__Impl )
            // InternalOBJ.g:1501:2: rule__Face__Group_1_1__1__Impl
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
    // InternalOBJ.g:1507:1: rule__Face__Group_1_1__1__Impl : ( ( rule__Face__Alternatives_1_1_1 ) ) ;
    public final void rule__Face__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1511:1: ( ( ( rule__Face__Alternatives_1_1_1 ) ) )
            // InternalOBJ.g:1512:1: ( ( rule__Face__Alternatives_1_1_1 ) )
            {
            // InternalOBJ.g:1512:1: ( ( rule__Face__Alternatives_1_1_1 ) )
            // InternalOBJ.g:1513:2: ( rule__Face__Alternatives_1_1_1 )
            {
             before(grammarAccess.getFaceAccess().getAlternatives_1_1_1()); 
            // InternalOBJ.g:1514:2: ( rule__Face__Alternatives_1_1_1 )
            // InternalOBJ.g:1514:3: rule__Face__Alternatives_1_1_1
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
    // InternalOBJ.g:1523:1: rule__Face__Group_1_1_1_1__0 : rule__Face__Group_1_1_1_1__0__Impl rule__Face__Group_1_1_1_1__1 ;
    public final void rule__Face__Group_1_1_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1527:1: ( rule__Face__Group_1_1_1_1__0__Impl rule__Face__Group_1_1_1_1__1 )
            // InternalOBJ.g:1528:2: rule__Face__Group_1_1_1_1__0__Impl rule__Face__Group_1_1_1_1__1
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
    // InternalOBJ.g:1535:1: rule__Face__Group_1_1_1_1__0__Impl : ( ( rule__Face__TextureIndicesAssignment_1_1_1_1_0 ) ) ;
    public final void rule__Face__Group_1_1_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1539:1: ( ( ( rule__Face__TextureIndicesAssignment_1_1_1_1_0 ) ) )
            // InternalOBJ.g:1540:1: ( ( rule__Face__TextureIndicesAssignment_1_1_1_1_0 ) )
            {
            // InternalOBJ.g:1540:1: ( ( rule__Face__TextureIndicesAssignment_1_1_1_1_0 ) )
            // InternalOBJ.g:1541:2: ( rule__Face__TextureIndicesAssignment_1_1_1_1_0 )
            {
             before(grammarAccess.getFaceAccess().getTextureIndicesAssignment_1_1_1_1_0()); 
            // InternalOBJ.g:1542:2: ( rule__Face__TextureIndicesAssignment_1_1_1_1_0 )
            // InternalOBJ.g:1542:3: rule__Face__TextureIndicesAssignment_1_1_1_1_0
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
    // InternalOBJ.g:1550:1: rule__Face__Group_1_1_1_1__1 : rule__Face__Group_1_1_1_1__1__Impl rule__Face__Group_1_1_1_1__2 ;
    public final void rule__Face__Group_1_1_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1554:1: ( rule__Face__Group_1_1_1_1__1__Impl rule__Face__Group_1_1_1_1__2 )
            // InternalOBJ.g:1555:2: rule__Face__Group_1_1_1_1__1__Impl rule__Face__Group_1_1_1_1__2
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
    // InternalOBJ.g:1562:1: rule__Face__Group_1_1_1_1__1__Impl : ( '/' ) ;
    public final void rule__Face__Group_1_1_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1566:1: ( ( '/' ) )
            // InternalOBJ.g:1567:1: ( '/' )
            {
            // InternalOBJ.g:1567:1: ( '/' )
            // InternalOBJ.g:1568:2: '/'
            {
             before(grammarAccess.getFaceAccess().getSolidusKeyword_1_1_1_1_1()); 
            match(input,14,FOLLOW_2); 
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
    // InternalOBJ.g:1577:1: rule__Face__Group_1_1_1_1__2 : rule__Face__Group_1_1_1_1__2__Impl ;
    public final void rule__Face__Group_1_1_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1581:1: ( rule__Face__Group_1_1_1_1__2__Impl )
            // InternalOBJ.g:1582:2: rule__Face__Group_1_1_1_1__2__Impl
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
    // InternalOBJ.g:1588:1: rule__Face__Group_1_1_1_1__2__Impl : ( ruleEInt ) ;
    public final void rule__Face__Group_1_1_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1592:1: ( ( ruleEInt ) )
            // InternalOBJ.g:1593:1: ( ruleEInt )
            {
            // InternalOBJ.g:1593:1: ( ruleEInt )
            // InternalOBJ.g:1594:2: ruleEInt
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
    // InternalOBJ.g:1604:1: rule__Face__Group_1_1_1_2__0 : rule__Face__Group_1_1_1_2__0__Impl rule__Face__Group_1_1_1_2__1 ;
    public final void rule__Face__Group_1_1_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1608:1: ( rule__Face__Group_1_1_1_2__0__Impl rule__Face__Group_1_1_1_2__1 )
            // InternalOBJ.g:1609:2: rule__Face__Group_1_1_1_2__0__Impl rule__Face__Group_1_1_1_2__1
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
    // InternalOBJ.g:1616:1: rule__Face__Group_1_1_1_2__0__Impl : ( '/' ) ;
    public final void rule__Face__Group_1_1_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1620:1: ( ( '/' ) )
            // InternalOBJ.g:1621:1: ( '/' )
            {
            // InternalOBJ.g:1621:1: ( '/' )
            // InternalOBJ.g:1622:2: '/'
            {
             before(grammarAccess.getFaceAccess().getSolidusKeyword_1_1_1_2_0()); 
            match(input,14,FOLLOW_2); 
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
    // InternalOBJ.g:1631:1: rule__Face__Group_1_1_1_2__1 : rule__Face__Group_1_1_1_2__1__Impl ;
    public final void rule__Face__Group_1_1_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1635:1: ( rule__Face__Group_1_1_1_2__1__Impl )
            // InternalOBJ.g:1636:2: rule__Face__Group_1_1_1_2__1__Impl
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
    // InternalOBJ.g:1642:1: rule__Face__Group_1_1_1_2__1__Impl : ( ruleEInt ) ;
    public final void rule__Face__Group_1_1_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1646:1: ( ( ruleEInt ) )
            // InternalOBJ.g:1647:1: ( ruleEInt )
            {
            // InternalOBJ.g:1647:1: ( ruleEInt )
            // InternalOBJ.g:1648:2: ruleEInt
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
    // InternalOBJ.g:1658:1: rule__Vertex__Group__0 : rule__Vertex__Group__0__Impl rule__Vertex__Group__1 ;
    public final void rule__Vertex__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1662:1: ( rule__Vertex__Group__0__Impl rule__Vertex__Group__1 )
            // InternalOBJ.g:1663:2: rule__Vertex__Group__0__Impl rule__Vertex__Group__1
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
    // InternalOBJ.g:1670:1: rule__Vertex__Group__0__Impl : ( () ) ;
    public final void rule__Vertex__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1674:1: ( ( () ) )
            // InternalOBJ.g:1675:1: ( () )
            {
            // InternalOBJ.g:1675:1: ( () )
            // InternalOBJ.g:1676:2: ()
            {
             before(grammarAccess.getVertexAccess().getVertexAction_0()); 
            // InternalOBJ.g:1677:2: ()
            // InternalOBJ.g:1677:3: 
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
    // InternalOBJ.g:1685:1: rule__Vertex__Group__1 : rule__Vertex__Group__1__Impl rule__Vertex__Group__2 ;
    public final void rule__Vertex__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1689:1: ( rule__Vertex__Group__1__Impl rule__Vertex__Group__2 )
            // InternalOBJ.g:1690:2: rule__Vertex__Group__1__Impl rule__Vertex__Group__2
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
    // InternalOBJ.g:1697:1: rule__Vertex__Group__1__Impl : ( ( rule__Vertex__XAssignment_1 ) ) ;
    public final void rule__Vertex__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1701:1: ( ( ( rule__Vertex__XAssignment_1 ) ) )
            // InternalOBJ.g:1702:1: ( ( rule__Vertex__XAssignment_1 ) )
            {
            // InternalOBJ.g:1702:1: ( ( rule__Vertex__XAssignment_1 ) )
            // InternalOBJ.g:1703:2: ( rule__Vertex__XAssignment_1 )
            {
             before(grammarAccess.getVertexAccess().getXAssignment_1()); 
            // InternalOBJ.g:1704:2: ( rule__Vertex__XAssignment_1 )
            // InternalOBJ.g:1704:3: rule__Vertex__XAssignment_1
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
    // InternalOBJ.g:1712:1: rule__Vertex__Group__2 : rule__Vertex__Group__2__Impl rule__Vertex__Group__3 ;
    public final void rule__Vertex__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1716:1: ( rule__Vertex__Group__2__Impl rule__Vertex__Group__3 )
            // InternalOBJ.g:1717:2: rule__Vertex__Group__2__Impl rule__Vertex__Group__3
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
    // InternalOBJ.g:1724:1: rule__Vertex__Group__2__Impl : ( ( rule__Vertex__YAssignment_2 ) ) ;
    public final void rule__Vertex__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1728:1: ( ( ( rule__Vertex__YAssignment_2 ) ) )
            // InternalOBJ.g:1729:1: ( ( rule__Vertex__YAssignment_2 ) )
            {
            // InternalOBJ.g:1729:1: ( ( rule__Vertex__YAssignment_2 ) )
            // InternalOBJ.g:1730:2: ( rule__Vertex__YAssignment_2 )
            {
             before(grammarAccess.getVertexAccess().getYAssignment_2()); 
            // InternalOBJ.g:1731:2: ( rule__Vertex__YAssignment_2 )
            // InternalOBJ.g:1731:3: rule__Vertex__YAssignment_2
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
    // InternalOBJ.g:1739:1: rule__Vertex__Group__3 : rule__Vertex__Group__3__Impl ;
    public final void rule__Vertex__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1743:1: ( rule__Vertex__Group__3__Impl )
            // InternalOBJ.g:1744:2: rule__Vertex__Group__3__Impl
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
    // InternalOBJ.g:1750:1: rule__Vertex__Group__3__Impl : ( ( rule__Vertex__ZAssignment_3 ) ) ;
    public final void rule__Vertex__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1754:1: ( ( ( rule__Vertex__ZAssignment_3 ) ) )
            // InternalOBJ.g:1755:1: ( ( rule__Vertex__ZAssignment_3 ) )
            {
            // InternalOBJ.g:1755:1: ( ( rule__Vertex__ZAssignment_3 ) )
            // InternalOBJ.g:1756:2: ( rule__Vertex__ZAssignment_3 )
            {
             before(grammarAccess.getVertexAccess().getZAssignment_3()); 
            // InternalOBJ.g:1757:2: ( rule__Vertex__ZAssignment_3 )
            // InternalOBJ.g:1757:3: rule__Vertex__ZAssignment_3
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
    // InternalOBJ.g:1766:1: rule__TextureVertex__Group__0 : rule__TextureVertex__Group__0__Impl rule__TextureVertex__Group__1 ;
    public final void rule__TextureVertex__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1770:1: ( rule__TextureVertex__Group__0__Impl rule__TextureVertex__Group__1 )
            // InternalOBJ.g:1771:2: rule__TextureVertex__Group__0__Impl rule__TextureVertex__Group__1
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
    // InternalOBJ.g:1778:1: rule__TextureVertex__Group__0__Impl : ( ( rule__TextureVertex__XAssignment_0 ) ) ;
    public final void rule__TextureVertex__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1782:1: ( ( ( rule__TextureVertex__XAssignment_0 ) ) )
            // InternalOBJ.g:1783:1: ( ( rule__TextureVertex__XAssignment_0 ) )
            {
            // InternalOBJ.g:1783:1: ( ( rule__TextureVertex__XAssignment_0 ) )
            // InternalOBJ.g:1784:2: ( rule__TextureVertex__XAssignment_0 )
            {
             before(grammarAccess.getTextureVertexAccess().getXAssignment_0()); 
            // InternalOBJ.g:1785:2: ( rule__TextureVertex__XAssignment_0 )
            // InternalOBJ.g:1785:3: rule__TextureVertex__XAssignment_0
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
    // InternalOBJ.g:1793:1: rule__TextureVertex__Group__1 : rule__TextureVertex__Group__1__Impl rule__TextureVertex__Group__2 ;
    public final void rule__TextureVertex__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1797:1: ( rule__TextureVertex__Group__1__Impl rule__TextureVertex__Group__2 )
            // InternalOBJ.g:1798:2: rule__TextureVertex__Group__1__Impl rule__TextureVertex__Group__2
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
    // InternalOBJ.g:1805:1: rule__TextureVertex__Group__1__Impl : ( ( rule__TextureVertex__YAssignment_1 ) ) ;
    public final void rule__TextureVertex__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1809:1: ( ( ( rule__TextureVertex__YAssignment_1 ) ) )
            // InternalOBJ.g:1810:1: ( ( rule__TextureVertex__YAssignment_1 ) )
            {
            // InternalOBJ.g:1810:1: ( ( rule__TextureVertex__YAssignment_1 ) )
            // InternalOBJ.g:1811:2: ( rule__TextureVertex__YAssignment_1 )
            {
             before(grammarAccess.getTextureVertexAccess().getYAssignment_1()); 
            // InternalOBJ.g:1812:2: ( rule__TextureVertex__YAssignment_1 )
            // InternalOBJ.g:1812:3: rule__TextureVertex__YAssignment_1
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
    // InternalOBJ.g:1820:1: rule__TextureVertex__Group__2 : rule__TextureVertex__Group__2__Impl ;
    public final void rule__TextureVertex__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1824:1: ( rule__TextureVertex__Group__2__Impl )
            // InternalOBJ.g:1825:2: rule__TextureVertex__Group__2__Impl
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
    // InternalOBJ.g:1831:1: rule__TextureVertex__Group__2__Impl : ( ( rule__TextureVertex__ZAssignment_2 )? ) ;
    public final void rule__TextureVertex__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1835:1: ( ( ( rule__TextureVertex__ZAssignment_2 )? ) )
            // InternalOBJ.g:1836:1: ( ( rule__TextureVertex__ZAssignment_2 )? )
            {
            // InternalOBJ.g:1836:1: ( ( rule__TextureVertex__ZAssignment_2 )? )
            // InternalOBJ.g:1837:2: ( rule__TextureVertex__ZAssignment_2 )?
            {
             before(grammarAccess.getTextureVertexAccess().getZAssignment_2()); 
            // InternalOBJ.g:1838:2: ( rule__TextureVertex__ZAssignment_2 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_INT && LA21_0<=RULE_DOUBLE)||LA21_0==18) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalOBJ.g:1838:3: rule__TextureVertex__ZAssignment_2
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
    // InternalOBJ.g:1847:1: rule__Material__Group__0 : rule__Material__Group__0__Impl rule__Material__Group__1 ;
    public final void rule__Material__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1851:1: ( rule__Material__Group__0__Impl rule__Material__Group__1 )
            // InternalOBJ.g:1852:2: rule__Material__Group__0__Impl rule__Material__Group__1
            {
            pushFollow(FOLLOW_8);
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
    // InternalOBJ.g:1859:1: rule__Material__Group__0__Impl : ( () ) ;
    public final void rule__Material__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1863:1: ( ( () ) )
            // InternalOBJ.g:1864:1: ( () )
            {
            // InternalOBJ.g:1864:1: ( () )
            // InternalOBJ.g:1865:2: ()
            {
             before(grammarAccess.getMaterialAccess().getMaterialAction_0()); 
            // InternalOBJ.g:1866:2: ()
            // InternalOBJ.g:1866:3: 
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
    // InternalOBJ.g:1874:1: rule__Material__Group__1 : rule__Material__Group__1__Impl ;
    public final void rule__Material__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1878:1: ( rule__Material__Group__1__Impl )
            // InternalOBJ.g:1879:2: rule__Material__Group__1__Impl
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
    // InternalOBJ.g:1885:1: rule__Material__Group__1__Impl : ( ( rule__Material__PhongMatNameAssignment_1 ) ) ;
    public final void rule__Material__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1889:1: ( ( ( rule__Material__PhongMatNameAssignment_1 ) ) )
            // InternalOBJ.g:1890:1: ( ( rule__Material__PhongMatNameAssignment_1 ) )
            {
            // InternalOBJ.g:1890:1: ( ( rule__Material__PhongMatNameAssignment_1 ) )
            // InternalOBJ.g:1891:2: ( rule__Material__PhongMatNameAssignment_1 )
            {
             before(grammarAccess.getMaterialAccess().getPhongMatNameAssignment_1()); 
            // InternalOBJ.g:1892:2: ( rule__Material__PhongMatNameAssignment_1 )
            // InternalOBJ.g:1892:3: rule__Material__PhongMatNameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Material__PhongMatNameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMaterialAccess().getPhongMatNameAssignment_1()); 

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
    // InternalOBJ.g:1901:1: rule__EInt__Group__0 : rule__EInt__Group__0__Impl rule__EInt__Group__1 ;
    public final void rule__EInt__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1905:1: ( rule__EInt__Group__0__Impl rule__EInt__Group__1 )
            // InternalOBJ.g:1906:2: rule__EInt__Group__0__Impl rule__EInt__Group__1
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
    // InternalOBJ.g:1913:1: rule__EInt__Group__0__Impl : ( ( '-' )? ) ;
    public final void rule__EInt__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1917:1: ( ( ( '-' )? ) )
            // InternalOBJ.g:1918:1: ( ( '-' )? )
            {
            // InternalOBJ.g:1918:1: ( ( '-' )? )
            // InternalOBJ.g:1919:2: ( '-' )?
            {
             before(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
            // InternalOBJ.g:1920:2: ( '-' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==18) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalOBJ.g:1920:3: '-'
                    {
                    match(input,18,FOLLOW_2); 

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
    // InternalOBJ.g:1928:1: rule__EInt__Group__1 : rule__EInt__Group__1__Impl ;
    public final void rule__EInt__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1932:1: ( rule__EInt__Group__1__Impl )
            // InternalOBJ.g:1933:2: rule__EInt__Group__1__Impl
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
    // InternalOBJ.g:1939:1: rule__EInt__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__EInt__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1943:1: ( ( RULE_INT ) )
            // InternalOBJ.g:1944:1: ( RULE_INT )
            {
            // InternalOBJ.g:1944:1: ( RULE_INT )
            // InternalOBJ.g:1945:2: RULE_INT
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


    // $ANTLR start "rule__Geometry__VertexSourcesAssignment_0"
    // InternalOBJ.g:1955:1: rule__Geometry__VertexSourcesAssignment_0 : ( ruleVertexSource ) ;
    public final void rule__Geometry__VertexSourcesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1959:1: ( ( ruleVertexSource ) )
            // InternalOBJ.g:1960:2: ( ruleVertexSource )
            {
            // InternalOBJ.g:1960:2: ( ruleVertexSource )
            // InternalOBJ.g:1961:3: ruleVertexSource
            {
             before(grammarAccess.getGeometryAccess().getVertexSourcesVertexSourceParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleVertexSource();

            state._fsp--;

             after(grammarAccess.getGeometryAccess().getVertexSourcesVertexSourceParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__Geometry__VertexSourcesAssignment_0"


    // $ANTLR start "rule__Geometry__NodesAssignment_1"
    // InternalOBJ.g:1970:1: rule__Geometry__NodesAssignment_1 : ( rulePolyShape ) ;
    public final void rule__Geometry__NodesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1974:1: ( ( rulePolyShape ) )
            // InternalOBJ.g:1975:2: ( rulePolyShape )
            {
            // InternalOBJ.g:1975:2: ( rulePolyShape )
            // InternalOBJ.g:1976:3: rulePolyShape
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
    // InternalOBJ.g:1985:1: rule__VertexSource__MaterialFilesAssignment_1_1 : ( ruleEString ) ;
    public final void rule__VertexSource__MaterialFilesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:1989:1: ( ( ruleEString ) )
            // InternalOBJ.g:1990:2: ( ruleEString )
            {
            // InternalOBJ.g:1990:2: ( ruleEString )
            // InternalOBJ.g:1991:3: ruleEString
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
    // InternalOBJ.g:2000:1: rule__VertexSource__VerticesAssignment_3_0_1 : ( ruleVertex ) ;
    public final void rule__VertexSource__VerticesAssignment_3_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:2004:1: ( ( ruleVertex ) )
            // InternalOBJ.g:2005:2: ( ruleVertex )
            {
            // InternalOBJ.g:2005:2: ( ruleVertex )
            // InternalOBJ.g:2006:3: ruleVertex
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
    // InternalOBJ.g:2015:1: rule__VertexSource__TextureCoordinatesAssignment_3_1_1 : ( ruleTextureVertex ) ;
    public final void rule__VertexSource__TextureCoordinatesAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:2019:1: ( ( ruleTextureVertex ) )
            // InternalOBJ.g:2020:2: ( ruleTextureVertex )
            {
            // InternalOBJ.g:2020:2: ( ruleTextureVertex )
            // InternalOBJ.g:2021:3: ruleTextureVertex
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


    // $ANTLR start "rule__PolyShape__MaterialFilesAssignment_1_1"
    // InternalOBJ.g:2030:1: rule__PolyShape__MaterialFilesAssignment_1_1 : ( ruleEString ) ;
    public final void rule__PolyShape__MaterialFilesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:2034:1: ( ( ruleEString ) )
            // InternalOBJ.g:2035:2: ( ruleEString )
            {
            // InternalOBJ.g:2035:2: ( ruleEString )
            // InternalOBJ.g:2036:3: ruleEString
            {
             before(grammarAccess.getPolyShapeAccess().getMaterialFilesEStringParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getPolyShapeAccess().getMaterialFilesEStringParserRuleCall_1_1_0()); 

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
    // $ANTLR end "rule__PolyShape__MaterialFilesAssignment_1_1"


    // $ANTLR start "rule__PolyShape__NameAssignment_2_1"
    // InternalOBJ.g:2045:1: rule__PolyShape__NameAssignment_2_1 : ( ruleEString ) ;
    public final void rule__PolyShape__NameAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:2049:1: ( ( ruleEString ) )
            // InternalOBJ.g:2050:2: ( ruleEString )
            {
            // InternalOBJ.g:2050:2: ( ruleEString )
            // InternalOBJ.g:2051:3: ruleEString
            {
             before(grammarAccess.getPolyShapeAccess().getNameEStringParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getPolyShapeAccess().getNameEStringParserRuleCall_2_1_0()); 

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
    // $ANTLR end "rule__PolyShape__NameAssignment_2_1"


    // $ANTLR start "rule__PolyShape__MaterialAssignment_3_1"
    // InternalOBJ.g:2060:1: rule__PolyShape__MaterialAssignment_3_1 : ( ruleMaterial ) ;
    public final void rule__PolyShape__MaterialAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:2064:1: ( ( ruleMaterial ) )
            // InternalOBJ.g:2065:2: ( ruleMaterial )
            {
            // InternalOBJ.g:2065:2: ( ruleMaterial )
            // InternalOBJ.g:2066:3: ruleMaterial
            {
             before(grammarAccess.getPolyShapeAccess().getMaterialMaterialParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMaterial();

            state._fsp--;

             after(grammarAccess.getPolyShapeAccess().getMaterialMaterialParserRuleCall_3_1_0()); 

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
    // $ANTLR end "rule__PolyShape__MaterialAssignment_3_1"


    // $ANTLR start "rule__PolyShape__FacesAssignment_4_0_1"
    // InternalOBJ.g:2075:1: rule__PolyShape__FacesAssignment_4_0_1 : ( ruleFace ) ;
    public final void rule__PolyShape__FacesAssignment_4_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:2079:1: ( ( ruleFace ) )
            // InternalOBJ.g:2080:2: ( ruleFace )
            {
            // InternalOBJ.g:2080:2: ( ruleFace )
            // InternalOBJ.g:2081:3: ruleFace
            {
             before(grammarAccess.getPolyShapeAccess().getFacesFaceParserRuleCall_4_0_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFace();

            state._fsp--;

             after(grammarAccess.getPolyShapeAccess().getFacesFaceParserRuleCall_4_0_1_0()); 

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
    // $ANTLR end "rule__PolyShape__FacesAssignment_4_0_1"


    // $ANTLR start "rule__Face__VertexIndicesAssignment_1_0"
    // InternalOBJ.g:2090:1: rule__Face__VertexIndicesAssignment_1_0 : ( ruleEInt ) ;
    public final void rule__Face__VertexIndicesAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:2094:1: ( ( ruleEInt ) )
            // InternalOBJ.g:2095:2: ( ruleEInt )
            {
            // InternalOBJ.g:2095:2: ( ruleEInt )
            // InternalOBJ.g:2096:3: ruleEInt
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
    // InternalOBJ.g:2105:1: rule__Face__TextureIndicesAssignment_1_1_1_0 : ( ruleEInt ) ;
    public final void rule__Face__TextureIndicesAssignment_1_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:2109:1: ( ( ruleEInt ) )
            // InternalOBJ.g:2110:2: ( ruleEInt )
            {
            // InternalOBJ.g:2110:2: ( ruleEInt )
            // InternalOBJ.g:2111:3: ruleEInt
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
    // InternalOBJ.g:2120:1: rule__Face__TextureIndicesAssignment_1_1_1_1_0 : ( ruleEInt ) ;
    public final void rule__Face__TextureIndicesAssignment_1_1_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:2124:1: ( ( ruleEInt ) )
            // InternalOBJ.g:2125:2: ( ruleEInt )
            {
            // InternalOBJ.g:2125:2: ( ruleEInt )
            // InternalOBJ.g:2126:3: ruleEInt
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
    // InternalOBJ.g:2135:1: rule__Vertex__XAssignment_1 : ( ruleEDouble ) ;
    public final void rule__Vertex__XAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:2139:1: ( ( ruleEDouble ) )
            // InternalOBJ.g:2140:2: ( ruleEDouble )
            {
            // InternalOBJ.g:2140:2: ( ruleEDouble )
            // InternalOBJ.g:2141:3: ruleEDouble
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
    // InternalOBJ.g:2150:1: rule__Vertex__YAssignment_2 : ( ruleEDouble ) ;
    public final void rule__Vertex__YAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:2154:1: ( ( ruleEDouble ) )
            // InternalOBJ.g:2155:2: ( ruleEDouble )
            {
            // InternalOBJ.g:2155:2: ( ruleEDouble )
            // InternalOBJ.g:2156:3: ruleEDouble
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
    // InternalOBJ.g:2165:1: rule__Vertex__ZAssignment_3 : ( ruleEDouble ) ;
    public final void rule__Vertex__ZAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:2169:1: ( ( ruleEDouble ) )
            // InternalOBJ.g:2170:2: ( ruleEDouble )
            {
            // InternalOBJ.g:2170:2: ( ruleEDouble )
            // InternalOBJ.g:2171:3: ruleEDouble
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
    // InternalOBJ.g:2180:1: rule__TextureVertex__XAssignment_0 : ( ruleEDouble ) ;
    public final void rule__TextureVertex__XAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:2184:1: ( ( ruleEDouble ) )
            // InternalOBJ.g:2185:2: ( ruleEDouble )
            {
            // InternalOBJ.g:2185:2: ( ruleEDouble )
            // InternalOBJ.g:2186:3: ruleEDouble
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
    // InternalOBJ.g:2195:1: rule__TextureVertex__YAssignment_1 : ( ruleEDouble ) ;
    public final void rule__TextureVertex__YAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:2199:1: ( ( ruleEDouble ) )
            // InternalOBJ.g:2200:2: ( ruleEDouble )
            {
            // InternalOBJ.g:2200:2: ( ruleEDouble )
            // InternalOBJ.g:2201:3: ruleEDouble
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
    // InternalOBJ.g:2210:1: rule__TextureVertex__ZAssignment_2 : ( ruleEDouble ) ;
    public final void rule__TextureVertex__ZAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:2214:1: ( ( ruleEDouble ) )
            // InternalOBJ.g:2215:2: ( ruleEDouble )
            {
            // InternalOBJ.g:2215:2: ( ruleEDouble )
            // InternalOBJ.g:2216:3: ruleEDouble
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


    // $ANTLR start "rule__Material__PhongMatNameAssignment_1"
    // InternalOBJ.g:2225:1: rule__Material__PhongMatNameAssignment_1 : ( ruleEString ) ;
    public final void rule__Material__PhongMatNameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOBJ.g:2229:1: ( ( ruleEString ) )
            // InternalOBJ.g:2230:2: ( ruleEString )
            {
            // InternalOBJ.g:2230:2: ( ruleEString )
            // InternalOBJ.g:2231:3: ruleEString
            {
             before(grammarAccess.getMaterialAccess().getPhongMatNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getMaterialAccess().getPhongMatNameEStringParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__Material__PhongMatNameAssignment_1"

    // Delegated rules


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA12 dfa12 = new DFA12(this);
    static final String dfa_1s = "\51\uffff";
    static final String dfa_2s = "\1\23\2\4\2\uffff\44\4";
    static final String dfa_3s = "\1\32\1\22\1\32\2\uffff\44\32";
    static final String dfa_4s = "\3\uffff\1\1\1\2\44\uffff";
    static final String dfa_5s = "\51\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\1\2\3\3\3\4",
            "\1\5\1\6\1\7\6\uffff\1\10\1\11\1\12\1\13\1\14\1\15",
            "\1\16\1\17\1\20\6\uffff\1\21\1\22\1\23\1\24\1\25\1\26\2\uffff\3\3\3\4",
            "",
            "",
            "\1\27\1\30\1\31\6\uffff\1\32\1\33\1\34\1\35\1\36\1\37\1\1\1\2\3\3\3\4",
            "\1\27\1\30\1\31\6\uffff\1\32\1\33\1\34\1\35\1\36\1\37\1\1\1\2\3\3\3\4",
            "\1\27\1\30\1\31\6\uffff\1\32\1\33\1\34\1\35\1\36\1\37\1\1\1\2\3\3\3\4",
            "\1\27\1\30\1\31\6\uffff\1\32\1\33\1\34\1\35\1\36\1\37\1\1\1\2\3\3\3\4",
            "\1\27\1\30\1\31\6\uffff\1\32\1\33\1\34\1\35\1\36\1\37\1\1\1\2\3\3\3\4",
            "\1\27\1\30\1\31\6\uffff\1\32\1\33\1\34\1\35\1\36\1\37\1\1\1\2\3\3\3\4",
            "\1\27\1\30\1\31\6\uffff\1\32\1\33\1\34\1\35\1\36\1\37\1\1\1\2\3\3\3\4",
            "\1\27\1\30\1\31\6\uffff\1\32\1\33\1\34\1\35\1\36\1\37\1\1\1\2\3\3\3\4",
            "\1\27\1\30\1\31\6\uffff\1\32\1\33\1\34\1\35\1\36\1\37\1\1\1\2\3\3\3\4",
            "\1\40\1\41\1\42\6\uffff\1\43\1\44\1\45\1\46\1\47\1\50\2\uffff\3\3\3\4",
            "\1\40\1\41\1\42\6\uffff\1\43\1\44\1\45\1\46\1\47\1\50\2\uffff\3\3\3\4",
            "\1\40\1\41\1\42\6\uffff\1\43\1\44\1\45\1\46\1\47\1\50\2\uffff\3\3\3\4",
            "\1\40\1\41\1\42\6\uffff\1\43\1\44\1\45\1\46\1\47\1\50\2\uffff\3\3\3\4",
            "\1\40\1\41\1\42\6\uffff\1\43\1\44\1\45\1\46\1\47\1\50\2\uffff\3\3\3\4",
            "\1\40\1\41\1\42\6\uffff\1\43\1\44\1\45\1\46\1\47\1\50\2\uffff\3\3\3\4",
            "\1\40\1\41\1\42\6\uffff\1\43\1\44\1\45\1\46\1\47\1\50\2\uffff\3\3\3\4",
            "\1\40\1\41\1\42\6\uffff\1\43\1\44\1\45\1\46\1\47\1\50\2\uffff\3\3\3\4",
            "\1\40\1\41\1\42\6\uffff\1\43\1\44\1\45\1\46\1\47\1\50\2\uffff\3\3\3\4",
            "\1\27\1\30\1\31\6\uffff\1\32\1\33\1\34\1\35\1\36\1\37\1\1\1\2\3\3\3\4",
            "\1\27\1\30\1\31\6\uffff\1\32\1\33\1\34\1\35\1\36\1\37\1\1\1\2\3\3\3\4",
            "\1\27\1\30\1\31\6\uffff\1\32\1\33\1\34\1\35\1\36\1\37\1\1\1\2\3\3\3\4",
            "\1\27\1\30\1\31\6\uffff\1\32\1\33\1\34\1\35\1\36\1\37\1\1\1\2\3\3\3\4",
            "\1\27\1\30\1\31\6\uffff\1\32\1\33\1\34\1\35\1\36\1\37\1\1\1\2\3\3\3\4",
            "\1\27\1\30\1\31\6\uffff\1\32\1\33\1\34\1\35\1\36\1\37\1\1\1\2\3\3\3\4",
            "\1\27\1\30\1\31\6\uffff\1\32\1\33\1\34\1\35\1\36\1\37\1\1\1\2\3\3\3\4",
            "\1\27\1\30\1\31\6\uffff\1\32\1\33\1\34\1\35\1\36\1\37\1\1\1\2\3\3\3\4",
            "\1\27\1\30\1\31\6\uffff\1\32\1\33\1\34\1\35\1\36\1\37\1\1\1\2\3\3\3\4",
            "\1\40\1\41\1\42\6\uffff\1\43\1\44\1\45\1\46\1\47\1\50\2\uffff\3\3\3\4",
            "\1\40\1\41\1\42\6\uffff\1\43\1\44\1\45\1\46\1\47\1\50\2\uffff\3\3\3\4",
            "\1\40\1\41\1\42\6\uffff\1\43\1\44\1\45\1\46\1\47\1\50\2\uffff\3\3\3\4",
            "\1\40\1\41\1\42\6\uffff\1\43\1\44\1\45\1\46\1\47\1\50\2\uffff\3\3\3\4",
            "\1\40\1\41\1\42\6\uffff\1\43\1\44\1\45\1\46\1\47\1\50\2\uffff\3\3\3\4",
            "\1\40\1\41\1\42\6\uffff\1\43\1\44\1\45\1\46\1\47\1\50\2\uffff\3\3\3\4",
            "\1\40\1\41\1\42\6\uffff\1\43\1\44\1\45\1\46\1\47\1\50\2\uffff\3\3\3\4",
            "\1\40\1\41\1\42\6\uffff\1\43\1\44\1\45\1\46\1\47\1\50\2\uffff\3\3\3\4",
            "\1\40\1\41\1\42\6\uffff\1\43\1\44\1\45\1\46\1\47\1\50\2\uffff\3\3\3\4"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "309:1: rule__Geometry__Alternatives : ( ( ( rule__Geometry__VertexSourcesAssignment_0 ) ) | ( ( rule__Geometry__NodesAssignment_1 ) ) );";
        }
    }
    static final String dfa_7s = "\35\uffff";
    static final String dfa_8s = "\1\1\34\uffff";
    static final String dfa_9s = "\1\23\1\uffff\17\6\1\uffff\1\6\1\uffff\3\6\1\uffff\1\6\2\uffff\1\6\1\uffff";
    static final String dfa_10s = "\1\32\1\uffff\4\22\1\6\2\22\1\6\2\22\1\6\2\22\1\6\1\22\1\uffff\1\6\1\uffff\1\22\1\6\1\22\1\uffff\1\6\2\uffff\1\6\1\uffff";
    static final String dfa_11s = "\1\uffff\1\2\17\uffff\1\1\1\uffff\1\1\3\uffff\1\1\1\uffff\2\1\1\uffff\1\1";
    static final String dfa_12s = "\35\uffff}>";
    static final String[] dfa_13s = {
            "\2\1\1\2\1\3\1\4\3\1",
            "",
            "\1\7\1\5\12\uffff\1\6",
            "\1\12\1\10\12\uffff\1\11",
            "\1\15\1\13\12\uffff\1\14",
            "\1\20\1\16\12\uffff\1\17",
            "\1\7",
            "\1\20\1\16\12\uffff\1\17",
            "\1\23\1\21\12\uffff\1\22",
            "\1\12",
            "\1\23\1\21\12\uffff\1\22",
            "\1\26\1\24\12\uffff\1\25",
            "\1\15",
            "\1\26\1\24\12\uffff\1\25",
            "\1\31\1\27\12\uffff\1\30",
            "\1\20",
            "\1\31\1\27\12\uffff\1\30",
            "",
            "\1\23",
            "",
            "\1\34\1\32\12\uffff\1\33",
            "\1\26",
            "\1\34\1\32\12\uffff\1\33",
            "",
            "\1\31",
            "",
            "",
            "\1\34",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "()* loopback of 615:3: ( rule__VertexSource__Alternatives_3 )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000007F80002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000000007E072L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000F80000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000F80002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x000000000007E070L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000000400C0L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000007F80000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000000410C0L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000000000400C2L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x00000000000440C0L});

}