const grid: any = document.getElementsByClassName('row');

console.log('script loaded');

const royalPurple: string = '#912A91';
const black: string = '#000000'
const white: string = '#FFFFFF'
const softPink: string = '#E4AFE7';

if (grid) {
    console.log('grid is found');
} else {
    console.log('grid is not found');
}

Array.from(grid).forEach((row: any) => {
    console.log('loaded row');
    const cols = row.getElementsByClassName('col')
    Array.from(cols).forEach((coord: any)=> {
        console.log('loaded col');

        coord.addEventListener('mouseup', mouseUp);
        coord.addEventListener('mousedown', mouseDown);
        coord.addEventListener('mouseover', hover);
        coord.addEventListener('mouseleave', mouseLeave);
    });
});

let selectedRow: number = -1;
let selectedCol: number = -1;

function textToNumber(text: string): number {
    switch (text) {
        case "one":
            return 1;
        case "two":
            return 2;
        case "three":
            return 3;
        case "four":
            return 4;
        case "five":
            return 5;
        case "six":
            return 6;
        case "seven":
            return 7;
        case "eight":
            return 8;
        default:
            throw new Error("Invalid Board Index");
    }
}

function mouseUp(this: any) {
    this.backgroundColor = white;
}

function mouseDown(this: any) {
    this.style.backgroundColor = royalPurple;
}

function saveCoord(this: any) {
    const coordColClasses = this.classList;

}

function mouseLeave(this: any) {
    this.style.backgroundColor = white;
}

function hover(this: any) {
    this.style.backgroundColor = softPink;
}
