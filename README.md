the plugin.yml file is necessary for a plugin to work. It should be in the main directory of your jar, not in a subfolder. It's in a subfolder here because the pom.xml file tells netbeans to put it there. The pom indicates that this is a maven project, all that means is that we use another service called Maven for building the jar. Here's the long version:

Netbeans is where you write your code. Maven is what you use to turn your code into something usable. Github is where you store your code for easy access.
