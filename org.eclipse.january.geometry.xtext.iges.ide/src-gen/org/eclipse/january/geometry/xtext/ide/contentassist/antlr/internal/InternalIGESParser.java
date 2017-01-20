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
import org.eclipse.january.geometry.xtext.services.IGESGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalIGESParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_WS", "RULE_DELIMITER", "RULE_SEPARATOR", "RULE_ENDLINE", "RULE_HOLLERITH", "RULE_DOUBLE", "'G'", "'D'", "'P'", "'S'", "'T'"
    };
    public static final int RULE_HOLLERITH=10;
    public static final int RULE_ENDLINE=9;
    public static final int RULE_WS=6;
    public static final int RULE_STRING=5;
    public static final int RULE_SEPARATOR=8;
    public static final int RULE_DELIMITER=7;
    public static final int T__15=15;
    public static final int RULE_DOUBLE=11;
    public static final int T__16=16;
    public static final int RULE_INT=4;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalIGESParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalIGESParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalIGESParser.tokenNames; }
    public String getGrammarFileName() { return "InternalIGES.g"; }


    	private IGESGrammarAccess grammarAccess;

    	public void setGrammarAccess(IGESGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleIGES"
    // InternalIGES.g:53:1: entryRuleIGES : ruleIGES EOF ;
    public final void entryRuleIGES() throws RecognitionException {
        try {
            // InternalIGES.g:54:1: ( ruleIGES EOF )
            // InternalIGES.g:55:1: ruleIGES EOF
            {
             before(grammarAccess.getIGESRule()); 
            pushFollow(FOLLOW_1);
            ruleIGES();

            state._fsp--;

             after(grammarAccess.getIGESRule()); 
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
    // $ANTLR end "entryRuleIGES"


    // $ANTLR start "ruleIGES"
    // InternalIGES.g:62:1: ruleIGES : ( ( rule__IGES__Group__0 ) ) ;
    public final void ruleIGES() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:66:2: ( ( ( rule__IGES__Group__0 ) ) )
            // InternalIGES.g:67:2: ( ( rule__IGES__Group__0 ) )
            {
            // InternalIGES.g:67:2: ( ( rule__IGES__Group__0 ) )
            // InternalIGES.g:68:3: ( rule__IGES__Group__0 )
            {
             before(grammarAccess.getIGESAccess().getGroup()); 
            // InternalIGES.g:69:3: ( rule__IGES__Group__0 )
            // InternalIGES.g:69:4: rule__IGES__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IGES__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIGESAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIGES"


    // $ANTLR start "entryRuleStart"
    // InternalIGES.g:78:1: entryRuleStart : ruleStart EOF ;
    public final void entryRuleStart() throws RecognitionException {
        try {
            // InternalIGES.g:79:1: ( ruleStart EOF )
            // InternalIGES.g:80:1: ruleStart EOF
            {
             before(grammarAccess.getStartRule()); 
            pushFollow(FOLLOW_1);
            ruleStart();

            state._fsp--;

             after(grammarAccess.getStartRule()); 
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
    // $ANTLR end "entryRuleStart"


    // $ANTLR start "ruleStart"
    // InternalIGES.g:87:1: ruleStart : ( ( ( rule__Start__LinesAssignment ) ) ( ( rule__Start__LinesAssignment )* ) ) ;
    public final void ruleStart() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:91:2: ( ( ( ( rule__Start__LinesAssignment ) ) ( ( rule__Start__LinesAssignment )* ) ) )
            // InternalIGES.g:92:2: ( ( ( rule__Start__LinesAssignment ) ) ( ( rule__Start__LinesAssignment )* ) )
            {
            // InternalIGES.g:92:2: ( ( ( rule__Start__LinesAssignment ) ) ( ( rule__Start__LinesAssignment )* ) )
            // InternalIGES.g:93:3: ( ( rule__Start__LinesAssignment ) ) ( ( rule__Start__LinesAssignment )* )
            {
            // InternalIGES.g:93:3: ( ( rule__Start__LinesAssignment ) )
            // InternalIGES.g:94:4: ( rule__Start__LinesAssignment )
            {
             before(grammarAccess.getStartAccess().getLinesAssignment()); 
            // InternalIGES.g:95:4: ( rule__Start__LinesAssignment )
            // InternalIGES.g:95:5: rule__Start__LinesAssignment
            {
            pushFollow(FOLLOW_3);
            rule__Start__LinesAssignment();

            state._fsp--;


            }

             after(grammarAccess.getStartAccess().getLinesAssignment()); 

            }

            // InternalIGES.g:98:3: ( ( rule__Start__LinesAssignment )* )
            // InternalIGES.g:99:4: ( rule__Start__LinesAssignment )*
            {
             before(grammarAccess.getStartAccess().getLinesAssignment()); 
            // InternalIGES.g:100:4: ( rule__Start__LinesAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_WS)||LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalIGES.g:100:5: rule__Start__LinesAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Start__LinesAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getStartAccess().getLinesAssignment()); 

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
    // $ANTLR end "ruleStart"


    // $ANTLR start "entryRuleGlobal"
    // InternalIGES.g:110:1: entryRuleGlobal : ruleGlobal EOF ;
    public final void entryRuleGlobal() throws RecognitionException {
        try {
            // InternalIGES.g:111:1: ( ruleGlobal EOF )
            // InternalIGES.g:112:1: ruleGlobal EOF
            {
             before(grammarAccess.getGlobalRule()); 
            pushFollow(FOLLOW_1);
            ruleGlobal();

            state._fsp--;

             after(grammarAccess.getGlobalRule()); 
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
    // $ANTLR end "entryRuleGlobal"


    // $ANTLR start "ruleGlobal"
    // InternalIGES.g:119:1: ruleGlobal : ( ( rule__Global__Group__0 ) ) ;
    public final void ruleGlobal() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:123:2: ( ( ( rule__Global__Group__0 ) ) )
            // InternalIGES.g:124:2: ( ( rule__Global__Group__0 ) )
            {
            // InternalIGES.g:124:2: ( ( rule__Global__Group__0 ) )
            // InternalIGES.g:125:3: ( rule__Global__Group__0 )
            {
             before(grammarAccess.getGlobalAccess().getGroup()); 
            // InternalIGES.g:126:3: ( rule__Global__Group__0 )
            // InternalIGES.g:126:4: rule__Global__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Global__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGlobalAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGlobal"


    // $ANTLR start "entryRuleData"
    // InternalIGES.g:135:1: entryRuleData : ruleData EOF ;
    public final void entryRuleData() throws RecognitionException {
        try {
            // InternalIGES.g:136:1: ( ruleData EOF )
            // InternalIGES.g:137:1: ruleData EOF
            {
             before(grammarAccess.getDataRule()); 
            pushFollow(FOLLOW_1);
            ruleData();

            state._fsp--;

             after(grammarAccess.getDataRule()); 
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
    // $ANTLR end "entryRuleData"


    // $ANTLR start "ruleData"
    // InternalIGES.g:144:1: ruleData : ( ( ( rule__Data__EntriesAssignment ) ) ( ( rule__Data__EntriesAssignment )* ) ) ;
    public final void ruleData() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:148:2: ( ( ( ( rule__Data__EntriesAssignment ) ) ( ( rule__Data__EntriesAssignment )* ) ) )
            // InternalIGES.g:149:2: ( ( ( rule__Data__EntriesAssignment ) ) ( ( rule__Data__EntriesAssignment )* ) )
            {
            // InternalIGES.g:149:2: ( ( ( rule__Data__EntriesAssignment ) ) ( ( rule__Data__EntriesAssignment )* ) )
            // InternalIGES.g:150:3: ( ( rule__Data__EntriesAssignment ) ) ( ( rule__Data__EntriesAssignment )* )
            {
            // InternalIGES.g:150:3: ( ( rule__Data__EntriesAssignment ) )
            // InternalIGES.g:151:4: ( rule__Data__EntriesAssignment )
            {
             before(grammarAccess.getDataAccess().getEntriesAssignment()); 
            // InternalIGES.g:152:4: ( rule__Data__EntriesAssignment )
            // InternalIGES.g:152:5: rule__Data__EntriesAssignment
            {
            pushFollow(FOLLOW_4);
            rule__Data__EntriesAssignment();

            state._fsp--;


            }

             after(grammarAccess.getDataAccess().getEntriesAssignment()); 

            }

            // InternalIGES.g:155:3: ( ( rule__Data__EntriesAssignment )* )
            // InternalIGES.g:156:4: ( rule__Data__EntriesAssignment )*
            {
             before(grammarAccess.getDataAccess().getEntriesAssignment()); 
            // InternalIGES.g:157:4: ( rule__Data__EntriesAssignment )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_WS) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalIGES.g:157:5: rule__Data__EntriesAssignment
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__Data__EntriesAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getDataAccess().getEntriesAssignment()); 

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
    // $ANTLR end "ruleData"


    // $ANTLR start "entryRuleEntry"
    // InternalIGES.g:167:1: entryRuleEntry : ruleEntry EOF ;
    public final void entryRuleEntry() throws RecognitionException {
        try {
            // InternalIGES.g:168:1: ( ruleEntry EOF )
            // InternalIGES.g:169:1: ruleEntry EOF
            {
             before(grammarAccess.getEntryRule()); 
            pushFollow(FOLLOW_1);
            ruleEntry();

            state._fsp--;

             after(grammarAccess.getEntryRule()); 
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
    // $ANTLR end "entryRuleEntry"


    // $ANTLR start "ruleEntry"
    // InternalIGES.g:176:1: ruleEntry : ( ( rule__Entry__Group__0 ) ) ;
    public final void ruleEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:180:2: ( ( ( rule__Entry__Group__0 ) ) )
            // InternalIGES.g:181:2: ( ( rule__Entry__Group__0 ) )
            {
            // InternalIGES.g:181:2: ( ( rule__Entry__Group__0 ) )
            // InternalIGES.g:182:3: ( rule__Entry__Group__0 )
            {
             before(grammarAccess.getEntryAccess().getGroup()); 
            // InternalIGES.g:183:3: ( rule__Entry__Group__0 )
            // InternalIGES.g:183:4: rule__Entry__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Entry__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEntry"


    // $ANTLR start "entryRuleParameters"
    // InternalIGES.g:192:1: entryRuleParameters : ruleParameters EOF ;
    public final void entryRuleParameters() throws RecognitionException {
        try {
            // InternalIGES.g:193:1: ( ruleParameters EOF )
            // InternalIGES.g:194:1: ruleParameters EOF
            {
             before(grammarAccess.getParametersRule()); 
            pushFollow(FOLLOW_1);
            ruleParameters();

            state._fsp--;

             after(grammarAccess.getParametersRule()); 
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
    // $ANTLR end "entryRuleParameters"


    // $ANTLR start "ruleParameters"
    // InternalIGES.g:201:1: ruleParameters : ( ( ( rule__Parameters__EntriesAssignment ) ) ( ( rule__Parameters__EntriesAssignment )* ) ) ;
    public final void ruleParameters() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:205:2: ( ( ( ( rule__Parameters__EntriesAssignment ) ) ( ( rule__Parameters__EntriesAssignment )* ) ) )
            // InternalIGES.g:206:2: ( ( ( rule__Parameters__EntriesAssignment ) ) ( ( rule__Parameters__EntriesAssignment )* ) )
            {
            // InternalIGES.g:206:2: ( ( ( rule__Parameters__EntriesAssignment ) ) ( ( rule__Parameters__EntriesAssignment )* ) )
            // InternalIGES.g:207:3: ( ( rule__Parameters__EntriesAssignment ) ) ( ( rule__Parameters__EntriesAssignment )* )
            {
            // InternalIGES.g:207:3: ( ( rule__Parameters__EntriesAssignment ) )
            // InternalIGES.g:208:4: ( rule__Parameters__EntriesAssignment )
            {
             before(grammarAccess.getParametersAccess().getEntriesAssignment()); 
            // InternalIGES.g:209:4: ( rule__Parameters__EntriesAssignment )
            // InternalIGES.g:209:5: rule__Parameters__EntriesAssignment
            {
            pushFollow(FOLLOW_5);
            rule__Parameters__EntriesAssignment();

            state._fsp--;


            }

             after(grammarAccess.getParametersAccess().getEntriesAssignment()); 

            }

            // InternalIGES.g:212:3: ( ( rule__Parameters__EntriesAssignment )* )
            // InternalIGES.g:213:4: ( rule__Parameters__EntriesAssignment )*
            {
             before(grammarAccess.getParametersAccess().getEntriesAssignment()); 
            // InternalIGES.g:214:4: ( rule__Parameters__EntriesAssignment )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_INT) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalIGES.g:214:5: rule__Parameters__EntriesAssignment
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Parameters__EntriesAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getParametersAccess().getEntriesAssignment()); 

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
    // $ANTLR end "ruleParameters"


    // $ANTLR start "entryRulePEntry"
    // InternalIGES.g:224:1: entryRulePEntry : rulePEntry EOF ;
    public final void entryRulePEntry() throws RecognitionException {
        try {
            // InternalIGES.g:225:1: ( rulePEntry EOF )
            // InternalIGES.g:226:1: rulePEntry EOF
            {
             before(grammarAccess.getPEntryRule()); 
            pushFollow(FOLLOW_1);
            rulePEntry();

            state._fsp--;

             after(grammarAccess.getPEntryRule()); 
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
    // $ANTLR end "entryRulePEntry"


    // $ANTLR start "rulePEntry"
    // InternalIGES.g:233:1: rulePEntry : ( ( rule__PEntry__Group__0 ) ) ;
    public final void rulePEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:237:2: ( ( ( rule__PEntry__Group__0 ) ) )
            // InternalIGES.g:238:2: ( ( rule__PEntry__Group__0 ) )
            {
            // InternalIGES.g:238:2: ( ( rule__PEntry__Group__0 ) )
            // InternalIGES.g:239:3: ( rule__PEntry__Group__0 )
            {
             before(grammarAccess.getPEntryAccess().getGroup()); 
            // InternalIGES.g:240:3: ( rule__PEntry__Group__0 )
            // InternalIGES.g:240:4: rule__PEntry__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PEntry__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePEntry"


    // $ANTLR start "entryRulePMultiEntry"
    // InternalIGES.g:249:1: entryRulePMultiEntry : rulePMultiEntry EOF ;
    public final void entryRulePMultiEntry() throws RecognitionException {
        try {
            // InternalIGES.g:250:1: ( rulePMultiEntry EOF )
            // InternalIGES.g:251:1: rulePMultiEntry EOF
            {
             before(grammarAccess.getPMultiEntryRule()); 
            pushFollow(FOLLOW_1);
            rulePMultiEntry();

            state._fsp--;

             after(grammarAccess.getPMultiEntryRule()); 
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
    // $ANTLR end "entryRulePMultiEntry"


    // $ANTLR start "rulePMultiEntry"
    // InternalIGES.g:258:1: rulePMultiEntry : ( ( rule__PMultiEntry__Group__0 ) ) ;
    public final void rulePMultiEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:262:2: ( ( ( rule__PMultiEntry__Group__0 ) ) )
            // InternalIGES.g:263:2: ( ( rule__PMultiEntry__Group__0 ) )
            {
            // InternalIGES.g:263:2: ( ( rule__PMultiEntry__Group__0 ) )
            // InternalIGES.g:264:3: ( rule__PMultiEntry__Group__0 )
            {
             before(grammarAccess.getPMultiEntryAccess().getGroup()); 
            // InternalIGES.g:265:3: ( rule__PMultiEntry__Group__0 )
            // InternalIGES.g:265:4: rule__PMultiEntry__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PMultiEntry__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPMultiEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePMultiEntry"


    // $ANTLR start "entryRuleValue"
    // InternalIGES.g:274:1: entryRuleValue : ruleValue EOF ;
    public final void entryRuleValue() throws RecognitionException {
        try {
            // InternalIGES.g:275:1: ( ruleValue EOF )
            // InternalIGES.g:276:1: ruleValue EOF
            {
             before(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_1);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getValueRule()); 
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
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // InternalIGES.g:283:1: ruleValue : ( ( rule__Value__Alternatives ) ) ;
    public final void ruleValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:287:2: ( ( ( rule__Value__Alternatives ) ) )
            // InternalIGES.g:288:2: ( ( rule__Value__Alternatives ) )
            {
            // InternalIGES.g:288:2: ( ( rule__Value__Alternatives ) )
            // InternalIGES.g:289:3: ( rule__Value__Alternatives )
            {
             before(grammarAccess.getValueAccess().getAlternatives()); 
            // InternalIGES.g:290:3: ( rule__Value__Alternatives )
            // InternalIGES.g:290:4: rule__Value__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Value__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getValueAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleHString"
    // InternalIGES.g:299:1: entryRuleHString : ruleHString EOF ;
    public final void entryRuleHString() throws RecognitionException {
        try {
            // InternalIGES.g:300:1: ( ruleHString EOF )
            // InternalIGES.g:301:1: ruleHString EOF
            {
             before(grammarAccess.getHStringRule()); 
            pushFollow(FOLLOW_1);
            ruleHString();

            state._fsp--;

             after(grammarAccess.getHStringRule()); 
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
    // $ANTLR end "entryRuleHString"


    // $ANTLR start "ruleHString"
    // InternalIGES.g:308:1: ruleHString : ( ( rule__HString__Group__0 ) ) ;
    public final void ruleHString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:312:2: ( ( ( rule__HString__Group__0 ) ) )
            // InternalIGES.g:313:2: ( ( rule__HString__Group__0 ) )
            {
            // InternalIGES.g:313:2: ( ( rule__HString__Group__0 ) )
            // InternalIGES.g:314:3: ( rule__HString__Group__0 )
            {
             before(grammarAccess.getHStringAccess().getGroup()); 
            // InternalIGES.g:315:3: ( rule__HString__Group__0 )
            // InternalIGES.g:315:4: rule__HString__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__HString__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getHStringAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHString"


    // $ANTLR start "entryRuleParam"
    // InternalIGES.g:324:1: entryRuleParam : ruleParam EOF ;
    public final void entryRuleParam() throws RecognitionException {
        try {
            // InternalIGES.g:325:1: ( ruleParam EOF )
            // InternalIGES.g:326:1: ruleParam EOF
            {
             before(grammarAccess.getParamRule()); 
            pushFollow(FOLLOW_1);
            ruleParam();

            state._fsp--;

             after(grammarAccess.getParamRule()); 
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
    // $ANTLR end "entryRuleParam"


    // $ANTLR start "ruleParam"
    // InternalIGES.g:333:1: ruleParam : ( ( rule__Param__Group__0 ) ) ;
    public final void ruleParam() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:337:2: ( ( ( rule__Param__Group__0 ) ) )
            // InternalIGES.g:338:2: ( ( rule__Param__Group__0 ) )
            {
            // InternalIGES.g:338:2: ( ( rule__Param__Group__0 ) )
            // InternalIGES.g:339:3: ( rule__Param__Group__0 )
            {
             before(grammarAccess.getParamAccess().getGroup()); 
            // InternalIGES.g:340:3: ( rule__Param__Group__0 )
            // InternalIGES.g:340:4: rule__Param__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Param__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParamAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParam"


    // $ANTLR start "entryRulePointer"
    // InternalIGES.g:349:1: entryRulePointer : rulePointer EOF ;
    public final void entryRulePointer() throws RecognitionException {
        try {
            // InternalIGES.g:350:1: ( rulePointer EOF )
            // InternalIGES.g:351:1: rulePointer EOF
            {
             before(grammarAccess.getPointerRule()); 
            pushFollow(FOLLOW_1);
            rulePointer();

            state._fsp--;

             after(grammarAccess.getPointerRule()); 
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
    // $ANTLR end "entryRulePointer"


    // $ANTLR start "rulePointer"
    // InternalIGES.g:358:1: rulePointer : ( ( rule__Pointer__Group__0 ) ) ;
    public final void rulePointer() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:362:2: ( ( ( rule__Pointer__Group__0 ) ) )
            // InternalIGES.g:363:2: ( ( rule__Pointer__Group__0 ) )
            {
            // InternalIGES.g:363:2: ( ( rule__Pointer__Group__0 ) )
            // InternalIGES.g:364:3: ( rule__Pointer__Group__0 )
            {
             before(grammarAccess.getPointerAccess().getGroup()); 
            // InternalIGES.g:365:3: ( rule__Pointer__Group__0 )
            // InternalIGES.g:365:4: rule__Pointer__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Pointer__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPointerAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePointer"


    // $ANTLR start "entryRuleEnd"
    // InternalIGES.g:374:1: entryRuleEnd : ruleEnd EOF ;
    public final void entryRuleEnd() throws RecognitionException {
        try {
            // InternalIGES.g:375:1: ( ruleEnd EOF )
            // InternalIGES.g:376:1: ruleEnd EOF
            {
             before(grammarAccess.getEndRule()); 
            pushFollow(FOLLOW_1);
            ruleEnd();

            state._fsp--;

             after(grammarAccess.getEndRule()); 
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
    // $ANTLR end "entryRuleEnd"


    // $ANTLR start "ruleEnd"
    // InternalIGES.g:383:1: ruleEnd : ( ( rule__End__Group__0 ) ) ;
    public final void ruleEnd() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:387:2: ( ( ( rule__End__Group__0 ) ) )
            // InternalIGES.g:388:2: ( ( rule__End__Group__0 ) )
            {
            // InternalIGES.g:388:2: ( ( rule__End__Group__0 ) )
            // InternalIGES.g:389:3: ( rule__End__Group__0 )
            {
             before(grammarAccess.getEndAccess().getGroup()); 
            // InternalIGES.g:390:3: ( rule__End__Group__0 )
            // InternalIGES.g:390:4: rule__End__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__End__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEndAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnd"


    // $ANTLR start "entryRulestartLine"
    // InternalIGES.g:399:1: entryRulestartLine : rulestartLine EOF ;
    public final void entryRulestartLine() throws RecognitionException {
        try {
            // InternalIGES.g:400:1: ( rulestartLine EOF )
            // InternalIGES.g:401:1: rulestartLine EOF
            {
             before(grammarAccess.getStartLineRule()); 
            pushFollow(FOLLOW_1);
            rulestartLine();

            state._fsp--;

             after(grammarAccess.getStartLineRule()); 
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
    // $ANTLR end "entryRulestartLine"


    // $ANTLR start "rulestartLine"
    // InternalIGES.g:408:1: rulestartLine : ( ( rule__StartLine__Group__0 ) ) ;
    public final void rulestartLine() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:412:2: ( ( ( rule__StartLine__Group__0 ) ) )
            // InternalIGES.g:413:2: ( ( rule__StartLine__Group__0 ) )
            {
            // InternalIGES.g:413:2: ( ( rule__StartLine__Group__0 ) )
            // InternalIGES.g:414:3: ( rule__StartLine__Group__0 )
            {
             before(grammarAccess.getStartLineAccess().getGroup()); 
            // InternalIGES.g:415:3: ( rule__StartLine__Group__0 )
            // InternalIGES.g:415:4: rule__StartLine__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__StartLine__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStartLineAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulestartLine"


    // $ANTLR start "rule__Entry__Alternatives_35"
    // InternalIGES.g:423:1: rule__Entry__Alternatives_35 : ( ( ( rule__Entry__EntityLabelAssignment_35_0 ) ) | ( RULE_INT ) );
    public final void rule__Entry__Alternatives_35() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:427:1: ( ( ( rule__Entry__EntityLabelAssignment_35_0 ) ) | ( RULE_INT ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_STRING) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_INT) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalIGES.g:428:2: ( ( rule__Entry__EntityLabelAssignment_35_0 ) )
                    {
                    // InternalIGES.g:428:2: ( ( rule__Entry__EntityLabelAssignment_35_0 ) )
                    // InternalIGES.g:429:3: ( rule__Entry__EntityLabelAssignment_35_0 )
                    {
                     before(grammarAccess.getEntryAccess().getEntityLabelAssignment_35_0()); 
                    // InternalIGES.g:430:3: ( rule__Entry__EntityLabelAssignment_35_0 )
                    // InternalIGES.g:430:4: rule__Entry__EntityLabelAssignment_35_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Entry__EntityLabelAssignment_35_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getEntryAccess().getEntityLabelAssignment_35_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIGES.g:434:2: ( RULE_INT )
                    {
                    // InternalIGES.g:434:2: ( RULE_INT )
                    // InternalIGES.g:435:3: RULE_INT
                    {
                     before(grammarAccess.getEntryAccess().getINTTerminalRuleCall_35_1()); 
                    match(input,RULE_INT,FOLLOW_2); 
                     after(grammarAccess.getEntryAccess().getINTTerminalRuleCall_35_1()); 

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
    // $ANTLR end "rule__Entry__Alternatives_35"


    // $ANTLR start "rule__Parameters__EntriesAlternatives_0"
    // InternalIGES.g:444:1: rule__Parameters__EntriesAlternatives_0 : ( ( rulePMultiEntry ) | ( rulePEntry ) );
    public final void rule__Parameters__EntriesAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:448:1: ( ( rulePMultiEntry ) | ( rulePEntry ) )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // InternalIGES.g:449:2: ( rulePMultiEntry )
                    {
                    // InternalIGES.g:449:2: ( rulePMultiEntry )
                    // InternalIGES.g:450:3: rulePMultiEntry
                    {
                     before(grammarAccess.getParametersAccess().getEntriesPMultiEntryParserRuleCall_0_0()); 
                    pushFollow(FOLLOW_2);
                    rulePMultiEntry();

                    state._fsp--;

                     after(grammarAccess.getParametersAccess().getEntriesPMultiEntryParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIGES.g:455:2: ( rulePEntry )
                    {
                    // InternalIGES.g:455:2: ( rulePEntry )
                    // InternalIGES.g:456:3: rulePEntry
                    {
                     before(grammarAccess.getParametersAccess().getEntriesPEntryParserRuleCall_0_1()); 
                    pushFollow(FOLLOW_2);
                    rulePEntry();

                    state._fsp--;

                     after(grammarAccess.getParametersAccess().getEntriesPEntryParserRuleCall_0_1()); 

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
    // $ANTLR end "rule__Parameters__EntriesAlternatives_0"


    // $ANTLR start "rule__Value__Alternatives"
    // InternalIGES.g:465:1: rule__Value__Alternatives : ( ( ruleParam ) | ( rulePointer ) | ( ruleHString ) );
    public final void rule__Value__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:469:1: ( ( ruleParam ) | ( rulePointer ) | ( ruleHString ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case RULE_DOUBLE:
                {
                alt6=1;
                }
                break;
            case RULE_INT:
                {
                alt6=2;
                }
                break;
            case RULE_HOLLERITH:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalIGES.g:470:2: ( ruleParam )
                    {
                    // InternalIGES.g:470:2: ( ruleParam )
                    // InternalIGES.g:471:3: ruleParam
                    {
                     before(grammarAccess.getValueAccess().getParamParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleParam();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getParamParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIGES.g:476:2: ( rulePointer )
                    {
                    // InternalIGES.g:476:2: ( rulePointer )
                    // InternalIGES.g:477:3: rulePointer
                    {
                     before(grammarAccess.getValueAccess().getPointerParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    rulePointer();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getPointerParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalIGES.g:482:2: ( ruleHString )
                    {
                    // InternalIGES.g:482:2: ( ruleHString )
                    // InternalIGES.g:483:3: ruleHString
                    {
                     before(grammarAccess.getValueAccess().getHStringParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleHString();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getHStringParserRuleCall_2()); 

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
    // $ANTLR end "rule__Value__Alternatives"


    // $ANTLR start "rule__StartLine__Alternatives_0"
    // InternalIGES.g:492:1: rule__StartLine__Alternatives_0 : ( ( RULE_STRING ) | ( RULE_WS ) );
    public final void rule__StartLine__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:496:1: ( ( RULE_STRING ) | ( RULE_WS ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_STRING) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_WS) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalIGES.g:497:2: ( RULE_STRING )
                    {
                    // InternalIGES.g:497:2: ( RULE_STRING )
                    // InternalIGES.g:498:3: RULE_STRING
                    {
                     before(grammarAccess.getStartLineAccess().getSTRINGTerminalRuleCall_0_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getStartLineAccess().getSTRINGTerminalRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIGES.g:503:2: ( RULE_WS )
                    {
                    // InternalIGES.g:503:2: ( RULE_WS )
                    // InternalIGES.g:504:3: RULE_WS
                    {
                     before(grammarAccess.getStartLineAccess().getWSTerminalRuleCall_0_1()); 
                    match(input,RULE_WS,FOLLOW_2); 
                     after(grammarAccess.getStartLineAccess().getWSTerminalRuleCall_0_1()); 

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
    // $ANTLR end "rule__StartLine__Alternatives_0"


    // $ANTLR start "rule__IGES__Group__0"
    // InternalIGES.g:513:1: rule__IGES__Group__0 : rule__IGES__Group__0__Impl rule__IGES__Group__1 ;
    public final void rule__IGES__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:517:1: ( rule__IGES__Group__0__Impl rule__IGES__Group__1 )
            // InternalIGES.g:518:2: rule__IGES__Group__0__Impl rule__IGES__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__IGES__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IGES__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IGES__Group__0"


    // $ANTLR start "rule__IGES__Group__0__Impl"
    // InternalIGES.g:525:1: rule__IGES__Group__0__Impl : ( ( rule__IGES__StartAssignment_0 ) ) ;
    public final void rule__IGES__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:529:1: ( ( ( rule__IGES__StartAssignment_0 ) ) )
            // InternalIGES.g:530:1: ( ( rule__IGES__StartAssignment_0 ) )
            {
            // InternalIGES.g:530:1: ( ( rule__IGES__StartAssignment_0 ) )
            // InternalIGES.g:531:2: ( rule__IGES__StartAssignment_0 )
            {
             before(grammarAccess.getIGESAccess().getStartAssignment_0()); 
            // InternalIGES.g:532:2: ( rule__IGES__StartAssignment_0 )
            // InternalIGES.g:532:3: rule__IGES__StartAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__IGES__StartAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getIGESAccess().getStartAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IGES__Group__0__Impl"


    // $ANTLR start "rule__IGES__Group__1"
    // InternalIGES.g:540:1: rule__IGES__Group__1 : rule__IGES__Group__1__Impl rule__IGES__Group__2 ;
    public final void rule__IGES__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:544:1: ( rule__IGES__Group__1__Impl rule__IGES__Group__2 )
            // InternalIGES.g:545:2: rule__IGES__Group__1__Impl rule__IGES__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__IGES__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IGES__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IGES__Group__1"


    // $ANTLR start "rule__IGES__Group__1__Impl"
    // InternalIGES.g:552:1: rule__IGES__Group__1__Impl : ( ( rule__IGES__GlobalAssignment_1 ) ) ;
    public final void rule__IGES__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:556:1: ( ( ( rule__IGES__GlobalAssignment_1 ) ) )
            // InternalIGES.g:557:1: ( ( rule__IGES__GlobalAssignment_1 ) )
            {
            // InternalIGES.g:557:1: ( ( rule__IGES__GlobalAssignment_1 ) )
            // InternalIGES.g:558:2: ( rule__IGES__GlobalAssignment_1 )
            {
             before(grammarAccess.getIGESAccess().getGlobalAssignment_1()); 
            // InternalIGES.g:559:2: ( rule__IGES__GlobalAssignment_1 )
            // InternalIGES.g:559:3: rule__IGES__GlobalAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__IGES__GlobalAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getIGESAccess().getGlobalAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IGES__Group__1__Impl"


    // $ANTLR start "rule__IGES__Group__2"
    // InternalIGES.g:567:1: rule__IGES__Group__2 : rule__IGES__Group__2__Impl rule__IGES__Group__3 ;
    public final void rule__IGES__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:571:1: ( rule__IGES__Group__2__Impl rule__IGES__Group__3 )
            // InternalIGES.g:572:2: rule__IGES__Group__2__Impl rule__IGES__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__IGES__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IGES__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IGES__Group__2"


    // $ANTLR start "rule__IGES__Group__2__Impl"
    // InternalIGES.g:579:1: rule__IGES__Group__2__Impl : ( ( rule__IGES__DataAssignment_2 ) ) ;
    public final void rule__IGES__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:583:1: ( ( ( rule__IGES__DataAssignment_2 ) ) )
            // InternalIGES.g:584:1: ( ( rule__IGES__DataAssignment_2 ) )
            {
            // InternalIGES.g:584:1: ( ( rule__IGES__DataAssignment_2 ) )
            // InternalIGES.g:585:2: ( rule__IGES__DataAssignment_2 )
            {
             before(grammarAccess.getIGESAccess().getDataAssignment_2()); 
            // InternalIGES.g:586:2: ( rule__IGES__DataAssignment_2 )
            // InternalIGES.g:586:3: rule__IGES__DataAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__IGES__DataAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getIGESAccess().getDataAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IGES__Group__2__Impl"


    // $ANTLR start "rule__IGES__Group__3"
    // InternalIGES.g:594:1: rule__IGES__Group__3 : rule__IGES__Group__3__Impl rule__IGES__Group__4 ;
    public final void rule__IGES__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:598:1: ( rule__IGES__Group__3__Impl rule__IGES__Group__4 )
            // InternalIGES.g:599:2: rule__IGES__Group__3__Impl rule__IGES__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__IGES__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IGES__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IGES__Group__3"


    // $ANTLR start "rule__IGES__Group__3__Impl"
    // InternalIGES.g:606:1: rule__IGES__Group__3__Impl : ( ( rule__IGES__ParametersAssignment_3 ) ) ;
    public final void rule__IGES__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:610:1: ( ( ( rule__IGES__ParametersAssignment_3 ) ) )
            // InternalIGES.g:611:1: ( ( rule__IGES__ParametersAssignment_3 ) )
            {
            // InternalIGES.g:611:1: ( ( rule__IGES__ParametersAssignment_3 ) )
            // InternalIGES.g:612:2: ( rule__IGES__ParametersAssignment_3 )
            {
             before(grammarAccess.getIGESAccess().getParametersAssignment_3()); 
            // InternalIGES.g:613:2: ( rule__IGES__ParametersAssignment_3 )
            // InternalIGES.g:613:3: rule__IGES__ParametersAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__IGES__ParametersAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getIGESAccess().getParametersAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IGES__Group__3__Impl"


    // $ANTLR start "rule__IGES__Group__4"
    // InternalIGES.g:621:1: rule__IGES__Group__4 : rule__IGES__Group__4__Impl ;
    public final void rule__IGES__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:625:1: ( rule__IGES__Group__4__Impl )
            // InternalIGES.g:626:2: rule__IGES__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IGES__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IGES__Group__4"


    // $ANTLR start "rule__IGES__Group__4__Impl"
    // InternalIGES.g:632:1: rule__IGES__Group__4__Impl : ( ( rule__IGES__EndAssignment_4 ) ) ;
    public final void rule__IGES__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:636:1: ( ( ( rule__IGES__EndAssignment_4 ) ) )
            // InternalIGES.g:637:1: ( ( rule__IGES__EndAssignment_4 ) )
            {
            // InternalIGES.g:637:1: ( ( rule__IGES__EndAssignment_4 ) )
            // InternalIGES.g:638:2: ( rule__IGES__EndAssignment_4 )
            {
             before(grammarAccess.getIGESAccess().getEndAssignment_4()); 
            // InternalIGES.g:639:2: ( rule__IGES__EndAssignment_4 )
            // InternalIGES.g:639:3: rule__IGES__EndAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__IGES__EndAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getIGESAccess().getEndAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IGES__Group__4__Impl"


    // $ANTLR start "rule__Global__Group__0"
    // InternalIGES.g:648:1: rule__Global__Group__0 : rule__Global__Group__0__Impl rule__Global__Group__1 ;
    public final void rule__Global__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:652:1: ( rule__Global__Group__0__Impl rule__Global__Group__1 )
            // InternalIGES.g:653:2: rule__Global__Group__0__Impl rule__Global__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__Global__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Global__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group__0"


    // $ANTLR start "rule__Global__Group__0__Impl"
    // InternalIGES.g:660:1: rule__Global__Group__0__Impl : ( ( RULE_DELIMITER )? ) ;
    public final void rule__Global__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:664:1: ( ( ( RULE_DELIMITER )? ) )
            // InternalIGES.g:665:1: ( ( RULE_DELIMITER )? )
            {
            // InternalIGES.g:665:1: ( ( RULE_DELIMITER )? )
            // InternalIGES.g:666:2: ( RULE_DELIMITER )?
            {
             before(grammarAccess.getGlobalAccess().getDELIMITERTerminalRuleCall_0()); 
            // InternalIGES.g:667:2: ( RULE_DELIMITER )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_DELIMITER) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalIGES.g:667:3: RULE_DELIMITER
                    {
                    match(input,RULE_DELIMITER,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getGlobalAccess().getDELIMITERTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group__0__Impl"


    // $ANTLR start "rule__Global__Group__1"
    // InternalIGES.g:675:1: rule__Global__Group__1 : rule__Global__Group__1__Impl rule__Global__Group__2 ;
    public final void rule__Global__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:679:1: ( rule__Global__Group__1__Impl rule__Global__Group__2 )
            // InternalIGES.g:680:2: rule__Global__Group__1__Impl rule__Global__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__Global__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Global__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group__1"


    // $ANTLR start "rule__Global__Group__1__Impl"
    // InternalIGES.g:687:1: rule__Global__Group__1__Impl : ( ( ruleHString )? ) ;
    public final void rule__Global__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:691:1: ( ( ( ruleHString )? ) )
            // InternalIGES.g:692:1: ( ( ruleHString )? )
            {
            // InternalIGES.g:692:1: ( ( ruleHString )? )
            // InternalIGES.g:693:2: ( ruleHString )?
            {
             before(grammarAccess.getGlobalAccess().getHStringParserRuleCall_1()); 
            // InternalIGES.g:694:2: ( ruleHString )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_HOLLERITH) ) {
                switch ( input.LA(2) ) {
                    case RULE_DELIMITER:
                        {
                        switch ( input.LA(3) ) {
                            case RULE_DOUBLE:
                                {
                                alt9=1;
                                }
                                break;
                            case RULE_INT:
                                {
                                alt9=1;
                                }
                                break;
                            case RULE_DELIMITER:
                            case RULE_HOLLERITH:
                                {
                                alt9=1;
                                }
                                break;
                        }

                        }
                        break;
                    case RULE_DOUBLE:
                        {
                        alt9=1;
                        }
                        break;
                    case RULE_INT:
                        {
                        alt9=1;
                        }
                        break;
                    case RULE_HOLLERITH:
                        {
                        alt9=1;
                        }
                        break;
                }

            }
            switch (alt9) {
                case 1 :
                    // InternalIGES.g:694:3: ruleHString
                    {
                    pushFollow(FOLLOW_2);
                    ruleHString();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGlobalAccess().getHStringParserRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group__1__Impl"


    // $ANTLR start "rule__Global__Group__2"
    // InternalIGES.g:702:1: rule__Global__Group__2 : rule__Global__Group__2__Impl rule__Global__Group__3 ;
    public final void rule__Global__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:706:1: ( rule__Global__Group__2__Impl rule__Global__Group__3 )
            // InternalIGES.g:707:2: rule__Global__Group__2__Impl rule__Global__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__Global__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Global__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group__2"


    // $ANTLR start "rule__Global__Group__2__Impl"
    // InternalIGES.g:714:1: rule__Global__Group__2__Impl : ( ( RULE_DELIMITER )? ) ;
    public final void rule__Global__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:718:1: ( ( ( RULE_DELIMITER )? ) )
            // InternalIGES.g:719:1: ( ( RULE_DELIMITER )? )
            {
            // InternalIGES.g:719:1: ( ( RULE_DELIMITER )? )
            // InternalIGES.g:720:2: ( RULE_DELIMITER )?
            {
             before(grammarAccess.getGlobalAccess().getDELIMITERTerminalRuleCall_2()); 
            // InternalIGES.g:721:2: ( RULE_DELIMITER )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_DELIMITER) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalIGES.g:721:3: RULE_DELIMITER
                    {
                    match(input,RULE_DELIMITER,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getGlobalAccess().getDELIMITERTerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group__2__Impl"


    // $ANTLR start "rule__Global__Group__3"
    // InternalIGES.g:729:1: rule__Global__Group__3 : rule__Global__Group__3__Impl rule__Global__Group__4 ;
    public final void rule__Global__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:733:1: ( rule__Global__Group__3__Impl rule__Global__Group__4 )
            // InternalIGES.g:734:2: rule__Global__Group__3__Impl rule__Global__Group__4
            {
            pushFollow(FOLLOW_10);
            rule__Global__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Global__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group__3"


    // $ANTLR start "rule__Global__Group__3__Impl"
    // InternalIGES.g:741:1: rule__Global__Group__3__Impl : ( ( ( rule__Global__Group_3__0 ) ) ( ( rule__Global__Group_3__0 )* ) ) ;
    public final void rule__Global__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:745:1: ( ( ( ( rule__Global__Group_3__0 ) ) ( ( rule__Global__Group_3__0 )* ) ) )
            // InternalIGES.g:746:1: ( ( ( rule__Global__Group_3__0 ) ) ( ( rule__Global__Group_3__0 )* ) )
            {
            // InternalIGES.g:746:1: ( ( ( rule__Global__Group_3__0 ) ) ( ( rule__Global__Group_3__0 )* ) )
            // InternalIGES.g:747:2: ( ( rule__Global__Group_3__0 ) ) ( ( rule__Global__Group_3__0 )* )
            {
            // InternalIGES.g:747:2: ( ( rule__Global__Group_3__0 ) )
            // InternalIGES.g:748:3: ( rule__Global__Group_3__0 )
            {
             before(grammarAccess.getGlobalAccess().getGroup_3()); 
            // InternalIGES.g:749:3: ( rule__Global__Group_3__0 )
            // InternalIGES.g:749:4: rule__Global__Group_3__0
            {
            pushFollow(FOLLOW_11);
            rule__Global__Group_3__0();

            state._fsp--;


            }

             after(grammarAccess.getGlobalAccess().getGroup_3()); 

            }

            // InternalIGES.g:752:2: ( ( rule__Global__Group_3__0 )* )
            // InternalIGES.g:753:3: ( rule__Global__Group_3__0 )*
            {
             before(grammarAccess.getGlobalAccess().getGroup_3()); 
            // InternalIGES.g:754:3: ( rule__Global__Group_3__0 )*
            loop11:
            do {
                int alt11=2;
                alt11 = dfa11.predict(input);
                switch (alt11) {
            	case 1 :
            	    // InternalIGES.g:754:4: rule__Global__Group_3__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Global__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getGlobalAccess().getGroup_3()); 

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
    // $ANTLR end "rule__Global__Group__3__Impl"


    // $ANTLR start "rule__Global__Group__4"
    // InternalIGES.g:763:1: rule__Global__Group__4 : rule__Global__Group__4__Impl rule__Global__Group__5 ;
    public final void rule__Global__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:767:1: ( rule__Global__Group__4__Impl rule__Global__Group__5 )
            // InternalIGES.g:768:2: rule__Global__Group__4__Impl rule__Global__Group__5
            {
            pushFollow(FOLLOW_10);
            rule__Global__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Global__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group__4"


    // $ANTLR start "rule__Global__Group__4__Impl"
    // InternalIGES.g:775:1: rule__Global__Group__4__Impl : ( ( rule__Global__ValuesAssignment_4 )* ) ;
    public final void rule__Global__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:779:1: ( ( ( rule__Global__ValuesAssignment_4 )* ) )
            // InternalIGES.g:780:1: ( ( rule__Global__ValuesAssignment_4 )* )
            {
            // InternalIGES.g:780:1: ( ( rule__Global__ValuesAssignment_4 )* )
            // InternalIGES.g:781:2: ( rule__Global__ValuesAssignment_4 )*
            {
             before(grammarAccess.getGlobalAccess().getValuesAssignment_4()); 
            // InternalIGES.g:782:2: ( rule__Global__ValuesAssignment_4 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_INT||(LA12_0>=RULE_HOLLERITH && LA12_0<=RULE_DOUBLE)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalIGES.g:782:3: rule__Global__ValuesAssignment_4
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Global__ValuesAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getGlobalAccess().getValuesAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group__4__Impl"


    // $ANTLR start "rule__Global__Group__5"
    // InternalIGES.g:790:1: rule__Global__Group__5 : rule__Global__Group__5__Impl rule__Global__Group__6 ;
    public final void rule__Global__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:794:1: ( rule__Global__Group__5__Impl rule__Global__Group__6 )
            // InternalIGES.g:795:2: rule__Global__Group__5__Impl rule__Global__Group__6
            {
            pushFollow(FOLLOW_12);
            rule__Global__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Global__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group__5"


    // $ANTLR start "rule__Global__Group__5__Impl"
    // InternalIGES.g:802:1: rule__Global__Group__5__Impl : ( RULE_SEPARATOR ) ;
    public final void rule__Global__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:806:1: ( ( RULE_SEPARATOR ) )
            // InternalIGES.g:807:1: ( RULE_SEPARATOR )
            {
            // InternalIGES.g:807:1: ( RULE_SEPARATOR )
            // InternalIGES.g:808:2: RULE_SEPARATOR
            {
             before(grammarAccess.getGlobalAccess().getSEPARATORTerminalRuleCall_5()); 
            match(input,RULE_SEPARATOR,FOLLOW_2); 
             after(grammarAccess.getGlobalAccess().getSEPARATORTerminalRuleCall_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group__5__Impl"


    // $ANTLR start "rule__Global__Group__6"
    // InternalIGES.g:817:1: rule__Global__Group__6 : rule__Global__Group__6__Impl rule__Global__Group__7 ;
    public final void rule__Global__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:821:1: ( rule__Global__Group__6__Impl rule__Global__Group__7 )
            // InternalIGES.g:822:2: rule__Global__Group__6__Impl rule__Global__Group__7
            {
            pushFollow(FOLLOW_12);
            rule__Global__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Global__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group__6"


    // $ANTLR start "rule__Global__Group__6__Impl"
    // InternalIGES.g:829:1: rule__Global__Group__6__Impl : ( ( RULE_WS )? ) ;
    public final void rule__Global__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:833:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:834:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:834:1: ( ( RULE_WS )? )
            // InternalIGES.g:835:2: ( RULE_WS )?
            {
             before(grammarAccess.getGlobalAccess().getWSTerminalRuleCall_6()); 
            // InternalIGES.g:836:2: ( RULE_WS )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_WS) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalIGES.g:836:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getGlobalAccess().getWSTerminalRuleCall_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group__6__Impl"


    // $ANTLR start "rule__Global__Group__7"
    // InternalIGES.g:844:1: rule__Global__Group__7 : rule__Global__Group__7__Impl rule__Global__Group__8 ;
    public final void rule__Global__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:848:1: ( rule__Global__Group__7__Impl rule__Global__Group__8 )
            // InternalIGES.g:849:2: rule__Global__Group__7__Impl rule__Global__Group__8
            {
            pushFollow(FOLLOW_13);
            rule__Global__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Global__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group__7"


    // $ANTLR start "rule__Global__Group__7__Impl"
    // InternalIGES.g:856:1: rule__Global__Group__7__Impl : ( 'G' ) ;
    public final void rule__Global__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:860:1: ( ( 'G' ) )
            // InternalIGES.g:861:1: ( 'G' )
            {
            // InternalIGES.g:861:1: ( 'G' )
            // InternalIGES.g:862:2: 'G'
            {
             before(grammarAccess.getGlobalAccess().getGKeyword_7()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getGlobalAccess().getGKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group__7__Impl"


    // $ANTLR start "rule__Global__Group__8"
    // InternalIGES.g:871:1: rule__Global__Group__8 : rule__Global__Group__8__Impl rule__Global__Group__9 ;
    public final void rule__Global__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:875:1: ( rule__Global__Group__8__Impl rule__Global__Group__9 )
            // InternalIGES.g:876:2: rule__Global__Group__8__Impl rule__Global__Group__9
            {
            pushFollow(FOLLOW_13);
            rule__Global__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Global__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group__8"


    // $ANTLR start "rule__Global__Group__8__Impl"
    // InternalIGES.g:883:1: rule__Global__Group__8__Impl : ( ( RULE_WS )? ) ;
    public final void rule__Global__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:887:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:888:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:888:1: ( ( RULE_WS )? )
            // InternalIGES.g:889:2: ( RULE_WS )?
            {
             before(grammarAccess.getGlobalAccess().getWSTerminalRuleCall_8()); 
            // InternalIGES.g:890:2: ( RULE_WS )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_WS) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalIGES.g:890:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getGlobalAccess().getWSTerminalRuleCall_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group__8__Impl"


    // $ANTLR start "rule__Global__Group__9"
    // InternalIGES.g:898:1: rule__Global__Group__9 : rule__Global__Group__9__Impl rule__Global__Group__10 ;
    public final void rule__Global__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:902:1: ( rule__Global__Group__9__Impl rule__Global__Group__10 )
            // InternalIGES.g:903:2: rule__Global__Group__9__Impl rule__Global__Group__10
            {
            pushFollow(FOLLOW_14);
            rule__Global__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Global__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group__9"


    // $ANTLR start "rule__Global__Group__9__Impl"
    // InternalIGES.g:910:1: rule__Global__Group__9__Impl : ( RULE_INT ) ;
    public final void rule__Global__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:914:1: ( ( RULE_INT ) )
            // InternalIGES.g:915:1: ( RULE_INT )
            {
            // InternalIGES.g:915:1: ( RULE_INT )
            // InternalIGES.g:916:2: RULE_INT
            {
             before(grammarAccess.getGlobalAccess().getINTTerminalRuleCall_9()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getGlobalAccess().getINTTerminalRuleCall_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group__9__Impl"


    // $ANTLR start "rule__Global__Group__10"
    // InternalIGES.g:925:1: rule__Global__Group__10 : rule__Global__Group__10__Impl ;
    public final void rule__Global__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:929:1: ( rule__Global__Group__10__Impl )
            // InternalIGES.g:930:2: rule__Global__Group__10__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Global__Group__10__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group__10"


    // $ANTLR start "rule__Global__Group__10__Impl"
    // InternalIGES.g:936:1: rule__Global__Group__10__Impl : ( RULE_ENDLINE ) ;
    public final void rule__Global__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:940:1: ( ( RULE_ENDLINE ) )
            // InternalIGES.g:941:1: ( RULE_ENDLINE )
            {
            // InternalIGES.g:941:1: ( RULE_ENDLINE )
            // InternalIGES.g:942:2: RULE_ENDLINE
            {
             before(grammarAccess.getGlobalAccess().getENDLINETerminalRuleCall_10()); 
            match(input,RULE_ENDLINE,FOLLOW_2); 
             after(grammarAccess.getGlobalAccess().getENDLINETerminalRuleCall_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group__10__Impl"


    // $ANTLR start "rule__Global__Group_3__0"
    // InternalIGES.g:952:1: rule__Global__Group_3__0 : rule__Global__Group_3__0__Impl rule__Global__Group_3__1 ;
    public final void rule__Global__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:956:1: ( rule__Global__Group_3__0__Impl rule__Global__Group_3__1 )
            // InternalIGES.g:957:2: rule__Global__Group_3__0__Impl rule__Global__Group_3__1
            {
            pushFollow(FOLLOW_12);
            rule__Global__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Global__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group_3__0"


    // $ANTLR start "rule__Global__Group_3__0__Impl"
    // InternalIGES.g:964:1: rule__Global__Group_3__0__Impl : ( ( ( rule__Global__ValuesAssignment_3_0 ) ) ( ( rule__Global__ValuesAssignment_3_0 )* ) ) ;
    public final void rule__Global__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:968:1: ( ( ( ( rule__Global__ValuesAssignment_3_0 ) ) ( ( rule__Global__ValuesAssignment_3_0 )* ) ) )
            // InternalIGES.g:969:1: ( ( ( rule__Global__ValuesAssignment_3_0 ) ) ( ( rule__Global__ValuesAssignment_3_0 )* ) )
            {
            // InternalIGES.g:969:1: ( ( ( rule__Global__ValuesAssignment_3_0 ) ) ( ( rule__Global__ValuesAssignment_3_0 )* ) )
            // InternalIGES.g:970:2: ( ( rule__Global__ValuesAssignment_3_0 ) ) ( ( rule__Global__ValuesAssignment_3_0 )* )
            {
            // InternalIGES.g:970:2: ( ( rule__Global__ValuesAssignment_3_0 ) )
            // InternalIGES.g:971:3: ( rule__Global__ValuesAssignment_3_0 )
            {
             before(grammarAccess.getGlobalAccess().getValuesAssignment_3_0()); 
            // InternalIGES.g:972:3: ( rule__Global__ValuesAssignment_3_0 )
            // InternalIGES.g:972:4: rule__Global__ValuesAssignment_3_0
            {
            pushFollow(FOLLOW_11);
            rule__Global__ValuesAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getGlobalAccess().getValuesAssignment_3_0()); 

            }

            // InternalIGES.g:975:2: ( ( rule__Global__ValuesAssignment_3_0 )* )
            // InternalIGES.g:976:3: ( rule__Global__ValuesAssignment_3_0 )*
            {
             before(grammarAccess.getGlobalAccess().getValuesAssignment_3_0()); 
            // InternalIGES.g:977:3: ( rule__Global__ValuesAssignment_3_0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_INT||(LA15_0>=RULE_HOLLERITH && LA15_0<=RULE_DOUBLE)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalIGES.g:977:4: rule__Global__ValuesAssignment_3_0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Global__ValuesAssignment_3_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getGlobalAccess().getValuesAssignment_3_0()); 

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
    // $ANTLR end "rule__Global__Group_3__0__Impl"


    // $ANTLR start "rule__Global__Group_3__1"
    // InternalIGES.g:986:1: rule__Global__Group_3__1 : rule__Global__Group_3__1__Impl rule__Global__Group_3__2 ;
    public final void rule__Global__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:990:1: ( rule__Global__Group_3__1__Impl rule__Global__Group_3__2 )
            // InternalIGES.g:991:2: rule__Global__Group_3__1__Impl rule__Global__Group_3__2
            {
            pushFollow(FOLLOW_12);
            rule__Global__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Global__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group_3__1"


    // $ANTLR start "rule__Global__Group_3__1__Impl"
    // InternalIGES.g:998:1: rule__Global__Group_3__1__Impl : ( ( RULE_WS )? ) ;
    public final void rule__Global__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1002:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:1003:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:1003:1: ( ( RULE_WS )? )
            // InternalIGES.g:1004:2: ( RULE_WS )?
            {
             before(grammarAccess.getGlobalAccess().getWSTerminalRuleCall_3_1()); 
            // InternalIGES.g:1005:2: ( RULE_WS )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_WS) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalIGES.g:1005:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getGlobalAccess().getWSTerminalRuleCall_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group_3__1__Impl"


    // $ANTLR start "rule__Global__Group_3__2"
    // InternalIGES.g:1013:1: rule__Global__Group_3__2 : rule__Global__Group_3__2__Impl rule__Global__Group_3__3 ;
    public final void rule__Global__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1017:1: ( rule__Global__Group_3__2__Impl rule__Global__Group_3__3 )
            // InternalIGES.g:1018:2: rule__Global__Group_3__2__Impl rule__Global__Group_3__3
            {
            pushFollow(FOLLOW_13);
            rule__Global__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Global__Group_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group_3__2"


    // $ANTLR start "rule__Global__Group_3__2__Impl"
    // InternalIGES.g:1025:1: rule__Global__Group_3__2__Impl : ( 'G' ) ;
    public final void rule__Global__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1029:1: ( ( 'G' ) )
            // InternalIGES.g:1030:1: ( 'G' )
            {
            // InternalIGES.g:1030:1: ( 'G' )
            // InternalIGES.g:1031:2: 'G'
            {
             before(grammarAccess.getGlobalAccess().getGKeyword_3_2()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getGlobalAccess().getGKeyword_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group_3__2__Impl"


    // $ANTLR start "rule__Global__Group_3__3"
    // InternalIGES.g:1040:1: rule__Global__Group_3__3 : rule__Global__Group_3__3__Impl rule__Global__Group_3__4 ;
    public final void rule__Global__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1044:1: ( rule__Global__Group_3__3__Impl rule__Global__Group_3__4 )
            // InternalIGES.g:1045:2: rule__Global__Group_3__3__Impl rule__Global__Group_3__4
            {
            pushFollow(FOLLOW_13);
            rule__Global__Group_3__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Global__Group_3__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group_3__3"


    // $ANTLR start "rule__Global__Group_3__3__Impl"
    // InternalIGES.g:1052:1: rule__Global__Group_3__3__Impl : ( ( RULE_WS )? ) ;
    public final void rule__Global__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1056:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:1057:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:1057:1: ( ( RULE_WS )? )
            // InternalIGES.g:1058:2: ( RULE_WS )?
            {
             before(grammarAccess.getGlobalAccess().getWSTerminalRuleCall_3_3()); 
            // InternalIGES.g:1059:2: ( RULE_WS )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_WS) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalIGES.g:1059:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getGlobalAccess().getWSTerminalRuleCall_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group_3__3__Impl"


    // $ANTLR start "rule__Global__Group_3__4"
    // InternalIGES.g:1067:1: rule__Global__Group_3__4 : rule__Global__Group_3__4__Impl rule__Global__Group_3__5 ;
    public final void rule__Global__Group_3__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1071:1: ( rule__Global__Group_3__4__Impl rule__Global__Group_3__5 )
            // InternalIGES.g:1072:2: rule__Global__Group_3__4__Impl rule__Global__Group_3__5
            {
            pushFollow(FOLLOW_14);
            rule__Global__Group_3__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Global__Group_3__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group_3__4"


    // $ANTLR start "rule__Global__Group_3__4__Impl"
    // InternalIGES.g:1079:1: rule__Global__Group_3__4__Impl : ( RULE_INT ) ;
    public final void rule__Global__Group_3__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1083:1: ( ( RULE_INT ) )
            // InternalIGES.g:1084:1: ( RULE_INT )
            {
            // InternalIGES.g:1084:1: ( RULE_INT )
            // InternalIGES.g:1085:2: RULE_INT
            {
             before(grammarAccess.getGlobalAccess().getINTTerminalRuleCall_3_4()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getGlobalAccess().getINTTerminalRuleCall_3_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group_3__4__Impl"


    // $ANTLR start "rule__Global__Group_3__5"
    // InternalIGES.g:1094:1: rule__Global__Group_3__5 : rule__Global__Group_3__5__Impl ;
    public final void rule__Global__Group_3__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1098:1: ( rule__Global__Group_3__5__Impl )
            // InternalIGES.g:1099:2: rule__Global__Group_3__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Global__Group_3__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group_3__5"


    // $ANTLR start "rule__Global__Group_3__5__Impl"
    // InternalIGES.g:1105:1: rule__Global__Group_3__5__Impl : ( RULE_ENDLINE ) ;
    public final void rule__Global__Group_3__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1109:1: ( ( RULE_ENDLINE ) )
            // InternalIGES.g:1110:1: ( RULE_ENDLINE )
            {
            // InternalIGES.g:1110:1: ( RULE_ENDLINE )
            // InternalIGES.g:1111:2: RULE_ENDLINE
            {
             before(grammarAccess.getGlobalAccess().getENDLINETerminalRuleCall_3_5()); 
            match(input,RULE_ENDLINE,FOLLOW_2); 
             after(grammarAccess.getGlobalAccess().getENDLINETerminalRuleCall_3_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__Group_3__5__Impl"


    // $ANTLR start "rule__Entry__Group__0"
    // InternalIGES.g:1121:1: rule__Entry__Group__0 : rule__Entry__Group__0__Impl rule__Entry__Group__1 ;
    public final void rule__Entry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1125:1: ( rule__Entry__Group__0__Impl rule__Entry__Group__1 )
            // InternalIGES.g:1126:2: rule__Entry__Group__0__Impl rule__Entry__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__Entry__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__0"


    // $ANTLR start "rule__Entry__Group__0__Impl"
    // InternalIGES.g:1133:1: rule__Entry__Group__0__Impl : ( RULE_WS ) ;
    public final void rule__Entry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1137:1: ( ( RULE_WS ) )
            // InternalIGES.g:1138:1: ( RULE_WS )
            {
            // InternalIGES.g:1138:1: ( RULE_WS )
            // InternalIGES.g:1139:2: RULE_WS
            {
             before(grammarAccess.getEntryAccess().getWSTerminalRuleCall_0()); 
            match(input,RULE_WS,FOLLOW_2); 
             after(grammarAccess.getEntryAccess().getWSTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__0__Impl"


    // $ANTLR start "rule__Entry__Group__1"
    // InternalIGES.g:1148:1: rule__Entry__Group__1 : rule__Entry__Group__1__Impl rule__Entry__Group__2 ;
    public final void rule__Entry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1152:1: ( rule__Entry__Group__1__Impl rule__Entry__Group__2 )
            // InternalIGES.g:1153:2: rule__Entry__Group__1__Impl rule__Entry__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__Entry__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__1"


    // $ANTLR start "rule__Entry__Group__1__Impl"
    // InternalIGES.g:1160:1: rule__Entry__Group__1__Impl : ( ( rule__Entry__TypeAssignment_1 ) ) ;
    public final void rule__Entry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1164:1: ( ( ( rule__Entry__TypeAssignment_1 ) ) )
            // InternalIGES.g:1165:1: ( ( rule__Entry__TypeAssignment_1 ) )
            {
            // InternalIGES.g:1165:1: ( ( rule__Entry__TypeAssignment_1 ) )
            // InternalIGES.g:1166:2: ( rule__Entry__TypeAssignment_1 )
            {
             before(grammarAccess.getEntryAccess().getTypeAssignment_1()); 
            // InternalIGES.g:1167:2: ( rule__Entry__TypeAssignment_1 )
            // InternalIGES.g:1167:3: rule__Entry__TypeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Entry__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEntryAccess().getTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__1__Impl"


    // $ANTLR start "rule__Entry__Group__2"
    // InternalIGES.g:1175:1: rule__Entry__Group__2 : rule__Entry__Group__2__Impl rule__Entry__Group__3 ;
    public final void rule__Entry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1179:1: ( rule__Entry__Group__2__Impl rule__Entry__Group__3 )
            // InternalIGES.g:1180:2: rule__Entry__Group__2__Impl rule__Entry__Group__3
            {
            pushFollow(FOLLOW_13);
            rule__Entry__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__2"


    // $ANTLR start "rule__Entry__Group__2__Impl"
    // InternalIGES.g:1187:1: rule__Entry__Group__2__Impl : ( ( RULE_WS )? ) ;
    public final void rule__Entry__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1191:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:1192:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:1192:1: ( ( RULE_WS )? )
            // InternalIGES.g:1193:2: ( RULE_WS )?
            {
             before(grammarAccess.getEntryAccess().getWSTerminalRuleCall_2()); 
            // InternalIGES.g:1194:2: ( RULE_WS )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_WS) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalIGES.g:1194:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEntryAccess().getWSTerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__2__Impl"


    // $ANTLR start "rule__Entry__Group__3"
    // InternalIGES.g:1202:1: rule__Entry__Group__3 : rule__Entry__Group__3__Impl rule__Entry__Group__4 ;
    public final void rule__Entry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1206:1: ( rule__Entry__Group__3__Impl rule__Entry__Group__4 )
            // InternalIGES.g:1207:2: rule__Entry__Group__3__Impl rule__Entry__Group__4
            {
            pushFollow(FOLLOW_13);
            rule__Entry__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__3"


    // $ANTLR start "rule__Entry__Group__3__Impl"
    // InternalIGES.g:1214:1: rule__Entry__Group__3__Impl : ( ( rule__Entry__ParamDataAssignment_3 ) ) ;
    public final void rule__Entry__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1218:1: ( ( ( rule__Entry__ParamDataAssignment_3 ) ) )
            // InternalIGES.g:1219:1: ( ( rule__Entry__ParamDataAssignment_3 ) )
            {
            // InternalIGES.g:1219:1: ( ( rule__Entry__ParamDataAssignment_3 ) )
            // InternalIGES.g:1220:2: ( rule__Entry__ParamDataAssignment_3 )
            {
             before(grammarAccess.getEntryAccess().getParamDataAssignment_3()); 
            // InternalIGES.g:1221:2: ( rule__Entry__ParamDataAssignment_3 )
            // InternalIGES.g:1221:3: rule__Entry__ParamDataAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Entry__ParamDataAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getEntryAccess().getParamDataAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__3__Impl"


    // $ANTLR start "rule__Entry__Group__4"
    // InternalIGES.g:1229:1: rule__Entry__Group__4 : rule__Entry__Group__4__Impl rule__Entry__Group__5 ;
    public final void rule__Entry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1233:1: ( rule__Entry__Group__4__Impl rule__Entry__Group__5 )
            // InternalIGES.g:1234:2: rule__Entry__Group__4__Impl rule__Entry__Group__5
            {
            pushFollow(FOLLOW_13);
            rule__Entry__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__4"


    // $ANTLR start "rule__Entry__Group__4__Impl"
    // InternalIGES.g:1241:1: rule__Entry__Group__4__Impl : ( ( RULE_WS )? ) ;
    public final void rule__Entry__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1245:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:1246:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:1246:1: ( ( RULE_WS )? )
            // InternalIGES.g:1247:2: ( RULE_WS )?
            {
             before(grammarAccess.getEntryAccess().getWSTerminalRuleCall_4()); 
            // InternalIGES.g:1248:2: ( RULE_WS )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_WS) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalIGES.g:1248:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEntryAccess().getWSTerminalRuleCall_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__4__Impl"


    // $ANTLR start "rule__Entry__Group__5"
    // InternalIGES.g:1256:1: rule__Entry__Group__5 : rule__Entry__Group__5__Impl rule__Entry__Group__6 ;
    public final void rule__Entry__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1260:1: ( rule__Entry__Group__5__Impl rule__Entry__Group__6 )
            // InternalIGES.g:1261:2: rule__Entry__Group__5__Impl rule__Entry__Group__6
            {
            pushFollow(FOLLOW_13);
            rule__Entry__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__5"


    // $ANTLR start "rule__Entry__Group__5__Impl"
    // InternalIGES.g:1268:1: rule__Entry__Group__5__Impl : ( ( rule__Entry__StructureAssignment_5 ) ) ;
    public final void rule__Entry__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1272:1: ( ( ( rule__Entry__StructureAssignment_5 ) ) )
            // InternalIGES.g:1273:1: ( ( rule__Entry__StructureAssignment_5 ) )
            {
            // InternalIGES.g:1273:1: ( ( rule__Entry__StructureAssignment_5 ) )
            // InternalIGES.g:1274:2: ( rule__Entry__StructureAssignment_5 )
            {
             before(grammarAccess.getEntryAccess().getStructureAssignment_5()); 
            // InternalIGES.g:1275:2: ( rule__Entry__StructureAssignment_5 )
            // InternalIGES.g:1275:3: rule__Entry__StructureAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Entry__StructureAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getEntryAccess().getStructureAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__5__Impl"


    // $ANTLR start "rule__Entry__Group__6"
    // InternalIGES.g:1283:1: rule__Entry__Group__6 : rule__Entry__Group__6__Impl rule__Entry__Group__7 ;
    public final void rule__Entry__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1287:1: ( rule__Entry__Group__6__Impl rule__Entry__Group__7 )
            // InternalIGES.g:1288:2: rule__Entry__Group__6__Impl rule__Entry__Group__7
            {
            pushFollow(FOLLOW_13);
            rule__Entry__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__6"


    // $ANTLR start "rule__Entry__Group__6__Impl"
    // InternalIGES.g:1295:1: rule__Entry__Group__6__Impl : ( ( RULE_WS )? ) ;
    public final void rule__Entry__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1299:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:1300:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:1300:1: ( ( RULE_WS )? )
            // InternalIGES.g:1301:2: ( RULE_WS )?
            {
             before(grammarAccess.getEntryAccess().getWSTerminalRuleCall_6()); 
            // InternalIGES.g:1302:2: ( RULE_WS )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_WS) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalIGES.g:1302:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEntryAccess().getWSTerminalRuleCall_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__6__Impl"


    // $ANTLR start "rule__Entry__Group__7"
    // InternalIGES.g:1310:1: rule__Entry__Group__7 : rule__Entry__Group__7__Impl rule__Entry__Group__8 ;
    public final void rule__Entry__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1314:1: ( rule__Entry__Group__7__Impl rule__Entry__Group__8 )
            // InternalIGES.g:1315:2: rule__Entry__Group__7__Impl rule__Entry__Group__8
            {
            pushFollow(FOLLOW_13);
            rule__Entry__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__7"


    // $ANTLR start "rule__Entry__Group__7__Impl"
    // InternalIGES.g:1322:1: rule__Entry__Group__7__Impl : ( ( rule__Entry__LineFontAssignment_7 ) ) ;
    public final void rule__Entry__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1326:1: ( ( ( rule__Entry__LineFontAssignment_7 ) ) )
            // InternalIGES.g:1327:1: ( ( rule__Entry__LineFontAssignment_7 ) )
            {
            // InternalIGES.g:1327:1: ( ( rule__Entry__LineFontAssignment_7 ) )
            // InternalIGES.g:1328:2: ( rule__Entry__LineFontAssignment_7 )
            {
             before(grammarAccess.getEntryAccess().getLineFontAssignment_7()); 
            // InternalIGES.g:1329:2: ( rule__Entry__LineFontAssignment_7 )
            // InternalIGES.g:1329:3: rule__Entry__LineFontAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Entry__LineFontAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getEntryAccess().getLineFontAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__7__Impl"


    // $ANTLR start "rule__Entry__Group__8"
    // InternalIGES.g:1337:1: rule__Entry__Group__8 : rule__Entry__Group__8__Impl rule__Entry__Group__9 ;
    public final void rule__Entry__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1341:1: ( rule__Entry__Group__8__Impl rule__Entry__Group__9 )
            // InternalIGES.g:1342:2: rule__Entry__Group__8__Impl rule__Entry__Group__9
            {
            pushFollow(FOLLOW_13);
            rule__Entry__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__8"


    // $ANTLR start "rule__Entry__Group__8__Impl"
    // InternalIGES.g:1349:1: rule__Entry__Group__8__Impl : ( ( RULE_WS )? ) ;
    public final void rule__Entry__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1353:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:1354:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:1354:1: ( ( RULE_WS )? )
            // InternalIGES.g:1355:2: ( RULE_WS )?
            {
             before(grammarAccess.getEntryAccess().getWSTerminalRuleCall_8()); 
            // InternalIGES.g:1356:2: ( RULE_WS )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_WS) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalIGES.g:1356:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEntryAccess().getWSTerminalRuleCall_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__8__Impl"


    // $ANTLR start "rule__Entry__Group__9"
    // InternalIGES.g:1364:1: rule__Entry__Group__9 : rule__Entry__Group__9__Impl rule__Entry__Group__10 ;
    public final void rule__Entry__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1368:1: ( rule__Entry__Group__9__Impl rule__Entry__Group__10 )
            // InternalIGES.g:1369:2: rule__Entry__Group__9__Impl rule__Entry__Group__10
            {
            pushFollow(FOLLOW_13);
            rule__Entry__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__9"


    // $ANTLR start "rule__Entry__Group__9__Impl"
    // InternalIGES.g:1376:1: rule__Entry__Group__9__Impl : ( ( rule__Entry__LevelAssignment_9 ) ) ;
    public final void rule__Entry__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1380:1: ( ( ( rule__Entry__LevelAssignment_9 ) ) )
            // InternalIGES.g:1381:1: ( ( rule__Entry__LevelAssignment_9 ) )
            {
            // InternalIGES.g:1381:1: ( ( rule__Entry__LevelAssignment_9 ) )
            // InternalIGES.g:1382:2: ( rule__Entry__LevelAssignment_9 )
            {
             before(grammarAccess.getEntryAccess().getLevelAssignment_9()); 
            // InternalIGES.g:1383:2: ( rule__Entry__LevelAssignment_9 )
            // InternalIGES.g:1383:3: rule__Entry__LevelAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__Entry__LevelAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getEntryAccess().getLevelAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__9__Impl"


    // $ANTLR start "rule__Entry__Group__10"
    // InternalIGES.g:1391:1: rule__Entry__Group__10 : rule__Entry__Group__10__Impl rule__Entry__Group__11 ;
    public final void rule__Entry__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1395:1: ( rule__Entry__Group__10__Impl rule__Entry__Group__11 )
            // InternalIGES.g:1396:2: rule__Entry__Group__10__Impl rule__Entry__Group__11
            {
            pushFollow(FOLLOW_13);
            rule__Entry__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__10"


    // $ANTLR start "rule__Entry__Group__10__Impl"
    // InternalIGES.g:1403:1: rule__Entry__Group__10__Impl : ( ( RULE_WS )? ) ;
    public final void rule__Entry__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1407:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:1408:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:1408:1: ( ( RULE_WS )? )
            // InternalIGES.g:1409:2: ( RULE_WS )?
            {
             before(grammarAccess.getEntryAccess().getWSTerminalRuleCall_10()); 
            // InternalIGES.g:1410:2: ( RULE_WS )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_WS) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalIGES.g:1410:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEntryAccess().getWSTerminalRuleCall_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__10__Impl"


    // $ANTLR start "rule__Entry__Group__11"
    // InternalIGES.g:1418:1: rule__Entry__Group__11 : rule__Entry__Group__11__Impl rule__Entry__Group__12 ;
    public final void rule__Entry__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1422:1: ( rule__Entry__Group__11__Impl rule__Entry__Group__12 )
            // InternalIGES.g:1423:2: rule__Entry__Group__11__Impl rule__Entry__Group__12
            {
            pushFollow(FOLLOW_13);
            rule__Entry__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__11"


    // $ANTLR start "rule__Entry__Group__11__Impl"
    // InternalIGES.g:1430:1: rule__Entry__Group__11__Impl : ( ( rule__Entry__ViewAssignment_11 ) ) ;
    public final void rule__Entry__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1434:1: ( ( ( rule__Entry__ViewAssignment_11 ) ) )
            // InternalIGES.g:1435:1: ( ( rule__Entry__ViewAssignment_11 ) )
            {
            // InternalIGES.g:1435:1: ( ( rule__Entry__ViewAssignment_11 ) )
            // InternalIGES.g:1436:2: ( rule__Entry__ViewAssignment_11 )
            {
             before(grammarAccess.getEntryAccess().getViewAssignment_11()); 
            // InternalIGES.g:1437:2: ( rule__Entry__ViewAssignment_11 )
            // InternalIGES.g:1437:3: rule__Entry__ViewAssignment_11
            {
            pushFollow(FOLLOW_2);
            rule__Entry__ViewAssignment_11();

            state._fsp--;


            }

             after(grammarAccess.getEntryAccess().getViewAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__11__Impl"


    // $ANTLR start "rule__Entry__Group__12"
    // InternalIGES.g:1445:1: rule__Entry__Group__12 : rule__Entry__Group__12__Impl rule__Entry__Group__13 ;
    public final void rule__Entry__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1449:1: ( rule__Entry__Group__12__Impl rule__Entry__Group__13 )
            // InternalIGES.g:1450:2: rule__Entry__Group__12__Impl rule__Entry__Group__13
            {
            pushFollow(FOLLOW_13);
            rule__Entry__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__12"


    // $ANTLR start "rule__Entry__Group__12__Impl"
    // InternalIGES.g:1457:1: rule__Entry__Group__12__Impl : ( ( RULE_WS )? ) ;
    public final void rule__Entry__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1461:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:1462:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:1462:1: ( ( RULE_WS )? )
            // InternalIGES.g:1463:2: ( RULE_WS )?
            {
             before(grammarAccess.getEntryAccess().getWSTerminalRuleCall_12()); 
            // InternalIGES.g:1464:2: ( RULE_WS )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_WS) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalIGES.g:1464:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEntryAccess().getWSTerminalRuleCall_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__12__Impl"


    // $ANTLR start "rule__Entry__Group__13"
    // InternalIGES.g:1472:1: rule__Entry__Group__13 : rule__Entry__Group__13__Impl rule__Entry__Group__14 ;
    public final void rule__Entry__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1476:1: ( rule__Entry__Group__13__Impl rule__Entry__Group__14 )
            // InternalIGES.g:1477:2: rule__Entry__Group__13__Impl rule__Entry__Group__14
            {
            pushFollow(FOLLOW_13);
            rule__Entry__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__13"


    // $ANTLR start "rule__Entry__Group__13__Impl"
    // InternalIGES.g:1484:1: rule__Entry__Group__13__Impl : ( ( rule__Entry__TransformMatrixAssignment_13 ) ) ;
    public final void rule__Entry__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1488:1: ( ( ( rule__Entry__TransformMatrixAssignment_13 ) ) )
            // InternalIGES.g:1489:1: ( ( rule__Entry__TransformMatrixAssignment_13 ) )
            {
            // InternalIGES.g:1489:1: ( ( rule__Entry__TransformMatrixAssignment_13 ) )
            // InternalIGES.g:1490:2: ( rule__Entry__TransformMatrixAssignment_13 )
            {
             before(grammarAccess.getEntryAccess().getTransformMatrixAssignment_13()); 
            // InternalIGES.g:1491:2: ( rule__Entry__TransformMatrixAssignment_13 )
            // InternalIGES.g:1491:3: rule__Entry__TransformMatrixAssignment_13
            {
            pushFollow(FOLLOW_2);
            rule__Entry__TransformMatrixAssignment_13();

            state._fsp--;


            }

             after(grammarAccess.getEntryAccess().getTransformMatrixAssignment_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__13__Impl"


    // $ANTLR start "rule__Entry__Group__14"
    // InternalIGES.g:1499:1: rule__Entry__Group__14 : rule__Entry__Group__14__Impl rule__Entry__Group__15 ;
    public final void rule__Entry__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1503:1: ( rule__Entry__Group__14__Impl rule__Entry__Group__15 )
            // InternalIGES.g:1504:2: rule__Entry__Group__14__Impl rule__Entry__Group__15
            {
            pushFollow(FOLLOW_13);
            rule__Entry__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__15();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__14"


    // $ANTLR start "rule__Entry__Group__14__Impl"
    // InternalIGES.g:1511:1: rule__Entry__Group__14__Impl : ( ( RULE_WS )? ) ;
    public final void rule__Entry__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1515:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:1516:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:1516:1: ( ( RULE_WS )? )
            // InternalIGES.g:1517:2: ( RULE_WS )?
            {
             before(grammarAccess.getEntryAccess().getWSTerminalRuleCall_14()); 
            // InternalIGES.g:1518:2: ( RULE_WS )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_WS) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalIGES.g:1518:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEntryAccess().getWSTerminalRuleCall_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__14__Impl"


    // $ANTLR start "rule__Entry__Group__15"
    // InternalIGES.g:1526:1: rule__Entry__Group__15 : rule__Entry__Group__15__Impl rule__Entry__Group__16 ;
    public final void rule__Entry__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1530:1: ( rule__Entry__Group__15__Impl rule__Entry__Group__16 )
            // InternalIGES.g:1531:2: rule__Entry__Group__15__Impl rule__Entry__Group__16
            {
            pushFollow(FOLLOW_13);
            rule__Entry__Group__15__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__16();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__15"


    // $ANTLR start "rule__Entry__Group__15__Impl"
    // InternalIGES.g:1538:1: rule__Entry__Group__15__Impl : ( ( RULE_INT )? ) ;
    public final void rule__Entry__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1542:1: ( ( ( RULE_INT )? ) )
            // InternalIGES.g:1543:1: ( ( RULE_INT )? )
            {
            // InternalIGES.g:1543:1: ( ( RULE_INT )? )
            // InternalIGES.g:1544:2: ( RULE_INT )?
            {
             before(grammarAccess.getEntryAccess().getINTTerminalRuleCall_15()); 
            // InternalIGES.g:1545:2: ( RULE_INT )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_INT) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==RULE_INT||LA25_1==RULE_WS) ) {
                    alt25=1;
                }
            }
            switch (alt25) {
                case 1 :
                    // InternalIGES.g:1545:3: RULE_INT
                    {
                    match(input,RULE_INT,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEntryAccess().getINTTerminalRuleCall_15()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__15__Impl"


    // $ANTLR start "rule__Entry__Group__16"
    // InternalIGES.g:1553:1: rule__Entry__Group__16 : rule__Entry__Group__16__Impl rule__Entry__Group__17 ;
    public final void rule__Entry__Group__16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1557:1: ( rule__Entry__Group__16__Impl rule__Entry__Group__17 )
            // InternalIGES.g:1558:2: rule__Entry__Group__16__Impl rule__Entry__Group__17
            {
            pushFollow(FOLLOW_13);
            rule__Entry__Group__16__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__17();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__16"


    // $ANTLR start "rule__Entry__Group__16__Impl"
    // InternalIGES.g:1565:1: rule__Entry__Group__16__Impl : ( ( RULE_WS )? ) ;
    public final void rule__Entry__Group__16__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1569:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:1570:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:1570:1: ( ( RULE_WS )? )
            // InternalIGES.g:1571:2: ( RULE_WS )?
            {
             before(grammarAccess.getEntryAccess().getWSTerminalRuleCall_16()); 
            // InternalIGES.g:1572:2: ( RULE_WS )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_WS) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalIGES.g:1572:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEntryAccess().getWSTerminalRuleCall_16()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__16__Impl"


    // $ANTLR start "rule__Entry__Group__17"
    // InternalIGES.g:1580:1: rule__Entry__Group__17 : rule__Entry__Group__17__Impl rule__Entry__Group__18 ;
    public final void rule__Entry__Group__17() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1584:1: ( rule__Entry__Group__17__Impl rule__Entry__Group__18 )
            // InternalIGES.g:1585:2: rule__Entry__Group__17__Impl rule__Entry__Group__18
            {
            pushFollow(FOLLOW_15);
            rule__Entry__Group__17__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__18();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__17"


    // $ANTLR start "rule__Entry__Group__17__Impl"
    // InternalIGES.g:1592:1: rule__Entry__Group__17__Impl : ( ( rule__Entry__StatusAssignment_17 ) ) ;
    public final void rule__Entry__Group__17__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1596:1: ( ( ( rule__Entry__StatusAssignment_17 ) ) )
            // InternalIGES.g:1597:1: ( ( rule__Entry__StatusAssignment_17 ) )
            {
            // InternalIGES.g:1597:1: ( ( rule__Entry__StatusAssignment_17 ) )
            // InternalIGES.g:1598:2: ( rule__Entry__StatusAssignment_17 )
            {
             before(grammarAccess.getEntryAccess().getStatusAssignment_17()); 
            // InternalIGES.g:1599:2: ( rule__Entry__StatusAssignment_17 )
            // InternalIGES.g:1599:3: rule__Entry__StatusAssignment_17
            {
            pushFollow(FOLLOW_2);
            rule__Entry__StatusAssignment_17();

            state._fsp--;


            }

             after(grammarAccess.getEntryAccess().getStatusAssignment_17()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__17__Impl"


    // $ANTLR start "rule__Entry__Group__18"
    // InternalIGES.g:1607:1: rule__Entry__Group__18 : rule__Entry__Group__18__Impl rule__Entry__Group__19 ;
    public final void rule__Entry__Group__18() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1611:1: ( rule__Entry__Group__18__Impl rule__Entry__Group__19 )
            // InternalIGES.g:1612:2: rule__Entry__Group__18__Impl rule__Entry__Group__19
            {
            pushFollow(FOLLOW_13);
            rule__Entry__Group__18__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__19();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__18"


    // $ANTLR start "rule__Entry__Group__18__Impl"
    // InternalIGES.g:1619:1: rule__Entry__Group__18__Impl : ( 'D' ) ;
    public final void rule__Entry__Group__18__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1623:1: ( ( 'D' ) )
            // InternalIGES.g:1624:1: ( 'D' )
            {
            // InternalIGES.g:1624:1: ( 'D' )
            // InternalIGES.g:1625:2: 'D'
            {
             before(grammarAccess.getEntryAccess().getDKeyword_18()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getEntryAccess().getDKeyword_18()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__18__Impl"


    // $ANTLR start "rule__Entry__Group__19"
    // InternalIGES.g:1634:1: rule__Entry__Group__19 : rule__Entry__Group__19__Impl rule__Entry__Group__20 ;
    public final void rule__Entry__Group__19() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1638:1: ( rule__Entry__Group__19__Impl rule__Entry__Group__20 )
            // InternalIGES.g:1639:2: rule__Entry__Group__19__Impl rule__Entry__Group__20
            {
            pushFollow(FOLLOW_13);
            rule__Entry__Group__19__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__20();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__19"


    // $ANTLR start "rule__Entry__Group__19__Impl"
    // InternalIGES.g:1646:1: rule__Entry__Group__19__Impl : ( ( RULE_WS )? ) ;
    public final void rule__Entry__Group__19__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1650:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:1651:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:1651:1: ( ( RULE_WS )? )
            // InternalIGES.g:1652:2: ( RULE_WS )?
            {
             before(grammarAccess.getEntryAccess().getWSTerminalRuleCall_19()); 
            // InternalIGES.g:1653:2: ( RULE_WS )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_WS) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalIGES.g:1653:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEntryAccess().getWSTerminalRuleCall_19()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__19__Impl"


    // $ANTLR start "rule__Entry__Group__20"
    // InternalIGES.g:1661:1: rule__Entry__Group__20 : rule__Entry__Group__20__Impl rule__Entry__Group__21 ;
    public final void rule__Entry__Group__20() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1665:1: ( rule__Entry__Group__20__Impl rule__Entry__Group__21 )
            // InternalIGES.g:1666:2: rule__Entry__Group__20__Impl rule__Entry__Group__21
            {
            pushFollow(FOLLOW_14);
            rule__Entry__Group__20__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__21();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__20"


    // $ANTLR start "rule__Entry__Group__20__Impl"
    // InternalIGES.g:1673:1: rule__Entry__Group__20__Impl : ( ( rule__Entry__IndexAssignment_20 ) ) ;
    public final void rule__Entry__Group__20__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1677:1: ( ( ( rule__Entry__IndexAssignment_20 ) ) )
            // InternalIGES.g:1678:1: ( ( rule__Entry__IndexAssignment_20 ) )
            {
            // InternalIGES.g:1678:1: ( ( rule__Entry__IndexAssignment_20 ) )
            // InternalIGES.g:1679:2: ( rule__Entry__IndexAssignment_20 )
            {
             before(grammarAccess.getEntryAccess().getIndexAssignment_20()); 
            // InternalIGES.g:1680:2: ( rule__Entry__IndexAssignment_20 )
            // InternalIGES.g:1680:3: rule__Entry__IndexAssignment_20
            {
            pushFollow(FOLLOW_2);
            rule__Entry__IndexAssignment_20();

            state._fsp--;


            }

             after(grammarAccess.getEntryAccess().getIndexAssignment_20()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__20__Impl"


    // $ANTLR start "rule__Entry__Group__21"
    // InternalIGES.g:1688:1: rule__Entry__Group__21 : rule__Entry__Group__21__Impl rule__Entry__Group__22 ;
    public final void rule__Entry__Group__21() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1692:1: ( rule__Entry__Group__21__Impl rule__Entry__Group__22 )
            // InternalIGES.g:1693:2: rule__Entry__Group__21__Impl rule__Entry__Group__22
            {
            pushFollow(FOLLOW_13);
            rule__Entry__Group__21__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__22();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__21"


    // $ANTLR start "rule__Entry__Group__21__Impl"
    // InternalIGES.g:1700:1: rule__Entry__Group__21__Impl : ( RULE_ENDLINE ) ;
    public final void rule__Entry__Group__21__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1704:1: ( ( RULE_ENDLINE ) )
            // InternalIGES.g:1705:1: ( RULE_ENDLINE )
            {
            // InternalIGES.g:1705:1: ( RULE_ENDLINE )
            // InternalIGES.g:1706:2: RULE_ENDLINE
            {
             before(grammarAccess.getEntryAccess().getENDLINETerminalRuleCall_21()); 
            match(input,RULE_ENDLINE,FOLLOW_2); 
             after(grammarAccess.getEntryAccess().getENDLINETerminalRuleCall_21()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__21__Impl"


    // $ANTLR start "rule__Entry__Group__22"
    // InternalIGES.g:1715:1: rule__Entry__Group__22 : rule__Entry__Group__22__Impl rule__Entry__Group__23 ;
    public final void rule__Entry__Group__22() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1719:1: ( rule__Entry__Group__22__Impl rule__Entry__Group__23 )
            // InternalIGES.g:1720:2: rule__Entry__Group__22__Impl rule__Entry__Group__23
            {
            pushFollow(FOLLOW_13);
            rule__Entry__Group__22__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__23();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__22"


    // $ANTLR start "rule__Entry__Group__22__Impl"
    // InternalIGES.g:1727:1: rule__Entry__Group__22__Impl : ( ( RULE_WS )? ) ;
    public final void rule__Entry__Group__22__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1731:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:1732:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:1732:1: ( ( RULE_WS )? )
            // InternalIGES.g:1733:2: ( RULE_WS )?
            {
             before(grammarAccess.getEntryAccess().getWSTerminalRuleCall_22()); 
            // InternalIGES.g:1734:2: ( RULE_WS )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_WS) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalIGES.g:1734:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEntryAccess().getWSTerminalRuleCall_22()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__22__Impl"


    // $ANTLR start "rule__Entry__Group__23"
    // InternalIGES.g:1742:1: rule__Entry__Group__23 : rule__Entry__Group__23__Impl rule__Entry__Group__24 ;
    public final void rule__Entry__Group__23() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1746:1: ( rule__Entry__Group__23__Impl rule__Entry__Group__24 )
            // InternalIGES.g:1747:2: rule__Entry__Group__23__Impl rule__Entry__Group__24
            {
            pushFollow(FOLLOW_13);
            rule__Entry__Group__23__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__24();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__23"


    // $ANTLR start "rule__Entry__Group__23__Impl"
    // InternalIGES.g:1754:1: rule__Entry__Group__23__Impl : ( RULE_INT ) ;
    public final void rule__Entry__Group__23__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1758:1: ( ( RULE_INT ) )
            // InternalIGES.g:1759:1: ( RULE_INT )
            {
            // InternalIGES.g:1759:1: ( RULE_INT )
            // InternalIGES.g:1760:2: RULE_INT
            {
             before(grammarAccess.getEntryAccess().getINTTerminalRuleCall_23()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEntryAccess().getINTTerminalRuleCall_23()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__23__Impl"


    // $ANTLR start "rule__Entry__Group__24"
    // InternalIGES.g:1769:1: rule__Entry__Group__24 : rule__Entry__Group__24__Impl rule__Entry__Group__25 ;
    public final void rule__Entry__Group__24() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1773:1: ( rule__Entry__Group__24__Impl rule__Entry__Group__25 )
            // InternalIGES.g:1774:2: rule__Entry__Group__24__Impl rule__Entry__Group__25
            {
            pushFollow(FOLLOW_13);
            rule__Entry__Group__24__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__25();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__24"


    // $ANTLR start "rule__Entry__Group__24__Impl"
    // InternalIGES.g:1781:1: rule__Entry__Group__24__Impl : ( ( RULE_WS )? ) ;
    public final void rule__Entry__Group__24__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1785:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:1786:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:1786:1: ( ( RULE_WS )? )
            // InternalIGES.g:1787:2: ( RULE_WS )?
            {
             before(grammarAccess.getEntryAccess().getWSTerminalRuleCall_24()); 
            // InternalIGES.g:1788:2: ( RULE_WS )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_WS) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalIGES.g:1788:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEntryAccess().getWSTerminalRuleCall_24()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__24__Impl"


    // $ANTLR start "rule__Entry__Group__25"
    // InternalIGES.g:1796:1: rule__Entry__Group__25 : rule__Entry__Group__25__Impl rule__Entry__Group__26 ;
    public final void rule__Entry__Group__25() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1800:1: ( rule__Entry__Group__25__Impl rule__Entry__Group__26 )
            // InternalIGES.g:1801:2: rule__Entry__Group__25__Impl rule__Entry__Group__26
            {
            pushFollow(FOLLOW_13);
            rule__Entry__Group__25__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__26();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__25"


    // $ANTLR start "rule__Entry__Group__25__Impl"
    // InternalIGES.g:1808:1: rule__Entry__Group__25__Impl : ( ( rule__Entry__LineWeightAssignment_25 ) ) ;
    public final void rule__Entry__Group__25__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1812:1: ( ( ( rule__Entry__LineWeightAssignment_25 ) ) )
            // InternalIGES.g:1813:1: ( ( rule__Entry__LineWeightAssignment_25 ) )
            {
            // InternalIGES.g:1813:1: ( ( rule__Entry__LineWeightAssignment_25 ) )
            // InternalIGES.g:1814:2: ( rule__Entry__LineWeightAssignment_25 )
            {
             before(grammarAccess.getEntryAccess().getLineWeightAssignment_25()); 
            // InternalIGES.g:1815:2: ( rule__Entry__LineWeightAssignment_25 )
            // InternalIGES.g:1815:3: rule__Entry__LineWeightAssignment_25
            {
            pushFollow(FOLLOW_2);
            rule__Entry__LineWeightAssignment_25();

            state._fsp--;


            }

             after(grammarAccess.getEntryAccess().getLineWeightAssignment_25()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__25__Impl"


    // $ANTLR start "rule__Entry__Group__26"
    // InternalIGES.g:1823:1: rule__Entry__Group__26 : rule__Entry__Group__26__Impl rule__Entry__Group__27 ;
    public final void rule__Entry__Group__26() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1827:1: ( rule__Entry__Group__26__Impl rule__Entry__Group__27 )
            // InternalIGES.g:1828:2: rule__Entry__Group__26__Impl rule__Entry__Group__27
            {
            pushFollow(FOLLOW_13);
            rule__Entry__Group__26__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__27();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__26"


    // $ANTLR start "rule__Entry__Group__26__Impl"
    // InternalIGES.g:1835:1: rule__Entry__Group__26__Impl : ( ( RULE_WS )? ) ;
    public final void rule__Entry__Group__26__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1839:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:1840:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:1840:1: ( ( RULE_WS )? )
            // InternalIGES.g:1841:2: ( RULE_WS )?
            {
             before(grammarAccess.getEntryAccess().getWSTerminalRuleCall_26()); 
            // InternalIGES.g:1842:2: ( RULE_WS )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_WS) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalIGES.g:1842:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEntryAccess().getWSTerminalRuleCall_26()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__26__Impl"


    // $ANTLR start "rule__Entry__Group__27"
    // InternalIGES.g:1850:1: rule__Entry__Group__27 : rule__Entry__Group__27__Impl rule__Entry__Group__28 ;
    public final void rule__Entry__Group__27() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1854:1: ( rule__Entry__Group__27__Impl rule__Entry__Group__28 )
            // InternalIGES.g:1855:2: rule__Entry__Group__27__Impl rule__Entry__Group__28
            {
            pushFollow(FOLLOW_13);
            rule__Entry__Group__27__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__28();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__27"


    // $ANTLR start "rule__Entry__Group__27__Impl"
    // InternalIGES.g:1862:1: rule__Entry__Group__27__Impl : ( ( rule__Entry__ColorAssignment_27 ) ) ;
    public final void rule__Entry__Group__27__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1866:1: ( ( ( rule__Entry__ColorAssignment_27 ) ) )
            // InternalIGES.g:1867:1: ( ( rule__Entry__ColorAssignment_27 ) )
            {
            // InternalIGES.g:1867:1: ( ( rule__Entry__ColorAssignment_27 ) )
            // InternalIGES.g:1868:2: ( rule__Entry__ColorAssignment_27 )
            {
             before(grammarAccess.getEntryAccess().getColorAssignment_27()); 
            // InternalIGES.g:1869:2: ( rule__Entry__ColorAssignment_27 )
            // InternalIGES.g:1869:3: rule__Entry__ColorAssignment_27
            {
            pushFollow(FOLLOW_2);
            rule__Entry__ColorAssignment_27();

            state._fsp--;


            }

             after(grammarAccess.getEntryAccess().getColorAssignment_27()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__27__Impl"


    // $ANTLR start "rule__Entry__Group__28"
    // InternalIGES.g:1877:1: rule__Entry__Group__28 : rule__Entry__Group__28__Impl rule__Entry__Group__29 ;
    public final void rule__Entry__Group__28() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1881:1: ( rule__Entry__Group__28__Impl rule__Entry__Group__29 )
            // InternalIGES.g:1882:2: rule__Entry__Group__28__Impl rule__Entry__Group__29
            {
            pushFollow(FOLLOW_13);
            rule__Entry__Group__28__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__29();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__28"


    // $ANTLR start "rule__Entry__Group__28__Impl"
    // InternalIGES.g:1889:1: rule__Entry__Group__28__Impl : ( ( RULE_WS )? ) ;
    public final void rule__Entry__Group__28__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1893:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:1894:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:1894:1: ( ( RULE_WS )? )
            // InternalIGES.g:1895:2: ( RULE_WS )?
            {
             before(grammarAccess.getEntryAccess().getWSTerminalRuleCall_28()); 
            // InternalIGES.g:1896:2: ( RULE_WS )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_WS) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalIGES.g:1896:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEntryAccess().getWSTerminalRuleCall_28()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__28__Impl"


    // $ANTLR start "rule__Entry__Group__29"
    // InternalIGES.g:1904:1: rule__Entry__Group__29 : rule__Entry__Group__29__Impl rule__Entry__Group__30 ;
    public final void rule__Entry__Group__29() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1908:1: ( rule__Entry__Group__29__Impl rule__Entry__Group__30 )
            // InternalIGES.g:1909:2: rule__Entry__Group__29__Impl rule__Entry__Group__30
            {
            pushFollow(FOLLOW_13);
            rule__Entry__Group__29__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__30();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__29"


    // $ANTLR start "rule__Entry__Group__29__Impl"
    // InternalIGES.g:1916:1: rule__Entry__Group__29__Impl : ( ( rule__Entry__ParamLinesAssignment_29 ) ) ;
    public final void rule__Entry__Group__29__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1920:1: ( ( ( rule__Entry__ParamLinesAssignment_29 ) ) )
            // InternalIGES.g:1921:1: ( ( rule__Entry__ParamLinesAssignment_29 ) )
            {
            // InternalIGES.g:1921:1: ( ( rule__Entry__ParamLinesAssignment_29 ) )
            // InternalIGES.g:1922:2: ( rule__Entry__ParamLinesAssignment_29 )
            {
             before(grammarAccess.getEntryAccess().getParamLinesAssignment_29()); 
            // InternalIGES.g:1923:2: ( rule__Entry__ParamLinesAssignment_29 )
            // InternalIGES.g:1923:3: rule__Entry__ParamLinesAssignment_29
            {
            pushFollow(FOLLOW_2);
            rule__Entry__ParamLinesAssignment_29();

            state._fsp--;


            }

             after(grammarAccess.getEntryAccess().getParamLinesAssignment_29()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__29__Impl"


    // $ANTLR start "rule__Entry__Group__30"
    // InternalIGES.g:1931:1: rule__Entry__Group__30 : rule__Entry__Group__30__Impl rule__Entry__Group__31 ;
    public final void rule__Entry__Group__30() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1935:1: ( rule__Entry__Group__30__Impl rule__Entry__Group__31 )
            // InternalIGES.g:1936:2: rule__Entry__Group__30__Impl rule__Entry__Group__31
            {
            pushFollow(FOLLOW_13);
            rule__Entry__Group__30__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__31();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__30"


    // $ANTLR start "rule__Entry__Group__30__Impl"
    // InternalIGES.g:1943:1: rule__Entry__Group__30__Impl : ( ( RULE_WS )? ) ;
    public final void rule__Entry__Group__30__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1947:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:1948:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:1948:1: ( ( RULE_WS )? )
            // InternalIGES.g:1949:2: ( RULE_WS )?
            {
             before(grammarAccess.getEntryAccess().getWSTerminalRuleCall_30()); 
            // InternalIGES.g:1950:2: ( RULE_WS )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_WS) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalIGES.g:1950:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEntryAccess().getWSTerminalRuleCall_30()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__30__Impl"


    // $ANTLR start "rule__Entry__Group__31"
    // InternalIGES.g:1958:1: rule__Entry__Group__31 : rule__Entry__Group__31__Impl rule__Entry__Group__32 ;
    public final void rule__Entry__Group__31() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1962:1: ( rule__Entry__Group__31__Impl rule__Entry__Group__32 )
            // InternalIGES.g:1963:2: rule__Entry__Group__31__Impl rule__Entry__Group__32
            {
            pushFollow(FOLLOW_16);
            rule__Entry__Group__31__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__32();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__31"


    // $ANTLR start "rule__Entry__Group__31__Impl"
    // InternalIGES.g:1970:1: rule__Entry__Group__31__Impl : ( ( rule__Entry__FormAssignment_31 ) ) ;
    public final void rule__Entry__Group__31__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1974:1: ( ( ( rule__Entry__FormAssignment_31 ) ) )
            // InternalIGES.g:1975:1: ( ( rule__Entry__FormAssignment_31 ) )
            {
            // InternalIGES.g:1975:1: ( ( rule__Entry__FormAssignment_31 ) )
            // InternalIGES.g:1976:2: ( rule__Entry__FormAssignment_31 )
            {
             before(grammarAccess.getEntryAccess().getFormAssignment_31()); 
            // InternalIGES.g:1977:2: ( rule__Entry__FormAssignment_31 )
            // InternalIGES.g:1977:3: rule__Entry__FormAssignment_31
            {
            pushFollow(FOLLOW_2);
            rule__Entry__FormAssignment_31();

            state._fsp--;


            }

             after(grammarAccess.getEntryAccess().getFormAssignment_31()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__31__Impl"


    // $ANTLR start "rule__Entry__Group__32"
    // InternalIGES.g:1985:1: rule__Entry__Group__32 : rule__Entry__Group__32__Impl rule__Entry__Group__33 ;
    public final void rule__Entry__Group__32() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:1989:1: ( rule__Entry__Group__32__Impl rule__Entry__Group__33 )
            // InternalIGES.g:1990:2: rule__Entry__Group__32__Impl rule__Entry__Group__33
            {
            pushFollow(FOLLOW_16);
            rule__Entry__Group__32__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__33();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__32"


    // $ANTLR start "rule__Entry__Group__32__Impl"
    // InternalIGES.g:1997:1: rule__Entry__Group__32__Impl : ( ( RULE_WS )? ) ;
    public final void rule__Entry__Group__32__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2001:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:2002:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:2002:1: ( ( RULE_WS )? )
            // InternalIGES.g:2003:2: ( RULE_WS )?
            {
             before(grammarAccess.getEntryAccess().getWSTerminalRuleCall_32()); 
            // InternalIGES.g:2004:2: ( RULE_WS )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_WS) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalIGES.g:2004:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEntryAccess().getWSTerminalRuleCall_32()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__32__Impl"


    // $ANTLR start "rule__Entry__Group__33"
    // InternalIGES.g:2012:1: rule__Entry__Group__33 : rule__Entry__Group__33__Impl rule__Entry__Group__34 ;
    public final void rule__Entry__Group__33() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2016:1: ( rule__Entry__Group__33__Impl rule__Entry__Group__34 )
            // InternalIGES.g:2017:2: rule__Entry__Group__33__Impl rule__Entry__Group__34
            {
            pushFollow(FOLLOW_16);
            rule__Entry__Group__33__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__34();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__33"


    // $ANTLR start "rule__Entry__Group__33__Impl"
    // InternalIGES.g:2024:1: rule__Entry__Group__33__Impl : ( ( rule__Entry__Group_33__0 )? ) ;
    public final void rule__Entry__Group__33__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2028:1: ( ( ( rule__Entry__Group_33__0 )? ) )
            // InternalIGES.g:2029:1: ( ( rule__Entry__Group_33__0 )? )
            {
            // InternalIGES.g:2029:1: ( ( rule__Entry__Group_33__0 )? )
            // InternalIGES.g:2030:2: ( rule__Entry__Group_33__0 )?
            {
             before(grammarAccess.getEntryAccess().getGroup_33()); 
            // InternalIGES.g:2031:2: ( rule__Entry__Group_33__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_INT) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalIGES.g:2031:3: rule__Entry__Group_33__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Entry__Group_33__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEntryAccess().getGroup_33()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__33__Impl"


    // $ANTLR start "rule__Entry__Group__34"
    // InternalIGES.g:2039:1: rule__Entry__Group__34 : rule__Entry__Group__34__Impl rule__Entry__Group__35 ;
    public final void rule__Entry__Group__34() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2043:1: ( rule__Entry__Group__34__Impl rule__Entry__Group__35 )
            // InternalIGES.g:2044:2: rule__Entry__Group__34__Impl rule__Entry__Group__35
            {
            pushFollow(FOLLOW_16);
            rule__Entry__Group__34__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__35();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__34"


    // $ANTLR start "rule__Entry__Group__34__Impl"
    // InternalIGES.g:2051:1: rule__Entry__Group__34__Impl : ( ( rule__Entry__Group_34__0 )? ) ;
    public final void rule__Entry__Group__34__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2055:1: ( ( ( rule__Entry__Group_34__0 )? ) )
            // InternalIGES.g:2056:1: ( ( rule__Entry__Group_34__0 )? )
            {
            // InternalIGES.g:2056:1: ( ( rule__Entry__Group_34__0 )? )
            // InternalIGES.g:2057:2: ( rule__Entry__Group_34__0 )?
            {
             before(grammarAccess.getEntryAccess().getGroup_34()); 
            // InternalIGES.g:2058:2: ( rule__Entry__Group_34__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_INT) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalIGES.g:2058:3: rule__Entry__Group_34__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Entry__Group_34__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEntryAccess().getGroup_34()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__34__Impl"


    // $ANTLR start "rule__Entry__Group__35"
    // InternalIGES.g:2066:1: rule__Entry__Group__35 : rule__Entry__Group__35__Impl rule__Entry__Group__36 ;
    public final void rule__Entry__Group__35() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2070:1: ( rule__Entry__Group__35__Impl rule__Entry__Group__36 )
            // InternalIGES.g:2071:2: rule__Entry__Group__35__Impl rule__Entry__Group__36
            {
            pushFollow(FOLLOW_16);
            rule__Entry__Group__35__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__36();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__35"


    // $ANTLR start "rule__Entry__Group__35__Impl"
    // InternalIGES.g:2078:1: rule__Entry__Group__35__Impl : ( ( rule__Entry__Alternatives_35 )? ) ;
    public final void rule__Entry__Group__35__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2082:1: ( ( ( rule__Entry__Alternatives_35 )? ) )
            // InternalIGES.g:2083:1: ( ( rule__Entry__Alternatives_35 )? )
            {
            // InternalIGES.g:2083:1: ( ( rule__Entry__Alternatives_35 )? )
            // InternalIGES.g:2084:2: ( rule__Entry__Alternatives_35 )?
            {
             before(grammarAccess.getEntryAccess().getAlternatives_35()); 
            // InternalIGES.g:2085:2: ( rule__Entry__Alternatives_35 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_STRING) ) {
                alt36=1;
            }
            else if ( (LA36_0==RULE_INT) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalIGES.g:2085:3: rule__Entry__Alternatives_35
                    {
                    pushFollow(FOLLOW_2);
                    rule__Entry__Alternatives_35();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEntryAccess().getAlternatives_35()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__35__Impl"


    // $ANTLR start "rule__Entry__Group__36"
    // InternalIGES.g:2093:1: rule__Entry__Group__36 : rule__Entry__Group__36__Impl rule__Entry__Group__37 ;
    public final void rule__Entry__Group__36() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2097:1: ( rule__Entry__Group__36__Impl rule__Entry__Group__37 )
            // InternalIGES.g:2098:2: rule__Entry__Group__36__Impl rule__Entry__Group__37
            {
            pushFollow(FOLLOW_16);
            rule__Entry__Group__36__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__37();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__36"


    // $ANTLR start "rule__Entry__Group__36__Impl"
    // InternalIGES.g:2105:1: rule__Entry__Group__36__Impl : ( ( RULE_WS )? ) ;
    public final void rule__Entry__Group__36__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2109:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:2110:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:2110:1: ( ( RULE_WS )? )
            // InternalIGES.g:2111:2: ( RULE_WS )?
            {
             before(grammarAccess.getEntryAccess().getWSTerminalRuleCall_36()); 
            // InternalIGES.g:2112:2: ( RULE_WS )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_WS) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalIGES.g:2112:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEntryAccess().getWSTerminalRuleCall_36()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__36__Impl"


    // $ANTLR start "rule__Entry__Group__37"
    // InternalIGES.g:2120:1: rule__Entry__Group__37 : rule__Entry__Group__37__Impl rule__Entry__Group__38 ;
    public final void rule__Entry__Group__37() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2124:1: ( rule__Entry__Group__37__Impl rule__Entry__Group__38 )
            // InternalIGES.g:2125:2: rule__Entry__Group__37__Impl rule__Entry__Group__38
            {
            pushFollow(FOLLOW_16);
            rule__Entry__Group__37__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__38();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__37"


    // $ANTLR start "rule__Entry__Group__37__Impl"
    // InternalIGES.g:2132:1: rule__Entry__Group__37__Impl : ( ( rule__Entry__SubNumAssignment_37 )? ) ;
    public final void rule__Entry__Group__37__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2136:1: ( ( ( rule__Entry__SubNumAssignment_37 )? ) )
            // InternalIGES.g:2137:1: ( ( rule__Entry__SubNumAssignment_37 )? )
            {
            // InternalIGES.g:2137:1: ( ( rule__Entry__SubNumAssignment_37 )? )
            // InternalIGES.g:2138:2: ( rule__Entry__SubNumAssignment_37 )?
            {
             before(grammarAccess.getEntryAccess().getSubNumAssignment_37()); 
            // InternalIGES.g:2139:2: ( rule__Entry__SubNumAssignment_37 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_INT) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalIGES.g:2139:3: rule__Entry__SubNumAssignment_37
                    {
                    pushFollow(FOLLOW_2);
                    rule__Entry__SubNumAssignment_37();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEntryAccess().getSubNumAssignment_37()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__37__Impl"


    // $ANTLR start "rule__Entry__Group__38"
    // InternalIGES.g:2147:1: rule__Entry__Group__38 : rule__Entry__Group__38__Impl rule__Entry__Group__39 ;
    public final void rule__Entry__Group__38() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2151:1: ( rule__Entry__Group__38__Impl rule__Entry__Group__39 )
            // InternalIGES.g:2152:2: rule__Entry__Group__38__Impl rule__Entry__Group__39
            {
            pushFollow(FOLLOW_13);
            rule__Entry__Group__38__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__39();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__38"


    // $ANTLR start "rule__Entry__Group__38__Impl"
    // InternalIGES.g:2159:1: rule__Entry__Group__38__Impl : ( 'D' ) ;
    public final void rule__Entry__Group__38__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2163:1: ( ( 'D' ) )
            // InternalIGES.g:2164:1: ( 'D' )
            {
            // InternalIGES.g:2164:1: ( 'D' )
            // InternalIGES.g:2165:2: 'D'
            {
             before(grammarAccess.getEntryAccess().getDKeyword_38()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getEntryAccess().getDKeyword_38()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__38__Impl"


    // $ANTLR start "rule__Entry__Group__39"
    // InternalIGES.g:2174:1: rule__Entry__Group__39 : rule__Entry__Group__39__Impl rule__Entry__Group__40 ;
    public final void rule__Entry__Group__39() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2178:1: ( rule__Entry__Group__39__Impl rule__Entry__Group__40 )
            // InternalIGES.g:2179:2: rule__Entry__Group__39__Impl rule__Entry__Group__40
            {
            pushFollow(FOLLOW_13);
            rule__Entry__Group__39__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__40();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__39"


    // $ANTLR start "rule__Entry__Group__39__Impl"
    // InternalIGES.g:2186:1: rule__Entry__Group__39__Impl : ( ( RULE_WS )? ) ;
    public final void rule__Entry__Group__39__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2190:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:2191:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:2191:1: ( ( RULE_WS )? )
            // InternalIGES.g:2192:2: ( RULE_WS )?
            {
             before(grammarAccess.getEntryAccess().getWSTerminalRuleCall_39()); 
            // InternalIGES.g:2193:2: ( RULE_WS )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_WS) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalIGES.g:2193:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEntryAccess().getWSTerminalRuleCall_39()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__39__Impl"


    // $ANTLR start "rule__Entry__Group__40"
    // InternalIGES.g:2201:1: rule__Entry__Group__40 : rule__Entry__Group__40__Impl rule__Entry__Group__41 ;
    public final void rule__Entry__Group__40() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2205:1: ( rule__Entry__Group__40__Impl rule__Entry__Group__41 )
            // InternalIGES.g:2206:2: rule__Entry__Group__40__Impl rule__Entry__Group__41
            {
            pushFollow(FOLLOW_14);
            rule__Entry__Group__40__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__41();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__40"


    // $ANTLR start "rule__Entry__Group__40__Impl"
    // InternalIGES.g:2213:1: rule__Entry__Group__40__Impl : ( RULE_INT ) ;
    public final void rule__Entry__Group__40__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2217:1: ( ( RULE_INT ) )
            // InternalIGES.g:2218:1: ( RULE_INT )
            {
            // InternalIGES.g:2218:1: ( RULE_INT )
            // InternalIGES.g:2219:2: RULE_INT
            {
             before(grammarAccess.getEntryAccess().getINTTerminalRuleCall_40()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEntryAccess().getINTTerminalRuleCall_40()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__40__Impl"


    // $ANTLR start "rule__Entry__Group__41"
    // InternalIGES.g:2228:1: rule__Entry__Group__41 : rule__Entry__Group__41__Impl ;
    public final void rule__Entry__Group__41() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2232:1: ( rule__Entry__Group__41__Impl )
            // InternalIGES.g:2233:2: rule__Entry__Group__41__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Entry__Group__41__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__41"


    // $ANTLR start "rule__Entry__Group__41__Impl"
    // InternalIGES.g:2239:1: rule__Entry__Group__41__Impl : ( RULE_ENDLINE ) ;
    public final void rule__Entry__Group__41__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2243:1: ( ( RULE_ENDLINE ) )
            // InternalIGES.g:2244:1: ( RULE_ENDLINE )
            {
            // InternalIGES.g:2244:1: ( RULE_ENDLINE )
            // InternalIGES.g:2245:2: RULE_ENDLINE
            {
             before(grammarAccess.getEntryAccess().getENDLINETerminalRuleCall_41()); 
            match(input,RULE_ENDLINE,FOLLOW_2); 
             after(grammarAccess.getEntryAccess().getENDLINETerminalRuleCall_41()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__41__Impl"


    // $ANTLR start "rule__Entry__Group_33__0"
    // InternalIGES.g:2255:1: rule__Entry__Group_33__0 : rule__Entry__Group_33__0__Impl rule__Entry__Group_33__1 ;
    public final void rule__Entry__Group_33__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2259:1: ( rule__Entry__Group_33__0__Impl rule__Entry__Group_33__1 )
            // InternalIGES.g:2260:2: rule__Entry__Group_33__0__Impl rule__Entry__Group_33__1
            {
            pushFollow(FOLLOW_7);
            rule__Entry__Group_33__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group_33__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group_33__0"


    // $ANTLR start "rule__Entry__Group_33__0__Impl"
    // InternalIGES.g:2267:1: rule__Entry__Group_33__0__Impl : ( RULE_INT ) ;
    public final void rule__Entry__Group_33__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2271:1: ( ( RULE_INT ) )
            // InternalIGES.g:2272:1: ( RULE_INT )
            {
            // InternalIGES.g:2272:1: ( RULE_INT )
            // InternalIGES.g:2273:2: RULE_INT
            {
             before(grammarAccess.getEntryAccess().getINTTerminalRuleCall_33_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEntryAccess().getINTTerminalRuleCall_33_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group_33__0__Impl"


    // $ANTLR start "rule__Entry__Group_33__1"
    // InternalIGES.g:2282:1: rule__Entry__Group_33__1 : rule__Entry__Group_33__1__Impl ;
    public final void rule__Entry__Group_33__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2286:1: ( rule__Entry__Group_33__1__Impl )
            // InternalIGES.g:2287:2: rule__Entry__Group_33__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Entry__Group_33__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group_33__1"


    // $ANTLR start "rule__Entry__Group_33__1__Impl"
    // InternalIGES.g:2293:1: rule__Entry__Group_33__1__Impl : ( ( RULE_WS )? ) ;
    public final void rule__Entry__Group_33__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2297:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:2298:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:2298:1: ( ( RULE_WS )? )
            // InternalIGES.g:2299:2: ( RULE_WS )?
            {
             before(grammarAccess.getEntryAccess().getWSTerminalRuleCall_33_1()); 
            // InternalIGES.g:2300:2: ( RULE_WS )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_WS) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalIGES.g:2300:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEntryAccess().getWSTerminalRuleCall_33_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group_33__1__Impl"


    // $ANTLR start "rule__Entry__Group_34__0"
    // InternalIGES.g:2309:1: rule__Entry__Group_34__0 : rule__Entry__Group_34__0__Impl rule__Entry__Group_34__1 ;
    public final void rule__Entry__Group_34__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2313:1: ( rule__Entry__Group_34__0__Impl rule__Entry__Group_34__1 )
            // InternalIGES.g:2314:2: rule__Entry__Group_34__0__Impl rule__Entry__Group_34__1
            {
            pushFollow(FOLLOW_7);
            rule__Entry__Group_34__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group_34__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group_34__0"


    // $ANTLR start "rule__Entry__Group_34__0__Impl"
    // InternalIGES.g:2321:1: rule__Entry__Group_34__0__Impl : ( RULE_INT ) ;
    public final void rule__Entry__Group_34__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2325:1: ( ( RULE_INT ) )
            // InternalIGES.g:2326:1: ( RULE_INT )
            {
            // InternalIGES.g:2326:1: ( RULE_INT )
            // InternalIGES.g:2327:2: RULE_INT
            {
             before(grammarAccess.getEntryAccess().getINTTerminalRuleCall_34_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEntryAccess().getINTTerminalRuleCall_34_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group_34__0__Impl"


    // $ANTLR start "rule__Entry__Group_34__1"
    // InternalIGES.g:2336:1: rule__Entry__Group_34__1 : rule__Entry__Group_34__1__Impl ;
    public final void rule__Entry__Group_34__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2340:1: ( rule__Entry__Group_34__1__Impl )
            // InternalIGES.g:2341:2: rule__Entry__Group_34__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Entry__Group_34__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group_34__1"


    // $ANTLR start "rule__Entry__Group_34__1__Impl"
    // InternalIGES.g:2347:1: rule__Entry__Group_34__1__Impl : ( ( RULE_WS )? ) ;
    public final void rule__Entry__Group_34__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2351:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:2352:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:2352:1: ( ( RULE_WS )? )
            // InternalIGES.g:2353:2: ( RULE_WS )?
            {
             before(grammarAccess.getEntryAccess().getWSTerminalRuleCall_34_1()); 
            // InternalIGES.g:2354:2: ( RULE_WS )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_WS) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalIGES.g:2354:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEntryAccess().getWSTerminalRuleCall_34_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group_34__1__Impl"


    // $ANTLR start "rule__PEntry__Group__0"
    // InternalIGES.g:2363:1: rule__PEntry__Group__0 : rule__PEntry__Group__0__Impl rule__PEntry__Group__1 ;
    public final void rule__PEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2367:1: ( rule__PEntry__Group__0__Impl rule__PEntry__Group__1 )
            // InternalIGES.g:2368:2: rule__PEntry__Group__0__Impl rule__PEntry__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__PEntry__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PEntry__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEntry__Group__0"


    // $ANTLR start "rule__PEntry__Group__0__Impl"
    // InternalIGES.g:2375:1: rule__PEntry__Group__0__Impl : ( ( rule__PEntry__TypeAssignment_0 ) ) ;
    public final void rule__PEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2379:1: ( ( ( rule__PEntry__TypeAssignment_0 ) ) )
            // InternalIGES.g:2380:1: ( ( rule__PEntry__TypeAssignment_0 ) )
            {
            // InternalIGES.g:2380:1: ( ( rule__PEntry__TypeAssignment_0 ) )
            // InternalIGES.g:2381:2: ( rule__PEntry__TypeAssignment_0 )
            {
             before(grammarAccess.getPEntryAccess().getTypeAssignment_0()); 
            // InternalIGES.g:2382:2: ( rule__PEntry__TypeAssignment_0 )
            // InternalIGES.g:2382:3: rule__PEntry__TypeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__PEntry__TypeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getPEntryAccess().getTypeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEntry__Group__0__Impl"


    // $ANTLR start "rule__PEntry__Group__1"
    // InternalIGES.g:2390:1: rule__PEntry__Group__1 : rule__PEntry__Group__1__Impl rule__PEntry__Group__2 ;
    public final void rule__PEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2394:1: ( rule__PEntry__Group__1__Impl rule__PEntry__Group__2 )
            // InternalIGES.g:2395:2: rule__PEntry__Group__1__Impl rule__PEntry__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__PEntry__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PEntry__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEntry__Group__1"


    // $ANTLR start "rule__PEntry__Group__1__Impl"
    // InternalIGES.g:2402:1: rule__PEntry__Group__1__Impl : ( ( RULE_DELIMITER )? ) ;
    public final void rule__PEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2406:1: ( ( ( RULE_DELIMITER )? ) )
            // InternalIGES.g:2407:1: ( ( RULE_DELIMITER )? )
            {
            // InternalIGES.g:2407:1: ( ( RULE_DELIMITER )? )
            // InternalIGES.g:2408:2: ( RULE_DELIMITER )?
            {
             before(grammarAccess.getPEntryAccess().getDELIMITERTerminalRuleCall_1()); 
            // InternalIGES.g:2409:2: ( RULE_DELIMITER )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_DELIMITER) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalIGES.g:2409:3: RULE_DELIMITER
                    {
                    match(input,RULE_DELIMITER,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getPEntryAccess().getDELIMITERTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEntry__Group__1__Impl"


    // $ANTLR start "rule__PEntry__Group__2"
    // InternalIGES.g:2417:1: rule__PEntry__Group__2 : rule__PEntry__Group__2__Impl rule__PEntry__Group__3 ;
    public final void rule__PEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2421:1: ( rule__PEntry__Group__2__Impl rule__PEntry__Group__3 )
            // InternalIGES.g:2422:2: rule__PEntry__Group__2__Impl rule__PEntry__Group__3
            {
            pushFollow(FOLLOW_10);
            rule__PEntry__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PEntry__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEntry__Group__2"


    // $ANTLR start "rule__PEntry__Group__2__Impl"
    // InternalIGES.g:2429:1: rule__PEntry__Group__2__Impl : ( ( rule__PEntry__ValuesAssignment_2 )* ) ;
    public final void rule__PEntry__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2433:1: ( ( ( rule__PEntry__ValuesAssignment_2 )* ) )
            // InternalIGES.g:2434:1: ( ( rule__PEntry__ValuesAssignment_2 )* )
            {
            // InternalIGES.g:2434:1: ( ( rule__PEntry__ValuesAssignment_2 )* )
            // InternalIGES.g:2435:2: ( rule__PEntry__ValuesAssignment_2 )*
            {
             before(grammarAccess.getPEntryAccess().getValuesAssignment_2()); 
            // InternalIGES.g:2436:2: ( rule__PEntry__ValuesAssignment_2 )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==RULE_INT||(LA43_0>=RULE_HOLLERITH && LA43_0<=RULE_DOUBLE)) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalIGES.g:2436:3: rule__PEntry__ValuesAssignment_2
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__PEntry__ValuesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

             after(grammarAccess.getPEntryAccess().getValuesAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEntry__Group__2__Impl"


    // $ANTLR start "rule__PEntry__Group__3"
    // InternalIGES.g:2444:1: rule__PEntry__Group__3 : rule__PEntry__Group__3__Impl rule__PEntry__Group__4 ;
    public final void rule__PEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2448:1: ( rule__PEntry__Group__3__Impl rule__PEntry__Group__4 )
            // InternalIGES.g:2449:2: rule__PEntry__Group__3__Impl rule__PEntry__Group__4
            {
            pushFollow(FOLLOW_13);
            rule__PEntry__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PEntry__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEntry__Group__3"


    // $ANTLR start "rule__PEntry__Group__3__Impl"
    // InternalIGES.g:2456:1: rule__PEntry__Group__3__Impl : ( RULE_SEPARATOR ) ;
    public final void rule__PEntry__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2460:1: ( ( RULE_SEPARATOR ) )
            // InternalIGES.g:2461:1: ( RULE_SEPARATOR )
            {
            // InternalIGES.g:2461:1: ( RULE_SEPARATOR )
            // InternalIGES.g:2462:2: RULE_SEPARATOR
            {
             before(grammarAccess.getPEntryAccess().getSEPARATORTerminalRuleCall_3()); 
            match(input,RULE_SEPARATOR,FOLLOW_2); 
             after(grammarAccess.getPEntryAccess().getSEPARATORTerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEntry__Group__3__Impl"


    // $ANTLR start "rule__PEntry__Group__4"
    // InternalIGES.g:2471:1: rule__PEntry__Group__4 : rule__PEntry__Group__4__Impl rule__PEntry__Group__5 ;
    public final void rule__PEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2475:1: ( rule__PEntry__Group__4__Impl rule__PEntry__Group__5 )
            // InternalIGES.g:2476:2: rule__PEntry__Group__4__Impl rule__PEntry__Group__5
            {
            pushFollow(FOLLOW_13);
            rule__PEntry__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PEntry__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEntry__Group__4"


    // $ANTLR start "rule__PEntry__Group__4__Impl"
    // InternalIGES.g:2483:1: rule__PEntry__Group__4__Impl : ( ( RULE_WS )? ) ;
    public final void rule__PEntry__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2487:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:2488:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:2488:1: ( ( RULE_WS )? )
            // InternalIGES.g:2489:2: ( RULE_WS )?
            {
             before(grammarAccess.getPEntryAccess().getWSTerminalRuleCall_4()); 
            // InternalIGES.g:2490:2: ( RULE_WS )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_WS) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalIGES.g:2490:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getPEntryAccess().getWSTerminalRuleCall_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEntry__Group__4__Impl"


    // $ANTLR start "rule__PEntry__Group__5"
    // InternalIGES.g:2498:1: rule__PEntry__Group__5 : rule__PEntry__Group__5__Impl rule__PEntry__Group__6 ;
    public final void rule__PEntry__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2502:1: ( rule__PEntry__Group__5__Impl rule__PEntry__Group__6 )
            // InternalIGES.g:2503:2: rule__PEntry__Group__5__Impl rule__PEntry__Group__6
            {
            pushFollow(FOLLOW_17);
            rule__PEntry__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PEntry__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEntry__Group__5"


    // $ANTLR start "rule__PEntry__Group__5__Impl"
    // InternalIGES.g:2510:1: rule__PEntry__Group__5__Impl : ( ( rule__PEntry__DIndexAssignment_5 ) ) ;
    public final void rule__PEntry__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2514:1: ( ( ( rule__PEntry__DIndexAssignment_5 ) ) )
            // InternalIGES.g:2515:1: ( ( rule__PEntry__DIndexAssignment_5 ) )
            {
            // InternalIGES.g:2515:1: ( ( rule__PEntry__DIndexAssignment_5 ) )
            // InternalIGES.g:2516:2: ( rule__PEntry__DIndexAssignment_5 )
            {
             before(grammarAccess.getPEntryAccess().getDIndexAssignment_5()); 
            // InternalIGES.g:2517:2: ( rule__PEntry__DIndexAssignment_5 )
            // InternalIGES.g:2517:3: rule__PEntry__DIndexAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__PEntry__DIndexAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getPEntryAccess().getDIndexAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEntry__Group__5__Impl"


    // $ANTLR start "rule__PEntry__Group__6"
    // InternalIGES.g:2525:1: rule__PEntry__Group__6 : rule__PEntry__Group__6__Impl rule__PEntry__Group__7 ;
    public final void rule__PEntry__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2529:1: ( rule__PEntry__Group__6__Impl rule__PEntry__Group__7 )
            // InternalIGES.g:2530:2: rule__PEntry__Group__6__Impl rule__PEntry__Group__7
            {
            pushFollow(FOLLOW_13);
            rule__PEntry__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PEntry__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEntry__Group__6"


    // $ANTLR start "rule__PEntry__Group__6__Impl"
    // InternalIGES.g:2537:1: rule__PEntry__Group__6__Impl : ( 'P' ) ;
    public final void rule__PEntry__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2541:1: ( ( 'P' ) )
            // InternalIGES.g:2542:1: ( 'P' )
            {
            // InternalIGES.g:2542:1: ( 'P' )
            // InternalIGES.g:2543:2: 'P'
            {
             before(grammarAccess.getPEntryAccess().getPKeyword_6()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getPEntryAccess().getPKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEntry__Group__6__Impl"


    // $ANTLR start "rule__PEntry__Group__7"
    // InternalIGES.g:2552:1: rule__PEntry__Group__7 : rule__PEntry__Group__7__Impl rule__PEntry__Group__8 ;
    public final void rule__PEntry__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2556:1: ( rule__PEntry__Group__7__Impl rule__PEntry__Group__8 )
            // InternalIGES.g:2557:2: rule__PEntry__Group__7__Impl rule__PEntry__Group__8
            {
            pushFollow(FOLLOW_13);
            rule__PEntry__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PEntry__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEntry__Group__7"


    // $ANTLR start "rule__PEntry__Group__7__Impl"
    // InternalIGES.g:2564:1: rule__PEntry__Group__7__Impl : ( ( RULE_WS )? ) ;
    public final void rule__PEntry__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2568:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:2569:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:2569:1: ( ( RULE_WS )? )
            // InternalIGES.g:2570:2: ( RULE_WS )?
            {
             before(grammarAccess.getPEntryAccess().getWSTerminalRuleCall_7()); 
            // InternalIGES.g:2571:2: ( RULE_WS )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_WS) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalIGES.g:2571:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getPEntryAccess().getWSTerminalRuleCall_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEntry__Group__7__Impl"


    // $ANTLR start "rule__PEntry__Group__8"
    // InternalIGES.g:2579:1: rule__PEntry__Group__8 : rule__PEntry__Group__8__Impl rule__PEntry__Group__9 ;
    public final void rule__PEntry__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2583:1: ( rule__PEntry__Group__8__Impl rule__PEntry__Group__9 )
            // InternalIGES.g:2584:2: rule__PEntry__Group__8__Impl rule__PEntry__Group__9
            {
            pushFollow(FOLLOW_14);
            rule__PEntry__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PEntry__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEntry__Group__8"


    // $ANTLR start "rule__PEntry__Group__8__Impl"
    // InternalIGES.g:2591:1: rule__PEntry__Group__8__Impl : ( ( rule__PEntry__IndiciesAssignment_8 ) ) ;
    public final void rule__PEntry__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2595:1: ( ( ( rule__PEntry__IndiciesAssignment_8 ) ) )
            // InternalIGES.g:2596:1: ( ( rule__PEntry__IndiciesAssignment_8 ) )
            {
            // InternalIGES.g:2596:1: ( ( rule__PEntry__IndiciesAssignment_8 ) )
            // InternalIGES.g:2597:2: ( rule__PEntry__IndiciesAssignment_8 )
            {
             before(grammarAccess.getPEntryAccess().getIndiciesAssignment_8()); 
            // InternalIGES.g:2598:2: ( rule__PEntry__IndiciesAssignment_8 )
            // InternalIGES.g:2598:3: rule__PEntry__IndiciesAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__PEntry__IndiciesAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getPEntryAccess().getIndiciesAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEntry__Group__8__Impl"


    // $ANTLR start "rule__PEntry__Group__9"
    // InternalIGES.g:2606:1: rule__PEntry__Group__9 : rule__PEntry__Group__9__Impl ;
    public final void rule__PEntry__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2610:1: ( rule__PEntry__Group__9__Impl )
            // InternalIGES.g:2611:2: rule__PEntry__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PEntry__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEntry__Group__9"


    // $ANTLR start "rule__PEntry__Group__9__Impl"
    // InternalIGES.g:2617:1: rule__PEntry__Group__9__Impl : ( RULE_ENDLINE ) ;
    public final void rule__PEntry__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2621:1: ( ( RULE_ENDLINE ) )
            // InternalIGES.g:2622:1: ( RULE_ENDLINE )
            {
            // InternalIGES.g:2622:1: ( RULE_ENDLINE )
            // InternalIGES.g:2623:2: RULE_ENDLINE
            {
             before(grammarAccess.getPEntryAccess().getENDLINETerminalRuleCall_9()); 
            match(input,RULE_ENDLINE,FOLLOW_2); 
             after(grammarAccess.getPEntryAccess().getENDLINETerminalRuleCall_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEntry__Group__9__Impl"


    // $ANTLR start "rule__PMultiEntry__Group__0"
    // InternalIGES.g:2633:1: rule__PMultiEntry__Group__0 : rule__PMultiEntry__Group__0__Impl rule__PMultiEntry__Group__1 ;
    public final void rule__PMultiEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2637:1: ( rule__PMultiEntry__Group__0__Impl rule__PMultiEntry__Group__1 )
            // InternalIGES.g:2638:2: rule__PMultiEntry__Group__0__Impl rule__PMultiEntry__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__PMultiEntry__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PMultiEntry__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group__0"


    // $ANTLR start "rule__PMultiEntry__Group__0__Impl"
    // InternalIGES.g:2645:1: rule__PMultiEntry__Group__0__Impl : ( ( rule__PMultiEntry__TypeAssignment_0 ) ) ;
    public final void rule__PMultiEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2649:1: ( ( ( rule__PMultiEntry__TypeAssignment_0 ) ) )
            // InternalIGES.g:2650:1: ( ( rule__PMultiEntry__TypeAssignment_0 ) )
            {
            // InternalIGES.g:2650:1: ( ( rule__PMultiEntry__TypeAssignment_0 ) )
            // InternalIGES.g:2651:2: ( rule__PMultiEntry__TypeAssignment_0 )
            {
             before(grammarAccess.getPMultiEntryAccess().getTypeAssignment_0()); 
            // InternalIGES.g:2652:2: ( rule__PMultiEntry__TypeAssignment_0 )
            // InternalIGES.g:2652:3: rule__PMultiEntry__TypeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__PMultiEntry__TypeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getPMultiEntryAccess().getTypeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group__0__Impl"


    // $ANTLR start "rule__PMultiEntry__Group__1"
    // InternalIGES.g:2660:1: rule__PMultiEntry__Group__1 : rule__PMultiEntry__Group__1__Impl rule__PMultiEntry__Group__2 ;
    public final void rule__PMultiEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2664:1: ( rule__PMultiEntry__Group__1__Impl rule__PMultiEntry__Group__2 )
            // InternalIGES.g:2665:2: rule__PMultiEntry__Group__1__Impl rule__PMultiEntry__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__PMultiEntry__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PMultiEntry__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group__1"


    // $ANTLR start "rule__PMultiEntry__Group__1__Impl"
    // InternalIGES.g:2672:1: rule__PMultiEntry__Group__1__Impl : ( ( RULE_DELIMITER )? ) ;
    public final void rule__PMultiEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2676:1: ( ( ( RULE_DELIMITER )? ) )
            // InternalIGES.g:2677:1: ( ( RULE_DELIMITER )? )
            {
            // InternalIGES.g:2677:1: ( ( RULE_DELIMITER )? )
            // InternalIGES.g:2678:2: ( RULE_DELIMITER )?
            {
             before(grammarAccess.getPMultiEntryAccess().getDELIMITERTerminalRuleCall_1()); 
            // InternalIGES.g:2679:2: ( RULE_DELIMITER )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_DELIMITER) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalIGES.g:2679:3: RULE_DELIMITER
                    {
                    match(input,RULE_DELIMITER,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getPMultiEntryAccess().getDELIMITERTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group__1__Impl"


    // $ANTLR start "rule__PMultiEntry__Group__2"
    // InternalIGES.g:2687:1: rule__PMultiEntry__Group__2 : rule__PMultiEntry__Group__2__Impl rule__PMultiEntry__Group__3 ;
    public final void rule__PMultiEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2691:1: ( rule__PMultiEntry__Group__2__Impl rule__PMultiEntry__Group__3 )
            // InternalIGES.g:2692:2: rule__PMultiEntry__Group__2__Impl rule__PMultiEntry__Group__3
            {
            pushFollow(FOLLOW_10);
            rule__PMultiEntry__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PMultiEntry__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group__2"


    // $ANTLR start "rule__PMultiEntry__Group__2__Impl"
    // InternalIGES.g:2699:1: rule__PMultiEntry__Group__2__Impl : ( ( ( rule__PMultiEntry__Group_2__0 ) ) ( ( rule__PMultiEntry__Group_2__0 )* ) ) ;
    public final void rule__PMultiEntry__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2703:1: ( ( ( ( rule__PMultiEntry__Group_2__0 ) ) ( ( rule__PMultiEntry__Group_2__0 )* ) ) )
            // InternalIGES.g:2704:1: ( ( ( rule__PMultiEntry__Group_2__0 ) ) ( ( rule__PMultiEntry__Group_2__0 )* ) )
            {
            // InternalIGES.g:2704:1: ( ( ( rule__PMultiEntry__Group_2__0 ) ) ( ( rule__PMultiEntry__Group_2__0 )* ) )
            // InternalIGES.g:2705:2: ( ( rule__PMultiEntry__Group_2__0 ) ) ( ( rule__PMultiEntry__Group_2__0 )* )
            {
            // InternalIGES.g:2705:2: ( ( rule__PMultiEntry__Group_2__0 ) )
            // InternalIGES.g:2706:3: ( rule__PMultiEntry__Group_2__0 )
            {
             before(grammarAccess.getPMultiEntryAccess().getGroup_2()); 
            // InternalIGES.g:2707:3: ( rule__PMultiEntry__Group_2__0 )
            // InternalIGES.g:2707:4: rule__PMultiEntry__Group_2__0
            {
            pushFollow(FOLLOW_19);
            rule__PMultiEntry__Group_2__0();

            state._fsp--;


            }

             after(grammarAccess.getPMultiEntryAccess().getGroup_2()); 

            }

            // InternalIGES.g:2710:2: ( ( rule__PMultiEntry__Group_2__0 )* )
            // InternalIGES.g:2711:3: ( rule__PMultiEntry__Group_2__0 )*
            {
             before(grammarAccess.getPMultiEntryAccess().getGroup_2()); 
            // InternalIGES.g:2712:3: ( rule__PMultiEntry__Group_2__0 )*
            loop47:
            do {
                int alt47=2;
                alt47 = dfa47.predict(input);
                switch (alt47) {
            	case 1 :
            	    // InternalIGES.g:2712:4: rule__PMultiEntry__Group_2__0
            	    {
            	    pushFollow(FOLLOW_19);
            	    rule__PMultiEntry__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

             after(grammarAccess.getPMultiEntryAccess().getGroup_2()); 

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
    // $ANTLR end "rule__PMultiEntry__Group__2__Impl"


    // $ANTLR start "rule__PMultiEntry__Group__3"
    // InternalIGES.g:2721:1: rule__PMultiEntry__Group__3 : rule__PMultiEntry__Group__3__Impl rule__PMultiEntry__Group__4 ;
    public final void rule__PMultiEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2725:1: ( rule__PMultiEntry__Group__3__Impl rule__PMultiEntry__Group__4 )
            // InternalIGES.g:2726:2: rule__PMultiEntry__Group__3__Impl rule__PMultiEntry__Group__4
            {
            pushFollow(FOLLOW_10);
            rule__PMultiEntry__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PMultiEntry__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group__3"


    // $ANTLR start "rule__PMultiEntry__Group__3__Impl"
    // InternalIGES.g:2733:1: rule__PMultiEntry__Group__3__Impl : ( ( rule__PMultiEntry__ValuesAssignment_3 )* ) ;
    public final void rule__PMultiEntry__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2737:1: ( ( ( rule__PMultiEntry__ValuesAssignment_3 )* ) )
            // InternalIGES.g:2738:1: ( ( rule__PMultiEntry__ValuesAssignment_3 )* )
            {
            // InternalIGES.g:2738:1: ( ( rule__PMultiEntry__ValuesAssignment_3 )* )
            // InternalIGES.g:2739:2: ( rule__PMultiEntry__ValuesAssignment_3 )*
            {
             before(grammarAccess.getPMultiEntryAccess().getValuesAssignment_3()); 
            // InternalIGES.g:2740:2: ( rule__PMultiEntry__ValuesAssignment_3 )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==RULE_INT||(LA48_0>=RULE_HOLLERITH && LA48_0<=RULE_DOUBLE)) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalIGES.g:2740:3: rule__PMultiEntry__ValuesAssignment_3
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__PMultiEntry__ValuesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

             after(grammarAccess.getPMultiEntryAccess().getValuesAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group__3__Impl"


    // $ANTLR start "rule__PMultiEntry__Group__4"
    // InternalIGES.g:2748:1: rule__PMultiEntry__Group__4 : rule__PMultiEntry__Group__4__Impl rule__PMultiEntry__Group__5 ;
    public final void rule__PMultiEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2752:1: ( rule__PMultiEntry__Group__4__Impl rule__PMultiEntry__Group__5 )
            // InternalIGES.g:2753:2: rule__PMultiEntry__Group__4__Impl rule__PMultiEntry__Group__5
            {
            pushFollow(FOLLOW_13);
            rule__PMultiEntry__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PMultiEntry__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group__4"


    // $ANTLR start "rule__PMultiEntry__Group__4__Impl"
    // InternalIGES.g:2760:1: rule__PMultiEntry__Group__4__Impl : ( RULE_SEPARATOR ) ;
    public final void rule__PMultiEntry__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2764:1: ( ( RULE_SEPARATOR ) )
            // InternalIGES.g:2765:1: ( RULE_SEPARATOR )
            {
            // InternalIGES.g:2765:1: ( RULE_SEPARATOR )
            // InternalIGES.g:2766:2: RULE_SEPARATOR
            {
             before(grammarAccess.getPMultiEntryAccess().getSEPARATORTerminalRuleCall_4()); 
            match(input,RULE_SEPARATOR,FOLLOW_2); 
             after(grammarAccess.getPMultiEntryAccess().getSEPARATORTerminalRuleCall_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group__4__Impl"


    // $ANTLR start "rule__PMultiEntry__Group__5"
    // InternalIGES.g:2775:1: rule__PMultiEntry__Group__5 : rule__PMultiEntry__Group__5__Impl rule__PMultiEntry__Group__6 ;
    public final void rule__PMultiEntry__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2779:1: ( rule__PMultiEntry__Group__5__Impl rule__PMultiEntry__Group__6 )
            // InternalIGES.g:2780:2: rule__PMultiEntry__Group__5__Impl rule__PMultiEntry__Group__6
            {
            pushFollow(FOLLOW_13);
            rule__PMultiEntry__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PMultiEntry__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group__5"


    // $ANTLR start "rule__PMultiEntry__Group__5__Impl"
    // InternalIGES.g:2787:1: rule__PMultiEntry__Group__5__Impl : ( ( RULE_WS )? ) ;
    public final void rule__PMultiEntry__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2791:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:2792:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:2792:1: ( ( RULE_WS )? )
            // InternalIGES.g:2793:2: ( RULE_WS )?
            {
             before(grammarAccess.getPMultiEntryAccess().getWSTerminalRuleCall_5()); 
            // InternalIGES.g:2794:2: ( RULE_WS )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_WS) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalIGES.g:2794:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getPMultiEntryAccess().getWSTerminalRuleCall_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group__5__Impl"


    // $ANTLR start "rule__PMultiEntry__Group__6"
    // InternalIGES.g:2802:1: rule__PMultiEntry__Group__6 : rule__PMultiEntry__Group__6__Impl rule__PMultiEntry__Group__7 ;
    public final void rule__PMultiEntry__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2806:1: ( rule__PMultiEntry__Group__6__Impl rule__PMultiEntry__Group__7 )
            // InternalIGES.g:2807:2: rule__PMultiEntry__Group__6__Impl rule__PMultiEntry__Group__7
            {
            pushFollow(FOLLOW_17);
            rule__PMultiEntry__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PMultiEntry__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group__6"


    // $ANTLR start "rule__PMultiEntry__Group__6__Impl"
    // InternalIGES.g:2814:1: rule__PMultiEntry__Group__6__Impl : ( RULE_INT ) ;
    public final void rule__PMultiEntry__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2818:1: ( ( RULE_INT ) )
            // InternalIGES.g:2819:1: ( RULE_INT )
            {
            // InternalIGES.g:2819:1: ( RULE_INT )
            // InternalIGES.g:2820:2: RULE_INT
            {
             before(grammarAccess.getPMultiEntryAccess().getINTTerminalRuleCall_6()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getPMultiEntryAccess().getINTTerminalRuleCall_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group__6__Impl"


    // $ANTLR start "rule__PMultiEntry__Group__7"
    // InternalIGES.g:2829:1: rule__PMultiEntry__Group__7 : rule__PMultiEntry__Group__7__Impl rule__PMultiEntry__Group__8 ;
    public final void rule__PMultiEntry__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2833:1: ( rule__PMultiEntry__Group__7__Impl rule__PMultiEntry__Group__8 )
            // InternalIGES.g:2834:2: rule__PMultiEntry__Group__7__Impl rule__PMultiEntry__Group__8
            {
            pushFollow(FOLLOW_13);
            rule__PMultiEntry__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PMultiEntry__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group__7"


    // $ANTLR start "rule__PMultiEntry__Group__7__Impl"
    // InternalIGES.g:2841:1: rule__PMultiEntry__Group__7__Impl : ( 'P' ) ;
    public final void rule__PMultiEntry__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2845:1: ( ( 'P' ) )
            // InternalIGES.g:2846:1: ( 'P' )
            {
            // InternalIGES.g:2846:1: ( 'P' )
            // InternalIGES.g:2847:2: 'P'
            {
             before(grammarAccess.getPMultiEntryAccess().getPKeyword_7()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getPMultiEntryAccess().getPKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group__7__Impl"


    // $ANTLR start "rule__PMultiEntry__Group__8"
    // InternalIGES.g:2856:1: rule__PMultiEntry__Group__8 : rule__PMultiEntry__Group__8__Impl rule__PMultiEntry__Group__9 ;
    public final void rule__PMultiEntry__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2860:1: ( rule__PMultiEntry__Group__8__Impl rule__PMultiEntry__Group__9 )
            // InternalIGES.g:2861:2: rule__PMultiEntry__Group__8__Impl rule__PMultiEntry__Group__9
            {
            pushFollow(FOLLOW_13);
            rule__PMultiEntry__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PMultiEntry__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group__8"


    // $ANTLR start "rule__PMultiEntry__Group__8__Impl"
    // InternalIGES.g:2868:1: rule__PMultiEntry__Group__8__Impl : ( ( RULE_WS )? ) ;
    public final void rule__PMultiEntry__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2872:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:2873:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:2873:1: ( ( RULE_WS )? )
            // InternalIGES.g:2874:2: ( RULE_WS )?
            {
             before(grammarAccess.getPMultiEntryAccess().getWSTerminalRuleCall_8()); 
            // InternalIGES.g:2875:2: ( RULE_WS )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_WS) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalIGES.g:2875:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getPMultiEntryAccess().getWSTerminalRuleCall_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group__8__Impl"


    // $ANTLR start "rule__PMultiEntry__Group__9"
    // InternalIGES.g:2883:1: rule__PMultiEntry__Group__9 : rule__PMultiEntry__Group__9__Impl rule__PMultiEntry__Group__10 ;
    public final void rule__PMultiEntry__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2887:1: ( rule__PMultiEntry__Group__9__Impl rule__PMultiEntry__Group__10 )
            // InternalIGES.g:2888:2: rule__PMultiEntry__Group__9__Impl rule__PMultiEntry__Group__10
            {
            pushFollow(FOLLOW_14);
            rule__PMultiEntry__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PMultiEntry__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group__9"


    // $ANTLR start "rule__PMultiEntry__Group__9__Impl"
    // InternalIGES.g:2895:1: rule__PMultiEntry__Group__9__Impl : ( RULE_INT ) ;
    public final void rule__PMultiEntry__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2899:1: ( ( RULE_INT ) )
            // InternalIGES.g:2900:1: ( RULE_INT )
            {
            // InternalIGES.g:2900:1: ( RULE_INT )
            // InternalIGES.g:2901:2: RULE_INT
            {
             before(grammarAccess.getPMultiEntryAccess().getINTTerminalRuleCall_9()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getPMultiEntryAccess().getINTTerminalRuleCall_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group__9__Impl"


    // $ANTLR start "rule__PMultiEntry__Group__10"
    // InternalIGES.g:2910:1: rule__PMultiEntry__Group__10 : rule__PMultiEntry__Group__10__Impl ;
    public final void rule__PMultiEntry__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2914:1: ( rule__PMultiEntry__Group__10__Impl )
            // InternalIGES.g:2915:2: rule__PMultiEntry__Group__10__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PMultiEntry__Group__10__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group__10"


    // $ANTLR start "rule__PMultiEntry__Group__10__Impl"
    // InternalIGES.g:2921:1: rule__PMultiEntry__Group__10__Impl : ( RULE_ENDLINE ) ;
    public final void rule__PMultiEntry__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2925:1: ( ( RULE_ENDLINE ) )
            // InternalIGES.g:2926:1: ( RULE_ENDLINE )
            {
            // InternalIGES.g:2926:1: ( RULE_ENDLINE )
            // InternalIGES.g:2927:2: RULE_ENDLINE
            {
             before(grammarAccess.getPMultiEntryAccess().getENDLINETerminalRuleCall_10()); 
            match(input,RULE_ENDLINE,FOLLOW_2); 
             after(grammarAccess.getPMultiEntryAccess().getENDLINETerminalRuleCall_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group__10__Impl"


    // $ANTLR start "rule__PMultiEntry__Group_2__0"
    // InternalIGES.g:2937:1: rule__PMultiEntry__Group_2__0 : rule__PMultiEntry__Group_2__0__Impl rule__PMultiEntry__Group_2__1 ;
    public final void rule__PMultiEntry__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2941:1: ( rule__PMultiEntry__Group_2__0__Impl rule__PMultiEntry__Group_2__1 )
            // InternalIGES.g:2942:2: rule__PMultiEntry__Group_2__0__Impl rule__PMultiEntry__Group_2__1
            {
            pushFollow(FOLLOW_18);
            rule__PMultiEntry__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PMultiEntry__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group_2__0"


    // $ANTLR start "rule__PMultiEntry__Group_2__0__Impl"
    // InternalIGES.g:2949:1: rule__PMultiEntry__Group_2__0__Impl : ( ( rule__PMultiEntry__ValuesAssignment_2_0 )* ) ;
    public final void rule__PMultiEntry__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2953:1: ( ( ( rule__PMultiEntry__ValuesAssignment_2_0 )* ) )
            // InternalIGES.g:2954:1: ( ( rule__PMultiEntry__ValuesAssignment_2_0 )* )
            {
            // InternalIGES.g:2954:1: ( ( rule__PMultiEntry__ValuesAssignment_2_0 )* )
            // InternalIGES.g:2955:2: ( rule__PMultiEntry__ValuesAssignment_2_0 )*
            {
             before(grammarAccess.getPMultiEntryAccess().getValuesAssignment_2_0()); 
            // InternalIGES.g:2956:2: ( rule__PMultiEntry__ValuesAssignment_2_0 )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==RULE_INT) ) {
                    int LA51_2 = input.LA(2);

                    if ( (LA51_2==RULE_INT||(LA51_2>=RULE_WS && LA51_2<=RULE_DELIMITER)||(LA51_2>=RULE_HOLLERITH && LA51_2<=RULE_DOUBLE)) ) {
                        alt51=1;
                    }


                }
                else if ( ((LA51_0>=RULE_HOLLERITH && LA51_0<=RULE_DOUBLE)) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalIGES.g:2956:3: rule__PMultiEntry__ValuesAssignment_2_0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__PMultiEntry__ValuesAssignment_2_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

             after(grammarAccess.getPMultiEntryAccess().getValuesAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group_2__0__Impl"


    // $ANTLR start "rule__PMultiEntry__Group_2__1"
    // InternalIGES.g:2964:1: rule__PMultiEntry__Group_2__1 : rule__PMultiEntry__Group_2__1__Impl rule__PMultiEntry__Group_2__2 ;
    public final void rule__PMultiEntry__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2968:1: ( rule__PMultiEntry__Group_2__1__Impl rule__PMultiEntry__Group_2__2 )
            // InternalIGES.g:2969:2: rule__PMultiEntry__Group_2__1__Impl rule__PMultiEntry__Group_2__2
            {
            pushFollow(FOLLOW_18);
            rule__PMultiEntry__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PMultiEntry__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group_2__1"


    // $ANTLR start "rule__PMultiEntry__Group_2__1__Impl"
    // InternalIGES.g:2976:1: rule__PMultiEntry__Group_2__1__Impl : ( ( RULE_WS )? ) ;
    public final void rule__PMultiEntry__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2980:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:2981:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:2981:1: ( ( RULE_WS )? )
            // InternalIGES.g:2982:2: ( RULE_WS )?
            {
             before(grammarAccess.getPMultiEntryAccess().getWSTerminalRuleCall_2_1()); 
            // InternalIGES.g:2983:2: ( RULE_WS )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_WS) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalIGES.g:2983:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getPMultiEntryAccess().getWSTerminalRuleCall_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group_2__1__Impl"


    // $ANTLR start "rule__PMultiEntry__Group_2__2"
    // InternalIGES.g:2991:1: rule__PMultiEntry__Group_2__2 : rule__PMultiEntry__Group_2__2__Impl rule__PMultiEntry__Group_2__3 ;
    public final void rule__PMultiEntry__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:2995:1: ( rule__PMultiEntry__Group_2__2__Impl rule__PMultiEntry__Group_2__3 )
            // InternalIGES.g:2996:2: rule__PMultiEntry__Group_2__2__Impl rule__PMultiEntry__Group_2__3
            {
            pushFollow(FOLLOW_17);
            rule__PMultiEntry__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PMultiEntry__Group_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group_2__2"


    // $ANTLR start "rule__PMultiEntry__Group_2__2__Impl"
    // InternalIGES.g:3003:1: rule__PMultiEntry__Group_2__2__Impl : ( ( rule__PMultiEntry__DIndexAssignment_2_2 ) ) ;
    public final void rule__PMultiEntry__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3007:1: ( ( ( rule__PMultiEntry__DIndexAssignment_2_2 ) ) )
            // InternalIGES.g:3008:1: ( ( rule__PMultiEntry__DIndexAssignment_2_2 ) )
            {
            // InternalIGES.g:3008:1: ( ( rule__PMultiEntry__DIndexAssignment_2_2 ) )
            // InternalIGES.g:3009:2: ( rule__PMultiEntry__DIndexAssignment_2_2 )
            {
             before(grammarAccess.getPMultiEntryAccess().getDIndexAssignment_2_2()); 
            // InternalIGES.g:3010:2: ( rule__PMultiEntry__DIndexAssignment_2_2 )
            // InternalIGES.g:3010:3: rule__PMultiEntry__DIndexAssignment_2_2
            {
            pushFollow(FOLLOW_2);
            rule__PMultiEntry__DIndexAssignment_2_2();

            state._fsp--;


            }

             after(grammarAccess.getPMultiEntryAccess().getDIndexAssignment_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group_2__2__Impl"


    // $ANTLR start "rule__PMultiEntry__Group_2__3"
    // InternalIGES.g:3018:1: rule__PMultiEntry__Group_2__3 : rule__PMultiEntry__Group_2__3__Impl rule__PMultiEntry__Group_2__4 ;
    public final void rule__PMultiEntry__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3022:1: ( rule__PMultiEntry__Group_2__3__Impl rule__PMultiEntry__Group_2__4 )
            // InternalIGES.g:3023:2: rule__PMultiEntry__Group_2__3__Impl rule__PMultiEntry__Group_2__4
            {
            pushFollow(FOLLOW_13);
            rule__PMultiEntry__Group_2__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PMultiEntry__Group_2__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group_2__3"


    // $ANTLR start "rule__PMultiEntry__Group_2__3__Impl"
    // InternalIGES.g:3030:1: rule__PMultiEntry__Group_2__3__Impl : ( 'P' ) ;
    public final void rule__PMultiEntry__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3034:1: ( ( 'P' ) )
            // InternalIGES.g:3035:1: ( 'P' )
            {
            // InternalIGES.g:3035:1: ( 'P' )
            // InternalIGES.g:3036:2: 'P'
            {
             before(grammarAccess.getPMultiEntryAccess().getPKeyword_2_3()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getPMultiEntryAccess().getPKeyword_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group_2__3__Impl"


    // $ANTLR start "rule__PMultiEntry__Group_2__4"
    // InternalIGES.g:3045:1: rule__PMultiEntry__Group_2__4 : rule__PMultiEntry__Group_2__4__Impl rule__PMultiEntry__Group_2__5 ;
    public final void rule__PMultiEntry__Group_2__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3049:1: ( rule__PMultiEntry__Group_2__4__Impl rule__PMultiEntry__Group_2__5 )
            // InternalIGES.g:3050:2: rule__PMultiEntry__Group_2__4__Impl rule__PMultiEntry__Group_2__5
            {
            pushFollow(FOLLOW_13);
            rule__PMultiEntry__Group_2__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PMultiEntry__Group_2__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group_2__4"


    // $ANTLR start "rule__PMultiEntry__Group_2__4__Impl"
    // InternalIGES.g:3057:1: rule__PMultiEntry__Group_2__4__Impl : ( ( RULE_WS )? ) ;
    public final void rule__PMultiEntry__Group_2__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3061:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:3062:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:3062:1: ( ( RULE_WS )? )
            // InternalIGES.g:3063:2: ( RULE_WS )?
            {
             before(grammarAccess.getPMultiEntryAccess().getWSTerminalRuleCall_2_4()); 
            // InternalIGES.g:3064:2: ( RULE_WS )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==RULE_WS) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalIGES.g:3064:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getPMultiEntryAccess().getWSTerminalRuleCall_2_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group_2__4__Impl"


    // $ANTLR start "rule__PMultiEntry__Group_2__5"
    // InternalIGES.g:3072:1: rule__PMultiEntry__Group_2__5 : rule__PMultiEntry__Group_2__5__Impl rule__PMultiEntry__Group_2__6 ;
    public final void rule__PMultiEntry__Group_2__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3076:1: ( rule__PMultiEntry__Group_2__5__Impl rule__PMultiEntry__Group_2__6 )
            // InternalIGES.g:3077:2: rule__PMultiEntry__Group_2__5__Impl rule__PMultiEntry__Group_2__6
            {
            pushFollow(FOLLOW_14);
            rule__PMultiEntry__Group_2__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PMultiEntry__Group_2__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group_2__5"


    // $ANTLR start "rule__PMultiEntry__Group_2__5__Impl"
    // InternalIGES.g:3084:1: rule__PMultiEntry__Group_2__5__Impl : ( ( rule__PMultiEntry__IndiciesAssignment_2_5 ) ) ;
    public final void rule__PMultiEntry__Group_2__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3088:1: ( ( ( rule__PMultiEntry__IndiciesAssignment_2_5 ) ) )
            // InternalIGES.g:3089:1: ( ( rule__PMultiEntry__IndiciesAssignment_2_5 ) )
            {
            // InternalIGES.g:3089:1: ( ( rule__PMultiEntry__IndiciesAssignment_2_5 ) )
            // InternalIGES.g:3090:2: ( rule__PMultiEntry__IndiciesAssignment_2_5 )
            {
             before(grammarAccess.getPMultiEntryAccess().getIndiciesAssignment_2_5()); 
            // InternalIGES.g:3091:2: ( rule__PMultiEntry__IndiciesAssignment_2_5 )
            // InternalIGES.g:3091:3: rule__PMultiEntry__IndiciesAssignment_2_5
            {
            pushFollow(FOLLOW_2);
            rule__PMultiEntry__IndiciesAssignment_2_5();

            state._fsp--;


            }

             after(grammarAccess.getPMultiEntryAccess().getIndiciesAssignment_2_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group_2__5__Impl"


    // $ANTLR start "rule__PMultiEntry__Group_2__6"
    // InternalIGES.g:3099:1: rule__PMultiEntry__Group_2__6 : rule__PMultiEntry__Group_2__6__Impl ;
    public final void rule__PMultiEntry__Group_2__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3103:1: ( rule__PMultiEntry__Group_2__6__Impl )
            // InternalIGES.g:3104:2: rule__PMultiEntry__Group_2__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PMultiEntry__Group_2__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group_2__6"


    // $ANTLR start "rule__PMultiEntry__Group_2__6__Impl"
    // InternalIGES.g:3110:1: rule__PMultiEntry__Group_2__6__Impl : ( RULE_ENDLINE ) ;
    public final void rule__PMultiEntry__Group_2__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3114:1: ( ( RULE_ENDLINE ) )
            // InternalIGES.g:3115:1: ( RULE_ENDLINE )
            {
            // InternalIGES.g:3115:1: ( RULE_ENDLINE )
            // InternalIGES.g:3116:2: RULE_ENDLINE
            {
             before(grammarAccess.getPMultiEntryAccess().getENDLINETerminalRuleCall_2_6()); 
            match(input,RULE_ENDLINE,FOLLOW_2); 
             after(grammarAccess.getPMultiEntryAccess().getENDLINETerminalRuleCall_2_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__Group_2__6__Impl"


    // $ANTLR start "rule__HString__Group__0"
    // InternalIGES.g:3126:1: rule__HString__Group__0 : rule__HString__Group__0__Impl rule__HString__Group__1 ;
    public final void rule__HString__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3130:1: ( rule__HString__Group__0__Impl rule__HString__Group__1 )
            // InternalIGES.g:3131:2: rule__HString__Group__0__Impl rule__HString__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__HString__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HString__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HString__Group__0"


    // $ANTLR start "rule__HString__Group__0__Impl"
    // InternalIGES.g:3138:1: rule__HString__Group__0__Impl : ( ( rule__HString__ValAssignment_0 ) ) ;
    public final void rule__HString__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3142:1: ( ( ( rule__HString__ValAssignment_0 ) ) )
            // InternalIGES.g:3143:1: ( ( rule__HString__ValAssignment_0 ) )
            {
            // InternalIGES.g:3143:1: ( ( rule__HString__ValAssignment_0 ) )
            // InternalIGES.g:3144:2: ( rule__HString__ValAssignment_0 )
            {
             before(grammarAccess.getHStringAccess().getValAssignment_0()); 
            // InternalIGES.g:3145:2: ( rule__HString__ValAssignment_0 )
            // InternalIGES.g:3145:3: rule__HString__ValAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__HString__ValAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getHStringAccess().getValAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HString__Group__0__Impl"


    // $ANTLR start "rule__HString__Group__1"
    // InternalIGES.g:3153:1: rule__HString__Group__1 : rule__HString__Group__1__Impl ;
    public final void rule__HString__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3157:1: ( rule__HString__Group__1__Impl )
            // InternalIGES.g:3158:2: rule__HString__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HString__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HString__Group__1"


    // $ANTLR start "rule__HString__Group__1__Impl"
    // InternalIGES.g:3164:1: rule__HString__Group__1__Impl : ( ( RULE_DELIMITER )? ) ;
    public final void rule__HString__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3168:1: ( ( ( RULE_DELIMITER )? ) )
            // InternalIGES.g:3169:1: ( ( RULE_DELIMITER )? )
            {
            // InternalIGES.g:3169:1: ( ( RULE_DELIMITER )? )
            // InternalIGES.g:3170:2: ( RULE_DELIMITER )?
            {
             before(grammarAccess.getHStringAccess().getDELIMITERTerminalRuleCall_1()); 
            // InternalIGES.g:3171:2: ( RULE_DELIMITER )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_DELIMITER) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalIGES.g:3171:3: RULE_DELIMITER
                    {
                    match(input,RULE_DELIMITER,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getHStringAccess().getDELIMITERTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HString__Group__1__Impl"


    // $ANTLR start "rule__Param__Group__0"
    // InternalIGES.g:3180:1: rule__Param__Group__0 : rule__Param__Group__0__Impl rule__Param__Group__1 ;
    public final void rule__Param__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3184:1: ( rule__Param__Group__0__Impl rule__Param__Group__1 )
            // InternalIGES.g:3185:2: rule__Param__Group__0__Impl rule__Param__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__Param__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Param__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Param__Group__0"


    // $ANTLR start "rule__Param__Group__0__Impl"
    // InternalIGES.g:3192:1: rule__Param__Group__0__Impl : ( ( rule__Param__ValAssignment_0 ) ) ;
    public final void rule__Param__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3196:1: ( ( ( rule__Param__ValAssignment_0 ) ) )
            // InternalIGES.g:3197:1: ( ( rule__Param__ValAssignment_0 ) )
            {
            // InternalIGES.g:3197:1: ( ( rule__Param__ValAssignment_0 ) )
            // InternalIGES.g:3198:2: ( rule__Param__ValAssignment_0 )
            {
             before(grammarAccess.getParamAccess().getValAssignment_0()); 
            // InternalIGES.g:3199:2: ( rule__Param__ValAssignment_0 )
            // InternalIGES.g:3199:3: rule__Param__ValAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Param__ValAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getParamAccess().getValAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Param__Group__0__Impl"


    // $ANTLR start "rule__Param__Group__1"
    // InternalIGES.g:3207:1: rule__Param__Group__1 : rule__Param__Group__1__Impl ;
    public final void rule__Param__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3211:1: ( rule__Param__Group__1__Impl )
            // InternalIGES.g:3212:2: rule__Param__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Param__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Param__Group__1"


    // $ANTLR start "rule__Param__Group__1__Impl"
    // InternalIGES.g:3218:1: rule__Param__Group__1__Impl : ( ( RULE_DELIMITER )? ) ;
    public final void rule__Param__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3222:1: ( ( ( RULE_DELIMITER )? ) )
            // InternalIGES.g:3223:1: ( ( RULE_DELIMITER )? )
            {
            // InternalIGES.g:3223:1: ( ( RULE_DELIMITER )? )
            // InternalIGES.g:3224:2: ( RULE_DELIMITER )?
            {
             before(grammarAccess.getParamAccess().getDELIMITERTerminalRuleCall_1()); 
            // InternalIGES.g:3225:2: ( RULE_DELIMITER )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==RULE_DELIMITER) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalIGES.g:3225:3: RULE_DELIMITER
                    {
                    match(input,RULE_DELIMITER,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getParamAccess().getDELIMITERTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Param__Group__1__Impl"


    // $ANTLR start "rule__Pointer__Group__0"
    // InternalIGES.g:3234:1: rule__Pointer__Group__0 : rule__Pointer__Group__0__Impl rule__Pointer__Group__1 ;
    public final void rule__Pointer__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3238:1: ( rule__Pointer__Group__0__Impl rule__Pointer__Group__1 )
            // InternalIGES.g:3239:2: rule__Pointer__Group__0__Impl rule__Pointer__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__Pointer__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Pointer__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Pointer__Group__0"


    // $ANTLR start "rule__Pointer__Group__0__Impl"
    // InternalIGES.g:3246:1: rule__Pointer__Group__0__Impl : ( ( rule__Pointer__ValAssignment_0 ) ) ;
    public final void rule__Pointer__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3250:1: ( ( ( rule__Pointer__ValAssignment_0 ) ) )
            // InternalIGES.g:3251:1: ( ( rule__Pointer__ValAssignment_0 ) )
            {
            // InternalIGES.g:3251:1: ( ( rule__Pointer__ValAssignment_0 ) )
            // InternalIGES.g:3252:2: ( rule__Pointer__ValAssignment_0 )
            {
             before(grammarAccess.getPointerAccess().getValAssignment_0()); 
            // InternalIGES.g:3253:2: ( rule__Pointer__ValAssignment_0 )
            // InternalIGES.g:3253:3: rule__Pointer__ValAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Pointer__ValAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getPointerAccess().getValAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Pointer__Group__0__Impl"


    // $ANTLR start "rule__Pointer__Group__1"
    // InternalIGES.g:3261:1: rule__Pointer__Group__1 : rule__Pointer__Group__1__Impl ;
    public final void rule__Pointer__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3265:1: ( rule__Pointer__Group__1__Impl )
            // InternalIGES.g:3266:2: rule__Pointer__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Pointer__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Pointer__Group__1"


    // $ANTLR start "rule__Pointer__Group__1__Impl"
    // InternalIGES.g:3272:1: rule__Pointer__Group__1__Impl : ( ( RULE_DELIMITER )? ) ;
    public final void rule__Pointer__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3276:1: ( ( ( RULE_DELIMITER )? ) )
            // InternalIGES.g:3277:1: ( ( RULE_DELIMITER )? )
            {
            // InternalIGES.g:3277:1: ( ( RULE_DELIMITER )? )
            // InternalIGES.g:3278:2: ( RULE_DELIMITER )?
            {
             before(grammarAccess.getPointerAccess().getDELIMITERTerminalRuleCall_1()); 
            // InternalIGES.g:3279:2: ( RULE_DELIMITER )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_DELIMITER) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalIGES.g:3279:3: RULE_DELIMITER
                    {
                    match(input,RULE_DELIMITER,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getPointerAccess().getDELIMITERTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Pointer__Group__1__Impl"


    // $ANTLR start "rule__End__Group__0"
    // InternalIGES.g:3288:1: rule__End__Group__0 : rule__End__Group__0__Impl rule__End__Group__1 ;
    public final void rule__End__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3292:1: ( rule__End__Group__0__Impl rule__End__Group__1 )
            // InternalIGES.g:3293:2: rule__End__Group__0__Impl rule__End__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__End__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__End__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__0"


    // $ANTLR start "rule__End__Group__0__Impl"
    // InternalIGES.g:3300:1: rule__End__Group__0__Impl : ( 'S' ) ;
    public final void rule__End__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3304:1: ( ( 'S' ) )
            // InternalIGES.g:3305:1: ( 'S' )
            {
            // InternalIGES.g:3305:1: ( 'S' )
            // InternalIGES.g:3306:2: 'S'
            {
             before(grammarAccess.getEndAccess().getSKeyword_0()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getEndAccess().getSKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__0__Impl"


    // $ANTLR start "rule__End__Group__1"
    // InternalIGES.g:3315:1: rule__End__Group__1 : rule__End__Group__1__Impl rule__End__Group__2 ;
    public final void rule__End__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3319:1: ( rule__End__Group__1__Impl rule__End__Group__2 )
            // InternalIGES.g:3320:2: rule__End__Group__1__Impl rule__End__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__End__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__End__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__1"


    // $ANTLR start "rule__End__Group__1__Impl"
    // InternalIGES.g:3327:1: rule__End__Group__1__Impl : ( ( RULE_WS )? ) ;
    public final void rule__End__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3331:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:3332:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:3332:1: ( ( RULE_WS )? )
            // InternalIGES.g:3333:2: ( RULE_WS )?
            {
             before(grammarAccess.getEndAccess().getWSTerminalRuleCall_1()); 
            // InternalIGES.g:3334:2: ( RULE_WS )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==RULE_WS) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalIGES.g:3334:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEndAccess().getWSTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__1__Impl"


    // $ANTLR start "rule__End__Group__2"
    // InternalIGES.g:3342:1: rule__End__Group__2 : rule__End__Group__2__Impl rule__End__Group__3 ;
    public final void rule__End__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3346:1: ( rule__End__Group__2__Impl rule__End__Group__3 )
            // InternalIGES.g:3347:2: rule__End__Group__2__Impl rule__End__Group__3
            {
            pushFollow(FOLLOW_21);
            rule__End__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__End__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__2"


    // $ANTLR start "rule__End__Group__2__Impl"
    // InternalIGES.g:3354:1: rule__End__Group__2__Impl : ( ( rule__End__SvalAssignment_2 ) ) ;
    public final void rule__End__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3358:1: ( ( ( rule__End__SvalAssignment_2 ) ) )
            // InternalIGES.g:3359:1: ( ( rule__End__SvalAssignment_2 ) )
            {
            // InternalIGES.g:3359:1: ( ( rule__End__SvalAssignment_2 ) )
            // InternalIGES.g:3360:2: ( rule__End__SvalAssignment_2 )
            {
             before(grammarAccess.getEndAccess().getSvalAssignment_2()); 
            // InternalIGES.g:3361:2: ( rule__End__SvalAssignment_2 )
            // InternalIGES.g:3361:3: rule__End__SvalAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__End__SvalAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getEndAccess().getSvalAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__2__Impl"


    // $ANTLR start "rule__End__Group__3"
    // InternalIGES.g:3369:1: rule__End__Group__3 : rule__End__Group__3__Impl rule__End__Group__4 ;
    public final void rule__End__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3373:1: ( rule__End__Group__3__Impl rule__End__Group__4 )
            // InternalIGES.g:3374:2: rule__End__Group__3__Impl rule__End__Group__4
            {
            pushFollow(FOLLOW_13);
            rule__End__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__End__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__3"


    // $ANTLR start "rule__End__Group__3__Impl"
    // InternalIGES.g:3381:1: rule__End__Group__3__Impl : ( 'G' ) ;
    public final void rule__End__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3385:1: ( ( 'G' ) )
            // InternalIGES.g:3386:1: ( 'G' )
            {
            // InternalIGES.g:3386:1: ( 'G' )
            // InternalIGES.g:3387:2: 'G'
            {
             before(grammarAccess.getEndAccess().getGKeyword_3()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getEndAccess().getGKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__3__Impl"


    // $ANTLR start "rule__End__Group__4"
    // InternalIGES.g:3396:1: rule__End__Group__4 : rule__End__Group__4__Impl rule__End__Group__5 ;
    public final void rule__End__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3400:1: ( rule__End__Group__4__Impl rule__End__Group__5 )
            // InternalIGES.g:3401:2: rule__End__Group__4__Impl rule__End__Group__5
            {
            pushFollow(FOLLOW_13);
            rule__End__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__End__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__4"


    // $ANTLR start "rule__End__Group__4__Impl"
    // InternalIGES.g:3408:1: rule__End__Group__4__Impl : ( ( RULE_WS )? ) ;
    public final void rule__End__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3412:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:3413:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:3413:1: ( ( RULE_WS )? )
            // InternalIGES.g:3414:2: ( RULE_WS )?
            {
             before(grammarAccess.getEndAccess().getWSTerminalRuleCall_4()); 
            // InternalIGES.g:3415:2: ( RULE_WS )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==RULE_WS) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalIGES.g:3415:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEndAccess().getWSTerminalRuleCall_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__4__Impl"


    // $ANTLR start "rule__End__Group__5"
    // InternalIGES.g:3423:1: rule__End__Group__5 : rule__End__Group__5__Impl rule__End__Group__6 ;
    public final void rule__End__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3427:1: ( rule__End__Group__5__Impl rule__End__Group__6 )
            // InternalIGES.g:3428:2: rule__End__Group__5__Impl rule__End__Group__6
            {
            pushFollow(FOLLOW_15);
            rule__End__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__End__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__5"


    // $ANTLR start "rule__End__Group__5__Impl"
    // InternalIGES.g:3435:1: rule__End__Group__5__Impl : ( ( rule__End__GvalAssignment_5 ) ) ;
    public final void rule__End__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3439:1: ( ( ( rule__End__GvalAssignment_5 ) ) )
            // InternalIGES.g:3440:1: ( ( rule__End__GvalAssignment_5 ) )
            {
            // InternalIGES.g:3440:1: ( ( rule__End__GvalAssignment_5 ) )
            // InternalIGES.g:3441:2: ( rule__End__GvalAssignment_5 )
            {
             before(grammarAccess.getEndAccess().getGvalAssignment_5()); 
            // InternalIGES.g:3442:2: ( rule__End__GvalAssignment_5 )
            // InternalIGES.g:3442:3: rule__End__GvalAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__End__GvalAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getEndAccess().getGvalAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__5__Impl"


    // $ANTLR start "rule__End__Group__6"
    // InternalIGES.g:3450:1: rule__End__Group__6 : rule__End__Group__6__Impl rule__End__Group__7 ;
    public final void rule__End__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3454:1: ( rule__End__Group__6__Impl rule__End__Group__7 )
            // InternalIGES.g:3455:2: rule__End__Group__6__Impl rule__End__Group__7
            {
            pushFollow(FOLLOW_13);
            rule__End__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__End__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__6"


    // $ANTLR start "rule__End__Group__6__Impl"
    // InternalIGES.g:3462:1: rule__End__Group__6__Impl : ( 'D' ) ;
    public final void rule__End__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3466:1: ( ( 'D' ) )
            // InternalIGES.g:3467:1: ( 'D' )
            {
            // InternalIGES.g:3467:1: ( 'D' )
            // InternalIGES.g:3468:2: 'D'
            {
             before(grammarAccess.getEndAccess().getDKeyword_6()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getEndAccess().getDKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__6__Impl"


    // $ANTLR start "rule__End__Group__7"
    // InternalIGES.g:3477:1: rule__End__Group__7 : rule__End__Group__7__Impl rule__End__Group__8 ;
    public final void rule__End__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3481:1: ( rule__End__Group__7__Impl rule__End__Group__8 )
            // InternalIGES.g:3482:2: rule__End__Group__7__Impl rule__End__Group__8
            {
            pushFollow(FOLLOW_13);
            rule__End__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__End__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__7"


    // $ANTLR start "rule__End__Group__7__Impl"
    // InternalIGES.g:3489:1: rule__End__Group__7__Impl : ( ( RULE_WS )? ) ;
    public final void rule__End__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3493:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:3494:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:3494:1: ( ( RULE_WS )? )
            // InternalIGES.g:3495:2: ( RULE_WS )?
            {
             before(grammarAccess.getEndAccess().getWSTerminalRuleCall_7()); 
            // InternalIGES.g:3496:2: ( RULE_WS )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_WS) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalIGES.g:3496:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEndAccess().getWSTerminalRuleCall_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__7__Impl"


    // $ANTLR start "rule__End__Group__8"
    // InternalIGES.g:3504:1: rule__End__Group__8 : rule__End__Group__8__Impl rule__End__Group__9 ;
    public final void rule__End__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3508:1: ( rule__End__Group__8__Impl rule__End__Group__9 )
            // InternalIGES.g:3509:2: rule__End__Group__8__Impl rule__End__Group__9
            {
            pushFollow(FOLLOW_17);
            rule__End__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__End__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__8"


    // $ANTLR start "rule__End__Group__8__Impl"
    // InternalIGES.g:3516:1: rule__End__Group__8__Impl : ( ( rule__End__DvalAssignment_8 ) ) ;
    public final void rule__End__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3520:1: ( ( ( rule__End__DvalAssignment_8 ) ) )
            // InternalIGES.g:3521:1: ( ( rule__End__DvalAssignment_8 ) )
            {
            // InternalIGES.g:3521:1: ( ( rule__End__DvalAssignment_8 ) )
            // InternalIGES.g:3522:2: ( rule__End__DvalAssignment_8 )
            {
             before(grammarAccess.getEndAccess().getDvalAssignment_8()); 
            // InternalIGES.g:3523:2: ( rule__End__DvalAssignment_8 )
            // InternalIGES.g:3523:3: rule__End__DvalAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__End__DvalAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getEndAccess().getDvalAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__8__Impl"


    // $ANTLR start "rule__End__Group__9"
    // InternalIGES.g:3531:1: rule__End__Group__9 : rule__End__Group__9__Impl rule__End__Group__10 ;
    public final void rule__End__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3535:1: ( rule__End__Group__9__Impl rule__End__Group__10 )
            // InternalIGES.g:3536:2: rule__End__Group__9__Impl rule__End__Group__10
            {
            pushFollow(FOLLOW_13);
            rule__End__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__End__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__9"


    // $ANTLR start "rule__End__Group__9__Impl"
    // InternalIGES.g:3543:1: rule__End__Group__9__Impl : ( 'P' ) ;
    public final void rule__End__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3547:1: ( ( 'P' ) )
            // InternalIGES.g:3548:1: ( 'P' )
            {
            // InternalIGES.g:3548:1: ( 'P' )
            // InternalIGES.g:3549:2: 'P'
            {
             before(grammarAccess.getEndAccess().getPKeyword_9()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getEndAccess().getPKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__9__Impl"


    // $ANTLR start "rule__End__Group__10"
    // InternalIGES.g:3558:1: rule__End__Group__10 : rule__End__Group__10__Impl rule__End__Group__11 ;
    public final void rule__End__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3562:1: ( rule__End__Group__10__Impl rule__End__Group__11 )
            // InternalIGES.g:3563:2: rule__End__Group__10__Impl rule__End__Group__11
            {
            pushFollow(FOLLOW_13);
            rule__End__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__End__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__10"


    // $ANTLR start "rule__End__Group__10__Impl"
    // InternalIGES.g:3570:1: rule__End__Group__10__Impl : ( ( RULE_WS )? ) ;
    public final void rule__End__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3574:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:3575:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:3575:1: ( ( RULE_WS )? )
            // InternalIGES.g:3576:2: ( RULE_WS )?
            {
             before(grammarAccess.getEndAccess().getWSTerminalRuleCall_10()); 
            // InternalIGES.g:3577:2: ( RULE_WS )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==RULE_WS) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalIGES.g:3577:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEndAccess().getWSTerminalRuleCall_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__10__Impl"


    // $ANTLR start "rule__End__Group__11"
    // InternalIGES.g:3585:1: rule__End__Group__11 : rule__End__Group__11__Impl rule__End__Group__12 ;
    public final void rule__End__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3589:1: ( rule__End__Group__11__Impl rule__End__Group__12 )
            // InternalIGES.g:3590:2: rule__End__Group__11__Impl rule__End__Group__12
            {
            pushFollow(FOLLOW_7);
            rule__End__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__End__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__11"


    // $ANTLR start "rule__End__Group__11__Impl"
    // InternalIGES.g:3597:1: rule__End__Group__11__Impl : ( ( rule__End__PvalAssignment_11 ) ) ;
    public final void rule__End__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3601:1: ( ( ( rule__End__PvalAssignment_11 ) ) )
            // InternalIGES.g:3602:1: ( ( rule__End__PvalAssignment_11 ) )
            {
            // InternalIGES.g:3602:1: ( ( rule__End__PvalAssignment_11 ) )
            // InternalIGES.g:3603:2: ( rule__End__PvalAssignment_11 )
            {
             before(grammarAccess.getEndAccess().getPvalAssignment_11()); 
            // InternalIGES.g:3604:2: ( rule__End__PvalAssignment_11 )
            // InternalIGES.g:3604:3: rule__End__PvalAssignment_11
            {
            pushFollow(FOLLOW_2);
            rule__End__PvalAssignment_11();

            state._fsp--;


            }

             after(grammarAccess.getEndAccess().getPvalAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__11__Impl"


    // $ANTLR start "rule__End__Group__12"
    // InternalIGES.g:3612:1: rule__End__Group__12 : rule__End__Group__12__Impl rule__End__Group__13 ;
    public final void rule__End__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3616:1: ( rule__End__Group__12__Impl rule__End__Group__13 )
            // InternalIGES.g:3617:2: rule__End__Group__12__Impl rule__End__Group__13
            {
            pushFollow(FOLLOW_22);
            rule__End__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__End__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__12"


    // $ANTLR start "rule__End__Group__12__Impl"
    // InternalIGES.g:3624:1: rule__End__Group__12__Impl : ( RULE_WS ) ;
    public final void rule__End__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3628:1: ( ( RULE_WS ) )
            // InternalIGES.g:3629:1: ( RULE_WS )
            {
            // InternalIGES.g:3629:1: ( RULE_WS )
            // InternalIGES.g:3630:2: RULE_WS
            {
             before(grammarAccess.getEndAccess().getWSTerminalRuleCall_12()); 
            match(input,RULE_WS,FOLLOW_2); 
             after(grammarAccess.getEndAccess().getWSTerminalRuleCall_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__12__Impl"


    // $ANTLR start "rule__End__Group__13"
    // InternalIGES.g:3639:1: rule__End__Group__13 : rule__End__Group__13__Impl rule__End__Group__14 ;
    public final void rule__End__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3643:1: ( rule__End__Group__13__Impl rule__End__Group__14 )
            // InternalIGES.g:3644:2: rule__End__Group__13__Impl rule__End__Group__14
            {
            pushFollow(FOLLOW_13);
            rule__End__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__End__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__13"


    // $ANTLR start "rule__End__Group__13__Impl"
    // InternalIGES.g:3651:1: rule__End__Group__13__Impl : ( 'T' ) ;
    public final void rule__End__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3655:1: ( ( 'T' ) )
            // InternalIGES.g:3656:1: ( 'T' )
            {
            // InternalIGES.g:3656:1: ( 'T' )
            // InternalIGES.g:3657:2: 'T'
            {
             before(grammarAccess.getEndAccess().getTKeyword_13()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getEndAccess().getTKeyword_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__13__Impl"


    // $ANTLR start "rule__End__Group__14"
    // InternalIGES.g:3666:1: rule__End__Group__14 : rule__End__Group__14__Impl rule__End__Group__15 ;
    public final void rule__End__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3670:1: ( rule__End__Group__14__Impl rule__End__Group__15 )
            // InternalIGES.g:3671:2: rule__End__Group__14__Impl rule__End__Group__15
            {
            pushFollow(FOLLOW_13);
            rule__End__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__End__Group__15();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__14"


    // $ANTLR start "rule__End__Group__14__Impl"
    // InternalIGES.g:3678:1: rule__End__Group__14__Impl : ( ( RULE_WS )? ) ;
    public final void rule__End__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3682:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:3683:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:3683:1: ( ( RULE_WS )? )
            // InternalIGES.g:3684:2: ( RULE_WS )?
            {
             before(grammarAccess.getEndAccess().getWSTerminalRuleCall_14()); 
            // InternalIGES.g:3685:2: ( RULE_WS )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==RULE_WS) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalIGES.g:3685:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEndAccess().getWSTerminalRuleCall_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__14__Impl"


    // $ANTLR start "rule__End__Group__15"
    // InternalIGES.g:3693:1: rule__End__Group__15 : rule__End__Group__15__Impl ;
    public final void rule__End__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3697:1: ( rule__End__Group__15__Impl )
            // InternalIGES.g:3698:2: rule__End__Group__15__Impl
            {
            pushFollow(FOLLOW_2);
            rule__End__Group__15__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__15"


    // $ANTLR start "rule__End__Group__15__Impl"
    // InternalIGES.g:3704:1: rule__End__Group__15__Impl : ( ( rule__End__TvalAssignment_15 ) ) ;
    public final void rule__End__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3708:1: ( ( ( rule__End__TvalAssignment_15 ) ) )
            // InternalIGES.g:3709:1: ( ( rule__End__TvalAssignment_15 ) )
            {
            // InternalIGES.g:3709:1: ( ( rule__End__TvalAssignment_15 ) )
            // InternalIGES.g:3710:2: ( rule__End__TvalAssignment_15 )
            {
             before(grammarAccess.getEndAccess().getTvalAssignment_15()); 
            // InternalIGES.g:3711:2: ( rule__End__TvalAssignment_15 )
            // InternalIGES.g:3711:3: rule__End__TvalAssignment_15
            {
            pushFollow(FOLLOW_2);
            rule__End__TvalAssignment_15();

            state._fsp--;


            }

             after(grammarAccess.getEndAccess().getTvalAssignment_15()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__Group__15__Impl"


    // $ANTLR start "rule__StartLine__Group__0"
    // InternalIGES.g:3720:1: rule__StartLine__Group__0 : rule__StartLine__Group__0__Impl rule__StartLine__Group__1 ;
    public final void rule__StartLine__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3724:1: ( rule__StartLine__Group__0__Impl rule__StartLine__Group__1 )
            // InternalIGES.g:3725:2: rule__StartLine__Group__0__Impl rule__StartLine__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__StartLine__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StartLine__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartLine__Group__0"


    // $ANTLR start "rule__StartLine__Group__0__Impl"
    // InternalIGES.g:3732:1: rule__StartLine__Group__0__Impl : ( ( rule__StartLine__Alternatives_0 )* ) ;
    public final void rule__StartLine__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3736:1: ( ( ( rule__StartLine__Alternatives_0 )* ) )
            // InternalIGES.g:3737:1: ( ( rule__StartLine__Alternatives_0 )* )
            {
            // InternalIGES.g:3737:1: ( ( rule__StartLine__Alternatives_0 )* )
            // InternalIGES.g:3738:2: ( rule__StartLine__Alternatives_0 )*
            {
             before(grammarAccess.getStartLineAccess().getAlternatives_0()); 
            // InternalIGES.g:3739:2: ( rule__StartLine__Alternatives_0 )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( ((LA62_0>=RULE_STRING && LA62_0<=RULE_WS)) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalIGES.g:3739:3: rule__StartLine__Alternatives_0
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__StartLine__Alternatives_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);

             after(grammarAccess.getStartLineAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartLine__Group__0__Impl"


    // $ANTLR start "rule__StartLine__Group__1"
    // InternalIGES.g:3747:1: rule__StartLine__Group__1 : rule__StartLine__Group__1__Impl rule__StartLine__Group__2 ;
    public final void rule__StartLine__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3751:1: ( rule__StartLine__Group__1__Impl rule__StartLine__Group__2 )
            // InternalIGES.g:3752:2: rule__StartLine__Group__1__Impl rule__StartLine__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__StartLine__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StartLine__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartLine__Group__1"


    // $ANTLR start "rule__StartLine__Group__1__Impl"
    // InternalIGES.g:3759:1: rule__StartLine__Group__1__Impl : ( 'S' ) ;
    public final void rule__StartLine__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3763:1: ( ( 'S' ) )
            // InternalIGES.g:3764:1: ( 'S' )
            {
            // InternalIGES.g:3764:1: ( 'S' )
            // InternalIGES.g:3765:2: 'S'
            {
             before(grammarAccess.getStartLineAccess().getSKeyword_1()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getStartLineAccess().getSKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartLine__Group__1__Impl"


    // $ANTLR start "rule__StartLine__Group__2"
    // InternalIGES.g:3774:1: rule__StartLine__Group__2 : rule__StartLine__Group__2__Impl rule__StartLine__Group__3 ;
    public final void rule__StartLine__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3778:1: ( rule__StartLine__Group__2__Impl rule__StartLine__Group__3 )
            // InternalIGES.g:3779:2: rule__StartLine__Group__2__Impl rule__StartLine__Group__3
            {
            pushFollow(FOLLOW_13);
            rule__StartLine__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StartLine__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartLine__Group__2"


    // $ANTLR start "rule__StartLine__Group__2__Impl"
    // InternalIGES.g:3786:1: rule__StartLine__Group__2__Impl : ( ( RULE_WS )? ) ;
    public final void rule__StartLine__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3790:1: ( ( ( RULE_WS )? ) )
            // InternalIGES.g:3791:1: ( ( RULE_WS )? )
            {
            // InternalIGES.g:3791:1: ( ( RULE_WS )? )
            // InternalIGES.g:3792:2: ( RULE_WS )?
            {
             before(grammarAccess.getStartLineAccess().getWSTerminalRuleCall_2()); 
            // InternalIGES.g:3793:2: ( RULE_WS )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==RULE_WS) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalIGES.g:3793:3: RULE_WS
                    {
                    match(input,RULE_WS,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getStartLineAccess().getWSTerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartLine__Group__2__Impl"


    // $ANTLR start "rule__StartLine__Group__3"
    // InternalIGES.g:3801:1: rule__StartLine__Group__3 : rule__StartLine__Group__3__Impl rule__StartLine__Group__4 ;
    public final void rule__StartLine__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3805:1: ( rule__StartLine__Group__3__Impl rule__StartLine__Group__4 )
            // InternalIGES.g:3806:2: rule__StartLine__Group__3__Impl rule__StartLine__Group__4
            {
            pushFollow(FOLLOW_14);
            rule__StartLine__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StartLine__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartLine__Group__3"


    // $ANTLR start "rule__StartLine__Group__3__Impl"
    // InternalIGES.g:3813:1: rule__StartLine__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__StartLine__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3817:1: ( ( RULE_INT ) )
            // InternalIGES.g:3818:1: ( RULE_INT )
            {
            // InternalIGES.g:3818:1: ( RULE_INT )
            // InternalIGES.g:3819:2: RULE_INT
            {
             before(grammarAccess.getStartLineAccess().getINTTerminalRuleCall_3()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getStartLineAccess().getINTTerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartLine__Group__3__Impl"


    // $ANTLR start "rule__StartLine__Group__4"
    // InternalIGES.g:3828:1: rule__StartLine__Group__4 : rule__StartLine__Group__4__Impl ;
    public final void rule__StartLine__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3832:1: ( rule__StartLine__Group__4__Impl )
            // InternalIGES.g:3833:2: rule__StartLine__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__StartLine__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartLine__Group__4"


    // $ANTLR start "rule__StartLine__Group__4__Impl"
    // InternalIGES.g:3839:1: rule__StartLine__Group__4__Impl : ( RULE_ENDLINE ) ;
    public final void rule__StartLine__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3843:1: ( ( RULE_ENDLINE ) )
            // InternalIGES.g:3844:1: ( RULE_ENDLINE )
            {
            // InternalIGES.g:3844:1: ( RULE_ENDLINE )
            // InternalIGES.g:3845:2: RULE_ENDLINE
            {
             before(grammarAccess.getStartLineAccess().getENDLINETerminalRuleCall_4()); 
            match(input,RULE_ENDLINE,FOLLOW_2); 
             after(grammarAccess.getStartLineAccess().getENDLINETerminalRuleCall_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartLine__Group__4__Impl"


    // $ANTLR start "rule__IGES__StartAssignment_0"
    // InternalIGES.g:3855:1: rule__IGES__StartAssignment_0 : ( ruleStart ) ;
    public final void rule__IGES__StartAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3859:1: ( ( ruleStart ) )
            // InternalIGES.g:3860:2: ( ruleStart )
            {
            // InternalIGES.g:3860:2: ( ruleStart )
            // InternalIGES.g:3861:3: ruleStart
            {
             before(grammarAccess.getIGESAccess().getStartStartParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleStart();

            state._fsp--;

             after(grammarAccess.getIGESAccess().getStartStartParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IGES__StartAssignment_0"


    // $ANTLR start "rule__IGES__GlobalAssignment_1"
    // InternalIGES.g:3870:1: rule__IGES__GlobalAssignment_1 : ( ruleGlobal ) ;
    public final void rule__IGES__GlobalAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3874:1: ( ( ruleGlobal ) )
            // InternalIGES.g:3875:2: ( ruleGlobal )
            {
            // InternalIGES.g:3875:2: ( ruleGlobal )
            // InternalIGES.g:3876:3: ruleGlobal
            {
             before(grammarAccess.getIGESAccess().getGlobalGlobalParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleGlobal();

            state._fsp--;

             after(grammarAccess.getIGESAccess().getGlobalGlobalParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IGES__GlobalAssignment_1"


    // $ANTLR start "rule__IGES__DataAssignment_2"
    // InternalIGES.g:3885:1: rule__IGES__DataAssignment_2 : ( ruleData ) ;
    public final void rule__IGES__DataAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3889:1: ( ( ruleData ) )
            // InternalIGES.g:3890:2: ( ruleData )
            {
            // InternalIGES.g:3890:2: ( ruleData )
            // InternalIGES.g:3891:3: ruleData
            {
             before(grammarAccess.getIGESAccess().getDataDataParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleData();

            state._fsp--;

             after(grammarAccess.getIGESAccess().getDataDataParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IGES__DataAssignment_2"


    // $ANTLR start "rule__IGES__ParametersAssignment_3"
    // InternalIGES.g:3900:1: rule__IGES__ParametersAssignment_3 : ( ruleParameters ) ;
    public final void rule__IGES__ParametersAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3904:1: ( ( ruleParameters ) )
            // InternalIGES.g:3905:2: ( ruleParameters )
            {
            // InternalIGES.g:3905:2: ( ruleParameters )
            // InternalIGES.g:3906:3: ruleParameters
            {
             before(grammarAccess.getIGESAccess().getParametersParametersParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleParameters();

            state._fsp--;

             after(grammarAccess.getIGESAccess().getParametersParametersParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IGES__ParametersAssignment_3"


    // $ANTLR start "rule__IGES__EndAssignment_4"
    // InternalIGES.g:3915:1: rule__IGES__EndAssignment_4 : ( ruleEnd ) ;
    public final void rule__IGES__EndAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3919:1: ( ( ruleEnd ) )
            // InternalIGES.g:3920:2: ( ruleEnd )
            {
            // InternalIGES.g:3920:2: ( ruleEnd )
            // InternalIGES.g:3921:3: ruleEnd
            {
             before(grammarAccess.getIGESAccess().getEndEndParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleEnd();

            state._fsp--;

             after(grammarAccess.getIGESAccess().getEndEndParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IGES__EndAssignment_4"


    // $ANTLR start "rule__Start__LinesAssignment"
    // InternalIGES.g:3930:1: rule__Start__LinesAssignment : ( rulestartLine ) ;
    public final void rule__Start__LinesAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3934:1: ( ( rulestartLine ) )
            // InternalIGES.g:3935:2: ( rulestartLine )
            {
            // InternalIGES.g:3935:2: ( rulestartLine )
            // InternalIGES.g:3936:3: rulestartLine
            {
             before(grammarAccess.getStartAccess().getLinesStartLineParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            rulestartLine();

            state._fsp--;

             after(grammarAccess.getStartAccess().getLinesStartLineParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Start__LinesAssignment"


    // $ANTLR start "rule__Global__ValuesAssignment_3_0"
    // InternalIGES.g:3945:1: rule__Global__ValuesAssignment_3_0 : ( ruleValue ) ;
    public final void rule__Global__ValuesAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3949:1: ( ( ruleValue ) )
            // InternalIGES.g:3950:2: ( ruleValue )
            {
            // InternalIGES.g:3950:2: ( ruleValue )
            // InternalIGES.g:3951:3: ruleValue
            {
             before(grammarAccess.getGlobalAccess().getValuesValueParserRuleCall_3_0_0()); 
            pushFollow(FOLLOW_2);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getGlobalAccess().getValuesValueParserRuleCall_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__ValuesAssignment_3_0"


    // $ANTLR start "rule__Global__ValuesAssignment_4"
    // InternalIGES.g:3960:1: rule__Global__ValuesAssignment_4 : ( ruleValue ) ;
    public final void rule__Global__ValuesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3964:1: ( ( ruleValue ) )
            // InternalIGES.g:3965:2: ( ruleValue )
            {
            // InternalIGES.g:3965:2: ( ruleValue )
            // InternalIGES.g:3966:3: ruleValue
            {
             before(grammarAccess.getGlobalAccess().getValuesValueParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getGlobalAccess().getValuesValueParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Global__ValuesAssignment_4"


    // $ANTLR start "rule__Data__EntriesAssignment"
    // InternalIGES.g:3975:1: rule__Data__EntriesAssignment : ( ruleEntry ) ;
    public final void rule__Data__EntriesAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3979:1: ( ( ruleEntry ) )
            // InternalIGES.g:3980:2: ( ruleEntry )
            {
            // InternalIGES.g:3980:2: ( ruleEntry )
            // InternalIGES.g:3981:3: ruleEntry
            {
             before(grammarAccess.getDataAccess().getEntriesEntryParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleEntry();

            state._fsp--;

             after(grammarAccess.getDataAccess().getEntriesEntryParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Data__EntriesAssignment"


    // $ANTLR start "rule__Entry__TypeAssignment_1"
    // InternalIGES.g:3990:1: rule__Entry__TypeAssignment_1 : ( RULE_INT ) ;
    public final void rule__Entry__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:3994:1: ( ( RULE_INT ) )
            // InternalIGES.g:3995:2: ( RULE_INT )
            {
            // InternalIGES.g:3995:2: ( RULE_INT )
            // InternalIGES.g:3996:3: RULE_INT
            {
             before(grammarAccess.getEntryAccess().getTypeINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEntryAccess().getTypeINTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__TypeAssignment_1"


    // $ANTLR start "rule__Entry__ParamDataAssignment_3"
    // InternalIGES.g:4005:1: rule__Entry__ParamDataAssignment_3 : ( RULE_INT ) ;
    public final void rule__Entry__ParamDataAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4009:1: ( ( RULE_INT ) )
            // InternalIGES.g:4010:2: ( RULE_INT )
            {
            // InternalIGES.g:4010:2: ( RULE_INT )
            // InternalIGES.g:4011:3: RULE_INT
            {
             before(grammarAccess.getEntryAccess().getParamDataINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEntryAccess().getParamDataINTTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__ParamDataAssignment_3"


    // $ANTLR start "rule__Entry__StructureAssignment_5"
    // InternalIGES.g:4020:1: rule__Entry__StructureAssignment_5 : ( RULE_INT ) ;
    public final void rule__Entry__StructureAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4024:1: ( ( RULE_INT ) )
            // InternalIGES.g:4025:2: ( RULE_INT )
            {
            // InternalIGES.g:4025:2: ( RULE_INT )
            // InternalIGES.g:4026:3: RULE_INT
            {
             before(grammarAccess.getEntryAccess().getStructureINTTerminalRuleCall_5_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEntryAccess().getStructureINTTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__StructureAssignment_5"


    // $ANTLR start "rule__Entry__LineFontAssignment_7"
    // InternalIGES.g:4035:1: rule__Entry__LineFontAssignment_7 : ( RULE_INT ) ;
    public final void rule__Entry__LineFontAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4039:1: ( ( RULE_INT ) )
            // InternalIGES.g:4040:2: ( RULE_INT )
            {
            // InternalIGES.g:4040:2: ( RULE_INT )
            // InternalIGES.g:4041:3: RULE_INT
            {
             before(grammarAccess.getEntryAccess().getLineFontINTTerminalRuleCall_7_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEntryAccess().getLineFontINTTerminalRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__LineFontAssignment_7"


    // $ANTLR start "rule__Entry__LevelAssignment_9"
    // InternalIGES.g:4050:1: rule__Entry__LevelAssignment_9 : ( RULE_INT ) ;
    public final void rule__Entry__LevelAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4054:1: ( ( RULE_INT ) )
            // InternalIGES.g:4055:2: ( RULE_INT )
            {
            // InternalIGES.g:4055:2: ( RULE_INT )
            // InternalIGES.g:4056:3: RULE_INT
            {
             before(grammarAccess.getEntryAccess().getLevelINTTerminalRuleCall_9_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEntryAccess().getLevelINTTerminalRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__LevelAssignment_9"


    // $ANTLR start "rule__Entry__ViewAssignment_11"
    // InternalIGES.g:4065:1: rule__Entry__ViewAssignment_11 : ( RULE_INT ) ;
    public final void rule__Entry__ViewAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4069:1: ( ( RULE_INT ) )
            // InternalIGES.g:4070:2: ( RULE_INT )
            {
            // InternalIGES.g:4070:2: ( RULE_INT )
            // InternalIGES.g:4071:3: RULE_INT
            {
             before(grammarAccess.getEntryAccess().getViewINTTerminalRuleCall_11_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEntryAccess().getViewINTTerminalRuleCall_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__ViewAssignment_11"


    // $ANTLR start "rule__Entry__TransformMatrixAssignment_13"
    // InternalIGES.g:4080:1: rule__Entry__TransformMatrixAssignment_13 : ( RULE_INT ) ;
    public final void rule__Entry__TransformMatrixAssignment_13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4084:1: ( ( RULE_INT ) )
            // InternalIGES.g:4085:2: ( RULE_INT )
            {
            // InternalIGES.g:4085:2: ( RULE_INT )
            // InternalIGES.g:4086:3: RULE_INT
            {
             before(grammarAccess.getEntryAccess().getTransformMatrixINTTerminalRuleCall_13_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEntryAccess().getTransformMatrixINTTerminalRuleCall_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__TransformMatrixAssignment_13"


    // $ANTLR start "rule__Entry__StatusAssignment_17"
    // InternalIGES.g:4095:1: rule__Entry__StatusAssignment_17 : ( RULE_INT ) ;
    public final void rule__Entry__StatusAssignment_17() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4099:1: ( ( RULE_INT ) )
            // InternalIGES.g:4100:2: ( RULE_INT )
            {
            // InternalIGES.g:4100:2: ( RULE_INT )
            // InternalIGES.g:4101:3: RULE_INT
            {
             before(grammarAccess.getEntryAccess().getStatusINTTerminalRuleCall_17_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEntryAccess().getStatusINTTerminalRuleCall_17_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__StatusAssignment_17"


    // $ANTLR start "rule__Entry__IndexAssignment_20"
    // InternalIGES.g:4110:1: rule__Entry__IndexAssignment_20 : ( RULE_INT ) ;
    public final void rule__Entry__IndexAssignment_20() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4114:1: ( ( RULE_INT ) )
            // InternalIGES.g:4115:2: ( RULE_INT )
            {
            // InternalIGES.g:4115:2: ( RULE_INT )
            // InternalIGES.g:4116:3: RULE_INT
            {
             before(grammarAccess.getEntryAccess().getIndexINTTerminalRuleCall_20_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEntryAccess().getIndexINTTerminalRuleCall_20_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__IndexAssignment_20"


    // $ANTLR start "rule__Entry__LineWeightAssignment_25"
    // InternalIGES.g:4125:1: rule__Entry__LineWeightAssignment_25 : ( RULE_INT ) ;
    public final void rule__Entry__LineWeightAssignment_25() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4129:1: ( ( RULE_INT ) )
            // InternalIGES.g:4130:2: ( RULE_INT )
            {
            // InternalIGES.g:4130:2: ( RULE_INT )
            // InternalIGES.g:4131:3: RULE_INT
            {
             before(grammarAccess.getEntryAccess().getLineWeightINTTerminalRuleCall_25_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEntryAccess().getLineWeightINTTerminalRuleCall_25_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__LineWeightAssignment_25"


    // $ANTLR start "rule__Entry__ColorAssignment_27"
    // InternalIGES.g:4140:1: rule__Entry__ColorAssignment_27 : ( RULE_INT ) ;
    public final void rule__Entry__ColorAssignment_27() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4144:1: ( ( RULE_INT ) )
            // InternalIGES.g:4145:2: ( RULE_INT )
            {
            // InternalIGES.g:4145:2: ( RULE_INT )
            // InternalIGES.g:4146:3: RULE_INT
            {
             before(grammarAccess.getEntryAccess().getColorINTTerminalRuleCall_27_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEntryAccess().getColorINTTerminalRuleCall_27_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__ColorAssignment_27"


    // $ANTLR start "rule__Entry__ParamLinesAssignment_29"
    // InternalIGES.g:4155:1: rule__Entry__ParamLinesAssignment_29 : ( RULE_INT ) ;
    public final void rule__Entry__ParamLinesAssignment_29() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4159:1: ( ( RULE_INT ) )
            // InternalIGES.g:4160:2: ( RULE_INT )
            {
            // InternalIGES.g:4160:2: ( RULE_INT )
            // InternalIGES.g:4161:3: RULE_INT
            {
             before(grammarAccess.getEntryAccess().getParamLinesINTTerminalRuleCall_29_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEntryAccess().getParamLinesINTTerminalRuleCall_29_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__ParamLinesAssignment_29"


    // $ANTLR start "rule__Entry__FormAssignment_31"
    // InternalIGES.g:4170:1: rule__Entry__FormAssignment_31 : ( RULE_INT ) ;
    public final void rule__Entry__FormAssignment_31() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4174:1: ( ( RULE_INT ) )
            // InternalIGES.g:4175:2: ( RULE_INT )
            {
            // InternalIGES.g:4175:2: ( RULE_INT )
            // InternalIGES.g:4176:3: RULE_INT
            {
             before(grammarAccess.getEntryAccess().getFormINTTerminalRuleCall_31_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEntryAccess().getFormINTTerminalRuleCall_31_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__FormAssignment_31"


    // $ANTLR start "rule__Entry__EntityLabelAssignment_35_0"
    // InternalIGES.g:4185:1: rule__Entry__EntityLabelAssignment_35_0 : ( RULE_STRING ) ;
    public final void rule__Entry__EntityLabelAssignment_35_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4189:1: ( ( RULE_STRING ) )
            // InternalIGES.g:4190:2: ( RULE_STRING )
            {
            // InternalIGES.g:4190:2: ( RULE_STRING )
            // InternalIGES.g:4191:3: RULE_STRING
            {
             before(grammarAccess.getEntryAccess().getEntityLabelSTRINGTerminalRuleCall_35_0_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getEntryAccess().getEntityLabelSTRINGTerminalRuleCall_35_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__EntityLabelAssignment_35_0"


    // $ANTLR start "rule__Entry__SubNumAssignment_37"
    // InternalIGES.g:4200:1: rule__Entry__SubNumAssignment_37 : ( RULE_INT ) ;
    public final void rule__Entry__SubNumAssignment_37() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4204:1: ( ( RULE_INT ) )
            // InternalIGES.g:4205:2: ( RULE_INT )
            {
            // InternalIGES.g:4205:2: ( RULE_INT )
            // InternalIGES.g:4206:3: RULE_INT
            {
             before(grammarAccess.getEntryAccess().getSubNumINTTerminalRuleCall_37_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEntryAccess().getSubNumINTTerminalRuleCall_37_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__SubNumAssignment_37"


    // $ANTLR start "rule__Parameters__EntriesAssignment"
    // InternalIGES.g:4215:1: rule__Parameters__EntriesAssignment : ( ( rule__Parameters__EntriesAlternatives_0 ) ) ;
    public final void rule__Parameters__EntriesAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4219:1: ( ( ( rule__Parameters__EntriesAlternatives_0 ) ) )
            // InternalIGES.g:4220:2: ( ( rule__Parameters__EntriesAlternatives_0 ) )
            {
            // InternalIGES.g:4220:2: ( ( rule__Parameters__EntriesAlternatives_0 ) )
            // InternalIGES.g:4221:3: ( rule__Parameters__EntriesAlternatives_0 )
            {
             before(grammarAccess.getParametersAccess().getEntriesAlternatives_0()); 
            // InternalIGES.g:4222:3: ( rule__Parameters__EntriesAlternatives_0 )
            // InternalIGES.g:4222:4: rule__Parameters__EntriesAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__Parameters__EntriesAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getParametersAccess().getEntriesAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameters__EntriesAssignment"


    // $ANTLR start "rule__PEntry__TypeAssignment_0"
    // InternalIGES.g:4230:1: rule__PEntry__TypeAssignment_0 : ( RULE_INT ) ;
    public final void rule__PEntry__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4234:1: ( ( RULE_INT ) )
            // InternalIGES.g:4235:2: ( RULE_INT )
            {
            // InternalIGES.g:4235:2: ( RULE_INT )
            // InternalIGES.g:4236:3: RULE_INT
            {
             before(grammarAccess.getPEntryAccess().getTypeINTTerminalRuleCall_0_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getPEntryAccess().getTypeINTTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEntry__TypeAssignment_0"


    // $ANTLR start "rule__PEntry__ValuesAssignment_2"
    // InternalIGES.g:4245:1: rule__PEntry__ValuesAssignment_2 : ( ruleValue ) ;
    public final void rule__PEntry__ValuesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4249:1: ( ( ruleValue ) )
            // InternalIGES.g:4250:2: ( ruleValue )
            {
            // InternalIGES.g:4250:2: ( ruleValue )
            // InternalIGES.g:4251:3: ruleValue
            {
             before(grammarAccess.getPEntryAccess().getValuesValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getPEntryAccess().getValuesValueParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEntry__ValuesAssignment_2"


    // $ANTLR start "rule__PEntry__DIndexAssignment_5"
    // InternalIGES.g:4260:1: rule__PEntry__DIndexAssignment_5 : ( RULE_INT ) ;
    public final void rule__PEntry__DIndexAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4264:1: ( ( RULE_INT ) )
            // InternalIGES.g:4265:2: ( RULE_INT )
            {
            // InternalIGES.g:4265:2: ( RULE_INT )
            // InternalIGES.g:4266:3: RULE_INT
            {
             before(grammarAccess.getPEntryAccess().getDIndexINTTerminalRuleCall_5_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getPEntryAccess().getDIndexINTTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEntry__DIndexAssignment_5"


    // $ANTLR start "rule__PEntry__IndiciesAssignment_8"
    // InternalIGES.g:4275:1: rule__PEntry__IndiciesAssignment_8 : ( RULE_INT ) ;
    public final void rule__PEntry__IndiciesAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4279:1: ( ( RULE_INT ) )
            // InternalIGES.g:4280:2: ( RULE_INT )
            {
            // InternalIGES.g:4280:2: ( RULE_INT )
            // InternalIGES.g:4281:3: RULE_INT
            {
             before(grammarAccess.getPEntryAccess().getIndiciesINTTerminalRuleCall_8_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getPEntryAccess().getIndiciesINTTerminalRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEntry__IndiciesAssignment_8"


    // $ANTLR start "rule__PMultiEntry__TypeAssignment_0"
    // InternalIGES.g:4290:1: rule__PMultiEntry__TypeAssignment_0 : ( RULE_INT ) ;
    public final void rule__PMultiEntry__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4294:1: ( ( RULE_INT ) )
            // InternalIGES.g:4295:2: ( RULE_INT )
            {
            // InternalIGES.g:4295:2: ( RULE_INT )
            // InternalIGES.g:4296:3: RULE_INT
            {
             before(grammarAccess.getPMultiEntryAccess().getTypeINTTerminalRuleCall_0_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getPMultiEntryAccess().getTypeINTTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__TypeAssignment_0"


    // $ANTLR start "rule__PMultiEntry__ValuesAssignment_2_0"
    // InternalIGES.g:4305:1: rule__PMultiEntry__ValuesAssignment_2_0 : ( ruleValue ) ;
    public final void rule__PMultiEntry__ValuesAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4309:1: ( ( ruleValue ) )
            // InternalIGES.g:4310:2: ( ruleValue )
            {
            // InternalIGES.g:4310:2: ( ruleValue )
            // InternalIGES.g:4311:3: ruleValue
            {
             before(grammarAccess.getPMultiEntryAccess().getValuesValueParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_2);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getPMultiEntryAccess().getValuesValueParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__ValuesAssignment_2_0"


    // $ANTLR start "rule__PMultiEntry__DIndexAssignment_2_2"
    // InternalIGES.g:4320:1: rule__PMultiEntry__DIndexAssignment_2_2 : ( RULE_INT ) ;
    public final void rule__PMultiEntry__DIndexAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4324:1: ( ( RULE_INT ) )
            // InternalIGES.g:4325:2: ( RULE_INT )
            {
            // InternalIGES.g:4325:2: ( RULE_INT )
            // InternalIGES.g:4326:3: RULE_INT
            {
             before(grammarAccess.getPMultiEntryAccess().getDIndexINTTerminalRuleCall_2_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getPMultiEntryAccess().getDIndexINTTerminalRuleCall_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__DIndexAssignment_2_2"


    // $ANTLR start "rule__PMultiEntry__IndiciesAssignment_2_5"
    // InternalIGES.g:4335:1: rule__PMultiEntry__IndiciesAssignment_2_5 : ( RULE_INT ) ;
    public final void rule__PMultiEntry__IndiciesAssignment_2_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4339:1: ( ( RULE_INT ) )
            // InternalIGES.g:4340:2: ( RULE_INT )
            {
            // InternalIGES.g:4340:2: ( RULE_INT )
            // InternalIGES.g:4341:3: RULE_INT
            {
             before(grammarAccess.getPMultiEntryAccess().getIndiciesINTTerminalRuleCall_2_5_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getPMultiEntryAccess().getIndiciesINTTerminalRuleCall_2_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__IndiciesAssignment_2_5"


    // $ANTLR start "rule__PMultiEntry__ValuesAssignment_3"
    // InternalIGES.g:4350:1: rule__PMultiEntry__ValuesAssignment_3 : ( ruleValue ) ;
    public final void rule__PMultiEntry__ValuesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4354:1: ( ( ruleValue ) )
            // InternalIGES.g:4355:2: ( ruleValue )
            {
            // InternalIGES.g:4355:2: ( ruleValue )
            // InternalIGES.g:4356:3: ruleValue
            {
             before(grammarAccess.getPMultiEntryAccess().getValuesValueParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getPMultiEntryAccess().getValuesValueParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiEntry__ValuesAssignment_3"


    // $ANTLR start "rule__HString__ValAssignment_0"
    // InternalIGES.g:4365:1: rule__HString__ValAssignment_0 : ( RULE_HOLLERITH ) ;
    public final void rule__HString__ValAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4369:1: ( ( RULE_HOLLERITH ) )
            // InternalIGES.g:4370:2: ( RULE_HOLLERITH )
            {
            // InternalIGES.g:4370:2: ( RULE_HOLLERITH )
            // InternalIGES.g:4371:3: RULE_HOLLERITH
            {
             before(grammarAccess.getHStringAccess().getValHOLLERITHTerminalRuleCall_0_0()); 
            match(input,RULE_HOLLERITH,FOLLOW_2); 
             after(grammarAccess.getHStringAccess().getValHOLLERITHTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HString__ValAssignment_0"


    // $ANTLR start "rule__Param__ValAssignment_0"
    // InternalIGES.g:4380:1: rule__Param__ValAssignment_0 : ( RULE_DOUBLE ) ;
    public final void rule__Param__ValAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4384:1: ( ( RULE_DOUBLE ) )
            // InternalIGES.g:4385:2: ( RULE_DOUBLE )
            {
            // InternalIGES.g:4385:2: ( RULE_DOUBLE )
            // InternalIGES.g:4386:3: RULE_DOUBLE
            {
             before(grammarAccess.getParamAccess().getValDOUBLETerminalRuleCall_0_0()); 
            match(input,RULE_DOUBLE,FOLLOW_2); 
             after(grammarAccess.getParamAccess().getValDOUBLETerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Param__ValAssignment_0"


    // $ANTLR start "rule__Pointer__ValAssignment_0"
    // InternalIGES.g:4395:1: rule__Pointer__ValAssignment_0 : ( RULE_INT ) ;
    public final void rule__Pointer__ValAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4399:1: ( ( RULE_INT ) )
            // InternalIGES.g:4400:2: ( RULE_INT )
            {
            // InternalIGES.g:4400:2: ( RULE_INT )
            // InternalIGES.g:4401:3: RULE_INT
            {
             before(grammarAccess.getPointerAccess().getValINTTerminalRuleCall_0_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getPointerAccess().getValINTTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Pointer__ValAssignment_0"


    // $ANTLR start "rule__End__SvalAssignment_2"
    // InternalIGES.g:4410:1: rule__End__SvalAssignment_2 : ( RULE_INT ) ;
    public final void rule__End__SvalAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4414:1: ( ( RULE_INT ) )
            // InternalIGES.g:4415:2: ( RULE_INT )
            {
            // InternalIGES.g:4415:2: ( RULE_INT )
            // InternalIGES.g:4416:3: RULE_INT
            {
             before(grammarAccess.getEndAccess().getSvalINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEndAccess().getSvalINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__SvalAssignment_2"


    // $ANTLR start "rule__End__GvalAssignment_5"
    // InternalIGES.g:4425:1: rule__End__GvalAssignment_5 : ( RULE_INT ) ;
    public final void rule__End__GvalAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4429:1: ( ( RULE_INT ) )
            // InternalIGES.g:4430:2: ( RULE_INT )
            {
            // InternalIGES.g:4430:2: ( RULE_INT )
            // InternalIGES.g:4431:3: RULE_INT
            {
             before(grammarAccess.getEndAccess().getGvalINTTerminalRuleCall_5_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEndAccess().getGvalINTTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__GvalAssignment_5"


    // $ANTLR start "rule__End__DvalAssignment_8"
    // InternalIGES.g:4440:1: rule__End__DvalAssignment_8 : ( RULE_INT ) ;
    public final void rule__End__DvalAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4444:1: ( ( RULE_INT ) )
            // InternalIGES.g:4445:2: ( RULE_INT )
            {
            // InternalIGES.g:4445:2: ( RULE_INT )
            // InternalIGES.g:4446:3: RULE_INT
            {
             before(grammarAccess.getEndAccess().getDvalINTTerminalRuleCall_8_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEndAccess().getDvalINTTerminalRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__DvalAssignment_8"


    // $ANTLR start "rule__End__PvalAssignment_11"
    // InternalIGES.g:4455:1: rule__End__PvalAssignment_11 : ( RULE_INT ) ;
    public final void rule__End__PvalAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4459:1: ( ( RULE_INT ) )
            // InternalIGES.g:4460:2: ( RULE_INT )
            {
            // InternalIGES.g:4460:2: ( RULE_INT )
            // InternalIGES.g:4461:3: RULE_INT
            {
             before(grammarAccess.getEndAccess().getPvalINTTerminalRuleCall_11_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEndAccess().getPvalINTTerminalRuleCall_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__PvalAssignment_11"


    // $ANTLR start "rule__End__TvalAssignment_15"
    // InternalIGES.g:4470:1: rule__End__TvalAssignment_15 : ( RULE_INT ) ;
    public final void rule__End__TvalAssignment_15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIGES.g:4474:1: ( ( RULE_INT ) )
            // InternalIGES.g:4475:2: ( RULE_INT )
            {
            // InternalIGES.g:4475:2: ( RULE_INT )
            // InternalIGES.g:4476:3: RULE_INT
            {
             before(grammarAccess.getEndAccess().getTvalINTTerminalRuleCall_15_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEndAccess().getTvalINTTerminalRuleCall_15_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__End__TvalAssignment_15"

    // Delegated rules


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA11 dfa11 = new DFA11(this);
    protected DFA47 dfa47 = new DFA47(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\6\4\2\uffff\3\4";
    static final String dfa_3s = "\1\4\3\13\1\16\1\13\2\uffff\3\13";
    static final String dfa_4s = "\6\uffff\1\1\1\2\3\uffff";
    static final String dfa_5s = "\13\uffff}>";
    static final String[] dfa_6s = {
            "\1\1",
            "\1\4\1\uffff\1\6\1\2\1\7\1\uffff\1\5\1\3",
            "\1\4\1\uffff\1\6\1\uffff\1\7\1\uffff\1\5\1\3",
            "\1\4\1\uffff\1\6\1\10\1\7\1\uffff\1\5\1\3",
            "\1\4\1\uffff\1\6\1\11\1\7\1\uffff\1\5\1\3\2\uffff\1\6",
            "\1\4\1\uffff\1\6\1\12\1\7\1\uffff\1\5\1\3",
            "",
            "",
            "\1\4\1\uffff\1\6\1\uffff\1\7\1\uffff\1\5\1\3",
            "\1\4\1\uffff\1\6\1\uffff\1\7\1\uffff\1\5\1\3",
            "\1\4\1\uffff\1\6\1\uffff\1\7\1\uffff\1\5\1\3"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "444:1: rule__Parameters__EntriesAlternatives_0 : ( ( rulePMultiEntry ) | ( rulePEntry ) );";
        }
    }
    static final String dfa_7s = "\17\uffff";
    static final String dfa_8s = "\4\4\1\uffff\4\4\1\uffff\5\4";
    static final String dfa_9s = "\1\13\3\14\1\uffff\4\14\1\uffff\5\14";
    static final String dfa_10s = "\4\uffff\1\2\4\uffff\1\1\5\uffff";
    static final String dfa_11s = "\17\uffff}>";
    static final String[] dfa_12s = {
            "\1\2\3\uffff\1\4\1\uffff\1\3\1\1",
            "\1\7\1\uffff\1\11\1\5\1\4\1\uffff\1\10\1\6\1\11",
            "\1\7\1\uffff\1\11\1\12\1\4\1\uffff\1\10\1\6\1\11",
            "\1\7\1\uffff\1\11\1\13\1\4\1\uffff\1\10\1\6\1\11",
            "",
            "\1\7\1\uffff\1\11\1\uffff\1\4\1\uffff\1\10\1\6\1\11",
            "\1\7\1\uffff\1\11\1\14\1\4\1\uffff\1\10\1\6\1\11",
            "\1\7\1\uffff\1\11\1\15\1\4\1\uffff\1\10\1\6\1\11",
            "\1\7\1\uffff\1\11\1\16\1\4\1\uffff\1\10\1\6\1\11",
            "",
            "\1\7\1\uffff\1\11\1\uffff\1\4\1\uffff\1\10\1\6\1\11",
            "\1\7\1\uffff\1\11\1\uffff\1\4\1\uffff\1\10\1\6\1\11",
            "\1\7\1\uffff\1\11\1\uffff\1\4\1\uffff\1\10\1\6\1\11",
            "\1\7\1\uffff\1\11\1\uffff\1\4\1\uffff\1\10\1\6\1\11",
            "\1\7\1\uffff\1\11\1\uffff\1\4\1\uffff\1\10\1\6\1\11"
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "()* loopback of 754:3: ( rule__Global__Group_3__0 )*";
        }
    }
    static final String dfa_13s = "\11\uffff";
    static final String dfa_14s = "\4\4\2\uffff\3\4";
    static final String dfa_15s = "\2\13\1\16\1\13\2\uffff\3\13";
    static final String dfa_16s = "\4\uffff\1\2\1\1\3\uffff";
    static final String dfa_17s = "\11\uffff}>";
    static final String[] dfa_18s = {
            "\1\2\1\uffff\1\5\1\uffff\1\4\1\uffff\1\3\1\1",
            "\1\2\1\uffff\1\5\1\6\1\4\1\uffff\1\3\1\1",
            "\1\2\1\uffff\1\5\1\7\1\4\1\uffff\1\3\1\1\2\uffff\1\5",
            "\1\2\1\uffff\1\5\1\10\1\4\1\uffff\1\3\1\1",
            "",
            "",
            "\1\2\1\uffff\1\5\1\uffff\1\4\1\uffff\1\3\1\1",
            "\1\2\1\uffff\1\5\1\uffff\1\4\1\uffff\1\3\1\1",
            "\1\2\1\uffff\1\5\1\uffff\1\4\1\uffff\1\3\1\1"
    };

    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final char[] dfa_14 = DFA.unpackEncodedStringToUnsignedChars(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[][] dfa_18 = unpackEncodedStringArray(dfa_18s);

    class DFA47 extends DFA {

        public DFA47(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 47;
            this.eot = dfa_13;
            this.eof = dfa_13;
            this.min = dfa_14;
            this.max = dfa_15;
            this.accept = dfa_16;
            this.special = dfa_17;
            this.transition = dfa_18;
        }
        public String getDescription() {
            return "()* loopback of 2712:3: ( rule__PMultiEntry__Group_2__0 )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000008062L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000C90L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000D90L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000C92L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000001040L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000002070L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000CD0L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000CD2L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000008060L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000062L});

}