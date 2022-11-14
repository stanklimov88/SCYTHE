Feature: Cookie-policy
  Как пользователю,
  мне нужен прозрачный механизм cookie-policy,
  чтобы самостоятельно решать какие куки принимать

  Background:
    Given - открываем стартовую страницу
    And   - очищаем куки

  @smoke
  Scenario: Отображение попапа cookie-policy
    When  - открываем страницу поиска
    Then  показан попап cookie-policy

  @acceptance @regression
  Scenario: Принятие всех куки
    Given - открываем страницу поиска
    When  - принимаем все куки
    Then  скрыт попап cookie-policy

  @acceptance @regression
  Scenario: Отсутствие попапа cookie-policy после принятия куки
    Given - открываем страницу поиска
    And   - принимаем все куки
    When  - обновляем страницу
    Then  попап cookie-policy не появляется

  @regression
  @wip
  Scenario: Открытие ссылки на cookie-policy из попапа

  @regression
  @wip
  Scenario: Настройка принятия куки

  @regression
  @wip
  Scenario: Открытие ссылки на cookie-policy из меню настроек куки






