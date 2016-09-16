package xtext.ide.contentassist.antlr.internal;

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
import xtext.services.STLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/*******************************************************************************
 * Copyright (c) 2016 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - 
 *   Kasper Gammeltoft
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalSTLParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_WS", "RULE_STRING", "RULE_DOUBLE", "RULE_ANY_OTHER", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "'solid'", "'endsolid'", "'facet'", "'outer'", "'loop'", "'endloop'", "'endfacet'", "'normal'", "'vertex'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=11;
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
    public static final int RULE_ID=4;
    public static final int RULE_WS=5;
    public static final int RULE_ANY_OTHER=8;
    public static final int RULE_INT=9;
    public static final int RULE_ML_COMMENT=10;
    public static final int T__20=20;

    // delegates
    // delegators


        public InternalSTLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSTLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSTLParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSTL.g"; }


    	private STLGrammarAccess grammarAccess;

    	public void setGrammarAccess(STLGrammarAccess grammarAccess) {
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
    // InternalSTL.g:61:1: entryRuleGeometry : ruleGeometry EOF ;
    public final void entryRuleGeometry() throws RecognitionException {
        try {
            // InternalSTL.g:62:1: ( ruleGeometry EOF )
            // InternalSTL.g:63:1: ruleGeometry EOF
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
    // InternalSTL.g:70:1: ruleGeometry : ( ( rule__Geometry__Group__0 ) ) ;
    public final void ruleGeometry() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:74:2: ( ( ( rule__Geometry__Group__0 ) ) )
            // InternalSTL.g:75:2: ( ( rule__Geometry__Group__0 ) )
            {
            // InternalSTL.g:75:2: ( ( rule__Geometry__Group__0 ) )
            // InternalSTL.g:76:3: ( rule__Geometry__Group__0 )
            {
             before(grammarAccess.getGeometryAccess().getGroup()); 
            // InternalSTL.g:77:3: ( rule__Geometry__Group__0 )
            // InternalSTL.g:77:4: rule__Geometry__Group__0
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


    // $ANTLR start "entryRuleShape_Impl"
    // InternalSTL.g:86:1: entryRuleShape_Impl : ruleShape_Impl EOF ;
    public final void entryRuleShape_Impl() throws RecognitionException {
        try {
            // InternalSTL.g:87:1: ( ruleShape_Impl EOF )
            // InternalSTL.g:88:1: ruleShape_Impl EOF
            {
             before(grammarAccess.getShape_ImplRule()); 
            pushFollow(FOLLOW_1);
            ruleShape_Impl();

            state._fsp--;

             after(grammarAccess.getShape_ImplRule()); 
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
    // $ANTLR end "entryRuleShape_Impl"


    // $ANTLR start "ruleShape_Impl"
    // InternalSTL.g:95:1: ruleShape_Impl : ( ( rule__Shape_Impl__Group__0 ) ) ;
    public final void ruleShape_Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:99:2: ( ( ( rule__Shape_Impl__Group__0 ) ) )
            // InternalSTL.g:100:2: ( ( rule__Shape_Impl__Group__0 ) )
            {
            // InternalSTL.g:100:2: ( ( rule__Shape_Impl__Group__0 ) )
            // InternalSTL.g:101:3: ( rule__Shape_Impl__Group__0 )
            {
             before(grammarAccess.getShape_ImplAccess().getGroup()); 
            // InternalSTL.g:102:3: ( rule__Shape_Impl__Group__0 )
            // InternalSTL.g:102:4: rule__Shape_Impl__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Shape_Impl__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getShape_ImplAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleShape_Impl"


    // $ANTLR start "entryRuleTriangle"
    // InternalSTL.g:111:1: entryRuleTriangle : ruleTriangle EOF ;
    public final void entryRuleTriangle() throws RecognitionException {
        try {
            // InternalSTL.g:112:1: ( ruleTriangle EOF )
            // InternalSTL.g:113:1: ruleTriangle EOF
            {
             before(grammarAccess.getTriangleRule()); 
            pushFollow(FOLLOW_1);
            ruleTriangle();

            state._fsp--;

             after(grammarAccess.getTriangleRule()); 
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
    // $ANTLR end "entryRuleTriangle"


    // $ANTLR start "ruleTriangle"
    // InternalSTL.g:120:1: ruleTriangle : ( ( rule__Triangle__Group__0 ) ) ;
    public final void ruleTriangle() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:124:2: ( ( ( rule__Triangle__Group__0 ) ) )
            // InternalSTL.g:125:2: ( ( rule__Triangle__Group__0 ) )
            {
            // InternalSTL.g:125:2: ( ( rule__Triangle__Group__0 ) )
            // InternalSTL.g:126:3: ( rule__Triangle__Group__0 )
            {
             before(grammarAccess.getTriangleAccess().getGroup()); 
            // InternalSTL.g:127:3: ( rule__Triangle__Group__0 )
            // InternalSTL.g:127:4: rule__Triangle__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Triangle__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTriangleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTriangle"


    // $ANTLR start "entryRuleVertex"
    // InternalSTL.g:136:1: entryRuleVertex : ruleVertex EOF ;
    public final void entryRuleVertex() throws RecognitionException {
        try {
            // InternalSTL.g:137:1: ( ruleVertex EOF )
            // InternalSTL.g:138:1: ruleVertex EOF
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
    // InternalSTL.g:145:1: ruleVertex : ( ( rule__Vertex__Group__0 ) ) ;
    public final void ruleVertex() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:149:2: ( ( ( rule__Vertex__Group__0 ) ) )
            // InternalSTL.g:150:2: ( ( rule__Vertex__Group__0 ) )
            {
            // InternalSTL.g:150:2: ( ( rule__Vertex__Group__0 ) )
            // InternalSTL.g:151:3: ( rule__Vertex__Group__0 )
            {
             before(grammarAccess.getVertexAccess().getGroup()); 
            // InternalSTL.g:152:3: ( rule__Vertex__Group__0 )
            // InternalSTL.g:152:4: rule__Vertex__Group__0
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


    // $ANTLR start "entryRuleEString"
    // InternalSTL.g:161:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalSTL.g:162:1: ( ruleEString EOF )
            // InternalSTL.g:163:1: ruleEString EOF
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
    // InternalSTL.g:170:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:174:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalSTL.g:175:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalSTL.g:175:2: ( ( rule__EString__Alternatives ) )
            // InternalSTL.g:176:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalSTL.g:177:3: ( rule__EString__Alternatives )
            // InternalSTL.g:177:4: rule__EString__Alternatives
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


    // $ANTLR start "rule__Shape_Impl__Alternatives_3"
    // InternalSTL.g:185:1: rule__Shape_Impl__Alternatives_3 : ( ( RULE_ID ) | ( RULE_WS ) | ( RULE_STRING ) | ( RULE_DOUBLE ) | ( RULE_ANY_OTHER ) );
    public final void rule__Shape_Impl__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:189:1: ( ( RULE_ID ) | ( RULE_WS ) | ( RULE_STRING ) | ( RULE_DOUBLE ) | ( RULE_ANY_OTHER ) )
            int alt1=5;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt1=1;
                }
                break;
            case RULE_WS:
                {
                alt1=2;
                }
                break;
            case RULE_STRING:
                {
                alt1=3;
                }
                break;
            case RULE_DOUBLE:
                {
                alt1=4;
                }
                break;
            case RULE_ANY_OTHER:
                {
                alt1=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalSTL.g:190:2: ( RULE_ID )
                    {
                    // InternalSTL.g:190:2: ( RULE_ID )
                    // InternalSTL.g:191:3: RULE_ID
                    {
                     before(grammarAccess.getShape_ImplAccess().getIDTerminalRuleCall_3_0()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getShape_ImplAccess().getIDTerminalRuleCall_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSTL.g:196:2: ( RULE_WS )
                    {
                    // InternalSTL.g:196:2: ( RULE_WS )
                    // InternalSTL.g:197:3: RULE_WS
                    {
                     before(grammarAccess.getShape_ImplAccess().getWSTerminalRuleCall_3_1()); 
                    match(input,RULE_WS,FOLLOW_2); 
                     after(grammarAccess.getShape_ImplAccess().getWSTerminalRuleCall_3_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSTL.g:202:2: ( RULE_STRING )
                    {
                    // InternalSTL.g:202:2: ( RULE_STRING )
                    // InternalSTL.g:203:3: RULE_STRING
                    {
                     before(grammarAccess.getShape_ImplAccess().getSTRINGTerminalRuleCall_3_2()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getShape_ImplAccess().getSTRINGTerminalRuleCall_3_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSTL.g:208:2: ( RULE_DOUBLE )
                    {
                    // InternalSTL.g:208:2: ( RULE_DOUBLE )
                    // InternalSTL.g:209:3: RULE_DOUBLE
                    {
                     before(grammarAccess.getShape_ImplAccess().getDOUBLETerminalRuleCall_3_3()); 
                    match(input,RULE_DOUBLE,FOLLOW_2); 
                     after(grammarAccess.getShape_ImplAccess().getDOUBLETerminalRuleCall_3_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSTL.g:214:2: ( RULE_ANY_OTHER )
                    {
                    // InternalSTL.g:214:2: ( RULE_ANY_OTHER )
                    // InternalSTL.g:215:3: RULE_ANY_OTHER
                    {
                     before(grammarAccess.getShape_ImplAccess().getANY_OTHERTerminalRuleCall_3_4()); 
                    match(input,RULE_ANY_OTHER,FOLLOW_2); 
                     after(grammarAccess.getShape_ImplAccess().getANY_OTHERTerminalRuleCall_3_4()); 

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
    // $ANTLR end "rule__Shape_Impl__Alternatives_3"


    // $ANTLR start "rule__Shape_Impl__Alternatives_8"
    // InternalSTL.g:224:1: rule__Shape_Impl__Alternatives_8 : ( ( RULE_ID ) | ( RULE_WS ) | ( RULE_STRING ) | ( RULE_DOUBLE ) | ( RULE_ANY_OTHER ) );
    public final void rule__Shape_Impl__Alternatives_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:228:1: ( ( RULE_ID ) | ( RULE_WS ) | ( RULE_STRING ) | ( RULE_DOUBLE ) | ( RULE_ANY_OTHER ) )
            int alt2=5;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt2=1;
                }
                break;
            case RULE_WS:
                {
                alt2=2;
                }
                break;
            case RULE_STRING:
                {
                alt2=3;
                }
                break;
            case RULE_DOUBLE:
                {
                alt2=4;
                }
                break;
            case RULE_ANY_OTHER:
                {
                alt2=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalSTL.g:229:2: ( RULE_ID )
                    {
                    // InternalSTL.g:229:2: ( RULE_ID )
                    // InternalSTL.g:230:3: RULE_ID
                    {
                     before(grammarAccess.getShape_ImplAccess().getIDTerminalRuleCall_8_0()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getShape_ImplAccess().getIDTerminalRuleCall_8_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSTL.g:235:2: ( RULE_WS )
                    {
                    // InternalSTL.g:235:2: ( RULE_WS )
                    // InternalSTL.g:236:3: RULE_WS
                    {
                     before(grammarAccess.getShape_ImplAccess().getWSTerminalRuleCall_8_1()); 
                    match(input,RULE_WS,FOLLOW_2); 
                     after(grammarAccess.getShape_ImplAccess().getWSTerminalRuleCall_8_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSTL.g:241:2: ( RULE_STRING )
                    {
                    // InternalSTL.g:241:2: ( RULE_STRING )
                    // InternalSTL.g:242:3: RULE_STRING
                    {
                     before(grammarAccess.getShape_ImplAccess().getSTRINGTerminalRuleCall_8_2()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getShape_ImplAccess().getSTRINGTerminalRuleCall_8_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSTL.g:247:2: ( RULE_DOUBLE )
                    {
                    // InternalSTL.g:247:2: ( RULE_DOUBLE )
                    // InternalSTL.g:248:3: RULE_DOUBLE
                    {
                     before(grammarAccess.getShape_ImplAccess().getDOUBLETerminalRuleCall_8_3()); 
                    match(input,RULE_DOUBLE,FOLLOW_2); 
                     after(grammarAccess.getShape_ImplAccess().getDOUBLETerminalRuleCall_8_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSTL.g:253:2: ( RULE_ANY_OTHER )
                    {
                    // InternalSTL.g:253:2: ( RULE_ANY_OTHER )
                    // InternalSTL.g:254:3: RULE_ANY_OTHER
                    {
                     before(grammarAccess.getShape_ImplAccess().getANY_OTHERTerminalRuleCall_8_4()); 
                    match(input,RULE_ANY_OTHER,FOLLOW_2); 
                     after(grammarAccess.getShape_ImplAccess().getANY_OTHERTerminalRuleCall_8_4()); 

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
    // $ANTLR end "rule__Shape_Impl__Alternatives_8"


    // $ANTLR start "rule__EString__Alternatives"
    // InternalSTL.g:263:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:267:1: ( ( RULE_STRING ) | ( RULE_ID ) )
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
                    // InternalSTL.g:268:2: ( RULE_STRING )
                    {
                    // InternalSTL.g:268:2: ( RULE_STRING )
                    // InternalSTL.g:269:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSTL.g:274:2: ( RULE_ID )
                    {
                    // InternalSTL.g:274:2: ( RULE_ID )
                    // InternalSTL.g:275:3: RULE_ID
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


    // $ANTLR start "rule__Geometry__Group__0"
    // InternalSTL.g:284:1: rule__Geometry__Group__0 : rule__Geometry__Group__0__Impl rule__Geometry__Group__1 ;
    public final void rule__Geometry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:288:1: ( rule__Geometry__Group__0__Impl rule__Geometry__Group__1 )
            // InternalSTL.g:289:2: rule__Geometry__Group__0__Impl rule__Geometry__Group__1
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
    // InternalSTL.g:296:1: rule__Geometry__Group__0__Impl : ( () ) ;
    public final void rule__Geometry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:300:1: ( ( () ) )
            // InternalSTL.g:301:1: ( () )
            {
            // InternalSTL.g:301:1: ( () )
            // InternalSTL.g:302:2: ()
            {
             before(grammarAccess.getGeometryAccess().getGeometryAction_0()); 
            // InternalSTL.g:303:2: ()
            // InternalSTL.g:303:3: 
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
    // InternalSTL.g:311:1: rule__Geometry__Group__1 : rule__Geometry__Group__1__Impl ;
    public final void rule__Geometry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:315:1: ( rule__Geometry__Group__1__Impl )
            // InternalSTL.g:316:2: rule__Geometry__Group__1__Impl
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
    // InternalSTL.g:322:1: rule__Geometry__Group__1__Impl : ( ( rule__Geometry__NodesAssignment_1 )* ) ;
    public final void rule__Geometry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:326:1: ( ( ( rule__Geometry__NodesAssignment_1 )* ) )
            // InternalSTL.g:327:1: ( ( rule__Geometry__NodesAssignment_1 )* )
            {
            // InternalSTL.g:327:1: ( ( rule__Geometry__NodesAssignment_1 )* )
            // InternalSTL.g:328:2: ( rule__Geometry__NodesAssignment_1 )*
            {
             before(grammarAccess.getGeometryAccess().getNodesAssignment_1()); 
            // InternalSTL.g:329:2: ( rule__Geometry__NodesAssignment_1 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==12) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalSTL.g:329:3: rule__Geometry__NodesAssignment_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__Geometry__NodesAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
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


    // $ANTLR start "rule__Shape_Impl__Group__0"
    // InternalSTL.g:338:1: rule__Shape_Impl__Group__0 : rule__Shape_Impl__Group__0__Impl rule__Shape_Impl__Group__1 ;
    public final void rule__Shape_Impl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:342:1: ( rule__Shape_Impl__Group__0__Impl rule__Shape_Impl__Group__1 )
            // InternalSTL.g:343:2: rule__Shape_Impl__Group__0__Impl rule__Shape_Impl__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Shape_Impl__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Shape_Impl__Group__1();

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
    // $ANTLR end "rule__Shape_Impl__Group__0"


    // $ANTLR start "rule__Shape_Impl__Group__0__Impl"
    // InternalSTL.g:350:1: rule__Shape_Impl__Group__0__Impl : ( () ) ;
    public final void rule__Shape_Impl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:354:1: ( ( () ) )
            // InternalSTL.g:355:1: ( () )
            {
            // InternalSTL.g:355:1: ( () )
            // InternalSTL.g:356:2: ()
            {
             before(grammarAccess.getShape_ImplAccess().getShapeAction_0()); 
            // InternalSTL.g:357:2: ()
            // InternalSTL.g:357:3: 
            {
            }

             after(grammarAccess.getShape_ImplAccess().getShapeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Shape_Impl__Group__0__Impl"


    // $ANTLR start "rule__Shape_Impl__Group__1"
    // InternalSTL.g:365:1: rule__Shape_Impl__Group__1 : rule__Shape_Impl__Group__1__Impl rule__Shape_Impl__Group__2 ;
    public final void rule__Shape_Impl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:369:1: ( rule__Shape_Impl__Group__1__Impl rule__Shape_Impl__Group__2 )
            // InternalSTL.g:370:2: rule__Shape_Impl__Group__1__Impl rule__Shape_Impl__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Shape_Impl__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Shape_Impl__Group__2();

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
    // $ANTLR end "rule__Shape_Impl__Group__1"


    // $ANTLR start "rule__Shape_Impl__Group__1__Impl"
    // InternalSTL.g:377:1: rule__Shape_Impl__Group__1__Impl : ( 'solid' ) ;
    public final void rule__Shape_Impl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:381:1: ( ( 'solid' ) )
            // InternalSTL.g:382:1: ( 'solid' )
            {
            // InternalSTL.g:382:1: ( 'solid' )
            // InternalSTL.g:383:2: 'solid'
            {
             before(grammarAccess.getShape_ImplAccess().getSolidKeyword_1()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getShape_ImplAccess().getSolidKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Shape_Impl__Group__1__Impl"


    // $ANTLR start "rule__Shape_Impl__Group__2"
    // InternalSTL.g:392:1: rule__Shape_Impl__Group__2 : rule__Shape_Impl__Group__2__Impl rule__Shape_Impl__Group__3 ;
    public final void rule__Shape_Impl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:396:1: ( rule__Shape_Impl__Group__2__Impl rule__Shape_Impl__Group__3 )
            // InternalSTL.g:397:2: rule__Shape_Impl__Group__2__Impl rule__Shape_Impl__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__Shape_Impl__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Shape_Impl__Group__3();

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
    // $ANTLR end "rule__Shape_Impl__Group__2"


    // $ANTLR start "rule__Shape_Impl__Group__2__Impl"
    // InternalSTL.g:404:1: rule__Shape_Impl__Group__2__Impl : ( ( rule__Shape_Impl__NameAssignment_2 )? ) ;
    public final void rule__Shape_Impl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:408:1: ( ( ( rule__Shape_Impl__NameAssignment_2 )? ) )
            // InternalSTL.g:409:1: ( ( rule__Shape_Impl__NameAssignment_2 )? )
            {
            // InternalSTL.g:409:1: ( ( rule__Shape_Impl__NameAssignment_2 )? )
            // InternalSTL.g:410:2: ( rule__Shape_Impl__NameAssignment_2 )?
            {
             before(grammarAccess.getShape_ImplAccess().getNameAssignment_2()); 
            // InternalSTL.g:411:2: ( rule__Shape_Impl__NameAssignment_2 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_STRING) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalSTL.g:411:3: rule__Shape_Impl__NameAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Shape_Impl__NameAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getShape_ImplAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Shape_Impl__Group__2__Impl"


    // $ANTLR start "rule__Shape_Impl__Group__3"
    // InternalSTL.g:419:1: rule__Shape_Impl__Group__3 : rule__Shape_Impl__Group__3__Impl rule__Shape_Impl__Group__4 ;
    public final void rule__Shape_Impl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:423:1: ( rule__Shape_Impl__Group__3__Impl rule__Shape_Impl__Group__4 )
            // InternalSTL.g:424:2: rule__Shape_Impl__Group__3__Impl rule__Shape_Impl__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__Shape_Impl__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Shape_Impl__Group__4();

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
    // $ANTLR end "rule__Shape_Impl__Group__3"


    // $ANTLR start "rule__Shape_Impl__Group__3__Impl"
    // InternalSTL.g:431:1: rule__Shape_Impl__Group__3__Impl : ( ( rule__Shape_Impl__Alternatives_3 )* ) ;
    public final void rule__Shape_Impl__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:435:1: ( ( ( rule__Shape_Impl__Alternatives_3 )* ) )
            // InternalSTL.g:436:1: ( ( rule__Shape_Impl__Alternatives_3 )* )
            {
            // InternalSTL.g:436:1: ( ( rule__Shape_Impl__Alternatives_3 )* )
            // InternalSTL.g:437:2: ( rule__Shape_Impl__Alternatives_3 )*
            {
             before(grammarAccess.getShape_ImplAccess().getAlternatives_3()); 
            // InternalSTL.g:438:2: ( rule__Shape_Impl__Alternatives_3 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=RULE_ID && LA6_0<=RULE_ANY_OTHER)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalSTL.g:438:3: rule__Shape_Impl__Alternatives_3
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Shape_Impl__Alternatives_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getShape_ImplAccess().getAlternatives_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Shape_Impl__Group__3__Impl"


    // $ANTLR start "rule__Shape_Impl__Group__4"
    // InternalSTL.g:446:1: rule__Shape_Impl__Group__4 : rule__Shape_Impl__Group__4__Impl rule__Shape_Impl__Group__5 ;
    public final void rule__Shape_Impl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:450:1: ( rule__Shape_Impl__Group__4__Impl rule__Shape_Impl__Group__5 )
            // InternalSTL.g:451:2: rule__Shape_Impl__Group__4__Impl rule__Shape_Impl__Group__5
            {
            pushFollow(FOLLOW_5);
            rule__Shape_Impl__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Shape_Impl__Group__5();

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
    // $ANTLR end "rule__Shape_Impl__Group__4"


    // $ANTLR start "rule__Shape_Impl__Group__4__Impl"
    // InternalSTL.g:458:1: rule__Shape_Impl__Group__4__Impl : ( ( rule__Shape_Impl__TrianglesAssignment_4 )* ) ;
    public final void rule__Shape_Impl__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:462:1: ( ( ( rule__Shape_Impl__TrianglesAssignment_4 )* ) )
            // InternalSTL.g:463:1: ( ( rule__Shape_Impl__TrianglesAssignment_4 )* )
            {
            // InternalSTL.g:463:1: ( ( rule__Shape_Impl__TrianglesAssignment_4 )* )
            // InternalSTL.g:464:2: ( rule__Shape_Impl__TrianglesAssignment_4 )*
            {
             before(grammarAccess.getShape_ImplAccess().getTrianglesAssignment_4()); 
            // InternalSTL.g:465:2: ( rule__Shape_Impl__TrianglesAssignment_4 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==14) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalSTL.g:465:3: rule__Shape_Impl__TrianglesAssignment_4
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__Shape_Impl__TrianglesAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getShape_ImplAccess().getTrianglesAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Shape_Impl__Group__4__Impl"


    // $ANTLR start "rule__Shape_Impl__Group__5"
    // InternalSTL.g:473:1: rule__Shape_Impl__Group__5 : rule__Shape_Impl__Group__5__Impl rule__Shape_Impl__Group__6 ;
    public final void rule__Shape_Impl__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:477:1: ( rule__Shape_Impl__Group__5__Impl rule__Shape_Impl__Group__6 )
            // InternalSTL.g:478:2: rule__Shape_Impl__Group__5__Impl rule__Shape_Impl__Group__6
            {
            pushFollow(FOLLOW_5);
            rule__Shape_Impl__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Shape_Impl__Group__6();

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
    // $ANTLR end "rule__Shape_Impl__Group__5"


    // $ANTLR start "rule__Shape_Impl__Group__5__Impl"
    // InternalSTL.g:485:1: rule__Shape_Impl__Group__5__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Shape_Impl__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:489:1: ( ( ( RULE_WS )* ) )
            // InternalSTL.g:490:1: ( ( RULE_WS )* )
            {
            // InternalSTL.g:490:1: ( ( RULE_WS )* )
            // InternalSTL.g:491:2: ( RULE_WS )*
            {
             before(grammarAccess.getShape_ImplAccess().getWSTerminalRuleCall_5()); 
            // InternalSTL.g:492:2: ( RULE_WS )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_WS) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalSTL.g:492:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getShape_ImplAccess().getWSTerminalRuleCall_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Shape_Impl__Group__5__Impl"


    // $ANTLR start "rule__Shape_Impl__Group__6"
    // InternalSTL.g:500:1: rule__Shape_Impl__Group__6 : rule__Shape_Impl__Group__6__Impl rule__Shape_Impl__Group__7 ;
    public final void rule__Shape_Impl__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:504:1: ( rule__Shape_Impl__Group__6__Impl rule__Shape_Impl__Group__7 )
            // InternalSTL.g:505:2: rule__Shape_Impl__Group__6__Impl rule__Shape_Impl__Group__7
            {
            pushFollow(FOLLOW_9);
            rule__Shape_Impl__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Shape_Impl__Group__7();

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
    // $ANTLR end "rule__Shape_Impl__Group__6"


    // $ANTLR start "rule__Shape_Impl__Group__6__Impl"
    // InternalSTL.g:512:1: rule__Shape_Impl__Group__6__Impl : ( 'endsolid' ) ;
    public final void rule__Shape_Impl__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:516:1: ( ( 'endsolid' ) )
            // InternalSTL.g:517:1: ( 'endsolid' )
            {
            // InternalSTL.g:517:1: ( 'endsolid' )
            // InternalSTL.g:518:2: 'endsolid'
            {
             before(grammarAccess.getShape_ImplAccess().getEndsolidKeyword_6()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getShape_ImplAccess().getEndsolidKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Shape_Impl__Group__6__Impl"


    // $ANTLR start "rule__Shape_Impl__Group__7"
    // InternalSTL.g:527:1: rule__Shape_Impl__Group__7 : rule__Shape_Impl__Group__7__Impl rule__Shape_Impl__Group__8 ;
    public final void rule__Shape_Impl__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:531:1: ( rule__Shape_Impl__Group__7__Impl rule__Shape_Impl__Group__8 )
            // InternalSTL.g:532:2: rule__Shape_Impl__Group__7__Impl rule__Shape_Impl__Group__8
            {
            pushFollow(FOLLOW_9);
            rule__Shape_Impl__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Shape_Impl__Group__8();

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
    // $ANTLR end "rule__Shape_Impl__Group__7"


    // $ANTLR start "rule__Shape_Impl__Group__7__Impl"
    // InternalSTL.g:539:1: rule__Shape_Impl__Group__7__Impl : ( ( ruleEString )? ) ;
    public final void rule__Shape_Impl__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:543:1: ( ( ( ruleEString )? ) )
            // InternalSTL.g:544:1: ( ( ruleEString )? )
            {
            // InternalSTL.g:544:1: ( ( ruleEString )? )
            // InternalSTL.g:545:2: ( ruleEString )?
            {
             before(grammarAccess.getShape_ImplAccess().getEStringParserRuleCall_7()); 
            // InternalSTL.g:546:2: ( ruleEString )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_STRING) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalSTL.g:546:3: ruleEString
                    {
                    pushFollow(FOLLOW_2);
                    ruleEString();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getShape_ImplAccess().getEStringParserRuleCall_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Shape_Impl__Group__7__Impl"


    // $ANTLR start "rule__Shape_Impl__Group__8"
    // InternalSTL.g:554:1: rule__Shape_Impl__Group__8 : rule__Shape_Impl__Group__8__Impl ;
    public final void rule__Shape_Impl__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:558:1: ( rule__Shape_Impl__Group__8__Impl )
            // InternalSTL.g:559:2: rule__Shape_Impl__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Shape_Impl__Group__8__Impl();

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
    // $ANTLR end "rule__Shape_Impl__Group__8"


    // $ANTLR start "rule__Shape_Impl__Group__8__Impl"
    // InternalSTL.g:565:1: rule__Shape_Impl__Group__8__Impl : ( ( rule__Shape_Impl__Alternatives_8 )* ) ;
    public final void rule__Shape_Impl__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:569:1: ( ( ( rule__Shape_Impl__Alternatives_8 )* ) )
            // InternalSTL.g:570:1: ( ( rule__Shape_Impl__Alternatives_8 )* )
            {
            // InternalSTL.g:570:1: ( ( rule__Shape_Impl__Alternatives_8 )* )
            // InternalSTL.g:571:2: ( rule__Shape_Impl__Alternatives_8 )*
            {
             before(grammarAccess.getShape_ImplAccess().getAlternatives_8()); 
            // InternalSTL.g:572:2: ( rule__Shape_Impl__Alternatives_8 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=RULE_ID && LA10_0<=RULE_ANY_OTHER)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalSTL.g:572:3: rule__Shape_Impl__Alternatives_8
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Shape_Impl__Alternatives_8();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getShape_ImplAccess().getAlternatives_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Shape_Impl__Group__8__Impl"


    // $ANTLR start "rule__Triangle__Group__0"
    // InternalSTL.g:581:1: rule__Triangle__Group__0 : rule__Triangle__Group__0__Impl rule__Triangle__Group__1 ;
    public final void rule__Triangle__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:585:1: ( rule__Triangle__Group__0__Impl rule__Triangle__Group__1 )
            // InternalSTL.g:586:2: rule__Triangle__Group__0__Impl rule__Triangle__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__Triangle__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Triangle__Group__1();

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
    // $ANTLR end "rule__Triangle__Group__0"


    // $ANTLR start "rule__Triangle__Group__0__Impl"
    // InternalSTL.g:593:1: rule__Triangle__Group__0__Impl : ( () ) ;
    public final void rule__Triangle__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:597:1: ( ( () ) )
            // InternalSTL.g:598:1: ( () )
            {
            // InternalSTL.g:598:1: ( () )
            // InternalSTL.g:599:2: ()
            {
             before(grammarAccess.getTriangleAccess().getTriangleAction_0()); 
            // InternalSTL.g:600:2: ()
            // InternalSTL.g:600:3: 
            {
            }

             after(grammarAccess.getTriangleAccess().getTriangleAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Triangle__Group__0__Impl"


    // $ANTLR start "rule__Triangle__Group__1"
    // InternalSTL.g:608:1: rule__Triangle__Group__1 : rule__Triangle__Group__1__Impl rule__Triangle__Group__2 ;
    public final void rule__Triangle__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:612:1: ( rule__Triangle__Group__1__Impl rule__Triangle__Group__2 )
            // InternalSTL.g:613:2: rule__Triangle__Group__1__Impl rule__Triangle__Group__2
            {
            pushFollow(FOLLOW_11);
            rule__Triangle__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Triangle__Group__2();

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
    // $ANTLR end "rule__Triangle__Group__1"


    // $ANTLR start "rule__Triangle__Group__1__Impl"
    // InternalSTL.g:620:1: rule__Triangle__Group__1__Impl : ( 'facet' ) ;
    public final void rule__Triangle__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:624:1: ( ( 'facet' ) )
            // InternalSTL.g:625:1: ( 'facet' )
            {
            // InternalSTL.g:625:1: ( 'facet' )
            // InternalSTL.g:626:2: 'facet'
            {
             before(grammarAccess.getTriangleAccess().getFacetKeyword_1()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getTriangleAccess().getFacetKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Triangle__Group__1__Impl"


    // $ANTLR start "rule__Triangle__Group__2"
    // InternalSTL.g:635:1: rule__Triangle__Group__2 : rule__Triangle__Group__2__Impl rule__Triangle__Group__3 ;
    public final void rule__Triangle__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:639:1: ( rule__Triangle__Group__2__Impl rule__Triangle__Group__3 )
            // InternalSTL.g:640:2: rule__Triangle__Group__2__Impl rule__Triangle__Group__3
            {
            pushFollow(FOLLOW_12);
            rule__Triangle__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Triangle__Group__3();

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
    // $ANTLR end "rule__Triangle__Group__2"


    // $ANTLR start "rule__Triangle__Group__2__Impl"
    // InternalSTL.g:647:1: rule__Triangle__Group__2__Impl : ( ( rule__Triangle__Group_2__0 ) ) ;
    public final void rule__Triangle__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:651:1: ( ( ( rule__Triangle__Group_2__0 ) ) )
            // InternalSTL.g:652:1: ( ( rule__Triangle__Group_2__0 ) )
            {
            // InternalSTL.g:652:1: ( ( rule__Triangle__Group_2__0 ) )
            // InternalSTL.g:653:2: ( rule__Triangle__Group_2__0 )
            {
             before(grammarAccess.getTriangleAccess().getGroup_2()); 
            // InternalSTL.g:654:2: ( rule__Triangle__Group_2__0 )
            // InternalSTL.g:654:3: rule__Triangle__Group_2__0
            {
            pushFollow(FOLLOW_2);
            rule__Triangle__Group_2__0();

            state._fsp--;


            }

             after(grammarAccess.getTriangleAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Triangle__Group__2__Impl"


    // $ANTLR start "rule__Triangle__Group__3"
    // InternalSTL.g:662:1: rule__Triangle__Group__3 : rule__Triangle__Group__3__Impl rule__Triangle__Group__4 ;
    public final void rule__Triangle__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:666:1: ( rule__Triangle__Group__3__Impl rule__Triangle__Group__4 )
            // InternalSTL.g:667:2: rule__Triangle__Group__3__Impl rule__Triangle__Group__4
            {
            pushFollow(FOLLOW_13);
            rule__Triangle__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Triangle__Group__4();

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
    // $ANTLR end "rule__Triangle__Group__3"


    // $ANTLR start "rule__Triangle__Group__3__Impl"
    // InternalSTL.g:674:1: rule__Triangle__Group__3__Impl : ( 'outer' ) ;
    public final void rule__Triangle__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:678:1: ( ( 'outer' ) )
            // InternalSTL.g:679:1: ( 'outer' )
            {
            // InternalSTL.g:679:1: ( 'outer' )
            // InternalSTL.g:680:2: 'outer'
            {
             before(grammarAccess.getTriangleAccess().getOuterKeyword_3()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getTriangleAccess().getOuterKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Triangle__Group__3__Impl"


    // $ANTLR start "rule__Triangle__Group__4"
    // InternalSTL.g:689:1: rule__Triangle__Group__4 : rule__Triangle__Group__4__Impl rule__Triangle__Group__5 ;
    public final void rule__Triangle__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:693:1: ( rule__Triangle__Group__4__Impl rule__Triangle__Group__5 )
            // InternalSTL.g:694:2: rule__Triangle__Group__4__Impl rule__Triangle__Group__5
            {
            pushFollow(FOLLOW_14);
            rule__Triangle__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Triangle__Group__5();

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
    // $ANTLR end "rule__Triangle__Group__4"


    // $ANTLR start "rule__Triangle__Group__4__Impl"
    // InternalSTL.g:701:1: rule__Triangle__Group__4__Impl : ( 'loop' ) ;
    public final void rule__Triangle__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:705:1: ( ( 'loop' ) )
            // InternalSTL.g:706:1: ( 'loop' )
            {
            // InternalSTL.g:706:1: ( 'loop' )
            // InternalSTL.g:707:2: 'loop'
            {
             before(grammarAccess.getTriangleAccess().getLoopKeyword_4()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getTriangleAccess().getLoopKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Triangle__Group__4__Impl"


    // $ANTLR start "rule__Triangle__Group__5"
    // InternalSTL.g:716:1: rule__Triangle__Group__5 : rule__Triangle__Group__5__Impl rule__Triangle__Group__6 ;
    public final void rule__Triangle__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:720:1: ( rule__Triangle__Group__5__Impl rule__Triangle__Group__6 )
            // InternalSTL.g:721:2: rule__Triangle__Group__5__Impl rule__Triangle__Group__6
            {
            pushFollow(FOLLOW_14);
            rule__Triangle__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Triangle__Group__6();

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
    // $ANTLR end "rule__Triangle__Group__5"


    // $ANTLR start "rule__Triangle__Group__5__Impl"
    // InternalSTL.g:728:1: rule__Triangle__Group__5__Impl : ( ( rule__Triangle__Group_5__0 )* ) ;
    public final void rule__Triangle__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:732:1: ( ( ( rule__Triangle__Group_5__0 )* ) )
            // InternalSTL.g:733:1: ( ( rule__Triangle__Group_5__0 )* )
            {
            // InternalSTL.g:733:1: ( ( rule__Triangle__Group_5__0 )* )
            // InternalSTL.g:734:2: ( rule__Triangle__Group_5__0 )*
            {
             before(grammarAccess.getTriangleAccess().getGroup_5()); 
            // InternalSTL.g:735:2: ( rule__Triangle__Group_5__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==20) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalSTL.g:735:3: rule__Triangle__Group_5__0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__Triangle__Group_5__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getTriangleAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Triangle__Group__5__Impl"


    // $ANTLR start "rule__Triangle__Group__6"
    // InternalSTL.g:743:1: rule__Triangle__Group__6 : rule__Triangle__Group__6__Impl rule__Triangle__Group__7 ;
    public final void rule__Triangle__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:747:1: ( rule__Triangle__Group__6__Impl rule__Triangle__Group__7 )
            // InternalSTL.g:748:2: rule__Triangle__Group__6__Impl rule__Triangle__Group__7
            {
            pushFollow(FOLLOW_16);
            rule__Triangle__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Triangle__Group__7();

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
    // $ANTLR end "rule__Triangle__Group__6"


    // $ANTLR start "rule__Triangle__Group__6__Impl"
    // InternalSTL.g:755:1: rule__Triangle__Group__6__Impl : ( 'endloop' ) ;
    public final void rule__Triangle__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:759:1: ( ( 'endloop' ) )
            // InternalSTL.g:760:1: ( 'endloop' )
            {
            // InternalSTL.g:760:1: ( 'endloop' )
            // InternalSTL.g:761:2: 'endloop'
            {
             before(grammarAccess.getTriangleAccess().getEndloopKeyword_6()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getTriangleAccess().getEndloopKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Triangle__Group__6__Impl"


    // $ANTLR start "rule__Triangle__Group__7"
    // InternalSTL.g:770:1: rule__Triangle__Group__7 : rule__Triangle__Group__7__Impl ;
    public final void rule__Triangle__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:774:1: ( rule__Triangle__Group__7__Impl )
            // InternalSTL.g:775:2: rule__Triangle__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Triangle__Group__7__Impl();

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
    // $ANTLR end "rule__Triangle__Group__7"


    // $ANTLR start "rule__Triangle__Group__7__Impl"
    // InternalSTL.g:781:1: rule__Triangle__Group__7__Impl : ( 'endfacet' ) ;
    public final void rule__Triangle__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:785:1: ( ( 'endfacet' ) )
            // InternalSTL.g:786:1: ( 'endfacet' )
            {
            // InternalSTL.g:786:1: ( 'endfacet' )
            // InternalSTL.g:787:2: 'endfacet'
            {
             before(grammarAccess.getTriangleAccess().getEndfacetKeyword_7()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getTriangleAccess().getEndfacetKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Triangle__Group__7__Impl"


    // $ANTLR start "rule__Triangle__Group_2__0"
    // InternalSTL.g:797:1: rule__Triangle__Group_2__0 : rule__Triangle__Group_2__0__Impl rule__Triangle__Group_2__1 ;
    public final void rule__Triangle__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:801:1: ( rule__Triangle__Group_2__0__Impl rule__Triangle__Group_2__1 )
            // InternalSTL.g:802:2: rule__Triangle__Group_2__0__Impl rule__Triangle__Group_2__1
            {
            pushFollow(FOLLOW_17);
            rule__Triangle__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Triangle__Group_2__1();

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
    // $ANTLR end "rule__Triangle__Group_2__0"


    // $ANTLR start "rule__Triangle__Group_2__0__Impl"
    // InternalSTL.g:809:1: rule__Triangle__Group_2__0__Impl : ( 'normal' ) ;
    public final void rule__Triangle__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:813:1: ( ( 'normal' ) )
            // InternalSTL.g:814:1: ( 'normal' )
            {
            // InternalSTL.g:814:1: ( 'normal' )
            // InternalSTL.g:815:2: 'normal'
            {
             before(grammarAccess.getTriangleAccess().getNormalKeyword_2_0()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getTriangleAccess().getNormalKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Triangle__Group_2__0__Impl"


    // $ANTLR start "rule__Triangle__Group_2__1"
    // InternalSTL.g:824:1: rule__Triangle__Group_2__1 : rule__Triangle__Group_2__1__Impl ;
    public final void rule__Triangle__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:828:1: ( rule__Triangle__Group_2__1__Impl )
            // InternalSTL.g:829:2: rule__Triangle__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Triangle__Group_2__1__Impl();

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
    // $ANTLR end "rule__Triangle__Group_2__1"


    // $ANTLR start "rule__Triangle__Group_2__1__Impl"
    // InternalSTL.g:835:1: rule__Triangle__Group_2__1__Impl : ( ( rule__Triangle__NormalAssignment_2_1 ) ) ;
    public final void rule__Triangle__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:839:1: ( ( ( rule__Triangle__NormalAssignment_2_1 ) ) )
            // InternalSTL.g:840:1: ( ( rule__Triangle__NormalAssignment_2_1 ) )
            {
            // InternalSTL.g:840:1: ( ( rule__Triangle__NormalAssignment_2_1 ) )
            // InternalSTL.g:841:2: ( rule__Triangle__NormalAssignment_2_1 )
            {
             before(grammarAccess.getTriangleAccess().getNormalAssignment_2_1()); 
            // InternalSTL.g:842:2: ( rule__Triangle__NormalAssignment_2_1 )
            // InternalSTL.g:842:3: rule__Triangle__NormalAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Triangle__NormalAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getTriangleAccess().getNormalAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Triangle__Group_2__1__Impl"


    // $ANTLR start "rule__Triangle__Group_5__0"
    // InternalSTL.g:851:1: rule__Triangle__Group_5__0 : rule__Triangle__Group_5__0__Impl rule__Triangle__Group_5__1 ;
    public final void rule__Triangle__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:855:1: ( rule__Triangle__Group_5__0__Impl rule__Triangle__Group_5__1 )
            // InternalSTL.g:856:2: rule__Triangle__Group_5__0__Impl rule__Triangle__Group_5__1
            {
            pushFollow(FOLLOW_17);
            rule__Triangle__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Triangle__Group_5__1();

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
    // $ANTLR end "rule__Triangle__Group_5__0"


    // $ANTLR start "rule__Triangle__Group_5__0__Impl"
    // InternalSTL.g:863:1: rule__Triangle__Group_5__0__Impl : ( 'vertex' ) ;
    public final void rule__Triangle__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:867:1: ( ( 'vertex' ) )
            // InternalSTL.g:868:1: ( 'vertex' )
            {
            // InternalSTL.g:868:1: ( 'vertex' )
            // InternalSTL.g:869:2: 'vertex'
            {
             before(grammarAccess.getTriangleAccess().getVertexKeyword_5_0()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getTriangleAccess().getVertexKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Triangle__Group_5__0__Impl"


    // $ANTLR start "rule__Triangle__Group_5__1"
    // InternalSTL.g:878:1: rule__Triangle__Group_5__1 : rule__Triangle__Group_5__1__Impl ;
    public final void rule__Triangle__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:882:1: ( rule__Triangle__Group_5__1__Impl )
            // InternalSTL.g:883:2: rule__Triangle__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Triangle__Group_5__1__Impl();

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
    // $ANTLR end "rule__Triangle__Group_5__1"


    // $ANTLR start "rule__Triangle__Group_5__1__Impl"
    // InternalSTL.g:889:1: rule__Triangle__Group_5__1__Impl : ( ( rule__Triangle__VerticesAssignment_5_1 ) ) ;
    public final void rule__Triangle__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:893:1: ( ( ( rule__Triangle__VerticesAssignment_5_1 ) ) )
            // InternalSTL.g:894:1: ( ( rule__Triangle__VerticesAssignment_5_1 ) )
            {
            // InternalSTL.g:894:1: ( ( rule__Triangle__VerticesAssignment_5_1 ) )
            // InternalSTL.g:895:2: ( rule__Triangle__VerticesAssignment_5_1 )
            {
             before(grammarAccess.getTriangleAccess().getVerticesAssignment_5_1()); 
            // InternalSTL.g:896:2: ( rule__Triangle__VerticesAssignment_5_1 )
            // InternalSTL.g:896:3: rule__Triangle__VerticesAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__Triangle__VerticesAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getTriangleAccess().getVerticesAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Triangle__Group_5__1__Impl"


    // $ANTLR start "rule__Vertex__Group__0"
    // InternalSTL.g:905:1: rule__Vertex__Group__0 : rule__Vertex__Group__0__Impl rule__Vertex__Group__1 ;
    public final void rule__Vertex__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:909:1: ( rule__Vertex__Group__0__Impl rule__Vertex__Group__1 )
            // InternalSTL.g:910:2: rule__Vertex__Group__0__Impl rule__Vertex__Group__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalSTL.g:917:1: rule__Vertex__Group__0__Impl : ( () ) ;
    public final void rule__Vertex__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:921:1: ( ( () ) )
            // InternalSTL.g:922:1: ( () )
            {
            // InternalSTL.g:922:1: ( () )
            // InternalSTL.g:923:2: ()
            {
             before(grammarAccess.getVertexAccess().getVertexAction_0()); 
            // InternalSTL.g:924:2: ()
            // InternalSTL.g:924:3: 
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
    // InternalSTL.g:932:1: rule__Vertex__Group__1 : rule__Vertex__Group__1__Impl rule__Vertex__Group__2 ;
    public final void rule__Vertex__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:936:1: ( rule__Vertex__Group__1__Impl rule__Vertex__Group__2 )
            // InternalSTL.g:937:2: rule__Vertex__Group__1__Impl rule__Vertex__Group__2
            {
            pushFollow(FOLLOW_17);
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
    // InternalSTL.g:944:1: rule__Vertex__Group__1__Impl : ( ( rule__Vertex__XAssignment_1 ) ) ;
    public final void rule__Vertex__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:948:1: ( ( ( rule__Vertex__XAssignment_1 ) ) )
            // InternalSTL.g:949:1: ( ( rule__Vertex__XAssignment_1 ) )
            {
            // InternalSTL.g:949:1: ( ( rule__Vertex__XAssignment_1 ) )
            // InternalSTL.g:950:2: ( rule__Vertex__XAssignment_1 )
            {
             before(grammarAccess.getVertexAccess().getXAssignment_1()); 
            // InternalSTL.g:951:2: ( rule__Vertex__XAssignment_1 )
            // InternalSTL.g:951:3: rule__Vertex__XAssignment_1
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
    // InternalSTL.g:959:1: rule__Vertex__Group__2 : rule__Vertex__Group__2__Impl rule__Vertex__Group__3 ;
    public final void rule__Vertex__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:963:1: ( rule__Vertex__Group__2__Impl rule__Vertex__Group__3 )
            // InternalSTL.g:964:2: rule__Vertex__Group__2__Impl rule__Vertex__Group__3
            {
            pushFollow(FOLLOW_17);
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
    // InternalSTL.g:971:1: rule__Vertex__Group__2__Impl : ( ( rule__Vertex__YAssignment_2 ) ) ;
    public final void rule__Vertex__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:975:1: ( ( ( rule__Vertex__YAssignment_2 ) ) )
            // InternalSTL.g:976:1: ( ( rule__Vertex__YAssignment_2 ) )
            {
            // InternalSTL.g:976:1: ( ( rule__Vertex__YAssignment_2 ) )
            // InternalSTL.g:977:2: ( rule__Vertex__YAssignment_2 )
            {
             before(grammarAccess.getVertexAccess().getYAssignment_2()); 
            // InternalSTL.g:978:2: ( rule__Vertex__YAssignment_2 )
            // InternalSTL.g:978:3: rule__Vertex__YAssignment_2
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
    // InternalSTL.g:986:1: rule__Vertex__Group__3 : rule__Vertex__Group__3__Impl ;
    public final void rule__Vertex__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:990:1: ( rule__Vertex__Group__3__Impl )
            // InternalSTL.g:991:2: rule__Vertex__Group__3__Impl
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
    // InternalSTL.g:997:1: rule__Vertex__Group__3__Impl : ( ( rule__Vertex__ZAssignment_3 ) ) ;
    public final void rule__Vertex__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1001:1: ( ( ( rule__Vertex__ZAssignment_3 ) ) )
            // InternalSTL.g:1002:1: ( ( rule__Vertex__ZAssignment_3 ) )
            {
            // InternalSTL.g:1002:1: ( ( rule__Vertex__ZAssignment_3 ) )
            // InternalSTL.g:1003:2: ( rule__Vertex__ZAssignment_3 )
            {
             before(grammarAccess.getVertexAccess().getZAssignment_3()); 
            // InternalSTL.g:1004:2: ( rule__Vertex__ZAssignment_3 )
            // InternalSTL.g:1004:3: rule__Vertex__ZAssignment_3
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


    // $ANTLR start "rule__Geometry__NodesAssignment_1"
    // InternalSTL.g:1013:1: rule__Geometry__NodesAssignment_1 : ( ruleShape_Impl ) ;
    public final void rule__Geometry__NodesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1017:1: ( ( ruleShape_Impl ) )
            // InternalSTL.g:1018:2: ( ruleShape_Impl )
            {
            // InternalSTL.g:1018:2: ( ruleShape_Impl )
            // InternalSTL.g:1019:3: ruleShape_Impl
            {
             before(grammarAccess.getGeometryAccess().getNodesShape_ImplParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleShape_Impl();

            state._fsp--;

             after(grammarAccess.getGeometryAccess().getNodesShape_ImplParserRuleCall_1_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__Shape_Impl__NameAssignment_2"
    // InternalSTL.g:1028:1: rule__Shape_Impl__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Shape_Impl__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1032:1: ( ( ruleEString ) )
            // InternalSTL.g:1033:2: ( ruleEString )
            {
            // InternalSTL.g:1033:2: ( ruleEString )
            // InternalSTL.g:1034:3: ruleEString
            {
             before(grammarAccess.getShape_ImplAccess().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getShape_ImplAccess().getNameEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Shape_Impl__NameAssignment_2"


    // $ANTLR start "rule__Shape_Impl__TrianglesAssignment_4"
    // InternalSTL.g:1043:1: rule__Shape_Impl__TrianglesAssignment_4 : ( ruleTriangle ) ;
    public final void rule__Shape_Impl__TrianglesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1047:1: ( ( ruleTriangle ) )
            // InternalSTL.g:1048:2: ( ruleTriangle )
            {
            // InternalSTL.g:1048:2: ( ruleTriangle )
            // InternalSTL.g:1049:3: ruleTriangle
            {
             before(grammarAccess.getShape_ImplAccess().getTrianglesTriangleParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleTriangle();

            state._fsp--;

             after(grammarAccess.getShape_ImplAccess().getTrianglesTriangleParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Shape_Impl__TrianglesAssignment_4"


    // $ANTLR start "rule__Triangle__NormalAssignment_2_1"
    // InternalSTL.g:1058:1: rule__Triangle__NormalAssignment_2_1 : ( ruleVertex ) ;
    public final void rule__Triangle__NormalAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1062:1: ( ( ruleVertex ) )
            // InternalSTL.g:1063:2: ( ruleVertex )
            {
            // InternalSTL.g:1063:2: ( ruleVertex )
            // InternalSTL.g:1064:3: ruleVertex
            {
             before(grammarAccess.getTriangleAccess().getNormalVertexParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleVertex();

            state._fsp--;

             after(grammarAccess.getTriangleAccess().getNormalVertexParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Triangle__NormalAssignment_2_1"


    // $ANTLR start "rule__Triangle__VerticesAssignment_5_1"
    // InternalSTL.g:1073:1: rule__Triangle__VerticesAssignment_5_1 : ( ruleVertex ) ;
    public final void rule__Triangle__VerticesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1077:1: ( ( ruleVertex ) )
            // InternalSTL.g:1078:2: ( ruleVertex )
            {
            // InternalSTL.g:1078:2: ( ruleVertex )
            // InternalSTL.g:1079:3: ruleVertex
            {
             before(grammarAccess.getTriangleAccess().getVerticesVertexParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleVertex();

            state._fsp--;

             after(grammarAccess.getTriangleAccess().getVerticesVertexParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Triangle__VerticesAssignment_5_1"


    // $ANTLR start "rule__Vertex__XAssignment_1"
    // InternalSTL.g:1088:1: rule__Vertex__XAssignment_1 : ( RULE_DOUBLE ) ;
    public final void rule__Vertex__XAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1092:1: ( ( RULE_DOUBLE ) )
            // InternalSTL.g:1093:2: ( RULE_DOUBLE )
            {
            // InternalSTL.g:1093:2: ( RULE_DOUBLE )
            // InternalSTL.g:1094:3: RULE_DOUBLE
            {
             before(grammarAccess.getVertexAccess().getXDOUBLETerminalRuleCall_1_0()); 
            match(input,RULE_DOUBLE,FOLLOW_2); 
             after(grammarAccess.getVertexAccess().getXDOUBLETerminalRuleCall_1_0()); 

            }


            }

        }
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
    // InternalSTL.g:1103:1: rule__Vertex__YAssignment_2 : ( RULE_DOUBLE ) ;
    public final void rule__Vertex__YAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1107:1: ( ( RULE_DOUBLE ) )
            // InternalSTL.g:1108:2: ( RULE_DOUBLE )
            {
            // InternalSTL.g:1108:2: ( RULE_DOUBLE )
            // InternalSTL.g:1109:3: RULE_DOUBLE
            {
             before(grammarAccess.getVertexAccess().getYDOUBLETerminalRuleCall_2_0()); 
            match(input,RULE_DOUBLE,FOLLOW_2); 
             after(grammarAccess.getVertexAccess().getYDOUBLETerminalRuleCall_2_0()); 

            }


            }

        }
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
    // InternalSTL.g:1118:1: rule__Vertex__ZAssignment_3 : ( RULE_DOUBLE ) ;
    public final void rule__Vertex__ZAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1122:1: ( ( RULE_DOUBLE ) )
            // InternalSTL.g:1123:2: ( RULE_DOUBLE )
            {
            // InternalSTL.g:1123:2: ( RULE_DOUBLE )
            // InternalSTL.g:1124:3: RULE_DOUBLE
            {
             before(grammarAccess.getVertexAccess().getZDOUBLETerminalRuleCall_3_0()); 
            match(input,RULE_DOUBLE,FOLLOW_2); 
             after(grammarAccess.getVertexAccess().getZDOUBLETerminalRuleCall_3_0()); 

            }


            }

        }
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


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000000061F0L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000000001F2L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000080L});

}