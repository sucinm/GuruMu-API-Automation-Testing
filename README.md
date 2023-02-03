# GuruMu API
Create automation testing for API

Cara pindah branch:
```
git checkout feature_a
```

Cara membuat branch baru:
```
git branch feature_b
```


Cara commit:

- how to check location branch
  `git branch`
- pindah branch
  `git checkout <branch> `
- add perubahan nya
  `git add .` // harus di branch sendiri
- commit
  `git commit -m "message"` // harus di branch sendiri
- menyamakan current branch dengan main
  `git pull --rebase origin main`
- push
  `git push origin <branch>` // harus di branch sendiri -> git origin feature/login

# NOTE
FORMAT NAMA BRANCH:

- feature/[HTTP METHOD]-[ENDPOINT] contoh:
    - `feature/login`
    - `feature/reservation`

FORMAT COMMIT MESSAGE:
- [NAMA BRANCH]: message. contoh:
    - `feature/login: Add schenario for login` 


* Convert json to json schema ? https://www.liquid-technologies.com/online-json-to-schema-converter
* Maven repository: https://mvnrepository.com/
