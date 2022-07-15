import com.test.API.AuthProd;
import com.test.API.AuthStg;
import com.test.API.Calls;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;

public class UnitTest {
    private final String stgAPI = "https://api.keyprstg.com/v1";
    private final String prodAPI = "https://api.keyprprod.com/v1";

    public static void main(String[] args) throws IOException, ParseException {
        //LocalDate newDate = LocalDate.parse("2022-07-11T21:00:01Z", DateTimeFormatter.ISO_ZONED_DATE_TIME);
        Calls.patchReservation().patch("https://api.keyprprod.com/v1/", AuthProd.getToken(), "aca8351d-61a1-4e04-9d88-3988ecf5c13f", "7d9df54b-c423-48d9-ac35-ab2979105027", "62c6ecfe60f9cc570807f6cc", "2022-07-14T03:00:00Z");
    }

}

/*

[
        {
        "groupName": "directions",
        "nodes": [
        {
        "size": "50",
        "subGroup": "",
        "name": "destinationHeaderLabel",
        "text": "Призначення"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "destinationHintText",
        "text": "Введіть адресу призначення"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "loadingLabel",
        "text": "Завантажую..."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "noDirectionsErrorText",
        "text": "Нажаль, жодних напрямів не знайдено"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "originHeaderLabel",
        "text": "Відправлення"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "originHintText",
        "text": "Введіть адресу відправлення"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "requiredLabel",
        "text": "*необхідне"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "searchLabel",
        "text": "Пошук"
        }
        ]
        },
        {
        "groupName": "errors",
        "nodes": [
        {
        "size": "255",
        "subGroup": "",
        "name": "loginFail",
        "text": "Помилка лоґ іну"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "sidDoesntExist",
        "text": "Введіть номер кімнати"
        }
        ]
        },
        {
        "groupName": "expresscheckout",
        "nodes": [
        {
        "size": "255",
        "subGroup": "",
        "name": "descriptionText",
        "text": "буде запощщене до вашого акаунту. Введіть імейл для отримання квитанції вашого чекауту."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "emailAddressHintLabel",
        "text": "Введіть імейл"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "emailAddressLabel",
        "text": "Імейл адреса"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "submitLabel",
        "text": "Підтвердити"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "validationInvalidLabel",
        "text": "Невірно"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "validationRequiredLabel",
        "text": "*Необхідне"
        }
        ]
        },
        {
        "groupName": "flightstats",
        "nodes": [
        {
        "size": "50",
        "subGroup": "",
        "name": "airlineLabel",
        "text": "Авіалінії"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "airportLabel",
        "text": "Аеропорт"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "allLabel",
        "text": "Усі авіалінії"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "arrivalsLabel",
        "text": "Вхідні"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "CanceledStatusLabel",
        "text": "Скасовані"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "delayedStatusLabel",
        "text": "Затримуються"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "departuresLabel",
        "text": "Вихідні"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "doneLabel",
        "text": "Готово"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "errorText",
        "text": "Нема результатів"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "filterLabel",
        "text": "Фільтр"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "landedStatusLabel",
        "text": "Прибули"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "minutesLateLabel",
        "text": "хвилин запізнення"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "noFlightLabel",
        "text": "Немає рейсів на цей час."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "noTimeLabel",
        "text": "Дані недоступні"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "onTimeStatusLabel",
        "text": "Вчасно"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "timeRangeLabel",
        "text": "ПРОМІЖОК ЧАСУ"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "unknownStatusLabel",
        "text": "Дані недоступні"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "canceledStatusLabel",
        "text": "0"
        }
        ]
        },
        {
        "groupName": "global",
        "nodes": [
        {
        "size": "50",
        "subGroup": "",
        "name": "cancelLabel",
        "text": "Скасувати"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "doneLabel",
        "text": "Готово"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "invalidLabel",
        "text": "*невірно"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "okLabel",
        "text": "Ok"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "requiredLabel",
        "text": "*Необхідне"
        },
        {
        "size": "250",
        "subGroup": "",
        "name": "sslErrorLabel",
        "text": "Не можу завантажити. Невірний сертифікат................."
        }
        ]
        },
        {
        "groupName": "home",
        "nodes": [
        {
        "size": "50",
        "subGroup": "",
        "name": "currentWeatherLabel",
        "text": "Зараз"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "dashboardAccessibilityLabel",
        "text": "Дашборд"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "mainMenuLabel",
        "text": "Головне меню"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "moreMenus",
        "text": "Більше від нашого готелю"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "noDataText",
        "text": "Немає даних"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "profileAccessibilityLabel",
        "text": "Профіль"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "tvBackButtonLabel",
        "text": "Назад"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "viewAllLabel",
        "text": "Дивитись усе"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "welcomeLabel",
        "text": "Ласкаво просимо до готелів Сапфір"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "newMessages",
        "text": "New Messages"
        }
        ]
        },
        {
        "groupName": "ICSNotifications",
        "nodes": [
        {
        "size": "50",
        "subGroup": "Common",
        "name": "due",
        "text": " До"
        },
        {
        "size": "50",
        "subGroup": "Common",
        "name": "dueDate",
        "text": " До дати"
        },
        {
        "size": "50",
        "subGroup": "Common",
        "name": "dueTime",
        "text": " До часу"
        },
        {
        "size": "50",
        "subGroup": "Common",
        "name": "frontDeskMsg",
        "text": " Зверніться до стійки реєстрації, якщо якась інфа неточна"
        },
        {
        "size": "50",
        "subGroup": "Common",
        "name": "guestName",
        "text": " Ім'я гостя"
        },
        {
        "size": "50",
        "subGroup": "Common",
        "name": "msg2",
        "text": "Див. ICS"
        },
        {
        "size": "50",
        "subGroup": "Common",
        "name": "name",
        "text": " Ім'я"
        },
        {
        "size": "50",
        "subGroup": "Common",
        "name": "reqDate",
        "text": " Дата ріквесту"
        },
        {
        "size": "50",
        "subGroup": "Common",
        "name": "reqTime",
        "text": " Час ріквесту"
        },
        {
        "size": "50",
        "subGroup": "Common",
        "name": "request",
        "text": " Ріквест"
        },
        {
        "size": "50",
        "subGroup": "Common",
        "name": "room",
        "text": " Кімната"
        },
        {
        "size": "50",
        "subGroup": "Common",
        "name": "roomNum",
        "text": " Номер Кімнати"
        },
        {
        "size": "50",
        "subGroup": "Common",
        "name": "ticket",
        "text": " Тікет #"
        },
        {
        "size": "50",
        "subGroup": "Common",
        "name": "ticketNum",
        "text": " Тікет номер"
        },
        {
        "size": "50",
        "subGroup": "Common",
        "name": "tknksMsg",
        "text": " Дякуємо за ваш "
        },
        {
        "size": "50",
        "subGroup": "Login",
        "name": "activity",
        "text": " Активність"
        },
        {
        "size": "50",
        "subGroup": "Login",
        "name": "checkIn",
        "text": " Чек-Ін"
        },
        {
        "size": "50",
        "subGroup": "Login",
        "name": "checkOut",
        "text": " Чек-Аут"
        },
        {
        "size": "50",
        "subGroup": "Login",
        "name": "contactStage",
        "text": " Contact stage"
        },
        {
        "size": "50",
        "subGroup": "Login",
        "name": "gift",
        "text": " Подарунок"
        },
        {
        "size": "50",
        "subGroup": "Login",
        "name": "guestName",
        "text": " Ім'я гостя"
        },
        {
        "size": "50",
        "subGroup": "Login",
        "name": "iceLoginNotification",
        "text": " Сповіщення ICE логіну"
        },
        {
        "size": "50",
        "subGroup": "Login",
        "name": "loginDate",
        "text": " Дата логіну"
        },
        {
        "size": "50",
        "subGroup": "Login",
        "name": "loginNotification",
        "text": " Сповіщення логіну"
        },
        {
        "size": "50",
        "subGroup": "Login",
        "name": "marketingRep",
        "text": " Маркетинг реп"
        },
        {
        "size": "50",
        "subGroup": "Login",
        "name": "ownerType",
        "text": " Тип власника"
        },
        {
        "size": "50",
        "subGroup": "Login",
        "name": "pointLevels",
        "text": " Point Levels"
        },
        {
        "size": "50",
        "subGroup": "Login",
        "name": "room",
        "text": " Кімната"
        },
        {
        "size": "50",
        "subGroup": "Login",
        "name": "salesRep",
        "text": " Sales Rep"
        },
        {
        "size": "50",
        "subGroup": "Login",
        "name": "status",
        "text": " Статус"
        },
        {
        "size": "50",
        "subGroup": "Login",
        "name": "tourLocation",
        "text": " Тур по локації"
        },
        {
        "size": "50",
        "subGroup": "Login",
        "name": "tourTime",
        "text": " Час туру"
        },
        {
        "size": "50",
        "subGroup": "Message",
        "name": "guestName",
        "text": " Ім'я гостя"
        },
        {
        "size": "50",
        "subGroup": "Message",
        "name": "message1",
        "text": " Наступне повідомлення було переглянуте наступним отримувачем"
        },
        {
        "size": "50",
        "subGroup": "Message",
        "name": "msg",
        "text": " Повідомлення"
        },
        {
        "size": "50",
        "subGroup": "Message",
        "name": "msgSub",
        "text": " Тема повідомлення"
        },
        {
        "size": "50",
        "subGroup": "Message",
        "name": "name",
        "text": " Ім'я"
        },
        {
        "size": "0",
        "subGroup": "Message",
        "name": "recipeint",
        "text": " Отримувач"
        },
        {
        "size": "0",
        "subGroup": "Message",
        "name": "recipeintDetails",
        "text": " Деталі отримувача"
        },
        {
        "size": "50",
        "subGroup": "Message",
        "name": "recipient",
        "text": " Отримувач"
        },
        {
        "size": "50",
        "subGroup": "Message",
        "name": "recipientDetails",
        "text": " Деталі отримувача"
        },
        {
        "size": "50",
        "subGroup": "Message",
        "name": "room",
        "text": " Кімната"
        },
        {
        "size": "50",
        "subGroup": "Message",
        "name": "subject",
        "text": " Повернути квитанцію за переглянуте повідомлення"
        },
        {
        "size": "50",
        "subGroup": "Message",
        "name": "viewDate",
        "text": " дата перегляду"
        },
        {
        "size": "50",
        "subGroup": "Message",
        "name": "viewedOn",
        "text": " Переглянуто о"
        },
        {
        "size": "50",
        "subGroup": "PlayVideo",
        "name": "guestName",
        "text": " Ім'я гостя"
        },
        {
        "size": "50",
        "subGroup": "PlayVideo",
        "name": "name",
        "text": " Ім'я"
        },
        {
        "size": "50",
        "subGroup": "PlayVideo",
        "name": "palayedOn",
        "text": " Відтворено о"
        },
        {
        "size": "50",
        "subGroup": "PlayVideo",
        "name": "playedDate",
        "text": " Дата відтворення"
        },
        {
        "size": "50",
        "subGroup": "PlayVideo",
        "name": "playedOn",
        "text": "Відтворено о"
        },
        {
        "size": "50",
        "subGroup": "PlayVideo",
        "name": "playVideoMsg1",
        "text": " Наступне відео було переглянуте наступним отримувачем"
        },
        {
        "size": "50",
        "subGroup": "PlayVideo",
        "name": "playVideoMsg2",
        "text": " Повернена квитанція за відтворене відео"
        },
        {
        "size": "50",
        "subGroup": "Message",
        "name": "recipient",
        "text": " Отримувач"
        },
        {
        "size": "50",
        "subGroup": "Message",
        "name": "recipientDetails",
        "text": " Деталі отримувача"
        },
        {
        "size": "50",
        "subGroup": "PlayVideo",
        "name": "retReceiptSub",
        "text": " Повернена квитанція за відтворене відео"
        },
        {
        "size": "50",
        "subGroup": "Common",
        "name": "roomNum",
        "text": " Номер Кімнати"
        },
        {
        "size": "50",
        "subGroup": "PlayVideo",
        "name": "videoInfo",
        "text": " інформація про відео"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "bags",
        "text": " Число валіз(?)"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "commCardSub",
        "text": " Картки коментарів"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "comments",
        "text": " Коментарі"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "conReq",
        "text": " Консьєрж ріквеста"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "course",
        "text": " Курс"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "date",
        "text": " Дата"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "description",
        "text": " Опис"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "due",
        "text": " До"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "dueDate",
        "text": " Дата до"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "email",
        "text": " імейл"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "errMsg1",
        "text": " Зверніться до стійки реєстрації"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "errMsg2",
        "text": " Зверніться до стійки реєстрації, якщо якась інфа невірна"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "expresscheckout",
        "text": " Опис: експрес чекаут"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "giftChoice",
        "text": " Вибір подарунка"
        },
        {
        "size": "50",
        "subGroup": "Common",
        "name": "guestName",
        "text": " Ім'я гостя"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "item",
        "text": " Річ 1"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "locAndTime",
        "text": " Локація та час"
        },
        {
        "size": "50",
        "subGroup": "Common",
        "name": "name",
        "text": " Ім'я"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "numOfGolfers",
        "text": "Число гравців в гольф"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "numPeople",
        "text": "Число людей"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "orderType",
        "text": " Тип замовлення"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "partySize",
        "text": " Розмір групи"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "perTrainerReq",
        "text": " Ріквест персонального тренера"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "phone",
        "text": " Телефон"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "phone1",
        "text": " Телефон #"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "pmsErrorMessage",
        "text": "ПМС еррор меседж"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "pmsOrderError1",
        "text": " Помилка обробки замовлення PMS  (TEST)"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "reqDate",
        "text": " Дата ріквесту"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "reqTime",
        "text": " Час ріквесту"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "reqType",
        "text": " Тип ріквесту"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "request",
        "text": " Ріквест"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "resId",
        "text": " ІД резервації"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "restaurant",
        "text": " Ресторан"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "resTime",
        "text": " Час резервації"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "roomNum",
        "text": " Номер кімнати"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "serCharge",
        "text": " Оплата послуги"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "siteTourTitle",
        "text": " Ріквест сайт туру"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "sms",
        "text": " СМС"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "snoozeMin",
        "text": " Хв."
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "snoozeMsg",
        "text": " Меседж відкладення"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "snoozTime",
        "text": " Час відкладення"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "subject",
        "text": " Повернена квитанція за переглянутий меседж"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "taxes",
        "text": " Податки"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "thnksMsg",
        "text": " Дякуємо за ва"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "ticket",
        "text": " Тікет #"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "total",
        "text": " Загальне"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "wakeUp",
        "text": "Підйом"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "wakeUpdate",
        "text": "Дата підйому"
        },
        {
        "size": "50",
        "subGroup": "Request",
        "name": "wakeUpTime",
        "text": "Відкласти"
        },
        {
        "size": "50",
        "subGroup": "Store",
        "name": "delFee",
        "text": "Плата за доставку"
        },
        {
        "size": "50",
        "subGroup": "Store",
        "name": "gratuity",
        "text": " Вдячність(?)"
        },
        {
        "size": "50",
        "subGroup": "Store",
        "name": "instructions",
        "text": " Інстуркції "
        },
        {
        "size": "50",
        "subGroup": "Store",
        "name": "item",
        "text": " Річ 1"
        },
        {
        "size": "50",
        "subGroup": "Store",
        "name": "orderError1",
        "text": " Виникла проблема в обробці вашого замовлення"
        },
        {
        "size": "50",
        "subGroup": "Store",
        "name": "orderError2",
        "text": " Помилка оброблення замовлення від POS"
        },
        {
        "size": "50",
        "subGroup": "Store",
        "name": "orderError3",
        "text": " Помилка оброблення замовлення від POS"
        },
        {
        "size": "50",
        "subGroup": "Store",
        "name": "peopleEating",
        "text": " Кількість поглиначів їжі"
        },
        {
        "size": "50",
        "subGroup": "Store",
        "name": "pmsOrderError1",
        "text": " Помилка оброблення замовлення від PMS  (TEST)"
        },
        {
        "size": "50",
        "subGroup": "Store",
        "name": "price",
        "text": " Ціна1"
        },
        {
        "size": "50",
        "subGroup": "Store",
        "name": "quantity",
        "text": " Кількість1"
        },
        {
        "size": "50",
        "subGroup": "store",
        "name": "resError",
        "text": " Помилка резервації"
        },
        {
        "size": "50",
        "subGroup": "store",
        "name": "resNum",
        "text": " Номер резервації"
        },
        {
        "size": "50",
        "subGroup": "Store",
        "name": "sms",
        "text": " СМС"
        },
        {
        "size": "50",
        "subGroup": "Store",
        "name": "subTotal",
        "text": " Суб-сума"
        },
        {
        "size": "50",
        "subGroup": "Store",
        "name": "tax",
        "text": " Податок"
        },
        {
        "size": "50",
        "subGroup": "Store",
        "name": "totalPrice",
        "text": " Загальна ціна1"
        },
        {
        "size": "50",
        "subGroup": "TimeZone",
        "name": "notice",
        "text": " Усі дати та час показані в часовій зоні готелю"
        },
        {
        "size": "50",
        "subGroup": "TimeZone",
        "name": "UTC",
        "text": " UTC"
        },
        {
        "size": "50",
        "subGroup": "Transportation",
        "name": "arrCity",
        "text": " місто прибуття"
        },
        {
        "size": "50",
        "subGroup": "Transportation",
        "name": "contact",
        "text": "Контакт"
        },
        {
        "size": "50",
        "subGroup": "Transportation",
        "name": "depCity",
        "text": " Місто відправлення"
        },
        {
        "size": "50",
        "subGroup": "Transportation",
        "name": "destination",
        "text": " Призначення"
        },
        {
        "size": "50",
        "subGroup": "Transportation",
        "name": "numPassengers",
        "text": " Кількість пасажирів"
        },
        {
        "size": "50",
        "subGroup": "Transportation",
        "name": "phone",
        "text": " Телефон"
        },
        {
        "size": "50",
        "subGroup": "Transportation",
        "name": "pickUpAdd",
        "text": " Адреса посадки"
        },
        {
        "size": "50",
        "subGroup": "Transportation",
        "name": "pickUpDate",
        "text": " Дата посадки"
        },
        {
        "size": "50",
        "subGroup": "Transportation",
        "name": "pickUpTime",
        "text": " Час посадки"
        },
        {
        "size": "50",
        "subGroup": "Transportation",
        "name": "reqTitleAir",
        "text": " Ріквест транспорту в аеропорт"
        },
        {
        "size": "50",
        "subGroup": "Transportation",
        "name": "reqTitleCar",
        "text": " Аренда авто ріквест"
        },
        {
        "size": "50",
        "subGroup": "Transportation",
        "name": "reqTitleLuxury",
        "text": " Люкс ріквест"
        },
        {
        "size": "50",
        "subGroup": "Transportation",
        "name": "reqTitleRail",
        "text": " Залізничний ріквест"
        },
        {
        "size": "50",
        "subGroup": "Transportation",
        "name": "reqTitleTaxi",
        "text": " Таксі ріквест"
        },
        {
        "size": "50",
        "subGroup": "Transportation",
        "name": "sms",
        "text": " СМС"
        },
        {
        "size": "50",
        "subGroup": "Store",
        "name": "location",
        "text": "Table location"
        }
        ]
        },
        {
        "groupName": "idle",
        "nodes": [
        {
        "size": "255",
        "subGroup": "",
        "name": "dashboardGreeting",
        "text": "ЛАСКАВО ПРОСИМО"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "getStartedLabel",
        "text": "Почнімо!"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "messagesLabel",
        "text": "Повідомлення"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "requestsLabel",
        "text": "Ріквести"
        }
        ]
        },
        {
        "groupName": "idVerification",
        "nodes": [
        {
        "size": "255",
        "subGroup": "",
        "name": "documentBackImageDescription",
        "text": "• Використовуйте відповідне освітлення без засвітів\\n• Впевніться, що ваш документ добре видно і він у фокусі\\n• Захопіть усі чотири кута вашого документу"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "documentBackImageShutterButton",
        "text": "Продовжити"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "documentBackImageTitle",
        "text": "Наступне фото - Сфотографуйте зворотню сторону ІД"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "documentClassificationError",
        "text": "Помилка класифікації"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "documentClassificationErrorDescription",
        "text": "Не вдалось класифікувати документ"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "documentContinueButton",
        "text": "Використати фото"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "documentError",
        "text": "Помилка"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "documentErrorDescription",
        "text": "Трапилась невідома помилка. Не вдалось витягти дані"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "documentFailedDescription",
        "text": "Не вдалось захопити ІД. Будь ласка, спробуйте ще"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "documentFailedRetakeButton",
        "text": "Замінити фото новим"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "documentFailedTitle",
        "text": "Зображення розмите"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "documentFrontImageDescription",
        "text": "Потрібен офіційний документ з фото. напр.: водійські права, паспорт, картка особи\\n\\nЩоб додати ваш документ, зробіть його фото камерою вашого телефону.\\n\\n• Використовуйте відповідне освітлення без засвітів\\n• Впевніться, що ваш документ добре видно і він у фокусі\\n• Захопіть усі чотири кута вашого документу"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "documentFrontImageShutterButton",
        "text": "Зробити фото документу"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "documentFrontImageTitle",
        "text": "Додати фото документу"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "documentRetakeButton",
        "text": "Зробити нове фото"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "errorButton",
        "text": "Спробуйте ще"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "idNotVerified",
        "text": "Не перевірено"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "isVerified",
        "text": "Перевірено"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "landingAnd",
        "text": "та"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "landingConfirmationButton",
        "text": "Прийнято"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "landingPrivacyPolicy",
        "text": "Політика конфіденційності"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "landingSubtitle",
        "text": "Готель Інтеліті"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "landingTermsAndConditions",
        "text": "Правила та умови"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "landingText",
        "text": "Щоб пропустити чек-ін на стійці реєстрації та відправитись до своєї кімнати, вам потрібно підтвердити вашу особу."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "landingTitle",
        "text": "ID Верифікація"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "resultBackendError",
        "text": "Помилка"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "resultBackendErrorMessage",
        "text": "У нас виникла помилка і ми її виправляємо. Спробуйте пізніше"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "resultConectivityError",
        "text": "Помилка з'єднання"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "resultConectivityErrorMessage",
        "text": "Нема інтернету. Впевніться, що Wi-Fi чи мобільну мережу підключего і спробуйте знову"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "resultContinueButton",
        "text": "Продовжити"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "resultDocumentError",
        "text": "Ім'я, вказане в документі, не співпало з ім'ям в резервації.\\n\\nБудь ласка оберіть документ, який співпадає з ім'ям в резервації та спробуйте ще раз. Для подальшої допомоги зверніться до стійки реєстрації."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "resultDocumentImageSubtitle",
        "text": "Перевіряю ім'я в резервації"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "resultDocumentImageTitle",
        "text": "Відправляю ІД"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "resultError",
        "text": "Помилка перевірки"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "resultErrorButton",
        "text": "Спробуйте ще"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "resultSelfError",
        "text": "Не можемо обробити ваше фото.\\n\\nБудь ласка, спробуйте зробити фото документа ще раз.\\n\\n• Use proper lighting without glare\\n• Ensure your ID is fully visible and in focus\\n• Capture all four corners of your ID."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "resultSelfImageTitle",
        "text": "Перевіряється"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "resultSuccess",
        "text": "Вітаємо!"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "resultSuccessDescription",
        "text": "Перевірку завершено"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "sdkClassifyImageAction",
        "text": "Класифікація..."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "sdkCropImageAction",
        "text": "Обрізання..."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "sdkInitializeAction",
        "text": "Ініціалізація..."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "sdkInitializeError",
        "text": "Помилка"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "sdkInitializeErrorMessage",
        "text": "Не вдалось ініціалізувати"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "sdkOpenCameraAction",
        "text": "Відкриваю камеру..."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "sdkUploadImageAction",
        "text": "Відвантажуємо..."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "selfImageCanceledError",
        "text": "Користувач скасував захоплення обличчя"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "selfImageDescription",
        "text": "Ми порівняємо це фото з вашим документом.\\n\\n• Впевніться, що ваше обличчя добре освітлене та чітко видно\\n• Поверніться до камери так відцентруйте обличчя згідно рамки\\n• Використовуйте стіну у якості тла, якщо можливо"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "selfImageError",
        "text": "Помилка захоплення обличчя"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "selfImageErrorMessage",
        "text": "Хотіли б спробувати ще?"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "selfImageShutterButton",
        "text": "Зробіть селфі"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "selfImageTitle",
        "text": "Сфотографуйтесь"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "stepsDescription",
        "text": "Щоб підтвердити вашу особистість, ім'я та прізвище вашої резервації повинне співпасти з вашим державним документом."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "stepsRequisiteOneContinueButton",
        "text": "Продовжити"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "stepsRequisiteOneSubtitle",
        "text": "Паспорт, Водійське посвідчення"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "stepsRequisiteOneTitle",
        "text": "Посвідчення особистості з фото"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "stepsRequisiteTwoContinueButton",
        "text": "Продовжити з чек-іном"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "stepsRequisiteTwoSubtitle",
        "text": "Власне фото в реальному часі"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "stepsRequisiteTwoTitle",
        "text": "Селфі"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "stepsStartButton",
        "text": "Почати"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "stepsTitle",
        "text": "Виконайте наступне для підтвердження особистості"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "confirmCheckInDialogConfirmButtonText",
        "text": "Confirm"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "confirmCheckInDialogIDNumberFieldLabel",
        "text": "ID Number: "
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "confirmCheckInDialogNameFieldLabel",
        "text": "Name: "
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "confirmCheckInDialogNationalityFieldLabel",
        "text": "Nationality: "
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "confirmCheckInDialogNotCorrectText",
        "text": "Information not correct? See the front desk."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "confirmCheckInDialogSubTitle",
        "text": "Check your personal information below."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "confirmCheckInDialogTitle",
        "text": "Confirm Identity to Check In"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "idVerificationRequiredLabel",
        "text": "ID Verification"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "sdkInitializeConectivityErrorMessage",
        "text": "Could not initialize. No network connection"
        }
        ]
        },
        {
        "groupName": "languageconfirmation",
        "nodes": [
        {
        "size": "50",
        "subGroup": "",
        "name": "cancelLabel",
        "text": "Скасувати"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "confirmLabel",
        "text": "Підтвердити"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "descriptionText",
        "text": "Впевнені?"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "titleLabel",
        "text": "Змінити мову"
        }
        ]
        },
        {
        "groupName": "maps",
        "nodes": [
        {
        "size": "50",
        "subGroup": "",
        "name": "directionsLabel",
        "text": "Напрямки"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "mapsLabel",
        "text": "Мапи"
        }
        ]
        },
        {
        "groupName": "mobileKey",
        "nodes": [
        {
        "size": "50",
        "subGroup": "",
        "name": "accessKeyActionButton",
        "text": "Отримати ключ"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "activateKeyActionButton",
        "text": "Активувати ключ"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "bannerCheckOutErrorFrontDesk",
        "text": "Чек аут невдалий"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "bannerCheckOutSuccess",
        "text": "Чек аут успішний"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "bannerErrorFrontDeskTitle",
        "text": "Ваш чек-ін не може бути завершено.\\nЗверніться до стійки реєстрації чи спробуйте пізніше"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "bannerErrorTryAgainTitle",
        "text": "Помилка активації ключа. Спробуйте ще."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "bannerSuccessCheckIn",
        "text": "Чек-ін вдалий."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "bannerSuccessTitle",
        "text": "Ваш ріквест успішно отримано."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "checkInRequirements",
        "text": "Необхідно для чек-іну"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "checkOutActionButton",
        "text": "Чек аут зараз"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "descriptionBottomLabelReservationDetail",
        "text": "Ваш запит обробляється.\\nЗверніть увагу, що оновлення резервації може зайняти кілька хвилин"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "dueInIntroText",
        "text": "Ми повідомимо вас, коли ваша кімната буде готова. Тим часом, будь ласка, приєднуйтесь до нас в лаунджі, де є коктейлі та жива музика. Використайте цей код, щоб отримати рахунки до вашої кімнати: [INTERFACE_ID]."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "dueInIntroTitle",
        "text": "Майже все"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "errorImportReservationDescription",
        "text": "Підтвердіть правильність введеної інформації. Ви маєте пройти чек-ін до вашої кімнати, щоб отримати Мобільний Ключ."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "errorImportReservationTitle",
        "text": "Резервація не може бути імпортована у цей час. Зверніться до стійки реєстрації за допомогою чи спробуйте пізніше."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "errorKeyNoLongerAvailableDescription",
        "text": "Зверніться до стійки реєстрації по допомогу"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "errorKeyNoLongerAvailableTitle",
        "text": "Ваш мобільний ключ більше недоступний"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "errorNoInternetConnectionDescription",
        "text": "Перевірте ваше з'єднання і спробуйте ще раз"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "errorNoInternetConnectionTitle",
        "text": "Немає доступу в інтернет"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "errorReservationIsCheckedOutDescription",
        "text": "Щоб скористатись мобільним ключем, резервація має бути зачекінена. Для подальшої допомоги, будь ласка, зверніться до стійки реєстрації."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "errorReservationIsCheckedOutTitle",
        "text": "Вас виписали (чекаутнули)."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "exitFlow",
        "text": "Вихід"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "expeditedCheckInDate",
        "text": "Дата вписки (чек іну)"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "expeditedCheckInNotes",
        "text": "Примітки"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "expeditedCheckInNotesHint",
        "text": "Додаткові запити чи потреби?"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "expeditedCheckInNoticeDescription",
        "text": "стійка реєстрації перевірить ваш запит та невдовзі вас впише (зачекінить). Ми повідомимо вас, коли ваша кімната та мобільний ключ будуть готові. "
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "expeditedCheckInNoticeTitle",
        "text": "Запит на прискорену вписку (чек-ін)"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "expeditedCheckInTime",
        "text": "Час вписки (чек-іну)"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "floatingActionButtonCasePrimary",
        "text": "Відкрийте ваші двері"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "floatingActionButtonCaseSecondary",
        "text": "Натисніть на ключі тут, щоб почати використовувати ваш Мобільний Ключ до вашої резервації"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "floatingActionButtonOfflineCasePrimary",
        "text": "Немає з'єднання? Не проблема"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "floatingActionButtonOfflineCaseSecondary",
        "text": "Ви усе ще можете використовувати ваш Мобільний Ключ без інтернет з'єднання"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "folioAcceptChargesLabel",
        "text": "Виписуючись, ви приймаєте суму стягнень"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "folioCheckOutConfirmCancel",
        "text": "Скасувати"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "folioCheckOutConfirmContinue",
        "text": "Продовжити"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "folioCheckOutConfirmDescription",
        "text": "При виписці з вас стягнуть плату за несплачені предмети з вашої вказаної картки та випишуть з вашої резервації. Ви більше не зможете використовувати ваш Мобільний Ключ"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "folioCheckOutConfirmTitle",
        "text": "Виписати з резервації"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "folioCheckOutConnectivityErrorMessage",
        "text": "Немає інтернет з'єднання. Перевірте wifi чи мобільну мережу та спробуйте ще "
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "folioCheckOutEmailErrorCancel",
        "text": "Скасувати"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "folioCheckOutEmailErrorContinue",
        "text": "Продовжити"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "folioCheckOutEmailErrorDescription",
        "text": "Ваше фоліо не може бути відправлене в даний момент. Зверніться до стійки реєстрації щоб отримати копію фоліо імейлом"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "folioCheckOutEmailErrorTitle",
        "text": "Надсилання фоліо невдале"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "folioEmailHint",
        "text": "Надіслати фоліо імейлом"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "folioRoomLabel",
        "text": "Кімната"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "folioTitle",
        "text": "Фоліо гостя"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "folioTotalChargesLabel",
        "text": "Загальні стягнення"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "guestLabel",
        "text": "Гість"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "helpViewFirstPoint",
        "text": "Просто тримайте ваш телефон навпроти замку."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "helpViewQuestionLabel",
        "text": "Як скористатись Мобільним Ключем"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "helpViewSecondPoint",
        "text": "Чекайте кліку від замку, що вказує на відкриття дверей"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "helpViewThirdPoint",
        "text": "Відкрийте ваші двері та насолоджуйтесь перебуванням."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "landingButtonText",
        "text": "Отримайте Мобільний Ключ"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "landingSubtitle",
        "text": "Новий спосіб доступу до кімнат"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "landingText",
        "text": "Наша нова фіча - Мобільний ключ - дозволяє вам використовувати ваш телефон, як ключ від кімнати.  Import your reservation and access your Mobile Key directly from your smartphone"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "landingTitle",
        "text": "Ласкаво просимо до Мобільного Ключа"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "lockOpeningViewDescription",
        "text": "Тримайте телефон коло\\nзамка, щоб відкрити двері"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "lockOpeningViewError",
        "text": "Щось не так, спробуйте ще. За допомогою зверніться до стійки реєстрації."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "lockOpeningViewHowToUseButton",
        "text": "Як користуватись мобільним ключем"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "lockOpeningViewSuccess",
        "text": "Успіх!\\nВаші двері відчинено."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "lockOpeningViewTimeRemaining",
        "text": "час, що залишається для сканування замку"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "lockscanningPausedButtonTitle",
        "text": "Продовжити сканування"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "lockscanningPausedTitle",
        "text": "Сканування замку призупинене"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "loginTitle",
        "text": "Логін"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "logOutCancel",
        "text": "Скасувати"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "logOutPrompt",
        "text": "Ви впевнені, що хочете вийти з акаунту?"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "logOutTitle",
        "text": "Вийти з акаунту"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "mobileKeyTitle",
        "text": "Мобільна вписка / Ключ"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "nightLabel",
        "text": "Ночей"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "noBluetoothViewDescription",
        "text": "Щоб відкрити двері телефоном, впевніться, що Bluetooth увімкнено"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "noBluetoothViewMain",
        "text": "Необхідний Bluetooth"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "noReservationButtonTitle",
        "text": "Імпортувати резервацію вручну"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "noReservationDescriptionTitle",
        "text": "Схоже, що у вас ще немає резервації.\\nУсі підтверджені резервації будуть показані тут.\\nСпробуйте ручний імпорт резервації."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "noReservationMainTitle",
        "text": "Резервацій не знайдено"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "refreshReservationActionButton",
        "text": "Оновити резервацію"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "registerTitle",
        "text": "Зареєструвати"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "registrationDescription",
        "text": "Створіть акаунт, щоб безпечно отримати ваш ключ"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "requestCheckInActionButton",
        "text": "Запитати вписку (чек-ін)"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "reservationDetailTitle",
        "text": "Моя резервація"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "reservationListFooterTitle",
        "text": "Не можете знайти резервацію? Спробуйте імпорт вручну"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "reservationListFooterTitleLink",
        "text": "Імпорт вручну"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "reservationListHeaderTitle",
        "text": "Оберіть вашу резервацію"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "reservationListSectionTitleNow",
        "text": "Поточна"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "reservationListSectionTitlePast",
        "text": "Минула"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "reservationListSectionTitleUpcoming",
        "text": "Майбутня"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "reservationListTitle",
        "text": "Резервації"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "reservationManualImportByPhoneChannelLabel",
        "text": "Підтвердіть тескстово чи дзвінком"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "reservationManualImportByPhoneHeaderTitle",
        "text": "Імпортуйте резервацію вручну"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "reservationManualImportByPhoneHelp",
        "text": "Будь ласка, додайте номер телефону та прізвище, вказане при бронюванні резервації. Ми підтвердимо ваш номер телефон чи подзвонивши, чи надіславши СМС повідомлення. Messaging and data rates may apply. "
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "reservationManualImportByPhoneSubmitButtonLabel",
        "text": "Продовжити"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "reservationManualImportChannelCall",
        "text": "Дзвінок"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "reservationManualImportChannelSms",
        "text": "Текст"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "reservationManualImportErrorNothingFound",
        "text": "Резервація не знайдена. Спробуйте ще"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "reservationManualImportErrorPhoneInvalid",
        "text": "Нажаль! Схоже, що номер, який ви надали, невалідний. Спробуйте ще."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "reservationManualImportErrorVerifyPhoneCodeInvalid",
        "text": "Нажаль! Код перевірки невірний."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "reservationManualImportHeaderTitle",
        "text": "Імпортувати резервацію вручну"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "reservationManualImportHelp",
        "text": "Зверніться до стійки реєстрації, якщо ви не можете знайти інвайт код, відправлений на ваш імейл."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "reservationManualImportInviteCodeHint",
        "text": "Інвайт код"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "reservationManualImportInviteCodeLabel",
        "text": "Введіть ваш номер запрошення до готелю"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "reservationManualImportLandingByCode",
        "text": "Імпортувати по інвайт коду"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "reservationManualImportLandingByPhone",
        "text": "Імпортувати за номером телефону"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "reservationManualImportLandingHeaderTitle",
        "text": "Вручну імпортувати вашу резервацію"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "reservationManualImportLandingHelp",
        "text": "Будь ласка, імпортуйте вашу резервацію по інвайт коду чи телефонному номеру."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "reservationManualImportLastNameHint",
        "text": "Прізвище"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "reservationManualImportLastNameLabel",
        "text": "Введіть прізвище з резервації"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "reservationManualImportPhoneHint",
        "text": "\"+1 (123) 456-7890\""
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "reservationManualImportPhoneLabel",
        "text": "Телефонний номер для резервації"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "reservationManualImportSubmitButtonLabel",
        "text": "Імпортувати зараз"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "reservationManualImportTitle",
        "text": "Імпортувати резервацію"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "reservationManualImportVerifyCodeHint",
        "text": "AABB1122"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "reservationManualImportVerifyCodeLabel",
        "text": "Перевірочний код"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "reservationManualImportVerifyPhoneHeaderTitle",
        "text": "Підтвердіть номер телефону"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "reservationManualImportVerifyPhoneHelp",
        "text": "Будь ласка, введіть наданий код верифікації. Не отримали код? #Спробуйте ще#"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "reservationManualImportVerifyPhoneSubmitButtonLabel",
        "text": "Перевірте"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "reviewFolioActionButton",
        "text": "Готові до виписки?"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "roomLabel",
        "text": "Кімната"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "stateButtonCheckedIn",
        "text": "Вписано"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "stateButtonCheckedOut",
        "text": "Виписано"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "stateButtonCheckIn",
        "text": "Вписка"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "stateButtonComingUp",
        "text": "Майбутня"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "stateButtonMobileKey",
        "text": "Мобільний Ключ"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "stateButtonUpcoming",
        "text": "Майбутня"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "statusCheckedIn",
        "text": "Вписана"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "statusCheckedOut",
        "text": "Виписана"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "statusCheckInFailed",
        "text": "Вписка невдала"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "statusCheckInRequested",
        "text": "Вписка запитана"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "statusCheckOutFailed",
        "text": "Виписка невдала"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "statusCheckOutRequested",
        "text": "Виписка в процесі"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "statusNoStatusAvailable",
        "text": "Статус недоступний"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "statusNoStatusAvalaible",
        "text": "Статус недоступний"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "statusNotCheckedIn",
        "text": "Не вписано"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "stayLabel",
        "text": "Перебування"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "successKeyActivationDescription",
        "text": "Ваш мобільний ключ був активований"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "successKeyActivationTitle",
        "text": "Успішно!"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "thankYouMessage",
        "text": "Спасибі, що були з нами!"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "tosLabel",
        "text": "Вписуючись, ви приймаєте наші [Умови перебування]"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "tryAgainActionButton",
        "text": "Спробуйте ще"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "checkintest",
        "text": "Test Ice:Description for check-in "
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "deeplinkAuthenticationFailed",
        "text": "This reservation was canceled or doesn't exist anymore!"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "errorEnableLocationButtonTitle",
        "text": "Turn On"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "errorEnableLocationDescription",
        "text": "Turn on location services to access your mobile key. For security purpose, mobile key can only be activated while on hotel property. Test!!"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "errorEnableLocationDismissTitle",
        "text": "Not Now"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "errorEnableLocationTitle",
        "text": "We need your location activate your mobile key. Test!!"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "errorOutsideOfPropertyButtonTitle",
        "text": "OK"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "errorOutsideOfPropertyDescription",
        "text": "We are working on getting things ready for you. You'll be able to access your mobile key once you're on hotel property. test text!"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "errorOutsideOfPropertyTitle",
        "text": "It looks like you are not on property!! Test Text!"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "expeditedCheckInDescription",
        "text": "This is a request, the front desk will check you in, you’ll be able to then get a mobile key, check back soon"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "keyActivated",
        "text": "Your mobile key has been activated"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "lockOpeningViewRoom",
        "text": "ROOM"
        }
        ]
        },
        {
        "groupName": "myAway",
        "nodes": [
        {
        "size": "50",
        "subGroup": "",
        "name": "codeFieldBlankError",
        "text": "Код не має бути порожнім"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "codeFieldLabel",
        "text": "Паскод"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "codeInstructionsLabel",
        "text": "Щоб увімкнути AirPlay, оберіть ваш паскод, обравши \"myAway\" на екрані ТВ. Введіть паскод у поле нижче."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "codeNoBoxesError",
        "text": "Код невірний"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "connectButtonLabel",
        "text": "З'єднати"
        },
        {
        "size": "0",
        "subGroup": "",
        "name": "connectedSuccessLabel",
        "text": "Ваш девайс готовий до AirPlay з вашим ТВ"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "connectingStatusLabel",
        "text": "З'єднуюсь..."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "disconnectButtonLabel",
        "text": "Від'єднати"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "networkInstructionsLabel",
        "text": "Ваш девайс не в мережі Wi-Fi. Перевірте ваші мережеві налаштування та спробуйте ще."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "selectTVInstructionsLabel",
        "text": "Оберіть ТВ до якого ви хочете під'єднатись через AirPlay"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "tvSelectLabel",
        "text": "Вибір ТВ"
        }
        ]
        },
        {
        "groupName": "navigation",
        "nodes": [
        {
        "size": "50",
        "subGroup": "",
        "name": "dashboardLabel",
        "text": "Дашборд"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "destinationsLabel",
        "text": "Призначення"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "parentLabel",
        "text": "Призначення"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "returnLabel",
        "text": "Повернутись до"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "servicesLabel",
        "text": "Послуги"
        }
        ]
        },
        {
        "groupName": "notifications",
        "nodes": [
        {
        "size": "0",
        "subGroup": "",
        "name": "appUseReminderText",
        "text": "Цей застосунок може бути використаний протягом вашого перебування, щоб покращити ваш гостьовий досвід 0_о."
        }
        ]
        },
        {
        "groupName": "pin",
        "nodes": [
        {
        "size": "50",
        "subGroup": "",
        "name": "headerLabel",
        "text": "Пін код"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "hintLabel",
        "text": "Введіть пін код"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "submitLabel",
        "text": "Надіслати"
        }
        ]
        },
        {
        "groupName": "postcard",
        "nodes": [
        {
        "size": "255",
        "subGroup": "",
        "name": "confirmation",
        "text": "Дякуємо. Ваша листівка надіслана."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "fromLabel",
        "text": "Від"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "messageHint",
        "text": "Напишіть повідомлення"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "messageLabel",
        "text": "Повідомлення"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "mobileTitle",
        "text": "Поштова карта"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "photoLabel",
        "text": "Фото"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "recipientEmailLabel",
        "text": "Імейл отримувача"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "retrievalError",
        "text": "Виникла проблема при отриманні доступних поштових карток. Зверніться до стійки реєстрації."
        },
        {
        "size": "80",
        "subGroup": "",
        "name": "subject",
        "text": "Four Seasons Resort Orlando Post Card"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "submissionError",
        "text": "Виникла проблема при надсиланні поштової картки. Зверніться до стійки реєстрації."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "submitLabel",
        "text": "Надіслати"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "title",
        "text": "Створити персоналізовану поштову картку"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "toLabel",
        "text": "До"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "userEmailLabel",
        "text": "Ваш імейл"
        }
        ]
        },
        {
        "groupName": "premium",
        "nodes": [
        {
        "size": "255",
        "subGroup": "",
        "name": "descriptionText",
        "text": "Ви можете отримати доступ до преміального контенту придбавши тимчасовий доступ. Сплачуючи за це покращення, ви отримуєте доступ до всього преміального контенту."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "payLabel",
        "text": "Покращення"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "roomNumberConfirmText",
        "text": "Будь ласка, введіть номер кімнати для підтвердження"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "roomNumberHint",
        "text": "Введіть номер кімнати"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "titleText",
        "text": "Покращення до преміуму"
        }
        ]
        },
        {
        "groupName": "printer",
        "nodes": [
        {
        "size": "255",
        "subGroup": "",
        "name": "printerOnErrorLocatingPrinters",
        "text": "There was a problem finding printers."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "printerOnErrorLocationServices",
        "text": "Please enable location services in settings to find nearby printers."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "printerOnPrintButtonLabel",
        "text": "Print"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "printerOnPrinterErrorText",
        "text": "There was a problem printing your page. Please contact support."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "printerOnPrintersTitleLabel",
        "text": "PrinterOn Printers"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "printerOnPrintJobQueuedText",
        "text": "Your print job has been successfuly sent."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "printerOnUserEmailHint",
        "text": "Please enter a valid email address."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "printerOnUserEmailInvalidText",
        "text": "Please enter a valid email address."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "printerOnUserEmailLabel",
        "text": "User email:"
        }
        ]
        },
        {
        "groupName": "profile",
        "nodes": [
        {
        "size": "50",
        "subGroup": "",
        "name": "accountSettingsLabel",
        "text": "Акаунт та налаштування"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "folioExpressCheckoutLabel",
        "text": "Експрес виписка"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "folioLabel",
        "text": "Фоліо"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "folioTotalLabel",
        "text": "Всього"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "languagesLabel",
        "text": "Мови"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "logIn",
        "text": "Увійти до акаунту"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "logOut",
        "text": "Вийти з акаунту"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "messagesLabel",
        "text": "Повідомлення"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "noMessagesLabel",
        "text": "Немає повідомлень"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "offerMessageTitle",
        "text": "Ви отримали нове повідомлення"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "requestsLabel",
        "text": "Ріквести/запити"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "settingsLabel",
        "text": "Налаштування"
        }
        ]
        },
        {
        "groupName": "request",
        "nodes": [
        {
        "size": "50",
        "subGroup": "",
        "name": "accessCodeHeaderLabel",
        "text": "Код доступу "
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "accessCodeHintLabel",
        "text": "Введіть код доступу"
        },
        {
        "size": "0",
        "subGroup": "",
        "name": "BlankLocationAlert",
        "text": "Це порожня локація "
        },
        {
        "size": "0",
        "subGroup": "",
        "name": "BlankphNoAlert",
        "text": "Порожній телефонний номер"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "commentCardConfirmationSubtitle",
        "text": "Ваш відгук безцінний для нас."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "commentCardConfirmationTitle",
        "text": "Дякуємо за заповнення картки відгуку!"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "commentHeaderLabel",
        "text": "Деталі вашого запиту"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "commentHintLabel",
        "text": "Додати коментар"
        },
        {
        "size": "0",
        "subGroup": "",
        "name": "confirmBtn",
        "text": "Підтвердити"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "confirmLabel",
        "text": "Ok"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "contactHeaderLabel",
        "text": "Телефонний номер"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "contactHintLabel",
        "text": "напр. +1 416 555 0165"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "dateHeaderLabel",
        "text": "Дата"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "doneLabel",
        "text": "Готово"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "errorText",
        "text": "Неможливо отримати запит. Спробуйте ще."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "fromHeaderAutomobileLabel",
        "text": "Адреса посадки"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "fromHeaderLabel",
        "text": "Від"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "fromHeaderRailwayLabel",
        "text": "Місто відправлення"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "fromHintLabel",
        "text": "Введіть походження"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "genericConfirmationSubtitleText",
        "text": "Ваш запит надіслано."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "genericConfirmationTitleText",
        "text": "Дякуємо"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "guestArrivalDateHeaderLabel",
        "text": "Дата прибуття"
        },
        {
        "size": "0",
        "subGroup": "",
        "name": "guestDateHeaderLabel",
        "text": "ДАТА ПОСАДКИ"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "guestEmailHeaderLabel",
        "text": "ІМЕЙЛ"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "guestEmailHintLabel",
        "text": "введіть ваш імейл"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "guestFullNameHeaderLabel",
        "text": "Повне ім'я"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "guestFullNameHintLabel",
        "text": "Введіть ваше повне ім'я"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "guestLastNameHeaderLabel",
        "text": "Прізвище"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "guestLastNameHintLabel",
        "text": "Введіть ваше прізвище"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "guestRoomNumberHeaderLabel",
        "text": "Номер кімнати"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "guestRoomNumberHintLabel",
        "text": "Номер кімнати"
        },
        {
        "size": "0",
        "subGroup": "",
        "name": "guestTimeHeaderLabel",
        "text": "ЧАС ПОСАДКИ"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "hintForTicketNumber",
        "text": "Введіть номер квитка"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "labelForTicketNumber",
        "text": "Номер квитка"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "optionsHeaderConciergeLabel",
        "text": "Тип запиту"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "optionsHeaderEngineeringLabel",
        "text": "Об'єкти сервісу"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "optionsHeaderLabel",
        "text": "Опції"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "optionsHeaderWakeupCallLabel",
        "text": "Час затримки"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "optionsHintLabel",
        "text": "Оберіть опцію"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "personsHeaderLabel",
        "text": "Число людей"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "personsHintLabel",
        "text": "Введіть кількість людей"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "phoneNumberHeaderLabel",
        "text": "Номер телефону"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "phoneNumberHintLabel",
        "text": "напр. +1 416 555 0165"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "requestConfirmationDoneLabel",
        "text": "Готово"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "smsHeaderLabel",
        "text": "НОМЕР ТЕЛЕФОНУ ДЛЯ СМС"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "smsHintLabel",
        "text": "введіть номер телефону"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "smsProviderHeaderLabel",
        "text": "СМС провайдер"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "smsProviderHintLabel",
        "text": "Оберіть провайдера"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "snoozeMinutesFifteen",
        "text": "15 хвилин"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "snoozeMinutesFive",
        "text": "5 хвилин"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "snoozeMinutesTen",
        "text": "10 хвилин"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "snoozeNone",
        "text": "не відкладати"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "submitLabel",
        "text": "Надіслати"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "ticketNumberHeaderLabel",
        "text": "Номер квитка"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "ticketNumberHintLabel",
        "text": "Введіть номер квитка"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "timeHeaderLabel",
        "text": "Час"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "timePickerDoneLabel",
        "text": "Готово"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "timePickerHourLabel",
        "text": "Годин"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "timePickerMeridiemLabel",
        "text": "am/pm"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "timePickerMinuteLabel",
        "text": "Хвилин"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "timeUpdatedText",
        "text": "Ваш час був відкорегований до найближчого доступного часу."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "toHeaderAutomobileLabel",
        "text": "Призначення"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "toHeaderLabel",
        "text": "До"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "toHeaderRailwayLabel",
        "text": "Місто прибуття"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "toHintLabel",
        "text": "Введіть призначення"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "unableToSubmitConfirm",
        "text": "Okay"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "unableToSubmitLabel",
        "text": "Запит недоступний"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "unableToSubmitMessage",
        "text": "Запити не можуть бути прийняті в цей час. Зверніться до стійки реєстрації."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "validationInvalidLabel",
        "text": "Неправильне"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "validationRequiredLabel",
        "text": "*Необхідне "
        }
        ]
        },
        {
        "groupName": "roomkey",
        "nodes": [
        {
        "size": "255",
        "subGroup": "",
        "name": "confirmationDescriptionText",
        "text": "Щоб завершити підписку на мобільний ключ, будь ласка, введіть код, отриманий в текстовому повідомленні."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "confirmLabel",
        "text": "Підтвердити"
        },
        {
        "size": "10",
        "subGroup": "",
        "name": "countryCodeHeaderLabel",
        "text": "Код"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "emailHeaderLabel",
        "text": "Імейл"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "errorAlreadyRegistered",
        "text": "Ви вже зареєстровані, ви отримаєте імейл для розблокування вашої підписки. "
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "errorAuthenticating",
        "text": "Ваш токен застарів. Розреєструйте цей девайс та зареєструйтесь заново."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "errorGenericError",
        "text": "Виникла проблема при обробці запиту. Спробуйте пізніше чи зверніться до стійки реєстрації по допомогу."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "errorInvalidPassword",
        "text": "Код мобільного ключа, який ви надали, невірний. "
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "errorNoRoom",
        "text": "Вам не призначили кімнату."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "errorOpenDoorGeneric",
        "text": "Виникла проблема при спробі відкрити ваші двері. Спробуйте пізніше чи зв'яжіться зі стійкою реєстрації за допомогою."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "guestServicesLabel",
        "text": "Послуги для гостей"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "instructions",
        "text": "Тримайте телефон коло замка"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "keyHeaderLabel",
        "text": "Мобільний ключ"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "phoneNumberHeaderLabel",
        "text": "Номер телефону"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "submitLabel",
        "text": "Надіслати"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "subscriptionDescriptionText",
        "text": "Ласкаво просимо. Заповніть наступну форму щоб підписатись на сервіс розумного мобільного ключа."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "titleLabel",
        "text": "Ключ від кімнати"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "unlockLabel",
        "text": "Натисніть, щоб відкрити кімнату"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "unregisterLabel",
        "text": "Розреєструвати девайс"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "validationInvalidLabel",
        "text": "*невірно"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "validationRequiredLabel",
        "text": "*Необхідне"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "welcomeLabel",
        "text": "Ви в кімнаті"
        }
        ]
        },
        {
        "groupName": "settings",
        "nodes": [
        {
        "size": "5",
        "subGroup": "",
        "name": "distanceKilometersLabel",
        "text": "km"
        },
        {
        "size": "5",
        "subGroup": "",
        "name": "distanceMilesLabel",
        "text": "mi"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "distanceUnitsLabel",
        "text": "Відстань"
        },
        {
        "size": "5",
        "subGroup": "",
        "name": "temperatureCelsiusLabel",
        "text": "ºC"
        },
        {
        "size": "5",
        "subGroup": "",
        "name": "temperatureFahrenheitLabel",
        "text": "ºF"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "temperatureLabel",
        "text": "Температура"
        },
        {
        "size": "5",
        "subGroup": "",
        "name": "time12HourLabel",
        "text": "12"
        },
        {
        "size": "5",
        "subGroup": "",
        "name": "time24HourLabel",
        "text": "24"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "timeLabel",
        "text": "Час"
        }
        ]
        },
        {
        "groupName": "share",
        "nodes": [
        {
        "size": "50",
        "subGroup": "",
        "name": "commentHintLabel",
        "text": "Додайте коментар"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "commentLabel",
        "text": "Коментар"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "emailAddressHintLabel",
        "text": "Введіть адресу імейлу"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "emailAddressLabel",
        "text": "Адреса імейлу"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "sendLabel",
        "text": "Надіслати"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "validationInvalidLabel",
        "text": "Неправильно"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "validationRequiredLabel",
        "text": "*Необхідне"
        }
        ]
        },
        {
        "groupName": "stores",
        "nodes": [
        {
        "size": "50",
        "subGroup": "",
        "name": "addedItemText",
        "text": "Ми додали це до вашого замовлення"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "addedItemTextDescription",
        "text": "Ви можете відредагувати ваше замовлення чи надіслати його натиснувши на \"Переглянути замовлення\" нижче"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "addItemLabel",
        "text": "Додати"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "alternateLocation",
        "text": "Номер локації вашого стільця(?)!!!!!!"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "availabilityAdjustedText",
        "text": "Ваш час був недоступний. Його підкорегували. Перегляньте, чи новий час вам відходить."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "availabilityText",
        "text": "Обраний час недоступний. Перегляньте на оберіть новий час."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "caloriesLabel",
        "text": "Калорії"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "cancelLabel",
        "text": "Повернутись"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "cancellationPolicyLabel",
        "text": "Політика скасування"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "carbsLabel",
        "text": "Carbs"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "cartItemsLabel",
        "text": "РОЗМІСТИТИ ЗАМОВЛЕННЯ"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "cartMyOrderLabel",
        "text": "Моє замовлення"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "cartTitleLabel",
        "text": "Ваше замовлення"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "changeDeliveryAlertLabel",
        "text": "Хочете змінити опцію доставки?"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "changeDeliveryLabel",
        "text": "Змінити опцію доставки"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "ChargeToRoom",
        "text": "На рахунок кімнати"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "clearCartConfirmationText",
        "text": "Your order has not been submitted at this time since you really can't tell what is going on and you want to exit the store.  Are you sure you want to exit the cart?  Please touch \"Return\" and select \"Place order\" to complete. Then go and tell your buddy. 123"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "clearOrderLabel",
        "text": "Спорожнити корзину"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "continueLabel",
        "text": "Продовжити"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "continueShoppingLabel",
        "text": "Продовжити покупки "
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "customConfirmation",
        "text": "Дякуємо. Ваше замовлення буде доставлено."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "dateHeaderLabel",
        "text": "Дата"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "deliveryMethod",
        "text": "Метод доставки"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "deliveryMethodOptionContactless",
        "text": "Безконтактно залишити"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "deliveryMethodOptionPersonal",
        "text": "Особисто"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "deliveryOptionPickupOrderDetail",
        "text": "Заберіть ваше замовлення беспосередньо з ресторану чи спеціальних локацій видачі."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "deliveryOptionPickupOrderId",
        "text": "pickuporder"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "deliveryOptionPickupOrderLabel",
        "text": "Забрати замовлення"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "deliveryOptionTitleReadOnlyLabel",
        "text": "*Ви будете сповіщені, коли ресторан прийме замовлення, приблизний час, за який ваше замовлення підготують, та коли замовлення буде готове до видачі."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "diningConfirmation",
        "text": "Дякуємо. Ваше обіднє замовлення було отримане."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "dismissLabel",
        "text": "Скинути"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "doneLabel",
        "text": "Готово"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "editOrderLabel",
        "text": "Редагувати замовлення"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "emptyOrderText",
        "text": "Ваш кошик порожній. Позації не додані до чекауту"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "eSignatureLabel",
        "text": "Відмітьте чекбокс для надання Е-підпису до вашого замовлення"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "fatLabel",
        "text": "Жири"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "genderFemaleLabel",
        "text": "Жіноча"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "genderLabel",
        "text": "Стать масажиста"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "genderMaleLabel",
        "text": "Чоловіча"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "genderNoPreferenceLabel",
        "text": "Без різниці"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "gratuityLabel",
        "text": "Чайові"
        },
        {
        "size": "500",
        "subGroup": "",
        "name": "hotelInstructionsText",
        "text": "Будь ласка, зверніть увагу, що для того, щоб слідувати заходам для стримання COVID та захисту наших гостей, наш персонал доставить замовлення до ваших дверей. Будь-які речі будуть залишені коло ваших дверей. Дякуємо."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "invalidLabel",
        "text": "*невірно"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "itemAddedToOrderNotifcationMessageLabel",
        "text": "Продовжіть покупки чи перегляньте ваше замовлення в кошику."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "itemAddedToOrderNotifcationTitleLabel",
        "text": "Товари, додані до замовлення"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "itemUnavailableText",
        "text": "Цей товар недоступний у обраний час. Завершіть ваше замовлення, чи спорожніть кошик."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "laundryValetConfirmation",
        "text": "Дякуємо. Ваше прання буде забране."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "menuUnavailableText",
        "text": "Меню доступні, виходячи з часу замовлення. Завершіть ваше замовлення, чи спорожніть кошик."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "noAvailabilityText",
        "text": "Ваш час недоступний. Інший час теж недоступний"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "orderDeliveryLabel",
        "text": "Доставити"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "orderLabel",
        "text": "Розмістити замовлення"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "paymentOptions",
        "text": "ОПЦІЇ ОПЛАТИ"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "payOnPickUp",
        "text": "Оплата при отриманні"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "phoneNumberHeaderLabel",
        "text": "Телефонний номер"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "phoneNumberHintLabel",
        "text": "напр. +1 416 555 0165 123456"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "pickText",
        "text": "Обрати"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "quantityLabel",
        "text": "Кількість"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "removeItemLabel",
        "text": "Прибрати"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "requestItemConfirmation",
        "text": "Дякуємо, ваш запит надіслано."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "requiredLabel",
        "text": "*Необхідне"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "reservationEmailHeaderLabel",
        "text": "Імейл з резервації"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "reservationNameHeaderLabel",
        "text": "Ім'я з резервації"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "selectDateTimeText",
        "text": "Будь ласка, оберіть дату та час вашого замовлення."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "servesLabel",
        "text": "Число гостей"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "serviceFeeLabel",
        "text": "Плата за послугу"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "smsHeaderLabel",
        "text": "Номер для СМС"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "smsHintLabel",
        "text": "напр. +1 416 555 0165"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "smsProviderHeaderLabel",
        "text": "СМС провайдер"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "smsProviderHintLabel",
        "text": "Оберіть провайдера"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "spaConfirmation",
        "text": "Дякуємо. Спа зв'яжеться з вами для уточнення вашого замовлення."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "spaConfirmationTimeShifted",
        "text": "Ваша спа резервація була зміщена на наступний доступний час: "
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "specialInstructionsLabel",
        "text": "Спеціальні інструкції"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "submitOrderLabel",
        "text": "Надіслати"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "taxLabel",
        "text": "Податок"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "timeHeaderLabel",
        "text": "Час"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "totalLabel",
        "text": "Всього"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "upgradeItemNoneText",
        "text": "Нічого"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "upgradeLabel",
        "text": "Покращення"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "upsellDoneLabel",
        "text": "Ні, дякую"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "upsellText",
        "text": "Хочете додати щось з цього до вашого замовлення?"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "viewOrderLabel",
        "text": "Переглянути замовлення (Test)"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "viewTermsLabel",
        "text": "Переглянути умови та правила"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "warningFutureDateDescriptionLabel",
        "text": "Зауважте: ви можете відредагувати ваше замовлення у будь-який час перед відправкою замовлення."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "warningFutureDateTitleLabel",
        "text": "Ви обрали майбутню дату доставки. Натисніть \"Продовжити\" щоб додати це замовлення до кошику."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "zeroLabel",
        "text": "Безкоштовно"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "errorOrderFailed",
        "text": "An error occurred while processing your order. Please try again."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "stores.deliveryMethod",
        "text": "Delivery method"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "stores.deliveryMethodOptionContactless",
        "text": "Contactless drop off Test Galyna"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "stores.deliveryMethodOptionPersonal",
        "text": "In person Test GAlyna"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "stores.hotelInstructionsText",
        "text": "Please note that in order comply with our COVID response measures and protect our guests, our staff will deliver your item(s) to your door. Any items that need to be picked up should be left at your door. Thank you."
        }
        ]
        },
        {
        "groupName": "announcements",
        "nodes": [
        {
        "size": "50",
        "subGroup": "",
        "name": "moreLabel",
        "text": "About"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "AlarmUnsetLabel",
        "text": "Set Alarm"
        }
        ]
        },
        {
        "groupName": "commentcard",
        "nodes": [
        {
        "size": "255",
        "subGroup": "",
        "name": "answerRequiredText",
        "text": "*at least one answer is required"
        },
        {
        "size": "100",
        "subGroup": "",
        "name": "errorMessage",
        "text": "Something went wrong, please try again."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "submitLabel",
        "text": "SUBMIT"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "commentCardConfirmationTitle",
        "text": "Thank you for filling out our comment card!"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "commentHeaderLabel",
        "text": "Details of your request"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "commentHintLabel",
        "text": "Add a comment"
        }
        ]
        },
        {
        "groupName": "creditCardInput",
        "nodes": [
        {
        "size": "50",
        "subGroup": "",
        "name": "creditCardAttached",
        "text": "Set"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "creditCardIsNeededToast",
        "text": "Credit card is needed"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "creditCardNotAttached",
        "text": "Not set"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "useCreditCardButtonLabel",
        "text": "Use card XXXX-"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "creditCardRequirementLabel",
        "text": "Credit card on file"
        }
        ]
        },
        {
        "groupName": "currency",
        "nodes": [
        {
        "size": "50",
        "subGroup": "",
        "name": "complimentaryItemLabel",
        "text": "Complimentary"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "freeLabel",
        "text": "Complimentary"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "zeroLabel",
        "text": "Complimentary"
        }
        ]
        },
        {
        "groupName": "dailyevents",
        "nodes": [
        {
        "size": "50",
        "subGroup": "",
        "name": "companyLabel",
        "text": "Company"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "dateLabel",
        "text": "Date"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "doneLabel",
        "text": "Done"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "eventsLabel",
        "text": "Events"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "floorPlansLabel",
        "text": "Floor plans"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "noEventsMsg",
        "text": "No events scheduled for today......"
        }
        ]
        },
        {
        "groupName": "dashboard",
        "nodes": [
        {
        "size": "50",
        "subGroup": "",
        "name": "alarm12HourLabel",
        "text": "12 hour"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "alarm1Label",
        "text": "Alarm 2"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "alarm24hourLabel",
        "text": "24 hour"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "alarm2Label",
        "text": "Alarm Two"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "alarmAmbientLabel",
        "text": "Ambient"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "alarmBirdsLabel",
        "text": "Birds"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "alarmChillLabel",
        "text": "Chill"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "alarmClearLabel",
        "text": "Clear"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "alarmConfirmationLabel",
        "text": "Set"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "alarmDateUnavailableText",
        "text": "There is already an alarm set for this time."
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "alarmDigitalLabel",
        "text": "Digital"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "alarmDrumsLabel",
        "text": "Drums"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "alarmGuitarLabel",
        "text": "Guitar"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "alarmOceanLabel",
        "text": "Ocean"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "alarmPianoLabel",
        "text": "Piano"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "alarmRedAlertLabel",
        "text": "Red Alert"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "alarmSnoozeDurationLabel",
        "text": "9 minutes"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "alarmSnoozeLabel",
        "text": "Snooze"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "alarmStopLabel",
        "text": "Stop"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "alarmTranceLabel",
        "text": "Trance"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "alarmUnsetLabel",
        "text": "Set alarm"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "confirmLabel",
        "text": "Ok"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "dashboardGreeting",
        "text": "Welcome all"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "dashboardMinutesLabel",
        "text": "Minutes"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "diningServiceQuickAccess",
        "text": "Dining Service"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "mainMenu",
        "text": "Main Menu"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "radioGenreLabel",
        "text": "Genre"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "radioLabel",
        "text": "Radio"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "radioLocationLabel",
        "text": "Location"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "radioSleepTimerLabel",
        "text": "Sleep timer (minutes)"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "radioSleepTimerOffLabel",
        "text": "Off"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "radioUnsetFilterLabel",
        "text": "Genre"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "radioUnsetStationLabel",
        "text": "Select a station"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "radioVolumeLabel",
        "text": "Volume"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "roomControlsLabel",
        "text": "Room Controls"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "roomControlsNoDataText",
        "text": "No Data Available"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "roomControlsNoRoomText",
        "text": "No room is configured for this device"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "roomLabel",
        "text": "ROOM:"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "settingsDoneLabel",
        "text": "Done"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "userUnavailableText",
        "text": "User is unavailable"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "weatherCurrentLabel",
        "text": "Current"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "weatherLabel",
        "text": "Weather"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "weatherNoDataText",
        "text": "No data available"
        }
        ]
        },
        {
        "groupName": "dateTimeFormat",
        "nodes": [
        {
        "size": "50",
        "subGroup": "",
        "name": "timeFormat12",
        "text": "h:mm a"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "timeFormat24",
        "text": "H:mm"
        }
        ]
        },
        {
        "groupName": "digitalkey",
        "nodes": [
        {
        "size": "100",
        "subGroup": "breadcrumbs",
        "name": "activateKey",
        "text": "Activate Key"
        },
        {
        "size": "100",
        "subGroup": "breadcrumbs",
        "name": "importReservation",
        "text": "Import Reservation"
        },
        {
        "size": "100",
        "subGroup": "breadcrumbs",
        "name": "registerText",
        "text": "Register"
        },
        {
        "size": "200",
        "subGroup": "lockOpeningScreen",
        "name": "descriptionText",
        "text": "Hold Your Phone To The Lock To Open Door"
        },
        {
        "size": "100",
        "subGroup": "lockOpeningScreen",
        "name": "doorOpenSuccessText",
        "text": "Success! Your Door Is Unlocked."
        },
        {
        "size": "100",
        "subGroup": "lockOpeningScreen",
        "name": "errorText",
        "text": "Something's not right, please try again. For help, contact the front desk"
        },
        {
        "size": "100",
        "subGroup": "lockOpeningScreen",
        "name": "howtoText",
        "text": "How to use your digital key"
        },
        {
        "size": "100",
        "subGroup": "lockOpeningScreen",
        "name": "roomText",
        "text": "ROOM"
        },
        {
        "size": "100",
        "subGroup": "termsAndConditions",
        "name": "linkPattern",
        "text": "terms and conditions"
        },
        {
        "size": "100",
        "subGroup": "termsAndConditions",
        "name": "secondSubtitle",
        "text": "A new way to unlock your stay"
        },
        {
        "size": "1000",
        "subGroup": "termsAndConditions",
        "name": "termsExternalLink",
        "text": "https://static.keypr.com/whitelabels/default/tos.html"
        },
        {
        "size": "100",
        "subGroup": "termsAndConditions",
        "name": "termsLabel",
        "text": "By activating this feature, you agree to accept the Terms and Conditions for use of this application"
        }
        ]
        },
        {
        "groupName": "infopage",
        "nodes": [
        {
        "size": "255",
        "subGroup": "",
        "name": "noDataText",
        "text": "No data available"
        }
        ]
        },
        {
        "groupName": "requestHistory",
        "nodes": [
        {
        "size": "50",
        "subGroup": "",
        "name": "statusAccepted",
        "text": "Accepted"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "statusComplete",
        "text": "Complete"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "statusNew",
        "text": "New"
        },
        {
        "size": "50",
        "subGroup": "",
        "name": "statusQueued",
        "text": "Queued"
        }
        ]
        },
        {
        "groupName": "roomControls",
        "nodes": [
        {
        "size": "50",
        "subGroup": "",
        "name": "connectionLost",
        "text": "Connection to Rooms Control Server Lost, Attempting to Reconnect."
        }
        ]
        },
        {
        "groupName": "video",
        "nodes": [
        {
        "size": "50",
        "subGroup": "",
        "name": "confirmLabel",
        "text": "Ok"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "noSupportText",
        "text": "Sorry, this video cannot be played."
        }
        ]
        },
        {
        "groupName": "welcomeLabel",
        "nodes": [
        {
        "size": "50",
        "subGroup": "welcome",
        "name": "welcomeLabel",
        "text": "Hello Test QA123"
        }
        ]
        },
        {
        "groupName": "confirmCheckInDialog",
        "nodes": [
        {
        "size": "255",
        "subGroup": "",
        "name": "confirmButtonText",
        "text": "Підтвердити"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "idNumberFieldLabel",
        "text": "Номер ІД: "
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "nameFieldLabel",
        "text": "Ім'я: "
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "nationalityFieldLabel",
        "text": "Національність: "
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "nationalityUnknownAltText",
        "text": "Невідомо"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "notCorrectText",
        "text": "Інформація не вірна? Зверніться до стійки реєстрації."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "subTitle",
        "text": "Перевірте вашу персональну інформацію, представлену нижче."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "title",
        "text": "Підтвердіть особистість для подальшої вписки"
        }
        ]
        },
        {
        "groupName": "healthviewConfiguration",
        "nodes": [
        {
        "size": "255",
        "subGroup": "",
        "name": "healthviewAcceptedLabel",
        "text": "Завершено"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "healthviewIsNeededToast",
        "text": "Вам потрібно переглянути та прийняти заяву про здоров'я перед впискою."
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "healthviewNot24HoursLabel",
        "text": "Доступно за 24hr до прибуття"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "healthviewNotAcceptedLabel",
        "text": "Не вдалось завершити"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "healthviewNotCompletedLabel",
        "text": "Натисніть для проходження"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "healthviewRequirementLabel",
        "text": "Заява про здоров'я"
        }
        ]
        },
        {
        "groupName": "onboarding",
        "nodes": [
        {
        "size": "255",
        "subGroup": "",
        "name": "onboardContinue",
        "text": "Продовжити"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "onboardHeader",
        "text": "Ваше перебування в \"Hotel Name\" очікує!"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "onboardSubTitle",
        "text": "Використовуючи додаток \"App Name\" для мобільної вписки займає всього 5 простих кроків!"
        },
        {
        "size": "255",
        "subGroup": "",
        "name": "onboardTermsAndCondition",
        "text": "Натискаючи продовжити ви погоджуєтесь з [Правилами, умовами та обробкою персональних даних]"
        }
        ]
        }
        ]*/
