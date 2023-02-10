<html>
  <head>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Poppins">
    <style>
      body {
        font-family: 'Poppins', serif;
      },
      .orange {
        margin: auto;
        text-align: center;
        color: #f09559;
      }
    </style>
  </head>
  <body>
    <div style="text-align: center;">
    <img width="40%" src="./images/GuruMu.svg">
    <h1 style="color: #F66B0E;">GuruMu</h1>
    Capstone Program Immersive Alterra Academy <br/>
    <a href="https://docs.google.com/spreadsheets/d/1mGQj6NVbtYZCHcabdkA4AH5UWITxDrlY0hzvWixFoT4/edit#gid=1006319607" target="blank"><img src="https://img.shields.io/badge/-Test%20Scenario-181717?style=for-the-badge&logo=microsoft-excel&color=f09559&logoColor=white" /></a>
    <a href="https://app.swaggerhub.com/apis-docs/CapstoneAltaBE14/GuruMu/1.0.0#/" target="blank"><img src="https://img.shields.io/badge/-API%20Documentation-181717?style=for-the-badge&logo=swagger&color=f09559&logoColor=white" /></a>
    </div>
    <h3>About GuruMu</h3>
    <p>
      GuruMu is an online private-study platform. Where users can order private tutors at any time. 
      Currently tutoring center located in more than 5 cities that combines online and offline learning.
      With GuruMu, no more obstacles to be able to learn independently. 
      GuruMu is available for students from elementary to high school and also serves all curricula in Indonesia.
    </p>
    <h3>Collaboration</h3>
    <div>
        <p>‍💻 <a href="https://github.com/ALTA-Gurumu/Frontend">[Frontend]</a></p> 
        <p>‍💻 <a href="https://github.com/ALTA-Gurumu/Backend">[Backend]</a></p> 
        <p>‍💻 <a href="https://github.com/ALTA-Gurumu/QE-API">[Automation API]</a></p> 
        <p>‍💻 <a href="https://github.com/ALTA-Gurumu/QE-Web">[Automation Web]</a></p> 
    </div>
    <h3>Report</h3>
    <div></div>
    <h3>Tools</h3>
    <div>
      <p>Manual Testing</p>
      <img src="https://img.shields.io/badge/-Google%20Chrome-181717?style=for-the-badge&logo=GoogleChrome&color=f09559&logoColor=white">
      <img src="https://img.shields.io/badge/-Postman-181717?style=for-the-badge&logo=postman&color=f09559&logoColor=white">
      <p>Automation Testing</p>
      <img src="https://img.shields.io/badge/-java-181717?style=for-the-badge&logo=java&color=f09559">
      <img src="https://img.shields.io/badge/-Apache%20Maven-181717?style=for-the-badge&logo=Apache%20Maven&color=f09559&logoColor=white">
      <img src="https://img.shields.io/badge/-cucumber-181717?style=for-the-badge&logo=cucumber&color=f09559&logoColor=white">
      <img src="https://img.shields.io/badge/-Rest%20Assured-181717?style=for-the-badge&logo=Rest-Assured&color=f09559&logoColor=white">
      <img src="https://img.shields.io/badge/-serenitybdd-181717?style=for-the-badge&logo=serenitybdd&color=f09559&logoColor=white">
      <img src="https://img.shields.io/badge/-IntelliJIDEA-181717?style=for-the-badge&logo=intellij-idea&color=f09559">
      <img src="https://img.shields.io/badge/-Gherkin-181717?style=for-the-badge&logo=gherkin&color=f09559">
      <p>Management Project</p>
      <img src="https://img.shields.io/badge/-GitHub-181717?style=for-the-badge&logo=github&color=f09559">
    </div>
  </body>
</html>

### 🔗 Git

Cara pindah branch:
```
git checkout feature_a
```

Cara membuat branch baru:
```
git branch feature_b
```


Cara commit:
- menyamakan current branch dengan main // harus di branch main
  `git pull --rebase origin main`
- how to check location branch
  `git branch`
- pindah branch
  `git checkout <branch> `
- add perubahan nya
  `git add .` // harus di branch sendiri
- commit
  `git commit -m "message"` // harus di branch sendiri
- push
  `git push origin <branch>` // harus di branch sendiri -> git origin feature/login

### :bookmark: Note
FORMAT NAMA BRANCH:

- feature/[HTTP METHOD]-[ENDPOINT] contoh:
    - `feature/login`
    - `feature/reservation`

FORMAT COMMIT MESSAGE:
- [NAMA BRANCH]: message. contoh:
    - `feature/login: Add schenario for login` 


* Convert json to json schema ? https://www.liquid-technologies.com/online-json-to-schema-converter
* Maven repository: https://mvnrepository.com/
