Na početku prvo je stvoren MainActivity i pripadajući layout main_activity. U layout su posložena 4 ImageButtona za koje su 
korištene slike čiji su izvori u popisu literature. Iznad ImageButtona dodan je i jedan opisni TextView. U MainActivity-u deklarirani su 
ImageButtoni i svaki je povezan s određenim elementom u layoutu. Zatim je definirana onClickListener metoda za osluškivanje na klik za svaki od ImageButtona. Na klik se preko eksplicitnog intenta otvara nova aktivnost, tj. svaki ImageButton vodi na drugu aktivnost. To je ostvareno switch case naredbom kojoj se predaje ID od ImageButtona.

Za svaku od 4 pretvorbe stvorena je zasebna aktivnosti s pripadajućim layoutom. 
Sve su napisane na istom principu, samo su izmjenjeni neki identifikatori. Svaki layout ima prvi vrhu jedan spinner koji se koristi
za određivanje konverzije (za pozadinu postavljena je osobno izrađena slika s okvirom, nalazi se u drawable folderu pod nazivom okvir.png),ispod spinnera je EditText element koji je definiran da prima samo decimalne vrijednosti, i na dnu svakog od ta 4 layouta nalazi se Button koji vodi na aktivnost RezultatiActivity. U aktivnostima za pretvorbu prvo su definirani i , povezani elementi s onima iz layouta, zatim se definirao adapter koji će upisivati polje stringova u svaki spinner (polje stringova za svaki spinner definirano je u obliku string-array u strings.xml), nakon toga je povezan adapter s određenim spinnerom i postavljena je metoda setOnItemSelectedListener koja klikom na određeni element polja stringova u spinneru sprema taj string u varijablu "određena_konverzija". Ova varijabla koristi se za prosljeđivanje preko putExtra metode. Uz nju šalje se i string vrijednost koja je upisana u EditText element. Nakon njih definiran je onClickListener za gumb koji vodi u RezultatiActivity. U slučaju da je gumb kliknut a nije upisana vrijednost u EditText, izbacuje se error poruka na EditTextu koja podsjeća da se mora unijeti vrijednost. A ako je kliknut gumb a nije odabrana konverzija u spinneru izbacuje se Toast poruka koja podsjeća da se konverzija mora odabrati.

U layoutu za rezultate postoje 4 TextView-a, dva ispisuju koje se jedinice nalaze u konverziji, a dva ispisuju unesenu vrijednost te vrijednost koja se trebala izračunati. RezultatiActivity primaju preko određenih ključeva string iz EditTexta i string iz "određene_konverzije" koji tada pomoću switch case naredbe ispituju. S obzirom na to koji je string poslan iz spinnera, obavlja se određena matematička operacija nad stringom iz EditTexta na način da je on prvo pretvoren u double vrijednost (zbog decimalnih vrijednosti), zatim je obavljena operacija te se dobiveni rezultat ponovno pretvara u string kako bi se mogao ispisati.

Na kraju razvoja aplikacije još je bilo potrebno dodati layoute za landscape prikaz u kojima su malo izmjenjeni položaji elemenata, te je dodan ScrollView u rezultati.xml i activity_main.xml za landscape. Dodana je i nova ikona aplikacije.

Što se tiče poteškoća u razvoju, nije bilo baš nekakvih velikih problema osim što sam naišla na grešku kod double vrijednosti pa je to riješeno pomoću try-catch. Izvor rješenja je također postavljen u literaturi pod brojem 3. 






Literatura:
  1. https://www.youtube.com/watch?v=28jA5-mO8K8, Pomoćni tutorial za spinnere od PRABEESH R K
  2. http://stackoverflow.com/questions/21928747/how-to-pass-spinner-data-from-one-activity-to-another, proslijeđivanje vrijednosti spinnera
  3. http://stackoverflow.com/questions/5766318/converting-double-to-string konvertiranje, double vrijednost u vrijednost za ispis
  4.  Materijali s laboratorijskih vježbi
  
Slike:
   1.http://wfarm2.dataknet.com/static/resources/icons/set113/85a70717.png , ikona za pretvorbu novca
   2.https://cdn2.iconfinder.com/data/icons/health-check-up/64/height-tall-measure-body-man-512.png, ikona za pretvorbu visine/udaljenosti
   3.https://www.google.com/search?q=tekucina+icon&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjek7-Xw43TAhVBPSwKHXNpBoAQ_AUIBigB&biw=1093&bih=502#tbm=isch&q=temeperature+icon&*&imgrc=7kT-sc1YDarRBM:, ikona za pretvorbu temperature
   4.http://wfarm3.dataknet.com/static/resources/icons/set113/9662bbe2.png, ikona za pretvorbu tekužine
