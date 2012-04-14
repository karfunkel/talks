import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import javax.swing.JTabbedPane

slide(
        id: 'Dependency',
        sub: 'Architektur',
        title: 'Griffon nimmt Abhängigkeiten ernst',
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '30[center, grow, fill]30',
            rowConstraints: '[center, grow, fill]')
    widget( buildMVCGroup('agenda', null, [backgroundColor: color(0xDDFFFFFF), content: {
        panel(content) {
            label('Dependencymanagement über Ivy', cssClass: 'L1')
            label('Eigene Implementierung möglich', cssClass: 'L2')
            label('Pluginabhängigkeiten mit 0.9.5 überarbeitet', cssClass: 'L1')
            label('Mehrere DependencyInjection Möglichkeiten', cssClass: 'L1')
            label('Minimale Eigenimplementierung', cssClass: 'L2')
            label('Spring', cssClass: 'L2')
            label('Guice', cssClass: 'L2')
            label('Weld (CDI)', cssClass: 'L2')
        }
    }]).view.root)

}
