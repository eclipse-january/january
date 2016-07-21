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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_WS", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ANY_OTHER", "'-'", "'+'", "'E'", "'e'", "'solid'", "'endsolid'", "'facet'", "'outer'", "'loop'", "'endloop'", "'endfacet'", "'normal'", "'vertex'", "'.'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=7;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__20=20;
    public static final int T__21=21;

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


    // $ANTLR start "entryRuleEDouble"
    // InternalSTL.g:161:1: entryRuleEDouble : ruleEDouble EOF ;
    public final void entryRuleEDouble() throws RecognitionException {
        try {
            // InternalSTL.g:162:1: ( ruleEDouble EOF )
            // InternalSTL.g:163:1: ruleEDouble EOF
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
    // InternalSTL.g:170:1: ruleEDouble : ( ( rule__EDouble__Group__0 ) ) ;
    public final void ruleEDouble() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:174:2: ( ( ( rule__EDouble__Group__0 ) ) )
            // InternalSTL.g:175:2: ( ( rule__EDouble__Group__0 ) )
            {
            // InternalSTL.g:175:2: ( ( rule__EDouble__Group__0 ) )
            // InternalSTL.g:176:3: ( rule__EDouble__Group__0 )
            {
             before(grammarAccess.getEDoubleAccess().getGroup()); 
            // InternalSTL.g:177:3: ( rule__EDouble__Group__0 )
            // InternalSTL.g:177:4: rule__EDouble__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EDouble__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEDoubleAccess().getGroup()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleEString"
    // InternalSTL.g:186:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalSTL.g:187:1: ( ruleEString EOF )
            // InternalSTL.g:188:1: ruleEString EOF
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
    // InternalSTL.g:195:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:199:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalSTL.g:200:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalSTL.g:200:2: ( ( rule__EString__Alternatives ) )
            // InternalSTL.g:201:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalSTL.g:202:3: ( rule__EString__Alternatives )
            // InternalSTL.g:202:4: rule__EString__Alternatives
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
    // InternalSTL.g:210:1: rule__Shape_Impl__Alternatives_3 : ( ( RULE_ID ) | ( RULE_WS ) | ( RULE_STRING ) | ( RULE_INT ) );
    public final void rule__Shape_Impl__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:214:1: ( ( RULE_ID ) | ( RULE_WS ) | ( RULE_STRING ) | ( RULE_INT ) )
            int alt1=4;
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
            case RULE_INT:
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalSTL.g:215:2: ( RULE_ID )
                    {
                    // InternalSTL.g:215:2: ( RULE_ID )
                    // InternalSTL.g:216:3: RULE_ID
                    {
                     before(grammarAccess.getShape_ImplAccess().getIDTerminalRuleCall_3_0()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getShape_ImplAccess().getIDTerminalRuleCall_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSTL.g:221:2: ( RULE_WS )
                    {
                    // InternalSTL.g:221:2: ( RULE_WS )
                    // InternalSTL.g:222:3: RULE_WS
                    {
                     before(grammarAccess.getShape_ImplAccess().getWSTerminalRuleCall_3_1()); 
                    match(input,RULE_WS,FOLLOW_2); 
                     after(grammarAccess.getShape_ImplAccess().getWSTerminalRuleCall_3_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSTL.g:227:2: ( RULE_STRING )
                    {
                    // InternalSTL.g:227:2: ( RULE_STRING )
                    // InternalSTL.g:228:3: RULE_STRING
                    {
                     before(grammarAccess.getShape_ImplAccess().getSTRINGTerminalRuleCall_3_2()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getShape_ImplAccess().getSTRINGTerminalRuleCall_3_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSTL.g:233:2: ( RULE_INT )
                    {
                    // InternalSTL.g:233:2: ( RULE_INT )
                    // InternalSTL.g:234:3: RULE_INT
                    {
                     before(grammarAccess.getShape_ImplAccess().getINTTerminalRuleCall_3_3()); 
                    match(input,RULE_INT,FOLLOW_2); 
                     after(grammarAccess.getShape_ImplAccess().getINTTerminalRuleCall_3_3()); 

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
    // InternalSTL.g:243:1: rule__Shape_Impl__Alternatives_8 : ( ( RULE_ID ) | ( RULE_WS ) | ( RULE_STRING ) | ( RULE_INT ) );
    public final void rule__Shape_Impl__Alternatives_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:247:1: ( ( RULE_ID ) | ( RULE_WS ) | ( RULE_STRING ) | ( RULE_INT ) )
            int alt2=4;
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
            case RULE_INT:
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
                    // InternalSTL.g:248:2: ( RULE_ID )
                    {
                    // InternalSTL.g:248:2: ( RULE_ID )
                    // InternalSTL.g:249:3: RULE_ID
                    {
                     before(grammarAccess.getShape_ImplAccess().getIDTerminalRuleCall_8_0()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getShape_ImplAccess().getIDTerminalRuleCall_8_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSTL.g:254:2: ( RULE_WS )
                    {
                    // InternalSTL.g:254:2: ( RULE_WS )
                    // InternalSTL.g:255:3: RULE_WS
                    {
                     before(grammarAccess.getShape_ImplAccess().getWSTerminalRuleCall_8_1()); 
                    match(input,RULE_WS,FOLLOW_2); 
                     after(grammarAccess.getShape_ImplAccess().getWSTerminalRuleCall_8_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSTL.g:260:2: ( RULE_STRING )
                    {
                    // InternalSTL.g:260:2: ( RULE_STRING )
                    // InternalSTL.g:261:3: RULE_STRING
                    {
                     before(grammarAccess.getShape_ImplAccess().getSTRINGTerminalRuleCall_8_2()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getShape_ImplAccess().getSTRINGTerminalRuleCall_8_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSTL.g:266:2: ( RULE_INT )
                    {
                    // InternalSTL.g:266:2: ( RULE_INT )
                    // InternalSTL.g:267:3: RULE_INT
                    {
                     before(grammarAccess.getShape_ImplAccess().getINTTerminalRuleCall_8_3()); 
                    match(input,RULE_INT,FOLLOW_2); 
                     after(grammarAccess.getShape_ImplAccess().getINTTerminalRuleCall_8_3()); 

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


    // $ANTLR start "rule__EDouble__Alternatives_0"
    // InternalSTL.g:276:1: rule__EDouble__Alternatives_0 : ( ( '-' ) | ( '+' ) );
    public final void rule__EDouble__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:280:1: ( ( '-' ) | ( '+' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            else if ( (LA3_0==12) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalSTL.g:281:2: ( '-' )
                    {
                    // InternalSTL.g:281:2: ( '-' )
                    // InternalSTL.g:282:3: '-'
                    {
                     before(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSTL.g:287:2: ( '+' )
                    {
                    // InternalSTL.g:287:2: ( '+' )
                    // InternalSTL.g:288:3: '+'
                    {
                     before(grammarAccess.getEDoubleAccess().getPlusSignKeyword_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getEDoubleAccess().getPlusSignKeyword_0_1()); 

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
    // $ANTLR end "rule__EDouble__Alternatives_0"


    // $ANTLR start "rule__EDouble__Alternatives_4_0"
    // InternalSTL.g:297:1: rule__EDouble__Alternatives_4_0 : ( ( 'E' ) | ( 'e' ) );
    public final void rule__EDouble__Alternatives_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:301:1: ( ( 'E' ) | ( 'e' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
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
                    // InternalSTL.g:302:2: ( 'E' )
                    {
                    // InternalSTL.g:302:2: ( 'E' )
                    // InternalSTL.g:303:3: 'E'
                    {
                     before(grammarAccess.getEDoubleAccess().getEKeyword_4_0_0()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getEDoubleAccess().getEKeyword_4_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSTL.g:308:2: ( 'e' )
                    {
                    // InternalSTL.g:308:2: ( 'e' )
                    // InternalSTL.g:309:3: 'e'
                    {
                     before(grammarAccess.getEDoubleAccess().getEKeyword_4_0_1()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getEDoubleAccess().getEKeyword_4_0_1()); 

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
    // $ANTLR end "rule__EDouble__Alternatives_4_0"


    // $ANTLR start "rule__EDouble__Alternatives_4_1"
    // InternalSTL.g:318:1: rule__EDouble__Alternatives_4_1 : ( ( '-' ) | ( '+' ) );
    public final void rule__EDouble__Alternatives_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:322:1: ( ( '-' ) | ( '+' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==11) ) {
                alt5=1;
            }
            else if ( (LA5_0==12) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalSTL.g:323:2: ( '-' )
                    {
                    // InternalSTL.g:323:2: ( '-' )
                    // InternalSTL.g:324:3: '-'
                    {
                     before(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_4_1_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_4_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSTL.g:329:2: ( '+' )
                    {
                    // InternalSTL.g:329:2: ( '+' )
                    // InternalSTL.g:330:3: '+'
                    {
                     before(grammarAccess.getEDoubleAccess().getPlusSignKeyword_4_1_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getEDoubleAccess().getPlusSignKeyword_4_1_1()); 

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
    // $ANTLR end "rule__EDouble__Alternatives_4_1"


    // $ANTLR start "rule__EString__Alternatives"
    // InternalSTL.g:339:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:343:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_ID) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalSTL.g:344:2: ( RULE_STRING )
                    {
                    // InternalSTL.g:344:2: ( RULE_STRING )
                    // InternalSTL.g:345:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSTL.g:350:2: ( RULE_ID )
                    {
                    // InternalSTL.g:350:2: ( RULE_ID )
                    // InternalSTL.g:351:3: RULE_ID
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
    // InternalSTL.g:360:1: rule__Geometry__Group__0 : rule__Geometry__Group__0__Impl rule__Geometry__Group__1 ;
    public final void rule__Geometry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:364:1: ( rule__Geometry__Group__0__Impl rule__Geometry__Group__1 )
            // InternalSTL.g:365:2: rule__Geometry__Group__0__Impl rule__Geometry__Group__1
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
    // InternalSTL.g:372:1: rule__Geometry__Group__0__Impl : ( () ) ;
    public final void rule__Geometry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:376:1: ( ( () ) )
            // InternalSTL.g:377:1: ( () )
            {
            // InternalSTL.g:377:1: ( () )
            // InternalSTL.g:378:2: ()
            {
             before(grammarAccess.getGeometryAccess().getGeometryAction_0()); 
            // InternalSTL.g:379:2: ()
            // InternalSTL.g:379:3: 
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
    // InternalSTL.g:387:1: rule__Geometry__Group__1 : rule__Geometry__Group__1__Impl ;
    public final void rule__Geometry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:391:1: ( rule__Geometry__Group__1__Impl )
            // InternalSTL.g:392:2: rule__Geometry__Group__1__Impl
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
    // InternalSTL.g:398:1: rule__Geometry__Group__1__Impl : ( ( rule__Geometry__NodesAssignment_1 )* ) ;
    public final void rule__Geometry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:402:1: ( ( ( rule__Geometry__NodesAssignment_1 )* ) )
            // InternalSTL.g:403:1: ( ( rule__Geometry__NodesAssignment_1 )* )
            {
            // InternalSTL.g:403:1: ( ( rule__Geometry__NodesAssignment_1 )* )
            // InternalSTL.g:404:2: ( rule__Geometry__NodesAssignment_1 )*
            {
             before(grammarAccess.getGeometryAccess().getNodesAssignment_1()); 
            // InternalSTL.g:405:2: ( rule__Geometry__NodesAssignment_1 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==15) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalSTL.g:405:3: rule__Geometry__NodesAssignment_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__Geometry__NodesAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // InternalSTL.g:414:1: rule__Shape_Impl__Group__0 : rule__Shape_Impl__Group__0__Impl rule__Shape_Impl__Group__1 ;
    public final void rule__Shape_Impl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:418:1: ( rule__Shape_Impl__Group__0__Impl rule__Shape_Impl__Group__1 )
            // InternalSTL.g:419:2: rule__Shape_Impl__Group__0__Impl rule__Shape_Impl__Group__1
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
    // InternalSTL.g:426:1: rule__Shape_Impl__Group__0__Impl : ( () ) ;
    public final void rule__Shape_Impl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:430:1: ( ( () ) )
            // InternalSTL.g:431:1: ( () )
            {
            // InternalSTL.g:431:1: ( () )
            // InternalSTL.g:432:2: ()
            {
             before(grammarAccess.getShape_ImplAccess().getShapeAction_0()); 
            // InternalSTL.g:433:2: ()
            // InternalSTL.g:433:3: 
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
    // InternalSTL.g:441:1: rule__Shape_Impl__Group__1 : rule__Shape_Impl__Group__1__Impl rule__Shape_Impl__Group__2 ;
    public final void rule__Shape_Impl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:445:1: ( rule__Shape_Impl__Group__1__Impl rule__Shape_Impl__Group__2 )
            // InternalSTL.g:446:2: rule__Shape_Impl__Group__1__Impl rule__Shape_Impl__Group__2
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
    // InternalSTL.g:453:1: rule__Shape_Impl__Group__1__Impl : ( 'solid' ) ;
    public final void rule__Shape_Impl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:457:1: ( ( 'solid' ) )
            // InternalSTL.g:458:1: ( 'solid' )
            {
            // InternalSTL.g:458:1: ( 'solid' )
            // InternalSTL.g:459:2: 'solid'
            {
             before(grammarAccess.getShape_ImplAccess().getSolidKeyword_1()); 
            match(input,15,FOLLOW_2); 
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
    // InternalSTL.g:468:1: rule__Shape_Impl__Group__2 : rule__Shape_Impl__Group__2__Impl rule__Shape_Impl__Group__3 ;
    public final void rule__Shape_Impl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:472:1: ( rule__Shape_Impl__Group__2__Impl rule__Shape_Impl__Group__3 )
            // InternalSTL.g:473:2: rule__Shape_Impl__Group__2__Impl rule__Shape_Impl__Group__3
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
    // InternalSTL.g:480:1: rule__Shape_Impl__Group__2__Impl : ( ( rule__Shape_Impl__NameAssignment_2 )? ) ;
    public final void rule__Shape_Impl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:484:1: ( ( ( rule__Shape_Impl__NameAssignment_2 )? ) )
            // InternalSTL.g:485:1: ( ( rule__Shape_Impl__NameAssignment_2 )? )
            {
            // InternalSTL.g:485:1: ( ( rule__Shape_Impl__NameAssignment_2 )? )
            // InternalSTL.g:486:2: ( rule__Shape_Impl__NameAssignment_2 )?
            {
             before(grammarAccess.getShape_ImplAccess().getNameAssignment_2()); 
            // InternalSTL.g:487:2: ( rule__Shape_Impl__NameAssignment_2 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_STRING) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalSTL.g:487:3: rule__Shape_Impl__NameAssignment_2
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
    // InternalSTL.g:495:1: rule__Shape_Impl__Group__3 : rule__Shape_Impl__Group__3__Impl rule__Shape_Impl__Group__4 ;
    public final void rule__Shape_Impl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:499:1: ( rule__Shape_Impl__Group__3__Impl rule__Shape_Impl__Group__4 )
            // InternalSTL.g:500:2: rule__Shape_Impl__Group__3__Impl rule__Shape_Impl__Group__4
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
    // InternalSTL.g:507:1: rule__Shape_Impl__Group__3__Impl : ( ( rule__Shape_Impl__Alternatives_3 )* ) ;
    public final void rule__Shape_Impl__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:511:1: ( ( ( rule__Shape_Impl__Alternatives_3 )* ) )
            // InternalSTL.g:512:1: ( ( rule__Shape_Impl__Alternatives_3 )* )
            {
            // InternalSTL.g:512:1: ( ( rule__Shape_Impl__Alternatives_3 )* )
            // InternalSTL.g:513:2: ( rule__Shape_Impl__Alternatives_3 )*
            {
             before(grammarAccess.getShape_ImplAccess().getAlternatives_3()); 
            // InternalSTL.g:514:2: ( rule__Shape_Impl__Alternatives_3 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=RULE_ID && LA9_0<=RULE_INT)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalSTL.g:514:3: rule__Shape_Impl__Alternatives_3
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Shape_Impl__Alternatives_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // InternalSTL.g:522:1: rule__Shape_Impl__Group__4 : rule__Shape_Impl__Group__4__Impl rule__Shape_Impl__Group__5 ;
    public final void rule__Shape_Impl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:526:1: ( rule__Shape_Impl__Group__4__Impl rule__Shape_Impl__Group__5 )
            // InternalSTL.g:527:2: rule__Shape_Impl__Group__4__Impl rule__Shape_Impl__Group__5
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
    // InternalSTL.g:534:1: rule__Shape_Impl__Group__4__Impl : ( ( rule__Shape_Impl__TrianglesAssignment_4 )* ) ;
    public final void rule__Shape_Impl__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:538:1: ( ( ( rule__Shape_Impl__TrianglesAssignment_4 )* ) )
            // InternalSTL.g:539:1: ( ( rule__Shape_Impl__TrianglesAssignment_4 )* )
            {
            // InternalSTL.g:539:1: ( ( rule__Shape_Impl__TrianglesAssignment_4 )* )
            // InternalSTL.g:540:2: ( rule__Shape_Impl__TrianglesAssignment_4 )*
            {
             before(grammarAccess.getShape_ImplAccess().getTrianglesAssignment_4()); 
            // InternalSTL.g:541:2: ( rule__Shape_Impl__TrianglesAssignment_4 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==17) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalSTL.g:541:3: rule__Shape_Impl__TrianglesAssignment_4
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__Shape_Impl__TrianglesAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
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
    // InternalSTL.g:549:1: rule__Shape_Impl__Group__5 : rule__Shape_Impl__Group__5__Impl rule__Shape_Impl__Group__6 ;
    public final void rule__Shape_Impl__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:553:1: ( rule__Shape_Impl__Group__5__Impl rule__Shape_Impl__Group__6 )
            // InternalSTL.g:554:2: rule__Shape_Impl__Group__5__Impl rule__Shape_Impl__Group__6
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
    // InternalSTL.g:561:1: rule__Shape_Impl__Group__5__Impl : ( ( RULE_WS )* ) ;
    public final void rule__Shape_Impl__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:565:1: ( ( ( RULE_WS )* ) )
            // InternalSTL.g:566:1: ( ( RULE_WS )* )
            {
            // InternalSTL.g:566:1: ( ( RULE_WS )* )
            // InternalSTL.g:567:2: ( RULE_WS )*
            {
             before(grammarAccess.getShape_ImplAccess().getWSTerminalRuleCall_5()); 
            // InternalSTL.g:568:2: ( RULE_WS )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_WS) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalSTL.g:568:3: RULE_WS
            	    {
            	    match(input,RULE_WS,FOLLOW_8); 

            	    }
            	    break;

            	default :
            	    break loop11;
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
    // InternalSTL.g:576:1: rule__Shape_Impl__Group__6 : rule__Shape_Impl__Group__6__Impl rule__Shape_Impl__Group__7 ;
    public final void rule__Shape_Impl__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:580:1: ( rule__Shape_Impl__Group__6__Impl rule__Shape_Impl__Group__7 )
            // InternalSTL.g:581:2: rule__Shape_Impl__Group__6__Impl rule__Shape_Impl__Group__7
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
    // InternalSTL.g:588:1: rule__Shape_Impl__Group__6__Impl : ( 'endsolid' ) ;
    public final void rule__Shape_Impl__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:592:1: ( ( 'endsolid' ) )
            // InternalSTL.g:593:1: ( 'endsolid' )
            {
            // InternalSTL.g:593:1: ( 'endsolid' )
            // InternalSTL.g:594:2: 'endsolid'
            {
             before(grammarAccess.getShape_ImplAccess().getEndsolidKeyword_6()); 
            match(input,16,FOLLOW_2); 
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
    // InternalSTL.g:603:1: rule__Shape_Impl__Group__7 : rule__Shape_Impl__Group__7__Impl rule__Shape_Impl__Group__8 ;
    public final void rule__Shape_Impl__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:607:1: ( rule__Shape_Impl__Group__7__Impl rule__Shape_Impl__Group__8 )
            // InternalSTL.g:608:2: rule__Shape_Impl__Group__7__Impl rule__Shape_Impl__Group__8
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
    // InternalSTL.g:615:1: rule__Shape_Impl__Group__7__Impl : ( ( ruleEString )? ) ;
    public final void rule__Shape_Impl__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:619:1: ( ( ( ruleEString )? ) )
            // InternalSTL.g:620:1: ( ( ruleEString )? )
            {
            // InternalSTL.g:620:1: ( ( ruleEString )? )
            // InternalSTL.g:621:2: ( ruleEString )?
            {
             before(grammarAccess.getShape_ImplAccess().getEStringParserRuleCall_7()); 
            // InternalSTL.g:622:2: ( ruleEString )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_STRING) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalSTL.g:622:3: ruleEString
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
    // InternalSTL.g:630:1: rule__Shape_Impl__Group__8 : rule__Shape_Impl__Group__8__Impl ;
    public final void rule__Shape_Impl__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:634:1: ( rule__Shape_Impl__Group__8__Impl )
            // InternalSTL.g:635:2: rule__Shape_Impl__Group__8__Impl
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
    // InternalSTL.g:641:1: rule__Shape_Impl__Group__8__Impl : ( ( rule__Shape_Impl__Alternatives_8 )* ) ;
    public final void rule__Shape_Impl__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:645:1: ( ( ( rule__Shape_Impl__Alternatives_8 )* ) )
            // InternalSTL.g:646:1: ( ( rule__Shape_Impl__Alternatives_8 )* )
            {
            // InternalSTL.g:646:1: ( ( rule__Shape_Impl__Alternatives_8 )* )
            // InternalSTL.g:647:2: ( rule__Shape_Impl__Alternatives_8 )*
            {
             before(grammarAccess.getShape_ImplAccess().getAlternatives_8()); 
            // InternalSTL.g:648:2: ( rule__Shape_Impl__Alternatives_8 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=RULE_ID && LA13_0<=RULE_INT)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalSTL.g:648:3: rule__Shape_Impl__Alternatives_8
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Shape_Impl__Alternatives_8();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
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
    // InternalSTL.g:657:1: rule__Triangle__Group__0 : rule__Triangle__Group__0__Impl rule__Triangle__Group__1 ;
    public final void rule__Triangle__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:661:1: ( rule__Triangle__Group__0__Impl rule__Triangle__Group__1 )
            // InternalSTL.g:662:2: rule__Triangle__Group__0__Impl rule__Triangle__Group__1
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
    // InternalSTL.g:669:1: rule__Triangle__Group__0__Impl : ( () ) ;
    public final void rule__Triangle__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:673:1: ( ( () ) )
            // InternalSTL.g:674:1: ( () )
            {
            // InternalSTL.g:674:1: ( () )
            // InternalSTL.g:675:2: ()
            {
             before(grammarAccess.getTriangleAccess().getTriangleAction_0()); 
            // InternalSTL.g:676:2: ()
            // InternalSTL.g:676:3: 
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
    // InternalSTL.g:684:1: rule__Triangle__Group__1 : rule__Triangle__Group__1__Impl rule__Triangle__Group__2 ;
    public final void rule__Triangle__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:688:1: ( rule__Triangle__Group__1__Impl rule__Triangle__Group__2 )
            // InternalSTL.g:689:2: rule__Triangle__Group__1__Impl rule__Triangle__Group__2
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
    // InternalSTL.g:696:1: rule__Triangle__Group__1__Impl : ( 'facet' ) ;
    public final void rule__Triangle__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:700:1: ( ( 'facet' ) )
            // InternalSTL.g:701:1: ( 'facet' )
            {
            // InternalSTL.g:701:1: ( 'facet' )
            // InternalSTL.g:702:2: 'facet'
            {
             before(grammarAccess.getTriangleAccess().getFacetKeyword_1()); 
            match(input,17,FOLLOW_2); 
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
    // InternalSTL.g:711:1: rule__Triangle__Group__2 : rule__Triangle__Group__2__Impl rule__Triangle__Group__3 ;
    public final void rule__Triangle__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:715:1: ( rule__Triangle__Group__2__Impl rule__Triangle__Group__3 )
            // InternalSTL.g:716:2: rule__Triangle__Group__2__Impl rule__Triangle__Group__3
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
    // InternalSTL.g:723:1: rule__Triangle__Group__2__Impl : ( ( rule__Triangle__Group_2__0 ) ) ;
    public final void rule__Triangle__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:727:1: ( ( ( rule__Triangle__Group_2__0 ) ) )
            // InternalSTL.g:728:1: ( ( rule__Triangle__Group_2__0 ) )
            {
            // InternalSTL.g:728:1: ( ( rule__Triangle__Group_2__0 ) )
            // InternalSTL.g:729:2: ( rule__Triangle__Group_2__0 )
            {
             before(grammarAccess.getTriangleAccess().getGroup_2()); 
            // InternalSTL.g:730:2: ( rule__Triangle__Group_2__0 )
            // InternalSTL.g:730:3: rule__Triangle__Group_2__0
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
    // InternalSTL.g:738:1: rule__Triangle__Group__3 : rule__Triangle__Group__3__Impl rule__Triangle__Group__4 ;
    public final void rule__Triangle__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:742:1: ( rule__Triangle__Group__3__Impl rule__Triangle__Group__4 )
            // InternalSTL.g:743:2: rule__Triangle__Group__3__Impl rule__Triangle__Group__4
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
    // InternalSTL.g:750:1: rule__Triangle__Group__3__Impl : ( 'outer' ) ;
    public final void rule__Triangle__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:754:1: ( ( 'outer' ) )
            // InternalSTL.g:755:1: ( 'outer' )
            {
            // InternalSTL.g:755:1: ( 'outer' )
            // InternalSTL.g:756:2: 'outer'
            {
             before(grammarAccess.getTriangleAccess().getOuterKeyword_3()); 
            match(input,18,FOLLOW_2); 
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
    // InternalSTL.g:765:1: rule__Triangle__Group__4 : rule__Triangle__Group__4__Impl rule__Triangle__Group__5 ;
    public final void rule__Triangle__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:769:1: ( rule__Triangle__Group__4__Impl rule__Triangle__Group__5 )
            // InternalSTL.g:770:2: rule__Triangle__Group__4__Impl rule__Triangle__Group__5
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
    // InternalSTL.g:777:1: rule__Triangle__Group__4__Impl : ( 'loop' ) ;
    public final void rule__Triangle__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:781:1: ( ( 'loop' ) )
            // InternalSTL.g:782:1: ( 'loop' )
            {
            // InternalSTL.g:782:1: ( 'loop' )
            // InternalSTL.g:783:2: 'loop'
            {
             before(grammarAccess.getTriangleAccess().getLoopKeyword_4()); 
            match(input,19,FOLLOW_2); 
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
    // InternalSTL.g:792:1: rule__Triangle__Group__5 : rule__Triangle__Group__5__Impl rule__Triangle__Group__6 ;
    public final void rule__Triangle__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:796:1: ( rule__Triangle__Group__5__Impl rule__Triangle__Group__6 )
            // InternalSTL.g:797:2: rule__Triangle__Group__5__Impl rule__Triangle__Group__6
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
    // InternalSTL.g:804:1: rule__Triangle__Group__5__Impl : ( ( rule__Triangle__Group_5__0 )* ) ;
    public final void rule__Triangle__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:808:1: ( ( ( rule__Triangle__Group_5__0 )* ) )
            // InternalSTL.g:809:1: ( ( rule__Triangle__Group_5__0 )* )
            {
            // InternalSTL.g:809:1: ( ( rule__Triangle__Group_5__0 )* )
            // InternalSTL.g:810:2: ( rule__Triangle__Group_5__0 )*
            {
             before(grammarAccess.getTriangleAccess().getGroup_5()); 
            // InternalSTL.g:811:2: ( rule__Triangle__Group_5__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==23) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalSTL.g:811:3: rule__Triangle__Group_5__0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__Triangle__Group_5__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // InternalSTL.g:819:1: rule__Triangle__Group__6 : rule__Triangle__Group__6__Impl rule__Triangle__Group__7 ;
    public final void rule__Triangle__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:823:1: ( rule__Triangle__Group__6__Impl rule__Triangle__Group__7 )
            // InternalSTL.g:824:2: rule__Triangle__Group__6__Impl rule__Triangle__Group__7
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
    // InternalSTL.g:831:1: rule__Triangle__Group__6__Impl : ( 'endloop' ) ;
    public final void rule__Triangle__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:835:1: ( ( 'endloop' ) )
            // InternalSTL.g:836:1: ( 'endloop' )
            {
            // InternalSTL.g:836:1: ( 'endloop' )
            // InternalSTL.g:837:2: 'endloop'
            {
             before(grammarAccess.getTriangleAccess().getEndloopKeyword_6()); 
            match(input,20,FOLLOW_2); 
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
    // InternalSTL.g:846:1: rule__Triangle__Group__7 : rule__Triangle__Group__7__Impl ;
    public final void rule__Triangle__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:850:1: ( rule__Triangle__Group__7__Impl )
            // InternalSTL.g:851:2: rule__Triangle__Group__7__Impl
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
    // InternalSTL.g:857:1: rule__Triangle__Group__7__Impl : ( 'endfacet' ) ;
    public final void rule__Triangle__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:861:1: ( ( 'endfacet' ) )
            // InternalSTL.g:862:1: ( 'endfacet' )
            {
            // InternalSTL.g:862:1: ( 'endfacet' )
            // InternalSTL.g:863:2: 'endfacet'
            {
             before(grammarAccess.getTriangleAccess().getEndfacetKeyword_7()); 
            match(input,21,FOLLOW_2); 
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
    // InternalSTL.g:873:1: rule__Triangle__Group_2__0 : rule__Triangle__Group_2__0__Impl rule__Triangle__Group_2__1 ;
    public final void rule__Triangle__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:877:1: ( rule__Triangle__Group_2__0__Impl rule__Triangle__Group_2__1 )
            // InternalSTL.g:878:2: rule__Triangle__Group_2__0__Impl rule__Triangle__Group_2__1
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
    // InternalSTL.g:885:1: rule__Triangle__Group_2__0__Impl : ( 'normal' ) ;
    public final void rule__Triangle__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:889:1: ( ( 'normal' ) )
            // InternalSTL.g:890:1: ( 'normal' )
            {
            // InternalSTL.g:890:1: ( 'normal' )
            // InternalSTL.g:891:2: 'normal'
            {
             before(grammarAccess.getTriangleAccess().getNormalKeyword_2_0()); 
            match(input,22,FOLLOW_2); 
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
    // InternalSTL.g:900:1: rule__Triangle__Group_2__1 : rule__Triangle__Group_2__1__Impl ;
    public final void rule__Triangle__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:904:1: ( rule__Triangle__Group_2__1__Impl )
            // InternalSTL.g:905:2: rule__Triangle__Group_2__1__Impl
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
    // InternalSTL.g:911:1: rule__Triangle__Group_2__1__Impl : ( ( rule__Triangle__NormalAssignment_2_1 ) ) ;
    public final void rule__Triangle__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:915:1: ( ( ( rule__Triangle__NormalAssignment_2_1 ) ) )
            // InternalSTL.g:916:1: ( ( rule__Triangle__NormalAssignment_2_1 ) )
            {
            // InternalSTL.g:916:1: ( ( rule__Triangle__NormalAssignment_2_1 ) )
            // InternalSTL.g:917:2: ( rule__Triangle__NormalAssignment_2_1 )
            {
             before(grammarAccess.getTriangleAccess().getNormalAssignment_2_1()); 
            // InternalSTL.g:918:2: ( rule__Triangle__NormalAssignment_2_1 )
            // InternalSTL.g:918:3: rule__Triangle__NormalAssignment_2_1
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
    // InternalSTL.g:927:1: rule__Triangle__Group_5__0 : rule__Triangle__Group_5__0__Impl rule__Triangle__Group_5__1 ;
    public final void rule__Triangle__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:931:1: ( rule__Triangle__Group_5__0__Impl rule__Triangle__Group_5__1 )
            // InternalSTL.g:932:2: rule__Triangle__Group_5__0__Impl rule__Triangle__Group_5__1
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
    // InternalSTL.g:939:1: rule__Triangle__Group_5__0__Impl : ( 'vertex' ) ;
    public final void rule__Triangle__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:943:1: ( ( 'vertex' ) )
            // InternalSTL.g:944:1: ( 'vertex' )
            {
            // InternalSTL.g:944:1: ( 'vertex' )
            // InternalSTL.g:945:2: 'vertex'
            {
             before(grammarAccess.getTriangleAccess().getVertexKeyword_5_0()); 
            match(input,23,FOLLOW_2); 
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
    // InternalSTL.g:954:1: rule__Triangle__Group_5__1 : rule__Triangle__Group_5__1__Impl ;
    public final void rule__Triangle__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:958:1: ( rule__Triangle__Group_5__1__Impl )
            // InternalSTL.g:959:2: rule__Triangle__Group_5__1__Impl
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
    // InternalSTL.g:965:1: rule__Triangle__Group_5__1__Impl : ( ( rule__Triangle__VerticesAssignment_5_1 ) ) ;
    public final void rule__Triangle__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:969:1: ( ( ( rule__Triangle__VerticesAssignment_5_1 ) ) )
            // InternalSTL.g:970:1: ( ( rule__Triangle__VerticesAssignment_5_1 ) )
            {
            // InternalSTL.g:970:1: ( ( rule__Triangle__VerticesAssignment_5_1 ) )
            // InternalSTL.g:971:2: ( rule__Triangle__VerticesAssignment_5_1 )
            {
             before(grammarAccess.getTriangleAccess().getVerticesAssignment_5_1()); 
            // InternalSTL.g:972:2: ( rule__Triangle__VerticesAssignment_5_1 )
            // InternalSTL.g:972:3: rule__Triangle__VerticesAssignment_5_1
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
    // InternalSTL.g:981:1: rule__Vertex__Group__0 : rule__Vertex__Group__0__Impl rule__Vertex__Group__1 ;
    public final void rule__Vertex__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:985:1: ( rule__Vertex__Group__0__Impl rule__Vertex__Group__1 )
            // InternalSTL.g:986:2: rule__Vertex__Group__0__Impl rule__Vertex__Group__1
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
    // InternalSTL.g:993:1: rule__Vertex__Group__0__Impl : ( () ) ;
    public final void rule__Vertex__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:997:1: ( ( () ) )
            // InternalSTL.g:998:1: ( () )
            {
            // InternalSTL.g:998:1: ( () )
            // InternalSTL.g:999:2: ()
            {
             before(grammarAccess.getVertexAccess().getVertexAction_0()); 
            // InternalSTL.g:1000:2: ()
            // InternalSTL.g:1000:3: 
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
    // InternalSTL.g:1008:1: rule__Vertex__Group__1 : rule__Vertex__Group__1__Impl rule__Vertex__Group__2 ;
    public final void rule__Vertex__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1012:1: ( rule__Vertex__Group__1__Impl rule__Vertex__Group__2 )
            // InternalSTL.g:1013:2: rule__Vertex__Group__1__Impl rule__Vertex__Group__2
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
    // InternalSTL.g:1020:1: rule__Vertex__Group__1__Impl : ( ( rule__Vertex__XAssignment_1 ) ) ;
    public final void rule__Vertex__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1024:1: ( ( ( rule__Vertex__XAssignment_1 ) ) )
            // InternalSTL.g:1025:1: ( ( rule__Vertex__XAssignment_1 ) )
            {
            // InternalSTL.g:1025:1: ( ( rule__Vertex__XAssignment_1 ) )
            // InternalSTL.g:1026:2: ( rule__Vertex__XAssignment_1 )
            {
             before(grammarAccess.getVertexAccess().getXAssignment_1()); 
            // InternalSTL.g:1027:2: ( rule__Vertex__XAssignment_1 )
            // InternalSTL.g:1027:3: rule__Vertex__XAssignment_1
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
    // InternalSTL.g:1035:1: rule__Vertex__Group__2 : rule__Vertex__Group__2__Impl rule__Vertex__Group__3 ;
    public final void rule__Vertex__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1039:1: ( rule__Vertex__Group__2__Impl rule__Vertex__Group__3 )
            // InternalSTL.g:1040:2: rule__Vertex__Group__2__Impl rule__Vertex__Group__3
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
    // InternalSTL.g:1047:1: rule__Vertex__Group__2__Impl : ( ( rule__Vertex__YAssignment_2 ) ) ;
    public final void rule__Vertex__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1051:1: ( ( ( rule__Vertex__YAssignment_2 ) ) )
            // InternalSTL.g:1052:1: ( ( rule__Vertex__YAssignment_2 ) )
            {
            // InternalSTL.g:1052:1: ( ( rule__Vertex__YAssignment_2 ) )
            // InternalSTL.g:1053:2: ( rule__Vertex__YAssignment_2 )
            {
             before(grammarAccess.getVertexAccess().getYAssignment_2()); 
            // InternalSTL.g:1054:2: ( rule__Vertex__YAssignment_2 )
            // InternalSTL.g:1054:3: rule__Vertex__YAssignment_2
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
    // InternalSTL.g:1062:1: rule__Vertex__Group__3 : rule__Vertex__Group__3__Impl ;
    public final void rule__Vertex__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1066:1: ( rule__Vertex__Group__3__Impl )
            // InternalSTL.g:1067:2: rule__Vertex__Group__3__Impl
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
    // InternalSTL.g:1073:1: rule__Vertex__Group__3__Impl : ( ( rule__Vertex__ZAssignment_3 ) ) ;
    public final void rule__Vertex__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1077:1: ( ( ( rule__Vertex__ZAssignment_3 ) ) )
            // InternalSTL.g:1078:1: ( ( rule__Vertex__ZAssignment_3 ) )
            {
            // InternalSTL.g:1078:1: ( ( rule__Vertex__ZAssignment_3 ) )
            // InternalSTL.g:1079:2: ( rule__Vertex__ZAssignment_3 )
            {
             before(grammarAccess.getVertexAccess().getZAssignment_3()); 
            // InternalSTL.g:1080:2: ( rule__Vertex__ZAssignment_3 )
            // InternalSTL.g:1080:3: rule__Vertex__ZAssignment_3
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


    // $ANTLR start "rule__EDouble__Group__0"
    // InternalSTL.g:1089:1: rule__EDouble__Group__0 : rule__EDouble__Group__0__Impl rule__EDouble__Group__1 ;
    public final void rule__EDouble__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1093:1: ( rule__EDouble__Group__0__Impl rule__EDouble__Group__1 )
            // InternalSTL.g:1094:2: rule__EDouble__Group__0__Impl rule__EDouble__Group__1
            {
            pushFollow(FOLLOW_17);
            rule__EDouble__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDouble__Group__1();

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
    // $ANTLR end "rule__EDouble__Group__0"


    // $ANTLR start "rule__EDouble__Group__0__Impl"
    // InternalSTL.g:1101:1: rule__EDouble__Group__0__Impl : ( ( rule__EDouble__Alternatives_0 )? ) ;
    public final void rule__EDouble__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1105:1: ( ( ( rule__EDouble__Alternatives_0 )? ) )
            // InternalSTL.g:1106:1: ( ( rule__EDouble__Alternatives_0 )? )
            {
            // InternalSTL.g:1106:1: ( ( rule__EDouble__Alternatives_0 )? )
            // InternalSTL.g:1107:2: ( rule__EDouble__Alternatives_0 )?
            {
             before(grammarAccess.getEDoubleAccess().getAlternatives_0()); 
            // InternalSTL.g:1108:2: ( rule__EDouble__Alternatives_0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=11 && LA15_0<=12)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalSTL.g:1108:3: rule__EDouble__Alternatives_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EDouble__Alternatives_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEDoubleAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__0__Impl"


    // $ANTLR start "rule__EDouble__Group__1"
    // InternalSTL.g:1116:1: rule__EDouble__Group__1 : rule__EDouble__Group__1__Impl rule__EDouble__Group__2 ;
    public final void rule__EDouble__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1120:1: ( rule__EDouble__Group__1__Impl rule__EDouble__Group__2 )
            // InternalSTL.g:1121:2: rule__EDouble__Group__1__Impl rule__EDouble__Group__2
            {
            pushFollow(FOLLOW_17);
            rule__EDouble__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDouble__Group__2();

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
    // $ANTLR end "rule__EDouble__Group__1"


    // $ANTLR start "rule__EDouble__Group__1__Impl"
    // InternalSTL.g:1128:1: rule__EDouble__Group__1__Impl : ( ( RULE_INT )? ) ;
    public final void rule__EDouble__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1132:1: ( ( ( RULE_INT )? ) )
            // InternalSTL.g:1133:1: ( ( RULE_INT )? )
            {
            // InternalSTL.g:1133:1: ( ( RULE_INT )? )
            // InternalSTL.g:1134:2: ( RULE_INT )?
            {
             before(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1()); 
            // InternalSTL.g:1135:2: ( RULE_INT )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_INT) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalSTL.g:1135:3: RULE_INT
                    {
                    match(input,RULE_INT,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__1__Impl"


    // $ANTLR start "rule__EDouble__Group__2"
    // InternalSTL.g:1143:1: rule__EDouble__Group__2 : rule__EDouble__Group__2__Impl rule__EDouble__Group__3 ;
    public final void rule__EDouble__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1147:1: ( rule__EDouble__Group__2__Impl rule__EDouble__Group__3 )
            // InternalSTL.g:1148:2: rule__EDouble__Group__2__Impl rule__EDouble__Group__3
            {
            pushFollow(FOLLOW_18);
            rule__EDouble__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDouble__Group__3();

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
    // $ANTLR end "rule__EDouble__Group__2"


    // $ANTLR start "rule__EDouble__Group__2__Impl"
    // InternalSTL.g:1155:1: rule__EDouble__Group__2__Impl : ( '.' ) ;
    public final void rule__EDouble__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1159:1: ( ( '.' ) )
            // InternalSTL.g:1160:1: ( '.' )
            {
            // InternalSTL.g:1160:1: ( '.' )
            // InternalSTL.g:1161:2: '.'
            {
             before(grammarAccess.getEDoubleAccess().getFullStopKeyword_2()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getEDoubleAccess().getFullStopKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__2__Impl"


    // $ANTLR start "rule__EDouble__Group__3"
    // InternalSTL.g:1170:1: rule__EDouble__Group__3 : rule__EDouble__Group__3__Impl rule__EDouble__Group__4 ;
    public final void rule__EDouble__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1174:1: ( rule__EDouble__Group__3__Impl rule__EDouble__Group__4 )
            // InternalSTL.g:1175:2: rule__EDouble__Group__3__Impl rule__EDouble__Group__4
            {
            pushFollow(FOLLOW_19);
            rule__EDouble__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDouble__Group__4();

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
    // $ANTLR end "rule__EDouble__Group__3"


    // $ANTLR start "rule__EDouble__Group__3__Impl"
    // InternalSTL.g:1182:1: rule__EDouble__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__EDouble__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1186:1: ( ( RULE_INT ) )
            // InternalSTL.g:1187:1: ( RULE_INT )
            {
            // InternalSTL.g:1187:1: ( RULE_INT )
            // InternalSTL.g:1188:2: RULE_INT
            {
             before(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__3__Impl"


    // $ANTLR start "rule__EDouble__Group__4"
    // InternalSTL.g:1197:1: rule__EDouble__Group__4 : rule__EDouble__Group__4__Impl ;
    public final void rule__EDouble__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1201:1: ( rule__EDouble__Group__4__Impl )
            // InternalSTL.g:1202:2: rule__EDouble__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EDouble__Group__4__Impl();

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
    // $ANTLR end "rule__EDouble__Group__4"


    // $ANTLR start "rule__EDouble__Group__4__Impl"
    // InternalSTL.g:1208:1: rule__EDouble__Group__4__Impl : ( ( rule__EDouble__Group_4__0 )? ) ;
    public final void rule__EDouble__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1212:1: ( ( ( rule__EDouble__Group_4__0 )? ) )
            // InternalSTL.g:1213:1: ( ( rule__EDouble__Group_4__0 )? )
            {
            // InternalSTL.g:1213:1: ( ( rule__EDouble__Group_4__0 )? )
            // InternalSTL.g:1214:2: ( rule__EDouble__Group_4__0 )?
            {
             before(grammarAccess.getEDoubleAccess().getGroup_4()); 
            // InternalSTL.g:1215:2: ( rule__EDouble__Group_4__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=13 && LA17_0<=14)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalSTL.g:1215:3: rule__EDouble__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EDouble__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEDoubleAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__4__Impl"


    // $ANTLR start "rule__EDouble__Group_4__0"
    // InternalSTL.g:1224:1: rule__EDouble__Group_4__0 : rule__EDouble__Group_4__0__Impl rule__EDouble__Group_4__1 ;
    public final void rule__EDouble__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1228:1: ( rule__EDouble__Group_4__0__Impl rule__EDouble__Group_4__1 )
            // InternalSTL.g:1229:2: rule__EDouble__Group_4__0__Impl rule__EDouble__Group_4__1
            {
            pushFollow(FOLLOW_20);
            rule__EDouble__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDouble__Group_4__1();

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
    // $ANTLR end "rule__EDouble__Group_4__0"


    // $ANTLR start "rule__EDouble__Group_4__0__Impl"
    // InternalSTL.g:1236:1: rule__EDouble__Group_4__0__Impl : ( ( rule__EDouble__Alternatives_4_0 ) ) ;
    public final void rule__EDouble__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1240:1: ( ( ( rule__EDouble__Alternatives_4_0 ) ) )
            // InternalSTL.g:1241:1: ( ( rule__EDouble__Alternatives_4_0 ) )
            {
            // InternalSTL.g:1241:1: ( ( rule__EDouble__Alternatives_4_0 ) )
            // InternalSTL.g:1242:2: ( rule__EDouble__Alternatives_4_0 )
            {
             before(grammarAccess.getEDoubleAccess().getAlternatives_4_0()); 
            // InternalSTL.g:1243:2: ( rule__EDouble__Alternatives_4_0 )
            // InternalSTL.g:1243:3: rule__EDouble__Alternatives_4_0
            {
            pushFollow(FOLLOW_2);
            rule__EDouble__Alternatives_4_0();

            state._fsp--;


            }

             after(grammarAccess.getEDoubleAccess().getAlternatives_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_4__0__Impl"


    // $ANTLR start "rule__EDouble__Group_4__1"
    // InternalSTL.g:1251:1: rule__EDouble__Group_4__1 : rule__EDouble__Group_4__1__Impl rule__EDouble__Group_4__2 ;
    public final void rule__EDouble__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1255:1: ( rule__EDouble__Group_4__1__Impl rule__EDouble__Group_4__2 )
            // InternalSTL.g:1256:2: rule__EDouble__Group_4__1__Impl rule__EDouble__Group_4__2
            {
            pushFollow(FOLLOW_20);
            rule__EDouble__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDouble__Group_4__2();

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
    // $ANTLR end "rule__EDouble__Group_4__1"


    // $ANTLR start "rule__EDouble__Group_4__1__Impl"
    // InternalSTL.g:1263:1: rule__EDouble__Group_4__1__Impl : ( ( rule__EDouble__Alternatives_4_1 )? ) ;
    public final void rule__EDouble__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1267:1: ( ( ( rule__EDouble__Alternatives_4_1 )? ) )
            // InternalSTL.g:1268:1: ( ( rule__EDouble__Alternatives_4_1 )? )
            {
            // InternalSTL.g:1268:1: ( ( rule__EDouble__Alternatives_4_1 )? )
            // InternalSTL.g:1269:2: ( rule__EDouble__Alternatives_4_1 )?
            {
             before(grammarAccess.getEDoubleAccess().getAlternatives_4_1()); 
            // InternalSTL.g:1270:2: ( rule__EDouble__Alternatives_4_1 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=11 && LA18_0<=12)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalSTL.g:1270:3: rule__EDouble__Alternatives_4_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__EDouble__Alternatives_4_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEDoubleAccess().getAlternatives_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_4__1__Impl"


    // $ANTLR start "rule__EDouble__Group_4__2"
    // InternalSTL.g:1278:1: rule__EDouble__Group_4__2 : rule__EDouble__Group_4__2__Impl ;
    public final void rule__EDouble__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1282:1: ( rule__EDouble__Group_4__2__Impl )
            // InternalSTL.g:1283:2: rule__EDouble__Group_4__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EDouble__Group_4__2__Impl();

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
    // $ANTLR end "rule__EDouble__Group_4__2"


    // $ANTLR start "rule__EDouble__Group_4__2__Impl"
    // InternalSTL.g:1289:1: rule__EDouble__Group_4__2__Impl : ( RULE_INT ) ;
    public final void rule__EDouble__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1293:1: ( ( RULE_INT ) )
            // InternalSTL.g:1294:1: ( RULE_INT )
            {
            // InternalSTL.g:1294:1: ( RULE_INT )
            // InternalSTL.g:1295:2: RULE_INT
            {
             before(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_4_2()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_4__2__Impl"


    // $ANTLR start "rule__Geometry__NodesAssignment_1"
    // InternalSTL.g:1305:1: rule__Geometry__NodesAssignment_1 : ( ruleShape_Impl ) ;
    public final void rule__Geometry__NodesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1309:1: ( ( ruleShape_Impl ) )
            // InternalSTL.g:1310:2: ( ruleShape_Impl )
            {
            // InternalSTL.g:1310:2: ( ruleShape_Impl )
            // InternalSTL.g:1311:3: ruleShape_Impl
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
    // InternalSTL.g:1320:1: rule__Shape_Impl__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Shape_Impl__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1324:1: ( ( ruleEString ) )
            // InternalSTL.g:1325:2: ( ruleEString )
            {
            // InternalSTL.g:1325:2: ( ruleEString )
            // InternalSTL.g:1326:3: ruleEString
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
    // InternalSTL.g:1335:1: rule__Shape_Impl__TrianglesAssignment_4 : ( ruleTriangle ) ;
    public final void rule__Shape_Impl__TrianglesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1339:1: ( ( ruleTriangle ) )
            // InternalSTL.g:1340:2: ( ruleTriangle )
            {
            // InternalSTL.g:1340:2: ( ruleTriangle )
            // InternalSTL.g:1341:3: ruleTriangle
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
    // InternalSTL.g:1350:1: rule__Triangle__NormalAssignment_2_1 : ( ruleVertex ) ;
    public final void rule__Triangle__NormalAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1354:1: ( ( ruleVertex ) )
            // InternalSTL.g:1355:2: ( ruleVertex )
            {
            // InternalSTL.g:1355:2: ( ruleVertex )
            // InternalSTL.g:1356:3: ruleVertex
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
    // InternalSTL.g:1365:1: rule__Triangle__VerticesAssignment_5_1 : ( ruleVertex ) ;
    public final void rule__Triangle__VerticesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1369:1: ( ( ruleVertex ) )
            // InternalSTL.g:1370:2: ( ruleVertex )
            {
            // InternalSTL.g:1370:2: ( ruleVertex )
            // InternalSTL.g:1371:3: ruleVertex
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
    // InternalSTL.g:1380:1: rule__Vertex__XAssignment_1 : ( ruleEDouble ) ;
    public final void rule__Vertex__XAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1384:1: ( ( ruleEDouble ) )
            // InternalSTL.g:1385:2: ( ruleEDouble )
            {
            // InternalSTL.g:1385:2: ( ruleEDouble )
            // InternalSTL.g:1386:3: ruleEDouble
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
    // InternalSTL.g:1395:1: rule__Vertex__YAssignment_2 : ( ruleEDouble ) ;
    public final void rule__Vertex__YAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1399:1: ( ( ruleEDouble ) )
            // InternalSTL.g:1400:2: ( ruleEDouble )
            {
            // InternalSTL.g:1400:2: ( ruleEDouble )
            // InternalSTL.g:1401:3: ruleEDouble
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
    // InternalSTL.g:1410:1: rule__Vertex__ZAssignment_3 : ( ruleEDouble ) ;
    public final void rule__Vertex__ZAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSTL.g:1414:1: ( ( ruleEDouble ) )
            // InternalSTL.g:1415:2: ( ruleEDouble )
            {
            // InternalSTL.g:1415:2: ( ruleEDouble )
            // InternalSTL.g:1416:3: ruleEDouble
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


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000000300F0L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000000000F2L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000900000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001001880L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000001880L});

}