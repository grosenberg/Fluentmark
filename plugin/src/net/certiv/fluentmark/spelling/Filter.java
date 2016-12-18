package net.certiv.fluentmark.spelling;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPartitioningException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Region;

import net.certiv.fluentmark.editor.Partitions;

public class Filter {

	public IRegion[] exec(IDocument doc, IRegion[] regions) throws BadLocationException, BadPartitioningException {
		List<IRegion> results = new ArrayList<>();

		if (doc instanceof IDocumentExtension3) {
			ITypedRegion[] partitions = ((IDocumentExtension3) doc).computePartitioning(Partitions.MK_PARTITIONING, 0,
					doc.getLength(), false);

			List<ITypedRegion> partitionsList = new ArrayList<>();
			for (ITypedRegion partition : partitions) {
				if (partition.getType().equals(IDocument.DEFAULT_CONTENT_TYPE)) {
					partitionsList.add(partition);
				}
			}

			for (IRegion region : regions) {
				for (IRegion partition : partitionsList) {
					intersect(new Diff(partition, region), results);
				}
			}
		}

		IRegion[] mkRegions = results.toArray(new IRegion[results.size()]);
		return mkRegions;
	}

	// region contained fully within
	// region completely covers
	// region overlaps begining
	// region overlaps end
	private void intersect(Diff diff, List<IRegion> results) {
		if (diff.contained()) {
			results.add(diff.region);
		} else if (diff.covers()) {
			IRegion[] cover = diff.split3();
			results.add(cover[1]);
		} else if (diff.overlapsStart()) {
			IRegion[] cover = diff.splitBeg();
			results.add(cover[1]);
		} else if (diff.overlapsEnd()) {
			IRegion[] cover = diff.splitEnd();
			results.add(cover[0]);
		}
	}

	class Diff {

		IRegion region;
		Segment pSeg;
		Segment rSeg;

		// region relative to partition
		boolean startsBefore;
		boolean startsWithin;
		boolean endsWithin;
		boolean endsAfter;

		public Diff(IRegion partition, IRegion region) {
			this.region = region;

			pSeg = new Segment(partition);
			rSeg = new Segment(region);
			startsBefore = rSeg.beg < pSeg.beg;
			startsWithin = rSeg.beg >= pSeg.beg && rSeg.beg <= pSeg.end;
			endsWithin = rSeg.end >= pSeg.beg && rSeg.end <= pSeg.end;
			endsAfter = rSeg.end > pSeg.end;
		}

		public boolean contained() {
			return startsWithin && endsWithin;
		}

		public boolean covers() {
			return startsBefore && endsAfter;
		}

		public boolean overlapsStart() {
			return startsBefore && endsWithin;
		}

		public boolean overlapsEnd() {
			return startsWithin && endsAfter;
		}

		public IRegion[] split3() {
			IRegion[] split = new IRegion[3];
			split[0] = new Region(rSeg.beg, pSeg.beg - rSeg.beg + 1);
			split[1] = new Region(pSeg.beg, pSeg.len);
			split[2] = new Region(pSeg.end + 1, rSeg.end - pSeg.end + 2);
			return split;
		}

		public IRegion[] splitBeg() {
			IRegion[] split = new IRegion[2];
			split[0] = new Region(rSeg.beg, pSeg.beg - rSeg.beg + 1);
			split[1] = new Region(pSeg.beg, rSeg.end - pSeg.beg + 1);
			return split;
		}

		public IRegion[] splitEnd() {
			IRegion[] split = new IRegion[2];
			split[0] = new Region(rSeg.beg, pSeg.end - rSeg.beg + 1);
			split[1] = new Region(pSeg.end + 1, rSeg.end - pSeg.end + 2);
			return split;
		}
	}

	class Segment {

		int beg;
		int end;
		int len;

		public Segment(IRegion part) {
			beg = part.getOffset();
			len = part.getLength();
			end = beg + len - 1;
		}
	}
}
