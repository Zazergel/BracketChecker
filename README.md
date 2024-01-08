<br/>
<p align="center">
  <a href="https://github.com/Zazergel/BracketChecker">
    <img src="https://raw.githubusercontent.com/Zazergel/BracketChecker/main/logo_bc.png" alt="Logo" width="400" height="270">
  </a>
  <h3 align="center">BracketChecker</h3>
  <p align="center">
    Check your text for correct bracket placement!
    <br/>
    <a href="https://github.com/Zazergel/BracketChecker/issues">Report Bug</a> *
    <a href="https://github.com/Zazergel/BracketChecker/issues">Request Feature</a>
  </p>
</p>
<div class="header" markdown="1" align="center">

  ![Downloads](https://img.shields.io/github/downloads/Zazergel/BracketChecker/total) ![Contributors](https://img.shields.io/github/contributors/Zazergel/BracketChecker?color=dark-green) ![Forks](https://img.shields.io/github/forks/Zazergel/BracketChecker?style=social) ![Issues](https://img.shields.io/github/issues/Zazergel/BracketChecker) 
</div>


## Table Of Contents

* [About the Project](#about-the-project)
* [Built With](#built-with)
* [Installation](#installation)
* [Usage](#usage)
* [Authors](#authors)

## About The Project

Данный проект реализует алгоритм для проверки правильной расстановки круглых скобок в тексте. В основе него лежит использование дека, который помогает отслеживать парность скобок.

Алгоритм начинает сканировать входной текст, обнаруживая открывающие и закрывающие скобки. Когда встречается открывающая скобка, она добавляется в дек. Если встречается закрывающая скобка, то производится проверка последней добавленной скобки в деке на парность с текущей закрывающей скобкой. Если парность не соблюдается, то текст считается неправильно составленным. Если парность соблюдается, то последняя открывающая скобка удаляется из дека. При сканировании всего текста, если дек не пустой, то текст также считается неправильно составленным.

Программа реализована в виде класса, который содержит метод для проверки текста на правильность расстановки скобок. Он принимает входной текст и возвращает true, если скобки расставлены правильно, и false в противном случае.

Преимущества данного проекта включают простоту использования и эффективность алгоритма, который работает за линейное время, так как каждая открывающая скобка добавляется в стек и каждая закрывающая скобка проверяется с последней скобкой в стеке.


## Built With
<p align="left">
    <img src="https://skillicons.dev/icons?i=java,maven,spring,docker" />
</p>

### Installation

1. Склонируйте репозиторий

```sh
git clone https://github.com/Zazergel/BracketChecker.git
```

2. Установите [Docker](https://www.docker.com/products/docker-desktop/)

3. Запустите проект с помощью Docker-compose

4. Отправьте POST запрос содержащий в теле JSON 
```sh
http://localhost:8080/api/checkBrackets
```
Пример тела запроса в формате JSON:
```sh
{
  "text": "Вчера я отправился в поход в лес вместе с друзьями. Мы выбрали маршрут, который проходил через горные потоки и поля (для разнообразия). В начале пути погода была отличной, солнце светило ярко, и птицы радостно пели. Однако, когда мы подошли ближе к вершине горы, небо стало покрываться облаками, (как будто природа готовила нам небольшой сюрприз). 
}
```
Пример ответа при правильной расстановке скобок:
```sh
{
    "isCorrect": true
}
```

## Usage

Этот проект полезен для разработчиков, которые работают с текстовыми данными и нуждаются в проверке правильности расстановки круглых скобок. Он может быть использован в различных областях программирования, где требуется обработка текстовых данных, таких как анализаторы кода, компиляторы, парсеры и другие инструменты.

## Authors

 **[Zazergel](https://github.com/Zazergel/)**

