include "console.iol"
include "template.iol"

main {
	template = "Hi. My name is ${name} and I am from ${country}.";
	template.name = "John";
	template.country = "Denmark";
	Test = 4;

	compile@Template(template)(result);

	println@Console(result)()
}
