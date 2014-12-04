jolie-templates
===============

String templates library for Jolie

## Example ##

```
include "console.iol"
include "template.iol"

main {
  template = "Hi. My name is ${name} and I am from ${country}.";
  template.name = "John";
  template.country = "Denmark";
  
  compile@Template(template)(result);
  println@Console(result)()
}
```
Prints `Hi. My name is John and I am from Denmark.`
