import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import javax.swing.JTabbedPane

slide(
        id: 'ReleaseCycle',
        sub: 'Plattform',
        title: 'Griffon hat einen neuen Release-Zyklus'
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '30[center, grow, fill]30',
            rowConstraints: '[center, grow, fill]')
    widget(buildMVCGroup('agenda', null, [backgroundColor: color(0xDDFFFFFF), content: {
        panel(content) {
            label('Releases alle 3-4 Monate', cssClass: 'L1')
            label('V 0.9.5 am 5. April', cssClass: 'L2')
            label('V 0.9.6 geplant Mai 2012', cssClass: 'L2')
            label('V 1.0 geplant 2012', cssClass: 'L2')
            label('In Planung: Hotfix system', cssClass: 'L1')
        }
    }]).view.root)
}