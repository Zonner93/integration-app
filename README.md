#Deeploy: 
https://integration-application.herokuapp.com/

#API Documentation:
https://docs.google.com/document/d/1PdKyKKskclwfqEa6D5WifAz3W_YU4XQYPNQdjlVaGaY

# Conventions

## 1. Git

### 1.1 Creating new branches

type/brief

brief should be short description (i.e. feat/Application-Form-Service)

### 1.2 Commit message

type: brief

### 1.3 Merge Requests

If you want to introduce your changes to develop branch you should push your changes to your working branch.
Next you have to create pull request that has to be approved by at least one person.
When merging branch to develop you should squash commits.

Merge request title should look like:

taskNumber - brief

In description, it should have link to task in jira

### 1.4 Types:

- add: new backwards-compatible abilities or functionalities
- fix: changes related to backwards-compatible bug fixes
- refactor: related to modifying the codebase, which neither adds a feature nor fixes a bug
- build: changes related to build system
- ci: changes related to continuous integration and development system
- docs: changes related to documentation
- perf: changes related to backward-compatible performance improvements
- style: related to styling the codebase, regardless of the meaning
- test: changes related to tests


### 2.2 Entities

Entity should have annotation for table name written with lower case <br/>
If name has multiple parts they should be separated with '_' <br/>
i.e: @Table(name = "application_forms")

### 2.3 Good practices

1. Before committing you should use these commands to format your code:
    1. ctrl+alt+l - reformatting code
    2. ctrl+alt+o - organizing imports

###### [How to create README (markdown) file](https://www.markdownguide.org/basic-syntax/)

