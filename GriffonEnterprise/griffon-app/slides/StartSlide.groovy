slide(id: 'Start', title: 'Start', sub: 'D') {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '30[center, grow, fill]30',
            rowConstraints: '[center, grow, fill]')
    panel() {
        migLayout(layoutConstraints: 'flowy', columnConstraints: '[]', rowConstraints: '[]')
        widget(buildMVCGroup('media', null, [
                author: 'Alexander Klein',
                date: new Date(),
                text: 'Organic umami 8-bit letterpress, next level mcsweeney\'s tattooed synth keytar. Bushwick banksy mcsweeney\'s, bicycle rights squid 3 wolf moon authentic tumblr sriracha irony ethical. Cardigan before they sold out hoodie, you probably haven\'t heard of them cray trust fund marfa squid vice. Mixtape brooklyn gastropub, next level jean shorts ethical thundercats mlkshk selvage raw denim before they sold out cray tumblr fanny pack vice. Tofu pickled next level art party +1, marfa tattooed messenger bag hella lomo bicycle rights authentic. Wayfarers VHS mcsweeney\'s iphone, tumblr trust fund gluten-free fingerstache pitchfork echo park lomo scenester viral tattooed. Ethnic salvia odd future post-ironic fixie williamsburg pop-up, fingerstache four loko trust fund wayfarers VHS vegan etsy.',
        ]).view.root)
        widget(buildMVCGroup('media', null, [
                icon: 'AlexanderKlein2.jpg',
                author: 'Alexander Klein',
                date: new Date(),
                format: 'yyyy-MM-dd',
                text: 'Yr +1 carles, ethical banksy 8-bit quinoa chillwave salvia sustainable godard tumblr aesthetic seitan leggings. Brooklyn VHS gastropub, keytar kale chips pork belly odd future. Portland four loko ennui, dreamcatcher viral photo booth tofu pour-over terry richardson beard synth. Godard sartorial iphone, thundercats brunch street art odd future williamsburg stumptown wayfarers bushwick before they sold out gastropub. Authentic echo park banh mi thundercats viral cred. DIY hoodie selvage photo booth tumblr. VHS kogi letterpress fanny pack.',
        ]).view.root)
        label('...', cssClass: 'H1', constraints: '')
    }
}
