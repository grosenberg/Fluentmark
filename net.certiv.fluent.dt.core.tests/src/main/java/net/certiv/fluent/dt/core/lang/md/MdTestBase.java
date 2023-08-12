package net.certiv.fluent.dt.core.lang.md;

import java.util.LinkedList;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.BeforeEach;

import net.certiv.common.sheet.Sheet;
import net.certiv.common.util.FsUtil;
import net.certiv.common.util.MsgBuilder;
import net.certiv.common.util.Strings;
import net.certiv.dsl.core.util.antlr.TreeUtil;
import net.certiv.fluent.dt.core.lang.md.gen.MdLexer;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.PageContext;

public class MdTestBase {

	static final boolean UPDATE_ALL = false;

	final LinkedList<String> problems = new LinkedList<>();

	MdLexer lexer;
	CommonTokenStream ts;
	MdParser parser;

	@BeforeEach
	void setup() {
		problems.clear();
	}

	public boolean required(String name, boolean one) {
		if (one || all()) return true;
		return !FsUtil.checkResource(getClass(), name);
	}

	private boolean all() {
		return UPDATE_ALL;
	}

	public PageContext createMdParserTree(CommonTokenStream ts) {
		parser = new MdParser(ts);
		parser.setTokenFactory(new MdTokenFactory());
		parser.removeErrorListeners();
		parser.addErrorListener(new MdErrorListener(problems, false));
		return parser.page();
	}

	public String renderTree(String name, ParseTree tree) {
		MsgBuilder mb = new MsgBuilder();
		mb.append("---- %s -------------------------", name).nl();
		if (!problems.isEmpty()) {
			mb.append("---- Errors ----").nl();
			for (String prob : problems) {
				mb.indent(prob).nl();
			}
			mb.nl();
		}
		mb.append("---- Tree ----").nl();
		mb.append(TreeUtil.toPrettyTree(tree, parser));
		mb.nl();
		return mb.toString();
	}

	public CommonTokenStream createMdTokenStream(String name, boolean fill) {
		String data = FsUtil.loadResource(getClass(), name).value;
		CodePointCharStream cs = CharStreams.fromString(data, name);
		lexer = new MdLexer(cs);
		lexer.setTokenFactory(new MdTokenFactory());
		lexer.removeErrorListeners();
		lexer.addErrorListener(new MdErrorListener(problems, false));
		ts = new CommonTokenStream(lexer);
		if (fill) ts.fill();
		return ts;
	}

	public String render(String name, CommonTokenStream ts) {
		return render(name, ts, true);
	}

	public String render(String name, CommonTokenStream ts, boolean hidden) {
		MsgBuilder mb = new MsgBuilder();
		if (!problems.isEmpty()) {
			mb.append("---- %s Errors -------------------------", name).nl();
			for (String prob : problems) {
				mb.indent(prob).nl();
			}
			mb.nl();
		}

		Sheet s = buildSheet(name, ts, hidden);
		mb.append(s.print()).nl();
		return mb.toString();
	}

	private Sheet buildSheet(String name, CommonTokenStream ts, boolean hidden) {
		Sheet s = Sheet.of(name).width(80);
		Sheet.Builder builder = s.builder();
		builder.col().name("Num").right().fixed().width(4);
		builder.col().name("Token").fixed().width(14);
		builder.col().name("Type").right().fixed().width(5);
		builder.col().name("Text");
		builder.col().name("Line").right().fixed().width(5);
		builder.col().name("Pos").right().fixed().width(4);
		builder.col().name("Channel").fixed().width(8);

		for (Token t : ts.getTokens()) {
			MdToken token = (MdToken) t;
			if (!hidden && token.isHidden()) continue;

			String num = String.valueOf(token.getTokenIndex());
			String tok = tokenName(token.getType());
			String type = String.valueOf(token.getType());
			String txt = Strings.encode(token.getText());

			String line = String.valueOf(token.lastLine());
			String pos = String.valueOf(token.getCharPositionInLine());
			String chan = chanName(token.getChannel());

			s.addRow(num, tok, type, txt, line, pos, chan);
		}

		s.build();
		return s;
	}

	public String tokenName(int type) {
		return lexer.getVocabulary().getDisplayName(type);
	}

	public String chanName(int channel) {
		return channel != 0 ? MdLexer.channelNames[channel] : Strings.EMPTY;
	}
}
