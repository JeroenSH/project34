String menu = "welkom";
void setup() {
  textSize(28);
  //fullScreen();
  size(1280, 720 );  //width height
  background(0, 0, 255);
}
/*
alle blokken
 
 fill(0, 0, 0);
 rect(width-(width-width/12), height - (height-height/25), width - (width-2*(width/12)), height - (height-2*(height/25)));       //blok 1 linksboven
 
 fill(0,0,0);
 rect(width-(3*(width/12)), height - (height-height/25),width - (width-(2*(width/12))) , height - (height-2*(height/25)));   //blok 2 rechtsboven
 
 fill(0, 0, 0);
 rect(width-(width-width/12), height - (3*height/25), width - (width-2*(width/12)), height - (height-2*(height/25)));       //blok 3 linksonder
 
 fill (0,0,0);
 rect(width-(3*(width/12)), height - (3*height/25), width - (width-(2*(width/12))), height - (height-2*(height/25)));   //blok 4 rechtsonder
 */


void draw() {

  switch(menu) {
  case "welkom":
    text("press any key to continue", width/2, height/2);
    if (mousePressed == true) {
      delay(60);
      menu ="geef pincode";
    }
    break;
  case "eerstekeuze":
    background(0, 0, 255);
    fill(0, 0, 0);
    rect(width-(width-width/12), height - (height-height/25), width - (width-2*(width/12)), height - (height-2*(height/25)));       //blok 1 linksboven
    fill(255, 0, 0);
    text("saldo opvragen", width-(width-width/12), height - (height-2*height/25));

    fill(0, 0, 0);
    rect(width-(3*(width/12)), height - (height-height/25), width - (width-(2*(width/12))), height - (height-2*(height/25)));   //blok 2 rechtsboven
    fill(255, 0, 0);
    text("geld opnemen", width-(3*(width/12)), height - (height-2*height/25));

    fill(0, 0, 0);
    rect(width-(width-width/12), height - (3*height/25), width - (width-2*(width/12)), height - (height-2*(height/25)));       //blok 3 linksonder
    fill(255, 0, 0);
    text("afbreken", width-(width-width/12), height -2*height/25);

    fill (0, 0, 0);
    rect(width-(3*(width/12)), height - (3*height/25), width - (width-(2*(width/12))), height - (height-2*(height/25)));   //blok 4 rechtsonder


    if ((mouseX > (width -(width-width/12))) && mouseX < (width - (width-3*(width/12))) && (mouseY > (height-(height - height/25))) && mouseY < height-(height-3*(height/25))) {    //blok 1
      fill(255, 0, 0);
      rect(width-(width-width/12), height - (height-height/25), width - (width-2*(width/12)), height - (height-2*(height/25))); 
      if (mousePressed == true) {
        menu ="saldo";
      }
    }
    if ((mouseX > (width -(3*(width/12)))) && mouseX < (width - (width/12)) && (mouseY > (height-(height - height/25))) && mouseY < height-(height-3*(height/25))) {    //blok 2
      fill(0, 255, 0);
      rect(width-(3*(width/12)), height - (height-height/25), width - (width-(2*(width/12))), height - (height-2*(height/25)));
      if (mousePressed == true) {
        menu ="geld opnemen";
      }
    }

    if ((mouseX > (width -(width-width/12))) && mouseX < (width - (width-3*(width/12))) && mouseY > (height - 3*(height/25)) && mouseY < (height - (height/25))) {    //blok 3 
      fill(0, 255, 0);
      rect(width-(width-width/12), height - (3*height/25), width - (width-2*(width/12)), height - (height-2*(height/25)));
      if (mousePressed == true) {
        menu ="afbreken";
      }
    }
    if ((mouseX > (width -(3*(width/12)))) && mouseX < (width - (width/12)) && mouseY > (height - 3*(height/25)) && mouseY < (height - (height/25))) {    //blok 4
      fill(255, 0, 0);
      rect(width-(3*(width/12)), height - (3*height/25), width - (width-(2*(width/12))), height - (height-2*(height/25)));   //blok 4 rechtsonder      
      if (mousePressed == true) {
        menu ="geef pincode";
      }
    }
    break;
  case "geef pincode":
    background(255, 0, 0);
    if (mousePressed == true) {
      menu ="eerstekeuze";
    }
    break;

  case "saldo":
    background(0, 0, 255);
    fill(0,0,0);
    text("uw saldo is:", 2*(width/12), 3*(height/25));
    int x = 100;
    fill(0,0,0);
    text(x,  4*(width/12), 3*(height/25));
    
    fill(0, 0, 0);
    rect(width-(width-width/12), height - (3*height/25), width - (width-2*(width/12)), height - (height-2*(height/25)));       //blok 3 linksonder
    fill(255, 0, 0);
    text("afbreken", width-(width-width/12), height -2*height/25);

    fill (0, 0, 0);
    rect(width-(3*(width/12)), height - (3*height/25), width - (width-(2*(width/12))), height - (height-2*(height/25)));   //blok 4 rechtsonder
    fill(255, 0, 0);
    text("geld opnemen", width-(3*(width/12)), height - (2*height/25));

    if ((mouseX > (width -(width-width/12))) && mouseX < (width - (width-3*(width/12))) && mouseY > (height - 3*(height/25)) && mouseY < (height - (height/25))) {    //blok 3 
      fill(0, 255, 0);
      rect(width-(width-width/12), height - (3*height/25), width - (width-2*(width/12)), height - (height-2*(height/25)));
      if (mousePressed == true) {
        menu ="afbreken";
      }
    }
    if ((mouseX > (width -(3*(width/12)))) && mouseX < (width - (width/12)) && mouseY > (height - 3*(height/25)) && mouseY < (height - (height/25))) {    //blok 4
      fill(255, 0, 0);
      rect(width-(3*(width/12)), height - (3*height/25), width - (width-(2*(width/12))), height - (height-2*(height/25)));   //blok 4 rechtsonder      
      if (mousePressed == true) {
        menu ="geld opnemen";
      }
    }
      break;

    case "geld opnemen":
      background(0, 0, 0);
      fill(255,0,0);
      text("kies bedrag:", height/2, width/2);
      
      fill(0, 0, 0);
    rect(width-(width-width/12), height - (height-height/25), width - (width-2*(width/12)), height - (height-2*(height/25)));       //blok 1 linksboven
    fill(255, 0, 0);
    text("20", width-(width-width/12), height - (height-2*height/25));

    fill(0, 0, 0);
    rect(width-(3*(width/12)), height - (height-height/25), width - (width-(2*(width/12))), height - (height-2*(height/25)));   //blok 2 rechtsboven
    fill(255, 0, 0);
    text("70", width-(3*(width/12)), height - (height-2*height/25));

    fill(0, 0, 0);
    rect(width-(width-width/12), height - (3*height/25), width - (width-2*(width/12)), height - (height-2*(height/25)));       //blok 3 linksonder
    fill(255, 0, 0);
    text("50", width-(width-width/12), height -2*height/25);

    fill (0, 0, 0);
    rect(width-(3*(width/12)), height - (3*height/25), width - (width-(2*(width/12))), height - (height-2*(height/25)));   //blok 4 rechtsonder
    fill(255, 0, 0);
    text("100", width-(3*(width/12)), height -2*(height/25));


    if ((mouseX > (width -(width-width/12))) && mouseX < (width - (width-3*(width/12))) && (mouseY > (height-(height - height/25))) && mouseY < height-(height-3*(height/25))) {    //blok 1
      fill(255, 0, 0);
      rect(width-(width-width/12), height - (height-height/25), width - (width-2*(width/12)), height - (height-2*(height/25))); 
      if (mousePressed == true) {
        menu ="";
      }
    }
    if ((mouseX > (width -(3*(width/12)))) && mouseX < (width - (width/12)) && (mouseY > (height-(height - height/25))) && mouseY < height-(height-3*(height/25))) {    //blok 2
      fill(0, 255, 0);
      rect(width-(3*(width/12)), height - (height-height/25), width - (width-(2*(width/12))), height - (height-2*(height/25)));
      if (mousePressed == true) {
        menu ="";
      }
    }

    if ((mouseX > (width -(width-width/12))) && mouseX < (width - (width-3*(width/12))) && mouseY > (height - 3*(height/25)) && mouseY < (height - (height/25))) {    //blok 3 
      fill(0, 255, 0);
      rect(width-(width-width/12), height - (3*height/25), width - (width-2*(width/12)), height - (height-2*(height/25)));
      if (mousePressed == true) {
        menu ="";
      }
    }
    if ((mouseX > (width -(3*(width/12)))) && mouseX < (width - (width/12)) && mouseY > (height - 3*(height/25)) && mouseY < (height - (height/25))) {    //blok 4
      fill(255, 0, 0);
      rect(width-(3*(width/12)), height - (3*height/25), width - (width-(2*(width/12))), height - (height-2*(height/25)));   //blok 4 rechtsonder      
      if (mousePressed == true) {
        menu ="";
      }
    }
      break;

    case "afbreken": 
      background(0, 0, 0);
      fill(255, 0, 0);
      text("neem uw pas uit", width/2, height/2);
      break;
    }
  }
