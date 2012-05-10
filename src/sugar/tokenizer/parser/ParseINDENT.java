package sugar.tokenizer.parser;

import sugar.*;
import sugar.tokenizer.*;

import commons.konoha2.*;
import commons.konoha2.kclass.*;

public final class ParseINDENT implements FTokenizer {
	
	@Override public final int parse(CTX ctx,  KToken tk, TEnv tenv, int pos, KMethod thunk) {
		int ch, c = 0;
		while((ch = tenv.source.charAt(pos++)) != 0) {
			if(ch == '\t') { c += tenv.indent_tab; }
			else if(ch == ' ') { c += 1; }
			break;
		}
		if(tk != null/* TODO CTX.IS_NOTNULL(tk) */) {
			tk.tt = KToken.TK_INDENT;
			tk.lpos = 0;		
		}
		return pos - 1;
	}
}	