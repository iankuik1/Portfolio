package com.example.musicstore.database;
import com.example.musicstore.R;
import com.example.musicstore.items.Electric;
import com.example.musicstore.items.Headphones;
import com.example.musicstore.items.Item;
import com.example.musicstore.items.Keyboard;
import com.example.musicstore.items.Grand;
import com.example.musicstore.items.Acoustic;
import com.example.musicstore.items.Monitors;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Contains my database. Implemented with singleton design pattern,
 * so only one instance can be created.
 */
public class Database implements Serializable {
    private static Database instance;
    private static ArrayList<Item> allItems;

    public Database() {
        allItems = new ArrayList<Item>();
        populateDatabase();

    }

    public static Database getInstance() {
        if(instance == null) {
            synchronized (Database.class) {
                if(instance == null) {
                    instance = new Database();
                }
            }
        }
        return instance;
    }

    /**
     * Populates the database on app launch
     */
    public void populateDatabase() {
        // Pianos- Keyboards
        allItems.add(new Keyboard("Nord Piano 2", "The Nord Piano 2 is a highly regarded stage piano known for its outstanding sound quality and versatility. With its weighted keys, extensive library of high-quality piano samples, and intuitive user interface, it offers a premium playing experience for professional musicians and demanding pianists.",R.drawable.nordstage5, R.drawable.nordstage52, R.drawable.nordstage53,5699, "Number of Keys: 88\nPort Selection: USB MIDI, USB-to-Host\nPower Requirement: AC Adapter (Included)\nMIDI Control Surfaces: Pitch Stick, Modulation Wheel\nWeight: 5.699 kg"));
        allItems.add(new Keyboard("Yamaha P-45", "The Yamaha P-45 is a compact and affordable digital piano suitable for beginners. It features weighted keys, realistic sound, and a sleek design, making it a popular choice for those starting their musical journey.",R.drawable.yamahap451,R.drawable.yamahap452, R.drawable.yamahap453,450, "Number of Keys: 88\\nPort Selection: USB-to-Host, Headphone Jack\\nPower Requirement: AC Adapter (Included)\\nMIDI Control Surfaces: Touch Strip, Expression Pedal\\nWeight: 4.5 kg"));
        allItems.add(new Keyboard("Casio PX-160", "The Casio PX-160 is a versatile digital piano offering excellent sound quality and touch sensitivity. With its elegant design, it provides an authentic playing experience for musicians of all levels, and it's portable too.", R.drawable.casiopx1601, R.drawable.casiopx1602,R.drawable.casiopx1603, 500, "Number of Keys: 88\nPort Selection: USB MIDI, USB-to-Host\nPower Requirement: AC Adapter (Included)\nMIDI Control Surfaces: Sustain Pedal, Modulation Pedal\nWeight: 5 kg"));
        allItems.add(new Keyboard("Korg B2","The Korg B2 is a budget-friendly digital piano with a focus on simplicity and high-quality sound. It offers a wide range of tones and built-in effects, making it ideal for students and players looking for versatility.", R.drawable.korgb21, R.drawable.korgb22,R.drawable.korgb23, 550, "Number of Keys: 88\nPort Selection: USB MIDI, USB-to-Host\nPower Requirement: AC Adapter (Included)\nMIDI Control Surfaces: Pitch Bend Wheel, Expression Pedal\nWeight: 5.5 kg"));
        allItems.add(new Keyboard("Roland FP-30", "The Roland FP-30 is a portable and feature-rich digital piano. It combines an authentic piano playing experience with modern technology, including Bluetooth connectivity and a wide selection of sounds and rhythms.", R.drawable.rolandfp301,R.drawable.rolandfp302,R.drawable.rolandfp303,700,"Number of Keys: 88\nPort Selection: USB MIDI, USB-to-Host, Bluetooth\nPower Requirement: AC Adapter (Included)\nMIDI Control Surfaces: Modulation Lever, Damper Pedal\nWeight: 7 kg"));
        allItems.add(new Keyboard("Kawai ES110", "The Kawai ES110 is a compact and portable digital piano known for its exceptional key action and realistic sound. It offers a variety of instrument voices and is suitable for both beginners and advanced players.", R.drawable.kawaies1101,R.drawable.kawaies1102,R.drawable.kawaies1103, 800, "Number of Keys: 88\nPort Selection: USB MIDI, USB-to-Host\nPower Requirement: AC Adapter (Included)\nMIDI Control Surfaces: Pitch Bend Wheel, Sostenuto Pedal\nWeight: 8 kg"));
        allItems.add(new Keyboard("Nord Stage 3 Compact", "The Nord Stage 3 Compact is a professional-grade stage piano that delivers outstanding sound and performance. With its extensive range of sounds, effects, and intuitive controls, it is a top choice for live musicians and studio artists.", R.drawable.nord3compact,R.drawable.nord3compact2,R.drawable.nord3compact3, 2500, "Number of Keys: 73\nPort Selection: USB MIDI, MIDI In/Out, Pedal Inputs\nPower Requirement: AC Adapter (Included)\nMIDI Control Surfaces: Pitch Stick, Modulation Wheel\nWeight: 14.51 kg"));
        allItems.add(new Keyboard("Yamaha CP88", "The Yamaha CP88 is a stage piano designed to deliver unmatched acoustic and electric piano sounds. It features a sleek and sturdy build, along with versatile performance controls, making it a go-to instrument for gigging musicians.", R.drawable.yamahacp881,R.drawable.yamahacp882,R.drawable.yamahacp883, 3000, "Number of Keys: 88\nPort Selection: USB-to-Host, MIDI In/Out, Pedal Inputs\nPower Requirement: AC Power Cord (Included)\nMIDI Control Surfaces: Pitch Bend/Modulation Wheels, Master Volume Knob\nWeight: 20.41 kg"));
        allItems.add(new Keyboard("Korg Kronos LS", "The Korg Kronos LS is a professional workstation that offers a vast array of sounds, effects, and recording capabilities. With its lightweight design and intuitive interface, it caters to the needs of musicians and producers alike.", R.drawable.korgkronosls1,R.drawable.korgkronosls2,R.drawable.korgkronosls3, 3500, "Number of Keys: 88\nPort Selection: USB MIDI, USB-to-Host, MIDI In/Out, Pedal Inputs\nPower Requirement: AC Adapter (Included)\nMIDI Control Surfaces: Joystick, Ribbon Controller, Assignable Knobs\nWeight: 15.88 kg"));
        allItems.add(new Keyboard("Roland RD-2000", "The Roland RD-2000 is a flagship stage piano known for its exceptional playability and versatility. It combines authentic piano sounds with advanced performance features, making it a favorite among professional keyboardists.", R.drawable.rolandrd20001,R.drawable.rolandrd20002,R.drawable.rolandrd20003, 2500, "Number of Keys: 88\nPort Selection: USB MIDI, MIDI In/Out, Pedal Inputs\nPower Requirement: AC Adapter (Included)\nMIDI Control Surfaces: Modulation Lever, Sliders, Assignable Buttons\nWeight: 14.51 kg"));
        allItems.add(new Keyboard("Kawai MP11SE", "The Kawai MP11SE is a stage piano renowned for its exquisite piano feel and sound quality. It offers an extensive range of realistic instrument voices and customizable controls, making it a preferred choice for serious pianists.", R.drawable.kawaimp11se1,R.drawable.kawaimp11se2,R.drawable.kawaimpse113,2800,"Number of Keys: 88\nPort Selection: USB MIDI, MIDI In/Out, Pedal Inputs\nPower Requirement: AC Adapter (Included)\nMIDI Control Surfaces: Pitch Bend Wheel, Sliders, Assignable Knobs\nWeight: 23.13 kg"));

        // Pianos- Grand Pianos
        allItems.add(new Grand("Steinway Model D", "The Steinway Model D Concert Grand Piano is the pinnacle of excellence in piano craftsmanship. With its unparalleled tonal range, responsive touch, and exceptional projection, this instrument has been the choice of countless world-class pianists and renowned concert halls. Experience the richness and precision of the Steinway Model D, a true masterpiece of musical artistry.", R.drawable.steinwaymodeld1, R.drawable.steinwaymodeld2, R.drawable.steinwaymodeld3, 150000, "Type: Concert Grand\n" +
                "Dimensions: 274 cm x 156 cm x 102 cm (L x W x H)\n" +
                "Pedals: Soft Pedal, Sostenuto Pedal, Sustain Pedal\n" +
                "Resistance: Medium"));
        allItems.add(new Grand("Bosendorfer 225", "The Bosendorfer 225 Grand Piano is a masterpiece of Austrian piano engineering. With its rich and warm sound, exceptional craftsmanship, and unique 92-key keyboard, it offers an unparalleled playing experience. The Bosendorfer 225 is the perfect choice for pianists and enthusiasts who seek a piano that delivers both power and nuance.", R.drawable.bosendorfer2251, R.drawable.bosendorfer2252, R.drawable.bosendorfer2253, 120000, "Type: Professional Grand\n" +
                "Dimensions: 225 cm x 157 cm x 102 cm (L x W x H)\n" +
                "Pedals: Soft Pedal, Sostenuto Pedal, Sustain Pedal\n" +
                "Resistance: Light to Medium"));
        allItems.add(new Grand("Yamaha CF6", "The Yamaha CF6 Grand Piano is a testament to Yamaha's dedication to excellence. Designed in collaboration with world-renowned pianists, this instrument delivers a remarkable range of expressive possibilities. From delicate pianissimo to powerful fortissimo, the CFX offers unparalleled clarity and tonal richness, making it a favorite choice for concert stages and recording studios.", R.drawable.yamahacfx1, R.drawable.yamahacfx2, R.drawable.yamahacfx3, 170000, "Type: Concert Grand\n" +
                "Dimensions: 212 cm x 149 cm x 102 cm (L x W x H)\n" +
                "Pedals: Soft Pedal, Sostenuto Pedal, Sustain Pedal\n" +
                "Resistance: Medium to Heavy"));
        allItems.add(new Grand("Kawai GX-7", "The Kawai GX-7 Grand Piano is a masterpiece of Japanese piano craftsmanship. With its meticulous attention to detail, exceptional touch, and rich tonal palette, the GX-7 offers an exquisite playing experience. Whether you're a professional pianist or a passionate enthusiast, the Kawai GX-7 will inspire and elevate your musical expression.", R.drawable.kawaigx71, R.drawable.kawaigx72, R.drawable.kawaigx73, 80000, "Type: Professional Grand\n" +
                "Dimensions: 213 cm x 153 cm x 102 cm (L x W x H)\n" +
                "Pedals: Soft Pedal, Sostenuto Pedal, Sustain Pedal\n" +
                "Resistance: Medium"));
        allItems.add(new Grand("Bluthner Model 1", "The Bluthner Model 1 Grand Piano is a testament to the rich tradition of German piano craftsmanship. With its distinctive warm and romantic tone, unparalleled resonance, and exquisite artistry, the Model 1 is a favorite choice among discerning musicians and piano connoisseurs. Experience the legacy of Bluthner and immerse yourself in a world of musical excellence.", R.drawable.bluthnermodel1_1, R.drawable.bluthnermodel1_2, R.drawable.bluthnermodel1_3, 95000, "Type: Professional Grand\n" +
                "Dimensions: 160 cm x 146 cm x 99 cm (L x W x H)\n" +
                "Pedals: Soft Pedal, Sostenuto Pedal, Sustain Pedal\n" +
                "Resistance: Medium to Heavy"));
        allItems.add(new Grand("Fazioli F308", "The Fazioli F308 Concert Grand Piano is the epitome of Italian piano artistry. Handcrafted with meticulous attention to detail, this instrument offers unparalleled dynamic range, exceptional clarity, and an exquisite singing tone. The Fazioli F308 is a jewel in the world of concert grand pianos, coveted by pianists and admired by audiences worldwide.", R.drawable.faziolif3081, R.drawable.faziolif3082, R.drawable.faziolif3083, 300000, "Type: Concert Grand\n" +
                "Dimensions: 308 cm x 155 cm x 101 cm (L x W x H)\n" +
                "Pedals: Soft Pedal, Sostenuto Pedal, Sustain Pedal\n" +
                "Resistance: Heavy"));
        allItems.add(new Grand("Petrof P284 Mistral", "The Petrof P284 Mistral Grand Piano combines Czech piano-making tradition with modern innovation. With its powerful sound, balanced tone, and exceptional craftsmanship, the Mistral is a remarkable instrument for pianists seeking a versatile and expressive playing experience. Discover the beauty and artistry of Petrof pianos with the P284 Mistral.", R.drawable.petrofp2841, R.drawable.petrofp2842, R.drawable.petrofp2843, 55000, "Type: Professional Grand\n" +
                "Dimensions: 284 cm x 156 cm x 102 cm (L x W x H)\n" +
                "Pedals: Soft Pedal, Sostenuto Pedal, Sustain Pedal\n" +
                "Resistance: Light to Medium"));
        allItems.add(new Grand("Bechstein D282", "The Bechstein D282 Concert Grand Piano is a masterpiece of German piano engineering. Handcrafted with precision and passion, this instrument offers a rich, resonant tone and exceptional dynamic range. Whether in intimate recital halls or grand concert venues, the Bechstein D282 Concert Grand Piano delivers unparalleled performance and artistry.", R.drawable.bechsteinconcert81, R.drawable.bechsteinconcert82, R.drawable.bechsteinconcert83, 240000, "Type: Professional Grand\n" +
                "Dimensions: 284 cm x 156 cm x 102 cm (L x W x H)\n" +
                "Pedals: Soft Pedal, Sostenuto Pedal, Sustain Pedal\n" +
                "Resistance: Light to Medium"));
        allItems.add(new Grand("Steinway Model B", "The Steinway Model B Grand Piano is a testament to the legacy of Steinway & Sons. Renowned for its balanced and versatile sound, superb touch, and exceptional craftsmanship, the Model B is a favorite choice for both professional pianists and passionate enthusiasts. Experience the iconic Steinway sound and tradition with the Model B.", R.drawable.steinwaymodelb1, R.drawable.steinwaymodelb2, R.drawable.steinwaymodelb3, 95000, "Type: Professional Grand\n" +
                "Dimensions: 211 cm x 156 cm x 102 cm (L x W x H)\n" +
                "Pedals: Soft Pedal, Sostenuto Pedal, Sustain Pedal\n" +
                "Resistance: Medium"));
        allItems.add(new Grand("Baldwin SD-10", "The Baldwin SD-10 Concert Grand Piano is a legendary instrument that has graced the stages of countless concert halls. Known for its powerful and resonant sound, exceptional touch, and remarkable durability, the SD-10 continues to be a favored choice among pianists and institutions worldwide. Experience the rich musical heritage of Baldwin with the SD-10 Concert Grand Piano.", R.drawable.baldwinsd101, R.drawable.baldwinsd102, R.drawable.baldwinsd103, 65000, "Type: Professional Grand\n" +
                "Dimensions: 211 cm x 156 cm x 102 cm (L x W x H)\n" +
                "Pedals: Soft Pedal, Sostenuto Pedal, Sustain Pedal\n" +
                "Resistance: Medium"));


        // Guitars- Electric
        allItems.add(new Electric("Fender Stratocaster", "The Fender Stratocaster is an iconic electric guitar known for its versatile tone and comfortable design. With its double-cutaway body, three single-coil pickups, and tremolo bridge, it offers a wide range of expressive possibilities, making it a favorite among guitarists across various genres.", R.drawable.fenderstratocaster1, R.drawable.fenderstratocaster2, R.drawable.fenderstratocaster3, 850, "Construction: Solid Body\n" +
                "Number of Frets: 22\n" +
                "Electronics: 3 Single-coil Pickups\n" +
                "Material of Strings: Nickel Plated Steel\n" +
                "Pickups: Single-coil\n" +
                "Bridge: Tremolo"));
        allItems.add(new Electric("Gibson LP Standard", "The Gibson Les Paul Standard is a legendary electric guitar with a rich history. Its solid mahogany body, maple top, and dual humbucking pickups deliver a powerful and warm tone. Perfect for rock, blues, and beyond, this guitar offers exceptional playability and classic aesthetics.", R.drawable.gibsonlespaulstandard1, R.drawable.gibsonlespaulstandard2, R.drawable.gibsonlespaulstandard3, 1900, "Construction: Solid Body\n" +
                "Number of Frets: 22\n" +
                "Electronics: 2 Humbucking Pickups\n" +
                "Material of Strings: Nickel Wound\n" +
                "Pickups: Humbucker\n" +
                "Bridge: Tune-o-matic"));
        allItems.add(new Electric("PRS Custom 24", "The PRS Custom 24 is a stunning electric guitar known for its exquisite craftsmanship and versatility. With its figured maple top, mahogany body, and PRS-designed humbucking pickups, it delivers a balanced and dynamic tone. Its sleek design and flawless playability make it a dream instrument for any guitarist.", R.drawable.prscustom241, R.drawable.prscustom242, R.drawable.prscustom243, 2500, "Construction: Solid Body\n" +
                "Number of Frets: 24\n" +
                "Electronics: 2 Humbucking Pickups\n" +
                "Material of Strings: Steel\n" +
                "Pickups: Humbucker\n" +
                "Bridge: Tremolo"));
        allItems.add(new Electric("Ibanez RG550", "The Ibanez RG550 is a high-performance electric guitar designed for players who crave speed and precision. Its sleek and ergonomic body, paired with a thin Wizard neck, enables effortless shredding. Equipped with versatile Ibanez pickups and a double-locking tremolo system, it's perfect for the modern rock and metal guitarist.", R.drawable.ibanezrg5501, R.drawable.ibanezrg5502, R.drawable.ibanezrg5503, 1200, "Construction: Solid Body\n" +
                "Number of Frets: 24\n" +
                "Electronics: HSH (Humbucker-Single-Humbucker)\n" +
                "Material of Strings: Nickel Wound\n" +
                "Pickups: Humbucker, Single-coil\n" +
                "Bridge: Double-locking Tremolo"));
        allItems.add(new Electric("ESP LTD EC-1000", "The ESP LTD EC-1000 is a powerhouse electric guitar with a classic design and modern features. Its mahogany body and set-neck construction deliver a thick and resonant tone, while its active EMG pickups provide high-output and clarity. Whether you're playing rock, metal, or blues, this guitar delivers exceptional performance.", R.drawable.espltdec10001, R.drawable.espltdec10002, R.drawable.espltdec10003, 1300, "Construction: Solid Body\n" +
                "Number of Frets: 24\n" +
                "Electronics: 2 Active EMG Pickups\n" +
                "Material of Strings: Stainless Steel\n" +
                "Pickups: Active EMG\n" +
                "Bridge: Tune-o-matic"));
        allItems.add(new Electric("Gibson SG Standard", "The Gibson SG Standard is a legendary electric guitar known for its raw power and aggressive tone. Featuring a solid mahogany body, slim-taper neck, and dual humbucking pickups, it delivers punchy, high-gain sounds with excellent sustain. Whether you're playing rock, blues, or metal, the Gibson SG Standard is a true rock 'n' roll machine.", R.drawable.gibsonsgstandard1, R.drawable.gibsonsgstandard2, R.drawable.gibsonsgstandard3, 1500, "Construction: Solid Body\n" +
                "Number of Frets: 22\n" +
                "Electronics: 2 Humbucking Pickups\n" +
                "Material of Strings: Nickel Wound\n" +
                "Pickups: Humbucker\n" +
                "Bridge: Tune-o-matic"));
        allItems.add(new Electric("PRS SE Custom 24", "The PRS SE Custom 24 is a high-quality and affordable electric guitar that offers remarkable versatility. With its maple top, mahogany body, and PRS-designed pickups, it delivers a balanced tone with excellent clarity. The SE Custom 24 is known for its comfortable playability and stunning aesthetics, making it an excellent choice for guitarists of all levels.", R.drawable.prssecustom241, R.drawable.prssecustom242, R.drawable.prssecustom243, 900, "Construction: Solid Body\n" +
                "Number of Frets: 24\n" +
                "Electronics: 2 PRS-designed Pickups\n" +
                "Material of Strings: Nickel Wound\n" +
                "Pickups: Humbucker\n" +
                "Bridge: Tremolo"));
        allItems.add(new Electric("Fender Telecaster", "The Fender Telecaster is a timeless electric guitar that has been a favorite among musicians for decades. With its single-cutaway body, two single-coil pickups, and distinctive twangy sound, the Telecaster is versatile enough to handle a wide range of musical styles. Whether you're playing country, rock, or blues, the Fender Telecaster delivers classic tones and reliable performance.", R.drawable.fendertelecaster1, R.drawable.fendertelecaster2, R.drawable.fendertelecaster3, 950, "Construction: Solid Body\n" +
                "Number of Frets: 21\n" +
                "Electronics: 2 Single-coil Pickups\n" +
                "Material of Strings: Nickel Plated Steel\n" +
                "Pickups: Single-coil\n" +
                "Bridge: Fixed"));
        allItems.add(new Electric("Gibson Explorer", "The Gibson Explorer is a bold and unique electric guitar that's perfect for players who want to make a statement. With its futuristic body design, dual humbucking pickups, and solid mahogany construction, the Explorer delivers a powerful and aggressive tone. It's a favorite among hard rock and metal guitarists who crave both style and substance.", R.drawable.gibsonexplorer1, R.drawable.gibsonexplorer2, R.drawable.gibsonexplorer3, 1700, "Construction: Solid Body\n" +
                "Number of Frets: 24\n" +
                "Electronics: 2 Humbucking Pickups\n" +
                "Material of Strings: Nickel Plated Steel\n" +
                "Pickups: Humbucker\n" +
                "Bridge: Double-locking Tremolo"));
        allItems.add(new Electric("Ibanez JEM7V", "The Ibanez JEM7V is a signature electric guitar designed in collaboration with virtuoso guitarist Steve Vai. Known for its distinctive looks and exceptional playability, this guitar features a basswood body, a bolt-on maple neck, and DiMarzio Evolution pickups. With its versatile tone and stunning aesthetics, the Ibanez JEM7V is a dream instrument for any aspiring shredder.", R.drawable.ibanezjem7v1, R.drawable.ibanezjem7v2, R.drawable.ibanezjem7v3, 3000, "Construction: Solid Body\n" +
                "Number of Frets: 22\n" +
                "Electronics: 2 Humbucking Pickups\n" +
                "Material of Strings: Nickel Wound\n" +
                "Pickups: Humbucker\n" +
                "Bridge: Tune-o-matic"));

        // Guitars- Acoustic
        // Add acoustic guitars...
        allItems.add(new Acoustic("Aria 101 OM",
                "The Aria '100 series' offers affordability without compromising playability and rich clear projection. Perfect for musicians of any level, it excels in live performances with its majestic body and fretboard.",
                R.drawable.satinsun1, R.drawable.satinsun2, R.drawable.satinsun3, 349, "Construction: Orchestra Model (OM)\n" +
                "Top Material: Solid Spruce\n" +
                "Back and Sides Material: Mahogany\n" +
                "Neck Material: Mahogany\n" +
                "Fingerboard Material: Rosewood\n" +
                "Number of Frets: 20\n" +
                "Strings: Steel\n" +
                "Electronics: None"));

        allItems.add(new Acoustic("Taylor 214ce",
                "The Taylor 214ce Deluxe combines premium materials and craftsmanship with a versatile sound and elegant design. Its solid Sitka spruce top, layered rosewood back and sides, and Taylor Expression System 2 electronics deliver a rich, balanced tone on and off the stage.",
                R.drawable.taylor214ce1, R.drawable.taylor214ce2, R.drawable.taylor214ce3, 1199, "Construction: Grand Auditorium\n" +
                "Top Material: Solid Sitka Spruce\n" +
                "Back and Sides Material: Layered Rosewood\n" +
                "Neck Material: Tropical Mahogany\n" +
                "Fingerboard Material: West African Crelicam Ebony\n" +
                "Number of Frets: 20\n" +
                "Strings: Steel\n" +
                "Electronics: Taylor Expression System 2"));

        allItems.add(new Acoustic("Martin D28",
                "The Martin D-28 is an iconic instrument beloved by generations of musicians. With its solid Sitka spruce top, East Indian rosewood back and sides, and forward-shifted bracing, it delivers a powerful, resonant tone and exceptional projection.",
                R.drawable.martind281, R.drawable.martind282, R.drawable.martind283, 2999, "Construction: Dreadnought\n" +
                "Top Material: Solid Sitka Spruce\n" +
                "Back and Sides Material: East Indian Rosewood\n" +
                "Neck Material: Select Hardwood\n" +
                "Fingerboard Material: Ebony\n" +
                "Number of Frets: 20\n" +
                "Strings: Steel\n" +
                "Electronics: None"));

        allItems.add(new Acoustic("Gibson J45",
                "The Gibson J-45 is a legendary instrument known for its warm, balanced tone and timeless design. Its solid Sitka spruce top, mahogany back and sides, and hand-scalloped X bracing offer a rich, full-bodied sound with excellent projection.",
                R.drawable.gibsonj451, R.drawable.gibsonj452, R.drawable.gibsonj453, 2499, "Construction: Round Shoulder Dreadnought\n" +
                "Top Material: Solid Sitka Spruce\n" +
                "Back and Sides Material: Mahogany\n" +
                "Neck Material: Mahogany\n" +
                "Fingerboard Material: Rosewood\n" +
                "Number of Frets: 20\n" +
                "Strings: Steel\n" +
                "Electronics: None"));

        allItems.add(new Acoustic("Yamaha FG800",
                "The Yamaha FG800 is a testament to Yamaha's commitment to quality and affordability. With its solid spruce top, nato/okume back and sides, and scalloped bracing, it delivers a vibrant and articulate tone. A popular choice among beginners and experienced players alike.",
                R.drawable.yamahafg8001, R.drawable.yamahafg8002, R.drawable.yamahafg8003, 199, "Construction: Dreadnought\n" +
                "Top Material: Solid Spruce\n" +
                "Back and Sides Material: Nato/Okume\n" +
                "Neck Material: Nato\n" +
                "Fingerboard Material: Rosewood\n" +
                "Number of Frets: 20\n" +
                "Strings: Steel\n" +
                "Electronics: None"));

        allItems.add(new Acoustic("Seagull S6",
                "The Seagull S6 Original offers exceptional craftsmanship, quality tonewoods, and a superb playing experience. Its solid cedar top, wild cherry back and sides, and tapered headstock deliver a warm, balanced tone with excellent sustain. A Canadian-made instrument that exceeds expectations.",
                R.drawable.seagulls61, R.drawable.seagulls62, R.drawable.seagulls63, 449, "Construction: Dreadnought\n" +
                "Top Material: Solid Cedar\n" +
                "Back and Sides Material: Wild Cherry\n" +
                "Neck Material: Silver Leaf Maple\n" +
                "Fingerboard Material: Rosewood\n" +
                "Number of Frets: 21\n" +
                "Strings: Steel\n" +
                "Electronics: None"));

        allItems.add(new Acoustic("Taylor 814ce",
                "The Taylor 814ce Deluxe combines premium materials and craftsmanship with a versatile sound and elegant design. Its solid Sitka spruce top, Indian rosewood back and sides, and Taylor Expression System 2 electronics deliver a rich, dynamic sound with unparalleled clarity and responsiveness.",
                R.drawable.taylor814ce1, R.drawable.taylor814ce2, R.drawable.taylor814ce3, 3699, "Construction: Grand Auditorium\n" +
                "Top Material: Solid Sitka Spruce\n" +
                "Back and Sides Material: Indian Rosewood\n" +
                "Neck Material: Tropical Mahogany\n" +
                "Fingerboard Material: West African Crelicam Ebony\n" +
                "Number of Frets: 20\n" +
                "Strings: Steel\n" +
                "Electronics: Taylor Expression System 2"));

        allItems.add(new Acoustic("Martin HD28",
                "The Martin HD-28 is a timeless classic with a powerful voice and exquisite craftsmanship. Its solid Sitka spruce top, East Indian rosewood back and sides, and scalloped bracing offer a bold and articulate tone with exceptional projection. A true workhorse that stands the test of time.",
                R.drawable.martinhdd281, R.drawable.martinhdd282, R.drawable.martinhdd283, 3499, "Construction: Dreadnought\n" +
                "Top Material: Solid Sitka Spruce\n" +
                "Back and Sides Material: East Indian Rosewood\n" +
                "Neck Material: Select Hardwood\n" +
                "Fingerboard Material: Ebony\n" +
                "Number of Frets: 20\n" +
                "Strings: Steel\n" +
                "Electronics: None"));

        allItems.add(new Acoustic("Gibson Hummingbird",
                "The Gibson Hummingbird Standard is an iconic instrument with a distinctive look and a rich, expressive sound. With its solid Sitka spruce top, mahogany back and sides, and hand-scalloped X bracing, it offers a balanced and resonant tone with excellent projection. A beloved choice for both strummers and fingerstyle players.",
                R.drawable.gibsonhummingbird1, R.drawable.gibsonhummingbird2, R.drawable.gibsonhummingbird3, 3599, "Construction: Square Shoulder Dreadnought\n" +
                "Top Material: Solid Sitka Spruce\n" +
                "Back and Sides Material: Mahogany\n" +
                "Neck Material: Mahogany\n" +
                "Fingerboard Material: Rosewood\n" +
                "Number of Frets: 20\n" +
                "Strings: Steel\n" +
                "Electronics: None"));

        allItems.add(new Acoustic("Yamaha FG830",
                "The Yamaha FG830 Solid Top builds upon the success of the FG800 with upgraded features and enhanced playability. With its solid spruce top, rosewood back and sides, and scalloped bracing, it delivers a rich and vibrant tone with improved projection. A reliable and versatile instrument suitable for players of all levels.",
                R.drawable.yamahafg8301, R.drawable.yamahafg8302, R.drawable.yamahafg8303, 249, "Construction: Dreadnought\n" +
                "Top Material: Solid Spruce\n" +
                "Back and Sides Material: Rosewood\n" +
                "Neck Material: Nato\n" +
                "Fingerboard Material: Rosewood\n" +
                "Number of Frets: 20\n" +
                "Strings: Steel\n" +
                "Electronics: None"));


        // Audio- Headphones
        allItems.add(new Headphones("Bose QuietComfort 35", "Experience world-class noise cancellation, wireless freedom, and exceptional sound quality with the Bose QuietComfort 35 II headphones. These over-ear headphones provide up to 20 hours of battery life and feature built-in Google Assistant for hands-free control.", R.drawable.boseqc351,R.drawable.boseqc352,R.drawable.boseqc353, 349.99f, "Connection: Wireless\nBattery Life: Up to 20 hours\nType: Over-ear\nDrivers: 40mm drivers\nBuild Material: Synthetic leather and metal"));
        allItems.add(new Headphones("Sony XM4", "Immerse yourself in music like never before with the Sony WH-1000XM4 headphones. These premium wireless headphones offer industry-leading noise cancellation, personalized sound, and up to 30 hours of battery life. Enjoy superior audio quality and smart features for a truly immersive listening experience.", R.drawable.sonyxm41,R.drawable.sonyxm42,R.drawable.sonyxm43, 349.99F, "Connection: Wireless\nBattery Life: Up to 30 hours\nType: Over-ear\nDrivers: 50mm drivers\nBuild Material: Plastic and metal"));
        allItems.add(new Headphones("Sennheiser 660S", "Discover the pure audio bliss with the Sennheiser HD 660 S open-back headphones. Featuring precise and natural sound reproduction, these audiophile-grade headphones deliver exceptional clarity and detail. The lightweight design and comfortable fit ensure hours of listening pleasure.", R.drawable.sennheiser6601,R.drawable.sennheiser6602,R.drawable.sennheiser6603, 499.95F, "Connection: Wired\nBattery Life: Wired\nType: Over-ear\nDrivers: 42mm drivers\nBuild Material: Aluminum and plastic"));
        allItems.add(new Headphones("Audio-Technica ATH-M50x", "The Audio-Technica ATH-M50x professional studio headphones are renowned for their exceptional audio performance. With a robust build, swiveling ear cups, and accurate sound reproduction, these headphones are a favorite among professionals and music enthusiasts alike.", R.drawable.audiotechnica50x1,R.drawable.audiotechnica50x2,R.drawable.audiotechnica50x3, 149, "Connection: Wired\nBattery Life: Wired\nType: Over-ear\nDrivers: 45mm drivers\nBuild Material: Plastic and metal"));
        allItems.add(new Headphones("Beats Studio3 Wireless", "Elevate your music experience with the Beats Studio3 Wireless headphones. Enjoy pure adaptive noise cancellation, impressive audio quality, and up to 22 hours of battery life. The iconic design and comfortable fit make these headphones perfect for all-day listening.", R.drawable.beatsstudio31,R.drawable.beatsstudio32,R.drawable.beatsstudio33,349.95F, "Connection: Wireless\nBattery Life: Up to 22 hours\nType: Over-ear\nDrivers: 40mm drivers\nBuild Material: Plastic and metal"));
        allItems.add(new Headphones("Jabra Elite 85h", "Unleash the power of true wireless freedom with the Jabra Elite 85h headphones. These smart headphones feature SmartSound technology, adaptive noise cancellation, and up to 36 hours of battery life. Stay connected and enjoy crystal-clear sound in any environment.", R.drawable.jabra85h1,R.drawable.jabra85h2,R.drawable.jabra85h3, 249.99F, "Connection: Wireless\nBattery Life: Up to 36 hours\nType: Over-ear\nDrivers: 40mm drivers\nBuild Material: Fabric and plastic"));
        allItems.add(new Headphones("Bowers & Wilkins PX7", "Description: Immerse yourself in sound with the Bowers & Wilkins PX7 wireless headphones. These premium headphones deliver exceptional audio quality, adaptive noise cancellation, and up to 30 hours of battery life. The sleek design and ergonomic fit ensure maximum comfort.", R.drawable.bwpx71,R.drawable.bwpx72,R.drawable.bwpx73, 399.99F, "Connection: Wireless\nBattery Life: Up to 30 hours\nType: Over-ear\nDrivers: 43mm drivers\nBuild Material: Carbon fiber and metal"));
        allItems.add(new Headphones("AKG K371", "Experience studio-quality sound reproduction with the AKG K371 headphones. These closed-back, over-ear headphones provide accurate and balanced audio, perfect for mixing, monitoring, and casual listening. The foldable design and detachable cables make them highly portable.",R.drawable.akgk371,R.drawable.akgmk72,R.drawable.akgk373,149, "Connection: Wired\nBattery Life: Wired\nType: Over-ear\nDrivers: 50mm drivers\nBuild Material: Plastic and metal"));
        allItems.add(new Headphones("Plantronics BackBeat Pro 2", "Enjoy wireless freedom and immersive audio with the Plantronics BackBeat Pro 2 headphones. With active noise cancellation, long-lasting battery life, and on-demand active noise canceling, these headphones are perfect for travel and everyday use.", R.drawable.plantronicspro1,R.drawable.plantronicspro2,R.drawable.plantronicspro3, 199.99F, "Connection: Wireless\nBattery Life: Up to 24 hours\nType: Over-ear\nDrivers: 40mm drivers\nBuild Material: Plastic and metal"));
        allItems.add(new Headphones("JBL Quantum 800", "Level up your gaming experience with the JBL Quantum 800 wireless gaming headphones. These feature-packed headphones offer JBL QuantumSOUND Signature, active noise cancellation, and a detachable boom microphone for crystal-clear communication.", R.drawable.jblquantum1,R.drawable.jblquantum2,R.drawable.jblquantum3, 199.95F, "Connection: Wireless\nBattery Life: Up to 14 hours\nType: Over-ear\nDrivers: 50mm drivers\nBuild Material: Plastic and metal"));

        // Audio- Monitors
        allItems.add(new Monitors("Yamaha HS5", "The Yamaha HS5 studio monitor is renowned for its accuracy and clarity. With a 5-inch woofer and 1-inch dome tweeter, it offers precise sound reproduction and a flat frequency response.", R.drawable.yamahahs51,R.drawable.yamahahs52,R.drawable.yamahahs53, 199, "Size: 5 inches\nTweeter Size: 1 inch\nDriver: 2-way\nInput: XLR, TRS\nPower Requirement: 70W\nFrequency Response: 54Hz - 30kHz"));
        allItems.add(new Monitors("KRK Rokit G4", "The KRK Rokit RP5 G4 studio monitor delivers powerful and balanced sound. Its bi-amped design, built-in DSP, and Kevlar drivers ensure accurate audio reproduction.", R.drawable.krkrokit51, R.drawable.krkrokit52, R.drawable.krkrokit53, 179, "Size: 5 inches\nTweeter Size: 1 inch\nDriver: 2-way\nInput: XLR, TRS, RCA\nPower Requirement: 55W\nFrequency Response: 43Hz - 40kHz"));
        allItems.add(new Monitors("JBL Professional 305P MkII", "The JBL Professional 305P MkII studio monitor provides exceptional detail and imaging. With a 5-inch woofer and 1-inch tweeter, it offers a wide sweet spot and precise frequency response.", R.drawable.jbl3051, R.drawable.jbl3052, R.drawable.jbl3053, 149, "Size: 5 inches\nTweeter Size: 1 inch\nDriver: 2-way\nInput: XLR, TRS\nPower Requirement: 82W\nFrequency Response: 49Hz - 20kHz"));
        allItems.add(new Monitors("Adam Audio T5V", "The Adam Audio T5V studio monitor features a U-ART tweeter and 5-inch woofer for precise and transparent sound reproduction. It offers excellent transient response and extended frequency range.", R.drawable.adamt5v1, R.drawable.adamt5v2, R.drawable.adamt5v3, 199, "Size: 5 inches\nTweeter Size: U-ART 1.9 inches\nDriver: 2-way\nInput: XLR, RCA\nPower Requirement: 70W\nFrequency Response: 45Hz - 25kHz"));
        allItems.add(new Monitors("PreSonus Eris E5", "The PreSonus Eris E5 studio monitor delivers accurate sound with its 5.25-inch Kevlar woofer and 1-inch silk-dome tweeter. Its acoustic tuning controls allow customization to your listening environment.", R.drawable.presonuse51, R.drawable.presonuse52, R.drawable.presonuse53, 149, "Size: 5.25 inches\nTweeter Size: 1 inch\nDriver: 2-way\nInput: XLR, TRS, RCA\nPower Requirement: 70W\nFrequency Response: 53Hz - 22kHz"));
        allItems.add(new Monitors("Focal Alpha 65", "The Focal Alpha 65 studio monitor provides exceptional clarity and detail. With a 6.5-inch woofer and 1-inch tweeter, it delivers precise sound reproduction across a wide frequency range.", R.drawable.focal651, R.drawable.focal652, R.drawable.focal653, 599, "Size: 6.5 inches\nTweeter Size: 1 inch\nDriver: 2-way\nInput: XLR, RCA\nPower Requirement: 105W\nFrequency Response: 40Hz - 22kHz"));
        allItems.add(new Monitors("Mackie MR524", "The Mackie MR524 studio monitor features a 5-inch polypropylene woofer and 1-inch silk-dome tweeter for balanced sound. Its logarithmic waveguide ensures wide dispersion and accurate imaging.", R.drawable.mackie5241, R.drawable.mackie5242, R.drawable.mackie5243, 899, "Size: 5 inches\nTweeter Size: 1 inch\nDriver: 2-way\nInput: XLR, TRS, RCA\nPower Requirement: 50W\nFrequency Response: 45Hz - 20kHz"));
        allItems.add(new Monitors("Neumann KH 120 A", "The Neumann KH 120 A studio monitor offers outstanding sound quality and precise imaging. It features a 5.25-inch woofer, 1-inch tweeter, and powerful amplification for optimal performance.", R.drawable.neumann1, R.drawable.neumann2, R.drawable.neumann3, 1239, "Size: 5.25 inches\nTweeter Size: 1 inch\nDriver: 2-way\nInput: XLR, RCA\nPower Requirement: 100W\nFrequency Response: 52Hz - 21kHz"));
        allItems.add(new Monitors("Genelec 8020D", "The Genelec 8020D studio monitor is known for its compact size and exceptional sound reproduction. It features a 4-inch woofer and 3/4-inch tweeter for accurate and detailed audio.", R.drawable.genelec2, R.drawable.genelec1, R.drawable.genelec3, 1259, "Size: 4 inches\nTweeter Size: 3/4 inch\nDriver: 2-way\nInput: XLR, RCA\nPower Requirement: 50W\nFrequency Response: 66Hz - 20kHz"));
        allItems.add(new Monitors("PreSonus Scepter S6", "The PreSonus Sceptre S6 studio monitor offers high-definition sound with its coaxial driver design. It features a 6.5-inch low/mid-frequency driver and a 1-inch tweeter, providing accurate imaging and a wide sweet spot", R.drawable.presonussceptre1, R.drawable.presonussceptre2, R.drawable.presonussceptre3, 899.99F, "Size: 6.5 inches\nTweeter Size: 1 inch\nDriver: 2-way\nInput: XLR, TRS\nPower Requirement: 180W\nFrequency Response: 45Hz - 20kHz"));
    }


    public static ArrayList<Item> getAllItems() {
        return allItems;
    }


}
