# GitHub Activity CLI

## Overview
GitHub Activity CLI is a simple command-line tool that fetches and displays the recent activity of a specified GitHub user. It utilizes the GitHub API to retrieve public events such as commits, issues, and stars.

## Features
- Fetch recent public GitHub activity of a user
- Display up to 5 recent events
- Handles API errors and invalid usernames gracefully

## Prerequisites
- Java 17 or later
- Internet connection

## Installation & Usage
### Clone the Repository
```sh
git clone https://github.com/yourusername/GitHub-Activity-CLI.git
cd GitHub-Activity-CLI
```

### Compile the Code
```sh
javac GitHubActivityCLI.java
```

### Run the CLI
```sh
java GitHubActivityCLI <GitHub-Username>
```
Example:
```sh
java GitHubActivityCLI kamranahmedse
```

## Example Output
```
Recent GitHub Activity:
- Pushed 3 commits to kamranahmedse/developer-roadmap
- Opened a new issue in kamranahmedse/developer-roadmap
- Starred kamranahmedse/developer-roadmap
```

## Error Handling
- Invalid GitHub usernames return a proper error message.
- If GitHub API is down, the program notifies the user.

## Contributing
Feel free to submit issues and pull requests to enhance this project!



