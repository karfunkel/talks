import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import javax.swing.JTabbedPane

slide(
        id: 'Logging',
        sub: 'Plattform',
        title: 'Kein Projekt ohne Logging'
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '30[center, grow, fill]30',
            rowConstraints: '[center, grow, fill]')
    widget(buildMVCGroup('agenda', null, [gap: 40, backgroundColor: color(0xDDFFFFFF), content: {
        panel(content) {
            label('SLF4J mit Logback', cssClass: 'L1')
            label('Buildtime logging', cssClass: 'L2')
            label('Runtime logging', cssClass: 'L2')
        }
    }]).view.root)
}