Coding Style for Quattor Modules
===============================

Introduction
------------

All major software projects have a set of guidelines for their 
code. It helps people to understand each other's code, and even 
your own code a few months (or days!) after you wrote it for 
the first time.

There are lots of documents motivating this, feel free to review 
them. [This one](http://www.kroah.com/linux/talks/ols_2002_kernel_codingstyle_paper/codingstyle.ps) 
is a good starting point but in short:

-   I want to read your code.
-   I want you to read my code.
-   I want to fix your bugs.
-   I want you to fix my bugs.

### Further reading

-   [Perl coding style guide](http://perldoc.perl.org/perlstyle.html)
-   [Documentation/CodingStyle and beyond](http://www.kroah.com/linux/talks/ols_2002_kernel_codingstyle_paper/codingstyle.ps), 
  by Greg Kroah-Hartman

The basics
----------

### Indentation

Use 4 white spaces. No tabs, no 8 white spaces, no funny things. 
Fix your editor's configuration, or use a decent one. There are 
plenty of them.

### Capitalisation

Use lowercase for local variables, uppercase for constants.

We have no consistent convention for function names enforced 
in the existing code but the recommandation is function\_names\_like\_this\_one 
rather than functionNameLikeThis.

### Use meaningful names for globals, short names for locals

\`i\` is a perfectly valid identifier for a loop variable. However, 
you deserve nasty punishment if you use it as a function name.

On the opposite, \`this\_is\_a\_temporary\_counter\` is plain 
bad for a loop variable.

So, some good examples:

```
sub write_user_credentials
{
    # ...
}
```

```
for my $i (0..10) {
    # ...
}

```


And very bad examples:

```
sub wuc
{
    # WTH???
}
```

```
for my $counter_from_0_to_10_included (0..10) {
    # Excuse me???
}
```

### Be modular

Really, it **matters**. Have you ever tried to understand a module 
which is 700 lines long? Did you ever try to understand what's 
the purpose of a variable that was defined 5 screens ago? Or 
the meaning of the 30th variable on this block? Or the purpose 
of that line that starts and finishes beyond the screen?

Here are the classic metrics for modularity:

* No lines longer than 80 columns.   * Split or rearrange longer strings    
* Split longer statements * If you have more than 3 levels of indentation, split your block 
* If your function goes beyond the screen, split it   * And don't try to reduce the font. ;) 
* If you have more than 7 local variables, split your function.    
* Sometimes it's OK to have 10, but if you have 15 your code is a problem.

### Don't use magic numbers

The `constant` pragma will give you meaningful names for any 
values other than 0 and 1 you need. They'll help you to understand 
why you chose such values on the past.

A good example:

```
use constant PI => 3.141592;
my $circle_area = $radio * PI * PI;
```

And the bad example:

```
# Oops! I missed a decimal somewhere!
 my $circle_area = $radio * 3.14159 * 3.141592;
```


### Comments

When in doubt, don't use them.

Comment all Pan data structures, or at least provide a link to 
their full description. Try to use the new annotation syntax, 
which will be (some day) imported by Doxygen, Javadoc or something 
similar.

Comment the purpose of each file, probably using POD syntax. 
Write a comment before the beginning of each function, telling 
what it does and how to use it. But don't annoy the reader with 
the internals.

Don't comment function bodies. If your code is so complex that 
it needs further explanations, you should probably split it in 
several functions and comment those functions. Of course, sometimes 
you have to work around some broken API, or some corner case. 
In such case, please comment **why** you are doing it, but not 
**how**. And don't comment the obvious.

Bad examples:

```
 ############################################################
 #
 # Increment by 1
 #
 ############################################################
 $i++;
```

These are best done like this:

Finally, don't put any credits on your comments, excepting on 
file headers.

### Don't use \`vars\`

This pragma has been deprecated since Perl 5.6, and that's a 
long time ago. Instead, use the \`our\` declaration for package-wide 
variables:

Good:

Bad:

### Curly bracket position

Follow Kernighan-Ritchie's convention: open curly brackets on 
the same line as the sentence they belong to and close them on 
a line for their own, excepting when it's an else or a do-while 
block:

This way it is perfectly clear where each block starts, finishes 
and continues.

The only exception to this are the curly brackets that open a 
function. They should be on a different line, and have nothing 
else on the same line:

The reason for this is that decent editors (f.i, Emacs) are aware 
that such curly braces mean something special, and allow you 
to move to the beginning and the end of a function with a single 
key stroke. This is a great help for navigating code.

### Parenthesis

Use them a lot. When in doubt, use them. Especially:

-   Always use parenthesis on function calls
-   Always use them on function calls even when there are no 
  arguments

The reason is that: Is easier to understand than:

### Prefer methods over plain functions

Especially when writing components, you want to log unexpected 
things. It's free to have a \`$self\` object, and let it log.

Only use plain functions if you want them exported to some other 
module.

The Quattor library (AKA perl-CAF and perl-LC)
----------------------------------------------

### Running commands

Do not use backticks or \`system\`, nor use \`open\` for pipes. 
The \`CAF::Process\` module has all you need, and it won't spawn 
new subshells, which is much safer.

Another advantage of the \`CAF::Process\` module is that your 
command line will be automatically logged at verbose level, which 
saves you snippets like this:

This will become inconsistent with different uses. Instead, do:

The log option is any CAF::Logger object, for instance the component 
you are writing.

#### Confidential information on the command line

Sometimes you pass confidential data to your commands. For instance, 
an encrypted password to usermod. In this cases, you don't want 
your command logged. Just don't pass any log argument to CAF::Process::new:

#### Examples

The following are extracted from CAF::Process man page, and assume 
you don't want to log the commands.

##### Piping to a process' stdin

Create the contents to be piped: Create the command, specifying 
$contents as the input, and “execute” it:

##### Piping in and out

Suppose we want a bi-directional pipe: we provide the command's 
stdin, and need to get its output and error:

And we'll have the command's standard output and error on $stdout 
and $stderr.

##### Emulating backticks to get a command’s output

Create the command: And get the output:

### File handling

Writing to files is not as simple as one could think: there are 
risks that you should be aware of. For instance, the following 
code is an example of what shouldn't be done:

If \`/tmp/foo\` already exists and is a symbolic link to \`/etc/shadow\`, 
you just lost all accounts on your system.

#### Writing to a file

Don't open files directly. Use the CAF::FileWriter module to 
do the work for you:

This module will perform all security checks for you, and will 
log what files you open for writing, so that your configuration 
is easier to debug.

You can specify the permissions you want at instantiation, too:

If you find any errors and have to discard your contents, just 
call the cancel method, and the existing file will be preserved:

Finally, if the contents you generate are the same as on the 
original file, nothing will be done, which will keep timestamps, 
among other properties.

The man page has all the details and more examples.

#### Temporary files

Don't use them. If you don't use <File::Temp>, you'll use predictable 
filenames, and that's just bad. Then, most implementations make 
temporary files world readable, and you usually don't want that. 
If you need temporary storage for some text, use an array, IO::String, 
in-memory files, a CAF::FileWriter or anything like that.

So you want to run a command which needs a file name as an argument, 
right? Easy. Just pipe to that command, as shown above. And pass 
/dev/fd/0 as the file name.

Finally, if all these options are not good enough (what are you 
trying to do?), use <File::Temp>::tmpfile, which will provide 
you an anonymous file handle. But please, use this only if you 
are convinced there is no other way to keep your temporary data.

#### Modifying an existing file

Sometimes you just want to add a couple of lines to an existing 
file, without destroying its current contents. Or to remove them. 
The module \`CAF::FileEditor\` is just for that. It is a subclass 
of \`CAF::FileWriter\`, and when you call the \`string\_ref\` 
method you'll get a reference to the file's contents so that 
you can freely update them.

For instance, you only want to change the first “a” for a b on 
the first line of a file:

If you want to add text at the beginning of the file, the \`head\_print\` 
method is what you are looking for.

#### Other tasks with files

When in doubt, use \`LC::\` modules and functions, over standard 
ones. For instance, use \`LC::<File::copy>\`, \`LC::<File::move>\` 
instead of \`File::Copy\` and friends.

\`LC::\` functions perform more security checks and are less 
prone to symlink attacks.

Input handling
--------------

Make your code run in tainted mode.

This is, don't trust any inputs, even if they are from the profile. 
During the workshop, Nick proposed to sign profiles (it was proposed 
2 years ago, too). While this gets (or not) implemented, **profiles 
are not to be trusted**. Sanitise everything just after reading 
it, and that way you'll be able to use it freely.

Also, when you print files that will be sourced by shell scripts, 
be sure to print all values between single quotes. This is true 
for almost every file you have under \`/etc/sysconfig\`.

Quality of messages
-------------------

### Don't annoy the user

The main principle is not to annoy the user. Use \`info\` and 
\`ok\` methods only for **very** important messages. A small 
description of the tasks you are going to perform, if they are 
complex enough.

### Unless he asks to

Provide a detailed trace of any task you perform with \`verbose\` 
messages. Trace DNS queries, URLs being retrieved, services you 
have to enable or disable...

But you don't need to log files you open or commands you run. 
The appropriate CAF objects will do so for you.

### Debugging output

Don't print user-relevant messages with \`debug\`. This should 
be used only for developer-relevant stuff, such as tracking temporary 
contents or so.

We don't have any convention for debug levels, is it needed?

### Use \`error\` only for fatal errors

Use the \`error\` method only if this error will make the entire 
component fail. If you can handle it, or the fail is not really 
important for the component's results, use \`info\` instead. 
If failing to download a file is OK because you can work around 
it, or you know you may have no rights to write on AFS, but that's 
OK, use an \`info\` message.

Otherwise, the component will be re-run with no need, and will 
keep failing and triggering alarms on the user's monitoring system.

Conclusions
-----------

Code quality matters. It will reduce bugs, and will make everybody's 
life easier.

All these conventions can be improved, so feedback will be appreciated. 
Especially, the CAF library can be extended with whatever task 
we repeat over and over (f.i, do we need any especial code to 
do DNS queries or download files from the Internet?).
