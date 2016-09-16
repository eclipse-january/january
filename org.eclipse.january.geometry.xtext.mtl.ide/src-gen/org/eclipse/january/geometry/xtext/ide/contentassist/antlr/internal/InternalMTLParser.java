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
import org.eclipse.january.geometry.xtext.services.MTLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMTLParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_DOUBLE", "RULE_SL_COMMENT", "RULE_WS", "RULE_ML_COMMENT", "RULE_ANY_OTHER", "'.'", "'/'", "'\\\\'", "':'", "'_'", "'-'", "'newmtl'", "'Ka'", "'Kd'", "'Ks'", "'Ns'", "'d'", "'Tr'", "'illum'", "'map_Ka'", "'map_Kd'", "'map_Ks'", "'map_Ns'", "'map_d'", "'map_bump'"
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
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
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


        public InternalMTLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMTLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMTLParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMTL.g"; }


    	private MTLGrammarAccess grammarAccess;

    	public void setGrammarAccess(MTLGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleMaterialSource"
    // InternalMTL.g:53:1: entryRuleMaterialSource : ruleMaterialSource EOF ;
    public final void entryRuleMaterialSource() throws RecognitionException {
        try {
            // InternalMTL.g:54:1: ( ruleMaterialSource EOF )
            // InternalMTL.g:55:1: ruleMaterialSource EOF
            {
             before(grammarAccess.getMaterialSourceRule()); 
            pushFollow(FOLLOW_1);
            ruleMaterialSource();

            state._fsp--;

             after(grammarAccess.getMaterialSourceRule()); 
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
    // $ANTLR end "entryRuleMaterialSource"


    // $ANTLR start "ruleMaterialSource"
    // InternalMTL.g:62:1: ruleMaterialSource : ( ( rule__MaterialSource__MaterialsAssignment )* ) ;
    public final void ruleMaterialSource() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:66:2: ( ( ( rule__MaterialSource__MaterialsAssignment )* ) )
            // InternalMTL.g:67:2: ( ( rule__MaterialSource__MaterialsAssignment )* )
            {
            // InternalMTL.g:67:2: ( ( rule__MaterialSource__MaterialsAssignment )* )
            // InternalMTL.g:68:3: ( rule__MaterialSource__MaterialsAssignment )*
            {
             before(grammarAccess.getMaterialSourceAccess().getMaterialsAssignment()); 
            // InternalMTL.g:69:3: ( rule__MaterialSource__MaterialsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==18||(LA1_0>=20 && LA1_0<=21)||(LA1_0>=23 && LA1_0<=31)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMTL.g:69:4: rule__MaterialSource__MaterialsAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__MaterialSource__MaterialsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getMaterialSourceAccess().getMaterialsAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMaterialSource"


    // $ANTLR start "entryRuleMaterial"
    // InternalMTL.g:78:1: entryRuleMaterial : ruleMaterial EOF ;
    public final void entryRuleMaterial() throws RecognitionException {
        try {
            // InternalMTL.g:79:1: ( ruleMaterial EOF )
            // InternalMTL.g:80:1: ruleMaterial EOF
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
    // InternalMTL.g:87:1: ruleMaterial : ( ( rule__Material__Alternatives ) ) ;
    public final void ruleMaterial() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:91:2: ( ( ( rule__Material__Alternatives ) ) )
            // InternalMTL.g:92:2: ( ( rule__Material__Alternatives ) )
            {
            // InternalMTL.g:92:2: ( ( rule__Material__Alternatives ) )
            // InternalMTL.g:93:3: ( rule__Material__Alternatives )
            {
             before(grammarAccess.getMaterialAccess().getAlternatives()); 
            // InternalMTL.g:94:3: ( rule__Material__Alternatives )
            // InternalMTL.g:94:4: rule__Material__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Material__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMaterialAccess().getAlternatives()); 

            }


            }

        }
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


    // $ANTLR start "entryRulePhongMaterial"
    // InternalMTL.g:103:1: entryRulePhongMaterial : rulePhongMaterial EOF ;
    public final void entryRulePhongMaterial() throws RecognitionException {
        try {
            // InternalMTL.g:104:1: ( rulePhongMaterial EOF )
            // InternalMTL.g:105:1: rulePhongMaterial EOF
            {
             before(grammarAccess.getPhongMaterialRule()); 
            pushFollow(FOLLOW_1);
            rulePhongMaterial();

            state._fsp--;

             after(grammarAccess.getPhongMaterialRule()); 
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
    // $ANTLR end "entryRulePhongMaterial"


    // $ANTLR start "rulePhongMaterial"
    // InternalMTL.g:112:1: rulePhongMaterial : ( ( rule__PhongMaterial__UnorderedGroup ) ) ;
    public final void rulePhongMaterial() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:116:2: ( ( ( rule__PhongMaterial__UnorderedGroup ) ) )
            // InternalMTL.g:117:2: ( ( rule__PhongMaterial__UnorderedGroup ) )
            {
            // InternalMTL.g:117:2: ( ( rule__PhongMaterial__UnorderedGroup ) )
            // InternalMTL.g:118:3: ( rule__PhongMaterial__UnorderedGroup )
            {
             before(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()); 
            // InternalMTL.g:119:3: ( rule__PhongMaterial__UnorderedGroup )
            // InternalMTL.g:119:4: rule__PhongMaterial__UnorderedGroup
            {
            pushFollow(FOLLOW_2);
            rule__PhongMaterial__UnorderedGroup();

            state._fsp--;


            }

             after(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePhongMaterial"


    // $ANTLR start "entryRuleTexturedMaterial"
    // InternalMTL.g:128:1: entryRuleTexturedMaterial : ruleTexturedMaterial EOF ;
    public final void entryRuleTexturedMaterial() throws RecognitionException {
        try {
            // InternalMTL.g:129:1: ( ruleTexturedMaterial EOF )
            // InternalMTL.g:130:1: ruleTexturedMaterial EOF
            {
             before(grammarAccess.getTexturedMaterialRule()); 
            pushFollow(FOLLOW_1);
            ruleTexturedMaterial();

            state._fsp--;

             after(grammarAccess.getTexturedMaterialRule()); 
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
    // $ANTLR end "entryRuleTexturedMaterial"


    // $ANTLR start "ruleTexturedMaterial"
    // InternalMTL.g:137:1: ruleTexturedMaterial : ( ( rule__TexturedMaterial__UnorderedGroup ) ) ;
    public final void ruleTexturedMaterial() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:141:2: ( ( ( rule__TexturedMaterial__UnorderedGroup ) ) )
            // InternalMTL.g:142:2: ( ( rule__TexturedMaterial__UnorderedGroup ) )
            {
            // InternalMTL.g:142:2: ( ( rule__TexturedMaterial__UnorderedGroup ) )
            // InternalMTL.g:143:3: ( rule__TexturedMaterial__UnorderedGroup )
            {
             before(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()); 
            // InternalMTL.g:144:3: ( rule__TexturedMaterial__UnorderedGroup )
            // InternalMTL.g:144:4: rule__TexturedMaterial__UnorderedGroup
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__UnorderedGroup();

            state._fsp--;


            }

             after(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTexturedMaterial"


    // $ANTLR start "entryRuleColor"
    // InternalMTL.g:153:1: entryRuleColor : ruleColor EOF ;
    public final void entryRuleColor() throws RecognitionException {
        try {
            // InternalMTL.g:154:1: ( ruleColor EOF )
            // InternalMTL.g:155:1: ruleColor EOF
            {
             before(grammarAccess.getColorRule()); 
            pushFollow(FOLLOW_1);
            ruleColor();

            state._fsp--;

             after(grammarAccess.getColorRule()); 
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
    // $ANTLR end "entryRuleColor"


    // $ANTLR start "ruleColor"
    // InternalMTL.g:162:1: ruleColor : ( ( rule__Color__Group__0 ) ) ;
    public final void ruleColor() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:166:2: ( ( ( rule__Color__Group__0 ) ) )
            // InternalMTL.g:167:2: ( ( rule__Color__Group__0 ) )
            {
            // InternalMTL.g:167:2: ( ( rule__Color__Group__0 ) )
            // InternalMTL.g:168:3: ( rule__Color__Group__0 )
            {
             before(grammarAccess.getColorAccess().getGroup()); 
            // InternalMTL.g:169:3: ( rule__Color__Group__0 )
            // InternalMTL.g:169:4: rule__Color__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Color__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getColorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleColor"


    // $ANTLR start "entryRuleEInt"
    // InternalMTL.g:178:1: entryRuleEInt : ruleEInt EOF ;
    public final void entryRuleEInt() throws RecognitionException {
        try {
            // InternalMTL.g:179:1: ( ruleEInt EOF )
            // InternalMTL.g:180:1: ruleEInt EOF
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
    // InternalMTL.g:187:1: ruleEInt : ( ( rule__EInt__Group__0 ) ) ;
    public final void ruleEInt() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:191:2: ( ( ( rule__EInt__Group__0 ) ) )
            // InternalMTL.g:192:2: ( ( rule__EInt__Group__0 ) )
            {
            // InternalMTL.g:192:2: ( ( rule__EInt__Group__0 ) )
            // InternalMTL.g:193:3: ( rule__EInt__Group__0 )
            {
             before(grammarAccess.getEIntAccess().getGroup()); 
            // InternalMTL.g:194:3: ( rule__EInt__Group__0 )
            // InternalMTL.g:194:4: rule__EInt__Group__0
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
    // InternalMTL.g:203:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalMTL.g:204:1: ( ruleEString EOF )
            // InternalMTL.g:205:1: ruleEString EOF
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
    // InternalMTL.g:212:1: ruleEString : ( ( ( rule__EString__Alternatives ) ) ( ( rule__EString__Alternatives )* ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:216:2: ( ( ( ( rule__EString__Alternatives ) ) ( ( rule__EString__Alternatives )* ) ) )
            // InternalMTL.g:217:2: ( ( ( rule__EString__Alternatives ) ) ( ( rule__EString__Alternatives )* ) )
            {
            // InternalMTL.g:217:2: ( ( ( rule__EString__Alternatives ) ) ( ( rule__EString__Alternatives )* ) )
            // InternalMTL.g:218:3: ( ( rule__EString__Alternatives ) ) ( ( rule__EString__Alternatives )* )
            {
            // InternalMTL.g:218:3: ( ( rule__EString__Alternatives ) )
            // InternalMTL.g:219:4: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalMTL.g:220:4: ( rule__EString__Alternatives )
            // InternalMTL.g:220:5: rule__EString__Alternatives
            {
            pushFollow(FOLLOW_4);
            rule__EString__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEStringAccess().getAlternatives()); 

            }

            // InternalMTL.g:223:3: ( ( rule__EString__Alternatives )* )
            // InternalMTL.g:224:4: ( rule__EString__Alternatives )*
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalMTL.g:225:4: ( rule__EString__Alternatives )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=RULE_STRING && LA2_0<=RULE_INT)||(LA2_0>=12 && LA2_0<=17)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalMTL.g:225:5: rule__EString__Alternatives
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
    // InternalMTL.g:235:1: entryRuleEDouble : ruleEDouble EOF ;
    public final void entryRuleEDouble() throws RecognitionException {
        try {
            // InternalMTL.g:236:1: ( ruleEDouble EOF )
            // InternalMTL.g:237:1: ruleEDouble EOF
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
    // InternalMTL.g:244:1: ruleEDouble : ( ( rule__EDouble__Alternatives ) ) ;
    public final void ruleEDouble() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:248:2: ( ( ( rule__EDouble__Alternatives ) ) )
            // InternalMTL.g:249:2: ( ( rule__EDouble__Alternatives ) )
            {
            // InternalMTL.g:249:2: ( ( rule__EDouble__Alternatives ) )
            // InternalMTL.g:250:3: ( rule__EDouble__Alternatives )
            {
             before(grammarAccess.getEDoubleAccess().getAlternatives()); 
            // InternalMTL.g:251:3: ( rule__EDouble__Alternatives )
            // InternalMTL.g:251:4: rule__EDouble__Alternatives
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


    // $ANTLR start "rule__Material__Alternatives"
    // InternalMTL.g:259:1: rule__Material__Alternatives : ( ( rulePhongMaterial ) | ( ruleTexturedMaterial ) );
    public final void rule__Material__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:263:1: ( ( rulePhongMaterial ) | ( ruleTexturedMaterial ) )
            int alt3=2;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // InternalMTL.g:264:2: ( rulePhongMaterial )
                    {
                    // InternalMTL.g:264:2: ( rulePhongMaterial )
                    // InternalMTL.g:265:3: rulePhongMaterial
                    {
                     before(grammarAccess.getMaterialAccess().getPhongMaterialParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    rulePhongMaterial();

                    state._fsp--;

                     after(grammarAccess.getMaterialAccess().getPhongMaterialParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMTL.g:270:2: ( ruleTexturedMaterial )
                    {
                    // InternalMTL.g:270:2: ( ruleTexturedMaterial )
                    // InternalMTL.g:271:3: ruleTexturedMaterial
                    {
                     before(grammarAccess.getMaterialAccess().getTexturedMaterialParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleTexturedMaterial();

                    state._fsp--;

                     after(grammarAccess.getMaterialAccess().getTexturedMaterialParserRuleCall_1()); 

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
    // $ANTLR end "rule__Material__Alternatives"


    // $ANTLR start "rule__PhongMaterial__Alternatives_3"
    // InternalMTL.g:280:1: rule__PhongMaterial__Alternatives_3 : ( ( ( rule__PhongMaterial__Group_3_0__0 ) ) | ( ( rule__PhongMaterial__Group_3_1__0 ) ) );
    public final void rule__PhongMaterial__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:284:1: ( ( ( rule__PhongMaterial__Group_3_0__0 ) ) | ( ( rule__PhongMaterial__Group_3_1__0 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==23) ) {
                alt4=1;
            }
            else if ( (LA4_0==24) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalMTL.g:285:2: ( ( rule__PhongMaterial__Group_3_0__0 ) )
                    {
                    // InternalMTL.g:285:2: ( ( rule__PhongMaterial__Group_3_0__0 ) )
                    // InternalMTL.g:286:3: ( rule__PhongMaterial__Group_3_0__0 )
                    {
                     before(grammarAccess.getPhongMaterialAccess().getGroup_3_0()); 
                    // InternalMTL.g:287:3: ( rule__PhongMaterial__Group_3_0__0 )
                    // InternalMTL.g:287:4: rule__PhongMaterial__Group_3_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PhongMaterial__Group_3_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPhongMaterialAccess().getGroup_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMTL.g:291:2: ( ( rule__PhongMaterial__Group_3_1__0 ) )
                    {
                    // InternalMTL.g:291:2: ( ( rule__PhongMaterial__Group_3_1__0 ) )
                    // InternalMTL.g:292:3: ( rule__PhongMaterial__Group_3_1__0 )
                    {
                     before(grammarAccess.getPhongMaterialAccess().getGroup_3_1()); 
                    // InternalMTL.g:293:3: ( rule__PhongMaterial__Group_3_1__0 )
                    // InternalMTL.g:293:4: rule__PhongMaterial__Group_3_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PhongMaterial__Group_3_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPhongMaterialAccess().getGroup_3_1()); 

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
    // $ANTLR end "rule__PhongMaterial__Alternatives_3"


    // $ANTLR start "rule__TexturedMaterial__Alternatives_3"
    // InternalMTL.g:301:1: rule__TexturedMaterial__Alternatives_3 : ( ( ( rule__TexturedMaterial__Group_3_0__0 ) ) | ( ( rule__TexturedMaterial__Group_3_1__0 ) ) );
    public final void rule__TexturedMaterial__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:305:1: ( ( ( rule__TexturedMaterial__Group_3_0__0 ) ) | ( ( rule__TexturedMaterial__Group_3_1__0 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==23) ) {
                alt5=1;
            }
            else if ( (LA5_0==24) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalMTL.g:306:2: ( ( rule__TexturedMaterial__Group_3_0__0 ) )
                    {
                    // InternalMTL.g:306:2: ( ( rule__TexturedMaterial__Group_3_0__0 ) )
                    // InternalMTL.g:307:3: ( rule__TexturedMaterial__Group_3_0__0 )
                    {
                     before(grammarAccess.getTexturedMaterialAccess().getGroup_3_0()); 
                    // InternalMTL.g:308:3: ( rule__TexturedMaterial__Group_3_0__0 )
                    // InternalMTL.g:308:4: rule__TexturedMaterial__Group_3_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TexturedMaterial__Group_3_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTexturedMaterialAccess().getGroup_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMTL.g:312:2: ( ( rule__TexturedMaterial__Group_3_1__0 ) )
                    {
                    // InternalMTL.g:312:2: ( ( rule__TexturedMaterial__Group_3_1__0 ) )
                    // InternalMTL.g:313:3: ( rule__TexturedMaterial__Group_3_1__0 )
                    {
                     before(grammarAccess.getTexturedMaterialAccess().getGroup_3_1()); 
                    // InternalMTL.g:314:3: ( rule__TexturedMaterial__Group_3_1__0 )
                    // InternalMTL.g:314:4: rule__TexturedMaterial__Group_3_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TexturedMaterial__Group_3_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTexturedMaterialAccess().getGroup_3_1()); 

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
    // $ANTLR end "rule__TexturedMaterial__Alternatives_3"


    // $ANTLR start "rule__EString__Alternatives"
    // InternalMTL.g:322:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) | ( RULE_INT ) | ( '.' ) | ( '/' ) | ( '\\\\' ) | ( ':' ) | ( '_' ) | ( '-' ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:326:1: ( ( RULE_STRING ) | ( RULE_ID ) | ( RULE_INT ) | ( '.' ) | ( '/' ) | ( '\\\\' ) | ( ':' ) | ( '_' ) | ( '-' ) )
            int alt6=9;
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
            case RULE_INT:
                {
                alt6=3;
                }
                break;
            case 12:
                {
                alt6=4;
                }
                break;
            case 13:
                {
                alt6=5;
                }
                break;
            case 14:
                {
                alt6=6;
                }
                break;
            case 15:
                {
                alt6=7;
                }
                break;
            case 16:
                {
                alt6=8;
                }
                break;
            case 17:
                {
                alt6=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalMTL.g:327:2: ( RULE_STRING )
                    {
                    // InternalMTL.g:327:2: ( RULE_STRING )
                    // InternalMTL.g:328:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMTL.g:333:2: ( RULE_ID )
                    {
                    // InternalMTL.g:333:2: ( RULE_ID )
                    // InternalMTL.g:334:3: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMTL.g:339:2: ( RULE_INT )
                    {
                    // InternalMTL.g:339:2: ( RULE_INT )
                    // InternalMTL.g:340:3: RULE_INT
                    {
                     before(grammarAccess.getEStringAccess().getINTTerminalRuleCall_2()); 
                    match(input,RULE_INT,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getINTTerminalRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalMTL.g:345:2: ( '.' )
                    {
                    // InternalMTL.g:345:2: ( '.' )
                    // InternalMTL.g:346:3: '.'
                    {
                     before(grammarAccess.getEStringAccess().getFullStopKeyword_3()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getFullStopKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalMTL.g:351:2: ( '/' )
                    {
                    // InternalMTL.g:351:2: ( '/' )
                    // InternalMTL.g:352:3: '/'
                    {
                     before(grammarAccess.getEStringAccess().getSolidusKeyword_4()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSolidusKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalMTL.g:357:2: ( '\\\\' )
                    {
                    // InternalMTL.g:357:2: ( '\\\\' )
                    // InternalMTL.g:358:3: '\\\\'
                    {
                     before(grammarAccess.getEStringAccess().getReverseSolidusKeyword_5()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getReverseSolidusKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalMTL.g:363:2: ( ':' )
                    {
                    // InternalMTL.g:363:2: ( ':' )
                    // InternalMTL.g:364:3: ':'
                    {
                     before(grammarAccess.getEStringAccess().getColonKeyword_6()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getColonKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalMTL.g:369:2: ( '_' )
                    {
                    // InternalMTL.g:369:2: ( '_' )
                    // InternalMTL.g:370:3: '_'
                    {
                     before(grammarAccess.getEStringAccess().get_Keyword_7()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().get_Keyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalMTL.g:375:2: ( '-' )
                    {
                    // InternalMTL.g:375:2: ( '-' )
                    // InternalMTL.g:376:3: '-'
                    {
                     before(grammarAccess.getEStringAccess().getHyphenMinusKeyword_8()); 
                    match(input,17,FOLLOW_2); 
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
    // InternalMTL.g:385:1: rule__EDouble__Alternatives : ( ( RULE_DOUBLE ) | ( ruleEInt ) );
    public final void rule__EDouble__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:389:1: ( ( RULE_DOUBLE ) | ( ruleEInt ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_DOUBLE) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_INT||LA7_0==17) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalMTL.g:390:2: ( RULE_DOUBLE )
                    {
                    // InternalMTL.g:390:2: ( RULE_DOUBLE )
                    // InternalMTL.g:391:3: RULE_DOUBLE
                    {
                     before(grammarAccess.getEDoubleAccess().getDOUBLETerminalRuleCall_0()); 
                    match(input,RULE_DOUBLE,FOLLOW_2); 
                     after(grammarAccess.getEDoubleAccess().getDOUBLETerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMTL.g:396:2: ( ruleEInt )
                    {
                    // InternalMTL.g:396:2: ( ruleEInt )
                    // InternalMTL.g:397:3: ruleEInt
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


    // $ANTLR start "rule__PhongMaterial__Group_0__0"
    // InternalMTL.g:406:1: rule__PhongMaterial__Group_0__0 : rule__PhongMaterial__Group_0__0__Impl rule__PhongMaterial__Group_0__1 ;
    public final void rule__PhongMaterial__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:410:1: ( rule__PhongMaterial__Group_0__0__Impl rule__PhongMaterial__Group_0__1 )
            // InternalMTL.g:411:2: rule__PhongMaterial__Group_0__0__Impl rule__PhongMaterial__Group_0__1
            {
            pushFollow(FOLLOW_5);
            rule__PhongMaterial__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhongMaterial__Group_0__1();

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
    // $ANTLR end "rule__PhongMaterial__Group_0__0"


    // $ANTLR start "rule__PhongMaterial__Group_0__0__Impl"
    // InternalMTL.g:418:1: rule__PhongMaterial__Group_0__0__Impl : ( 'newmtl' ) ;
    public final void rule__PhongMaterial__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:422:1: ( ( 'newmtl' ) )
            // InternalMTL.g:423:1: ( 'newmtl' )
            {
            // InternalMTL.g:423:1: ( 'newmtl' )
            // InternalMTL.g:424:2: 'newmtl'
            {
             before(grammarAccess.getPhongMaterialAccess().getNewmtlKeyword_0_0()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getPhongMaterialAccess().getNewmtlKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__Group_0__0__Impl"


    // $ANTLR start "rule__PhongMaterial__Group_0__1"
    // InternalMTL.g:433:1: rule__PhongMaterial__Group_0__1 : rule__PhongMaterial__Group_0__1__Impl rule__PhongMaterial__Group_0__2 ;
    public final void rule__PhongMaterial__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:437:1: ( rule__PhongMaterial__Group_0__1__Impl rule__PhongMaterial__Group_0__2 )
            // InternalMTL.g:438:2: rule__PhongMaterial__Group_0__1__Impl rule__PhongMaterial__Group_0__2
            {
            pushFollow(FOLLOW_6);
            rule__PhongMaterial__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhongMaterial__Group_0__2();

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
    // $ANTLR end "rule__PhongMaterial__Group_0__1"


    // $ANTLR start "rule__PhongMaterial__Group_0__1__Impl"
    // InternalMTL.g:445:1: rule__PhongMaterial__Group_0__1__Impl : ( ( rule__PhongMaterial__NameAssignment_0_1 ) ) ;
    public final void rule__PhongMaterial__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:449:1: ( ( ( rule__PhongMaterial__NameAssignment_0_1 ) ) )
            // InternalMTL.g:450:1: ( ( rule__PhongMaterial__NameAssignment_0_1 ) )
            {
            // InternalMTL.g:450:1: ( ( rule__PhongMaterial__NameAssignment_0_1 ) )
            // InternalMTL.g:451:2: ( rule__PhongMaterial__NameAssignment_0_1 )
            {
             before(grammarAccess.getPhongMaterialAccess().getNameAssignment_0_1()); 
            // InternalMTL.g:452:2: ( rule__PhongMaterial__NameAssignment_0_1 )
            // InternalMTL.g:452:3: rule__PhongMaterial__NameAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__PhongMaterial__NameAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getPhongMaterialAccess().getNameAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__Group_0__1__Impl"


    // $ANTLR start "rule__PhongMaterial__Group_0__2"
    // InternalMTL.g:460:1: rule__PhongMaterial__Group_0__2 : rule__PhongMaterial__Group_0__2__Impl ;
    public final void rule__PhongMaterial__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:464:1: ( rule__PhongMaterial__Group_0__2__Impl )
            // InternalMTL.g:465:2: rule__PhongMaterial__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PhongMaterial__Group_0__2__Impl();

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
    // $ANTLR end "rule__PhongMaterial__Group_0__2"


    // $ANTLR start "rule__PhongMaterial__Group_0__2__Impl"
    // InternalMTL.g:471:1: rule__PhongMaterial__Group_0__2__Impl : ( ( rule__PhongMaterial__Group_0_2__0 ) ) ;
    public final void rule__PhongMaterial__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:475:1: ( ( ( rule__PhongMaterial__Group_0_2__0 ) ) )
            // InternalMTL.g:476:1: ( ( rule__PhongMaterial__Group_0_2__0 ) )
            {
            // InternalMTL.g:476:1: ( ( rule__PhongMaterial__Group_0_2__0 ) )
            // InternalMTL.g:477:2: ( rule__PhongMaterial__Group_0_2__0 )
            {
             before(grammarAccess.getPhongMaterialAccess().getGroup_0_2()); 
            // InternalMTL.g:478:2: ( rule__PhongMaterial__Group_0_2__0 )
            // InternalMTL.g:478:3: rule__PhongMaterial__Group_0_2__0
            {
            pushFollow(FOLLOW_2);
            rule__PhongMaterial__Group_0_2__0();

            state._fsp--;


            }

             after(grammarAccess.getPhongMaterialAccess().getGroup_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__Group_0__2__Impl"


    // $ANTLR start "rule__PhongMaterial__Group_0_2__0"
    // InternalMTL.g:487:1: rule__PhongMaterial__Group_0_2__0 : rule__PhongMaterial__Group_0_2__0__Impl rule__PhongMaterial__Group_0_2__1 ;
    public final void rule__PhongMaterial__Group_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:491:1: ( rule__PhongMaterial__Group_0_2__0__Impl rule__PhongMaterial__Group_0_2__1 )
            // InternalMTL.g:492:2: rule__PhongMaterial__Group_0_2__0__Impl rule__PhongMaterial__Group_0_2__1
            {
            pushFollow(FOLLOW_7);
            rule__PhongMaterial__Group_0_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhongMaterial__Group_0_2__1();

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
    // $ANTLR end "rule__PhongMaterial__Group_0_2__0"


    // $ANTLR start "rule__PhongMaterial__Group_0_2__0__Impl"
    // InternalMTL.g:499:1: rule__PhongMaterial__Group_0_2__0__Impl : ( 'Ka' ) ;
    public final void rule__PhongMaterial__Group_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:503:1: ( ( 'Ka' ) )
            // InternalMTL.g:504:1: ( 'Ka' )
            {
            // InternalMTL.g:504:1: ( 'Ka' )
            // InternalMTL.g:505:2: 'Ka'
            {
             before(grammarAccess.getPhongMaterialAccess().getKaKeyword_0_2_0()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getPhongMaterialAccess().getKaKeyword_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__Group_0_2__0__Impl"


    // $ANTLR start "rule__PhongMaterial__Group_0_2__1"
    // InternalMTL.g:514:1: rule__PhongMaterial__Group_0_2__1 : rule__PhongMaterial__Group_0_2__1__Impl ;
    public final void rule__PhongMaterial__Group_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:518:1: ( rule__PhongMaterial__Group_0_2__1__Impl )
            // InternalMTL.g:519:2: rule__PhongMaterial__Group_0_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PhongMaterial__Group_0_2__1__Impl();

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
    // $ANTLR end "rule__PhongMaterial__Group_0_2__1"


    // $ANTLR start "rule__PhongMaterial__Group_0_2__1__Impl"
    // InternalMTL.g:525:1: rule__PhongMaterial__Group_0_2__1__Impl : ( ( rule__PhongMaterial__AmbientAssignment_0_2_1 ) ) ;
    public final void rule__PhongMaterial__Group_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:529:1: ( ( ( rule__PhongMaterial__AmbientAssignment_0_2_1 ) ) )
            // InternalMTL.g:530:1: ( ( rule__PhongMaterial__AmbientAssignment_0_2_1 ) )
            {
            // InternalMTL.g:530:1: ( ( rule__PhongMaterial__AmbientAssignment_0_2_1 ) )
            // InternalMTL.g:531:2: ( rule__PhongMaterial__AmbientAssignment_0_2_1 )
            {
             before(grammarAccess.getPhongMaterialAccess().getAmbientAssignment_0_2_1()); 
            // InternalMTL.g:532:2: ( rule__PhongMaterial__AmbientAssignment_0_2_1 )
            // InternalMTL.g:532:3: rule__PhongMaterial__AmbientAssignment_0_2_1
            {
            pushFollow(FOLLOW_2);
            rule__PhongMaterial__AmbientAssignment_0_2_1();

            state._fsp--;


            }

             after(grammarAccess.getPhongMaterialAccess().getAmbientAssignment_0_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__Group_0_2__1__Impl"


    // $ANTLR start "rule__PhongMaterial__Group_1__0"
    // InternalMTL.g:541:1: rule__PhongMaterial__Group_1__0 : rule__PhongMaterial__Group_1__0__Impl rule__PhongMaterial__Group_1__1 ;
    public final void rule__PhongMaterial__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:545:1: ( rule__PhongMaterial__Group_1__0__Impl rule__PhongMaterial__Group_1__1 )
            // InternalMTL.g:546:2: rule__PhongMaterial__Group_1__0__Impl rule__PhongMaterial__Group_1__1
            {
            pushFollow(FOLLOW_7);
            rule__PhongMaterial__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhongMaterial__Group_1__1();

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
    // $ANTLR end "rule__PhongMaterial__Group_1__0"


    // $ANTLR start "rule__PhongMaterial__Group_1__0__Impl"
    // InternalMTL.g:553:1: rule__PhongMaterial__Group_1__0__Impl : ( 'Kd' ) ;
    public final void rule__PhongMaterial__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:557:1: ( ( 'Kd' ) )
            // InternalMTL.g:558:1: ( 'Kd' )
            {
            // InternalMTL.g:558:1: ( 'Kd' )
            // InternalMTL.g:559:2: 'Kd'
            {
             before(grammarAccess.getPhongMaterialAccess().getKdKeyword_1_0()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getPhongMaterialAccess().getKdKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__Group_1__0__Impl"


    // $ANTLR start "rule__PhongMaterial__Group_1__1"
    // InternalMTL.g:568:1: rule__PhongMaterial__Group_1__1 : rule__PhongMaterial__Group_1__1__Impl ;
    public final void rule__PhongMaterial__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:572:1: ( rule__PhongMaterial__Group_1__1__Impl )
            // InternalMTL.g:573:2: rule__PhongMaterial__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PhongMaterial__Group_1__1__Impl();

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
    // $ANTLR end "rule__PhongMaterial__Group_1__1"


    // $ANTLR start "rule__PhongMaterial__Group_1__1__Impl"
    // InternalMTL.g:579:1: rule__PhongMaterial__Group_1__1__Impl : ( ( rule__PhongMaterial__DiffuseAssignment_1_1 ) ) ;
    public final void rule__PhongMaterial__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:583:1: ( ( ( rule__PhongMaterial__DiffuseAssignment_1_1 ) ) )
            // InternalMTL.g:584:1: ( ( rule__PhongMaterial__DiffuseAssignment_1_1 ) )
            {
            // InternalMTL.g:584:1: ( ( rule__PhongMaterial__DiffuseAssignment_1_1 ) )
            // InternalMTL.g:585:2: ( rule__PhongMaterial__DiffuseAssignment_1_1 )
            {
             before(grammarAccess.getPhongMaterialAccess().getDiffuseAssignment_1_1()); 
            // InternalMTL.g:586:2: ( rule__PhongMaterial__DiffuseAssignment_1_1 )
            // InternalMTL.g:586:3: rule__PhongMaterial__DiffuseAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__PhongMaterial__DiffuseAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getPhongMaterialAccess().getDiffuseAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__Group_1__1__Impl"


    // $ANTLR start "rule__PhongMaterial__Group_2__0"
    // InternalMTL.g:595:1: rule__PhongMaterial__Group_2__0 : rule__PhongMaterial__Group_2__0__Impl rule__PhongMaterial__Group_2__1 ;
    public final void rule__PhongMaterial__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:599:1: ( rule__PhongMaterial__Group_2__0__Impl rule__PhongMaterial__Group_2__1 )
            // InternalMTL.g:600:2: rule__PhongMaterial__Group_2__0__Impl rule__PhongMaterial__Group_2__1
            {
            pushFollow(FOLLOW_7);
            rule__PhongMaterial__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhongMaterial__Group_2__1();

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
    // $ANTLR end "rule__PhongMaterial__Group_2__0"


    // $ANTLR start "rule__PhongMaterial__Group_2__0__Impl"
    // InternalMTL.g:607:1: rule__PhongMaterial__Group_2__0__Impl : ( 'Ks' ) ;
    public final void rule__PhongMaterial__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:611:1: ( ( 'Ks' ) )
            // InternalMTL.g:612:1: ( 'Ks' )
            {
            // InternalMTL.g:612:1: ( 'Ks' )
            // InternalMTL.g:613:2: 'Ks'
            {
             before(grammarAccess.getPhongMaterialAccess().getKsKeyword_2_0()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getPhongMaterialAccess().getKsKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__Group_2__0__Impl"


    // $ANTLR start "rule__PhongMaterial__Group_2__1"
    // InternalMTL.g:622:1: rule__PhongMaterial__Group_2__1 : rule__PhongMaterial__Group_2__1__Impl rule__PhongMaterial__Group_2__2 ;
    public final void rule__PhongMaterial__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:626:1: ( rule__PhongMaterial__Group_2__1__Impl rule__PhongMaterial__Group_2__2 )
            // InternalMTL.g:627:2: rule__PhongMaterial__Group_2__1__Impl rule__PhongMaterial__Group_2__2
            {
            pushFollow(FOLLOW_8);
            rule__PhongMaterial__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhongMaterial__Group_2__2();

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
    // $ANTLR end "rule__PhongMaterial__Group_2__1"


    // $ANTLR start "rule__PhongMaterial__Group_2__1__Impl"
    // InternalMTL.g:634:1: rule__PhongMaterial__Group_2__1__Impl : ( ( rule__PhongMaterial__SpecularAssignment_2_1 ) ) ;
    public final void rule__PhongMaterial__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:638:1: ( ( ( rule__PhongMaterial__SpecularAssignment_2_1 ) ) )
            // InternalMTL.g:639:1: ( ( rule__PhongMaterial__SpecularAssignment_2_1 ) )
            {
            // InternalMTL.g:639:1: ( ( rule__PhongMaterial__SpecularAssignment_2_1 ) )
            // InternalMTL.g:640:2: ( rule__PhongMaterial__SpecularAssignment_2_1 )
            {
             before(grammarAccess.getPhongMaterialAccess().getSpecularAssignment_2_1()); 
            // InternalMTL.g:641:2: ( rule__PhongMaterial__SpecularAssignment_2_1 )
            // InternalMTL.g:641:3: rule__PhongMaterial__SpecularAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__PhongMaterial__SpecularAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getPhongMaterialAccess().getSpecularAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__Group_2__1__Impl"


    // $ANTLR start "rule__PhongMaterial__Group_2__2"
    // InternalMTL.g:649:1: rule__PhongMaterial__Group_2__2 : rule__PhongMaterial__Group_2__2__Impl ;
    public final void rule__PhongMaterial__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:653:1: ( rule__PhongMaterial__Group_2__2__Impl )
            // InternalMTL.g:654:2: rule__PhongMaterial__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PhongMaterial__Group_2__2__Impl();

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
    // $ANTLR end "rule__PhongMaterial__Group_2__2"


    // $ANTLR start "rule__PhongMaterial__Group_2__2__Impl"
    // InternalMTL.g:660:1: rule__PhongMaterial__Group_2__2__Impl : ( ( rule__PhongMaterial__Group_2_2__0 )? ) ;
    public final void rule__PhongMaterial__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:664:1: ( ( ( rule__PhongMaterial__Group_2_2__0 )? ) )
            // InternalMTL.g:665:1: ( ( rule__PhongMaterial__Group_2_2__0 )? )
            {
            // InternalMTL.g:665:1: ( ( rule__PhongMaterial__Group_2_2__0 )? )
            // InternalMTL.g:666:2: ( rule__PhongMaterial__Group_2_2__0 )?
            {
             before(grammarAccess.getPhongMaterialAccess().getGroup_2_2()); 
            // InternalMTL.g:667:2: ( rule__PhongMaterial__Group_2_2__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==22) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalMTL.g:667:3: rule__PhongMaterial__Group_2_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PhongMaterial__Group_2_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPhongMaterialAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__Group_2__2__Impl"


    // $ANTLR start "rule__PhongMaterial__Group_2_2__0"
    // InternalMTL.g:676:1: rule__PhongMaterial__Group_2_2__0 : rule__PhongMaterial__Group_2_2__0__Impl rule__PhongMaterial__Group_2_2__1 ;
    public final void rule__PhongMaterial__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:680:1: ( rule__PhongMaterial__Group_2_2__0__Impl rule__PhongMaterial__Group_2_2__1 )
            // InternalMTL.g:681:2: rule__PhongMaterial__Group_2_2__0__Impl rule__PhongMaterial__Group_2_2__1
            {
            pushFollow(FOLLOW_7);
            rule__PhongMaterial__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhongMaterial__Group_2_2__1();

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
    // $ANTLR end "rule__PhongMaterial__Group_2_2__0"


    // $ANTLR start "rule__PhongMaterial__Group_2_2__0__Impl"
    // InternalMTL.g:688:1: rule__PhongMaterial__Group_2_2__0__Impl : ( 'Ns' ) ;
    public final void rule__PhongMaterial__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:692:1: ( ( 'Ns' ) )
            // InternalMTL.g:693:1: ( 'Ns' )
            {
            // InternalMTL.g:693:1: ( 'Ns' )
            // InternalMTL.g:694:2: 'Ns'
            {
             before(grammarAccess.getPhongMaterialAccess().getNsKeyword_2_2_0()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getPhongMaterialAccess().getNsKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__Group_2_2__0__Impl"


    // $ANTLR start "rule__PhongMaterial__Group_2_2__1"
    // InternalMTL.g:703:1: rule__PhongMaterial__Group_2_2__1 : rule__PhongMaterial__Group_2_2__1__Impl ;
    public final void rule__PhongMaterial__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:707:1: ( rule__PhongMaterial__Group_2_2__1__Impl )
            // InternalMTL.g:708:2: rule__PhongMaterial__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PhongMaterial__Group_2_2__1__Impl();

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
    // $ANTLR end "rule__PhongMaterial__Group_2_2__1"


    // $ANTLR start "rule__PhongMaterial__Group_2_2__1__Impl"
    // InternalMTL.g:714:1: rule__PhongMaterial__Group_2_2__1__Impl : ( ( rule__PhongMaterial__SpecularExponentAssignment_2_2_1 ) ) ;
    public final void rule__PhongMaterial__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:718:1: ( ( ( rule__PhongMaterial__SpecularExponentAssignment_2_2_1 ) ) )
            // InternalMTL.g:719:1: ( ( rule__PhongMaterial__SpecularExponentAssignment_2_2_1 ) )
            {
            // InternalMTL.g:719:1: ( ( rule__PhongMaterial__SpecularExponentAssignment_2_2_1 ) )
            // InternalMTL.g:720:2: ( rule__PhongMaterial__SpecularExponentAssignment_2_2_1 )
            {
             before(grammarAccess.getPhongMaterialAccess().getSpecularExponentAssignment_2_2_1()); 
            // InternalMTL.g:721:2: ( rule__PhongMaterial__SpecularExponentAssignment_2_2_1 )
            // InternalMTL.g:721:3: rule__PhongMaterial__SpecularExponentAssignment_2_2_1
            {
            pushFollow(FOLLOW_2);
            rule__PhongMaterial__SpecularExponentAssignment_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getPhongMaterialAccess().getSpecularExponentAssignment_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__Group_2_2__1__Impl"


    // $ANTLR start "rule__PhongMaterial__Group_3_0__0"
    // InternalMTL.g:730:1: rule__PhongMaterial__Group_3_0__0 : rule__PhongMaterial__Group_3_0__0__Impl rule__PhongMaterial__Group_3_0__1 ;
    public final void rule__PhongMaterial__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:734:1: ( rule__PhongMaterial__Group_3_0__0__Impl rule__PhongMaterial__Group_3_0__1 )
            // InternalMTL.g:735:2: rule__PhongMaterial__Group_3_0__0__Impl rule__PhongMaterial__Group_3_0__1
            {
            pushFollow(FOLLOW_7);
            rule__PhongMaterial__Group_3_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhongMaterial__Group_3_0__1();

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
    // $ANTLR end "rule__PhongMaterial__Group_3_0__0"


    // $ANTLR start "rule__PhongMaterial__Group_3_0__0__Impl"
    // InternalMTL.g:742:1: rule__PhongMaterial__Group_3_0__0__Impl : ( 'd' ) ;
    public final void rule__PhongMaterial__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:746:1: ( ( 'd' ) )
            // InternalMTL.g:747:1: ( 'd' )
            {
            // InternalMTL.g:747:1: ( 'd' )
            // InternalMTL.g:748:2: 'd'
            {
             before(grammarAccess.getPhongMaterialAccess().getDKeyword_3_0_0()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getPhongMaterialAccess().getDKeyword_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__Group_3_0__0__Impl"


    // $ANTLR start "rule__PhongMaterial__Group_3_0__1"
    // InternalMTL.g:757:1: rule__PhongMaterial__Group_3_0__1 : rule__PhongMaterial__Group_3_0__1__Impl ;
    public final void rule__PhongMaterial__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:761:1: ( rule__PhongMaterial__Group_3_0__1__Impl )
            // InternalMTL.g:762:2: rule__PhongMaterial__Group_3_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PhongMaterial__Group_3_0__1__Impl();

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
    // $ANTLR end "rule__PhongMaterial__Group_3_0__1"


    // $ANTLR start "rule__PhongMaterial__Group_3_0__1__Impl"
    // InternalMTL.g:768:1: rule__PhongMaterial__Group_3_0__1__Impl : ( ( rule__PhongMaterial__OpaqueAssignment_3_0_1 ) ) ;
    public final void rule__PhongMaterial__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:772:1: ( ( ( rule__PhongMaterial__OpaqueAssignment_3_0_1 ) ) )
            // InternalMTL.g:773:1: ( ( rule__PhongMaterial__OpaqueAssignment_3_0_1 ) )
            {
            // InternalMTL.g:773:1: ( ( rule__PhongMaterial__OpaqueAssignment_3_0_1 ) )
            // InternalMTL.g:774:2: ( rule__PhongMaterial__OpaqueAssignment_3_0_1 )
            {
             before(grammarAccess.getPhongMaterialAccess().getOpaqueAssignment_3_0_1()); 
            // InternalMTL.g:775:2: ( rule__PhongMaterial__OpaqueAssignment_3_0_1 )
            // InternalMTL.g:775:3: rule__PhongMaterial__OpaqueAssignment_3_0_1
            {
            pushFollow(FOLLOW_2);
            rule__PhongMaterial__OpaqueAssignment_3_0_1();

            state._fsp--;


            }

             after(grammarAccess.getPhongMaterialAccess().getOpaqueAssignment_3_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__Group_3_0__1__Impl"


    // $ANTLR start "rule__PhongMaterial__Group_3_1__0"
    // InternalMTL.g:784:1: rule__PhongMaterial__Group_3_1__0 : rule__PhongMaterial__Group_3_1__0__Impl rule__PhongMaterial__Group_3_1__1 ;
    public final void rule__PhongMaterial__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:788:1: ( rule__PhongMaterial__Group_3_1__0__Impl rule__PhongMaterial__Group_3_1__1 )
            // InternalMTL.g:789:2: rule__PhongMaterial__Group_3_1__0__Impl rule__PhongMaterial__Group_3_1__1
            {
            pushFollow(FOLLOW_7);
            rule__PhongMaterial__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhongMaterial__Group_3_1__1();

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
    // $ANTLR end "rule__PhongMaterial__Group_3_1__0"


    // $ANTLR start "rule__PhongMaterial__Group_3_1__0__Impl"
    // InternalMTL.g:796:1: rule__PhongMaterial__Group_3_1__0__Impl : ( 'Tr' ) ;
    public final void rule__PhongMaterial__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:800:1: ( ( 'Tr' ) )
            // InternalMTL.g:801:1: ( 'Tr' )
            {
            // InternalMTL.g:801:1: ( 'Tr' )
            // InternalMTL.g:802:2: 'Tr'
            {
             before(grammarAccess.getPhongMaterialAccess().getTrKeyword_3_1_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getPhongMaterialAccess().getTrKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__Group_3_1__0__Impl"


    // $ANTLR start "rule__PhongMaterial__Group_3_1__1"
    // InternalMTL.g:811:1: rule__PhongMaterial__Group_3_1__1 : rule__PhongMaterial__Group_3_1__1__Impl ;
    public final void rule__PhongMaterial__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:815:1: ( rule__PhongMaterial__Group_3_1__1__Impl )
            // InternalMTL.g:816:2: rule__PhongMaterial__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PhongMaterial__Group_3_1__1__Impl();

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
    // $ANTLR end "rule__PhongMaterial__Group_3_1__1"


    // $ANTLR start "rule__PhongMaterial__Group_3_1__1__Impl"
    // InternalMTL.g:822:1: rule__PhongMaterial__Group_3_1__1__Impl : ( ( rule__PhongMaterial__TransparentAssignment_3_1_1 ) ) ;
    public final void rule__PhongMaterial__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:826:1: ( ( ( rule__PhongMaterial__TransparentAssignment_3_1_1 ) ) )
            // InternalMTL.g:827:1: ( ( rule__PhongMaterial__TransparentAssignment_3_1_1 ) )
            {
            // InternalMTL.g:827:1: ( ( rule__PhongMaterial__TransparentAssignment_3_1_1 ) )
            // InternalMTL.g:828:2: ( rule__PhongMaterial__TransparentAssignment_3_1_1 )
            {
             before(grammarAccess.getPhongMaterialAccess().getTransparentAssignment_3_1_1()); 
            // InternalMTL.g:829:2: ( rule__PhongMaterial__TransparentAssignment_3_1_1 )
            // InternalMTL.g:829:3: rule__PhongMaterial__TransparentAssignment_3_1_1
            {
            pushFollow(FOLLOW_2);
            rule__PhongMaterial__TransparentAssignment_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getPhongMaterialAccess().getTransparentAssignment_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__Group_3_1__1__Impl"


    // $ANTLR start "rule__PhongMaterial__Group_4__0"
    // InternalMTL.g:838:1: rule__PhongMaterial__Group_4__0 : rule__PhongMaterial__Group_4__0__Impl rule__PhongMaterial__Group_4__1 ;
    public final void rule__PhongMaterial__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:842:1: ( rule__PhongMaterial__Group_4__0__Impl rule__PhongMaterial__Group_4__1 )
            // InternalMTL.g:843:2: rule__PhongMaterial__Group_4__0__Impl rule__PhongMaterial__Group_4__1
            {
            pushFollow(FOLLOW_7);
            rule__PhongMaterial__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PhongMaterial__Group_4__1();

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
    // $ANTLR end "rule__PhongMaterial__Group_4__0"


    // $ANTLR start "rule__PhongMaterial__Group_4__0__Impl"
    // InternalMTL.g:850:1: rule__PhongMaterial__Group_4__0__Impl : ( 'illum' ) ;
    public final void rule__PhongMaterial__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:854:1: ( ( 'illum' ) )
            // InternalMTL.g:855:1: ( 'illum' )
            {
            // InternalMTL.g:855:1: ( 'illum' )
            // InternalMTL.g:856:2: 'illum'
            {
             before(grammarAccess.getPhongMaterialAccess().getIllumKeyword_4_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getPhongMaterialAccess().getIllumKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__Group_4__0__Impl"


    // $ANTLR start "rule__PhongMaterial__Group_4__1"
    // InternalMTL.g:865:1: rule__PhongMaterial__Group_4__1 : rule__PhongMaterial__Group_4__1__Impl ;
    public final void rule__PhongMaterial__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:869:1: ( rule__PhongMaterial__Group_4__1__Impl )
            // InternalMTL.g:870:2: rule__PhongMaterial__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PhongMaterial__Group_4__1__Impl();

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
    // $ANTLR end "rule__PhongMaterial__Group_4__1"


    // $ANTLR start "rule__PhongMaterial__Group_4__1__Impl"
    // InternalMTL.g:876:1: rule__PhongMaterial__Group_4__1__Impl : ( ( rule__PhongMaterial__IlluminationAssignment_4_1 ) ) ;
    public final void rule__PhongMaterial__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:880:1: ( ( ( rule__PhongMaterial__IlluminationAssignment_4_1 ) ) )
            // InternalMTL.g:881:1: ( ( rule__PhongMaterial__IlluminationAssignment_4_1 ) )
            {
            // InternalMTL.g:881:1: ( ( rule__PhongMaterial__IlluminationAssignment_4_1 ) )
            // InternalMTL.g:882:2: ( rule__PhongMaterial__IlluminationAssignment_4_1 )
            {
             before(grammarAccess.getPhongMaterialAccess().getIlluminationAssignment_4_1()); 
            // InternalMTL.g:883:2: ( rule__PhongMaterial__IlluminationAssignment_4_1 )
            // InternalMTL.g:883:3: rule__PhongMaterial__IlluminationAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__PhongMaterial__IlluminationAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getPhongMaterialAccess().getIlluminationAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__Group_4__1__Impl"


    // $ANTLR start "rule__TexturedMaterial__Group_0__0"
    // InternalMTL.g:892:1: rule__TexturedMaterial__Group_0__0 : rule__TexturedMaterial__Group_0__0__Impl rule__TexturedMaterial__Group_0__1 ;
    public final void rule__TexturedMaterial__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:896:1: ( rule__TexturedMaterial__Group_0__0__Impl rule__TexturedMaterial__Group_0__1 )
            // InternalMTL.g:897:2: rule__TexturedMaterial__Group_0__0__Impl rule__TexturedMaterial__Group_0__1
            {
            pushFollow(FOLLOW_5);
            rule__TexturedMaterial__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_0__1();

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
    // $ANTLR end "rule__TexturedMaterial__Group_0__0"


    // $ANTLR start "rule__TexturedMaterial__Group_0__0__Impl"
    // InternalMTL.g:904:1: rule__TexturedMaterial__Group_0__0__Impl : ( 'newmtl' ) ;
    public final void rule__TexturedMaterial__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:908:1: ( ( 'newmtl' ) )
            // InternalMTL.g:909:1: ( 'newmtl' )
            {
            // InternalMTL.g:909:1: ( 'newmtl' )
            // InternalMTL.g:910:2: 'newmtl'
            {
             before(grammarAccess.getTexturedMaterialAccess().getNewmtlKeyword_0_0()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getTexturedMaterialAccess().getNewmtlKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__Group_0__0__Impl"


    // $ANTLR start "rule__TexturedMaterial__Group_0__1"
    // InternalMTL.g:919:1: rule__TexturedMaterial__Group_0__1 : rule__TexturedMaterial__Group_0__1__Impl rule__TexturedMaterial__Group_0__2 ;
    public final void rule__TexturedMaterial__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:923:1: ( rule__TexturedMaterial__Group_0__1__Impl rule__TexturedMaterial__Group_0__2 )
            // InternalMTL.g:924:2: rule__TexturedMaterial__Group_0__1__Impl rule__TexturedMaterial__Group_0__2
            {
            pushFollow(FOLLOW_6);
            rule__TexturedMaterial__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_0__2();

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
    // $ANTLR end "rule__TexturedMaterial__Group_0__1"


    // $ANTLR start "rule__TexturedMaterial__Group_0__1__Impl"
    // InternalMTL.g:931:1: rule__TexturedMaterial__Group_0__1__Impl : ( ( rule__TexturedMaterial__NameAssignment_0_1 ) ) ;
    public final void rule__TexturedMaterial__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:935:1: ( ( ( rule__TexturedMaterial__NameAssignment_0_1 ) ) )
            // InternalMTL.g:936:1: ( ( rule__TexturedMaterial__NameAssignment_0_1 ) )
            {
            // InternalMTL.g:936:1: ( ( rule__TexturedMaterial__NameAssignment_0_1 ) )
            // InternalMTL.g:937:2: ( rule__TexturedMaterial__NameAssignment_0_1 )
            {
             before(grammarAccess.getTexturedMaterialAccess().getNameAssignment_0_1()); 
            // InternalMTL.g:938:2: ( rule__TexturedMaterial__NameAssignment_0_1 )
            // InternalMTL.g:938:3: rule__TexturedMaterial__NameAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__NameAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getTexturedMaterialAccess().getNameAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__Group_0__1__Impl"


    // $ANTLR start "rule__TexturedMaterial__Group_0__2"
    // InternalMTL.g:946:1: rule__TexturedMaterial__Group_0__2 : rule__TexturedMaterial__Group_0__2__Impl ;
    public final void rule__TexturedMaterial__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:950:1: ( rule__TexturedMaterial__Group_0__2__Impl )
            // InternalMTL.g:951:2: rule__TexturedMaterial__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_0__2__Impl();

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
    // $ANTLR end "rule__TexturedMaterial__Group_0__2"


    // $ANTLR start "rule__TexturedMaterial__Group_0__2__Impl"
    // InternalMTL.g:957:1: rule__TexturedMaterial__Group_0__2__Impl : ( ( rule__TexturedMaterial__Group_0_2__0 ) ) ;
    public final void rule__TexturedMaterial__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:961:1: ( ( ( rule__TexturedMaterial__Group_0_2__0 ) ) )
            // InternalMTL.g:962:1: ( ( rule__TexturedMaterial__Group_0_2__0 ) )
            {
            // InternalMTL.g:962:1: ( ( rule__TexturedMaterial__Group_0_2__0 ) )
            // InternalMTL.g:963:2: ( rule__TexturedMaterial__Group_0_2__0 )
            {
             before(grammarAccess.getTexturedMaterialAccess().getGroup_0_2()); 
            // InternalMTL.g:964:2: ( rule__TexturedMaterial__Group_0_2__0 )
            // InternalMTL.g:964:3: rule__TexturedMaterial__Group_0_2__0
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_0_2__0();

            state._fsp--;


            }

             after(grammarAccess.getTexturedMaterialAccess().getGroup_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__Group_0__2__Impl"


    // $ANTLR start "rule__TexturedMaterial__Group_0_2__0"
    // InternalMTL.g:973:1: rule__TexturedMaterial__Group_0_2__0 : rule__TexturedMaterial__Group_0_2__0__Impl rule__TexturedMaterial__Group_0_2__1 ;
    public final void rule__TexturedMaterial__Group_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:977:1: ( rule__TexturedMaterial__Group_0_2__0__Impl rule__TexturedMaterial__Group_0_2__1 )
            // InternalMTL.g:978:2: rule__TexturedMaterial__Group_0_2__0__Impl rule__TexturedMaterial__Group_0_2__1
            {
            pushFollow(FOLLOW_7);
            rule__TexturedMaterial__Group_0_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_0_2__1();

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
    // $ANTLR end "rule__TexturedMaterial__Group_0_2__0"


    // $ANTLR start "rule__TexturedMaterial__Group_0_2__0__Impl"
    // InternalMTL.g:985:1: rule__TexturedMaterial__Group_0_2__0__Impl : ( 'Ka' ) ;
    public final void rule__TexturedMaterial__Group_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:989:1: ( ( 'Ka' ) )
            // InternalMTL.g:990:1: ( 'Ka' )
            {
            // InternalMTL.g:990:1: ( 'Ka' )
            // InternalMTL.g:991:2: 'Ka'
            {
             before(grammarAccess.getTexturedMaterialAccess().getKaKeyword_0_2_0()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getTexturedMaterialAccess().getKaKeyword_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__Group_0_2__0__Impl"


    // $ANTLR start "rule__TexturedMaterial__Group_0_2__1"
    // InternalMTL.g:1000:1: rule__TexturedMaterial__Group_0_2__1 : rule__TexturedMaterial__Group_0_2__1__Impl ;
    public final void rule__TexturedMaterial__Group_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1004:1: ( rule__TexturedMaterial__Group_0_2__1__Impl )
            // InternalMTL.g:1005:2: rule__TexturedMaterial__Group_0_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_0_2__1__Impl();

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
    // $ANTLR end "rule__TexturedMaterial__Group_0_2__1"


    // $ANTLR start "rule__TexturedMaterial__Group_0_2__1__Impl"
    // InternalMTL.g:1011:1: rule__TexturedMaterial__Group_0_2__1__Impl : ( ( rule__TexturedMaterial__AmbientAssignment_0_2_1 ) ) ;
    public final void rule__TexturedMaterial__Group_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1015:1: ( ( ( rule__TexturedMaterial__AmbientAssignment_0_2_1 ) ) )
            // InternalMTL.g:1016:1: ( ( rule__TexturedMaterial__AmbientAssignment_0_2_1 ) )
            {
            // InternalMTL.g:1016:1: ( ( rule__TexturedMaterial__AmbientAssignment_0_2_1 ) )
            // InternalMTL.g:1017:2: ( rule__TexturedMaterial__AmbientAssignment_0_2_1 )
            {
             before(grammarAccess.getTexturedMaterialAccess().getAmbientAssignment_0_2_1()); 
            // InternalMTL.g:1018:2: ( rule__TexturedMaterial__AmbientAssignment_0_2_1 )
            // InternalMTL.g:1018:3: rule__TexturedMaterial__AmbientAssignment_0_2_1
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__AmbientAssignment_0_2_1();

            state._fsp--;


            }

             after(grammarAccess.getTexturedMaterialAccess().getAmbientAssignment_0_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__Group_0_2__1__Impl"


    // $ANTLR start "rule__TexturedMaterial__Group_1__0"
    // InternalMTL.g:1027:1: rule__TexturedMaterial__Group_1__0 : rule__TexturedMaterial__Group_1__0__Impl rule__TexturedMaterial__Group_1__1 ;
    public final void rule__TexturedMaterial__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1031:1: ( rule__TexturedMaterial__Group_1__0__Impl rule__TexturedMaterial__Group_1__1 )
            // InternalMTL.g:1032:2: rule__TexturedMaterial__Group_1__0__Impl rule__TexturedMaterial__Group_1__1
            {
            pushFollow(FOLLOW_7);
            rule__TexturedMaterial__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_1__1();

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
    // $ANTLR end "rule__TexturedMaterial__Group_1__0"


    // $ANTLR start "rule__TexturedMaterial__Group_1__0__Impl"
    // InternalMTL.g:1039:1: rule__TexturedMaterial__Group_1__0__Impl : ( 'Kd' ) ;
    public final void rule__TexturedMaterial__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1043:1: ( ( 'Kd' ) )
            // InternalMTL.g:1044:1: ( 'Kd' )
            {
            // InternalMTL.g:1044:1: ( 'Kd' )
            // InternalMTL.g:1045:2: 'Kd'
            {
             before(grammarAccess.getTexturedMaterialAccess().getKdKeyword_1_0()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getTexturedMaterialAccess().getKdKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__Group_1__0__Impl"


    // $ANTLR start "rule__TexturedMaterial__Group_1__1"
    // InternalMTL.g:1054:1: rule__TexturedMaterial__Group_1__1 : rule__TexturedMaterial__Group_1__1__Impl ;
    public final void rule__TexturedMaterial__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1058:1: ( rule__TexturedMaterial__Group_1__1__Impl )
            // InternalMTL.g:1059:2: rule__TexturedMaterial__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_1__1__Impl();

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
    // $ANTLR end "rule__TexturedMaterial__Group_1__1"


    // $ANTLR start "rule__TexturedMaterial__Group_1__1__Impl"
    // InternalMTL.g:1065:1: rule__TexturedMaterial__Group_1__1__Impl : ( ( rule__TexturedMaterial__DiffuseAssignment_1_1 ) ) ;
    public final void rule__TexturedMaterial__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1069:1: ( ( ( rule__TexturedMaterial__DiffuseAssignment_1_1 ) ) )
            // InternalMTL.g:1070:1: ( ( rule__TexturedMaterial__DiffuseAssignment_1_1 ) )
            {
            // InternalMTL.g:1070:1: ( ( rule__TexturedMaterial__DiffuseAssignment_1_1 ) )
            // InternalMTL.g:1071:2: ( rule__TexturedMaterial__DiffuseAssignment_1_1 )
            {
             before(grammarAccess.getTexturedMaterialAccess().getDiffuseAssignment_1_1()); 
            // InternalMTL.g:1072:2: ( rule__TexturedMaterial__DiffuseAssignment_1_1 )
            // InternalMTL.g:1072:3: rule__TexturedMaterial__DiffuseAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__DiffuseAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTexturedMaterialAccess().getDiffuseAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__Group_1__1__Impl"


    // $ANTLR start "rule__TexturedMaterial__Group_2__0"
    // InternalMTL.g:1081:1: rule__TexturedMaterial__Group_2__0 : rule__TexturedMaterial__Group_2__0__Impl rule__TexturedMaterial__Group_2__1 ;
    public final void rule__TexturedMaterial__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1085:1: ( rule__TexturedMaterial__Group_2__0__Impl rule__TexturedMaterial__Group_2__1 )
            // InternalMTL.g:1086:2: rule__TexturedMaterial__Group_2__0__Impl rule__TexturedMaterial__Group_2__1
            {
            pushFollow(FOLLOW_7);
            rule__TexturedMaterial__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_2__1();

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
    // $ANTLR end "rule__TexturedMaterial__Group_2__0"


    // $ANTLR start "rule__TexturedMaterial__Group_2__0__Impl"
    // InternalMTL.g:1093:1: rule__TexturedMaterial__Group_2__0__Impl : ( 'Ks' ) ;
    public final void rule__TexturedMaterial__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1097:1: ( ( 'Ks' ) )
            // InternalMTL.g:1098:1: ( 'Ks' )
            {
            // InternalMTL.g:1098:1: ( 'Ks' )
            // InternalMTL.g:1099:2: 'Ks'
            {
             before(grammarAccess.getTexturedMaterialAccess().getKsKeyword_2_0()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getTexturedMaterialAccess().getKsKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__Group_2__0__Impl"


    // $ANTLR start "rule__TexturedMaterial__Group_2__1"
    // InternalMTL.g:1108:1: rule__TexturedMaterial__Group_2__1 : rule__TexturedMaterial__Group_2__1__Impl rule__TexturedMaterial__Group_2__2 ;
    public final void rule__TexturedMaterial__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1112:1: ( rule__TexturedMaterial__Group_2__1__Impl rule__TexturedMaterial__Group_2__2 )
            // InternalMTL.g:1113:2: rule__TexturedMaterial__Group_2__1__Impl rule__TexturedMaterial__Group_2__2
            {
            pushFollow(FOLLOW_8);
            rule__TexturedMaterial__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_2__2();

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
    // $ANTLR end "rule__TexturedMaterial__Group_2__1"


    // $ANTLR start "rule__TexturedMaterial__Group_2__1__Impl"
    // InternalMTL.g:1120:1: rule__TexturedMaterial__Group_2__1__Impl : ( ( rule__TexturedMaterial__SpecularAssignment_2_1 ) ) ;
    public final void rule__TexturedMaterial__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1124:1: ( ( ( rule__TexturedMaterial__SpecularAssignment_2_1 ) ) )
            // InternalMTL.g:1125:1: ( ( rule__TexturedMaterial__SpecularAssignment_2_1 ) )
            {
            // InternalMTL.g:1125:1: ( ( rule__TexturedMaterial__SpecularAssignment_2_1 ) )
            // InternalMTL.g:1126:2: ( rule__TexturedMaterial__SpecularAssignment_2_1 )
            {
             before(grammarAccess.getTexturedMaterialAccess().getSpecularAssignment_2_1()); 
            // InternalMTL.g:1127:2: ( rule__TexturedMaterial__SpecularAssignment_2_1 )
            // InternalMTL.g:1127:3: rule__TexturedMaterial__SpecularAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__SpecularAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getTexturedMaterialAccess().getSpecularAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__Group_2__1__Impl"


    // $ANTLR start "rule__TexturedMaterial__Group_2__2"
    // InternalMTL.g:1135:1: rule__TexturedMaterial__Group_2__2 : rule__TexturedMaterial__Group_2__2__Impl ;
    public final void rule__TexturedMaterial__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1139:1: ( rule__TexturedMaterial__Group_2__2__Impl )
            // InternalMTL.g:1140:2: rule__TexturedMaterial__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_2__2__Impl();

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
    // $ANTLR end "rule__TexturedMaterial__Group_2__2"


    // $ANTLR start "rule__TexturedMaterial__Group_2__2__Impl"
    // InternalMTL.g:1146:1: rule__TexturedMaterial__Group_2__2__Impl : ( ( rule__TexturedMaterial__Group_2_2__0 )? ) ;
    public final void rule__TexturedMaterial__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1150:1: ( ( ( rule__TexturedMaterial__Group_2_2__0 )? ) )
            // InternalMTL.g:1151:1: ( ( rule__TexturedMaterial__Group_2_2__0 )? )
            {
            // InternalMTL.g:1151:1: ( ( rule__TexturedMaterial__Group_2_2__0 )? )
            // InternalMTL.g:1152:2: ( rule__TexturedMaterial__Group_2_2__0 )?
            {
             before(grammarAccess.getTexturedMaterialAccess().getGroup_2_2()); 
            // InternalMTL.g:1153:2: ( rule__TexturedMaterial__Group_2_2__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==22) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalMTL.g:1153:3: rule__TexturedMaterial__Group_2_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TexturedMaterial__Group_2_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTexturedMaterialAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__Group_2__2__Impl"


    // $ANTLR start "rule__TexturedMaterial__Group_2_2__0"
    // InternalMTL.g:1162:1: rule__TexturedMaterial__Group_2_2__0 : rule__TexturedMaterial__Group_2_2__0__Impl rule__TexturedMaterial__Group_2_2__1 ;
    public final void rule__TexturedMaterial__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1166:1: ( rule__TexturedMaterial__Group_2_2__0__Impl rule__TexturedMaterial__Group_2_2__1 )
            // InternalMTL.g:1167:2: rule__TexturedMaterial__Group_2_2__0__Impl rule__TexturedMaterial__Group_2_2__1
            {
            pushFollow(FOLLOW_7);
            rule__TexturedMaterial__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_2_2__1();

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
    // $ANTLR end "rule__TexturedMaterial__Group_2_2__0"


    // $ANTLR start "rule__TexturedMaterial__Group_2_2__0__Impl"
    // InternalMTL.g:1174:1: rule__TexturedMaterial__Group_2_2__0__Impl : ( 'Ns' ) ;
    public final void rule__TexturedMaterial__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1178:1: ( ( 'Ns' ) )
            // InternalMTL.g:1179:1: ( 'Ns' )
            {
            // InternalMTL.g:1179:1: ( 'Ns' )
            // InternalMTL.g:1180:2: 'Ns'
            {
             before(grammarAccess.getTexturedMaterialAccess().getNsKeyword_2_2_0()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getTexturedMaterialAccess().getNsKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__Group_2_2__0__Impl"


    // $ANTLR start "rule__TexturedMaterial__Group_2_2__1"
    // InternalMTL.g:1189:1: rule__TexturedMaterial__Group_2_2__1 : rule__TexturedMaterial__Group_2_2__1__Impl ;
    public final void rule__TexturedMaterial__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1193:1: ( rule__TexturedMaterial__Group_2_2__1__Impl )
            // InternalMTL.g:1194:2: rule__TexturedMaterial__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_2_2__1__Impl();

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
    // $ANTLR end "rule__TexturedMaterial__Group_2_2__1"


    // $ANTLR start "rule__TexturedMaterial__Group_2_2__1__Impl"
    // InternalMTL.g:1200:1: rule__TexturedMaterial__Group_2_2__1__Impl : ( ( rule__TexturedMaterial__SpecularExponentAssignment_2_2_1 ) ) ;
    public final void rule__TexturedMaterial__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1204:1: ( ( ( rule__TexturedMaterial__SpecularExponentAssignment_2_2_1 ) ) )
            // InternalMTL.g:1205:1: ( ( rule__TexturedMaterial__SpecularExponentAssignment_2_2_1 ) )
            {
            // InternalMTL.g:1205:1: ( ( rule__TexturedMaterial__SpecularExponentAssignment_2_2_1 ) )
            // InternalMTL.g:1206:2: ( rule__TexturedMaterial__SpecularExponentAssignment_2_2_1 )
            {
             before(grammarAccess.getTexturedMaterialAccess().getSpecularExponentAssignment_2_2_1()); 
            // InternalMTL.g:1207:2: ( rule__TexturedMaterial__SpecularExponentAssignment_2_2_1 )
            // InternalMTL.g:1207:3: rule__TexturedMaterial__SpecularExponentAssignment_2_2_1
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__SpecularExponentAssignment_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getTexturedMaterialAccess().getSpecularExponentAssignment_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__Group_2_2__1__Impl"


    // $ANTLR start "rule__TexturedMaterial__Group_3_0__0"
    // InternalMTL.g:1216:1: rule__TexturedMaterial__Group_3_0__0 : rule__TexturedMaterial__Group_3_0__0__Impl rule__TexturedMaterial__Group_3_0__1 ;
    public final void rule__TexturedMaterial__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1220:1: ( rule__TexturedMaterial__Group_3_0__0__Impl rule__TexturedMaterial__Group_3_0__1 )
            // InternalMTL.g:1221:2: rule__TexturedMaterial__Group_3_0__0__Impl rule__TexturedMaterial__Group_3_0__1
            {
            pushFollow(FOLLOW_7);
            rule__TexturedMaterial__Group_3_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_3_0__1();

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
    // $ANTLR end "rule__TexturedMaterial__Group_3_0__0"


    // $ANTLR start "rule__TexturedMaterial__Group_3_0__0__Impl"
    // InternalMTL.g:1228:1: rule__TexturedMaterial__Group_3_0__0__Impl : ( 'd' ) ;
    public final void rule__TexturedMaterial__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1232:1: ( ( 'd' ) )
            // InternalMTL.g:1233:1: ( 'd' )
            {
            // InternalMTL.g:1233:1: ( 'd' )
            // InternalMTL.g:1234:2: 'd'
            {
             before(grammarAccess.getTexturedMaterialAccess().getDKeyword_3_0_0()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getTexturedMaterialAccess().getDKeyword_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__Group_3_0__0__Impl"


    // $ANTLR start "rule__TexturedMaterial__Group_3_0__1"
    // InternalMTL.g:1243:1: rule__TexturedMaterial__Group_3_0__1 : rule__TexturedMaterial__Group_3_0__1__Impl ;
    public final void rule__TexturedMaterial__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1247:1: ( rule__TexturedMaterial__Group_3_0__1__Impl )
            // InternalMTL.g:1248:2: rule__TexturedMaterial__Group_3_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_3_0__1__Impl();

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
    // $ANTLR end "rule__TexturedMaterial__Group_3_0__1"


    // $ANTLR start "rule__TexturedMaterial__Group_3_0__1__Impl"
    // InternalMTL.g:1254:1: rule__TexturedMaterial__Group_3_0__1__Impl : ( ( rule__TexturedMaterial__OpaqueAssignment_3_0_1 ) ) ;
    public final void rule__TexturedMaterial__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1258:1: ( ( ( rule__TexturedMaterial__OpaqueAssignment_3_0_1 ) ) )
            // InternalMTL.g:1259:1: ( ( rule__TexturedMaterial__OpaqueAssignment_3_0_1 ) )
            {
            // InternalMTL.g:1259:1: ( ( rule__TexturedMaterial__OpaqueAssignment_3_0_1 ) )
            // InternalMTL.g:1260:2: ( rule__TexturedMaterial__OpaqueAssignment_3_0_1 )
            {
             before(grammarAccess.getTexturedMaterialAccess().getOpaqueAssignment_3_0_1()); 
            // InternalMTL.g:1261:2: ( rule__TexturedMaterial__OpaqueAssignment_3_0_1 )
            // InternalMTL.g:1261:3: rule__TexturedMaterial__OpaqueAssignment_3_0_1
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__OpaqueAssignment_3_0_1();

            state._fsp--;


            }

             after(grammarAccess.getTexturedMaterialAccess().getOpaqueAssignment_3_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__Group_3_0__1__Impl"


    // $ANTLR start "rule__TexturedMaterial__Group_3_1__0"
    // InternalMTL.g:1270:1: rule__TexturedMaterial__Group_3_1__0 : rule__TexturedMaterial__Group_3_1__0__Impl rule__TexturedMaterial__Group_3_1__1 ;
    public final void rule__TexturedMaterial__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1274:1: ( rule__TexturedMaterial__Group_3_1__0__Impl rule__TexturedMaterial__Group_3_1__1 )
            // InternalMTL.g:1275:2: rule__TexturedMaterial__Group_3_1__0__Impl rule__TexturedMaterial__Group_3_1__1
            {
            pushFollow(FOLLOW_7);
            rule__TexturedMaterial__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_3_1__1();

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
    // $ANTLR end "rule__TexturedMaterial__Group_3_1__0"


    // $ANTLR start "rule__TexturedMaterial__Group_3_1__0__Impl"
    // InternalMTL.g:1282:1: rule__TexturedMaterial__Group_3_1__0__Impl : ( 'Tr' ) ;
    public final void rule__TexturedMaterial__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1286:1: ( ( 'Tr' ) )
            // InternalMTL.g:1287:1: ( 'Tr' )
            {
            // InternalMTL.g:1287:1: ( 'Tr' )
            // InternalMTL.g:1288:2: 'Tr'
            {
             before(grammarAccess.getTexturedMaterialAccess().getTrKeyword_3_1_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getTexturedMaterialAccess().getTrKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__Group_3_1__0__Impl"


    // $ANTLR start "rule__TexturedMaterial__Group_3_1__1"
    // InternalMTL.g:1297:1: rule__TexturedMaterial__Group_3_1__1 : rule__TexturedMaterial__Group_3_1__1__Impl ;
    public final void rule__TexturedMaterial__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1301:1: ( rule__TexturedMaterial__Group_3_1__1__Impl )
            // InternalMTL.g:1302:2: rule__TexturedMaterial__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_3_1__1__Impl();

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
    // $ANTLR end "rule__TexturedMaterial__Group_3_1__1"


    // $ANTLR start "rule__TexturedMaterial__Group_3_1__1__Impl"
    // InternalMTL.g:1308:1: rule__TexturedMaterial__Group_3_1__1__Impl : ( ( rule__TexturedMaterial__TransparentAssignment_3_1_1 ) ) ;
    public final void rule__TexturedMaterial__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1312:1: ( ( ( rule__TexturedMaterial__TransparentAssignment_3_1_1 ) ) )
            // InternalMTL.g:1313:1: ( ( rule__TexturedMaterial__TransparentAssignment_3_1_1 ) )
            {
            // InternalMTL.g:1313:1: ( ( rule__TexturedMaterial__TransparentAssignment_3_1_1 ) )
            // InternalMTL.g:1314:2: ( rule__TexturedMaterial__TransparentAssignment_3_1_1 )
            {
             before(grammarAccess.getTexturedMaterialAccess().getTransparentAssignment_3_1_1()); 
            // InternalMTL.g:1315:2: ( rule__TexturedMaterial__TransparentAssignment_3_1_1 )
            // InternalMTL.g:1315:3: rule__TexturedMaterial__TransparentAssignment_3_1_1
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__TransparentAssignment_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTexturedMaterialAccess().getTransparentAssignment_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__Group_3_1__1__Impl"


    // $ANTLR start "rule__TexturedMaterial__Group_4__0"
    // InternalMTL.g:1324:1: rule__TexturedMaterial__Group_4__0 : rule__TexturedMaterial__Group_4__0__Impl rule__TexturedMaterial__Group_4__1 ;
    public final void rule__TexturedMaterial__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1328:1: ( rule__TexturedMaterial__Group_4__0__Impl rule__TexturedMaterial__Group_4__1 )
            // InternalMTL.g:1329:2: rule__TexturedMaterial__Group_4__0__Impl rule__TexturedMaterial__Group_4__1
            {
            pushFollow(FOLLOW_7);
            rule__TexturedMaterial__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_4__1();

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
    // $ANTLR end "rule__TexturedMaterial__Group_4__0"


    // $ANTLR start "rule__TexturedMaterial__Group_4__0__Impl"
    // InternalMTL.g:1336:1: rule__TexturedMaterial__Group_4__0__Impl : ( 'illum' ) ;
    public final void rule__TexturedMaterial__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1340:1: ( ( 'illum' ) )
            // InternalMTL.g:1341:1: ( 'illum' )
            {
            // InternalMTL.g:1341:1: ( 'illum' )
            // InternalMTL.g:1342:2: 'illum'
            {
             before(grammarAccess.getTexturedMaterialAccess().getIllumKeyword_4_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getTexturedMaterialAccess().getIllumKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__Group_4__0__Impl"


    // $ANTLR start "rule__TexturedMaterial__Group_4__1"
    // InternalMTL.g:1351:1: rule__TexturedMaterial__Group_4__1 : rule__TexturedMaterial__Group_4__1__Impl ;
    public final void rule__TexturedMaterial__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1355:1: ( rule__TexturedMaterial__Group_4__1__Impl )
            // InternalMTL.g:1356:2: rule__TexturedMaterial__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_4__1__Impl();

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
    // $ANTLR end "rule__TexturedMaterial__Group_4__1"


    // $ANTLR start "rule__TexturedMaterial__Group_4__1__Impl"
    // InternalMTL.g:1362:1: rule__TexturedMaterial__Group_4__1__Impl : ( ( rule__TexturedMaterial__IlluminationAssignment_4_1 ) ) ;
    public final void rule__TexturedMaterial__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1366:1: ( ( ( rule__TexturedMaterial__IlluminationAssignment_4_1 ) ) )
            // InternalMTL.g:1367:1: ( ( rule__TexturedMaterial__IlluminationAssignment_4_1 ) )
            {
            // InternalMTL.g:1367:1: ( ( rule__TexturedMaterial__IlluminationAssignment_4_1 ) )
            // InternalMTL.g:1368:2: ( rule__TexturedMaterial__IlluminationAssignment_4_1 )
            {
             before(grammarAccess.getTexturedMaterialAccess().getIlluminationAssignment_4_1()); 
            // InternalMTL.g:1369:2: ( rule__TexturedMaterial__IlluminationAssignment_4_1 )
            // InternalMTL.g:1369:3: rule__TexturedMaterial__IlluminationAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__IlluminationAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getTexturedMaterialAccess().getIlluminationAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__Group_4__1__Impl"


    // $ANTLR start "rule__TexturedMaterial__Group_5__0"
    // InternalMTL.g:1378:1: rule__TexturedMaterial__Group_5__0 : rule__TexturedMaterial__Group_5__0__Impl rule__TexturedMaterial__Group_5__1 ;
    public final void rule__TexturedMaterial__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1382:1: ( rule__TexturedMaterial__Group_5__0__Impl rule__TexturedMaterial__Group_5__1 )
            // InternalMTL.g:1383:2: rule__TexturedMaterial__Group_5__0__Impl rule__TexturedMaterial__Group_5__1
            {
            pushFollow(FOLLOW_5);
            rule__TexturedMaterial__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_5__1();

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
    // $ANTLR end "rule__TexturedMaterial__Group_5__0"


    // $ANTLR start "rule__TexturedMaterial__Group_5__0__Impl"
    // InternalMTL.g:1390:1: rule__TexturedMaterial__Group_5__0__Impl : ( 'map_Ka' ) ;
    public final void rule__TexturedMaterial__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1394:1: ( ( 'map_Ka' ) )
            // InternalMTL.g:1395:1: ( 'map_Ka' )
            {
            // InternalMTL.g:1395:1: ( 'map_Ka' )
            // InternalMTL.g:1396:2: 'map_Ka'
            {
             before(grammarAccess.getTexturedMaterialAccess().getMap_KaKeyword_5_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getTexturedMaterialAccess().getMap_KaKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__Group_5__0__Impl"


    // $ANTLR start "rule__TexturedMaterial__Group_5__1"
    // InternalMTL.g:1405:1: rule__TexturedMaterial__Group_5__1 : rule__TexturedMaterial__Group_5__1__Impl ;
    public final void rule__TexturedMaterial__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1409:1: ( rule__TexturedMaterial__Group_5__1__Impl )
            // InternalMTL.g:1410:2: rule__TexturedMaterial__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_5__1__Impl();

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
    // $ANTLR end "rule__TexturedMaterial__Group_5__1"


    // $ANTLR start "rule__TexturedMaterial__Group_5__1__Impl"
    // InternalMTL.g:1416:1: rule__TexturedMaterial__Group_5__1__Impl : ( ( rule__TexturedMaterial__AmbientMapAssignment_5_1 ) ) ;
    public final void rule__TexturedMaterial__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1420:1: ( ( ( rule__TexturedMaterial__AmbientMapAssignment_5_1 ) ) )
            // InternalMTL.g:1421:1: ( ( rule__TexturedMaterial__AmbientMapAssignment_5_1 ) )
            {
            // InternalMTL.g:1421:1: ( ( rule__TexturedMaterial__AmbientMapAssignment_5_1 ) )
            // InternalMTL.g:1422:2: ( rule__TexturedMaterial__AmbientMapAssignment_5_1 )
            {
             before(grammarAccess.getTexturedMaterialAccess().getAmbientMapAssignment_5_1()); 
            // InternalMTL.g:1423:2: ( rule__TexturedMaterial__AmbientMapAssignment_5_1 )
            // InternalMTL.g:1423:3: rule__TexturedMaterial__AmbientMapAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__AmbientMapAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getTexturedMaterialAccess().getAmbientMapAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__Group_5__1__Impl"


    // $ANTLR start "rule__TexturedMaterial__Group_6__0"
    // InternalMTL.g:1432:1: rule__TexturedMaterial__Group_6__0 : rule__TexturedMaterial__Group_6__0__Impl rule__TexturedMaterial__Group_6__1 ;
    public final void rule__TexturedMaterial__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1436:1: ( rule__TexturedMaterial__Group_6__0__Impl rule__TexturedMaterial__Group_6__1 )
            // InternalMTL.g:1437:2: rule__TexturedMaterial__Group_6__0__Impl rule__TexturedMaterial__Group_6__1
            {
            pushFollow(FOLLOW_5);
            rule__TexturedMaterial__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_6__1();

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
    // $ANTLR end "rule__TexturedMaterial__Group_6__0"


    // $ANTLR start "rule__TexturedMaterial__Group_6__0__Impl"
    // InternalMTL.g:1444:1: rule__TexturedMaterial__Group_6__0__Impl : ( 'map_Kd' ) ;
    public final void rule__TexturedMaterial__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1448:1: ( ( 'map_Kd' ) )
            // InternalMTL.g:1449:1: ( 'map_Kd' )
            {
            // InternalMTL.g:1449:1: ( 'map_Kd' )
            // InternalMTL.g:1450:2: 'map_Kd'
            {
             before(grammarAccess.getTexturedMaterialAccess().getMap_KdKeyword_6_0()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getTexturedMaterialAccess().getMap_KdKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__Group_6__0__Impl"


    // $ANTLR start "rule__TexturedMaterial__Group_6__1"
    // InternalMTL.g:1459:1: rule__TexturedMaterial__Group_6__1 : rule__TexturedMaterial__Group_6__1__Impl ;
    public final void rule__TexturedMaterial__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1463:1: ( rule__TexturedMaterial__Group_6__1__Impl )
            // InternalMTL.g:1464:2: rule__TexturedMaterial__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_6__1__Impl();

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
    // $ANTLR end "rule__TexturedMaterial__Group_6__1"


    // $ANTLR start "rule__TexturedMaterial__Group_6__1__Impl"
    // InternalMTL.g:1470:1: rule__TexturedMaterial__Group_6__1__Impl : ( ( rule__TexturedMaterial__DiffuseMapAssignment_6_1 ) ) ;
    public final void rule__TexturedMaterial__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1474:1: ( ( ( rule__TexturedMaterial__DiffuseMapAssignment_6_1 ) ) )
            // InternalMTL.g:1475:1: ( ( rule__TexturedMaterial__DiffuseMapAssignment_6_1 ) )
            {
            // InternalMTL.g:1475:1: ( ( rule__TexturedMaterial__DiffuseMapAssignment_6_1 ) )
            // InternalMTL.g:1476:2: ( rule__TexturedMaterial__DiffuseMapAssignment_6_1 )
            {
             before(grammarAccess.getTexturedMaterialAccess().getDiffuseMapAssignment_6_1()); 
            // InternalMTL.g:1477:2: ( rule__TexturedMaterial__DiffuseMapAssignment_6_1 )
            // InternalMTL.g:1477:3: rule__TexturedMaterial__DiffuseMapAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__DiffuseMapAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getTexturedMaterialAccess().getDiffuseMapAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__Group_6__1__Impl"


    // $ANTLR start "rule__TexturedMaterial__Group_7__0"
    // InternalMTL.g:1486:1: rule__TexturedMaterial__Group_7__0 : rule__TexturedMaterial__Group_7__0__Impl rule__TexturedMaterial__Group_7__1 ;
    public final void rule__TexturedMaterial__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1490:1: ( rule__TexturedMaterial__Group_7__0__Impl rule__TexturedMaterial__Group_7__1 )
            // InternalMTL.g:1491:2: rule__TexturedMaterial__Group_7__0__Impl rule__TexturedMaterial__Group_7__1
            {
            pushFollow(FOLLOW_5);
            rule__TexturedMaterial__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_7__1();

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
    // $ANTLR end "rule__TexturedMaterial__Group_7__0"


    // $ANTLR start "rule__TexturedMaterial__Group_7__0__Impl"
    // InternalMTL.g:1498:1: rule__TexturedMaterial__Group_7__0__Impl : ( 'map_Ks' ) ;
    public final void rule__TexturedMaterial__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1502:1: ( ( 'map_Ks' ) )
            // InternalMTL.g:1503:1: ( 'map_Ks' )
            {
            // InternalMTL.g:1503:1: ( 'map_Ks' )
            // InternalMTL.g:1504:2: 'map_Ks'
            {
             before(grammarAccess.getTexturedMaterialAccess().getMap_KsKeyword_7_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getTexturedMaterialAccess().getMap_KsKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__Group_7__0__Impl"


    // $ANTLR start "rule__TexturedMaterial__Group_7__1"
    // InternalMTL.g:1513:1: rule__TexturedMaterial__Group_7__1 : rule__TexturedMaterial__Group_7__1__Impl ;
    public final void rule__TexturedMaterial__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1517:1: ( rule__TexturedMaterial__Group_7__1__Impl )
            // InternalMTL.g:1518:2: rule__TexturedMaterial__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_7__1__Impl();

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
    // $ANTLR end "rule__TexturedMaterial__Group_7__1"


    // $ANTLR start "rule__TexturedMaterial__Group_7__1__Impl"
    // InternalMTL.g:1524:1: rule__TexturedMaterial__Group_7__1__Impl : ( ( rule__TexturedMaterial__SpecularMapAssignment_7_1 ) ) ;
    public final void rule__TexturedMaterial__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1528:1: ( ( ( rule__TexturedMaterial__SpecularMapAssignment_7_1 ) ) )
            // InternalMTL.g:1529:1: ( ( rule__TexturedMaterial__SpecularMapAssignment_7_1 ) )
            {
            // InternalMTL.g:1529:1: ( ( rule__TexturedMaterial__SpecularMapAssignment_7_1 ) )
            // InternalMTL.g:1530:2: ( rule__TexturedMaterial__SpecularMapAssignment_7_1 )
            {
             before(grammarAccess.getTexturedMaterialAccess().getSpecularMapAssignment_7_1()); 
            // InternalMTL.g:1531:2: ( rule__TexturedMaterial__SpecularMapAssignment_7_1 )
            // InternalMTL.g:1531:3: rule__TexturedMaterial__SpecularMapAssignment_7_1
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__SpecularMapAssignment_7_1();

            state._fsp--;


            }

             after(grammarAccess.getTexturedMaterialAccess().getSpecularMapAssignment_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__Group_7__1__Impl"


    // $ANTLR start "rule__TexturedMaterial__Group_8__0"
    // InternalMTL.g:1540:1: rule__TexturedMaterial__Group_8__0 : rule__TexturedMaterial__Group_8__0__Impl rule__TexturedMaterial__Group_8__1 ;
    public final void rule__TexturedMaterial__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1544:1: ( rule__TexturedMaterial__Group_8__0__Impl rule__TexturedMaterial__Group_8__1 )
            // InternalMTL.g:1545:2: rule__TexturedMaterial__Group_8__0__Impl rule__TexturedMaterial__Group_8__1
            {
            pushFollow(FOLLOW_5);
            rule__TexturedMaterial__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_8__1();

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
    // $ANTLR end "rule__TexturedMaterial__Group_8__0"


    // $ANTLR start "rule__TexturedMaterial__Group_8__0__Impl"
    // InternalMTL.g:1552:1: rule__TexturedMaterial__Group_8__0__Impl : ( 'map_Ns' ) ;
    public final void rule__TexturedMaterial__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1556:1: ( ( 'map_Ns' ) )
            // InternalMTL.g:1557:1: ( 'map_Ns' )
            {
            // InternalMTL.g:1557:1: ( 'map_Ns' )
            // InternalMTL.g:1558:2: 'map_Ns'
            {
             before(grammarAccess.getTexturedMaterialAccess().getMap_NsKeyword_8_0()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getTexturedMaterialAccess().getMap_NsKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__Group_8__0__Impl"


    // $ANTLR start "rule__TexturedMaterial__Group_8__1"
    // InternalMTL.g:1567:1: rule__TexturedMaterial__Group_8__1 : rule__TexturedMaterial__Group_8__1__Impl ;
    public final void rule__TexturedMaterial__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1571:1: ( rule__TexturedMaterial__Group_8__1__Impl )
            // InternalMTL.g:1572:2: rule__TexturedMaterial__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_8__1__Impl();

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
    // $ANTLR end "rule__TexturedMaterial__Group_8__1"


    // $ANTLR start "rule__TexturedMaterial__Group_8__1__Impl"
    // InternalMTL.g:1578:1: rule__TexturedMaterial__Group_8__1__Impl : ( ( rule__TexturedMaterial__SpecularHighlightMapAssignment_8_1 ) ) ;
    public final void rule__TexturedMaterial__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1582:1: ( ( ( rule__TexturedMaterial__SpecularHighlightMapAssignment_8_1 ) ) )
            // InternalMTL.g:1583:1: ( ( rule__TexturedMaterial__SpecularHighlightMapAssignment_8_1 ) )
            {
            // InternalMTL.g:1583:1: ( ( rule__TexturedMaterial__SpecularHighlightMapAssignment_8_1 ) )
            // InternalMTL.g:1584:2: ( rule__TexturedMaterial__SpecularHighlightMapAssignment_8_1 )
            {
             before(grammarAccess.getTexturedMaterialAccess().getSpecularHighlightMapAssignment_8_1()); 
            // InternalMTL.g:1585:2: ( rule__TexturedMaterial__SpecularHighlightMapAssignment_8_1 )
            // InternalMTL.g:1585:3: rule__TexturedMaterial__SpecularHighlightMapAssignment_8_1
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__SpecularHighlightMapAssignment_8_1();

            state._fsp--;


            }

             after(grammarAccess.getTexturedMaterialAccess().getSpecularHighlightMapAssignment_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__Group_8__1__Impl"


    // $ANTLR start "rule__TexturedMaterial__Group_9__0"
    // InternalMTL.g:1594:1: rule__TexturedMaterial__Group_9__0 : rule__TexturedMaterial__Group_9__0__Impl rule__TexturedMaterial__Group_9__1 ;
    public final void rule__TexturedMaterial__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1598:1: ( rule__TexturedMaterial__Group_9__0__Impl rule__TexturedMaterial__Group_9__1 )
            // InternalMTL.g:1599:2: rule__TexturedMaterial__Group_9__0__Impl rule__TexturedMaterial__Group_9__1
            {
            pushFollow(FOLLOW_5);
            rule__TexturedMaterial__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_9__1();

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
    // $ANTLR end "rule__TexturedMaterial__Group_9__0"


    // $ANTLR start "rule__TexturedMaterial__Group_9__0__Impl"
    // InternalMTL.g:1606:1: rule__TexturedMaterial__Group_9__0__Impl : ( 'map_d' ) ;
    public final void rule__TexturedMaterial__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1610:1: ( ( 'map_d' ) )
            // InternalMTL.g:1611:1: ( 'map_d' )
            {
            // InternalMTL.g:1611:1: ( 'map_d' )
            // InternalMTL.g:1612:2: 'map_d'
            {
             before(grammarAccess.getTexturedMaterialAccess().getMap_dKeyword_9_0()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getTexturedMaterialAccess().getMap_dKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__Group_9__0__Impl"


    // $ANTLR start "rule__TexturedMaterial__Group_9__1"
    // InternalMTL.g:1621:1: rule__TexturedMaterial__Group_9__1 : rule__TexturedMaterial__Group_9__1__Impl ;
    public final void rule__TexturedMaterial__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1625:1: ( rule__TexturedMaterial__Group_9__1__Impl )
            // InternalMTL.g:1626:2: rule__TexturedMaterial__Group_9__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_9__1__Impl();

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
    // $ANTLR end "rule__TexturedMaterial__Group_9__1"


    // $ANTLR start "rule__TexturedMaterial__Group_9__1__Impl"
    // InternalMTL.g:1632:1: rule__TexturedMaterial__Group_9__1__Impl : ( ( rule__TexturedMaterial__AlphaMapAssignment_9_1 ) ) ;
    public final void rule__TexturedMaterial__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1636:1: ( ( ( rule__TexturedMaterial__AlphaMapAssignment_9_1 ) ) )
            // InternalMTL.g:1637:1: ( ( rule__TexturedMaterial__AlphaMapAssignment_9_1 ) )
            {
            // InternalMTL.g:1637:1: ( ( rule__TexturedMaterial__AlphaMapAssignment_9_1 ) )
            // InternalMTL.g:1638:2: ( rule__TexturedMaterial__AlphaMapAssignment_9_1 )
            {
             before(grammarAccess.getTexturedMaterialAccess().getAlphaMapAssignment_9_1()); 
            // InternalMTL.g:1639:2: ( rule__TexturedMaterial__AlphaMapAssignment_9_1 )
            // InternalMTL.g:1639:3: rule__TexturedMaterial__AlphaMapAssignment_9_1
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__AlphaMapAssignment_9_1();

            state._fsp--;


            }

             after(grammarAccess.getTexturedMaterialAccess().getAlphaMapAssignment_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__Group_9__1__Impl"


    // $ANTLR start "rule__TexturedMaterial__Group_10__0"
    // InternalMTL.g:1648:1: rule__TexturedMaterial__Group_10__0 : rule__TexturedMaterial__Group_10__0__Impl rule__TexturedMaterial__Group_10__1 ;
    public final void rule__TexturedMaterial__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1652:1: ( rule__TexturedMaterial__Group_10__0__Impl rule__TexturedMaterial__Group_10__1 )
            // InternalMTL.g:1653:2: rule__TexturedMaterial__Group_10__0__Impl rule__TexturedMaterial__Group_10__1
            {
            pushFollow(FOLLOW_5);
            rule__TexturedMaterial__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_10__1();

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
    // $ANTLR end "rule__TexturedMaterial__Group_10__0"


    // $ANTLR start "rule__TexturedMaterial__Group_10__0__Impl"
    // InternalMTL.g:1660:1: rule__TexturedMaterial__Group_10__0__Impl : ( 'map_bump' ) ;
    public final void rule__TexturedMaterial__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1664:1: ( ( 'map_bump' ) )
            // InternalMTL.g:1665:1: ( 'map_bump' )
            {
            // InternalMTL.g:1665:1: ( 'map_bump' )
            // InternalMTL.g:1666:2: 'map_bump'
            {
             before(grammarAccess.getTexturedMaterialAccess().getMap_bumpKeyword_10_0()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getTexturedMaterialAccess().getMap_bumpKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__Group_10__0__Impl"


    // $ANTLR start "rule__TexturedMaterial__Group_10__1"
    // InternalMTL.g:1675:1: rule__TexturedMaterial__Group_10__1 : rule__TexturedMaterial__Group_10__1__Impl ;
    public final void rule__TexturedMaterial__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1679:1: ( rule__TexturedMaterial__Group_10__1__Impl )
            // InternalMTL.g:1680:2: rule__TexturedMaterial__Group_10__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__Group_10__1__Impl();

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
    // $ANTLR end "rule__TexturedMaterial__Group_10__1"


    // $ANTLR start "rule__TexturedMaterial__Group_10__1__Impl"
    // InternalMTL.g:1686:1: rule__TexturedMaterial__Group_10__1__Impl : ( ( rule__TexturedMaterial__BumpMapAssignment_10_1 ) ) ;
    public final void rule__TexturedMaterial__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1690:1: ( ( ( rule__TexturedMaterial__BumpMapAssignment_10_1 ) ) )
            // InternalMTL.g:1691:1: ( ( rule__TexturedMaterial__BumpMapAssignment_10_1 ) )
            {
            // InternalMTL.g:1691:1: ( ( rule__TexturedMaterial__BumpMapAssignment_10_1 ) )
            // InternalMTL.g:1692:2: ( rule__TexturedMaterial__BumpMapAssignment_10_1 )
            {
             before(grammarAccess.getTexturedMaterialAccess().getBumpMapAssignment_10_1()); 
            // InternalMTL.g:1693:2: ( rule__TexturedMaterial__BumpMapAssignment_10_1 )
            // InternalMTL.g:1693:3: rule__TexturedMaterial__BumpMapAssignment_10_1
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__BumpMapAssignment_10_1();

            state._fsp--;


            }

             after(grammarAccess.getTexturedMaterialAccess().getBumpMapAssignment_10_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__Group_10__1__Impl"


    // $ANTLR start "rule__Color__Group__0"
    // InternalMTL.g:1702:1: rule__Color__Group__0 : rule__Color__Group__0__Impl rule__Color__Group__1 ;
    public final void rule__Color__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1706:1: ( rule__Color__Group__0__Impl rule__Color__Group__1 )
            // InternalMTL.g:1707:2: rule__Color__Group__0__Impl rule__Color__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__Color__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Color__Group__1();

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
    // $ANTLR end "rule__Color__Group__0"


    // $ANTLR start "rule__Color__Group__0__Impl"
    // InternalMTL.g:1714:1: rule__Color__Group__0__Impl : ( ( rule__Color__RedAssignment_0 ) ) ;
    public final void rule__Color__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1718:1: ( ( ( rule__Color__RedAssignment_0 ) ) )
            // InternalMTL.g:1719:1: ( ( rule__Color__RedAssignment_0 ) )
            {
            // InternalMTL.g:1719:1: ( ( rule__Color__RedAssignment_0 ) )
            // InternalMTL.g:1720:2: ( rule__Color__RedAssignment_0 )
            {
             before(grammarAccess.getColorAccess().getRedAssignment_0()); 
            // InternalMTL.g:1721:2: ( rule__Color__RedAssignment_0 )
            // InternalMTL.g:1721:3: rule__Color__RedAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Color__RedAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getColorAccess().getRedAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Color__Group__0__Impl"


    // $ANTLR start "rule__Color__Group__1"
    // InternalMTL.g:1729:1: rule__Color__Group__1 : rule__Color__Group__1__Impl rule__Color__Group__2 ;
    public final void rule__Color__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1733:1: ( rule__Color__Group__1__Impl rule__Color__Group__2 )
            // InternalMTL.g:1734:2: rule__Color__Group__1__Impl rule__Color__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__Color__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Color__Group__2();

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
    // $ANTLR end "rule__Color__Group__1"


    // $ANTLR start "rule__Color__Group__1__Impl"
    // InternalMTL.g:1741:1: rule__Color__Group__1__Impl : ( ( rule__Color__GreenAssignment_1 ) ) ;
    public final void rule__Color__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1745:1: ( ( ( rule__Color__GreenAssignment_1 ) ) )
            // InternalMTL.g:1746:1: ( ( rule__Color__GreenAssignment_1 ) )
            {
            // InternalMTL.g:1746:1: ( ( rule__Color__GreenAssignment_1 ) )
            // InternalMTL.g:1747:2: ( rule__Color__GreenAssignment_1 )
            {
             before(grammarAccess.getColorAccess().getGreenAssignment_1()); 
            // InternalMTL.g:1748:2: ( rule__Color__GreenAssignment_1 )
            // InternalMTL.g:1748:3: rule__Color__GreenAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Color__GreenAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getColorAccess().getGreenAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Color__Group__1__Impl"


    // $ANTLR start "rule__Color__Group__2"
    // InternalMTL.g:1756:1: rule__Color__Group__2 : rule__Color__Group__2__Impl ;
    public final void rule__Color__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1760:1: ( rule__Color__Group__2__Impl )
            // InternalMTL.g:1761:2: rule__Color__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Color__Group__2__Impl();

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
    // $ANTLR end "rule__Color__Group__2"


    // $ANTLR start "rule__Color__Group__2__Impl"
    // InternalMTL.g:1767:1: rule__Color__Group__2__Impl : ( ( rule__Color__BlueAssignment_2 ) ) ;
    public final void rule__Color__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1771:1: ( ( ( rule__Color__BlueAssignment_2 ) ) )
            // InternalMTL.g:1772:1: ( ( rule__Color__BlueAssignment_2 ) )
            {
            // InternalMTL.g:1772:1: ( ( rule__Color__BlueAssignment_2 ) )
            // InternalMTL.g:1773:2: ( rule__Color__BlueAssignment_2 )
            {
             before(grammarAccess.getColorAccess().getBlueAssignment_2()); 
            // InternalMTL.g:1774:2: ( rule__Color__BlueAssignment_2 )
            // InternalMTL.g:1774:3: rule__Color__BlueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Color__BlueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getColorAccess().getBlueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Color__Group__2__Impl"


    // $ANTLR start "rule__EInt__Group__0"
    // InternalMTL.g:1783:1: rule__EInt__Group__0 : rule__EInt__Group__0__Impl rule__EInt__Group__1 ;
    public final void rule__EInt__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1787:1: ( rule__EInt__Group__0__Impl rule__EInt__Group__1 )
            // InternalMTL.g:1788:2: rule__EInt__Group__0__Impl rule__EInt__Group__1
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
    // InternalMTL.g:1795:1: rule__EInt__Group__0__Impl : ( ( '-' )? ) ;
    public final void rule__EInt__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1799:1: ( ( ( '-' )? ) )
            // InternalMTL.g:1800:1: ( ( '-' )? )
            {
            // InternalMTL.g:1800:1: ( ( '-' )? )
            // InternalMTL.g:1801:2: ( '-' )?
            {
             before(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
            // InternalMTL.g:1802:2: ( '-' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==17) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalMTL.g:1802:3: '-'
                    {
                    match(input,17,FOLLOW_2); 

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
    // InternalMTL.g:1810:1: rule__EInt__Group__1 : rule__EInt__Group__1__Impl ;
    public final void rule__EInt__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1814:1: ( rule__EInt__Group__1__Impl )
            // InternalMTL.g:1815:2: rule__EInt__Group__1__Impl
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
    // InternalMTL.g:1821:1: rule__EInt__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__EInt__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1825:1: ( ( RULE_INT ) )
            // InternalMTL.g:1826:1: ( RULE_INT )
            {
            // InternalMTL.g:1826:1: ( RULE_INT )
            // InternalMTL.g:1827:2: RULE_INT
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


    // $ANTLR start "rule__PhongMaterial__UnorderedGroup"
    // InternalMTL.g:1837:1: rule__PhongMaterial__UnorderedGroup : rule__PhongMaterial__UnorderedGroup__0 {...}?;
    public final void rule__PhongMaterial__UnorderedGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getPhongMaterialAccess().getUnorderedGroup());
        	
        try {
            // InternalMTL.g:1842:1: ( rule__PhongMaterial__UnorderedGroup__0 {...}?)
            // InternalMTL.g:1843:2: rule__PhongMaterial__UnorderedGroup__0 {...}?
            {
            pushFollow(FOLLOW_2);
            rule__PhongMaterial__UnorderedGroup__0();

            state._fsp--;

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "rule__PhongMaterial__UnorderedGroup", "getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup())");
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__UnorderedGroup"


    // $ANTLR start "rule__PhongMaterial__UnorderedGroup__Impl"
    // InternalMTL.g:1851:1: rule__PhongMaterial__UnorderedGroup__Impl : ( ({...}? => ( ( ( rule__PhongMaterial__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__PhongMaterial__Group_1__0 ) ) ) ) | ({...}? => ( ( ( rule__PhongMaterial__Group_2__0 ) ) ) ) | ({...}? => ( ( ( rule__PhongMaterial__Alternatives_3 ) ) ) ) | ({...}? => ( ( ( rule__PhongMaterial__Group_4__0 ) ) ) ) ) ;
    public final void rule__PhongMaterial__UnorderedGroup__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalMTL.g:1856:1: ( ( ({...}? => ( ( ( rule__PhongMaterial__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__PhongMaterial__Group_1__0 ) ) ) ) | ({...}? => ( ( ( rule__PhongMaterial__Group_2__0 ) ) ) ) | ({...}? => ( ( ( rule__PhongMaterial__Alternatives_3 ) ) ) ) | ({...}? => ( ( ( rule__PhongMaterial__Group_4__0 ) ) ) ) ) )
            // InternalMTL.g:1857:3: ( ({...}? => ( ( ( rule__PhongMaterial__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__PhongMaterial__Group_1__0 ) ) ) ) | ({...}? => ( ( ( rule__PhongMaterial__Group_2__0 ) ) ) ) | ({...}? => ( ( ( rule__PhongMaterial__Alternatives_3 ) ) ) ) | ({...}? => ( ( ( rule__PhongMaterial__Group_4__0 ) ) ) ) )
            {
            // InternalMTL.g:1857:3: ( ({...}? => ( ( ( rule__PhongMaterial__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__PhongMaterial__Group_1__0 ) ) ) ) | ({...}? => ( ( ( rule__PhongMaterial__Group_2__0 ) ) ) ) | ({...}? => ( ( ( rule__PhongMaterial__Alternatives_3 ) ) ) ) | ({...}? => ( ( ( rule__PhongMaterial__Group_4__0 ) ) ) ) )
            int alt11=5;
            int LA11_0 = input.LA(1);

            if ( LA11_0 == 18 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 0) ) {
                alt11=1;
            }
            else if ( LA11_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 1) ) {
                alt11=2;
            }
            else if ( LA11_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 2) ) {
                alt11=3;
            }
            else if ( LA11_0 >= 23 && LA11_0 <= 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 3) ) {
                alt11=4;
            }
            else if ( LA11_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 4) ) {
                alt11=5;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalMTL.g:1858:3: ({...}? => ( ( ( rule__PhongMaterial__Group_0__0 ) ) ) )
                    {
                    // InternalMTL.g:1858:3: ({...}? => ( ( ( rule__PhongMaterial__Group_0__0 ) ) ) )
                    // InternalMTL.g:1859:4: {...}? => ( ( ( rule__PhongMaterial__Group_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 0) ) {
                        throw new FailedPredicateException(input, "rule__PhongMaterial__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 0)");
                    }
                    // InternalMTL.g:1859:107: ( ( ( rule__PhongMaterial__Group_0__0 ) ) )
                    // InternalMTL.g:1860:5: ( ( rule__PhongMaterial__Group_0__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 0);
                    				

                    					selected = true;
                    				
                    // InternalMTL.g:1866:5: ( ( rule__PhongMaterial__Group_0__0 ) )
                    // InternalMTL.g:1867:6: ( rule__PhongMaterial__Group_0__0 )
                    {
                     before(grammarAccess.getPhongMaterialAccess().getGroup_0()); 
                    // InternalMTL.g:1868:6: ( rule__PhongMaterial__Group_0__0 )
                    // InternalMTL.g:1868:7: rule__PhongMaterial__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PhongMaterial__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPhongMaterialAccess().getGroup_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMTL.g:1873:3: ({...}? => ( ( ( rule__PhongMaterial__Group_1__0 ) ) ) )
                    {
                    // InternalMTL.g:1873:3: ({...}? => ( ( ( rule__PhongMaterial__Group_1__0 ) ) ) )
                    // InternalMTL.g:1874:4: {...}? => ( ( ( rule__PhongMaterial__Group_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 1) ) {
                        throw new FailedPredicateException(input, "rule__PhongMaterial__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 1)");
                    }
                    // InternalMTL.g:1874:107: ( ( ( rule__PhongMaterial__Group_1__0 ) ) )
                    // InternalMTL.g:1875:5: ( ( rule__PhongMaterial__Group_1__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 1);
                    				

                    					selected = true;
                    				
                    // InternalMTL.g:1881:5: ( ( rule__PhongMaterial__Group_1__0 ) )
                    // InternalMTL.g:1882:6: ( rule__PhongMaterial__Group_1__0 )
                    {
                     before(grammarAccess.getPhongMaterialAccess().getGroup_1()); 
                    // InternalMTL.g:1883:6: ( rule__PhongMaterial__Group_1__0 )
                    // InternalMTL.g:1883:7: rule__PhongMaterial__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PhongMaterial__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPhongMaterialAccess().getGroup_1()); 

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMTL.g:1888:3: ({...}? => ( ( ( rule__PhongMaterial__Group_2__0 ) ) ) )
                    {
                    // InternalMTL.g:1888:3: ({...}? => ( ( ( rule__PhongMaterial__Group_2__0 ) ) ) )
                    // InternalMTL.g:1889:4: {...}? => ( ( ( rule__PhongMaterial__Group_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 2) ) {
                        throw new FailedPredicateException(input, "rule__PhongMaterial__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 2)");
                    }
                    // InternalMTL.g:1889:107: ( ( ( rule__PhongMaterial__Group_2__0 ) ) )
                    // InternalMTL.g:1890:5: ( ( rule__PhongMaterial__Group_2__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 2);
                    				

                    					selected = true;
                    				
                    // InternalMTL.g:1896:5: ( ( rule__PhongMaterial__Group_2__0 ) )
                    // InternalMTL.g:1897:6: ( rule__PhongMaterial__Group_2__0 )
                    {
                     before(grammarAccess.getPhongMaterialAccess().getGroup_2()); 
                    // InternalMTL.g:1898:6: ( rule__PhongMaterial__Group_2__0 )
                    // InternalMTL.g:1898:7: rule__PhongMaterial__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PhongMaterial__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPhongMaterialAccess().getGroup_2()); 

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalMTL.g:1903:3: ({...}? => ( ( ( rule__PhongMaterial__Alternatives_3 ) ) ) )
                    {
                    // InternalMTL.g:1903:3: ({...}? => ( ( ( rule__PhongMaterial__Alternatives_3 ) ) ) )
                    // InternalMTL.g:1904:4: {...}? => ( ( ( rule__PhongMaterial__Alternatives_3 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 3) ) {
                        throw new FailedPredicateException(input, "rule__PhongMaterial__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 3)");
                    }
                    // InternalMTL.g:1904:107: ( ( ( rule__PhongMaterial__Alternatives_3 ) ) )
                    // InternalMTL.g:1905:5: ( ( rule__PhongMaterial__Alternatives_3 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 3);
                    				

                    					selected = true;
                    				
                    // InternalMTL.g:1911:5: ( ( rule__PhongMaterial__Alternatives_3 ) )
                    // InternalMTL.g:1912:6: ( rule__PhongMaterial__Alternatives_3 )
                    {
                     before(grammarAccess.getPhongMaterialAccess().getAlternatives_3()); 
                    // InternalMTL.g:1913:6: ( rule__PhongMaterial__Alternatives_3 )
                    // InternalMTL.g:1913:7: rule__PhongMaterial__Alternatives_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__PhongMaterial__Alternatives_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getPhongMaterialAccess().getAlternatives_3()); 

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalMTL.g:1918:3: ({...}? => ( ( ( rule__PhongMaterial__Group_4__0 ) ) ) )
                    {
                    // InternalMTL.g:1918:3: ({...}? => ( ( ( rule__PhongMaterial__Group_4__0 ) ) ) )
                    // InternalMTL.g:1919:4: {...}? => ( ( ( rule__PhongMaterial__Group_4__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 4) ) {
                        throw new FailedPredicateException(input, "rule__PhongMaterial__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 4)");
                    }
                    // InternalMTL.g:1919:107: ( ( ( rule__PhongMaterial__Group_4__0 ) ) )
                    // InternalMTL.g:1920:5: ( ( rule__PhongMaterial__Group_4__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 4);
                    				

                    					selected = true;
                    				
                    // InternalMTL.g:1926:5: ( ( rule__PhongMaterial__Group_4__0 ) )
                    // InternalMTL.g:1927:6: ( rule__PhongMaterial__Group_4__0 )
                    {
                     before(grammarAccess.getPhongMaterialAccess().getGroup_4()); 
                    // InternalMTL.g:1928:6: ( rule__PhongMaterial__Group_4__0 )
                    // InternalMTL.g:1928:7: rule__PhongMaterial__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PhongMaterial__Group_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPhongMaterialAccess().getGroup_4()); 

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPhongMaterialAccess().getUnorderedGroup());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__UnorderedGroup__Impl"


    // $ANTLR start "rule__PhongMaterial__UnorderedGroup__0"
    // InternalMTL.g:1941:1: rule__PhongMaterial__UnorderedGroup__0 : rule__PhongMaterial__UnorderedGroup__Impl ( rule__PhongMaterial__UnorderedGroup__1 )? ;
    public final void rule__PhongMaterial__UnorderedGroup__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1945:1: ( rule__PhongMaterial__UnorderedGroup__Impl ( rule__PhongMaterial__UnorderedGroup__1 )? )
            // InternalMTL.g:1946:2: rule__PhongMaterial__UnorderedGroup__Impl ( rule__PhongMaterial__UnorderedGroup__1 )?
            {
            pushFollow(FOLLOW_9);
            rule__PhongMaterial__UnorderedGroup__Impl();

            state._fsp--;

            // InternalMTL.g:1947:2: ( rule__PhongMaterial__UnorderedGroup__1 )?
            int alt12=2;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // InternalMTL.g:1947:2: rule__PhongMaterial__UnorderedGroup__1
                    {
                    pushFollow(FOLLOW_2);
                    rule__PhongMaterial__UnorderedGroup__1();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__UnorderedGroup__0"


    // $ANTLR start "rule__PhongMaterial__UnorderedGroup__1"
    // InternalMTL.g:1953:1: rule__PhongMaterial__UnorderedGroup__1 : rule__PhongMaterial__UnorderedGroup__Impl ( rule__PhongMaterial__UnorderedGroup__2 )? ;
    public final void rule__PhongMaterial__UnorderedGroup__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1957:1: ( rule__PhongMaterial__UnorderedGroup__Impl ( rule__PhongMaterial__UnorderedGroup__2 )? )
            // InternalMTL.g:1958:2: rule__PhongMaterial__UnorderedGroup__Impl ( rule__PhongMaterial__UnorderedGroup__2 )?
            {
            pushFollow(FOLLOW_9);
            rule__PhongMaterial__UnorderedGroup__Impl();

            state._fsp--;

            // InternalMTL.g:1959:2: ( rule__PhongMaterial__UnorderedGroup__2 )?
            int alt13=2;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // InternalMTL.g:1959:2: rule__PhongMaterial__UnorderedGroup__2
                    {
                    pushFollow(FOLLOW_2);
                    rule__PhongMaterial__UnorderedGroup__2();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__UnorderedGroup__1"


    // $ANTLR start "rule__PhongMaterial__UnorderedGroup__2"
    // InternalMTL.g:1965:1: rule__PhongMaterial__UnorderedGroup__2 : rule__PhongMaterial__UnorderedGroup__Impl ( rule__PhongMaterial__UnorderedGroup__3 )? ;
    public final void rule__PhongMaterial__UnorderedGroup__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1969:1: ( rule__PhongMaterial__UnorderedGroup__Impl ( rule__PhongMaterial__UnorderedGroup__3 )? )
            // InternalMTL.g:1970:2: rule__PhongMaterial__UnorderedGroup__Impl ( rule__PhongMaterial__UnorderedGroup__3 )?
            {
            pushFollow(FOLLOW_9);
            rule__PhongMaterial__UnorderedGroup__Impl();

            state._fsp--;

            // InternalMTL.g:1971:2: ( rule__PhongMaterial__UnorderedGroup__3 )?
            int alt14=2;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // InternalMTL.g:1971:2: rule__PhongMaterial__UnorderedGroup__3
                    {
                    pushFollow(FOLLOW_2);
                    rule__PhongMaterial__UnorderedGroup__3();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__UnorderedGroup__2"


    // $ANTLR start "rule__PhongMaterial__UnorderedGroup__3"
    // InternalMTL.g:1977:1: rule__PhongMaterial__UnorderedGroup__3 : rule__PhongMaterial__UnorderedGroup__Impl ( rule__PhongMaterial__UnorderedGroup__4 )? ;
    public final void rule__PhongMaterial__UnorderedGroup__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1981:1: ( rule__PhongMaterial__UnorderedGroup__Impl ( rule__PhongMaterial__UnorderedGroup__4 )? )
            // InternalMTL.g:1982:2: rule__PhongMaterial__UnorderedGroup__Impl ( rule__PhongMaterial__UnorderedGroup__4 )?
            {
            pushFollow(FOLLOW_9);
            rule__PhongMaterial__UnorderedGroup__Impl();

            state._fsp--;

            // InternalMTL.g:1983:2: ( rule__PhongMaterial__UnorderedGroup__4 )?
            int alt15=2;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // InternalMTL.g:1983:2: rule__PhongMaterial__UnorderedGroup__4
                    {
                    pushFollow(FOLLOW_2);
                    rule__PhongMaterial__UnorderedGroup__4();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__UnorderedGroup__3"


    // $ANTLR start "rule__PhongMaterial__UnorderedGroup__4"
    // InternalMTL.g:1989:1: rule__PhongMaterial__UnorderedGroup__4 : rule__PhongMaterial__UnorderedGroup__Impl ;
    public final void rule__PhongMaterial__UnorderedGroup__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:1993:1: ( rule__PhongMaterial__UnorderedGroup__Impl )
            // InternalMTL.g:1994:2: rule__PhongMaterial__UnorderedGroup__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PhongMaterial__UnorderedGroup__Impl();

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
    // $ANTLR end "rule__PhongMaterial__UnorderedGroup__4"


    // $ANTLR start "rule__TexturedMaterial__UnorderedGroup"
    // InternalMTL.g:2001:1: rule__TexturedMaterial__UnorderedGroup : rule__TexturedMaterial__UnorderedGroup__0 {...}?;
    public final void rule__TexturedMaterial__UnorderedGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup());
        	
        try {
            // InternalMTL.g:2006:1: ( rule__TexturedMaterial__UnorderedGroup__0 {...}?)
            // InternalMTL.g:2007:2: rule__TexturedMaterial__UnorderedGroup__0 {...}?
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__UnorderedGroup__0();

            state._fsp--;

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "rule__TexturedMaterial__UnorderedGroup", "getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup())");
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__UnorderedGroup"


    // $ANTLR start "rule__TexturedMaterial__UnorderedGroup__Impl"
    // InternalMTL.g:2015:1: rule__TexturedMaterial__UnorderedGroup__Impl : ( ({...}? => ( ( ( rule__TexturedMaterial__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_1__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_2__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Alternatives_3 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_4__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_5__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_6__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_7__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_8__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_9__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_10__0 ) ) ) ) ) ;
    public final void rule__TexturedMaterial__UnorderedGroup__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalMTL.g:2020:1: ( ( ({...}? => ( ( ( rule__TexturedMaterial__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_1__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_2__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Alternatives_3 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_4__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_5__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_6__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_7__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_8__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_9__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_10__0 ) ) ) ) ) )
            // InternalMTL.g:2021:3: ( ({...}? => ( ( ( rule__TexturedMaterial__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_1__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_2__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Alternatives_3 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_4__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_5__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_6__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_7__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_8__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_9__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_10__0 ) ) ) ) )
            {
            // InternalMTL.g:2021:3: ( ({...}? => ( ( ( rule__TexturedMaterial__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_1__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_2__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Alternatives_3 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_4__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_5__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_6__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_7__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_8__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_9__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_10__0 ) ) ) ) )
            int alt16=11;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // InternalMTL.g:2022:3: ({...}? => ( ( ( rule__TexturedMaterial__Group_0__0 ) ) ) )
                    {
                    // InternalMTL.g:2022:3: ({...}? => ( ( ( rule__TexturedMaterial__Group_0__0 ) ) ) )
                    // InternalMTL.g:2023:4: {...}? => ( ( ( rule__TexturedMaterial__Group_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 0) ) {
                        throw new FailedPredicateException(input, "rule__TexturedMaterial__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 0)");
                    }
                    // InternalMTL.g:2023:110: ( ( ( rule__TexturedMaterial__Group_0__0 ) ) )
                    // InternalMTL.g:2024:5: ( ( rule__TexturedMaterial__Group_0__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 0);
                    				

                    					selected = true;
                    				
                    // InternalMTL.g:2030:5: ( ( rule__TexturedMaterial__Group_0__0 ) )
                    // InternalMTL.g:2031:6: ( rule__TexturedMaterial__Group_0__0 )
                    {
                     before(grammarAccess.getTexturedMaterialAccess().getGroup_0()); 
                    // InternalMTL.g:2032:6: ( rule__TexturedMaterial__Group_0__0 )
                    // InternalMTL.g:2032:7: rule__TexturedMaterial__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TexturedMaterial__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTexturedMaterialAccess().getGroup_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMTL.g:2037:3: ({...}? => ( ( ( rule__TexturedMaterial__Group_1__0 ) ) ) )
                    {
                    // InternalMTL.g:2037:3: ({...}? => ( ( ( rule__TexturedMaterial__Group_1__0 ) ) ) )
                    // InternalMTL.g:2038:4: {...}? => ( ( ( rule__TexturedMaterial__Group_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 1) ) {
                        throw new FailedPredicateException(input, "rule__TexturedMaterial__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 1)");
                    }
                    // InternalMTL.g:2038:110: ( ( ( rule__TexturedMaterial__Group_1__0 ) ) )
                    // InternalMTL.g:2039:5: ( ( rule__TexturedMaterial__Group_1__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 1);
                    				

                    					selected = true;
                    				
                    // InternalMTL.g:2045:5: ( ( rule__TexturedMaterial__Group_1__0 ) )
                    // InternalMTL.g:2046:6: ( rule__TexturedMaterial__Group_1__0 )
                    {
                     before(grammarAccess.getTexturedMaterialAccess().getGroup_1()); 
                    // InternalMTL.g:2047:6: ( rule__TexturedMaterial__Group_1__0 )
                    // InternalMTL.g:2047:7: rule__TexturedMaterial__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TexturedMaterial__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTexturedMaterialAccess().getGroup_1()); 

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMTL.g:2052:3: ({...}? => ( ( ( rule__TexturedMaterial__Group_2__0 ) ) ) )
                    {
                    // InternalMTL.g:2052:3: ({...}? => ( ( ( rule__TexturedMaterial__Group_2__0 ) ) ) )
                    // InternalMTL.g:2053:4: {...}? => ( ( ( rule__TexturedMaterial__Group_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 2) ) {
                        throw new FailedPredicateException(input, "rule__TexturedMaterial__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 2)");
                    }
                    // InternalMTL.g:2053:110: ( ( ( rule__TexturedMaterial__Group_2__0 ) ) )
                    // InternalMTL.g:2054:5: ( ( rule__TexturedMaterial__Group_2__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 2);
                    				

                    					selected = true;
                    				
                    // InternalMTL.g:2060:5: ( ( rule__TexturedMaterial__Group_2__0 ) )
                    // InternalMTL.g:2061:6: ( rule__TexturedMaterial__Group_2__0 )
                    {
                     before(grammarAccess.getTexturedMaterialAccess().getGroup_2()); 
                    // InternalMTL.g:2062:6: ( rule__TexturedMaterial__Group_2__0 )
                    // InternalMTL.g:2062:7: rule__TexturedMaterial__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TexturedMaterial__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTexturedMaterialAccess().getGroup_2()); 

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalMTL.g:2067:3: ({...}? => ( ( ( rule__TexturedMaterial__Alternatives_3 ) ) ) )
                    {
                    // InternalMTL.g:2067:3: ({...}? => ( ( ( rule__TexturedMaterial__Alternatives_3 ) ) ) )
                    // InternalMTL.g:2068:4: {...}? => ( ( ( rule__TexturedMaterial__Alternatives_3 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {
                        throw new FailedPredicateException(input, "rule__TexturedMaterial__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3)");
                    }
                    // InternalMTL.g:2068:110: ( ( ( rule__TexturedMaterial__Alternatives_3 ) ) )
                    // InternalMTL.g:2069:5: ( ( rule__TexturedMaterial__Alternatives_3 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3);
                    				

                    					selected = true;
                    				
                    // InternalMTL.g:2075:5: ( ( rule__TexturedMaterial__Alternatives_3 ) )
                    // InternalMTL.g:2076:6: ( rule__TexturedMaterial__Alternatives_3 )
                    {
                     before(grammarAccess.getTexturedMaterialAccess().getAlternatives_3()); 
                    // InternalMTL.g:2077:6: ( rule__TexturedMaterial__Alternatives_3 )
                    // InternalMTL.g:2077:7: rule__TexturedMaterial__Alternatives_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__TexturedMaterial__Alternatives_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getTexturedMaterialAccess().getAlternatives_3()); 

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalMTL.g:2082:3: ({...}? => ( ( ( rule__TexturedMaterial__Group_4__0 ) ) ) )
                    {
                    // InternalMTL.g:2082:3: ({...}? => ( ( ( rule__TexturedMaterial__Group_4__0 ) ) ) )
                    // InternalMTL.g:2083:4: {...}? => ( ( ( rule__TexturedMaterial__Group_4__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 4) ) {
                        throw new FailedPredicateException(input, "rule__TexturedMaterial__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 4)");
                    }
                    // InternalMTL.g:2083:110: ( ( ( rule__TexturedMaterial__Group_4__0 ) ) )
                    // InternalMTL.g:2084:5: ( ( rule__TexturedMaterial__Group_4__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 4);
                    				

                    					selected = true;
                    				
                    // InternalMTL.g:2090:5: ( ( rule__TexturedMaterial__Group_4__0 ) )
                    // InternalMTL.g:2091:6: ( rule__TexturedMaterial__Group_4__0 )
                    {
                     before(grammarAccess.getTexturedMaterialAccess().getGroup_4()); 
                    // InternalMTL.g:2092:6: ( rule__TexturedMaterial__Group_4__0 )
                    // InternalMTL.g:2092:7: rule__TexturedMaterial__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TexturedMaterial__Group_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTexturedMaterialAccess().getGroup_4()); 

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalMTL.g:2097:3: ({...}? => ( ( ( rule__TexturedMaterial__Group_5__0 ) ) ) )
                    {
                    // InternalMTL.g:2097:3: ({...}? => ( ( ( rule__TexturedMaterial__Group_5__0 ) ) ) )
                    // InternalMTL.g:2098:4: {...}? => ( ( ( rule__TexturedMaterial__Group_5__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {
                        throw new FailedPredicateException(input, "rule__TexturedMaterial__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5)");
                    }
                    // InternalMTL.g:2098:110: ( ( ( rule__TexturedMaterial__Group_5__0 ) ) )
                    // InternalMTL.g:2099:5: ( ( rule__TexturedMaterial__Group_5__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5);
                    				

                    					selected = true;
                    				
                    // InternalMTL.g:2105:5: ( ( rule__TexturedMaterial__Group_5__0 ) )
                    // InternalMTL.g:2106:6: ( rule__TexturedMaterial__Group_5__0 )
                    {
                     before(grammarAccess.getTexturedMaterialAccess().getGroup_5()); 
                    // InternalMTL.g:2107:6: ( rule__TexturedMaterial__Group_5__0 )
                    // InternalMTL.g:2107:7: rule__TexturedMaterial__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TexturedMaterial__Group_5__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTexturedMaterialAccess().getGroup_5()); 

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalMTL.g:2112:3: ({...}? => ( ( ( rule__TexturedMaterial__Group_6__0 ) ) ) )
                    {
                    // InternalMTL.g:2112:3: ({...}? => ( ( ( rule__TexturedMaterial__Group_6__0 ) ) ) )
                    // InternalMTL.g:2113:4: {...}? => ( ( ( rule__TexturedMaterial__Group_6__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {
                        throw new FailedPredicateException(input, "rule__TexturedMaterial__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6)");
                    }
                    // InternalMTL.g:2113:110: ( ( ( rule__TexturedMaterial__Group_6__0 ) ) )
                    // InternalMTL.g:2114:5: ( ( rule__TexturedMaterial__Group_6__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6);
                    				

                    					selected = true;
                    				
                    // InternalMTL.g:2120:5: ( ( rule__TexturedMaterial__Group_6__0 ) )
                    // InternalMTL.g:2121:6: ( rule__TexturedMaterial__Group_6__0 )
                    {
                     before(grammarAccess.getTexturedMaterialAccess().getGroup_6()); 
                    // InternalMTL.g:2122:6: ( rule__TexturedMaterial__Group_6__0 )
                    // InternalMTL.g:2122:7: rule__TexturedMaterial__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TexturedMaterial__Group_6__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTexturedMaterialAccess().getGroup_6()); 

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalMTL.g:2127:3: ({...}? => ( ( ( rule__TexturedMaterial__Group_7__0 ) ) ) )
                    {
                    // InternalMTL.g:2127:3: ({...}? => ( ( ( rule__TexturedMaterial__Group_7__0 ) ) ) )
                    // InternalMTL.g:2128:4: {...}? => ( ( ( rule__TexturedMaterial__Group_7__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {
                        throw new FailedPredicateException(input, "rule__TexturedMaterial__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7)");
                    }
                    // InternalMTL.g:2128:110: ( ( ( rule__TexturedMaterial__Group_7__0 ) ) )
                    // InternalMTL.g:2129:5: ( ( rule__TexturedMaterial__Group_7__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7);
                    				

                    					selected = true;
                    				
                    // InternalMTL.g:2135:5: ( ( rule__TexturedMaterial__Group_7__0 ) )
                    // InternalMTL.g:2136:6: ( rule__TexturedMaterial__Group_7__0 )
                    {
                     before(grammarAccess.getTexturedMaterialAccess().getGroup_7()); 
                    // InternalMTL.g:2137:6: ( rule__TexturedMaterial__Group_7__0 )
                    // InternalMTL.g:2137:7: rule__TexturedMaterial__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TexturedMaterial__Group_7__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTexturedMaterialAccess().getGroup_7()); 

                    }


                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalMTL.g:2142:3: ({...}? => ( ( ( rule__TexturedMaterial__Group_8__0 ) ) ) )
                    {
                    // InternalMTL.g:2142:3: ({...}? => ( ( ( rule__TexturedMaterial__Group_8__0 ) ) ) )
                    // InternalMTL.g:2143:4: {...}? => ( ( ( rule__TexturedMaterial__Group_8__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {
                        throw new FailedPredicateException(input, "rule__TexturedMaterial__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8)");
                    }
                    // InternalMTL.g:2143:110: ( ( ( rule__TexturedMaterial__Group_8__0 ) ) )
                    // InternalMTL.g:2144:5: ( ( rule__TexturedMaterial__Group_8__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8);
                    				

                    					selected = true;
                    				
                    // InternalMTL.g:2150:5: ( ( rule__TexturedMaterial__Group_8__0 ) )
                    // InternalMTL.g:2151:6: ( rule__TexturedMaterial__Group_8__0 )
                    {
                     before(grammarAccess.getTexturedMaterialAccess().getGroup_8()); 
                    // InternalMTL.g:2152:6: ( rule__TexturedMaterial__Group_8__0 )
                    // InternalMTL.g:2152:7: rule__TexturedMaterial__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TexturedMaterial__Group_8__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTexturedMaterialAccess().getGroup_8()); 

                    }


                    }


                    }


                    }
                    break;
                case 10 :
                    // InternalMTL.g:2157:3: ({...}? => ( ( ( rule__TexturedMaterial__Group_9__0 ) ) ) )
                    {
                    // InternalMTL.g:2157:3: ({...}? => ( ( ( rule__TexturedMaterial__Group_9__0 ) ) ) )
                    // InternalMTL.g:2158:4: {...}? => ( ( ( rule__TexturedMaterial__Group_9__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {
                        throw new FailedPredicateException(input, "rule__TexturedMaterial__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9)");
                    }
                    // InternalMTL.g:2158:110: ( ( ( rule__TexturedMaterial__Group_9__0 ) ) )
                    // InternalMTL.g:2159:5: ( ( rule__TexturedMaterial__Group_9__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9);
                    				

                    					selected = true;
                    				
                    // InternalMTL.g:2165:5: ( ( rule__TexturedMaterial__Group_9__0 ) )
                    // InternalMTL.g:2166:6: ( rule__TexturedMaterial__Group_9__0 )
                    {
                     before(grammarAccess.getTexturedMaterialAccess().getGroup_9()); 
                    // InternalMTL.g:2167:6: ( rule__TexturedMaterial__Group_9__0 )
                    // InternalMTL.g:2167:7: rule__TexturedMaterial__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TexturedMaterial__Group_9__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTexturedMaterialAccess().getGroup_9()); 

                    }


                    }


                    }


                    }
                    break;
                case 11 :
                    // InternalMTL.g:2172:3: ({...}? => ( ( ( rule__TexturedMaterial__Group_10__0 ) ) ) )
                    {
                    // InternalMTL.g:2172:3: ({...}? => ( ( ( rule__TexturedMaterial__Group_10__0 ) ) ) )
                    // InternalMTL.g:2173:4: {...}? => ( ( ( rule__TexturedMaterial__Group_10__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {
                        throw new FailedPredicateException(input, "rule__TexturedMaterial__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10)");
                    }
                    // InternalMTL.g:2173:111: ( ( ( rule__TexturedMaterial__Group_10__0 ) ) )
                    // InternalMTL.g:2174:5: ( ( rule__TexturedMaterial__Group_10__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10);
                    				

                    					selected = true;
                    				
                    // InternalMTL.g:2180:5: ( ( rule__TexturedMaterial__Group_10__0 ) )
                    // InternalMTL.g:2181:6: ( rule__TexturedMaterial__Group_10__0 )
                    {
                     before(grammarAccess.getTexturedMaterialAccess().getGroup_10()); 
                    // InternalMTL.g:2182:6: ( rule__TexturedMaterial__Group_10__0 )
                    // InternalMTL.g:2182:7: rule__TexturedMaterial__Group_10__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TexturedMaterial__Group_10__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTexturedMaterialAccess().getGroup_10()); 

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__UnorderedGroup__Impl"


    // $ANTLR start "rule__TexturedMaterial__UnorderedGroup__0"
    // InternalMTL.g:2195:1: rule__TexturedMaterial__UnorderedGroup__0 : rule__TexturedMaterial__UnorderedGroup__Impl ( rule__TexturedMaterial__UnorderedGroup__1 )? ;
    public final void rule__TexturedMaterial__UnorderedGroup__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2199:1: ( rule__TexturedMaterial__UnorderedGroup__Impl ( rule__TexturedMaterial__UnorderedGroup__1 )? )
            // InternalMTL.g:2200:2: rule__TexturedMaterial__UnorderedGroup__Impl ( rule__TexturedMaterial__UnorderedGroup__1 )?
            {
            pushFollow(FOLLOW_3);
            rule__TexturedMaterial__UnorderedGroup__Impl();

            state._fsp--;

            // InternalMTL.g:2201:2: ( rule__TexturedMaterial__UnorderedGroup__1 )?
            int alt17=2;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // InternalMTL.g:2201:2: rule__TexturedMaterial__UnorderedGroup__1
                    {
                    pushFollow(FOLLOW_2);
                    rule__TexturedMaterial__UnorderedGroup__1();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__UnorderedGroup__0"


    // $ANTLR start "rule__TexturedMaterial__UnorderedGroup__1"
    // InternalMTL.g:2207:1: rule__TexturedMaterial__UnorderedGroup__1 : rule__TexturedMaterial__UnorderedGroup__Impl ( rule__TexturedMaterial__UnorderedGroup__2 )? ;
    public final void rule__TexturedMaterial__UnorderedGroup__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2211:1: ( rule__TexturedMaterial__UnorderedGroup__Impl ( rule__TexturedMaterial__UnorderedGroup__2 )? )
            // InternalMTL.g:2212:2: rule__TexturedMaterial__UnorderedGroup__Impl ( rule__TexturedMaterial__UnorderedGroup__2 )?
            {
            pushFollow(FOLLOW_3);
            rule__TexturedMaterial__UnorderedGroup__Impl();

            state._fsp--;

            // InternalMTL.g:2213:2: ( rule__TexturedMaterial__UnorderedGroup__2 )?
            int alt18=2;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // InternalMTL.g:2213:2: rule__TexturedMaterial__UnorderedGroup__2
                    {
                    pushFollow(FOLLOW_2);
                    rule__TexturedMaterial__UnorderedGroup__2();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__UnorderedGroup__1"


    // $ANTLR start "rule__TexturedMaterial__UnorderedGroup__2"
    // InternalMTL.g:2219:1: rule__TexturedMaterial__UnorderedGroup__2 : rule__TexturedMaterial__UnorderedGroup__Impl ( rule__TexturedMaterial__UnorderedGroup__3 )? ;
    public final void rule__TexturedMaterial__UnorderedGroup__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2223:1: ( rule__TexturedMaterial__UnorderedGroup__Impl ( rule__TexturedMaterial__UnorderedGroup__3 )? )
            // InternalMTL.g:2224:2: rule__TexturedMaterial__UnorderedGroup__Impl ( rule__TexturedMaterial__UnorderedGroup__3 )?
            {
            pushFollow(FOLLOW_3);
            rule__TexturedMaterial__UnorderedGroup__Impl();

            state._fsp--;

            // InternalMTL.g:2225:2: ( rule__TexturedMaterial__UnorderedGroup__3 )?
            int alt19=2;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // InternalMTL.g:2225:2: rule__TexturedMaterial__UnorderedGroup__3
                    {
                    pushFollow(FOLLOW_2);
                    rule__TexturedMaterial__UnorderedGroup__3();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__UnorderedGroup__2"


    // $ANTLR start "rule__TexturedMaterial__UnorderedGroup__3"
    // InternalMTL.g:2231:1: rule__TexturedMaterial__UnorderedGroup__3 : rule__TexturedMaterial__UnorderedGroup__Impl ( rule__TexturedMaterial__UnorderedGroup__4 )? ;
    public final void rule__TexturedMaterial__UnorderedGroup__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2235:1: ( rule__TexturedMaterial__UnorderedGroup__Impl ( rule__TexturedMaterial__UnorderedGroup__4 )? )
            // InternalMTL.g:2236:2: rule__TexturedMaterial__UnorderedGroup__Impl ( rule__TexturedMaterial__UnorderedGroup__4 )?
            {
            pushFollow(FOLLOW_3);
            rule__TexturedMaterial__UnorderedGroup__Impl();

            state._fsp--;

            // InternalMTL.g:2237:2: ( rule__TexturedMaterial__UnorderedGroup__4 )?
            int alt20=2;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // InternalMTL.g:2237:2: rule__TexturedMaterial__UnorderedGroup__4
                    {
                    pushFollow(FOLLOW_2);
                    rule__TexturedMaterial__UnorderedGroup__4();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__UnorderedGroup__3"


    // $ANTLR start "rule__TexturedMaterial__UnorderedGroup__4"
    // InternalMTL.g:2243:1: rule__TexturedMaterial__UnorderedGroup__4 : rule__TexturedMaterial__UnorderedGroup__Impl ( rule__TexturedMaterial__UnorderedGroup__5 )? ;
    public final void rule__TexturedMaterial__UnorderedGroup__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2247:1: ( rule__TexturedMaterial__UnorderedGroup__Impl ( rule__TexturedMaterial__UnorderedGroup__5 )? )
            // InternalMTL.g:2248:2: rule__TexturedMaterial__UnorderedGroup__Impl ( rule__TexturedMaterial__UnorderedGroup__5 )?
            {
            pushFollow(FOLLOW_3);
            rule__TexturedMaterial__UnorderedGroup__Impl();

            state._fsp--;

            // InternalMTL.g:2249:2: ( rule__TexturedMaterial__UnorderedGroup__5 )?
            int alt21=2;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // InternalMTL.g:2249:2: rule__TexturedMaterial__UnorderedGroup__5
                    {
                    pushFollow(FOLLOW_2);
                    rule__TexturedMaterial__UnorderedGroup__5();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__UnorderedGroup__4"


    // $ANTLR start "rule__TexturedMaterial__UnorderedGroup__5"
    // InternalMTL.g:2255:1: rule__TexturedMaterial__UnorderedGroup__5 : rule__TexturedMaterial__UnorderedGroup__Impl ( rule__TexturedMaterial__UnorderedGroup__6 )? ;
    public final void rule__TexturedMaterial__UnorderedGroup__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2259:1: ( rule__TexturedMaterial__UnorderedGroup__Impl ( rule__TexturedMaterial__UnorderedGroup__6 )? )
            // InternalMTL.g:2260:2: rule__TexturedMaterial__UnorderedGroup__Impl ( rule__TexturedMaterial__UnorderedGroup__6 )?
            {
            pushFollow(FOLLOW_3);
            rule__TexturedMaterial__UnorderedGroup__Impl();

            state._fsp--;

            // InternalMTL.g:2261:2: ( rule__TexturedMaterial__UnorderedGroup__6 )?
            int alt22=2;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // InternalMTL.g:2261:2: rule__TexturedMaterial__UnorderedGroup__6
                    {
                    pushFollow(FOLLOW_2);
                    rule__TexturedMaterial__UnorderedGroup__6();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__UnorderedGroup__5"


    // $ANTLR start "rule__TexturedMaterial__UnorderedGroup__6"
    // InternalMTL.g:2267:1: rule__TexturedMaterial__UnorderedGroup__6 : rule__TexturedMaterial__UnorderedGroup__Impl ( rule__TexturedMaterial__UnorderedGroup__7 )? ;
    public final void rule__TexturedMaterial__UnorderedGroup__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2271:1: ( rule__TexturedMaterial__UnorderedGroup__Impl ( rule__TexturedMaterial__UnorderedGroup__7 )? )
            // InternalMTL.g:2272:2: rule__TexturedMaterial__UnorderedGroup__Impl ( rule__TexturedMaterial__UnorderedGroup__7 )?
            {
            pushFollow(FOLLOW_3);
            rule__TexturedMaterial__UnorderedGroup__Impl();

            state._fsp--;

            // InternalMTL.g:2273:2: ( rule__TexturedMaterial__UnorderedGroup__7 )?
            int alt23=2;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // InternalMTL.g:2273:2: rule__TexturedMaterial__UnorderedGroup__7
                    {
                    pushFollow(FOLLOW_2);
                    rule__TexturedMaterial__UnorderedGroup__7();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__UnorderedGroup__6"


    // $ANTLR start "rule__TexturedMaterial__UnorderedGroup__7"
    // InternalMTL.g:2279:1: rule__TexturedMaterial__UnorderedGroup__7 : rule__TexturedMaterial__UnorderedGroup__Impl ( rule__TexturedMaterial__UnorderedGroup__8 )? ;
    public final void rule__TexturedMaterial__UnorderedGroup__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2283:1: ( rule__TexturedMaterial__UnorderedGroup__Impl ( rule__TexturedMaterial__UnorderedGroup__8 )? )
            // InternalMTL.g:2284:2: rule__TexturedMaterial__UnorderedGroup__Impl ( rule__TexturedMaterial__UnorderedGroup__8 )?
            {
            pushFollow(FOLLOW_3);
            rule__TexturedMaterial__UnorderedGroup__Impl();

            state._fsp--;

            // InternalMTL.g:2285:2: ( rule__TexturedMaterial__UnorderedGroup__8 )?
            int alt24=2;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // InternalMTL.g:2285:2: rule__TexturedMaterial__UnorderedGroup__8
                    {
                    pushFollow(FOLLOW_2);
                    rule__TexturedMaterial__UnorderedGroup__8();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__UnorderedGroup__7"


    // $ANTLR start "rule__TexturedMaterial__UnorderedGroup__8"
    // InternalMTL.g:2291:1: rule__TexturedMaterial__UnorderedGroup__8 : rule__TexturedMaterial__UnorderedGroup__Impl ( rule__TexturedMaterial__UnorderedGroup__9 )? ;
    public final void rule__TexturedMaterial__UnorderedGroup__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2295:1: ( rule__TexturedMaterial__UnorderedGroup__Impl ( rule__TexturedMaterial__UnorderedGroup__9 )? )
            // InternalMTL.g:2296:2: rule__TexturedMaterial__UnorderedGroup__Impl ( rule__TexturedMaterial__UnorderedGroup__9 )?
            {
            pushFollow(FOLLOW_3);
            rule__TexturedMaterial__UnorderedGroup__Impl();

            state._fsp--;

            // InternalMTL.g:2297:2: ( rule__TexturedMaterial__UnorderedGroup__9 )?
            int alt25=2;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // InternalMTL.g:2297:2: rule__TexturedMaterial__UnorderedGroup__9
                    {
                    pushFollow(FOLLOW_2);
                    rule__TexturedMaterial__UnorderedGroup__9();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__UnorderedGroup__8"


    // $ANTLR start "rule__TexturedMaterial__UnorderedGroup__9"
    // InternalMTL.g:2303:1: rule__TexturedMaterial__UnorderedGroup__9 : rule__TexturedMaterial__UnorderedGroup__Impl ( rule__TexturedMaterial__UnorderedGroup__10 )? ;
    public final void rule__TexturedMaterial__UnorderedGroup__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2307:1: ( rule__TexturedMaterial__UnorderedGroup__Impl ( rule__TexturedMaterial__UnorderedGroup__10 )? )
            // InternalMTL.g:2308:2: rule__TexturedMaterial__UnorderedGroup__Impl ( rule__TexturedMaterial__UnorderedGroup__10 )?
            {
            pushFollow(FOLLOW_3);
            rule__TexturedMaterial__UnorderedGroup__Impl();

            state._fsp--;

            // InternalMTL.g:2309:2: ( rule__TexturedMaterial__UnorderedGroup__10 )?
            int alt26=2;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // InternalMTL.g:2309:2: rule__TexturedMaterial__UnorderedGroup__10
                    {
                    pushFollow(FOLLOW_2);
                    rule__TexturedMaterial__UnorderedGroup__10();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__UnorderedGroup__9"


    // $ANTLR start "rule__TexturedMaterial__UnorderedGroup__10"
    // InternalMTL.g:2315:1: rule__TexturedMaterial__UnorderedGroup__10 : rule__TexturedMaterial__UnorderedGroup__Impl ;
    public final void rule__TexturedMaterial__UnorderedGroup__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2319:1: ( rule__TexturedMaterial__UnorderedGroup__Impl )
            // InternalMTL.g:2320:2: rule__TexturedMaterial__UnorderedGroup__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TexturedMaterial__UnorderedGroup__Impl();

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
    // $ANTLR end "rule__TexturedMaterial__UnorderedGroup__10"


    // $ANTLR start "rule__MaterialSource__MaterialsAssignment"
    // InternalMTL.g:2327:1: rule__MaterialSource__MaterialsAssignment : ( ruleMaterial ) ;
    public final void rule__MaterialSource__MaterialsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2331:1: ( ( ruleMaterial ) )
            // InternalMTL.g:2332:2: ( ruleMaterial )
            {
            // InternalMTL.g:2332:2: ( ruleMaterial )
            // InternalMTL.g:2333:3: ruleMaterial
            {
             before(grammarAccess.getMaterialSourceAccess().getMaterialsMaterialParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleMaterial();

            state._fsp--;

             after(grammarAccess.getMaterialSourceAccess().getMaterialsMaterialParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MaterialSource__MaterialsAssignment"


    // $ANTLR start "rule__PhongMaterial__NameAssignment_0_1"
    // InternalMTL.g:2342:1: rule__PhongMaterial__NameAssignment_0_1 : ( ruleEString ) ;
    public final void rule__PhongMaterial__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2346:1: ( ( ruleEString ) )
            // InternalMTL.g:2347:2: ( ruleEString )
            {
            // InternalMTL.g:2347:2: ( ruleEString )
            // InternalMTL.g:2348:3: ruleEString
            {
             before(grammarAccess.getPhongMaterialAccess().getNameEStringParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getPhongMaterialAccess().getNameEStringParserRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__NameAssignment_0_1"


    // $ANTLR start "rule__PhongMaterial__AmbientAssignment_0_2_1"
    // InternalMTL.g:2357:1: rule__PhongMaterial__AmbientAssignment_0_2_1 : ( ruleColor ) ;
    public final void rule__PhongMaterial__AmbientAssignment_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2361:1: ( ( ruleColor ) )
            // InternalMTL.g:2362:2: ( ruleColor )
            {
            // InternalMTL.g:2362:2: ( ruleColor )
            // InternalMTL.g:2363:3: ruleColor
            {
             before(grammarAccess.getPhongMaterialAccess().getAmbientColorParserRuleCall_0_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleColor();

            state._fsp--;

             after(grammarAccess.getPhongMaterialAccess().getAmbientColorParserRuleCall_0_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__AmbientAssignment_0_2_1"


    // $ANTLR start "rule__PhongMaterial__DiffuseAssignment_1_1"
    // InternalMTL.g:2372:1: rule__PhongMaterial__DiffuseAssignment_1_1 : ( ruleColor ) ;
    public final void rule__PhongMaterial__DiffuseAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2376:1: ( ( ruleColor ) )
            // InternalMTL.g:2377:2: ( ruleColor )
            {
            // InternalMTL.g:2377:2: ( ruleColor )
            // InternalMTL.g:2378:3: ruleColor
            {
             before(grammarAccess.getPhongMaterialAccess().getDiffuseColorParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleColor();

            state._fsp--;

             after(grammarAccess.getPhongMaterialAccess().getDiffuseColorParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__DiffuseAssignment_1_1"


    // $ANTLR start "rule__PhongMaterial__SpecularAssignment_2_1"
    // InternalMTL.g:2387:1: rule__PhongMaterial__SpecularAssignment_2_1 : ( ruleColor ) ;
    public final void rule__PhongMaterial__SpecularAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2391:1: ( ( ruleColor ) )
            // InternalMTL.g:2392:2: ( ruleColor )
            {
            // InternalMTL.g:2392:2: ( ruleColor )
            // InternalMTL.g:2393:3: ruleColor
            {
             before(grammarAccess.getPhongMaterialAccess().getSpecularColorParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleColor();

            state._fsp--;

             after(grammarAccess.getPhongMaterialAccess().getSpecularColorParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__SpecularAssignment_2_1"


    // $ANTLR start "rule__PhongMaterial__SpecularExponentAssignment_2_2_1"
    // InternalMTL.g:2402:1: rule__PhongMaterial__SpecularExponentAssignment_2_2_1 : ( ruleEDouble ) ;
    public final void rule__PhongMaterial__SpecularExponentAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2406:1: ( ( ruleEDouble ) )
            // InternalMTL.g:2407:2: ( ruleEDouble )
            {
            // InternalMTL.g:2407:2: ( ruleEDouble )
            // InternalMTL.g:2408:3: ruleEDouble
            {
             before(grammarAccess.getPhongMaterialAccess().getSpecularExponentEDoubleParserRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getPhongMaterialAccess().getSpecularExponentEDoubleParserRuleCall_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__SpecularExponentAssignment_2_2_1"


    // $ANTLR start "rule__PhongMaterial__OpaqueAssignment_3_0_1"
    // InternalMTL.g:2417:1: rule__PhongMaterial__OpaqueAssignment_3_0_1 : ( ruleEDouble ) ;
    public final void rule__PhongMaterial__OpaqueAssignment_3_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2421:1: ( ( ruleEDouble ) )
            // InternalMTL.g:2422:2: ( ruleEDouble )
            {
            // InternalMTL.g:2422:2: ( ruleEDouble )
            // InternalMTL.g:2423:3: ruleEDouble
            {
             before(grammarAccess.getPhongMaterialAccess().getOpaqueEDoubleParserRuleCall_3_0_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getPhongMaterialAccess().getOpaqueEDoubleParserRuleCall_3_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__OpaqueAssignment_3_0_1"


    // $ANTLR start "rule__PhongMaterial__TransparentAssignment_3_1_1"
    // InternalMTL.g:2432:1: rule__PhongMaterial__TransparentAssignment_3_1_1 : ( ruleEDouble ) ;
    public final void rule__PhongMaterial__TransparentAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2436:1: ( ( ruleEDouble ) )
            // InternalMTL.g:2437:2: ( ruleEDouble )
            {
            // InternalMTL.g:2437:2: ( ruleEDouble )
            // InternalMTL.g:2438:3: ruleEDouble
            {
             before(grammarAccess.getPhongMaterialAccess().getTransparentEDoubleParserRuleCall_3_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getPhongMaterialAccess().getTransparentEDoubleParserRuleCall_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__TransparentAssignment_3_1_1"


    // $ANTLR start "rule__PhongMaterial__IlluminationAssignment_4_1"
    // InternalMTL.g:2447:1: rule__PhongMaterial__IlluminationAssignment_4_1 : ( ruleEInt ) ;
    public final void rule__PhongMaterial__IlluminationAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2451:1: ( ( ruleEInt ) )
            // InternalMTL.g:2452:2: ( ruleEInt )
            {
            // InternalMTL.g:2452:2: ( ruleEInt )
            // InternalMTL.g:2453:3: ruleEInt
            {
             before(grammarAccess.getPhongMaterialAccess().getIlluminationEIntParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getPhongMaterialAccess().getIlluminationEIntParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhongMaterial__IlluminationAssignment_4_1"


    // $ANTLR start "rule__TexturedMaterial__NameAssignment_0_1"
    // InternalMTL.g:2462:1: rule__TexturedMaterial__NameAssignment_0_1 : ( ruleEString ) ;
    public final void rule__TexturedMaterial__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2466:1: ( ( ruleEString ) )
            // InternalMTL.g:2467:2: ( ruleEString )
            {
            // InternalMTL.g:2467:2: ( ruleEString )
            // InternalMTL.g:2468:3: ruleEString
            {
             before(grammarAccess.getTexturedMaterialAccess().getNameEStringParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTexturedMaterialAccess().getNameEStringParserRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__NameAssignment_0_1"


    // $ANTLR start "rule__TexturedMaterial__AmbientAssignment_0_2_1"
    // InternalMTL.g:2477:1: rule__TexturedMaterial__AmbientAssignment_0_2_1 : ( ruleColor ) ;
    public final void rule__TexturedMaterial__AmbientAssignment_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2481:1: ( ( ruleColor ) )
            // InternalMTL.g:2482:2: ( ruleColor )
            {
            // InternalMTL.g:2482:2: ( ruleColor )
            // InternalMTL.g:2483:3: ruleColor
            {
             before(grammarAccess.getTexturedMaterialAccess().getAmbientColorParserRuleCall_0_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleColor();

            state._fsp--;

             after(grammarAccess.getTexturedMaterialAccess().getAmbientColorParserRuleCall_0_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__AmbientAssignment_0_2_1"


    // $ANTLR start "rule__TexturedMaterial__DiffuseAssignment_1_1"
    // InternalMTL.g:2492:1: rule__TexturedMaterial__DiffuseAssignment_1_1 : ( ruleColor ) ;
    public final void rule__TexturedMaterial__DiffuseAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2496:1: ( ( ruleColor ) )
            // InternalMTL.g:2497:2: ( ruleColor )
            {
            // InternalMTL.g:2497:2: ( ruleColor )
            // InternalMTL.g:2498:3: ruleColor
            {
             before(grammarAccess.getTexturedMaterialAccess().getDiffuseColorParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleColor();

            state._fsp--;

             after(grammarAccess.getTexturedMaterialAccess().getDiffuseColorParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__DiffuseAssignment_1_1"


    // $ANTLR start "rule__TexturedMaterial__SpecularAssignment_2_1"
    // InternalMTL.g:2507:1: rule__TexturedMaterial__SpecularAssignment_2_1 : ( ruleColor ) ;
    public final void rule__TexturedMaterial__SpecularAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2511:1: ( ( ruleColor ) )
            // InternalMTL.g:2512:2: ( ruleColor )
            {
            // InternalMTL.g:2512:2: ( ruleColor )
            // InternalMTL.g:2513:3: ruleColor
            {
             before(grammarAccess.getTexturedMaterialAccess().getSpecularColorParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleColor();

            state._fsp--;

             after(grammarAccess.getTexturedMaterialAccess().getSpecularColorParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__SpecularAssignment_2_1"


    // $ANTLR start "rule__TexturedMaterial__SpecularExponentAssignment_2_2_1"
    // InternalMTL.g:2522:1: rule__TexturedMaterial__SpecularExponentAssignment_2_2_1 : ( ruleEDouble ) ;
    public final void rule__TexturedMaterial__SpecularExponentAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2526:1: ( ( ruleEDouble ) )
            // InternalMTL.g:2527:2: ( ruleEDouble )
            {
            // InternalMTL.g:2527:2: ( ruleEDouble )
            // InternalMTL.g:2528:3: ruleEDouble
            {
             before(grammarAccess.getTexturedMaterialAccess().getSpecularExponentEDoubleParserRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getTexturedMaterialAccess().getSpecularExponentEDoubleParserRuleCall_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__SpecularExponentAssignment_2_2_1"


    // $ANTLR start "rule__TexturedMaterial__OpaqueAssignment_3_0_1"
    // InternalMTL.g:2537:1: rule__TexturedMaterial__OpaqueAssignment_3_0_1 : ( ruleEDouble ) ;
    public final void rule__TexturedMaterial__OpaqueAssignment_3_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2541:1: ( ( ruleEDouble ) )
            // InternalMTL.g:2542:2: ( ruleEDouble )
            {
            // InternalMTL.g:2542:2: ( ruleEDouble )
            // InternalMTL.g:2543:3: ruleEDouble
            {
             before(grammarAccess.getTexturedMaterialAccess().getOpaqueEDoubleParserRuleCall_3_0_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getTexturedMaterialAccess().getOpaqueEDoubleParserRuleCall_3_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__OpaqueAssignment_3_0_1"


    // $ANTLR start "rule__TexturedMaterial__TransparentAssignment_3_1_1"
    // InternalMTL.g:2552:1: rule__TexturedMaterial__TransparentAssignment_3_1_1 : ( ruleEDouble ) ;
    public final void rule__TexturedMaterial__TransparentAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2556:1: ( ( ruleEDouble ) )
            // InternalMTL.g:2557:2: ( ruleEDouble )
            {
            // InternalMTL.g:2557:2: ( ruleEDouble )
            // InternalMTL.g:2558:3: ruleEDouble
            {
             before(grammarAccess.getTexturedMaterialAccess().getTransparentEDoubleParserRuleCall_3_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getTexturedMaterialAccess().getTransparentEDoubleParserRuleCall_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__TransparentAssignment_3_1_1"


    // $ANTLR start "rule__TexturedMaterial__IlluminationAssignment_4_1"
    // InternalMTL.g:2567:1: rule__TexturedMaterial__IlluminationAssignment_4_1 : ( ruleEInt ) ;
    public final void rule__TexturedMaterial__IlluminationAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2571:1: ( ( ruleEInt ) )
            // InternalMTL.g:2572:2: ( ruleEInt )
            {
            // InternalMTL.g:2572:2: ( ruleEInt )
            // InternalMTL.g:2573:3: ruleEInt
            {
             before(grammarAccess.getTexturedMaterialAccess().getIlluminationEIntParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getTexturedMaterialAccess().getIlluminationEIntParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__IlluminationAssignment_4_1"


    // $ANTLR start "rule__TexturedMaterial__AmbientMapAssignment_5_1"
    // InternalMTL.g:2582:1: rule__TexturedMaterial__AmbientMapAssignment_5_1 : ( ruleEString ) ;
    public final void rule__TexturedMaterial__AmbientMapAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2586:1: ( ( ruleEString ) )
            // InternalMTL.g:2587:2: ( ruleEString )
            {
            // InternalMTL.g:2587:2: ( ruleEString )
            // InternalMTL.g:2588:3: ruleEString
            {
             before(grammarAccess.getTexturedMaterialAccess().getAmbientMapEStringParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTexturedMaterialAccess().getAmbientMapEStringParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__AmbientMapAssignment_5_1"


    // $ANTLR start "rule__TexturedMaterial__DiffuseMapAssignment_6_1"
    // InternalMTL.g:2597:1: rule__TexturedMaterial__DiffuseMapAssignment_6_1 : ( ruleEString ) ;
    public final void rule__TexturedMaterial__DiffuseMapAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2601:1: ( ( ruleEString ) )
            // InternalMTL.g:2602:2: ( ruleEString )
            {
            // InternalMTL.g:2602:2: ( ruleEString )
            // InternalMTL.g:2603:3: ruleEString
            {
             before(grammarAccess.getTexturedMaterialAccess().getDiffuseMapEStringParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTexturedMaterialAccess().getDiffuseMapEStringParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__DiffuseMapAssignment_6_1"


    // $ANTLR start "rule__TexturedMaterial__SpecularMapAssignment_7_1"
    // InternalMTL.g:2612:1: rule__TexturedMaterial__SpecularMapAssignment_7_1 : ( ruleEString ) ;
    public final void rule__TexturedMaterial__SpecularMapAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2616:1: ( ( ruleEString ) )
            // InternalMTL.g:2617:2: ( ruleEString )
            {
            // InternalMTL.g:2617:2: ( ruleEString )
            // InternalMTL.g:2618:3: ruleEString
            {
             before(grammarAccess.getTexturedMaterialAccess().getSpecularMapEStringParserRuleCall_7_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTexturedMaterialAccess().getSpecularMapEStringParserRuleCall_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__SpecularMapAssignment_7_1"


    // $ANTLR start "rule__TexturedMaterial__SpecularHighlightMapAssignment_8_1"
    // InternalMTL.g:2627:1: rule__TexturedMaterial__SpecularHighlightMapAssignment_8_1 : ( ruleEString ) ;
    public final void rule__TexturedMaterial__SpecularHighlightMapAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2631:1: ( ( ruleEString ) )
            // InternalMTL.g:2632:2: ( ruleEString )
            {
            // InternalMTL.g:2632:2: ( ruleEString )
            // InternalMTL.g:2633:3: ruleEString
            {
             before(grammarAccess.getTexturedMaterialAccess().getSpecularHighlightMapEStringParserRuleCall_8_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTexturedMaterialAccess().getSpecularHighlightMapEStringParserRuleCall_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__SpecularHighlightMapAssignment_8_1"


    // $ANTLR start "rule__TexturedMaterial__AlphaMapAssignment_9_1"
    // InternalMTL.g:2642:1: rule__TexturedMaterial__AlphaMapAssignment_9_1 : ( ruleEString ) ;
    public final void rule__TexturedMaterial__AlphaMapAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2646:1: ( ( ruleEString ) )
            // InternalMTL.g:2647:2: ( ruleEString )
            {
            // InternalMTL.g:2647:2: ( ruleEString )
            // InternalMTL.g:2648:3: ruleEString
            {
             before(grammarAccess.getTexturedMaterialAccess().getAlphaMapEStringParserRuleCall_9_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTexturedMaterialAccess().getAlphaMapEStringParserRuleCall_9_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__AlphaMapAssignment_9_1"


    // $ANTLR start "rule__TexturedMaterial__BumpMapAssignment_10_1"
    // InternalMTL.g:2657:1: rule__TexturedMaterial__BumpMapAssignment_10_1 : ( ruleEString ) ;
    public final void rule__TexturedMaterial__BumpMapAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2661:1: ( ( ruleEString ) )
            // InternalMTL.g:2662:2: ( ruleEString )
            {
            // InternalMTL.g:2662:2: ( ruleEString )
            // InternalMTL.g:2663:3: ruleEString
            {
             before(grammarAccess.getTexturedMaterialAccess().getBumpMapEStringParserRuleCall_10_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTexturedMaterialAccess().getBumpMapEStringParserRuleCall_10_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TexturedMaterial__BumpMapAssignment_10_1"


    // $ANTLR start "rule__Color__RedAssignment_0"
    // InternalMTL.g:2672:1: rule__Color__RedAssignment_0 : ( ruleEDouble ) ;
    public final void rule__Color__RedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2676:1: ( ( ruleEDouble ) )
            // InternalMTL.g:2677:2: ( ruleEDouble )
            {
            // InternalMTL.g:2677:2: ( ruleEDouble )
            // InternalMTL.g:2678:3: ruleEDouble
            {
             before(grammarAccess.getColorAccess().getRedEDoubleParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getColorAccess().getRedEDoubleParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Color__RedAssignment_0"


    // $ANTLR start "rule__Color__GreenAssignment_1"
    // InternalMTL.g:2687:1: rule__Color__GreenAssignment_1 : ( ruleEDouble ) ;
    public final void rule__Color__GreenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2691:1: ( ( ruleEDouble ) )
            // InternalMTL.g:2692:2: ( ruleEDouble )
            {
            // InternalMTL.g:2692:2: ( ruleEDouble )
            // InternalMTL.g:2693:3: ruleEDouble
            {
             before(grammarAccess.getColorAccess().getGreenEDoubleParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getColorAccess().getGreenEDoubleParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Color__GreenAssignment_1"


    // $ANTLR start "rule__Color__BlueAssignment_2"
    // InternalMTL.g:2702:1: rule__Color__BlueAssignment_2 : ( ruleEDouble ) ;
    public final void rule__Color__BlueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMTL.g:2706:1: ( ( ruleEDouble ) )
            // InternalMTL.g:2707:2: ( ruleEDouble )
            {
            // InternalMTL.g:2707:2: ( ruleEDouble )
            // InternalMTL.g:2708:3: ruleEDouble
            {
             before(grammarAccess.getColorAccess().getBlueEDoubleParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getColorAccess().getBlueEDoubleParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Color__BlueAssignment_2"

    // Delegated rules


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA13 dfa13 = new DFA13(this);
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA15 dfa15 = new DFA15(this);
    protected DFA16 dfa16 = new DFA16(this);
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA18 dfa18 = new DFA18(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA22 dfa22 = new DFA22(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA26 dfa26 = new DFA26(this);
    static final String dfa_1s = "\76\uffff";
    static final String dfa_2s = "\1\22\1\4\5\6\1\uffff\11\4\6\6\1\uffff\1\6\2\uffff\1\6\1\uffff\1\6\1\uffff\11\4\12\6\1\uffff\1\6\2\uffff\1\6\1\uffff\3\6\1\uffff\1\6\1\uffff";
    static final String dfa_3s = "\1\37\6\21\1\uffff\11\23\1\21\1\6\2\21\1\6\1\21\1\uffff\1\6\2\uffff\1\6\1\uffff\1\6\1\uffff\11\23\2\21\1\6\2\21\1\6\2\21\1\6\1\21\1\uffff\1\6\2\uffff\1\6\1\uffff\1\21\1\6\1\21\1\uffff\1\6\1\uffff";
    static final String dfa_4s = "\7\uffff\1\2\17\uffff\1\1\1\uffff\2\1\1\uffff\1\1\1\uffff\1\1\23\uffff\1\1\1\uffff\2\1\1\uffff\1\1\3\uffff\1\1\1\uffff\1\1";
    static final String dfa_5s = "\76\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\1\uffff\1\2\1\3\1\uffff\1\4\1\5\1\6\6\7",
            "\1\10\1\11\1\12\5\uffff\1\13\1\14\1\15\1\16\1\17\1\20",
            "\1\23\1\21\11\uffff\1\22",
            "\1\26\1\24\11\uffff\1\25",
            "\1\31\1\27\11\uffff\1\30",
            "\1\34\1\32\11\uffff\1\33",
            "\1\36\12\uffff\1\35",
            "",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\53\1\51\11\uffff\1\52",
            "\1\23",
            "\1\53\1\51\11\uffff\1\52",
            "\1\56\1\54\11\uffff\1\55",
            "\1\26",
            "\1\56\1\54\11\uffff\1\55",
            "",
            "\1\31",
            "",
            "",
            "\1\34",
            "",
            "\1\36",
            "",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\61\1\57\11\uffff\1\60",
            "\1\64\1\62\11\uffff\1\63",
            "\1\53",
            "\1\64\1\62\11\uffff\1\63",
            "\1\67\1\65\11\uffff\1\66",
            "\1\56",
            "\1\67\1\65\11\uffff\1\66",
            "\1\72\1\70\11\uffff\1\71",
            "\1\61",
            "\1\72\1\70\11\uffff\1\71",
            "",
            "\1\64",
            "",
            "",
            "\1\67",
            "",
            "\1\75\1\73\11\uffff\1\74",
            "\1\72",
            "\1\75\1\73\11\uffff\1\74",
            "",
            "\1\75",
            ""
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
            return "259:1: rule__Material__Alternatives : ( ( rulePhongMaterial ) | ( ruleTexturedMaterial ) );";
        }
    }
    static final String dfa_7s = "\77\uffff";
    static final String dfa_8s = "\1\7\76\uffff";
    static final String dfa_9s = "\1\22\1\4\5\6\1\uffff\11\4\6\6\1\0\1\6\2\0\1\6\1\0\1\6\1\0\11\4\7\6\1\uffff\3\6\1\0\1\6\2\0\1\6\1\0\3\6\1\0\1\6\1\0";
    static final String dfa_10s = "\1\37\6\21\1\uffff\11\23\1\21\1\6\2\21\1\6\1\21\1\0\1\6\2\0\1\6\1\0\1\6\1\0\11\23\2\21\1\6\2\21\1\6\1\21\1\uffff\1\21\1\6\1\21\1\0\1\6\2\0\1\6\1\0\1\21\1\6\1\21\1\0\1\6\1\0";
    static final String dfa_11s = "\7\uffff\1\2\47\uffff\1\1\17\uffff";
    static final String dfa_12s = "\27\uffff\1\1\1\uffff\1\0\1\10\1\uffff\1\7\1\uffff\1\4\24\uffff\1\5\1\uffff\1\3\1\6\1\uffff\1\2\3\uffff\1\11\1\uffff\1\12}>";
    static final String[] dfa_13s = {
            "\1\1\1\uffff\1\2\1\3\1\uffff\1\4\1\5\1\6\6\7",
            "\1\10\1\11\1\12\5\uffff\1\13\1\14\1\15\1\16\1\17\1\20",
            "\1\23\1\21\11\uffff\1\22",
            "\1\26\1\24\11\uffff\1\25",
            "\1\31\1\27\11\uffff\1\30",
            "\1\34\1\32\11\uffff\1\33",
            "\1\36\12\uffff\1\35",
            "",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\53\1\51\11\uffff\1\52",
            "\1\23",
            "\1\53\1\51\11\uffff\1\52",
            "\1\56\1\54\11\uffff\1\55",
            "\1\26",
            "\1\56\1\54\11\uffff\1\55",
            "\1\uffff",
            "\1\31",
            "\1\uffff",
            "\1\uffff",
            "\1\34",
            "\1\uffff",
            "\1\36",
            "\1\uffff",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\37\1\40\1\41\5\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\50",
            "\1\62\1\60\11\uffff\1\61",
            "\1\65\1\63\11\uffff\1\64",
            "\1\53",
            "\1\65\1\63\11\uffff\1\64",
            "\1\70\1\66\11\uffff\1\67",
            "\1\56",
            "\1\70\1\66\11\uffff\1\67",
            "",
            "\1\73\1\71\11\uffff\1\72",
            "\1\62",
            "\1\73\1\71\11\uffff\1\72",
            "\1\uffff",
            "\1\65",
            "\1\uffff",
            "\1\uffff",
            "\1\70",
            "\1\uffff",
            "\1\76\1\74\11\uffff\1\75",
            "\1\73",
            "\1\76\1\74\11\uffff\1\75",
            "\1\uffff",
            "\1\76",
            "\1\uffff"
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
            return "1947:2: ( rule__PhongMaterial__UnorderedGroup__1 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_25 = input.LA(1);

                         
                        int index12_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 3) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index12_25);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_23 = input.LA(1);

                         
                        int index12_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 3) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index12_23);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_56 = input.LA(1);

                         
                        int index12_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 2) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index12_56);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA12_53 = input.LA(1);

                         
                        int index12_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 1) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index12_53);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA12_30 = input.LA(1);

                         
                        int index12_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 4) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index12_30);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA12_51 = input.LA(1);

                         
                        int index12_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 1) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index12_51);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA12_54 = input.LA(1);

                         
                        int index12_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 2) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index12_54);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA12_28 = input.LA(1);

                         
                        int index12_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 3) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index12_28);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA12_26 = input.LA(1);

                         
                        int index12_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 3) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index12_26);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA12_60 = input.LA(1);

                         
                        int index12_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 0) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index12_60);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA12_62 = input.LA(1);

                         
                        int index12_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 0) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index12_62);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_14s = "\27\uffff\1\0\1\uffff\1\1\1\7\1\uffff\1\12\1\uffff\1\4\24\uffff\1\5\1\uffff\1\2\1\3\1\uffff\1\6\3\uffff\1\10\1\uffff\1\11}>";
    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_14;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "1959:2: ( rule__PhongMaterial__UnorderedGroup__2 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA13_23 = input.LA(1);

                         
                        int index13_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 3) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index13_23);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA13_25 = input.LA(1);

                         
                        int index13_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 3) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index13_25);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA13_53 = input.LA(1);

                         
                        int index13_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 1) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index13_53);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA13_54 = input.LA(1);

                         
                        int index13_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 2) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index13_54);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA13_30 = input.LA(1);

                         
                        int index13_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 4) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index13_30);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA13_51 = input.LA(1);

                         
                        int index13_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 1) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index13_51);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA13_56 = input.LA(1);

                         
                        int index13_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 2) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index13_56);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA13_26 = input.LA(1);

                         
                        int index13_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 3) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index13_26);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA13_60 = input.LA(1);

                         
                        int index13_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 0) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index13_60);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA13_62 = input.LA(1);

                         
                        int index13_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 0) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index13_62);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA13_28 = input.LA(1);

                         
                        int index13_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 3) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index13_28);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 13, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_15s = "\27\uffff\1\5\1\uffff\1\4\1\3\1\uffff\1\1\1\uffff\1\10\24\uffff\1\11\1\uffff\1\6\1\12\1\uffff\1\7\3\uffff\1\0\1\uffff\1\2}>";
    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_15;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "1971:2: ( rule__PhongMaterial__UnorderedGroup__3 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_60 = input.LA(1);

                         
                        int index14_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 0) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index14_60);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_28 = input.LA(1);

                         
                        int index14_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 3) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index14_28);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA14_62 = input.LA(1);

                         
                        int index14_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 0) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index14_62);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA14_26 = input.LA(1);

                         
                        int index14_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 3) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index14_26);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA14_25 = input.LA(1);

                         
                        int index14_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 3) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index14_25);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA14_23 = input.LA(1);

                         
                        int index14_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 3) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index14_23);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA14_53 = input.LA(1);

                         
                        int index14_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 1) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index14_53);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA14_56 = input.LA(1);

                         
                        int index14_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 2) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index14_56);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA14_30 = input.LA(1);

                         
                        int index14_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 4) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index14_30);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA14_51 = input.LA(1);

                         
                        int index14_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 1) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index14_51);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA14_54 = input.LA(1);

                         
                        int index14_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 2) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index14_54);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_16s = "\27\uffff\1\10\1\uffff\1\7\1\6\1\uffff\1\4\1\uffff\1\2\24\uffff\1\1\1\uffff\1\12\1\0\1\uffff\1\11\3\uffff\1\3\1\uffff\1\5}>";
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_16;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "1983:2: ( rule__PhongMaterial__UnorderedGroup__4 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA15_54 = input.LA(1);

                         
                        int index15_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 2) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index15_54);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA15_51 = input.LA(1);

                         
                        int index15_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 1) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index15_51);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA15_30 = input.LA(1);

                         
                        int index15_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 4) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index15_30);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA15_60 = input.LA(1);

                         
                        int index15_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 0) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index15_60);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA15_28 = input.LA(1);

                         
                        int index15_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 3) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index15_28);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA15_62 = input.LA(1);

                         
                        int index15_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 0) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index15_62);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA15_26 = input.LA(1);

                         
                        int index15_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 3) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index15_26);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA15_25 = input.LA(1);

                         
                        int index15_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 3) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index15_25);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA15_23 = input.LA(1);

                         
                        int index15_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 3) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index15_23);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA15_56 = input.LA(1);

                         
                        int index15_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 2) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index15_56);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA15_53 = input.LA(1);

                         
                        int index15_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getPhongMaterialAccess().getUnorderedGroup(), 1) ) {s = 47;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getPhongMaterialAccess().getUnorderedGroup()) ) {s = 7;}

                         
                        input.seek(index15_53);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 15, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_17s = "\14\uffff";
    static final String dfa_18s = "\1\22\13\uffff";
    static final String dfa_19s = "\1\37\13\uffff";
    static final String dfa_20s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13";
    static final String dfa_21s = "\1\0\13\uffff}>";
    static final String[] dfa_22s = {
            "\1\1\1\uffff\1\2\1\3\1\uffff\2\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13",
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
            ""
    };

    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final char[] dfa_18 = DFA.unpackEncodedStringToUnsignedChars(dfa_18s);
    static final char[] dfa_19 = DFA.unpackEncodedStringToUnsignedChars(dfa_19s);
    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final short[] dfa_21 = DFA.unpackEncodedString(dfa_21s);
    static final short[][] dfa_22 = unpackEncodedStringArray(dfa_22s);

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = dfa_17;
            this.eof = dfa_17;
            this.min = dfa_18;
            this.max = dfa_19;
            this.accept = dfa_20;
            this.special = dfa_21;
            this.transition = dfa_22;
        }
        public String getDescription() {
            return "2021:3: ( ({...}? => ( ( ( rule__TexturedMaterial__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_1__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_2__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Alternatives_3 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_4__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_5__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_6__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_7__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_8__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_9__0 ) ) ) ) | ({...}? => ( ( ( rule__TexturedMaterial__Group_10__0 ) ) ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA16_0 = input.LA(1);

                         
                        int index16_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA16_0 == 18 && getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 0) ) {s = 1;}

                        else if ( LA16_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 1) ) {s = 2;}

                        else if ( LA16_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 2) ) {s = 3;}

                        else if ( LA16_0 >= 23 && LA16_0 <= 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 4;}

                        else if ( LA16_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 4) ) {s = 5;}

                        else if ( LA16_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 6;}

                        else if ( LA16_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 7;}

                        else if ( LA16_0 == 28 && getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 8;}

                        else if ( LA16_0 == 29 && getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 9;}

                        else if ( LA16_0 == 30 && getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 10;}

                        else if ( LA16_0 == 31 && getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 11;}

                         
                        input.seek(index16_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 16, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_23s = "\173\uffff";
    static final String dfa_24s = "\1\15\172\uffff";
    static final String dfa_25s = "\1\22\1\4\5\6\6\4\1\uffff\11\4\6\6\1\0\1\6\2\0\1\6\1\0\1\6\67\0\11\4\7\6\1\uffff\3\6\1\0\1\6\2\0\1\6\1\0\3\6\1\0\1\6\1\0";
    static final String dfa_26s = "\1\37\14\21\1\uffff\11\23\1\21\1\6\2\21\1\6\1\21\1\0\1\6\2\0\1\6\1\0\1\6\67\0\11\23\2\21\1\6\2\21\1\6\1\21\1\uffff\1\21\1\6\1\21\1\0\1\6\2\0\1\6\1\0\1\21\1\6\1\21\1\0\1\6\1\0";
    static final String dfa_27s = "\15\uffff\1\2\135\uffff\1\1\17\uffff";
    static final String dfa_28s = "\35\uffff\1\14\1\uffff\1\21\1\3\1\uffff\1\10\1\uffff\1\57\1\41\1\51\1\63\1\74\1\75\1\6\1\20\1\31\1\32\1\70\1\1\1\15\1\26\1\27\1\37\1\47\1\56\1\61\1\23\1\34\1\44\1\53\1\54\1\66\1\77\1\11\1\12\1\50\1\62\1\72\1\4\1\5\1\16\1\30\1\40\1\42\1\0\1\13\1\25\1\35\1\36\1\46\1\55\1\67\1\71\1\33\1\43\1\52\1\64\1\65\1\76\1\7\1\22\1\24\24\uffff\1\60\1\uffff\1\45\1\17\1\uffff\1\2\3\uffff\1\73\1\uffff\1\100}>";
    static final String[] dfa_29s = {
            "\1\1\1\uffff\1\2\1\3\1\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14",
            "\1\16\1\17\1\20\5\uffff\1\21\1\22\1\23\1\24\1\25\1\26",
            "\1\31\1\27\11\uffff\1\30",
            "\1\34\1\32\11\uffff\1\33",
            "\1\37\1\35\11\uffff\1\36",
            "\1\42\1\40\11\uffff\1\41",
            "\1\44\12\uffff\1\43",
            "\1\45\1\46\1\47\5\uffff\1\50\1\51\1\52\1\53\1\54\1\55",
            "\1\56\1\57\1\60\5\uffff\1\61\1\62\1\63\1\64\1\65\1\66",
            "\1\67\1\70\1\71\5\uffff\1\72\1\73\1\74\1\75\1\76\1\77",
            "\1\100\1\101\1\102\5\uffff\1\103\1\104\1\105\1\106\1\107\1\110",
            "\1\111\1\112\1\113\5\uffff\1\114\1\115\1\116\1\117\1\120\1\121",
            "\1\122\1\123\1\124\5\uffff\1\125\1\126\1\127\1\130\1\131\1\132",
            "",
            "\1\133\1\134\1\135\5\uffff\1\136\1\137\1\140\1\141\1\142\1\143\1\uffff\1\144",
            "\1\133\1\134\1\135\5\uffff\1\136\1\137\1\140\1\141\1\142\1\143\1\uffff\1\144",
            "\1\133\1\134\1\135\5\uffff\1\136\1\137\1\140\1\141\1\142\1\143\1\uffff\1\144",
            "\1\133\1\134\1\135\5\uffff\1\136\1\137\1\140\1\141\1\142\1\143\1\uffff\1\144",
            "\1\133\1\134\1\135\5\uffff\1\136\1\137\1\140\1\141\1\142\1\143\1\uffff\1\144",
            "\1\133\1\134\1\135\5\uffff\1\136\1\137\1\140\1\141\1\142\1\143\1\uffff\1\144",
            "\1\133\1\134\1\135\5\uffff\1\136\1\137\1\140\1\141\1\142\1\143\1\uffff\1\144",
            "\1\133\1\134\1\135\5\uffff\1\136\1\137\1\140\1\141\1\142\1\143\1\uffff\1\144",
            "\1\133\1\134\1\135\5\uffff\1\136\1\137\1\140\1\141\1\142\1\143\1\uffff\1\144",
            "\1\147\1\145\11\uffff\1\146",
            "\1\31",
            "\1\147\1\145\11\uffff\1\146",
            "\1\152\1\150\11\uffff\1\151",
            "\1\34",
            "\1\152\1\150\11\uffff\1\151",
            "\1\uffff",
            "\1\37",
            "\1\uffff",
            "\1\uffff",
            "\1\42",
            "\1\uffff",
            "\1\44",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\133\1\134\1\135\5\uffff\1\136\1\137\1\140\1\141\1\142\1\143\1\uffff\1\144",
            "\1\133\1\134\1\135\5\uffff\1\136\1\137\1\140\1\141\1\142\1\143\1\uffff\1\144",
            "\1\133\1\134\1\135\5\uffff\1\136\1\137\1\140\1\141\1\142\1\143\1\uffff\1\144",
            "\1\133\1\134\1\135\5\uffff\1\136\1\137\1\140\1\141\1\142\1\143\1\uffff\1\144",
            "\1\133\1\134\1\135\5\uffff\1\136\1\137\1\140\1\141\1\142\1\143\1\uffff\1\144",
            "\1\133\1\134\1\135\5\uffff\1\136\1\137\1\140\1\141\1\142\1\143\1\uffff\1\144",
            "\1\133\1\134\1\135\5\uffff\1\136\1\137\1\140\1\141\1\142\1\143\1\uffff\1\144",
            "\1\133\1\134\1\135\5\uffff\1\136\1\137\1\140\1\141\1\142\1\143\1\uffff\1\144",
            "\1\133\1\134\1\135\5\uffff\1\136\1\137\1\140\1\141\1\142\1\143\1\uffff\1\144",
            "\1\156\1\154\11\uffff\1\155",
            "\1\161\1\157\11\uffff\1\160",
            "\1\147",
            "\1\161\1\157\11\uffff\1\160",
            "\1\164\1\162\11\uffff\1\163",
            "\1\152",
            "\1\164\1\162\11\uffff\1\163",
            "",
            "\1\167\1\165\11\uffff\1\166",
            "\1\156",
            "\1\167\1\165\11\uffff\1\166",
            "\1\uffff",
            "\1\161",
            "\1\uffff",
            "\1\uffff",
            "\1\164",
            "\1\uffff",
            "\1\172\1\170\11\uffff\1\171",
            "\1\167",
            "\1\172\1\170\11\uffff\1\171",
            "\1\uffff",
            "\1\172",
            "\1\uffff"
    };

    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final char[] dfa_25 = DFA.unpackEncodedStringToUnsignedChars(dfa_25s);
    static final char[] dfa_26 = DFA.unpackEncodedStringToUnsignedChars(dfa_26s);
    static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
    static final short[] dfa_28 = DFA.unpackEncodedString(dfa_28s);
    static final short[][] dfa_29 = unpackEncodedStringArray(dfa_29s);

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = dfa_23;
            this.eof = dfa_24;
            this.min = dfa_25;
            this.max = dfa_26;
            this.accept = dfa_27;
            this.special = dfa_28;
            this.transition = dfa_29;
        }
        public String getDescription() {
            return "2201:2: ( rule__TexturedMaterial__UnorderedGroup__1 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA17_73 = input.LA(1);

                         
                        int index17_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_73);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA17_47 = input.LA(1);

                         
                        int index17_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_47);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA17_116 = input.LA(1);

                         
                        int index17_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 2) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_116);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA17_32 = input.LA(1);

                         
                        int index17_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_32);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA17_67 = input.LA(1);

                         
                        int index17_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_67);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA17_68 = input.LA(1);

                         
                        int index17_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_68);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA17_42 = input.LA(1);

                         
                        int index17_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_42);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA17_88 = input.LA(1);

                         
                        int index17_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_88);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA17_34 = input.LA(1);

                         
                        int index17_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_34);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA17_62 = input.LA(1);

                         
                        int index17_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_62);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA17_63 = input.LA(1);

                         
                        int index17_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_63);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA17_74 = input.LA(1);

                         
                        int index17_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_74);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA17_29 = input.LA(1);

                         
                        int index17_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_29);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA17_48 = input.LA(1);

                         
                        int index17_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_48);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA17_69 = input.LA(1);

                         
                        int index17_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_69);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA17_114 = input.LA(1);

                         
                        int index17_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 2) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_114);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA17_43 = input.LA(1);

                         
                        int index17_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_43);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA17_31 = input.LA(1);

                         
                        int index17_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_31);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA17_89 = input.LA(1);

                         
                        int index17_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_89);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA17_55 = input.LA(1);

                         
                        int index17_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_55);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA17_90 = input.LA(1);

                         
                        int index17_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_90);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA17_75 = input.LA(1);

                         
                        int index17_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_75);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA17_49 = input.LA(1);

                         
                        int index17_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_49);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA17_50 = input.LA(1);

                         
                        int index17_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_50);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA17_70 = input.LA(1);

                         
                        int index17_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_70);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA17_44 = input.LA(1);

                         
                        int index17_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_44);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA17_45 = input.LA(1);

                         
                        int index17_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_45);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA17_82 = input.LA(1);

                         
                        int index17_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_82);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA17_56 = input.LA(1);

                         
                        int index17_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_56);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA17_76 = input.LA(1);

                         
                        int index17_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_76);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA17_77 = input.LA(1);

                         
                        int index17_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_77);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA17_51 = input.LA(1);

                         
                        int index17_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_51);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA17_71 = input.LA(1);

                         
                        int index17_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_71);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA17_37 = input.LA(1);

                         
                        int index17_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_37);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA17_72 = input.LA(1);

                         
                        int index17_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_72);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA17_83 = input.LA(1);

                         
                        int index17_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_83);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA17_57 = input.LA(1);

                         
                        int index17_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_57);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA17_113 = input.LA(1);

                         
                        int index17_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 1) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_113);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA17_78 = input.LA(1);

                         
                        int index17_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_78);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA17_52 = input.LA(1);

                         
                        int index17_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_52);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA17_64 = input.LA(1);

                         
                        int index17_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_64);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA17_38 = input.LA(1);

                         
                        int index17_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_38);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA17_84 = input.LA(1);

                         
                        int index17_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_84);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA17_58 = input.LA(1);

                         
                        int index17_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_58);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA17_59 = input.LA(1);

                         
                        int index17_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_59);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA17_79 = input.LA(1);

                         
                        int index17_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_79);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA17_53 = input.LA(1);

                         
                        int index17_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_53);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA17_36 = input.LA(1);

                         
                        int index17_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 4) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_36);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA17_111 = input.LA(1);

                         
                        int index17_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 1) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_111);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA17_54 = input.LA(1);

                         
                        int index17_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_54);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA17_65 = input.LA(1);

                         
                        int index17_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_65);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA17_39 = input.LA(1);

                         
                        int index17_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_39);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA17_85 = input.LA(1);

                         
                        int index17_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_85);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA17_86 = input.LA(1);

                         
                        int index17_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_86);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA17_60 = input.LA(1);

                         
                        int index17_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_60);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA17_80 = input.LA(1);

                         
                        int index17_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_80);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA17_46 = input.LA(1);

                         
                        int index17_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_46);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA17_81 = input.LA(1);

                         
                        int index17_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_81);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA17_66 = input.LA(1);

                         
                        int index17_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_66);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA17_120 = input.LA(1);

                         
                        int index17_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 0) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_120);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA17_40 = input.LA(1);

                         
                        int index17_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_40);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA17_41 = input.LA(1);

                         
                        int index17_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_41);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA17_87 = input.LA(1);

                         
                        int index17_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_87);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA17_61 = input.LA(1);

                         
                        int index17_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_61);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA17_122 = input.LA(1);

                         
                        int index17_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 0) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index17_122);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 17, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_30s = "\35\uffff\1\45\1\uffff\1\54\1\34\1\uffff\1\42\1\uffff\1\0\1\77\1\1\1\12\1\21\1\35\1\36\1\50\1\60\1\70\1\26\1\31\1\44\1\56\1\65\1\66\1\76\1\7\1\17\1\61\1\63\1\73\1\4\1\14\1\15\1\25\1\40\1\53\1\10\1\11\1\20\1\32\1\46\1\47\1\57\1\67\1\100\1\41\1\43\1\55\1\64\1\74\1\75\1\6\1\16\1\27\1\71\1\72\1\3\1\13\1\22\1\24\1\37\1\51\1\62\24\uffff\1\2\1\uffff\1\5\1\52\1\uffff\1\33\3\uffff\1\23\1\uffff\1\30}>";
    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = dfa_23;
            this.eof = dfa_24;
            this.min = dfa_25;
            this.max = dfa_26;
            this.accept = dfa_27;
            this.special = dfa_30;
            this.transition = dfa_29;
        }
        public String getDescription() {
            return "2213:2: ( rule__TexturedMaterial__UnorderedGroup__2 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA18_36 = input.LA(1);

                         
                        int index18_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 4) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_36);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA18_38 = input.LA(1);

                         
                        int index18_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_38);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA18_111 = input.LA(1);

                         
                        int index18_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 1) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_111);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA18_84 = input.LA(1);

                         
                        int index18_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_84);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA18_58 = input.LA(1);

                         
                        int index18_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_58);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA18_113 = input.LA(1);

                         
                        int index18_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 1) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_113);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA18_79 = input.LA(1);

                         
                        int index18_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_79);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA18_53 = input.LA(1);

                         
                        int index18_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_53);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA18_64 = input.LA(1);

                         
                        int index18_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_64);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA18_65 = input.LA(1);

                         
                        int index18_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_65);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA18_39 = input.LA(1);

                         
                        int index18_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_39);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA18_85 = input.LA(1);

                         
                        int index18_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_85);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA18_59 = input.LA(1);

                         
                        int index18_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_59);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA18_60 = input.LA(1);

                         
                        int index18_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_60);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA18_80 = input.LA(1);

                         
                        int index18_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_80);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA18_54 = input.LA(1);

                         
                        int index18_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_54);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA18_66 = input.LA(1);

                         
                        int index18_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_66);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA18_40 = input.LA(1);

                         
                        int index18_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_40);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA18_86 = input.LA(1);

                         
                        int index18_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_86);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA18_120 = input.LA(1);

                         
                        int index18_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 0) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_120);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA18_87 = input.LA(1);

                         
                        int index18_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_87);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA18_61 = input.LA(1);

                         
                        int index18_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_61);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA18_46 = input.LA(1);

                         
                        int index18_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_46);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA18_81 = input.LA(1);

                         
                        int index18_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_81);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA18_122 = input.LA(1);

                         
                        int index18_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 0) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_122);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA18_47 = input.LA(1);

                         
                        int index18_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_47);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA18_67 = input.LA(1);

                         
                        int index18_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_67);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA18_116 = input.LA(1);

                         
                        int index18_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 2) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_116);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA18_32 = input.LA(1);

                         
                        int index18_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_32);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA18_41 = input.LA(1);

                         
                        int index18_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_41);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA18_42 = input.LA(1);

                         
                        int index18_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_42);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA18_88 = input.LA(1);

                         
                        int index18_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_88);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA18_62 = input.LA(1);

                         
                        int index18_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_62);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA18_73 = input.LA(1);

                         
                        int index18_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_73);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA18_34 = input.LA(1);

                         
                        int index18_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_34);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA18_74 = input.LA(1);

                         
                        int index18_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_74);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA18_48 = input.LA(1);

                         
                        int index18_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_48);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA18_29 = input.LA(1);

                         
                        int index18_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_29);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA18_68 = input.LA(1);

                         
                        int index18_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_68);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA18_69 = input.LA(1);

                         
                        int index18_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_69);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA18_43 = input.LA(1);

                         
                        int index18_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_43);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA18_89 = input.LA(1);

                         
                        int index18_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_89);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA18_114 = input.LA(1);

                         
                        int index18_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 2) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_114);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA18_63 = input.LA(1);

                         
                        int index18_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_63);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA18_31 = input.LA(1);

                         
                        int index18_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_31);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA18_75 = input.LA(1);

                         
                        int index18_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_75);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA18_49 = input.LA(1);

                         
                        int index18_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_49);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA18_70 = input.LA(1);

                         
                        int index18_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_70);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA18_44 = input.LA(1);

                         
                        int index18_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_44);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA18_55 = input.LA(1);

                         
                        int index18_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_55);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA18_90 = input.LA(1);

                         
                        int index18_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_90);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA18_56 = input.LA(1);

                         
                        int index18_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_56);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA18_76 = input.LA(1);

                         
                        int index18_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_76);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA18_50 = input.LA(1);

                         
                        int index18_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_50);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA18_51 = input.LA(1);

                         
                        int index18_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_51);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA18_71 = input.LA(1);

                         
                        int index18_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_71);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA18_45 = input.LA(1);

                         
                        int index18_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_45);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA18_82 = input.LA(1);

                         
                        int index18_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_82);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA18_83 = input.LA(1);

                         
                        int index18_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_83);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA18_57 = input.LA(1);

                         
                        int index18_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_57);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA18_77 = input.LA(1);

                         
                        int index18_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_77);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA18_78 = input.LA(1);

                         
                        int index18_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_78);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA18_52 = input.LA(1);

                         
                        int index18_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_52);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA18_37 = input.LA(1);

                         
                        int index18_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_37);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA18_72 = input.LA(1);

                         
                        int index18_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index18_72);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 18, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_31s = "\35\uffff\1\0\1\uffff\1\6\1\72\1\uffff\1\76\1\uffff\1\45\1\27\1\41\1\53\1\54\1\64\1\77\1\10\1\12\1\22\1\57\1\74\1\3\1\4\1\16\1\26\1\36\1\37\1\51\1\13\1\24\1\33\1\34\1\44\1\56\1\67\1\70\1\1\1\40\1\52\1\62\1\63\1\75\1\7\1\20\1\21\1\30\1\73\1\2\1\14\1\15\1\25\1\35\1\47\1\50\1\60\1\23\1\31\1\42\1\43\1\55\1\66\1\100\1\11\1\17\24\uffff\1\46\1\uffff\1\32\1\5\1\uffff\1\71\3\uffff\1\61\1\uffff\1\65}>";
    static final short[] dfa_31 = DFA.unpackEncodedString(dfa_31s);

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = dfa_23;
            this.eof = dfa_24;
            this.min = dfa_25;
            this.max = dfa_26;
            this.accept = dfa_27;
            this.special = dfa_31;
            this.transition = dfa_29;
        }
        public String getDescription() {
            return "2225:2: ( rule__TexturedMaterial__UnorderedGroup__3 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA19_29 = input.LA(1);

                         
                        int index19_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_29);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA19_63 = input.LA(1);

                         
                        int index19_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_63);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA19_74 = input.LA(1);

                         
                        int index19_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_74);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA19_48 = input.LA(1);

                         
                        int index19_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_48);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA19_49 = input.LA(1);

                         
                        int index19_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_49);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA19_114 = input.LA(1);

                         
                        int index19_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 2) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_114);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA19_31 = input.LA(1);

                         
                        int index19_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_31);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA19_69 = input.LA(1);

                         
                        int index19_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_69);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA19_43 = input.LA(1);

                         
                        int index19_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_43);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA19_89 = input.LA(1);

                         
                        int index19_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_89);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA19_44 = input.LA(1);

                         
                        int index19_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_44);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA19_55 = input.LA(1);

                         
                        int index19_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_55);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA19_75 = input.LA(1);

                         
                        int index19_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_75);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA19_76 = input.LA(1);

                         
                        int index19_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_76);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA19_50 = input.LA(1);

                         
                        int index19_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_50);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA19_90 = input.LA(1);

                         
                        int index19_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_90);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA19_70 = input.LA(1);

                         
                        int index19_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_70);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA19_71 = input.LA(1);

                         
                        int index19_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_71);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA19_45 = input.LA(1);

                         
                        int index19_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_45);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA19_82 = input.LA(1);

                         
                        int index19_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_82);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA19_56 = input.LA(1);

                         
                        int index19_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_56);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA19_77 = input.LA(1);

                         
                        int index19_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_77);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA19_51 = input.LA(1);

                         
                        int index19_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_51);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA19_37 = input.LA(1);

                         
                        int index19_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_37);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA19_72 = input.LA(1);

                         
                        int index19_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_72);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA19_83 = input.LA(1);

                         
                        int index19_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_83);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA19_113 = input.LA(1);

                         
                        int index19_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 1) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_113);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA19_57 = input.LA(1);

                         
                        int index19_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_57);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA19_58 = input.LA(1);

                         
                        int index19_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_58);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA19_78 = input.LA(1);

                         
                        int index19_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_78);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA19_52 = input.LA(1);

                         
                        int index19_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_52);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA19_53 = input.LA(1);

                         
                        int index19_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_53);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA19_64 = input.LA(1);

                         
                        int index19_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_64);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA19_38 = input.LA(1);

                         
                        int index19_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_38);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA19_84 = input.LA(1);

                         
                        int index19_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_84);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA19_85 = input.LA(1);

                         
                        int index19_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_85);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA19_59 = input.LA(1);

                         
                        int index19_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_59);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA19_36 = input.LA(1);

                         
                        int index19_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 4) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_36);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA19_111 = input.LA(1);

                         
                        int index19_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 1) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_111);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA19_79 = input.LA(1);

                         
                        int index19_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_79);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA19_80 = input.LA(1);

                         
                        int index19_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_80);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA19_54 = input.LA(1);

                         
                        int index19_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_54);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA19_65 = input.LA(1);

                         
                        int index19_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_65);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA19_39 = input.LA(1);

                         
                        int index19_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_39);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA19_40 = input.LA(1);

                         
                        int index19_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_40);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA19_86 = input.LA(1);

                         
                        int index19_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_86);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA19_60 = input.LA(1);

                         
                        int index19_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_60);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA19_46 = input.LA(1);

                         
                        int index19_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_46);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA19_81 = input.LA(1);

                         
                        int index19_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_81);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA19_120 = input.LA(1);

                         
                        int index19_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 0) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_120);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA19_66 = input.LA(1);

                         
                        int index19_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_66);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA19_67 = input.LA(1);

                         
                        int index19_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_67);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA19_41 = input.LA(1);

                         
                        int index19_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_41);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA19_122 = input.LA(1);

                         
                        int index19_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 0) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_122);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA19_87 = input.LA(1);

                         
                        int index19_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_87);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA19_61 = input.LA(1);

                         
                        int index19_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_61);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA19_62 = input.LA(1);

                         
                        int index19_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_62);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA19_116 = input.LA(1);

                         
                        int index19_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 2) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_116);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA19_32 = input.LA(1);

                         
                        int index19_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_32);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA19_73 = input.LA(1);

                         
                        int index19_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_73);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA19_47 = input.LA(1);

                         
                        int index19_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_47);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA19_68 = input.LA(1);

                         
                        int index19_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_68);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA19_34 = input.LA(1);

                         
                        int index19_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_34);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA19_42 = input.LA(1);

                         
                        int index19_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_42);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA19_88 = input.LA(1);

                         
                        int index19_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index19_88);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 19, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_32s = "\35\uffff\1\60\1\uffff\1\42\1\47\1\uffff\1\30\1\uffff\1\1\1\73\1\0\1\17\1\26\1\40\1\50\1\46\1\56\1\65\1\21\1\31\1\52\1\62\1\70\1\76\1\75\1\4\1\13\1\54\1\64\1\100\1\10\1\15\1\24\1\23\1\33\1\44\1\3\1\12\1\27\1\41\1\51\1\61\1\57\1\67\1\74\1\32\1\43\1\63\1\71\1\77\1\6\1\5\1\14\1\22\1\66\1\72\1\11\1\16\1\25\1\37\1\35\1\45\1\55\24\uffff\1\2\1\uffff\1\7\1\53\1\uffff\1\34\3\uffff\1\36\1\uffff\1\20}>";
    static final short[] dfa_32 = DFA.unpackEncodedString(dfa_32s);

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = dfa_23;
            this.eof = dfa_24;
            this.min = dfa_25;
            this.max = dfa_26;
            this.accept = dfa_27;
            this.special = dfa_32;
            this.transition = dfa_29;
        }
        public String getDescription() {
            return "2237:2: ( rule__TexturedMaterial__UnorderedGroup__4 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA20_38 = input.LA(1);

                         
                        int index20_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_38);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA20_36 = input.LA(1);

                         
                        int index20_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 4) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_36);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA20_111 = input.LA(1);

                         
                        int index20_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 1) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_111);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA20_64 = input.LA(1);

                         
                        int index20_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_64);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA20_53 = input.LA(1);

                         
                        int index20_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_53);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA20_79 = input.LA(1);

                         
                        int index20_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_79);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA20_78 = input.LA(1);

                         
                        int index20_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_78);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA20_113 = input.LA(1);

                         
                        int index20_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 1) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_113);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA20_58 = input.LA(1);

                         
                        int index20_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_58);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA20_84 = input.LA(1);

                         
                        int index20_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_84);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA20_65 = input.LA(1);

                         
                        int index20_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_65);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA20_54 = input.LA(1);

                         
                        int index20_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_54);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA20_80 = input.LA(1);

                         
                        int index20_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_80);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA20_59 = input.LA(1);

                         
                        int index20_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_59);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA20_85 = input.LA(1);

                         
                        int index20_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_85);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA20_39 = input.LA(1);

                         
                        int index20_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_39);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA20_122 = input.LA(1);

                         
                        int index20_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 0) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_122);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA20_46 = input.LA(1);

                         
                        int index20_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_46);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA20_81 = input.LA(1);

                         
                        int index20_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_81);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA20_61 = input.LA(1);

                         
                        int index20_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_61);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA20_60 = input.LA(1);

                         
                        int index20_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_60);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA20_86 = input.LA(1);

                         
                        int index20_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_86);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA20_40 = input.LA(1);

                         
                        int index20_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_40);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA20_66 = input.LA(1);

                         
                        int index20_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_66);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA20_34 = input.LA(1);

                         
                        int index20_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_34);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA20_47 = input.LA(1);

                         
                        int index20_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_47);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA20_73 = input.LA(1);

                         
                        int index20_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_73);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA20_62 = input.LA(1);

                         
                        int index20_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_62);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA20_116 = input.LA(1);

                         
                        int index20_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 2) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_116);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA20_88 = input.LA(1);

                         
                        int index20_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_88);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA20_120 = input.LA(1);

                         
                        int index20_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 0) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_120);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA20_87 = input.LA(1);

                         
                        int index20_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_87);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA20_41 = input.LA(1);

                         
                        int index20_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_41);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA20_67 = input.LA(1);

                         
                        int index20_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_67);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA20_31 = input.LA(1);

                         
                        int index20_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_31);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA20_74 = input.LA(1);

                         
                        int index20_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_74);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA20_63 = input.LA(1);

                         
                        int index20_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_63);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA20_89 = input.LA(1);

                         
                        int index20_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_89);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA20_43 = input.LA(1);

                         
                        int index20_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_43);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA20_32 = input.LA(1);

                         
                        int index20_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_32);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA20_42 = input.LA(1);

                         
                        int index20_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_42);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA20_68 = input.LA(1);

                         
                        int index20_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_68);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA20_48 = input.LA(1);

                         
                        int index20_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_48);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA20_114 = input.LA(1);

                         
                        int index20_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 2) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_114);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA20_55 = input.LA(1);

                         
                        int index20_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_55);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA20_90 = input.LA(1);

                         
                        int index20_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_90);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA20_44 = input.LA(1);

                         
                        int index20_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_44);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA20_70 = input.LA(1);

                         
                        int index20_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_70);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA20_29 = input.LA(1);

                         
                        int index20_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_29);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA20_69 = input.LA(1);

                         
                        int index20_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_69);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA20_49 = input.LA(1);

                         
                        int index20_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_49);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA20_75 = input.LA(1);

                         
                        int index20_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_75);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA20_56 = input.LA(1);

                         
                        int index20_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_56);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA20_45 = input.LA(1);

                         
                        int index20_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_45);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA20_82 = input.LA(1);

                         
                        int index20_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_82);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA20_71 = input.LA(1);

                         
                        int index20_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_71);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA20_50 = input.LA(1);

                         
                        int index20_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_50);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA20_76 = input.LA(1);

                         
                        int index20_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_76);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA20_83 = input.LA(1);

                         
                        int index20_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_83);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA20_37 = input.LA(1);

                         
                        int index20_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_37);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA20_72 = input.LA(1);

                         
                        int index20_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_72);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA20_52 = input.LA(1);

                         
                        int index20_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_52);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA20_51 = input.LA(1);

                         
                        int index20_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_51);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA20_77 = input.LA(1);

                         
                        int index20_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_77);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA20_57 = input.LA(1);

                         
                        int index20_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index20_57);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 20, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_33s = "\35\uffff\1\30\1\uffff\1\12\1\17\1\uffff\1\0\1\uffff\1\52\1\43\1\51\1\70\1\77\1\10\1\20\1\16\1\26\1\35\1\72\1\1\1\22\1\32\1\40\1\46\1\45\1\55\1\64\1\24\1\34\1\50\1\61\1\66\1\75\1\74\1\3\1\14\1\54\1\63\1\100\1\11\1\21\1\31\1\27\1\37\1\44\1\2\1\13\1\33\1\41\1\47\1\57\1\56\1\65\1\73\1\36\1\42\1\62\1\67\1\76\1\7\1\5\1\15\1\25\24\uffff\1\53\1\uffff\1\60\1\23\1\uffff\1\4\3\uffff\1\6\1\uffff\1\71}>";
    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = dfa_23;
            this.eof = dfa_24;
            this.min = dfa_25;
            this.max = dfa_26;
            this.accept = dfa_27;
            this.special = dfa_33;
            this.transition = dfa_29;
        }
        public String getDescription() {
            return "2249:2: ( rule__TexturedMaterial__UnorderedGroup__5 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA21_34 = input.LA(1);

                         
                        int index21_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_34);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA21_47 = input.LA(1);

                         
                        int index21_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_47);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA21_73 = input.LA(1);

                         
                        int index21_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_73);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA21_62 = input.LA(1);

                         
                        int index21_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_62);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA21_116 = input.LA(1);

                         
                        int index21_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 2) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_116);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA21_88 = input.LA(1);

                         
                        int index21_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_88);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA21_120 = input.LA(1);

                         
                        int index21_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 0) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_120);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA21_87 = input.LA(1);

                         
                        int index21_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_87);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA21_41 = input.LA(1);

                         
                        int index21_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_41);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA21_67 = input.LA(1);

                         
                        int index21_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_67);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA21_31 = input.LA(1);

                         
                        int index21_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_31);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA21_74 = input.LA(1);

                         
                        int index21_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_74);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA21_63 = input.LA(1);

                         
                        int index21_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_63);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA21_89 = input.LA(1);

                         
                        int index21_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_89);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA21_43 = input.LA(1);

                         
                        int index21_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_43);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA21_32 = input.LA(1);

                         
                        int index21_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_32);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA21_42 = input.LA(1);

                         
                        int index21_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_42);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA21_68 = input.LA(1);

                         
                        int index21_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_68);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA21_48 = input.LA(1);

                         
                        int index21_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_48);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA21_114 = input.LA(1);

                         
                        int index21_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 2) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_114);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA21_55 = input.LA(1);

                         
                        int index21_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_55);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA21_90 = input.LA(1);

                         
                        int index21_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_90);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA21_44 = input.LA(1);

                         
                        int index21_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_44);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA21_70 = input.LA(1);

                         
                        int index21_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_70);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA21_29 = input.LA(1);

                         
                        int index21_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_29);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA21_69 = input.LA(1);

                         
                        int index21_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_69);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA21_49 = input.LA(1);

                         
                        int index21_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_49);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA21_75 = input.LA(1);

                         
                        int index21_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_75);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA21_56 = input.LA(1);

                         
                        int index21_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_56);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA21_45 = input.LA(1);

                         
                        int index21_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_45);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA21_82 = input.LA(1);

                         
                        int index21_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_82);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA21_71 = input.LA(1);

                         
                        int index21_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_71);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA21_50 = input.LA(1);

                         
                        int index21_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_50);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA21_76 = input.LA(1);

                         
                        int index21_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_76);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA21_83 = input.LA(1);

                         
                        int index21_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_83);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA21_37 = input.LA(1);

                         
                        int index21_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_37);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA21_72 = input.LA(1);

                         
                        int index21_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_72);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA21_52 = input.LA(1);

                         
                        int index21_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_52);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA21_51 = input.LA(1);

                         
                        int index21_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_51);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA21_77 = input.LA(1);

                         
                        int index21_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_77);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA21_57 = input.LA(1);

                         
                        int index21_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_57);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA21_38 = input.LA(1);

                         
                        int index21_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_38);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA21_36 = input.LA(1);

                         
                        int index21_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 4) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_36);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA21_111 = input.LA(1);

                         
                        int index21_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 1) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_111);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA21_64 = input.LA(1);

                         
                        int index21_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_64);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA21_53 = input.LA(1);

                         
                        int index21_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_53);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA21_79 = input.LA(1);

                         
                        int index21_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_79);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA21_78 = input.LA(1);

                         
                        int index21_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_78);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA21_113 = input.LA(1);

                         
                        int index21_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 1) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_113);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA21_58 = input.LA(1);

                         
                        int index21_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_58);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA21_84 = input.LA(1);

                         
                        int index21_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_84);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA21_65 = input.LA(1);

                         
                        int index21_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_65);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA21_54 = input.LA(1);

                         
                        int index21_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_54);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA21_80 = input.LA(1);

                         
                        int index21_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_80);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA21_59 = input.LA(1);

                         
                        int index21_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_59);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA21_85 = input.LA(1);

                         
                        int index21_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_85);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA21_39 = input.LA(1);

                         
                        int index21_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_39);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA21_122 = input.LA(1);

                         
                        int index21_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 0) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_122);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA21_46 = input.LA(1);

                         
                        int index21_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_46);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA21_81 = input.LA(1);

                         
                        int index21_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_81);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA21_61 = input.LA(1);

                         
                        int index21_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_61);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA21_60 = input.LA(1);

                         
                        int index21_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_60);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA21_86 = input.LA(1);

                         
                        int index21_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_86);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA21_40 = input.LA(1);

                         
                        int index21_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_40);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA21_66 = input.LA(1);

                         
                        int index21_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index21_66);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 21, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_34s = "\35\uffff\1\70\1\uffff\1\75\1\60\1\uffff\1\63\1\uffff\1\32\1\23\1\31\1\41\1\40\1\50\1\61\1\67\1\6\1\12\1\54\1\64\1\73\1\72\1\1\1\7\1\15\1\35\1\43\1\4\1\11\1\21\1\20\1\26\1\36\1\45\1\66\1\77\1\34\1\42\1\52\1\51\1\62\1\71\1\0\1\14\1\24\1\65\1\76\1\3\1\2\1\10\1\16\1\25\1\44\1\55\1\13\1\22\1\30\1\27\1\37\1\47\1\57\1\100\1\5\24\uffff\1\33\1\uffff\1\17\1\74\1\uffff\1\56\3\uffff\1\46\1\uffff\1\53}>";
    static final short[] dfa_34 = DFA.unpackEncodedString(dfa_34s);

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = dfa_23;
            this.eof = dfa_24;
            this.min = dfa_25;
            this.max = dfa_26;
            this.accept = dfa_27;
            this.special = dfa_34;
            this.transition = dfa_29;
        }
        public String getDescription() {
            return "2261:2: ( rule__TexturedMaterial__UnorderedGroup__6 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA22_70 = input.LA(1);

                         
                        int index22_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_70);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA22_50 = input.LA(1);

                         
                        int index22_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_50);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA22_76 = input.LA(1);

                         
                        int index22_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_76);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA22_75 = input.LA(1);

                         
                        int index22_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_75);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA22_55 = input.LA(1);

                         
                        int index22_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_55);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA22_90 = input.LA(1);

                         
                        int index22_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_90);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA22_44 = input.LA(1);

                         
                        int index22_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_44);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA22_51 = input.LA(1);

                         
                        int index22_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_51);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA22_77 = input.LA(1);

                         
                        int index22_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_77);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA22_56 = input.LA(1);

                         
                        int index22_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_56);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA22_45 = input.LA(1);

                         
                        int index22_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_45);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA22_82 = input.LA(1);

                         
                        int index22_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_82);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA22_71 = input.LA(1);

                         
                        int index22_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_71);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA22_52 = input.LA(1);

                         
                        int index22_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_52);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA22_78 = input.LA(1);

                         
                        int index22_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_78);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA22_113 = input.LA(1);

                         
                        int index22_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 1) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_113);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA22_58 = input.LA(1);

                         
                        int index22_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_58);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA22_57 = input.LA(1);

                         
                        int index22_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_57);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA22_83 = input.LA(1);

                         
                        int index22_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_83);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA22_37 = input.LA(1);

                         
                        int index22_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_37);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA22_72 = input.LA(1);

                         
                        int index22_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_72);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA22_79 = input.LA(1);

                         
                        int index22_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_79);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA22_59 = input.LA(1);

                         
                        int index22_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_59);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA22_85 = input.LA(1);

                         
                        int index22_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_85);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA22_84 = input.LA(1);

                         
                        int index22_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_84);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA22_38 = input.LA(1);

                         
                        int index22_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_38);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA22_36 = input.LA(1);

                         
                        int index22_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 4) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_36);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA22_111 = input.LA(1);

                         
                        int index22_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 1) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_111);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA22_64 = input.LA(1);

                         
                        int index22_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_64);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA22_53 = input.LA(1);

                         
                        int index22_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_53);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA22_60 = input.LA(1);

                         
                        int index22_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_60);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA22_86 = input.LA(1);

                         
                        int index22_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_86);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA22_40 = input.LA(1);

                         
                        int index22_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_40);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA22_39 = input.LA(1);

                         
                        int index22_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_39);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA22_65 = input.LA(1);

                         
                        int index22_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_65);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA22_54 = input.LA(1);

                         
                        int index22_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_54);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA22_80 = input.LA(1);

                         
                        int index22_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_80);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA22_61 = input.LA(1);

                         
                        int index22_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_61);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA22_120 = input.LA(1);

                         
                        int index22_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 0) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_120);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA22_87 = input.LA(1);

                         
                        int index22_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_87);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA22_41 = input.LA(1);

                         
                        int index22_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_41);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA22_67 = input.LA(1);

                         
                        int index22_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_67);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA22_66 = input.LA(1);

                         
                        int index22_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_66);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA22_122 = input.LA(1);

                         
                        int index22_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 0) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_122);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA22_46 = input.LA(1);

                         
                        int index22_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_46);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA22_81 = input.LA(1);

                         
                        int index22_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_81);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA22_116 = input.LA(1);

                         
                        int index22_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 2) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_116);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA22_88 = input.LA(1);

                         
                        int index22_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_88);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA22_32 = input.LA(1);

                         
                        int index22_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_32);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA22_42 = input.LA(1);

                         
                        int index22_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_42);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA22_68 = input.LA(1);

                         
                        int index22_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_68);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA22_34 = input.LA(1);

                         
                        int index22_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_34);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA22_47 = input.LA(1);

                         
                        int index22_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_47);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA22_73 = input.LA(1);

                         
                        int index22_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_73);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA22_62 = input.LA(1);

                         
                        int index22_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_62);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA22_43 = input.LA(1);

                         
                        int index22_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_43);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA22_29 = input.LA(1);

                         
                        int index22_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_29);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA22_69 = input.LA(1);

                         
                        int index22_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_69);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA22_49 = input.LA(1);

                         
                        int index22_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_49);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA22_48 = input.LA(1);

                         
                        int index22_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_48);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA22_114 = input.LA(1);

                         
                        int index22_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 2) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_114);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA22_31 = input.LA(1);

                         
                        int index22_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_31);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA22_74 = input.LA(1);

                         
                        int index22_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_74);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA22_63 = input.LA(1);

                         
                        int index22_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_63);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA22_89 = input.LA(1);

                         
                        int index22_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index22_89);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 22, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_35s = "\35\uffff\1\55\1\uffff\1\62\1\44\1\uffff\1\50\1\uffff\1\7\1\0\1\17\1\25\1\35\1\46\1\45\1\54\1\66\1\72\1\27\1\51\1\60\1\70\1\76\1\75\1\2\1\12\1\20\1\64\1\100\1\5\1\15\1\23\1\22\1\31\1\41\1\52\1\11\1\26\1\36\1\47\1\57\1\56\1\67\1\74\1\1\1\40\1\63\1\71\1\77\1\4\1\3\1\13\1\21\1\30\1\73\1\6\1\16\1\24\1\34\1\33\1\43\1\53\1\65\24\uffff\1\10\1\uffff\1\14\1\61\1\uffff\1\42\3\uffff\1\32\1\uffff\1\37}>";
    static final short[] dfa_35 = DFA.unpackEncodedString(dfa_35s);

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = dfa_23;
            this.eof = dfa_24;
            this.min = dfa_25;
            this.max = dfa_26;
            this.accept = dfa_27;
            this.special = dfa_35;
            this.transition = dfa_29;
        }
        public String getDescription() {
            return "2273:2: ( rule__TexturedMaterial__UnorderedGroup__7 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_37 = input.LA(1);

                         
                        int index23_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_37);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA23_72 = input.LA(1);

                         
                        int index23_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_72);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA23_52 = input.LA(1);

                         
                        int index23_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_52);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA23_78 = input.LA(1);

                         
                        int index23_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_78);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA23_77 = input.LA(1);

                         
                        int index23_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_77);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA23_57 = input.LA(1);

                         
                        int index23_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_57);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA23_83 = input.LA(1);

                         
                        int index23_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_83);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA23_36 = input.LA(1);

                         
                        int index23_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 4) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_36);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA23_111 = input.LA(1);

                         
                        int index23_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 1) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_111);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA23_64 = input.LA(1);

                         
                        int index23_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_64);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA23_53 = input.LA(1);

                         
                        int index23_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_53);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA23_79 = input.LA(1);

                         
                        int index23_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_79);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA23_113 = input.LA(1);

                         
                        int index23_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 1) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_113);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA23_58 = input.LA(1);

                         
                        int index23_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_58);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA23_84 = input.LA(1);

                         
                        int index23_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_84);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA23_38 = input.LA(1);

                         
                        int index23_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_38);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA23_54 = input.LA(1);

                         
                        int index23_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_54);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA23_80 = input.LA(1);

                         
                        int index23_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_80);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA23_60 = input.LA(1);

                         
                        int index23_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_60);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA23_59 = input.LA(1);

                         
                        int index23_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_59);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA23_85 = input.LA(1);

                         
                        int index23_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_85);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA23_39 = input.LA(1);

                         
                        int index23_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_39);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA23_65 = input.LA(1);

                         
                        int index23_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_65);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA23_46 = input.LA(1);

                         
                        int index23_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_46);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA23_81 = input.LA(1);

                         
                        int index23_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_81);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA23_61 = input.LA(1);

                         
                        int index23_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_61);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA23_120 = input.LA(1);

                         
                        int index23_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 0) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_120);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA23_87 = input.LA(1);

                         
                        int index23_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_87);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA23_86 = input.LA(1);

                         
                        int index23_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_86);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA23_40 = input.LA(1);

                         
                        int index23_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_40);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA23_66 = input.LA(1);

                         
                        int index23_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_66);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA23_122 = input.LA(1);

                         
                        int index23_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 0) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_122);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA23_73 = input.LA(1);

                         
                        int index23_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_73);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA23_62 = input.LA(1);

                         
                        int index23_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_62);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA23_116 = input.LA(1);

                         
                        int index23_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 2) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_116);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA23_88 = input.LA(1);

                         
                        int index23_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_88);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA23_32 = input.LA(1);

                         
                        int index23_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_32);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA23_42 = input.LA(1);

                         
                        int index23_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_42);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA23_41 = input.LA(1);

                         
                        int index23_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_41);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA23_67 = input.LA(1);

                         
                        int index23_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_67);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA23_34 = input.LA(1);

                         
                        int index23_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_34);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA23_47 = input.LA(1);

                         
                        int index23_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_47);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA23_63 = input.LA(1);

                         
                        int index23_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_63);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA23_89 = input.LA(1);

                         
                        int index23_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_89);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA23_43 = input.LA(1);

                         
                        int index23_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_43);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA23_29 = input.LA(1);

                         
                        int index23_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_29);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA23_69 = input.LA(1);

                         
                        int index23_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_69);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA23_68 = input.LA(1);

                         
                        int index23_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_68);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA23_48 = input.LA(1);

                         
                        int index23_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_48);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA23_114 = input.LA(1);

                         
                        int index23_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 2) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_114);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA23_31 = input.LA(1);

                         
                        int index23_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_31);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA23_74 = input.LA(1);

                         
                        int index23_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_74);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA23_55 = input.LA(1);

                         
                        int index23_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_55);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA23_90 = input.LA(1);

                         
                        int index23_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_90);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA23_44 = input.LA(1);

                         
                        int index23_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_44);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA23_70 = input.LA(1);

                         
                        int index23_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_70);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA23_49 = input.LA(1);

                         
                        int index23_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_49);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA23_75 = input.LA(1);

                         
                        int index23_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_75);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA23_45 = input.LA(1);

                         
                        int index23_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_45);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA23_82 = input.LA(1);

                         
                        int index23_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_82);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA23_71 = input.LA(1);

                         
                        int index23_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_71);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA23_51 = input.LA(1);

                         
                        int index23_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_51);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA23_50 = input.LA(1);

                         
                        int index23_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_50);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA23_76 = input.LA(1);

                         
                        int index23_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_76);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA23_56 = input.LA(1);

                         
                        int index23_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index23_56);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 23, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_36s = "\35\uffff\1\45\1\uffff\1\51\1\34\1\uffff\1\40\1\uffff\1\6\1\77\1\5\1\15\1\24\1\23\1\35\1\44\1\54\1\70\1\27\1\41\1\47\1\57\1\56\1\64\1\72\1\0\1\17\1\61\1\67\1\75\1\3\1\2\1\12\1\20\1\31\1\53\1\10\1\16\1\25\1\37\1\36\1\46\1\55\1\63\1\100\1\42\1\52\1\60\1\66\1\65\1\73\1\1\1\11\1\30\1\71\1\76\1\4\1\14\1\13\1\22\1\33\1\43\1\62\24\uffff\1\7\1\uffff\1\74\1\50\1\uffff\1\32\3\uffff\1\21\1\uffff\1\26}>";
    static final short[] dfa_36 = DFA.unpackEncodedString(dfa_36s);

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = dfa_23;
            this.eof = dfa_24;
            this.min = dfa_25;
            this.max = dfa_26;
            this.accept = dfa_27;
            this.special = dfa_36;
            this.transition = dfa_29;
        }
        public String getDescription() {
            return "2285:2: ( rule__TexturedMaterial__UnorderedGroup__8 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA24_53 = input.LA(1);

                         
                        int index24_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_53);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA24_79 = input.LA(1);

                         
                        int index24_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_79);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA24_59 = input.LA(1);

                         
                        int index24_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_59);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA24_58 = input.LA(1);

                         
                        int index24_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_58);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA24_84 = input.LA(1);

                         
                        int index24_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_84);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA24_38 = input.LA(1);

                         
                        int index24_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_38);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA24_36 = input.LA(1);

                         
                        int index24_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 4) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_36);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA24_111 = input.LA(1);

                         
                        int index24_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 1) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_111);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA24_64 = input.LA(1);

                         
                        int index24_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_64);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA24_80 = input.LA(1);

                         
                        int index24_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_80);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA24_60 = input.LA(1);

                         
                        int index24_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_60);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA24_86 = input.LA(1);

                         
                        int index24_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_86);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA24_85 = input.LA(1);

                         
                        int index24_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_85);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA24_39 = input.LA(1);

                         
                        int index24_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_39);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA24_65 = input.LA(1);

                         
                        int index24_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_65);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA24_54 = input.LA(1);

                         
                        int index24_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_54);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA24_61 = input.LA(1);

                         
                        int index24_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_61);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA24_120 = input.LA(1);

                         
                        int index24_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 0) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_120);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA24_87 = input.LA(1);

                         
                        int index24_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_87);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA24_41 = input.LA(1);

                         
                        int index24_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_41);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA24_40 = input.LA(1);

                         
                        int index24_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_40);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA24_66 = input.LA(1);

                         
                        int index24_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_66);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA24_122 = input.LA(1);

                         
                        int index24_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 0) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_122);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA24_46 = input.LA(1);

                         
                        int index24_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_46);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA24_81 = input.LA(1);

                         
                        int index24_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_81);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA24_62 = input.LA(1);

                         
                        int index24_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_62);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA24_116 = input.LA(1);

                         
                        int index24_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 2) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_116);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA24_88 = input.LA(1);

                         
                        int index24_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_88);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA24_32 = input.LA(1);

                         
                        int index24_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_32);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA24_42 = input.LA(1);

                         
                        int index24_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_42);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA24_68 = input.LA(1);

                         
                        int index24_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_68);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA24_67 = input.LA(1);

                         
                        int index24_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_67);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA24_34 = input.LA(1);

                         
                        int index24_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_34);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA24_47 = input.LA(1);

                         
                        int index24_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_47);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA24_73 = input.LA(1);

                         
                        int index24_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_73);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA24_89 = input.LA(1);

                         
                        int index24_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_89);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA24_43 = input.LA(1);

                         
                        int index24_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_43);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA24_29 = input.LA(1);

                         
                        int index24_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_29);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA24_69 = input.LA(1);

                         
                        int index24_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_69);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA24_48 = input.LA(1);

                         
                        int index24_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_48);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA24_114 = input.LA(1);

                         
                        int index24_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 2) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_114);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA24_31 = input.LA(1);

                         
                        int index24_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_31);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA24_74 = input.LA(1);

                         
                        int index24_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_74);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA24_63 = input.LA(1);

                         
                        int index24_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_63);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA24_44 = input.LA(1);

                         
                        int index24_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_44);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA24_70 = input.LA(1);

                         
                        int index24_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_70);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA24_50 = input.LA(1);

                         
                        int index24_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_50);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA24_49 = input.LA(1);

                         
                        int index24_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_49);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA24_75 = input.LA(1);

                         
                        int index24_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_75);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA24_55 = input.LA(1);

                         
                        int index24_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_55);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA24_90 = input.LA(1);

                         
                        int index24_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_90);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA24_71 = input.LA(1);

                         
                        int index24_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_71);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA24_51 = input.LA(1);

                         
                        int index24_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_51);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA24_77 = input.LA(1);

                         
                        int index24_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_77);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA24_76 = input.LA(1);

                         
                        int index24_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_76);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA24_56 = input.LA(1);

                         
                        int index24_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_56);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA24_45 = input.LA(1);

                         
                        int index24_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_45);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA24_82 = input.LA(1);

                         
                        int index24_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_82);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA24_52 = input.LA(1);

                         
                        int index24_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_52);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA24_78 = input.LA(1);

                         
                        int index24_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_78);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA24_113 = input.LA(1);

                         
                        int index24_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 1) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_113);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA24_57 = input.LA(1);

                         
                        int index24_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_57);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA24_83 = input.LA(1);

                         
                        int index24_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_83);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA24_37 = input.LA(1);

                         
                        int index24_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_37);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA24_72 = input.LA(1);

                         
                        int index24_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index24_72);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 24, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_37s = "\35\uffff\1\46\1\uffff\1\31\1\36\1\uffff\1\16\1\uffff\1\72\1\63\1\70\1\0\1\15\1\25\1\40\1\47\1\45\1\53\1\11\1\17\1\27\1\51\1\57\1\65\1\75\1\74\1\2\1\43\1\52\1\61\1\100\1\5\1\13\1\22\1\21\1\33\1\73\1\1\1\7\1\26\1\41\1\50\1\56\1\55\1\64\1\20\1\32\1\42\1\60\1\66\1\76\1\4\1\3\1\12\1\54\1\62\1\67\1\6\1\14\1\24\1\37\1\34\1\44\24\uffff\1\71\1\uffff\1\77\1\30\1\uffff\1\35\3\uffff\1\23\1\uffff\1\10}>";
    static final short[] dfa_37 = DFA.unpackEncodedString(dfa_37s);

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = dfa_23;
            this.eof = dfa_24;
            this.min = dfa_25;
            this.max = dfa_26;
            this.accept = dfa_27;
            this.special = dfa_37;
            this.transition = dfa_29;
        }
        public String getDescription() {
            return "2297:2: ( rule__TexturedMaterial__UnorderedGroup__9 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA25_39 = input.LA(1);

                         
                        int index25_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_39);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA25_65 = input.LA(1);

                         
                        int index25_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_65);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA25_54 = input.LA(1);

                         
                        int index25_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_54);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA25_80 = input.LA(1);

                         
                        int index25_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_80);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA25_79 = input.LA(1);

                         
                        int index25_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_79);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA25_59 = input.LA(1);

                         
                        int index25_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_59);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA25_85 = input.LA(1);

                         
                        int index25_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_85);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA25_66 = input.LA(1);

                         
                        int index25_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_66);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA25_122 = input.LA(1);

                         
                        int index25_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 0) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_122);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA25_46 = input.LA(1);

                         
                        int index25_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_46);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA25_81 = input.LA(1);

                         
                        int index25_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_81);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA25_60 = input.LA(1);

                         
                        int index25_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_60);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA25_86 = input.LA(1);

                         
                        int index25_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_86);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA25_40 = input.LA(1);

                         
                        int index25_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_40);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA25_34 = input.LA(1);

                         
                        int index25_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_34);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA25_47 = input.LA(1);

                         
                        int index25_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_47);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA25_73 = input.LA(1);

                         
                        int index25_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_73);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA25_62 = input.LA(1);

                         
                        int index25_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_62);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA25_61 = input.LA(1);

                         
                        int index25_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_61);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA25_120 = input.LA(1);

                         
                        int index25_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 0) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_120);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA25_87 = input.LA(1);

                         
                        int index25_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_87);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA25_41 = input.LA(1);

                         
                        int index25_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_41);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA25_67 = input.LA(1);

                         
                        int index25_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_67);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA25_48 = input.LA(1);

                         
                        int index25_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_48);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA25_114 = input.LA(1);

                         
                        int index25_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 2) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_114);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA25_31 = input.LA(1);

                         
                        int index25_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_31);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA25_74 = input.LA(1);

                         
                        int index25_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_74);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA25_63 = input.LA(1);

                         
                        int index25_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_63);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA25_89 = input.LA(1);

                         
                        int index25_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_89);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA25_116 = input.LA(1);

                         
                        int index25_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 2) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_116);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA25_32 = input.LA(1);

                         
                        int index25_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_32);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA25_88 = input.LA(1);

                         
                        int index25_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_88);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA25_42 = input.LA(1);

                         
                        int index25_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_42);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA25_68 = input.LA(1);

                         
                        int index25_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_68);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA25_75 = input.LA(1);

                         
                        int index25_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_75);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA25_55 = input.LA(1);

                         
                        int index25_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_55);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA25_90 = input.LA(1);

                         
                        int index25_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_90);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA25_44 = input.LA(1);

                         
                        int index25_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_44);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA25_29 = input.LA(1);

                         
                        int index25_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_29);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA25_43 = input.LA(1);

                         
                        int index25_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_43);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA25_69 = input.LA(1);

                         
                        int index25_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_69);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA25_49 = input.LA(1);

                         
                        int index25_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_49);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA25_56 = input.LA(1);

                         
                        int index25_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_56);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA25_45 = input.LA(1);

                         
                        int index25_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_45);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA25_82 = input.LA(1);

                         
                        int index25_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_82);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA25_71 = input.LA(1);

                         
                        int index25_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_71);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA25_70 = input.LA(1);

                         
                        int index25_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_70);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA25_50 = input.LA(1);

                         
                        int index25_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_50);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA25_76 = input.LA(1);

                         
                        int index25_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_76);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA25_57 = input.LA(1);

                         
                        int index25_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_57);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA25_83 = input.LA(1);

                         
                        int index25_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_83);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA25_37 = input.LA(1);

                         
                        int index25_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_37);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA25_72 = input.LA(1);

                         
                        int index25_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_72);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA25_51 = input.LA(1);

                         
                        int index25_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_51);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA25_77 = input.LA(1);

                         
                        int index25_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_77);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA25_84 = input.LA(1);

                         
                        int index25_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_84);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA25_38 = input.LA(1);

                         
                        int index25_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_38);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA25_111 = input.LA(1);

                         
                        int index25_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 1) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_111);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA25_36 = input.LA(1);

                         
                        int index25_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 4) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_36);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA25_64 = input.LA(1);

                         
                        int index25_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_64);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA25_53 = input.LA(1);

                         
                        int index25_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_53);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA25_52 = input.LA(1);

                         
                        int index25_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_52);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA25_78 = input.LA(1);

                         
                        int index25_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_78);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA25_113 = input.LA(1);

                         
                        int index25_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 1) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_113);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA25_58 = input.LA(1);

                         
                        int index25_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index25_58);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 25, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_38s = "\35\uffff\1\4\1\uffff\1\11\1\73\1\uffff\1\100\1\uffff\1\47\1\33\1\45\1\50\1\57\1\70\1\3\1\5\1\16\1\24\1\64\1\77\1\0\1\13\1\22\1\31\1\32\1\43\1\54\1\17\1\26\1\27\1\37\1\52\1\61\1\62\1\75\1\7\1\44\1\55\1\56\1\67\1\2\1\14\1\15\1\23\1\34\1\76\1\10\1\12\1\21\1\30\1\41\1\42\1\53\1\65\1\25\1\35\1\36\1\51\1\60\1\71\1\74\1\6\1\20\24\uffff\1\46\1\uffff\1\40\1\1\1\uffff\1\72\3\uffff\1\63\1\uffff\1\66}>";
    static final short[] dfa_38 = DFA.unpackEncodedString(dfa_38s);

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = dfa_23;
            this.eof = dfa_24;
            this.min = dfa_25;
            this.max = dfa_26;
            this.accept = dfa_27;
            this.special = dfa_38;
            this.transition = dfa_29;
        }
        public String getDescription() {
            return "2309:2: ( rule__TexturedMaterial__UnorderedGroup__10 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA26_48 = input.LA(1);

                         
                        int index26_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_48);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA26_114 = input.LA(1);

                         
                        int index26_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 2) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_114);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA26_68 = input.LA(1);

                         
                        int index26_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_68);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA26_42 = input.LA(1);

                         
                        int index26_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_42);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA26_29 = input.LA(1);

                         
                        int index26_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_29);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA26_43 = input.LA(1);

                         
                        int index26_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_43);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA26_89 = input.LA(1);

                         
                        int index26_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_89);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA26_63 = input.LA(1);

                         
                        int index26_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_63);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA26_74 = input.LA(1);

                         
                        int index26_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_74);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA26_31 = input.LA(1);

                         
                        int index26_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_31);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA26_75 = input.LA(1);

                         
                        int index26_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_75);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA26_49 = input.LA(1);

                         
                        int index26_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_49);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA26_69 = input.LA(1);

                         
                        int index26_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_69);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA26_70 = input.LA(1);

                         
                        int index26_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_70);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA26_44 = input.LA(1);

                         
                        int index26_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_44);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA26_55 = input.LA(1);

                         
                        int index26_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_55);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA26_90 = input.LA(1);

                         
                        int index26_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_90);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA26_76 = input.LA(1);

                         
                        int index26_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_76);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA26_50 = input.LA(1);

                         
                        int index26_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_50);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA26_71 = input.LA(1);

                         
                        int index26_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_71);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA26_45 = input.LA(1);

                         
                        int index26_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_45);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA26_82 = input.LA(1);

                         
                        int index26_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_82);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA26_56 = input.LA(1);

                         
                        int index26_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_56);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA26_57 = input.LA(1);

                         
                        int index26_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_57);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA26_77 = input.LA(1);

                         
                        int index26_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_77);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA26_51 = input.LA(1);

                         
                        int index26_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_51);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA26_52 = input.LA(1);

                         
                        int index26_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_52);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA26_37 = input.LA(1);

                         
                        int index26_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_37);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA26_72 = input.LA(1);

                         
                        int index26_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_72);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA26_83 = input.LA(1);

                         
                        int index26_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_83);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA26_84 = input.LA(1);

                         
                        int index26_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_84);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA26_58 = input.LA(1);

                         
                        int index26_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_58);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA26_113 = input.LA(1);

                         
                        int index26_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 1) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_113);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA26_78 = input.LA(1);

                         
                        int index26_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_78);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA26_79 = input.LA(1);

                         
                        int index26_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_79);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA26_53 = input.LA(1);

                         
                        int index26_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_53);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA26_64 = input.LA(1);

                         
                        int index26_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_64);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA26_38 = input.LA(1);

                         
                        int index26_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_38);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA26_111 = input.LA(1);

                         
                        int index26_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 1) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_111);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA26_36 = input.LA(1);

                         
                        int index26_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 4) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_36);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA26_39 = input.LA(1);

                         
                        int index26_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_39);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA26_85 = input.LA(1);

                         
                        int index26_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_85);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA26_59 = input.LA(1);

                         
                        int index26_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_59);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA26_80 = input.LA(1);

                         
                        int index26_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_80);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA26_54 = input.LA(1);

                         
                        int index26_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_54);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA26_65 = input.LA(1);

                         
                        int index26_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_65);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA26_66 = input.LA(1);

                         
                        int index26_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_66);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA26_40 = input.LA(1);

                         
                        int index26_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_40);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA26_86 = input.LA(1);

                         
                        int index26_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_86);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA26_60 = input.LA(1);

                         
                        int index26_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_60);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA26_61 = input.LA(1);

                         
                        int index26_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_61);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA26_120 = input.LA(1);

                         
                        int index26_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 0) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_120);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA26_46 = input.LA(1);

                         
                        int index26_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_46);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA26_81 = input.LA(1);

                         
                        int index26_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_81);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA26_122 = input.LA(1);

                         
                        int index26_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 0) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_122);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA26_67 = input.LA(1);

                         
                        int index26_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 8) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_67);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA26_41 = input.LA(1);

                         
                        int index26_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 5) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_41);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA26_87 = input.LA(1);

                         
                        int index26_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_87);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA26_116 = input.LA(1);

                         
                        int index26_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 2) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_116);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA26_32 = input.LA(1);

                         
                        int index26_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_32);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA26_88 = input.LA(1);

                         
                        int index26_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 10) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_88);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA26_62 = input.LA(1);

                         
                        int index26_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 7) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_62);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA26_73 = input.LA(1);

                         
                        int index26_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 9) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_73);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA26_47 = input.LA(1);

                         
                        int index26_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 6) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_47);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA26_34 = input.LA(1);

                         
                        int index26_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup(), 3) ) {s = 107;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getTexturedMaterialAccess().getUnorderedGroup()) ) {s = 13;}

                         
                        input.seek(index26_34);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 26, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000FFB40002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000000003F072L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000000003F070L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000000200C0L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000003B40002L});

}
