void setup(){
  size(1920, 1080);  //width height
  background(0,0,255);
}

void draw(){
  fill(0,0,0);
 rect(width-1440,height - 810,width - 960 ,height - 540); 
 
 if ((mouseX > (width-1440)) && (mouseX < width - 960)){
   fill(255,0,0);
 rect(width-1440,height - 810,width - 960 ,height - 540); 
 }
}
