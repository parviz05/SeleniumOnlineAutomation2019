package com.cybertek.test.first_dayGit;

public class ClassNOTE {
    /*
    GIT Day 1 Class notes
Good Morning!

Today is GIT day 1
I would say this is a GIT intro.

Next class will be about HTML.

================================
Any irrelevant questions let's keep work parking lot.
Main time let's spend on GIT.

-- -- GIT is a version control tool/system

Distributed Version Control System - that means, there is not only

one version of project, every collaborator (or every sdet, developer whoever is involved into this project) has copy of this project on the computer.

In case of google drive - it's more like centralized, because files are only there. We don't copies (unless we want) on our computer.

It keeps track of changes that you have made.

It doesn't matter who when and how many changes was made, git will track and remember who did it and when, what time.

When I was in the project we had 3 automation testers. We worked on the same project (java project) GIT made possible to collaborate 3 of us.

GIT lets you see different versions of code.

We can easily go back to the old version.
Or compare with previous version.

GIT records entire history of changes: version 1 --> version 2 --> version 3.

***************
BREAK TILL 2:10

When we are talking about version control systems, there are basically 2 types:
- Distributed (GIT)
- Centralized

VCS (Version Control System)

Another benefit of VCS is security and backup.

You can save your code in the cloud, and even if your computer will brake, your code is still safe.

GIT, SVN, CVS (not pharmacy)

WE have local and remote repository.
If you remember, we ran command "git init". Basically, this command creates local repository (or repo).

Repository = repo.
What is repository? It's like a folder with files.

How to create repo? Repository repo1 = new Repository(); ?? good, but no.

#######Step 1. Let's check if git is installed.

Run git --version in terminal (use cmd for windows, or git bash)

Version is not so important. Most of the features have been introduced long time ago.

Most of the time, new version doesn't bring new features. New version, most of the, brings bug fixes.

git --help

These are common Git commands used in various situations:

start a working area (see also: git help tutorial)
clone Clone a repository into a new directory
init Create an empty Git repository or reinitialize an existing one

work on the current change (see also: git help everyday)
add Add file contents to the index
mv Move or rename a file, a directory, or a symlink
reset Reset current HEAD to the specified state
rm Remove files from the working tree and from the index

examine the history and state (see also: git help revisions)
bisect Use binary search to find the commit that introduced a bug
grep Print lines matching a pattern
log Show commit logs
show Show various types of objects
status Show the working tree status

grow, mark and tweak your common history
branch List, create, or delete branches
checkout Switch branches or restore working tree files
commit Record changes to the repository
diff Show changes between commits, commit and working tree, etc
merge Join two or more development histories together
rebase Reapply commits on top of another base tip
tag Create, list, delete or verify a tag object signed with GPG

collaborate (see also: git help workflows)
fetch Download objects and refs from another repository
pull Fetch from and integrate with another repository or a local branch
push Update remote refs along with associated objects

'git help -a' and 'git help -g' list available subcommands and some

#####Step 2. Let's create a github account

BREAK TILL 3:10

Setup git git name, email, password om your computer only ONCE.

git config --global user.name "sdetuser" or try like this, if it didn't work: git config --global user.name sdetuser
#######################
These steps are important, because we need to introduce ourself to git.

git config --global user.email github account email
git config --global user.password github account password

#######################


sdetuser - must be your name. Can be full name, username, nickname...
As a response - you will not get anything


WHY WE repeat these steps on our computer?

Once we create github account and created repo on this account, we need to connect our local repo with remote (github) repo

git config --global color.ui true - to make git output colorful

Password is visible

Local --> the one is on your computer
Remote --> in the cloud (github)

If, you are pushing your code from local repo (your computer) to remote (github) and password or email is not correct, you will get an error.

We can use git in two ways:
Through terminal
UI or IDE (Eclipse, Intellij)

Most likely, you will use git from IDE.

99% of the time, I used git only from Eclipse.


If we use from terminal, let's say for windows we can use powershell or cmd or git bash.
For mac - just default terminal.

git config --list | to check your configuration

wsip-70-166-39-41:first-intellij-project cybertekstudio$ git init
Initialized empty Git repository in /Users/cybertekstudio/IdeaProjects/first-intellij-project/.git/

git init stands for initializing local repository, then we need to connect our local repository with remote repository. Remote repository is located on github. Once we execute this command, .git folder will be created.

git add <something> means add files to the staging area

When you are adding a new file to your project, the status of this file will be "untracked".

git status -- to check current status of your project files. Let's say if there are any new files or modified files that are ready for staging.

On branch master -- master is a default branch, we need branches to have multiple version of our code at same time.

No commits yet - commit is like version of your project. No commits means we have no versions saved yet.

Untracked files:
(use "git add <file>..." to include in what will be committed)

.DS_Store
.idea/
first-intellij-project.iml
out/
src/

nothing added to commit but untracked files present (use "git add" to track)

############################
BREAK TILL 4:15.


About MAC and WINDOWS: GIT commands are THE SAME.

#################################

git status -
- checks if there is any new files
- checks if there is any modified files
- and if there is any commits

git log - checks history of commits.

commit a8f6b844d4c4adba8524d1491a71037470de6f2f (HEAD -> master, origin/master)
Author: Cybertek Studio <vfomiuk@gmail.com>
Date: Sun Jun 16 16:30:02 2019 -0400

first commit


git init - create local repo
git add . - add everything to the staging area
git status - show status if git repo'
git commit -m "message" -m fot commit message, commit is process of taking code snapshot. After commit, we can send code to the github
git push - sends code to the github.


Your branch is ahead of 'origin/master' by 1 commit. // that means our local repository has newer version that remote (github)
(use "git push" to publish your local commits) // we will use this command to send our changes to the github



git add . --> git commit -m "message" --> git push

we cannot push without commit
we cannot commit without adding to the staging area


gt add . (dot means add all files, we can pick files for staging area. For example: we are working on the script. It's not ready yet, you don't want to send to the remote repo (github).So you are committing files (java classes, tests...) that you finished.


what's the pull command?

If there are some changes in the remote repo (github), you need to get these changes and pull into local repository.

git pull allows to get all changes from remote repo.

Besides github, there are other websites(repositories).
- BitBucket (I used it at work)
-


     */
}
