package org.eclipse.january.geometry.dsl.vtk.ide.contentassist.antlr.internal;

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
import org.eclipse.january.geometry.dsl.vtk.services.VTKGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalVTKParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ENDLINE", "RULE_DOUBLE", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ML_COMMENT", "RULE_ANY_OTHER", "'.'", "'/'", "'\\\\'", "':'", "'_'", "'-'", "'POLYGONS'", "'TRIANGLE_STRIPS'", "'POINTS'"
    };
    public static final int RULE_ENDLINE=4;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int RULE_DOUBLE=5;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=7;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_INT=8;
    public static final int RULE_ML_COMMENT=11;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalVTKParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalVTKParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalVTKParser.tokenNames; }
    public String getGrammarFileName() { return "InternalVTK.g"; }


    	private VTKGrammarAccess grammarAccess;

    	public void setGrammarAccess(VTKGrammarAccess grammarAccess) {
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
    // InternalVTK.g:53:1: entryRuleGeometry : ruleGeometry EOF ;
    public final void entryRuleGeometry() throws RecognitionException {
        try {
            // InternalVTK.g:54:1: ( ruleGeometry EOF )
            // InternalVTK.g:55:1: ruleGeometry EOF
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
    // InternalVTK.g:62:1: ruleGeometry : ( ( rule__Geometry__Group__0 ) ) ;
    public final void ruleGeometry() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:66:2: ( ( ( rule__Geometry__Group__0 ) ) )
            // InternalVTK.g:67:2: ( ( rule__Geometry__Group__0 ) )
            {
            // InternalVTK.g:67:2: ( ( rule__Geometry__Group__0 ) )
            // InternalVTK.g:68:3: ( rule__Geometry__Group__0 )
            {
             before(grammarAccess.getGeometryAccess().getGroup()); 
            // InternalVTK.g:69:3: ( rule__Geometry__Group__0 )
            // InternalVTK.g:69:4: rule__Geometry__Group__0
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
    // InternalVTK.g:78:1: entryRuleVertexSource : ruleVertexSource EOF ;
    public final void entryRuleVertexSource() throws RecognitionException {
        try {
            // InternalVTK.g:79:1: ( ruleVertexSource EOF )
            // InternalVTK.g:80:1: ruleVertexSource EOF
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
    // InternalVTK.g:87:1: ruleVertexSource : ( ( rule__VertexSource__Group__0 ) ) ;
    public final void ruleVertexSource() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:91:2: ( ( ( rule__VertexSource__Group__0 ) ) )
            // InternalVTK.g:92:2: ( ( rule__VertexSource__Group__0 ) )
            {
            // InternalVTK.g:92:2: ( ( rule__VertexSource__Group__0 ) )
            // InternalVTK.g:93:3: ( rule__VertexSource__Group__0 )
            {
             before(grammarAccess.getVertexSourceAccess().getGroup()); 
            // InternalVTK.g:94:3: ( rule__VertexSource__Group__0 )
            // InternalVTK.g:94:4: rule__VertexSource__Group__0
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


    // $ANTLR start "entryRuleEDouble"
    // InternalVTK.g:103:1: entryRuleEDouble : ruleEDouble EOF ;
    public final void entryRuleEDouble() throws RecognitionException {
        try {
            // InternalVTK.g:104:1: ( ruleEDouble EOF )
            // InternalVTK.g:105:1: ruleEDouble EOF
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
    // InternalVTK.g:112:1: ruleEDouble : ( ( rule__EDouble__Alternatives ) ) ;
    public final void ruleEDouble() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:116:2: ( ( ( rule__EDouble__Alternatives ) ) )
            // InternalVTK.g:117:2: ( ( rule__EDouble__Alternatives ) )
            {
            // InternalVTK.g:117:2: ( ( rule__EDouble__Alternatives ) )
            // InternalVTK.g:118:3: ( rule__EDouble__Alternatives )
            {
             before(grammarAccess.getEDoubleAccess().getAlternatives()); 
            // InternalVTK.g:119:3: ( rule__EDouble__Alternatives )
            // InternalVTK.g:119:4: rule__EDouble__Alternatives
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


    // $ANTLR start "entryRuleEInt"
    // InternalVTK.g:128:1: entryRuleEInt : ruleEInt EOF ;
    public final void entryRuleEInt() throws RecognitionException {
        try {
            // InternalVTK.g:129:1: ( ruleEInt EOF )
            // InternalVTK.g:130:1: ruleEInt EOF
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
    // InternalVTK.g:137:1: ruleEInt : ( ( rule__EInt__Group__0 ) ) ;
    public final void ruleEInt() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:141:2: ( ( ( rule__EInt__Group__0 ) ) )
            // InternalVTK.g:142:2: ( ( rule__EInt__Group__0 ) )
            {
            // InternalVTK.g:142:2: ( ( rule__EInt__Group__0 ) )
            // InternalVTK.g:143:3: ( rule__EInt__Group__0 )
            {
             before(grammarAccess.getEIntAccess().getGroup()); 
            // InternalVTK.g:144:3: ( rule__EInt__Group__0 )
            // InternalVTK.g:144:4: rule__EInt__Group__0
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
    // InternalVTK.g:153:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalVTK.g:154:1: ( ruleEString EOF )
            // InternalVTK.g:155:1: ruleEString EOF
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
    // InternalVTK.g:162:1: ruleEString : ( ( ( rule__EString__Alternatives ) ) ( ( rule__EString__Alternatives )* ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:166:2: ( ( ( ( rule__EString__Alternatives ) ) ( ( rule__EString__Alternatives )* ) ) )
            // InternalVTK.g:167:2: ( ( ( rule__EString__Alternatives ) ) ( ( rule__EString__Alternatives )* ) )
            {
            // InternalVTK.g:167:2: ( ( ( rule__EString__Alternatives ) ) ( ( rule__EString__Alternatives )* ) )
            // InternalVTK.g:168:3: ( ( rule__EString__Alternatives ) ) ( ( rule__EString__Alternatives )* )
            {
            // InternalVTK.g:168:3: ( ( rule__EString__Alternatives ) )
            // InternalVTK.g:169:4: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalVTK.g:170:4: ( rule__EString__Alternatives )
            // InternalVTK.g:170:5: rule__EString__Alternatives
            {
            pushFollow(FOLLOW_3);
            rule__EString__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEStringAccess().getAlternatives()); 

            }

            // InternalVTK.g:173:3: ( ( rule__EString__Alternatives )* )
            // InternalVTK.g:174:4: ( rule__EString__Alternatives )*
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalVTK.g:175:4: ( rule__EString__Alternatives )*
            loop1:
            do {
                int alt1=2;
                alt1 = dfa1.predict(input);
                switch (alt1) {
            	case 1 :
            	    // InternalVTK.g:175:5: rule__EString__Alternatives
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


    // $ANTLR start "entryRuleFace"
    // InternalVTK.g:185:1: entryRuleFace : ruleFace EOF ;
    public final void entryRuleFace() throws RecognitionException {
        try {
            // InternalVTK.g:186:1: ( ruleFace EOF )
            // InternalVTK.g:187:1: ruleFace EOF
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
    // InternalVTK.g:194:1: ruleFace : ( ( rule__Face__Group__0 ) ) ;
    public final void ruleFace() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:198:2: ( ( ( rule__Face__Group__0 ) ) )
            // InternalVTK.g:199:2: ( ( rule__Face__Group__0 ) )
            {
            // InternalVTK.g:199:2: ( ( rule__Face__Group__0 ) )
            // InternalVTK.g:200:3: ( rule__Face__Group__0 )
            {
             before(grammarAccess.getFaceAccess().getGroup()); 
            // InternalVTK.g:201:3: ( rule__Face__Group__0 )
            // InternalVTK.g:201:4: rule__Face__Group__0
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


    // $ANTLR start "entryRulePolyShape"
    // InternalVTK.g:210:1: entryRulePolyShape : rulePolyShape EOF ;
    public final void entryRulePolyShape() throws RecognitionException {
        try {
            // InternalVTK.g:211:1: ( rulePolyShape EOF )
            // InternalVTK.g:212:1: rulePolyShape EOF
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
    // InternalVTK.g:219:1: rulePolyShape : ( ( rule__PolyShape__Group__0 ) ) ;
    public final void rulePolyShape() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:223:2: ( ( ( rule__PolyShape__Group__0 ) ) )
            // InternalVTK.g:224:2: ( ( rule__PolyShape__Group__0 ) )
            {
            // InternalVTK.g:224:2: ( ( rule__PolyShape__Group__0 ) )
            // InternalVTK.g:225:3: ( rule__PolyShape__Group__0 )
            {
             before(grammarAccess.getPolyShapeAccess().getGroup()); 
            // InternalVTK.g:226:3: ( rule__PolyShape__Group__0 )
            // InternalVTK.g:226:4: rule__PolyShape__Group__0
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


    // $ANTLR start "entryRuleTriangleStripPolyShape"
    // InternalVTK.g:235:1: entryRuleTriangleStripPolyShape : ruleTriangleStripPolyShape EOF ;
    public final void entryRuleTriangleStripPolyShape() throws RecognitionException {
        try {
            // InternalVTK.g:236:1: ( ruleTriangleStripPolyShape EOF )
            // InternalVTK.g:237:1: ruleTriangleStripPolyShape EOF
            {
             before(grammarAccess.getTriangleStripPolyShapeRule()); 
            pushFollow(FOLLOW_1);
            ruleTriangleStripPolyShape();

            state._fsp--;

             after(grammarAccess.getTriangleStripPolyShapeRule()); 
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
    // $ANTLR end "entryRuleTriangleStripPolyShape"


    // $ANTLR start "ruleTriangleStripPolyShape"
    // InternalVTK.g:244:1: ruleTriangleStripPolyShape : ( ( rule__TriangleStripPolyShape__Group__0 ) ) ;
    public final void ruleTriangleStripPolyShape() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:248:2: ( ( ( rule__TriangleStripPolyShape__Group__0 ) ) )
            // InternalVTK.g:249:2: ( ( rule__TriangleStripPolyShape__Group__0 ) )
            {
            // InternalVTK.g:249:2: ( ( rule__TriangleStripPolyShape__Group__0 ) )
            // InternalVTK.g:250:3: ( rule__TriangleStripPolyShape__Group__0 )
            {
             before(grammarAccess.getTriangleStripPolyShapeAccess().getGroup()); 
            // InternalVTK.g:251:3: ( rule__TriangleStripPolyShape__Group__0 )
            // InternalVTK.g:251:4: rule__TriangleStripPolyShape__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TriangleStripPolyShape__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTriangleStripPolyShapeAccess().getGroup()); 

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
    // $ANTLR end "ruleTriangleStripPolyShape"


    // $ANTLR start "entryRuleVertex"
    // InternalVTK.g:260:1: entryRuleVertex : ruleVertex EOF ;
    public final void entryRuleVertex() throws RecognitionException {
        try {
            // InternalVTK.g:261:1: ( ruleVertex EOF )
            // InternalVTK.g:262:1: ruleVertex EOF
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
    // InternalVTK.g:269:1: ruleVertex : ( ( rule__Vertex__Group__0 ) ) ;
    public final void ruleVertex() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:273:2: ( ( ( rule__Vertex__Group__0 ) ) )
            // InternalVTK.g:274:2: ( ( rule__Vertex__Group__0 ) )
            {
            // InternalVTK.g:274:2: ( ( rule__Vertex__Group__0 ) )
            // InternalVTK.g:275:3: ( rule__Vertex__Group__0 )
            {
             before(grammarAccess.getVertexAccess().getGroup()); 
            // InternalVTK.g:276:3: ( rule__Vertex__Group__0 )
            // InternalVTK.g:276:4: rule__Vertex__Group__0
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


    // $ANTLR start "rule__Geometry__Alternatives_2"
    // InternalVTK.g:284:1: rule__Geometry__Alternatives_2 : ( ( RULE_ENDLINE ) | ( ( rule__Geometry__VertexSourcesAssignment_2_1 ) ) | ( ( rule__Geometry__Group_2_2__0 ) ) | ( ( rule__Geometry__Group_2_3__0 ) ) );
    public final void rule__Geometry__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:288:1: ( ( RULE_ENDLINE ) | ( ( rule__Geometry__VertexSourcesAssignment_2_1 ) ) | ( ( rule__Geometry__Group_2_2__0 ) ) | ( ( rule__Geometry__Group_2_3__0 ) ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case RULE_ENDLINE:
                {
                alt2=1;
                }
                break;
            case RULE_DOUBLE:
            case RULE_INT:
            case 18:
            case 21:
                {
                alt2=2;
                }
                break;
            case 19:
                {
                alt2=3;
                }
                break;
            case 20:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalVTK.g:289:2: ( RULE_ENDLINE )
                    {
                    // InternalVTK.g:289:2: ( RULE_ENDLINE )
                    // InternalVTK.g:290:3: RULE_ENDLINE
                    {
                     before(grammarAccess.getGeometryAccess().getENDLINETerminalRuleCall_2_0()); 
                    match(input,RULE_ENDLINE,FOLLOW_2); 
                     after(grammarAccess.getGeometryAccess().getENDLINETerminalRuleCall_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalVTK.g:295:2: ( ( rule__Geometry__VertexSourcesAssignment_2_1 ) )
                    {
                    // InternalVTK.g:295:2: ( ( rule__Geometry__VertexSourcesAssignment_2_1 ) )
                    // InternalVTK.g:296:3: ( rule__Geometry__VertexSourcesAssignment_2_1 )
                    {
                     before(grammarAccess.getGeometryAccess().getVertexSourcesAssignment_2_1()); 
                    // InternalVTK.g:297:3: ( rule__Geometry__VertexSourcesAssignment_2_1 )
                    // InternalVTK.g:297:4: rule__Geometry__VertexSourcesAssignment_2_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Geometry__VertexSourcesAssignment_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getGeometryAccess().getVertexSourcesAssignment_2_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalVTK.g:301:2: ( ( rule__Geometry__Group_2_2__0 ) )
                    {
                    // InternalVTK.g:301:2: ( ( rule__Geometry__Group_2_2__0 ) )
                    // InternalVTK.g:302:3: ( rule__Geometry__Group_2_2__0 )
                    {
                     before(grammarAccess.getGeometryAccess().getGroup_2_2()); 
                    // InternalVTK.g:303:3: ( rule__Geometry__Group_2_2__0 )
                    // InternalVTK.g:303:4: rule__Geometry__Group_2_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Geometry__Group_2_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getGeometryAccess().getGroup_2_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalVTK.g:307:2: ( ( rule__Geometry__Group_2_3__0 ) )
                    {
                    // InternalVTK.g:307:2: ( ( rule__Geometry__Group_2_3__0 ) )
                    // InternalVTK.g:308:3: ( rule__Geometry__Group_2_3__0 )
                    {
                     before(grammarAccess.getGeometryAccess().getGroup_2_3()); 
                    // InternalVTK.g:309:3: ( rule__Geometry__Group_2_3__0 )
                    // InternalVTK.g:309:4: rule__Geometry__Group_2_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Geometry__Group_2_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getGeometryAccess().getGroup_2_3()); 

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
    // $ANTLR end "rule__Geometry__Alternatives_2"


    // $ANTLR start "rule__EDouble__Alternatives"
    // InternalVTK.g:317:1: rule__EDouble__Alternatives : ( ( RULE_DOUBLE ) | ( ruleEInt ) );
    public final void rule__EDouble__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:321:1: ( ( RULE_DOUBLE ) | ( ruleEInt ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_DOUBLE) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_INT||LA3_0==18) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalVTK.g:322:2: ( RULE_DOUBLE )
                    {
                    // InternalVTK.g:322:2: ( RULE_DOUBLE )
                    // InternalVTK.g:323:3: RULE_DOUBLE
                    {
                     before(grammarAccess.getEDoubleAccess().getDOUBLETerminalRuleCall_0()); 
                    match(input,RULE_DOUBLE,FOLLOW_2); 
                     after(grammarAccess.getEDoubleAccess().getDOUBLETerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalVTK.g:328:2: ( ruleEInt )
                    {
                    // InternalVTK.g:328:2: ( ruleEInt )
                    // InternalVTK.g:329:3: ruleEInt
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


    // $ANTLR start "rule__EString__Alternatives"
    // InternalVTK.g:338:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) | ( RULE_INT ) | ( '.' ) | ( '/' ) | ( '\\\\' ) | ( ':' ) | ( '_' ) | ( '-' ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:342:1: ( ( RULE_STRING ) | ( RULE_ID ) | ( RULE_INT ) | ( '.' ) | ( '/' ) | ( '\\\\' ) | ( ':' ) | ( '_' ) | ( '-' ) )
            int alt4=9;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt4=1;
                }
                break;
            case RULE_ID:
                {
                alt4=2;
                }
                break;
            case RULE_INT:
                {
                alt4=3;
                }
                break;
            case 13:
                {
                alt4=4;
                }
                break;
            case 14:
                {
                alt4=5;
                }
                break;
            case 15:
                {
                alt4=6;
                }
                break;
            case 16:
                {
                alt4=7;
                }
                break;
            case 17:
                {
                alt4=8;
                }
                break;
            case 18:
                {
                alt4=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalVTK.g:343:2: ( RULE_STRING )
                    {
                    // InternalVTK.g:343:2: ( RULE_STRING )
                    // InternalVTK.g:344:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalVTK.g:349:2: ( RULE_ID )
                    {
                    // InternalVTK.g:349:2: ( RULE_ID )
                    // InternalVTK.g:350:3: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalVTK.g:355:2: ( RULE_INT )
                    {
                    // InternalVTK.g:355:2: ( RULE_INT )
                    // InternalVTK.g:356:3: RULE_INT
                    {
                     before(grammarAccess.getEStringAccess().getINTTerminalRuleCall_2()); 
                    match(input,RULE_INT,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getINTTerminalRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalVTK.g:361:2: ( '.' )
                    {
                    // InternalVTK.g:361:2: ( '.' )
                    // InternalVTK.g:362:3: '.'
                    {
                     before(grammarAccess.getEStringAccess().getFullStopKeyword_3()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getFullStopKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalVTK.g:367:2: ( '/' )
                    {
                    // InternalVTK.g:367:2: ( '/' )
                    // InternalVTK.g:368:3: '/'
                    {
                     before(grammarAccess.getEStringAccess().getSolidusKeyword_4()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSolidusKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalVTK.g:373:2: ( '\\\\' )
                    {
                    // InternalVTK.g:373:2: ( '\\\\' )
                    // InternalVTK.g:374:3: '\\\\'
                    {
                     before(grammarAccess.getEStringAccess().getReverseSolidusKeyword_5()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getReverseSolidusKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalVTK.g:379:2: ( ':' )
                    {
                    // InternalVTK.g:379:2: ( ':' )
                    // InternalVTK.g:380:3: ':'
                    {
                     before(grammarAccess.getEStringAccess().getColonKeyword_6()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getColonKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalVTK.g:385:2: ( '_' )
                    {
                    // InternalVTK.g:385:2: ( '_' )
                    // InternalVTK.g:386:3: '_'
                    {
                     before(grammarAccess.getEStringAccess().get_Keyword_7()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().get_Keyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalVTK.g:391:2: ( '-' )
                    {
                    // InternalVTK.g:391:2: ( '-' )
                    // InternalVTK.g:392:3: '-'
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


    // $ANTLR start "rule__Geometry__Group__0"
    // InternalVTK.g:401:1: rule__Geometry__Group__0 : rule__Geometry__Group__0__Impl rule__Geometry__Group__1 ;
    public final void rule__Geometry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:405:1: ( rule__Geometry__Group__0__Impl rule__Geometry__Group__1 )
            // InternalVTK.g:406:2: rule__Geometry__Group__0__Impl rule__Geometry__Group__1
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
    // InternalVTK.g:413:1: rule__Geometry__Group__0__Impl : ( () ) ;
    public final void rule__Geometry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:417:1: ( ( () ) )
            // InternalVTK.g:418:1: ( () )
            {
            // InternalVTK.g:418:1: ( () )
            // InternalVTK.g:419:2: ()
            {
             before(grammarAccess.getGeometryAccess().getGeometryAction_0()); 
            // InternalVTK.g:420:2: ()
            // InternalVTK.g:420:3: 
            {
            }

             after(grammarAccess.getGeometryAccess().getGeometryAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Geometry__Group__0__Impl"


    // $ANTLR start "rule__Geometry__Group__1"
    // InternalVTK.g:428:1: rule__Geometry__Group__1 : rule__Geometry__Group__1__Impl rule__Geometry__Group__2 ;
    public final void rule__Geometry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:432:1: ( rule__Geometry__Group__1__Impl rule__Geometry__Group__2 )
            // InternalVTK.g:433:2: rule__Geometry__Group__1__Impl rule__Geometry__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Geometry__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Geometry__Group__2();

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
    // InternalVTK.g:440:1: rule__Geometry__Group__1__Impl : ( ( rule__Geometry__NameAssignment_1 ) ) ;
    public final void rule__Geometry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:444:1: ( ( ( rule__Geometry__NameAssignment_1 ) ) )
            // InternalVTK.g:445:1: ( ( rule__Geometry__NameAssignment_1 ) )
            {
            // InternalVTK.g:445:1: ( ( rule__Geometry__NameAssignment_1 ) )
            // InternalVTK.g:446:2: ( rule__Geometry__NameAssignment_1 )
            {
             before(grammarAccess.getGeometryAccess().getNameAssignment_1()); 
            // InternalVTK.g:447:2: ( rule__Geometry__NameAssignment_1 )
            // InternalVTK.g:447:3: rule__Geometry__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Geometry__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getGeometryAccess().getNameAssignment_1()); 

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


    // $ANTLR start "rule__Geometry__Group__2"
    // InternalVTK.g:455:1: rule__Geometry__Group__2 : rule__Geometry__Group__2__Impl ;
    public final void rule__Geometry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:459:1: ( rule__Geometry__Group__2__Impl )
            // InternalVTK.g:460:2: rule__Geometry__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Geometry__Group__2__Impl();

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
    // $ANTLR end "rule__Geometry__Group__2"


    // $ANTLR start "rule__Geometry__Group__2__Impl"
    // InternalVTK.g:466:1: rule__Geometry__Group__2__Impl : ( ( rule__Geometry__Alternatives_2 )* ) ;
    public final void rule__Geometry__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:470:1: ( ( ( rule__Geometry__Alternatives_2 )* ) )
            // InternalVTK.g:471:1: ( ( rule__Geometry__Alternatives_2 )* )
            {
            // InternalVTK.g:471:1: ( ( rule__Geometry__Alternatives_2 )* )
            // InternalVTK.g:472:2: ( rule__Geometry__Alternatives_2 )*
            {
             before(grammarAccess.getGeometryAccess().getAlternatives_2()); 
            // InternalVTK.g:473:2: ( rule__Geometry__Alternatives_2 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=RULE_ENDLINE && LA5_0<=RULE_DOUBLE)||LA5_0==RULE_INT||(LA5_0>=18 && LA5_0<=21)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalVTK.g:473:3: rule__Geometry__Alternatives_2
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Geometry__Alternatives_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getGeometryAccess().getAlternatives_2()); 

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
    // $ANTLR end "rule__Geometry__Group__2__Impl"


    // $ANTLR start "rule__Geometry__Group_2_2__0"
    // InternalVTK.g:482:1: rule__Geometry__Group_2_2__0 : rule__Geometry__Group_2_2__0__Impl rule__Geometry__Group_2_2__1 ;
    public final void rule__Geometry__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:486:1: ( rule__Geometry__Group_2_2__0__Impl rule__Geometry__Group_2_2__1 )
            // InternalVTK.g:487:2: rule__Geometry__Group_2_2__0__Impl rule__Geometry__Group_2_2__1
            {
            pushFollow(FOLLOW_7);
            rule__Geometry__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Geometry__Group_2_2__1();

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
    // $ANTLR end "rule__Geometry__Group_2_2__0"


    // $ANTLR start "rule__Geometry__Group_2_2__0__Impl"
    // InternalVTK.g:494:1: rule__Geometry__Group_2_2__0__Impl : ( ( rule__Geometry__Group_2_2_0__0 ) ) ;
    public final void rule__Geometry__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:498:1: ( ( ( rule__Geometry__Group_2_2_0__0 ) ) )
            // InternalVTK.g:499:1: ( ( rule__Geometry__Group_2_2_0__0 ) )
            {
            // InternalVTK.g:499:1: ( ( rule__Geometry__Group_2_2_0__0 ) )
            // InternalVTK.g:500:2: ( rule__Geometry__Group_2_2_0__0 )
            {
             before(grammarAccess.getGeometryAccess().getGroup_2_2_0()); 
            // InternalVTK.g:501:2: ( rule__Geometry__Group_2_2_0__0 )
            // InternalVTK.g:501:3: rule__Geometry__Group_2_2_0__0
            {
            pushFollow(FOLLOW_2);
            rule__Geometry__Group_2_2_0__0();

            state._fsp--;


            }

             after(grammarAccess.getGeometryAccess().getGroup_2_2_0()); 

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
    // $ANTLR end "rule__Geometry__Group_2_2__0__Impl"


    // $ANTLR start "rule__Geometry__Group_2_2__1"
    // InternalVTK.g:509:1: rule__Geometry__Group_2_2__1 : rule__Geometry__Group_2_2__1__Impl ;
    public final void rule__Geometry__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:513:1: ( rule__Geometry__Group_2_2__1__Impl )
            // InternalVTK.g:514:2: rule__Geometry__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Geometry__Group_2_2__1__Impl();

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
    // $ANTLR end "rule__Geometry__Group_2_2__1"


    // $ANTLR start "rule__Geometry__Group_2_2__1__Impl"
    // InternalVTK.g:520:1: rule__Geometry__Group_2_2__1__Impl : ( ( rule__Geometry__NodesAssignment_2_2_1 )* ) ;
    public final void rule__Geometry__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:524:1: ( ( ( rule__Geometry__NodesAssignment_2_2_1 )* ) )
            // InternalVTK.g:525:1: ( ( rule__Geometry__NodesAssignment_2_2_1 )* )
            {
            // InternalVTK.g:525:1: ( ( rule__Geometry__NodesAssignment_2_2_1 )* )
            // InternalVTK.g:526:2: ( rule__Geometry__NodesAssignment_2_2_1 )*
            {
             before(grammarAccess.getGeometryAccess().getNodesAssignment_2_2_1()); 
            // InternalVTK.g:527:2: ( rule__Geometry__NodesAssignment_2_2_1 )*
            loop6:
            do {
                int alt6=2;
                alt6 = dfa6.predict(input);
                switch (alt6) {
            	case 1 :
            	    // InternalVTK.g:527:3: rule__Geometry__NodesAssignment_2_2_1
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__Geometry__NodesAssignment_2_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getGeometryAccess().getNodesAssignment_2_2_1()); 

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
    // $ANTLR end "rule__Geometry__Group_2_2__1__Impl"


    // $ANTLR start "rule__Geometry__Group_2_2_0__0"
    // InternalVTK.g:536:1: rule__Geometry__Group_2_2_0__0 : rule__Geometry__Group_2_2_0__0__Impl rule__Geometry__Group_2_2_0__1 ;
    public final void rule__Geometry__Group_2_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:540:1: ( rule__Geometry__Group_2_2_0__0__Impl rule__Geometry__Group_2_2_0__1 )
            // InternalVTK.g:541:2: rule__Geometry__Group_2_2_0__0__Impl rule__Geometry__Group_2_2_0__1
            {
            pushFollow(FOLLOW_9);
            rule__Geometry__Group_2_2_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Geometry__Group_2_2_0__1();

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
    // $ANTLR end "rule__Geometry__Group_2_2_0__0"


    // $ANTLR start "rule__Geometry__Group_2_2_0__0__Impl"
    // InternalVTK.g:548:1: rule__Geometry__Group_2_2_0__0__Impl : ( 'POLYGONS' ) ;
    public final void rule__Geometry__Group_2_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:552:1: ( ( 'POLYGONS' ) )
            // InternalVTK.g:553:1: ( 'POLYGONS' )
            {
            // InternalVTK.g:553:1: ( 'POLYGONS' )
            // InternalVTK.g:554:2: 'POLYGONS'
            {
             before(grammarAccess.getGeometryAccess().getPOLYGONSKeyword_2_2_0_0()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getGeometryAccess().getPOLYGONSKeyword_2_2_0_0()); 

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
    // $ANTLR end "rule__Geometry__Group_2_2_0__0__Impl"


    // $ANTLR start "rule__Geometry__Group_2_2_0__1"
    // InternalVTK.g:563:1: rule__Geometry__Group_2_2_0__1 : rule__Geometry__Group_2_2_0__1__Impl rule__Geometry__Group_2_2_0__2 ;
    public final void rule__Geometry__Group_2_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:567:1: ( rule__Geometry__Group_2_2_0__1__Impl rule__Geometry__Group_2_2_0__2 )
            // InternalVTK.g:568:2: rule__Geometry__Group_2_2_0__1__Impl rule__Geometry__Group_2_2_0__2
            {
            pushFollow(FOLLOW_9);
            rule__Geometry__Group_2_2_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Geometry__Group_2_2_0__2();

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
    // $ANTLR end "rule__Geometry__Group_2_2_0__1"


    // $ANTLR start "rule__Geometry__Group_2_2_0__1__Impl"
    // InternalVTK.g:575:1: rule__Geometry__Group_2_2_0__1__Impl : ( RULE_INT ) ;
    public final void rule__Geometry__Group_2_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:579:1: ( ( RULE_INT ) )
            // InternalVTK.g:580:1: ( RULE_INT )
            {
            // InternalVTK.g:580:1: ( RULE_INT )
            // InternalVTK.g:581:2: RULE_INT
            {
             before(grammarAccess.getGeometryAccess().getINTTerminalRuleCall_2_2_0_1()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getGeometryAccess().getINTTerminalRuleCall_2_2_0_1()); 

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
    // $ANTLR end "rule__Geometry__Group_2_2_0__1__Impl"


    // $ANTLR start "rule__Geometry__Group_2_2_0__2"
    // InternalVTK.g:590:1: rule__Geometry__Group_2_2_0__2 : rule__Geometry__Group_2_2_0__2__Impl rule__Geometry__Group_2_2_0__3 ;
    public final void rule__Geometry__Group_2_2_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:594:1: ( rule__Geometry__Group_2_2_0__2__Impl rule__Geometry__Group_2_2_0__3 )
            // InternalVTK.g:595:2: rule__Geometry__Group_2_2_0__2__Impl rule__Geometry__Group_2_2_0__3
            {
            pushFollow(FOLLOW_10);
            rule__Geometry__Group_2_2_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Geometry__Group_2_2_0__3();

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
    // $ANTLR end "rule__Geometry__Group_2_2_0__2"


    // $ANTLR start "rule__Geometry__Group_2_2_0__2__Impl"
    // InternalVTK.g:602:1: rule__Geometry__Group_2_2_0__2__Impl : ( RULE_INT ) ;
    public final void rule__Geometry__Group_2_2_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:606:1: ( ( RULE_INT ) )
            // InternalVTK.g:607:1: ( RULE_INT )
            {
            // InternalVTK.g:607:1: ( RULE_INT )
            // InternalVTK.g:608:2: RULE_INT
            {
             before(grammarAccess.getGeometryAccess().getINTTerminalRuleCall_2_2_0_2()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getGeometryAccess().getINTTerminalRuleCall_2_2_0_2()); 

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
    // $ANTLR end "rule__Geometry__Group_2_2_0__2__Impl"


    // $ANTLR start "rule__Geometry__Group_2_2_0__3"
    // InternalVTK.g:617:1: rule__Geometry__Group_2_2_0__3 : rule__Geometry__Group_2_2_0__3__Impl ;
    public final void rule__Geometry__Group_2_2_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:621:1: ( rule__Geometry__Group_2_2_0__3__Impl )
            // InternalVTK.g:622:2: rule__Geometry__Group_2_2_0__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Geometry__Group_2_2_0__3__Impl();

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
    // $ANTLR end "rule__Geometry__Group_2_2_0__3"


    // $ANTLR start "rule__Geometry__Group_2_2_0__3__Impl"
    // InternalVTK.g:628:1: rule__Geometry__Group_2_2_0__3__Impl : ( ( RULE_ENDLINE )? ) ;
    public final void rule__Geometry__Group_2_2_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:632:1: ( ( ( RULE_ENDLINE )? ) )
            // InternalVTK.g:633:1: ( ( RULE_ENDLINE )? )
            {
            // InternalVTK.g:633:1: ( ( RULE_ENDLINE )? )
            // InternalVTK.g:634:2: ( RULE_ENDLINE )?
            {
             before(grammarAccess.getGeometryAccess().getENDLINETerminalRuleCall_2_2_0_3()); 
            // InternalVTK.g:635:2: ( RULE_ENDLINE )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ENDLINE) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalVTK.g:635:3: RULE_ENDLINE
                    {
                    match(input,RULE_ENDLINE,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getGeometryAccess().getENDLINETerminalRuleCall_2_2_0_3()); 

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
    // $ANTLR end "rule__Geometry__Group_2_2_0__3__Impl"


    // $ANTLR start "rule__Geometry__Group_2_3__0"
    // InternalVTK.g:644:1: rule__Geometry__Group_2_3__0 : rule__Geometry__Group_2_3__0__Impl rule__Geometry__Group_2_3__1 ;
    public final void rule__Geometry__Group_2_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:648:1: ( rule__Geometry__Group_2_3__0__Impl rule__Geometry__Group_2_3__1 )
            // InternalVTK.g:649:2: rule__Geometry__Group_2_3__0__Impl rule__Geometry__Group_2_3__1
            {
            pushFollow(FOLLOW_7);
            rule__Geometry__Group_2_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Geometry__Group_2_3__1();

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
    // $ANTLR end "rule__Geometry__Group_2_3__0"


    // $ANTLR start "rule__Geometry__Group_2_3__0__Impl"
    // InternalVTK.g:656:1: rule__Geometry__Group_2_3__0__Impl : ( ( rule__Geometry__Group_2_3_0__0 ) ) ;
    public final void rule__Geometry__Group_2_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:660:1: ( ( ( rule__Geometry__Group_2_3_0__0 ) ) )
            // InternalVTK.g:661:1: ( ( rule__Geometry__Group_2_3_0__0 ) )
            {
            // InternalVTK.g:661:1: ( ( rule__Geometry__Group_2_3_0__0 ) )
            // InternalVTK.g:662:2: ( rule__Geometry__Group_2_3_0__0 )
            {
             before(grammarAccess.getGeometryAccess().getGroup_2_3_0()); 
            // InternalVTK.g:663:2: ( rule__Geometry__Group_2_3_0__0 )
            // InternalVTK.g:663:3: rule__Geometry__Group_2_3_0__0
            {
            pushFollow(FOLLOW_2);
            rule__Geometry__Group_2_3_0__0();

            state._fsp--;


            }

             after(grammarAccess.getGeometryAccess().getGroup_2_3_0()); 

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
    // $ANTLR end "rule__Geometry__Group_2_3__0__Impl"


    // $ANTLR start "rule__Geometry__Group_2_3__1"
    // InternalVTK.g:671:1: rule__Geometry__Group_2_3__1 : rule__Geometry__Group_2_3__1__Impl ;
    public final void rule__Geometry__Group_2_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:675:1: ( rule__Geometry__Group_2_3__1__Impl )
            // InternalVTK.g:676:2: rule__Geometry__Group_2_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Geometry__Group_2_3__1__Impl();

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
    // $ANTLR end "rule__Geometry__Group_2_3__1"


    // $ANTLR start "rule__Geometry__Group_2_3__1__Impl"
    // InternalVTK.g:682:1: rule__Geometry__Group_2_3__1__Impl : ( ( rule__Geometry__NodesAssignment_2_3_1 )* ) ;
    public final void rule__Geometry__Group_2_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:686:1: ( ( ( rule__Geometry__NodesAssignment_2_3_1 )* ) )
            // InternalVTK.g:687:1: ( ( rule__Geometry__NodesAssignment_2_3_1 )* )
            {
            // InternalVTK.g:687:1: ( ( rule__Geometry__NodesAssignment_2_3_1 )* )
            // InternalVTK.g:688:2: ( rule__Geometry__NodesAssignment_2_3_1 )*
            {
             before(grammarAccess.getGeometryAccess().getNodesAssignment_2_3_1()); 
            // InternalVTK.g:689:2: ( rule__Geometry__NodesAssignment_2_3_1 )*
            loop8:
            do {
                int alt8=2;
                alt8 = dfa8.predict(input);
                switch (alt8) {
            	case 1 :
            	    // InternalVTK.g:689:3: rule__Geometry__NodesAssignment_2_3_1
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__Geometry__NodesAssignment_2_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getGeometryAccess().getNodesAssignment_2_3_1()); 

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
    // $ANTLR end "rule__Geometry__Group_2_3__1__Impl"


    // $ANTLR start "rule__Geometry__Group_2_3_0__0"
    // InternalVTK.g:698:1: rule__Geometry__Group_2_3_0__0 : rule__Geometry__Group_2_3_0__0__Impl rule__Geometry__Group_2_3_0__1 ;
    public final void rule__Geometry__Group_2_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:702:1: ( rule__Geometry__Group_2_3_0__0__Impl rule__Geometry__Group_2_3_0__1 )
            // InternalVTK.g:703:2: rule__Geometry__Group_2_3_0__0__Impl rule__Geometry__Group_2_3_0__1
            {
            pushFollow(FOLLOW_9);
            rule__Geometry__Group_2_3_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Geometry__Group_2_3_0__1();

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
    // $ANTLR end "rule__Geometry__Group_2_3_0__0"


    // $ANTLR start "rule__Geometry__Group_2_3_0__0__Impl"
    // InternalVTK.g:710:1: rule__Geometry__Group_2_3_0__0__Impl : ( 'TRIANGLE_STRIPS' ) ;
    public final void rule__Geometry__Group_2_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:714:1: ( ( 'TRIANGLE_STRIPS' ) )
            // InternalVTK.g:715:1: ( 'TRIANGLE_STRIPS' )
            {
            // InternalVTK.g:715:1: ( 'TRIANGLE_STRIPS' )
            // InternalVTK.g:716:2: 'TRIANGLE_STRIPS'
            {
             before(grammarAccess.getGeometryAccess().getTRIANGLE_STRIPSKeyword_2_3_0_0()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getGeometryAccess().getTRIANGLE_STRIPSKeyword_2_3_0_0()); 

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
    // $ANTLR end "rule__Geometry__Group_2_3_0__0__Impl"


    // $ANTLR start "rule__Geometry__Group_2_3_0__1"
    // InternalVTK.g:725:1: rule__Geometry__Group_2_3_0__1 : rule__Geometry__Group_2_3_0__1__Impl rule__Geometry__Group_2_3_0__2 ;
    public final void rule__Geometry__Group_2_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:729:1: ( rule__Geometry__Group_2_3_0__1__Impl rule__Geometry__Group_2_3_0__2 )
            // InternalVTK.g:730:2: rule__Geometry__Group_2_3_0__1__Impl rule__Geometry__Group_2_3_0__2
            {
            pushFollow(FOLLOW_9);
            rule__Geometry__Group_2_3_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Geometry__Group_2_3_0__2();

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
    // $ANTLR end "rule__Geometry__Group_2_3_0__1"


    // $ANTLR start "rule__Geometry__Group_2_3_0__1__Impl"
    // InternalVTK.g:737:1: rule__Geometry__Group_2_3_0__1__Impl : ( RULE_INT ) ;
    public final void rule__Geometry__Group_2_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:741:1: ( ( RULE_INT ) )
            // InternalVTK.g:742:1: ( RULE_INT )
            {
            // InternalVTK.g:742:1: ( RULE_INT )
            // InternalVTK.g:743:2: RULE_INT
            {
             before(grammarAccess.getGeometryAccess().getINTTerminalRuleCall_2_3_0_1()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getGeometryAccess().getINTTerminalRuleCall_2_3_0_1()); 

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
    // $ANTLR end "rule__Geometry__Group_2_3_0__1__Impl"


    // $ANTLR start "rule__Geometry__Group_2_3_0__2"
    // InternalVTK.g:752:1: rule__Geometry__Group_2_3_0__2 : rule__Geometry__Group_2_3_0__2__Impl rule__Geometry__Group_2_3_0__3 ;
    public final void rule__Geometry__Group_2_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:756:1: ( rule__Geometry__Group_2_3_0__2__Impl rule__Geometry__Group_2_3_0__3 )
            // InternalVTK.g:757:2: rule__Geometry__Group_2_3_0__2__Impl rule__Geometry__Group_2_3_0__3
            {
            pushFollow(FOLLOW_10);
            rule__Geometry__Group_2_3_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Geometry__Group_2_3_0__3();

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
    // $ANTLR end "rule__Geometry__Group_2_3_0__2"


    // $ANTLR start "rule__Geometry__Group_2_3_0__2__Impl"
    // InternalVTK.g:764:1: rule__Geometry__Group_2_3_0__2__Impl : ( RULE_INT ) ;
    public final void rule__Geometry__Group_2_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:768:1: ( ( RULE_INT ) )
            // InternalVTK.g:769:1: ( RULE_INT )
            {
            // InternalVTK.g:769:1: ( RULE_INT )
            // InternalVTK.g:770:2: RULE_INT
            {
             before(grammarAccess.getGeometryAccess().getINTTerminalRuleCall_2_3_0_2()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getGeometryAccess().getINTTerminalRuleCall_2_3_0_2()); 

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
    // $ANTLR end "rule__Geometry__Group_2_3_0__2__Impl"


    // $ANTLR start "rule__Geometry__Group_2_3_0__3"
    // InternalVTK.g:779:1: rule__Geometry__Group_2_3_0__3 : rule__Geometry__Group_2_3_0__3__Impl ;
    public final void rule__Geometry__Group_2_3_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:783:1: ( rule__Geometry__Group_2_3_0__3__Impl )
            // InternalVTK.g:784:2: rule__Geometry__Group_2_3_0__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Geometry__Group_2_3_0__3__Impl();

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
    // $ANTLR end "rule__Geometry__Group_2_3_0__3"


    // $ANTLR start "rule__Geometry__Group_2_3_0__3__Impl"
    // InternalVTK.g:790:1: rule__Geometry__Group_2_3_0__3__Impl : ( ( RULE_ENDLINE )? ) ;
    public final void rule__Geometry__Group_2_3_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:794:1: ( ( ( RULE_ENDLINE )? ) )
            // InternalVTK.g:795:1: ( ( RULE_ENDLINE )? )
            {
            // InternalVTK.g:795:1: ( ( RULE_ENDLINE )? )
            // InternalVTK.g:796:2: ( RULE_ENDLINE )?
            {
             before(grammarAccess.getGeometryAccess().getENDLINETerminalRuleCall_2_3_0_3()); 
            // InternalVTK.g:797:2: ( RULE_ENDLINE )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ENDLINE) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalVTK.g:797:3: RULE_ENDLINE
                    {
                    match(input,RULE_ENDLINE,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getGeometryAccess().getENDLINETerminalRuleCall_2_3_0_3()); 

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
    // $ANTLR end "rule__Geometry__Group_2_3_0__3__Impl"


    // $ANTLR start "rule__VertexSource__Group__0"
    // InternalVTK.g:806:1: rule__VertexSource__Group__0 : rule__VertexSource__Group__0__Impl rule__VertexSource__Group__1 ;
    public final void rule__VertexSource__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:810:1: ( rule__VertexSource__Group__0__Impl rule__VertexSource__Group__1 )
            // InternalVTK.g:811:2: rule__VertexSource__Group__0__Impl rule__VertexSource__Group__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalVTK.g:818:1: rule__VertexSource__Group__0__Impl : ( () ) ;
    public final void rule__VertexSource__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:822:1: ( ( () ) )
            // InternalVTK.g:823:1: ( () )
            {
            // InternalVTK.g:823:1: ( () )
            // InternalVTK.g:824:2: ()
            {
             before(grammarAccess.getVertexSourceAccess().getVertexSourceAction_0()); 
            // InternalVTK.g:825:2: ()
            // InternalVTK.g:825:3: 
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
    // InternalVTK.g:833:1: rule__VertexSource__Group__1 : rule__VertexSource__Group__1__Impl rule__VertexSource__Group__2 ;
    public final void rule__VertexSource__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:837:1: ( rule__VertexSource__Group__1__Impl rule__VertexSource__Group__2 )
            // InternalVTK.g:838:2: rule__VertexSource__Group__1__Impl rule__VertexSource__Group__2
            {
            pushFollow(FOLLOW_7);
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
    // InternalVTK.g:845:1: rule__VertexSource__Group__1__Impl : ( ( rule__VertexSource__Group_1__0 )? ) ;
    public final void rule__VertexSource__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:849:1: ( ( ( rule__VertexSource__Group_1__0 )? ) )
            // InternalVTK.g:850:1: ( ( rule__VertexSource__Group_1__0 )? )
            {
            // InternalVTK.g:850:1: ( ( rule__VertexSource__Group_1__0 )? )
            // InternalVTK.g:851:2: ( rule__VertexSource__Group_1__0 )?
            {
             before(grammarAccess.getVertexSourceAccess().getGroup_1()); 
            // InternalVTK.g:852:2: ( rule__VertexSource__Group_1__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalVTK.g:852:3: rule__VertexSource__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__VertexSource__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

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
    // InternalVTK.g:860:1: rule__VertexSource__Group__2 : rule__VertexSource__Group__2__Impl ;
    public final void rule__VertexSource__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:864:1: ( rule__VertexSource__Group__2__Impl )
            // InternalVTK.g:865:2: rule__VertexSource__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VertexSource__Group__2__Impl();

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
    // InternalVTK.g:871:1: rule__VertexSource__Group__2__Impl : ( ( ( rule__VertexSource__VerticesAssignment_2 ) ) ( ( rule__VertexSource__VerticesAssignment_2 )* ) ) ;
    public final void rule__VertexSource__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:875:1: ( ( ( ( rule__VertexSource__VerticesAssignment_2 ) ) ( ( rule__VertexSource__VerticesAssignment_2 )* ) ) )
            // InternalVTK.g:876:1: ( ( ( rule__VertexSource__VerticesAssignment_2 ) ) ( ( rule__VertexSource__VerticesAssignment_2 )* ) )
            {
            // InternalVTK.g:876:1: ( ( ( rule__VertexSource__VerticesAssignment_2 ) ) ( ( rule__VertexSource__VerticesAssignment_2 )* ) )
            // InternalVTK.g:877:2: ( ( rule__VertexSource__VerticesAssignment_2 ) ) ( ( rule__VertexSource__VerticesAssignment_2 )* )
            {
            // InternalVTK.g:877:2: ( ( rule__VertexSource__VerticesAssignment_2 ) )
            // InternalVTK.g:878:3: ( rule__VertexSource__VerticesAssignment_2 )
            {
             before(grammarAccess.getVertexSourceAccess().getVerticesAssignment_2()); 
            // InternalVTK.g:879:3: ( rule__VertexSource__VerticesAssignment_2 )
            // InternalVTK.g:879:4: rule__VertexSource__VerticesAssignment_2
            {
            pushFollow(FOLLOW_8);
            rule__VertexSource__VerticesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getVertexSourceAccess().getVerticesAssignment_2()); 

            }

            // InternalVTK.g:882:2: ( ( rule__VertexSource__VerticesAssignment_2 )* )
            // InternalVTK.g:883:3: ( rule__VertexSource__VerticesAssignment_2 )*
            {
             before(grammarAccess.getVertexSourceAccess().getVerticesAssignment_2()); 
            // InternalVTK.g:884:3: ( rule__VertexSource__VerticesAssignment_2 )*
            loop11:
            do {
                int alt11=2;
                alt11 = dfa11.predict(input);
                switch (alt11) {
            	case 1 :
            	    // InternalVTK.g:884:4: rule__VertexSource__VerticesAssignment_2
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__VertexSource__VerticesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getVertexSourceAccess().getVerticesAssignment_2()); 

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
    // $ANTLR end "rule__VertexSource__Group__2__Impl"


    // $ANTLR start "rule__VertexSource__Group_1__0"
    // InternalVTK.g:894:1: rule__VertexSource__Group_1__0 : rule__VertexSource__Group_1__0__Impl rule__VertexSource__Group_1__1 ;
    public final void rule__VertexSource__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:898:1: ( rule__VertexSource__Group_1__0__Impl rule__VertexSource__Group_1__1 )
            // InternalVTK.g:899:2: rule__VertexSource__Group_1__0__Impl rule__VertexSource__Group_1__1
            {
            pushFollow(FOLLOW_11);
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
    // InternalVTK.g:906:1: rule__VertexSource__Group_1__0__Impl : ( 'POINTS' ) ;
    public final void rule__VertexSource__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:910:1: ( ( 'POINTS' ) )
            // InternalVTK.g:911:1: ( 'POINTS' )
            {
            // InternalVTK.g:911:1: ( 'POINTS' )
            // InternalVTK.g:912:2: 'POINTS'
            {
             before(grammarAccess.getVertexSourceAccess().getPOINTSKeyword_1_0()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getVertexSourceAccess().getPOINTSKeyword_1_0()); 

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
    // InternalVTK.g:921:1: rule__VertexSource__Group_1__1 : rule__VertexSource__Group_1__1__Impl rule__VertexSource__Group_1__2 ;
    public final void rule__VertexSource__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:925:1: ( rule__VertexSource__Group_1__1__Impl rule__VertexSource__Group_1__2 )
            // InternalVTK.g:926:2: rule__VertexSource__Group_1__1__Impl rule__VertexSource__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__VertexSource__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VertexSource__Group_1__2();

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
    // InternalVTK.g:933:1: rule__VertexSource__Group_1__1__Impl : ( ( ruleEString )? ) ;
    public final void rule__VertexSource__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:937:1: ( ( ( ruleEString )? ) )
            // InternalVTK.g:938:1: ( ( ruleEString )? )
            {
            // InternalVTK.g:938:1: ( ( ruleEString )? )
            // InternalVTK.g:939:2: ( ruleEString )?
            {
             before(grammarAccess.getVertexSourceAccess().getEStringParserRuleCall_1_1()); 
            // InternalVTK.g:940:2: ( ruleEString )?
            int alt12=2;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // InternalVTK.g:940:3: ruleEString
                    {
                    pushFollow(FOLLOW_2);
                    ruleEString();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVertexSourceAccess().getEStringParserRuleCall_1_1()); 

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


    // $ANTLR start "rule__VertexSource__Group_1__2"
    // InternalVTK.g:948:1: rule__VertexSource__Group_1__2 : rule__VertexSource__Group_1__2__Impl ;
    public final void rule__VertexSource__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:952:1: ( rule__VertexSource__Group_1__2__Impl )
            // InternalVTK.g:953:2: rule__VertexSource__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VertexSource__Group_1__2__Impl();

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
    // $ANTLR end "rule__VertexSource__Group_1__2"


    // $ANTLR start "rule__VertexSource__Group_1__2__Impl"
    // InternalVTK.g:959:1: rule__VertexSource__Group_1__2__Impl : ( ( RULE_ENDLINE )? ) ;
    public final void rule__VertexSource__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:963:1: ( ( ( RULE_ENDLINE )? ) )
            // InternalVTK.g:964:1: ( ( RULE_ENDLINE )? )
            {
            // InternalVTK.g:964:1: ( ( RULE_ENDLINE )? )
            // InternalVTK.g:965:2: ( RULE_ENDLINE )?
            {
             before(grammarAccess.getVertexSourceAccess().getENDLINETerminalRuleCall_1_2()); 
            // InternalVTK.g:966:2: ( RULE_ENDLINE )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ENDLINE) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalVTK.g:966:3: RULE_ENDLINE
                    {
                    match(input,RULE_ENDLINE,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getVertexSourceAccess().getENDLINETerminalRuleCall_1_2()); 

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
    // $ANTLR end "rule__VertexSource__Group_1__2__Impl"


    // $ANTLR start "rule__EInt__Group__0"
    // InternalVTK.g:975:1: rule__EInt__Group__0 : rule__EInt__Group__0__Impl rule__EInt__Group__1 ;
    public final void rule__EInt__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:979:1: ( rule__EInt__Group__0__Impl rule__EInt__Group__1 )
            // InternalVTK.g:980:2: rule__EInt__Group__0__Impl rule__EInt__Group__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalVTK.g:987:1: rule__EInt__Group__0__Impl : ( ( '-' )? ) ;
    public final void rule__EInt__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:991:1: ( ( ( '-' )? ) )
            // InternalVTK.g:992:1: ( ( '-' )? )
            {
            // InternalVTK.g:992:1: ( ( '-' )? )
            // InternalVTK.g:993:2: ( '-' )?
            {
             before(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
            // InternalVTK.g:994:2: ( '-' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==18) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalVTK.g:994:3: '-'
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
    // InternalVTK.g:1002:1: rule__EInt__Group__1 : rule__EInt__Group__1__Impl ;
    public final void rule__EInt__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1006:1: ( rule__EInt__Group__1__Impl )
            // InternalVTK.g:1007:2: rule__EInt__Group__1__Impl
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
    // InternalVTK.g:1013:1: rule__EInt__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__EInt__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1017:1: ( ( RULE_INT ) )
            // InternalVTK.g:1018:1: ( RULE_INT )
            {
            // InternalVTK.g:1018:1: ( RULE_INT )
            // InternalVTK.g:1019:2: RULE_INT
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


    // $ANTLR start "rule__Face__Group__0"
    // InternalVTK.g:1029:1: rule__Face__Group__0 : rule__Face__Group__0__Impl rule__Face__Group__1 ;
    public final void rule__Face__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1033:1: ( rule__Face__Group__0__Impl rule__Face__Group__1 )
            // InternalVTK.g:1034:2: rule__Face__Group__0__Impl rule__Face__Group__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalVTK.g:1041:1: rule__Face__Group__0__Impl : ( () ) ;
    public final void rule__Face__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1045:1: ( ( () ) )
            // InternalVTK.g:1046:1: ( () )
            {
            // InternalVTK.g:1046:1: ( () )
            // InternalVTK.g:1047:2: ()
            {
             before(grammarAccess.getFaceAccess().getFaceAction_0()); 
            // InternalVTK.g:1048:2: ()
            // InternalVTK.g:1048:3: 
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
    // InternalVTK.g:1056:1: rule__Face__Group__1 : rule__Face__Group__1__Impl rule__Face__Group__2 ;
    public final void rule__Face__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1060:1: ( rule__Face__Group__1__Impl rule__Face__Group__2 )
            // InternalVTK.g:1061:2: rule__Face__Group__1__Impl rule__Face__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__Face__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Face__Group__2();

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
    // InternalVTK.g:1068:1: rule__Face__Group__1__Impl : ( ruleEInt ) ;
    public final void rule__Face__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1072:1: ( ( ruleEInt ) )
            // InternalVTK.g:1073:1: ( ruleEInt )
            {
            // InternalVTK.g:1073:1: ( ruleEInt )
            // InternalVTK.g:1074:2: ruleEInt
            {
             before(grammarAccess.getFaceAccess().getEIntParserRuleCall_1()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getFaceAccess().getEIntParserRuleCall_1()); 

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


    // $ANTLR start "rule__Face__Group__2"
    // InternalVTK.g:1083:1: rule__Face__Group__2 : rule__Face__Group__2__Impl rule__Face__Group__3 ;
    public final void rule__Face__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1087:1: ( rule__Face__Group__2__Impl rule__Face__Group__3 )
            // InternalVTK.g:1088:2: rule__Face__Group__2__Impl rule__Face__Group__3
            {
            pushFollow(FOLLOW_10);
            rule__Face__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Face__Group__3();

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
    // $ANTLR end "rule__Face__Group__2"


    // $ANTLR start "rule__Face__Group__2__Impl"
    // InternalVTK.g:1095:1: rule__Face__Group__2__Impl : ( ( ( rule__Face__VertexIndicesAssignment_2 ) ) ( ( rule__Face__VertexIndicesAssignment_2 )* ) ) ;
    public final void rule__Face__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1099:1: ( ( ( ( rule__Face__VertexIndicesAssignment_2 ) ) ( ( rule__Face__VertexIndicesAssignment_2 )* ) ) )
            // InternalVTK.g:1100:1: ( ( ( rule__Face__VertexIndicesAssignment_2 ) ) ( ( rule__Face__VertexIndicesAssignment_2 )* ) )
            {
            // InternalVTK.g:1100:1: ( ( ( rule__Face__VertexIndicesAssignment_2 ) ) ( ( rule__Face__VertexIndicesAssignment_2 )* ) )
            // InternalVTK.g:1101:2: ( ( rule__Face__VertexIndicesAssignment_2 ) ) ( ( rule__Face__VertexIndicesAssignment_2 )* )
            {
            // InternalVTK.g:1101:2: ( ( rule__Face__VertexIndicesAssignment_2 ) )
            // InternalVTK.g:1102:3: ( rule__Face__VertexIndicesAssignment_2 )
            {
             before(grammarAccess.getFaceAccess().getVertexIndicesAssignment_2()); 
            // InternalVTK.g:1103:3: ( rule__Face__VertexIndicesAssignment_2 )
            // InternalVTK.g:1103:4: rule__Face__VertexIndicesAssignment_2
            {
            pushFollow(FOLLOW_8);
            rule__Face__VertexIndicesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getFaceAccess().getVertexIndicesAssignment_2()); 

            }

            // InternalVTK.g:1106:2: ( ( rule__Face__VertexIndicesAssignment_2 )* )
            // InternalVTK.g:1107:3: ( rule__Face__VertexIndicesAssignment_2 )*
            {
             before(grammarAccess.getFaceAccess().getVertexIndicesAssignment_2()); 
            // InternalVTK.g:1108:3: ( rule__Face__VertexIndicesAssignment_2 )*
            loop15:
            do {
                int alt15=2;
                alt15 = dfa15.predict(input);
                switch (alt15) {
            	case 1 :
            	    // InternalVTK.g:1108:4: rule__Face__VertexIndicesAssignment_2
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__Face__VertexIndicesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getFaceAccess().getVertexIndicesAssignment_2()); 

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
    // $ANTLR end "rule__Face__Group__2__Impl"


    // $ANTLR start "rule__Face__Group__3"
    // InternalVTK.g:1117:1: rule__Face__Group__3 : rule__Face__Group__3__Impl ;
    public final void rule__Face__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1121:1: ( rule__Face__Group__3__Impl )
            // InternalVTK.g:1122:2: rule__Face__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Face__Group__3__Impl();

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
    // $ANTLR end "rule__Face__Group__3"


    // $ANTLR start "rule__Face__Group__3__Impl"
    // InternalVTK.g:1128:1: rule__Face__Group__3__Impl : ( ( RULE_ENDLINE )? ) ;
    public final void rule__Face__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1132:1: ( ( ( RULE_ENDLINE )? ) )
            // InternalVTK.g:1133:1: ( ( RULE_ENDLINE )? )
            {
            // InternalVTK.g:1133:1: ( ( RULE_ENDLINE )? )
            // InternalVTK.g:1134:2: ( RULE_ENDLINE )?
            {
             before(grammarAccess.getFaceAccess().getENDLINETerminalRuleCall_3()); 
            // InternalVTK.g:1135:2: ( RULE_ENDLINE )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ENDLINE) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalVTK.g:1135:3: RULE_ENDLINE
                    {
                    match(input,RULE_ENDLINE,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getFaceAccess().getENDLINETerminalRuleCall_3()); 

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
    // $ANTLR end "rule__Face__Group__3__Impl"


    // $ANTLR start "rule__PolyShape__Group__0"
    // InternalVTK.g:1144:1: rule__PolyShape__Group__0 : rule__PolyShape__Group__0__Impl rule__PolyShape__Group__1 ;
    public final void rule__PolyShape__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1148:1: ( rule__PolyShape__Group__0__Impl rule__PolyShape__Group__1 )
            // InternalVTK.g:1149:2: rule__PolyShape__Group__0__Impl rule__PolyShape__Group__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalVTK.g:1156:1: rule__PolyShape__Group__0__Impl : ( () ) ;
    public final void rule__PolyShape__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1160:1: ( ( () ) )
            // InternalVTK.g:1161:1: ( () )
            {
            // InternalVTK.g:1161:1: ( () )
            // InternalVTK.g:1162:2: ()
            {
             before(grammarAccess.getPolyShapeAccess().getPolyShapeAction_0()); 
            // InternalVTK.g:1163:2: ()
            // InternalVTK.g:1163:3: 
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
    // InternalVTK.g:1171:1: rule__PolyShape__Group__1 : rule__PolyShape__Group__1__Impl ;
    public final void rule__PolyShape__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1175:1: ( rule__PolyShape__Group__1__Impl )
            // InternalVTK.g:1176:2: rule__PolyShape__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PolyShape__Group__1__Impl();

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
    // InternalVTK.g:1182:1: rule__PolyShape__Group__1__Impl : ( ( ( rule__PolyShape__FacesAssignment_1 ) ) ( ( rule__PolyShape__FacesAssignment_1 )* ) ) ;
    public final void rule__PolyShape__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1186:1: ( ( ( ( rule__PolyShape__FacesAssignment_1 ) ) ( ( rule__PolyShape__FacesAssignment_1 )* ) ) )
            // InternalVTK.g:1187:1: ( ( ( rule__PolyShape__FacesAssignment_1 ) ) ( ( rule__PolyShape__FacesAssignment_1 )* ) )
            {
            // InternalVTK.g:1187:1: ( ( ( rule__PolyShape__FacesAssignment_1 ) ) ( ( rule__PolyShape__FacesAssignment_1 )* ) )
            // InternalVTK.g:1188:2: ( ( rule__PolyShape__FacesAssignment_1 ) ) ( ( rule__PolyShape__FacesAssignment_1 )* )
            {
            // InternalVTK.g:1188:2: ( ( rule__PolyShape__FacesAssignment_1 ) )
            // InternalVTK.g:1189:3: ( rule__PolyShape__FacesAssignment_1 )
            {
             before(grammarAccess.getPolyShapeAccess().getFacesAssignment_1()); 
            // InternalVTK.g:1190:3: ( rule__PolyShape__FacesAssignment_1 )
            // InternalVTK.g:1190:4: rule__PolyShape__FacesAssignment_1
            {
            pushFollow(FOLLOW_8);
            rule__PolyShape__FacesAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPolyShapeAccess().getFacesAssignment_1()); 

            }

            // InternalVTK.g:1193:2: ( ( rule__PolyShape__FacesAssignment_1 )* )
            // InternalVTK.g:1194:3: ( rule__PolyShape__FacesAssignment_1 )*
            {
             before(grammarAccess.getPolyShapeAccess().getFacesAssignment_1()); 
            // InternalVTK.g:1195:3: ( rule__PolyShape__FacesAssignment_1 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==18) ) {
                    int LA17_2 = input.LA(2);

                    if ( (LA17_2==RULE_INT) ) {
                        int LA17_3 = input.LA(3);

                        if ( (LA17_3==18) ) {
                            int LA17_4 = input.LA(4);

                            if ( (LA17_4==RULE_INT) ) {
                                alt17=1;
                            }


                        }
                        else if ( (LA17_3==RULE_INT) ) {
                            alt17=1;
                        }


                    }


                }
                else if ( (LA17_0==RULE_INT) ) {
                    int LA17_3 = input.LA(2);

                    if ( (LA17_3==18) ) {
                        int LA17_4 = input.LA(3);

                        if ( (LA17_4==RULE_INT) ) {
                            alt17=1;
                        }


                    }
                    else if ( (LA17_3==RULE_INT) ) {
                        alt17=1;
                    }


                }


                switch (alt17) {
            	case 1 :
            	    // InternalVTK.g:1195:4: rule__PolyShape__FacesAssignment_1
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__PolyShape__FacesAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getPolyShapeAccess().getFacesAssignment_1()); 

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
    // $ANTLR end "rule__PolyShape__Group__1__Impl"


    // $ANTLR start "rule__TriangleStripPolyShape__Group__0"
    // InternalVTK.g:1205:1: rule__TriangleStripPolyShape__Group__0 : rule__TriangleStripPolyShape__Group__0__Impl rule__TriangleStripPolyShape__Group__1 ;
    public final void rule__TriangleStripPolyShape__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1209:1: ( rule__TriangleStripPolyShape__Group__0__Impl rule__TriangleStripPolyShape__Group__1 )
            // InternalVTK.g:1210:2: rule__TriangleStripPolyShape__Group__0__Impl rule__TriangleStripPolyShape__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__TriangleStripPolyShape__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TriangleStripPolyShape__Group__1();

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
    // $ANTLR end "rule__TriangleStripPolyShape__Group__0"


    // $ANTLR start "rule__TriangleStripPolyShape__Group__0__Impl"
    // InternalVTK.g:1217:1: rule__TriangleStripPolyShape__Group__0__Impl : ( () ) ;
    public final void rule__TriangleStripPolyShape__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1221:1: ( ( () ) )
            // InternalVTK.g:1222:1: ( () )
            {
            // InternalVTK.g:1222:1: ( () )
            // InternalVTK.g:1223:2: ()
            {
             before(grammarAccess.getTriangleStripPolyShapeAccess().getTriangleStripPolyShapeAction_0()); 
            // InternalVTK.g:1224:2: ()
            // InternalVTK.g:1224:3: 
            {
            }

             after(grammarAccess.getTriangleStripPolyShapeAccess().getTriangleStripPolyShapeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TriangleStripPolyShape__Group__0__Impl"


    // $ANTLR start "rule__TriangleStripPolyShape__Group__1"
    // InternalVTK.g:1232:1: rule__TriangleStripPolyShape__Group__1 : rule__TriangleStripPolyShape__Group__1__Impl ;
    public final void rule__TriangleStripPolyShape__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1236:1: ( rule__TriangleStripPolyShape__Group__1__Impl )
            // InternalVTK.g:1237:2: rule__TriangleStripPolyShape__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TriangleStripPolyShape__Group__1__Impl();

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
    // $ANTLR end "rule__TriangleStripPolyShape__Group__1"


    // $ANTLR start "rule__TriangleStripPolyShape__Group__1__Impl"
    // InternalVTK.g:1243:1: rule__TriangleStripPolyShape__Group__1__Impl : ( ( ( rule__TriangleStripPolyShape__FacesAssignment_1 ) ) ( ( rule__TriangleStripPolyShape__FacesAssignment_1 )* ) ) ;
    public final void rule__TriangleStripPolyShape__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1247:1: ( ( ( ( rule__TriangleStripPolyShape__FacesAssignment_1 ) ) ( ( rule__TriangleStripPolyShape__FacesAssignment_1 )* ) ) )
            // InternalVTK.g:1248:1: ( ( ( rule__TriangleStripPolyShape__FacesAssignment_1 ) ) ( ( rule__TriangleStripPolyShape__FacesAssignment_1 )* ) )
            {
            // InternalVTK.g:1248:1: ( ( ( rule__TriangleStripPolyShape__FacesAssignment_1 ) ) ( ( rule__TriangleStripPolyShape__FacesAssignment_1 )* ) )
            // InternalVTK.g:1249:2: ( ( rule__TriangleStripPolyShape__FacesAssignment_1 ) ) ( ( rule__TriangleStripPolyShape__FacesAssignment_1 )* )
            {
            // InternalVTK.g:1249:2: ( ( rule__TriangleStripPolyShape__FacesAssignment_1 ) )
            // InternalVTK.g:1250:3: ( rule__TriangleStripPolyShape__FacesAssignment_1 )
            {
             before(grammarAccess.getTriangleStripPolyShapeAccess().getFacesAssignment_1()); 
            // InternalVTK.g:1251:3: ( rule__TriangleStripPolyShape__FacesAssignment_1 )
            // InternalVTK.g:1251:4: rule__TriangleStripPolyShape__FacesAssignment_1
            {
            pushFollow(FOLLOW_8);
            rule__TriangleStripPolyShape__FacesAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTriangleStripPolyShapeAccess().getFacesAssignment_1()); 

            }

            // InternalVTK.g:1254:2: ( ( rule__TriangleStripPolyShape__FacesAssignment_1 )* )
            // InternalVTK.g:1255:3: ( rule__TriangleStripPolyShape__FacesAssignment_1 )*
            {
             before(grammarAccess.getTriangleStripPolyShapeAccess().getFacesAssignment_1()); 
            // InternalVTK.g:1256:3: ( rule__TriangleStripPolyShape__FacesAssignment_1 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==18) ) {
                    int LA18_2 = input.LA(2);

                    if ( (LA18_2==RULE_INT) ) {
                        int LA18_3 = input.LA(3);

                        if ( (LA18_3==18) ) {
                            int LA18_4 = input.LA(4);

                            if ( (LA18_4==RULE_INT) ) {
                                alt18=1;
                            }


                        }
                        else if ( (LA18_3==RULE_INT) ) {
                            alt18=1;
                        }


                    }


                }
                else if ( (LA18_0==RULE_INT) ) {
                    int LA18_3 = input.LA(2);

                    if ( (LA18_3==18) ) {
                        int LA18_4 = input.LA(3);

                        if ( (LA18_4==RULE_INT) ) {
                            alt18=1;
                        }


                    }
                    else if ( (LA18_3==RULE_INT) ) {
                        alt18=1;
                    }


                }


                switch (alt18) {
            	case 1 :
            	    // InternalVTK.g:1256:4: rule__TriangleStripPolyShape__FacesAssignment_1
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__TriangleStripPolyShape__FacesAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getTriangleStripPolyShapeAccess().getFacesAssignment_1()); 

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
    // $ANTLR end "rule__TriangleStripPolyShape__Group__1__Impl"


    // $ANTLR start "rule__Vertex__Group__0"
    // InternalVTK.g:1266:1: rule__Vertex__Group__0 : rule__Vertex__Group__0__Impl rule__Vertex__Group__1 ;
    public final void rule__Vertex__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1270:1: ( rule__Vertex__Group__0__Impl rule__Vertex__Group__1 )
            // InternalVTK.g:1271:2: rule__Vertex__Group__0__Impl rule__Vertex__Group__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalVTK.g:1278:1: rule__Vertex__Group__0__Impl : ( () ) ;
    public final void rule__Vertex__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1282:1: ( ( () ) )
            // InternalVTK.g:1283:1: ( () )
            {
            // InternalVTK.g:1283:1: ( () )
            // InternalVTK.g:1284:2: ()
            {
             before(grammarAccess.getVertexAccess().getVertexAction_0()); 
            // InternalVTK.g:1285:2: ()
            // InternalVTK.g:1285:3: 
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
    // InternalVTK.g:1293:1: rule__Vertex__Group__1 : rule__Vertex__Group__1__Impl rule__Vertex__Group__2 ;
    public final void rule__Vertex__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1297:1: ( rule__Vertex__Group__1__Impl rule__Vertex__Group__2 )
            // InternalVTK.g:1298:2: rule__Vertex__Group__1__Impl rule__Vertex__Group__2
            {
            pushFollow(FOLLOW_7);
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
    // InternalVTK.g:1305:1: rule__Vertex__Group__1__Impl : ( ( rule__Vertex__XAssignment_1 ) ) ;
    public final void rule__Vertex__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1309:1: ( ( ( rule__Vertex__XAssignment_1 ) ) )
            // InternalVTK.g:1310:1: ( ( rule__Vertex__XAssignment_1 ) )
            {
            // InternalVTK.g:1310:1: ( ( rule__Vertex__XAssignment_1 ) )
            // InternalVTK.g:1311:2: ( rule__Vertex__XAssignment_1 )
            {
             before(grammarAccess.getVertexAccess().getXAssignment_1()); 
            // InternalVTK.g:1312:2: ( rule__Vertex__XAssignment_1 )
            // InternalVTK.g:1312:3: rule__Vertex__XAssignment_1
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
    // InternalVTK.g:1320:1: rule__Vertex__Group__2 : rule__Vertex__Group__2__Impl rule__Vertex__Group__3 ;
    public final void rule__Vertex__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1324:1: ( rule__Vertex__Group__2__Impl rule__Vertex__Group__3 )
            // InternalVTK.g:1325:2: rule__Vertex__Group__2__Impl rule__Vertex__Group__3
            {
            pushFollow(FOLLOW_7);
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
    // InternalVTK.g:1332:1: rule__Vertex__Group__2__Impl : ( ( rule__Vertex__YAssignment_2 ) ) ;
    public final void rule__Vertex__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1336:1: ( ( ( rule__Vertex__YAssignment_2 ) ) )
            // InternalVTK.g:1337:1: ( ( rule__Vertex__YAssignment_2 ) )
            {
            // InternalVTK.g:1337:1: ( ( rule__Vertex__YAssignment_2 ) )
            // InternalVTK.g:1338:2: ( rule__Vertex__YAssignment_2 )
            {
             before(grammarAccess.getVertexAccess().getYAssignment_2()); 
            // InternalVTK.g:1339:2: ( rule__Vertex__YAssignment_2 )
            // InternalVTK.g:1339:3: rule__Vertex__YAssignment_2
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
    // InternalVTK.g:1347:1: rule__Vertex__Group__3 : rule__Vertex__Group__3__Impl rule__Vertex__Group__4 ;
    public final void rule__Vertex__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1351:1: ( rule__Vertex__Group__3__Impl rule__Vertex__Group__4 )
            // InternalVTK.g:1352:2: rule__Vertex__Group__3__Impl rule__Vertex__Group__4
            {
            pushFollow(FOLLOW_12);
            rule__Vertex__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Vertex__Group__4();

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
    // InternalVTK.g:1359:1: rule__Vertex__Group__3__Impl : ( ( rule__Vertex__ZAssignment_3 ) ) ;
    public final void rule__Vertex__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1363:1: ( ( ( rule__Vertex__ZAssignment_3 ) ) )
            // InternalVTK.g:1364:1: ( ( rule__Vertex__ZAssignment_3 ) )
            {
            // InternalVTK.g:1364:1: ( ( rule__Vertex__ZAssignment_3 ) )
            // InternalVTK.g:1365:2: ( rule__Vertex__ZAssignment_3 )
            {
             before(grammarAccess.getVertexAccess().getZAssignment_3()); 
            // InternalVTK.g:1366:2: ( rule__Vertex__ZAssignment_3 )
            // InternalVTK.g:1366:3: rule__Vertex__ZAssignment_3
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


    // $ANTLR start "rule__Vertex__Group__4"
    // InternalVTK.g:1374:1: rule__Vertex__Group__4 : rule__Vertex__Group__4__Impl rule__Vertex__Group__5 ;
    public final void rule__Vertex__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1378:1: ( rule__Vertex__Group__4__Impl rule__Vertex__Group__5 )
            // InternalVTK.g:1379:2: rule__Vertex__Group__4__Impl rule__Vertex__Group__5
            {
            pushFollow(FOLLOW_12);
            rule__Vertex__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Vertex__Group__5();

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
    // $ANTLR end "rule__Vertex__Group__4"


    // $ANTLR start "rule__Vertex__Group__4__Impl"
    // InternalVTK.g:1386:1: rule__Vertex__Group__4__Impl : ( ( ruleEInt )? ) ;
    public final void rule__Vertex__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1390:1: ( ( ( ruleEInt )? ) )
            // InternalVTK.g:1391:1: ( ( ruleEInt )? )
            {
            // InternalVTK.g:1391:1: ( ( ruleEInt )? )
            // InternalVTK.g:1392:2: ( ruleEInt )?
            {
             before(grammarAccess.getVertexAccess().getEIntParserRuleCall_4()); 
            // InternalVTK.g:1393:2: ( ruleEInt )?
            int alt19=2;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // InternalVTK.g:1393:3: ruleEInt
                    {
                    pushFollow(FOLLOW_2);
                    ruleEInt();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVertexAccess().getEIntParserRuleCall_4()); 

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
    // $ANTLR end "rule__Vertex__Group__4__Impl"


    // $ANTLR start "rule__Vertex__Group__5"
    // InternalVTK.g:1401:1: rule__Vertex__Group__5 : rule__Vertex__Group__5__Impl ;
    public final void rule__Vertex__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1405:1: ( rule__Vertex__Group__5__Impl )
            // InternalVTK.g:1406:2: rule__Vertex__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Vertex__Group__5__Impl();

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
    // $ANTLR end "rule__Vertex__Group__5"


    // $ANTLR start "rule__Vertex__Group__5__Impl"
    // InternalVTK.g:1412:1: rule__Vertex__Group__5__Impl : ( ( RULE_ENDLINE )? ) ;
    public final void rule__Vertex__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1416:1: ( ( ( RULE_ENDLINE )? ) )
            // InternalVTK.g:1417:1: ( ( RULE_ENDLINE )? )
            {
            // InternalVTK.g:1417:1: ( ( RULE_ENDLINE )? )
            // InternalVTK.g:1418:2: ( RULE_ENDLINE )?
            {
             before(grammarAccess.getVertexAccess().getENDLINETerminalRuleCall_5()); 
            // InternalVTK.g:1419:2: ( RULE_ENDLINE )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ENDLINE) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalVTK.g:1419:3: RULE_ENDLINE
                    {
                    match(input,RULE_ENDLINE,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getVertexAccess().getENDLINETerminalRuleCall_5()); 

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
    // $ANTLR end "rule__Vertex__Group__5__Impl"


    // $ANTLR start "rule__Geometry__NameAssignment_1"
    // InternalVTK.g:1428:1: rule__Geometry__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Geometry__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1432:1: ( ( ruleEString ) )
            // InternalVTK.g:1433:2: ( ruleEString )
            {
            // InternalVTK.g:1433:2: ( ruleEString )
            // InternalVTK.g:1434:3: ruleEString
            {
             before(grammarAccess.getGeometryAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getGeometryAccess().getNameEStringParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__Geometry__NameAssignment_1"


    // $ANTLR start "rule__Geometry__VertexSourcesAssignment_2_1"
    // InternalVTK.g:1443:1: rule__Geometry__VertexSourcesAssignment_2_1 : ( ruleVertexSource ) ;
    public final void rule__Geometry__VertexSourcesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1447:1: ( ( ruleVertexSource ) )
            // InternalVTK.g:1448:2: ( ruleVertexSource )
            {
            // InternalVTK.g:1448:2: ( ruleVertexSource )
            // InternalVTK.g:1449:3: ruleVertexSource
            {
             before(grammarAccess.getGeometryAccess().getVertexSourcesVertexSourceParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleVertexSource();

            state._fsp--;

             after(grammarAccess.getGeometryAccess().getVertexSourcesVertexSourceParserRuleCall_2_1_0()); 

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
    // $ANTLR end "rule__Geometry__VertexSourcesAssignment_2_1"


    // $ANTLR start "rule__Geometry__NodesAssignment_2_2_1"
    // InternalVTK.g:1458:1: rule__Geometry__NodesAssignment_2_2_1 : ( rulePolyShape ) ;
    public final void rule__Geometry__NodesAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1462:1: ( ( rulePolyShape ) )
            // InternalVTK.g:1463:2: ( rulePolyShape )
            {
            // InternalVTK.g:1463:2: ( rulePolyShape )
            // InternalVTK.g:1464:3: rulePolyShape
            {
             before(grammarAccess.getGeometryAccess().getNodesPolyShapeParserRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_2);
            rulePolyShape();

            state._fsp--;

             after(grammarAccess.getGeometryAccess().getNodesPolyShapeParserRuleCall_2_2_1_0()); 

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
    // $ANTLR end "rule__Geometry__NodesAssignment_2_2_1"


    // $ANTLR start "rule__Geometry__NodesAssignment_2_3_1"
    // InternalVTK.g:1473:1: rule__Geometry__NodesAssignment_2_3_1 : ( ruleTriangleStripPolyShape ) ;
    public final void rule__Geometry__NodesAssignment_2_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1477:1: ( ( ruleTriangleStripPolyShape ) )
            // InternalVTK.g:1478:2: ( ruleTriangleStripPolyShape )
            {
            // InternalVTK.g:1478:2: ( ruleTriangleStripPolyShape )
            // InternalVTK.g:1479:3: ruleTriangleStripPolyShape
            {
             before(grammarAccess.getGeometryAccess().getNodesTriangleStripPolyShapeParserRuleCall_2_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTriangleStripPolyShape();

            state._fsp--;

             after(grammarAccess.getGeometryAccess().getNodesTriangleStripPolyShapeParserRuleCall_2_3_1_0()); 

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
    // $ANTLR end "rule__Geometry__NodesAssignment_2_3_1"


    // $ANTLR start "rule__VertexSource__VerticesAssignment_2"
    // InternalVTK.g:1488:1: rule__VertexSource__VerticesAssignment_2 : ( ruleVertex ) ;
    public final void rule__VertexSource__VerticesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1492:1: ( ( ruleVertex ) )
            // InternalVTK.g:1493:2: ( ruleVertex )
            {
            // InternalVTK.g:1493:2: ( ruleVertex )
            // InternalVTK.g:1494:3: ruleVertex
            {
             before(grammarAccess.getVertexSourceAccess().getVerticesVertexParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleVertex();

            state._fsp--;

             after(grammarAccess.getVertexSourceAccess().getVerticesVertexParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__VertexSource__VerticesAssignment_2"


    // $ANTLR start "rule__Face__VertexIndicesAssignment_2"
    // InternalVTK.g:1503:1: rule__Face__VertexIndicesAssignment_2 : ( ruleEInt ) ;
    public final void rule__Face__VertexIndicesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1507:1: ( ( ruleEInt ) )
            // InternalVTK.g:1508:2: ( ruleEInt )
            {
            // InternalVTK.g:1508:2: ( ruleEInt )
            // InternalVTK.g:1509:3: ruleEInt
            {
             before(grammarAccess.getFaceAccess().getVertexIndicesEIntParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getFaceAccess().getVertexIndicesEIntParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__Face__VertexIndicesAssignment_2"


    // $ANTLR start "rule__PolyShape__FacesAssignment_1"
    // InternalVTK.g:1518:1: rule__PolyShape__FacesAssignment_1 : ( ruleFace ) ;
    public final void rule__PolyShape__FacesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1522:1: ( ( ruleFace ) )
            // InternalVTK.g:1523:2: ( ruleFace )
            {
            // InternalVTK.g:1523:2: ( ruleFace )
            // InternalVTK.g:1524:3: ruleFace
            {
             before(grammarAccess.getPolyShapeAccess().getFacesFaceParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFace();

            state._fsp--;

             after(grammarAccess.getPolyShapeAccess().getFacesFaceParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__PolyShape__FacesAssignment_1"


    // $ANTLR start "rule__TriangleStripPolyShape__FacesAssignment_1"
    // InternalVTK.g:1533:1: rule__TriangleStripPolyShape__FacesAssignment_1 : ( ruleFace ) ;
    public final void rule__TriangleStripPolyShape__FacesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1537:1: ( ( ruleFace ) )
            // InternalVTK.g:1538:2: ( ruleFace )
            {
            // InternalVTK.g:1538:2: ( ruleFace )
            // InternalVTK.g:1539:3: ruleFace
            {
             before(grammarAccess.getTriangleStripPolyShapeAccess().getFacesFaceParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFace();

            state._fsp--;

             after(grammarAccess.getTriangleStripPolyShapeAccess().getFacesFaceParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__TriangleStripPolyShape__FacesAssignment_1"


    // $ANTLR start "rule__Vertex__XAssignment_1"
    // InternalVTK.g:1548:1: rule__Vertex__XAssignment_1 : ( ruleEDouble ) ;
    public final void rule__Vertex__XAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1552:1: ( ( ruleEDouble ) )
            // InternalVTK.g:1553:2: ( ruleEDouble )
            {
            // InternalVTK.g:1553:2: ( ruleEDouble )
            // InternalVTK.g:1554:3: ruleEDouble
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
    // InternalVTK.g:1563:1: rule__Vertex__YAssignment_2 : ( ruleEDouble ) ;
    public final void rule__Vertex__YAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1567:1: ( ( ruleEDouble ) )
            // InternalVTK.g:1568:2: ( ruleEDouble )
            {
            // InternalVTK.g:1568:2: ( ruleEDouble )
            // InternalVTK.g:1569:3: ruleEDouble
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
    // InternalVTK.g:1578:1: rule__Vertex__ZAssignment_3 : ( ruleEDouble ) ;
    public final void rule__Vertex__ZAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVTK.g:1582:1: ( ( ruleEDouble ) )
            // InternalVTK.g:1583:2: ( ruleEDouble )
            {
            // InternalVTK.g:1583:2: ( ruleEDouble )
            // InternalVTK.g:1584:3: ruleEDouble
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

    // Delegated rules


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA8 dfa8 = new DFA8(this);
    protected DFA11 dfa11 = new DFA11(this);
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA15 dfa15 = new DFA15(this);
    protected DFA19 dfa19 = new DFA19(this);
    static final String dfa_1s = "\102\uffff";
    static final String dfa_2s = "\1\1\2\uffff\1\2\1\uffff\1\2\1\14\1\1\1\uffff\2\1\1\21\3\uffff\1\21\2\uffff\1\21\2\uffff\1\21\1\40\1\uffff\1\40\1\1\1\uffff\2\1\1\uffff\1\1\4\uffff\1\45\2\uffff\1\45\2\uffff\1\45\1\uffff\2\64\1\1\1\uffff\2\1\1\uffff\1\1\4\uffff\1\71\2\uffff\1\71\1\uffff\1\71\1\uffff\2\101\2\uffff";
    static final String dfa_3s = "\1\4\2\uffff\1\4\1\5\3\4\1\10\3\4\1\uffff\1\10\1\uffff\1\4\1\10\1\uffff\1\4\1\5\1\10\2\4\1\10\2\4\1\10\2\4\1\10\1\4\1\10\1\uffff\1\10\1\uffff\1\4\1\10\1\uffff\1\4\1\5\1\10\1\4\1\10\3\4\1\10\2\4\1\10\1\4\1\10\1\uffff\1\10\1\uffff\1\4\1\10\1\uffff\1\4\1\10\1\4\1\10\2\4\1\10\1\uffff";
    static final String dfa_4s = "\1\25\2\uffff\1\25\1\22\3\25\1\10\3\25\1\uffff\1\10\1\uffff\1\25\1\10\1\uffff\1\25\1\22\1\10\2\25\1\10\2\25\1\10\2\25\1\10\1\25\1\10\1\uffff\1\10\1\uffff\1\25\1\10\1\uffff\1\25\1\22\1\10\1\25\1\10\3\25\1\10\2\25\1\10\1\25\1\10\1\uffff\1\10\1\uffff\1\25\1\10\1\uffff\1\25\1\10\1\25\1\10\2\25\1\10\1\uffff";
    static final String dfa_5s = "\1\uffff\1\2\1\1\11\uffff\1\1\1\uffff\1\1\2\uffff\1\1\16\uffff\1\1\1\uffff\1\1\2\uffff\1\1\16\uffff\1\1\1\uffff\1\1\2\uffff\1\1\7\uffff\1\1";
    static final String dfa_6s = "\102\uffff}>";
    static final String[] dfa_7s = {
            "\2\1\2\2\1\3\4\uffff\6\2\3\1",
            "",
            "",
            "\1\2\1\4\2\2\1\6\4\uffff\5\2\1\5\3\2",
            "\1\7\2\uffff\1\11\11\uffff\1\10",
            "\4\2\1\6\4\uffff\11\2",
            "\1\14\1\12\3\14\4\uffff\5\14\1\13\3\14",
            "\1\1\1\17\2\uffff\1\16\11\uffff\1\15\3\1",
            "\1\11",
            "\1\1\1\17\2\uffff\1\16\11\uffff\1\15\3\1",
            "\1\1\1\22\2\uffff\1\21\11\uffff\1\20\3\1",
            "\4\21\1\14\4\uffff\11\21",
            "",
            "\1\16",
            "",
            "\1\21\1\23\2\uffff\1\25\11\uffff\1\24\3\21",
            "\1\21",
            "",
            "\1\21\1\26\2\uffff\1\30\11\uffff\1\27\3\21",
            "\1\31\2\uffff\1\33\11\uffff\1\32",
            "\1\25",
            "\1\21\1\34\2\uffff\1\36\11\uffff\1\35\3\21",
            "\1\40\1\34\2\uffff\1\40\11\uffff\1\37\3\40",
            "\1\30",
            "\1\40\1\34\2\uffff\1\40\11\uffff\1\37\3\40",
            "\1\1\1\43\2\uffff\1\42\11\uffff\1\41\3\1",
            "\1\33",
            "\1\1\1\43\2\uffff\1\42\11\uffff\1\41\3\1",
            "\1\1\1\46\2\uffff\1\45\11\uffff\1\44\3\1",
            "\1\36",
            "\1\1\1\46\2\uffff\1\45\11\uffff\1\44\3\1",
            "\1\40",
            "",
            "\1\42",
            "",
            "\1\45\1\47\2\uffff\1\51\11\uffff\1\50\3\45",
            "\1\45",
            "",
            "\1\45\1\54\2\uffff\1\53\11\uffff\1\52\3\45",
            "\1\55\2\uffff\1\57\11\uffff\1\56",
            "\1\51",
            "\1\45\1\60\2\uffff\1\62\11\uffff\1\61\3\45",
            "\1\53",
            "\1\45\1\60\2\uffff\1\64\11\uffff\1\63\3\64",
            "\1\64\1\60\2\uffff\1\64\11\uffff\1\63\3\64",
            "\1\1\1\67\2\uffff\1\66\11\uffff\1\65\3\1",
            "\1\57",
            "\1\1\1\67\2\uffff\1\66\11\uffff\1\65\3\1",
            "\1\1\1\72\2\uffff\1\71\11\uffff\1\70\3\1",
            "\1\62",
            "\1\1\1\72\2\uffff\1\71\11\uffff\1\70\3\1",
            "\1\64",
            "",
            "\1\66",
            "",
            "\1\71\1\47\2\uffff\1\74\11\uffff\1\73\3\71",
            "\1\71",
            "",
            "\1\71\1\77\2\uffff\1\76\11\uffff\1\75\3\71",
            "\1\74",
            "\1\71\1\60\2\uffff\1\62\11\uffff\1\61\3\71",
            "\1\76",
            "\1\71\1\60\2\uffff\1\101\11\uffff\1\100\3\101",
            "\1\101\1\60\2\uffff\1\101\11\uffff\1\100\3\101",
            "\1\101",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 175:4: ( rule__EString__Alternatives )*";
        }
    }
    static final String dfa_8s = "\52\uffff";
    static final String dfa_9s = "\1\1\4\uffff\1\10\1\1\3\uffff\1\1\1\uffff\1\24\1\uffff\1\24\1\26\1\uffff\1\26\1\1\4\uffff\1\1\1\uffff\2\1\1\uffff\1\1\1\uffff\1\47\3\uffff\1\47\1\51\1\uffff\1\51\4\uffff";
    static final String dfa_10s = "\1\4\1\uffff\1\10\1\5\1\10\2\4\1\10\1\uffff\1\10\1\4\1\5\1\4\1\10\2\4\1\10\2\4\1\10\1\uffff\1\10\1\uffff\1\4\1\10\2\4\1\10\1\4\1\5\1\4\1\10\1\uffff\1\10\2\4\1\10\1\4\1\10\1\uffff\1\10\1\uffff";
    static final String dfa_11s = "\1\25\1\uffff\1\10\1\22\1\10\2\25\1\10\1\uffff\1\10\1\25\1\22\1\25\1\10\2\25\1\10\2\25\1\10\1\uffff\1\10\1\uffff\1\25\1\10\2\25\1\10\1\25\1\22\1\25\1\10\1\uffff\1\10\2\25\1\10\1\25\1\10\1\uffff\1\10\1\uffff";
    static final String dfa_12s = "\1\uffff\1\2\6\uffff\1\1\13\uffff\1\1\1\uffff\1\1\11\uffff\1\1\6\uffff\1\1\1\uffff\1\1";
    static final String dfa_13s = "\52\uffff}>";
    static final String[] dfa_14s = {
            "\2\1\2\uffff\1\3\11\uffff\1\2\3\1",
            "",
            "\1\3",
            "\1\1\2\uffff\1\5\11\uffff\1\4",
            "\1\5",
            "\1\10\1\6\2\uffff\1\10\11\uffff\1\7\3\10",
            "\1\1\1\13\2\uffff\1\12\11\uffff\1\11\3\1",
            "\1\10",
            "",
            "\1\12",
            "\1\1\1\14\2\uffff\1\16\11\uffff\1\15\3\1",
            "\1\17\2\uffff\1\21\11\uffff\1\20",
            "\1\24\1\22\2\uffff\1\24\11\uffff\1\23\3\24",
            "\1\16",
            "\1\24\1\22\2\uffff\1\24\11\uffff\1\23\3\24",
            "\1\26\1\27\2\uffff\1\26\11\uffff\1\25\3\26",
            "\1\21",
            "\1\26\1\27\2\uffff\1\26\11\uffff\1\25\3\26",
            "\1\1\1\32\2\uffff\1\31\11\uffff\1\30\3\1",
            "\1\24",
            "",
            "\1\26",
            "",
            "\1\1\1\35\2\uffff\1\34\11\uffff\1\33\3\1",
            "\1\31",
            "\1\1\1\36\2\uffff\1\40\11\uffff\1\37\3\1",
            "\1\1\1\36\2\uffff\1\40\11\uffff\1\37\3\1",
            "\1\34",
            "\1\1\1\36\2\uffff\1\42\11\uffff\1\41\3\1",
            "\1\43\2\uffff\1\45\11\uffff\1\44",
            "\1\47\1\22\2\uffff\1\47\11\uffff\1\46\3\47",
            "\1\40",
            "",
            "\1\42",
            "\1\47\1\22\2\uffff\1\47\11\uffff\1\46\3\47",
            "\1\51\1\27\2\uffff\1\51\11\uffff\1\50\3\51",
            "\1\45",
            "\1\51\1\27\2\uffff\1\51\11\uffff\1\50\3\51",
            "\1\47",
            "",
            "\1\51",
            ""
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "()* loopback of 527:2: ( rule__Geometry__NodesAssignment_2_2_1 )*";
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "()* loopback of 689:2: ( rule__Geometry__NodesAssignment_2_3_1 )*";
        }
    }
    static final String dfa_15s = "\13\uffff";
    static final String dfa_16s = "\1\1\12\uffff";
    static final String dfa_17s = "\1\4\1\uffff\1\5\1\10\2\5\1\10\1\5\1\uffff\1\10\1\uffff";
    static final String dfa_18s = "\1\25\1\uffff\1\22\1\10\2\22\1\10\1\22\1\uffff\1\10\1\uffff";
    static final String dfa_19s = "\1\uffff\1\2\6\uffff\1\1\1\uffff\1\1";
    static final String dfa_20s = "\13\uffff}>";
    static final String[] dfa_21s = {
            "\1\1\1\2\2\uffff\1\4\11\uffff\1\3\3\1",
            "",
            "\1\5\2\uffff\1\7\11\uffff\1\6",
            "\1\4",
            "\1\5\2\uffff\1\7\11\uffff\1\6",
            "\1\10\2\uffff\1\12\11\uffff\1\11",
            "\1\7",
            "\1\10\2\uffff\1\12\11\uffff\1\11",
            "",
            "\1\12",
            ""
    };

    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
    static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
    static final char[] dfa_18 = DFA.unpackEncodedStringToUnsignedChars(dfa_18s);
    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final short[][] dfa_21 = unpackEncodedStringArray(dfa_21s);

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = dfa_15;
            this.eof = dfa_16;
            this.min = dfa_17;
            this.max = dfa_18;
            this.accept = dfa_19;
            this.special = dfa_20;
            this.transition = dfa_21;
        }
        public String getDescription() {
            return "()* loopback of 884:3: ( rule__VertexSource__VerticesAssignment_2 )*";
        }
    }
    static final String dfa_22s = "\103\uffff";
    static final String dfa_23s = "\10\uffff\1\4\1\uffff\2\4\2\uffff\1\23\2\uffff\1\23\4\uffff\1\23\1\41\1\uffff\1\41\1\4\1\uffff\2\4\1\uffff\1\4\4\uffff\1\46\2\uffff\1\46\2\uffff\1\46\1\65\1\uffff\1\65\1\4\1\uffff\2\4\1\uffff\1\4\4\uffff\1\72\2\uffff\1\72\1\uffff\1\72\1\102\1\uffff\1\102\2\uffff";
    static final String dfa_24s = "\1\4\1\uffff\1\4\2\uffff\1\5\3\4\1\10\3\4\1\uffff\1\4\1\10\1\uffff\1\4\1\10\1\uffff\1\5\1\10\2\4\1\10\2\4\1\10\2\4\1\10\1\4\1\10\1\uffff\1\10\1\uffff\1\4\1\10\1\uffff\1\4\1\5\1\10\2\4\1\10\2\4\1\10\2\4\1\10\1\4\1\10\1\uffff\1\10\1\uffff\1\4\1\10\1\uffff\1\4\1\10\2\4\1\10\1\4\1\10\1\uffff";
    static final String dfa_25s = "\1\22\1\uffff\1\22\2\uffff\3\22\1\25\1\10\2\25\1\22\1\uffff\1\25\1\10\1\uffff\1\25\1\10\1\uffff\1\22\1\10\2\25\1\10\2\25\1\10\2\25\1\10\1\25\1\10\1\uffff\1\10\1\uffff\1\25\1\10\1\uffff\1\25\1\22\1\10\2\25\1\10\2\25\1\10\2\25\1\10\1\25\1\10\1\uffff\1\10\1\uffff\1\25\1\10\1\uffff\1\25\1\10\2\25\1\10\1\25\1\10\1\uffff";
    static final String dfa_26s = "\1\uffff\1\1\1\uffff\1\1\1\2\10\uffff\1\1\2\uffff\1\1\2\uffff\1\1\15\uffff\1\1\1\uffff\1\1\2\uffff\1\1\16\uffff\1\1\1\uffff\1\1\2\uffff\1\1\7\uffff\1\1";
    static final String dfa_27s = "\103\uffff}>";
    static final String[] dfa_28s = {
            "\2\4\2\1\1\2\4\uffff\5\1\1\3",
            "",
            "\1\3\1\5\2\3\1\7\4\uffff\5\3\1\6",
            "",
            "",
            "\1\10\2\uffff\1\12\11\uffff\1\11",
            "\4\3\1\7\4\uffff\6\3",
            "\1\15\1\13\3\15\4\uffff\5\15\1\14",
            "\1\4\1\16\2\uffff\1\20\11\uffff\1\17\3\4",
            "\1\12",
            "\1\4\1\16\2\uffff\1\20\11\uffff\1\17\3\4",
            "\1\4\1\21\2\uffff\1\23\11\uffff\1\22\3\4",
            "\4\23\1\15\4\uffff\6\23",
            "",
            "\1\23\1\24\2\uffff\1\26\11\uffff\1\25\3\23",
            "\1\20",
            "",
            "\1\23\1\27\2\uffff\1\31\11\uffff\1\30\3\23",
            "\1\23",
            "",
            "\1\32\2\uffff\1\34\11\uffff\1\33",
            "\1\26",
            "\1\23\1\35\2\uffff\1\37\11\uffff\1\36\3\23",
            "\1\41\1\35\2\uffff\1\41\11\uffff\1\40\3\41",
            "\1\31",
            "\1\41\1\35\2\uffff\1\41\11\uffff\1\40\3\41",
            "\1\4\1\44\2\uffff\1\43\11\uffff\1\42\3\4",
            "\1\34",
            "\1\4\1\44\2\uffff\1\43\11\uffff\1\42\3\4",
            "\1\4\1\47\2\uffff\1\46\11\uffff\1\45\3\4",
            "\1\37",
            "\1\4\1\47\2\uffff\1\46\11\uffff\1\45\3\4",
            "\1\41",
            "",
            "\1\43",
            "",
            "\1\46\1\50\2\uffff\1\52\11\uffff\1\51\3\46",
            "\1\46",
            "",
            "\1\46\1\53\2\uffff\1\55\11\uffff\1\54\3\46",
            "\1\56\2\uffff\1\60\11\uffff\1\57",
            "\1\52",
            "\1\46\1\61\2\uffff\1\63\11\uffff\1\62\3\46",
            "\1\65\1\61\2\uffff\1\65\11\uffff\1\64\3\65",
            "\1\55",
            "\1\65\1\61\2\uffff\1\65\11\uffff\1\64\3\65",
            "\1\4\1\70\2\uffff\1\67\11\uffff\1\66\3\4",
            "\1\60",
            "\1\4\1\70\2\uffff\1\67\11\uffff\1\66\3\4",
            "\1\4\1\73\2\uffff\1\72\11\uffff\1\71\3\4",
            "\1\63",
            "\1\4\1\73\2\uffff\1\72\11\uffff\1\71\3\4",
            "\1\65",
            "",
            "\1\67",
            "",
            "\1\72\1\50\2\uffff\1\75\11\uffff\1\74\3\72",
            "\1\72",
            "",
            "\1\72\1\76\2\uffff\1\100\11\uffff\1\77\3\72",
            "\1\75",
            "\1\72\1\61\2\uffff\1\63\11\uffff\1\62\3\72",
            "\1\102\1\61\2\uffff\1\102\11\uffff\1\101\3\102",
            "\1\100",
            "\1\102\1\61\2\uffff\1\102\11\uffff\1\101\3\102",
            "\1\102",
            ""
    };

    static final short[] dfa_22 = DFA.unpackEncodedString(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final char[] dfa_24 = DFA.unpackEncodedStringToUnsignedChars(dfa_24s);
    static final char[] dfa_25 = DFA.unpackEncodedStringToUnsignedChars(dfa_25s);
    static final short[] dfa_26 = DFA.unpackEncodedString(dfa_26s);
    static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
    static final short[][] dfa_28 = unpackEncodedStringArray(dfa_28s);

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = dfa_22;
            this.eof = dfa_23;
            this.min = dfa_24;
            this.max = dfa_25;
            this.accept = dfa_26;
            this.special = dfa_27;
            this.transition = dfa_28;
        }
        public String getDescription() {
            return "940:2: ( ruleEString )?";
        }
    }
    static final String dfa_29s = "\43\uffff";
    static final String dfa_30s = "\1\1\2\uffff\1\6\3\uffff\1\1\1\uffff\1\1\2\uffff\1\13\2\uffff\1\13\1\1\1\uffff\2\1\1\uffff\1\1\2\uffff\1\32\2\uffff\1\32\1\uffff\1\32\1\42\1\uffff\1\42\2\uffff";
    static final String dfa_31s = "\1\4\1\uffff\1\10\1\4\1\5\1\10\1\uffff\1\4\1\10\1\4\1\10\1\uffff\1\4\1\5\1\10\2\4\1\10\2\4\1\10\1\4\1\10\1\uffff\1\4\1\10\1\uffff\1\4\1\10\2\4\1\10\1\4\1\10\1\uffff";
    static final String dfa_32s = "\1\25\1\uffff\1\10\1\25\1\22\1\10\1\uffff\1\25\1\10\1\25\1\10\1\uffff\1\25\1\22\1\10\2\25\1\10\2\25\1\10\1\25\1\10\1\uffff\1\25\1\10\1\uffff\1\25\1\10\2\25\1\10\1\25\1\10\1\uffff";
    static final String dfa_33s = "\1\uffff\1\2\4\uffff\1\1\4\uffff\1\1\13\uffff\1\1\2\uffff\1\1\7\uffff\1\1";
    static final String dfa_34s = "\43\uffff}>";
    static final String[] dfa_35s = {
            "\2\1\2\uffff\1\3\11\uffff\1\2\3\1",
            "",
            "\1\3",
            "\1\6\1\4\2\uffff\1\6\11\uffff\1\5\3\6",
            "\1\7\2\uffff\1\11\11\uffff\1\10",
            "\1\6",
            "",
            "\1\1\1\14\2\uffff\1\13\11\uffff\1\12\3\1",
            "\1\11",
            "\1\1\1\14\2\uffff\1\13\11\uffff\1\12\3\1",
            "\1\13",
            "",
            "\1\13\1\15\2\uffff\1\17\11\uffff\1\16\3\13",
            "\1\20\2\uffff\1\22\11\uffff\1\21",
            "\1\17",
            "\1\13\1\23\2\uffff\1\25\11\uffff\1\24\3\13",
            "\1\1\1\30\2\uffff\1\27\11\uffff\1\26\3\1",
            "\1\22",
            "\1\1\1\30\2\uffff\1\27\11\uffff\1\26\3\1",
            "\1\1\1\33\2\uffff\1\32\11\uffff\1\31\3\1",
            "\1\25",
            "\1\1\1\33\2\uffff\1\32\11\uffff\1\31\3\1",
            "\1\27",
            "",
            "\1\32\1\15\2\uffff\1\35\11\uffff\1\34\3\32",
            "\1\32",
            "",
            "\1\32\1\36\2\uffff\1\40\11\uffff\1\37\3\32",
            "\1\35",
            "\1\32\1\23\2\uffff\1\25\11\uffff\1\24\3\32",
            "\1\42\1\23\2\uffff\1\42\11\uffff\1\41\3\42",
            "\1\40",
            "\1\42\1\23\2\uffff\1\42\11\uffff\1\41\3\42",
            "\1\42",
            ""
    };

    static final short[] dfa_29 = DFA.unpackEncodedString(dfa_29s);
    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final char[] dfa_31 = DFA.unpackEncodedStringToUnsignedChars(dfa_31s);
    static final char[] dfa_32 = DFA.unpackEncodedStringToUnsignedChars(dfa_32s);
    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
    static final short[] dfa_34 = DFA.unpackEncodedString(dfa_34s);
    static final short[][] dfa_35 = unpackEncodedStringArray(dfa_35s);

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = dfa_29;
            this.eof = dfa_30;
            this.min = dfa_31;
            this.max = dfa_32;
            this.accept = dfa_33;
            this.special = dfa_34;
            this.transition = dfa_35;
        }
        public String getDescription() {
            return "()* loopback of 1108:3: ( rule__Face__VertexIndicesAssignment_2 )*";
        }
    }
    static final String dfa_36s = "\44\uffff";
    static final String dfa_37s = "\1\3\1\uffff\1\7\5\uffff\1\3\1\uffff\1\3\2\uffff\1\14\2\uffff\1\14\1\3\1\uffff\2\3\1\uffff\1\3\2\uffff\1\33\2\uffff\1\33\1\uffff\1\33\1\43\1\uffff\1\43\2\uffff";
    static final String dfa_38s = "\1\4\1\10\1\4\1\uffff\1\5\1\10\1\5\1\uffff\1\4\1\10\1\4\1\10\1\uffff\1\4\1\5\1\10\2\4\1\10\2\4\1\10\1\4\1\10\1\uffff\1\4\1\10\1\uffff\1\4\1\10\2\4\1\10\1\4\1\10\1\uffff";
    static final String dfa_39s = "\1\25\1\10\1\25\1\uffff\1\22\1\10\1\22\1\uffff\1\25\1\10\1\25\1\10\1\uffff\1\25\1\22\1\10\2\25\1\10\2\25\1\10\1\25\1\10\1\uffff\1\25\1\10\1\uffff\1\25\1\10\2\25\1\10\1\25\1\10\1\uffff";
    static final String dfa_40s = "\3\uffff\1\2\3\uffff\1\1\4\uffff\1\1\13\uffff\1\1\2\uffff\1\1\7\uffff\1\1";
    static final String dfa_41s = "\44\uffff}>";
    static final String[] dfa_42s = {
            "\2\3\2\uffff\1\2\11\uffff\1\1\3\3",
            "\1\2",
            "\1\7\1\4\2\uffff\1\6\11\uffff\1\5\3\7",
            "",
            "\1\10\2\uffff\1\12\11\uffff\1\11",
            "\1\6",
            "\1\10\2\uffff\1\12\11\uffff\1\11",
            "",
            "\1\3\1\15\2\uffff\1\14\11\uffff\1\13\3\3",
            "\1\12",
            "\1\3\1\15\2\uffff\1\14\11\uffff\1\13\3\3",
            "\1\14",
            "",
            "\1\14\1\16\2\uffff\1\20\11\uffff\1\17\3\14",
            "\1\21\2\uffff\1\23\11\uffff\1\22",
            "\1\20",
            "\1\14\1\24\2\uffff\1\26\11\uffff\1\25\3\14",
            "\1\3\1\31\2\uffff\1\30\11\uffff\1\27\3\3",
            "\1\23",
            "\1\3\1\31\2\uffff\1\30\11\uffff\1\27\3\3",
            "\1\3\1\34\2\uffff\1\33\11\uffff\1\32\3\3",
            "\1\26",
            "\1\3\1\34\2\uffff\1\33\11\uffff\1\32\3\3",
            "\1\30",
            "",
            "\1\33\1\16\2\uffff\1\36\11\uffff\1\35\3\33",
            "\1\33",
            "",
            "\1\33\1\37\2\uffff\1\41\11\uffff\1\40\3\33",
            "\1\36",
            "\1\33\1\24\2\uffff\1\26\11\uffff\1\25\3\33",
            "\1\43\1\24\2\uffff\1\43\11\uffff\1\42\3\43",
            "\1\41",
            "\1\43\1\24\2\uffff\1\43\11\uffff\1\42\3\43",
            "\1\43",
            ""
    };

    static final short[] dfa_36 = DFA.unpackEncodedString(dfa_36s);
    static final short[] dfa_37 = DFA.unpackEncodedString(dfa_37s);
    static final char[] dfa_38 = DFA.unpackEncodedStringToUnsignedChars(dfa_38s);
    static final char[] dfa_39 = DFA.unpackEncodedStringToUnsignedChars(dfa_39s);
    static final short[] dfa_40 = DFA.unpackEncodedString(dfa_40s);
    static final short[] dfa_41 = DFA.unpackEncodedString(dfa_41s);
    static final short[][] dfa_42 = unpackEncodedStringArray(dfa_42s);

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = dfa_36;
            this.eof = dfa_37;
            this.min = dfa_38;
            this.max = dfa_39;
            this.accept = dfa_40;
            this.special = dfa_41;
            this.transition = dfa_42;
        }
        public String getDescription() {
            return "1393:2: ( ruleEInt )?";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000000000007E1C2L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000000007E1C0L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000003C0130L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000003C0132L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000240120L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000240122L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x000000000007E1D0L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000240130L});

}