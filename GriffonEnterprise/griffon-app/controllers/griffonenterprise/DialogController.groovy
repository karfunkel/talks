package griffonenterprise

class DialogController {
    // these will be injected by Griffon
    DialogModel model
    DialogView view

    void mvcGroupInit(Map args) {
        MVCGroupConfiguration configuration = args.configuration
        model.icon = args.icon ?: configuration?.config.icon ?: 'default.png'
        model.author = args.author ?: configuration?.config.author
        model.date = args.date ?: configuration?.config.date
        model.format = args.format ?: configuration?.config.format
        model.text = args.text ?: configuration?.config.text
    }
}
