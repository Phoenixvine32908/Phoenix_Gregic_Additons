# Whacky mod for fun GT Additions
# Seeks to add whacky and cool features to spicen up gameplay

Contributions are welcome here.

Most assets and code are licensed under LPGL 3.0 as I use code/assets from other wonderful creators

However for the code involving cleanroom and hpca componet parts, these are an exception as these are licensed under MIT

There is currently a bug if you decide to only use jei (Not present if you use emi or jei+emi). The recipes won't show up, *gasp*. To fix it all you need to do is pop the below example into your Kubejs/client_scripts folder.

```js title="manual_recipe_showing_fix.js"
JEIEvents.addItems(event => {
    event.add('phoenix_gregic_additons:active_phoenix_cooling_component')
    event.add('phoenix_gregic_additons:advanced_phoenix_computation_component')
    event.add('phoenix_gregic_additons:akashic_coil_block')
    event.add('phoenix_gregic_additons:akashic_zeronium_casing')
    event.add('phoenix_gregic_additons:blazing_cleaning_maintenance_hatch')
    event.add('phoenix_gregic_additons:blazing_filter_casing')
    event.add('phoenix_gregic_additons:high_yield_photon_emission_regulator')
    event.add('phoenix_gregic_additons:perfected_logic')
    event.add('phoenix_gregic_additons:phoenix_computation_component')
    event.add('phoenix_gregic_additons:phoenix_enriched_neutronium_casing')
    event.add('phoenix_gregic_additons:phoenix_heat_sink_component')
    event.add('phoenix_gregic_additons:reliable_naquadah_alloy_machine_casing')
    event.add('phoenix_gregic_additons:space_time_cooled_eternity_casing')
    event.add('phoenix_gregic_additons:true_phoenix_infused_casing')
    event.add('phoenix_gregic_additons:uhv_solar_panel')
    event.add('phoenix_gregic_additons:uev_solar_panel')
    event.add('phoenix_gregic_additons:uiv_solar_panel')
    event.add('phoenix_gregic_additons:uxv_solar_panel')
    event.add('phoenix_gregic_additons:opv_solar_panel')
    event.add('phoenix_gregic_additons:max_solar_panel')
})
```



## Credit
- Thanks to Ezlych of Sky Of Grind for providing the textures for the Phoenix HPCA Componets[Ezlych/RianGomita](https://github.com/RianGomita)
- Thanks to Shugabrush for providing the example jei fix. 
- Thanks to Sky of Grind for some textures/ideas[Sky of Grind Github](https://github.com/RianGomita/Sky-Of-Grind)
- Thanks to Ghostipedia for allowing me to use her UniqueWorkableElectricMultiblockMachine class[Ghosipedia](https://github.com/Ghostipedia)
- Thanks to CosmicCore for some of the textures[Cosmic Core Github](https://github.com/Frontiers-PackForge/CosmicCore)
- Thanks to NegaNote of Monifactory/Monilabs for allowing me to use her CreativeEnergyMultiblockMachine[NegaNote/](https://github.com/NegaNote)[MoniLabs Github](https://github.com/NegaNote/MoniLabs/blob/main/README.md)
- Thanks to NegaNote of Gtm Utils for code to learn from and use of the SterileCleaningMaintence Hatch texture [GTM Utils Github](https://github.com/NegaNote/GregTech-Modern-Utilities)
- Thans to Ravemaker, Ensign Evident, and Qwerty from the Sky of Grind/Phoenix Forge Technologies discord for advice
- Thanks to Monifactory for some of the textures [MoniFactory Github](https://github.com/ThePansmith/Monifactory)
- Thanks to the GregTech Modern team for use of code such as HPCAMachine and the HPCAComponet classes [GTM Github](https://github.com/GregTechCEu/GregTech-Modern)
- Thanks to Jurrejelle of the Gregtech Modern team for code help and advice(He's fixed a lot of bug's that impacted PFT and PhoenixCore devlopment so huge thanks)(https://github.com/jurrejelle)

