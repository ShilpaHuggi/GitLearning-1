# GitLearning
Configuration Management -- talk about git

From Pavan videos
==================
gitinit  ---  create a local repository 
git add -- moving to stage area from your workspace.  ==> tracking will start from .....
git add.   -- will add all files to staging
git commit -m -- take/push the files to local repository (which is hidden)
git status -- to know the status of file whether it is in working dir, or staging or local repo
Before pushing the code to remote repository, 
we need to provide the connection with repository
for that commands are:
git remote add origin "link of  git hub remote repository"
To give user name /password. --- commands are 
git config --global user.email emailid
git config --global user.name name 
then push the code --- git push -u origin branch name
then to pull the code from remote repository. --- 
git pull origin master/branchname

to clone data at first into your system:
git clone "remote repository link"
git fetch origin master/branch --- the changes will not be applied to local repository, but will download the code and changes is not going to applied to your code.(not collabarated/merged)
git log -- gives all tracked files 
git log --oneline  ====> help you to see the commit ids
git help -- give you all commands 
git ls -files ==> displays files from staging area.
git remove filename ==> 
git diff file1 file2 ==> to know the difference between content in the files
                                    or 
                                    example: working directory file and the previous commit
                                    or difference between tracked or ontracked file
 git diff HEAD "filename of working dir/untracked file"
 HEAD ==> always point to recent commit
 
 From Raghav videos
 ===================
 Git checkout branchname ==> switch to new branch
 git --version ==> to check version about git bash
 git --merged ==>to know what all branches got merged in remote repository
 git branch -d branchname ==> will delete the branch from local
 git checkout -b branchname master
 
 // delete branch locally
git branch -d localBranchName

// delete branch remotely
git push origin --delete remoteBranchName
