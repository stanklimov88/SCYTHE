#noinspection NonAsciiCharacters
Feature: Поиск на сайте
  Как пользователю,
  мне нужен текстовый поиск,
  чтобы находить информацию по запросу

  @smoke
  Scenario: Отображение поисковой строки на странице
    Given - открываем страницу поиска
    Then  отображается поисковая строка

  @regression
  @wip
  Scenario: Скрытие кнопки поиска по дефолту

  @acceptance
  Scenario: Очистка поисковой строки крестиком
    Given - открываем страницу поиска
    When  - вводим проверочный поисковой запрос
    And   - очищаем строку поиска
    Then  очищена строка поиска
    And   скрыты поисковые подсказки

  Scenario Template: Отправка поисковых запросов
    Given - открываем страницу поиска
    When  - вводим "<query>" в поисковую строку
    And   - отправляем запрос
    Then показаны результаты поиска

    @smoke @acceptance @regression
    Examples:
      | query             |
      | самшит            |

    @acceptance @regression
    Examples:
      | query             |
      | lol               |
      | KEK               |
      | Чебурек           |
      | random coffee     |
      | 1974              |
      | 3,1415926         |
      | 2+2=5             |
      | email@example.com |

    @regression
    Examples:
      | query             |
      | camelCase         |
      | kebab-case        |
      | snake_case        |
      | SCREAMING_SNAKE   |

  @security
  @regression
  Scenario Template: Экранирование вредоносных поисковых запросов
    Given - открываем страницу поиска
    When  - вводим "<query>" в поисковую строку
    And   - отправляем запрос
    Then  показаны результаты поиска

    Examples:
      | query             |
      | alert(1);         |
      | '+OR+1=1--        |
      | {foo: \"bar\"}    |

  @acceptance @regression
  Scenario Template: Отсутствие результатов поиска
    Given - открываем страницу поиска
    When  - вводим "<query>" в поисковую строку
    And   - отправляем запрос
    Then  нет результатов поиска
    And   показана заглушка отсутствия результатов поиска
    Examples:
      | query             |
      | ???????           |
