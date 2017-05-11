package net.certiv.fluentmark.views;

import net.certiv.fluentmark.util.Strings;

public interface MathJax {

	public static final String defaultCDN = //
			"<script type=\"text/javascript\" async" + Strings.EOL + //
					"	src=\"https://cdnjs.cloudflare.com/ajax/libs/mathjax/2.7.0/MathJax.js?"
					+ "config=TeX-MML-AM_CHTML\">" + Strings.EOL + //
					"</script>" + Strings.EOL;

	// minimum configuration and register with the signal hub to perform 'typeset()' callback on
	// the startup 'End' signal
	public static final String minConfig = //
			"<script type=\"text/x-mathjax-config\">" + Strings.EOL + //
					"MathJax.Hub.Config({" + Strings.EOL + //
					"	messageStyle: \"none\"," + Strings.EOL + //
					"	positionToHash: true," + Strings.EOL + //
					"	TeX: {" + Strings.EOL + //
					"		equationNumbers: {" + Strings.EOL + //
					"			autoNumber: \"all\"" + Strings.EOL + //
					"		}" + Strings.EOL + //
					"	}," + Strings.EOL + //
					"});" + Strings.EOL + "MathJax.Hub.Register.StartupHook(\"End\", typeset);" + Strings.EOL + //
					"</script>" + Strings.EOL;

	public static final String experimentalConfig = //
			"<script type=\"text/x-mathjax-config\">" + Strings.EOL + //
					"MathJax.Hub.Config({" + Strings.EOL + //
					"	messageStyle: \"none\"," + Strings.EOL + //
					"	positionToHash: true," + Strings.EOL + //
					"	TeX: {" + Strings.EOL + //
					"		equationNumbers: {" + Strings.EOL + //
					"			autoNumber: \"all\"" + Strings.EOL + //
					"		}" + Strings.EOL + //
					"	}," + Strings.EOL + //
					"	tex2jax: {" + Strings.EOL + //
					"		inlineMath: [" + Strings.EOL + //
					"			['$', '$']" + Strings.EOL + //
					"		]," + Strings.EOL + //
					"		displayMath: [" + Strings.EOL + //
					"			['\\begin{displaymath}', '\\end{displaymath}']," + Strings.EOL + //
					"			['\\begin{equation}', '\\end{equation}']" + Strings.EOL + //
					"		]," + Strings.EOL + //
					"		processEscapes: true," + Strings.EOL + //
					"		preview: \"none\"" + Strings.EOL + //
					"	}," + Strings.EOL + //
					"	SVG: {" + Strings.EOL + //
					"		scale: 95" + Strings.EOL + //
					"	}," + Strings.EOL + //
					"	\"HTML-CSS\": {" + Strings.EOL + //
					"		scale: 95," + Strings.EOL + //
					"		availableFonts: [\"TeX\"]," + Strings.EOL + //
					"		styles: {" + Strings.EOL + //
					"			\".MathJax_Preview\": {" + Strings.EOL + //
					"				color: \"#999\"" + Strings.EOL + //
					"			}" + Strings.EOL + //
					"		}" + Strings.EOL + //
					"	}," + Strings.EOL + //
					"	\"fast-preview\": {" + Strings.EOL + //
					"		disabled: true" + Strings.EOL + //
					"	}" + Strings.EOL + //
					"});" + Strings.EOL;
}
