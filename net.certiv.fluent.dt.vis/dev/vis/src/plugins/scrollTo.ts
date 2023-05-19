/**
 * Scroll the document container to position a document line at vertical center.
 *
 * First attempts to center using a marked element.
 * If not found, centers by line approximation.
 *
 * @param line current editor line number
 * @param total total number of lines in the editor document
 */
export function scrollTo(line: number, total: number): void {
  const mark = document.getElementById('scrollToId');
  if (mark) {
    console.log('ScrollTo marker');
    mark.scrollIntoView({
      behavior: 'smooth',
      block: 'center',
      inline: 'center',
    });
  } else {
    const maxY = scrollMaxY();
    const posY = (line * maxY) / total;

    console.log('ScrollTo posY: %s/%s', posY, maxY);
    const box = document.getElementById('boxId');
    box?.scrollTo({ top: posY, behavior: 'smooth' });
  }
}

function scrollMaxY(): number {
  const box = document.getElementById('boxId');
  if (!box) return 800;
  const height = Math.max(box.clientHeight, box.scrollHeight, box.offsetHeight);
  return height - window.innerHeight;
}

/**
 * Calculates and applies the height property for the element identified by
 * 'boxId'. The height value is computed as the max available height, adjusted
 * for the window inner height and excluding the fixed height of the header
 * identified by 'hdrId'.
 */
export function calcHeight(): string {
  const height = compute() + 'px';
  const box = document.getElementById('boxId');
  if (box) {
    box.style.height = height;
    console.log('Resize: height=%s', height);
  }
  return height;
}

function compute(): number {
  let height = document.documentElement.getBoundingClientRect().height;
  const header = document.getElementById('hdrId');
  if (header) height -= header.clientHeight;
  height -= 130; // margins fudge factor!!!
  console.log('Computed height: %s', height);
  return height;
}
