package io.github.simonlarsen.template;

import jolie.runtime.JavaService;
import jolie.runtime.Value;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Template extends JavaService {
	public String compile(Value request) {
		String template = request.strValue();
		StringBuilder builder = new StringBuilder();

		Pattern pattern = Pattern.compile("\\$\\{([_a-zA-Z][_a-zA-Z0-9]*)\\}");
		Matcher matcher = pattern.matcher(template);

		int i = 0;
		while(matcher.find()) {
			String replacement = request.getFirstChild(matcher.group(1)).strValue();
			builder.append(template.substring(i, matcher.start()));
			builder.append(replacement);
			i = matcher.end();
		}
		builder.append(template.substring(i, template.length()));

		return builder.toString();
	}
}
