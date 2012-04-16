import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import javax.swing.JTabbedPane

slide(
        id: 'Archetypes',
        sub: 'Architektur',
        title: 'Archetypen sind Projekt-Templates'
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '30[center, grow, fill]30',
            rowConstraints: '[center, grow, fill]')
    widget(buildMVCGroup('agenda', null, [backgroundColor: color(0xDDFFFFFF), content: {
        panel(content) {
            label('Templates sind Vorlagen für Artefakte', cssClass: 'L1')
            label('Archetypes sind Vorlagen für Projekte', cssClass: 'L1')
            label('Können Templates, MVC-Groups, Skripte usw. enthalten', cssClass: 'L2')
            label('Können Plugins installieren', cssClass: 'L2')
            label('Können MVC-Gruppen erstellen', cssClass: 'L2')
            label('Ein Archetype ist eine ZIP-Datei mit Descriptor', cssClass: 'L2')
            label('Archetypen können wie Plugins verwaltet werden', cssClass: 'L2')
            label('griffon create-app --archetype <Archetype> <Projekt>', cssClass: 'L2')
        }
    }]).view.root)
}