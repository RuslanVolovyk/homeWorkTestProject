package data;

public enum NavigationLinksUrlsYandex {
    video("Яндекс.Видео"),
    images("Яндекс.Картинки"),
    news("Яндекс.Новости: Главные новости сегодня, самые свежие и последние новости России онлайн"),
    maps("Яндекс.Карты — поиск мест и адресов, городской транспорт"),
    market("Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов"),
    translate("Яндекс.Переводчик – словарь и онлайн перевод на английский, русский, немецкий, французский, украинский и другие языки."),
    music("Яндекс.Музыка — собираем музыку и подкасты для вас");

    private String title;

    NavigationLinksUrlsYandex(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
