# Testes automatizados da Dog API

Projeto de testes de API com código compatível com Java 11, Rest Assured,
Cucumber (BDD) e Gradle. Os cenários são escritos em português (PT-BR) e
validam o status HTTP e o formato dos dados retornados pela API.

## Pré-requisitos

- JDK 17 ou superior para executar o Gradle (o código é compilado para Java 11)
- Acesso à internet para baixar as dependências e consultar a Dog API

## Executar os testes

No Windows:

```powershell
.\gradlew.bat test
```

No macOS ou Linux:

```bash
./gradlew test
```

Para executar os testes e gerar o relatório Allure com gráficos:

```bash
./gradlew clean test allureReport
```

No Windows, use `.\gradlew.bat clean test allureReport`.

O relatório HTML do Gradle fica em `build/reports/tests/test/index.html`, e o
relatório Allure em `build/reports/allure-report/allureReport/index.html`.
Na pipeline do GitHub Actions, o relatório e os resultados brutos ficam
disponíveis como artefato `allure-report` por 14 dias, mesmo quando os testes
falham.
