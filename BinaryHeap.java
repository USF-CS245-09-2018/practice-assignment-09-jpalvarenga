package priorityqueue;

public class BinaryHeap {
	
	private int[] heap;
	private int top = 0;
	
	public BinaryHeap() {
		this.heap = new int[10];
	}
	
	public void add(int element) {
		
		if(top >= this.heap.length) {
			int[] current = new int[this.heap.length * 2];
			for(int i = 0; i < heap.length; i++) {
				current[i] = this.heap[i];
			}
			this.heap = current;
		}
		
		
		this.heap[top] = element;

		
		int index = top;
		int parent = (index - 1)/2;
		
		swiftTop(index, parent);
		
		this.top++;
	}
	
	private void swap(int index, int parent) {
		int temp = this.heap[parent];
		this.heap[parent] = this.heap[index];
		this.heap[index] = temp;
	}
	
	public int remove() {
		int element = this.heap[0];
		this.heap[0] = this.heap[top - 1];
		top--;
		swiftDown(0);
		return element;
	}
	
	public void swiftDown(int parent) {
		
		int left = parent * 2 + 1;
		int right  = left + 1;
		
		
		if(left >= top) {
			return;
		}
		
		int index;
		
		if(this.heap[left] < this.heap[right]) {
			index = left;
		} else {
			index = right;
		}
		
		if(this.heap[index] < this.heap[parent]) {
			swiftTop(index, parent);
			swiftDown(index);
		}
		
		
	}
	
	private void swiftTop(int index, int parent) {
		while(this.heap[index] < this.heap[parent]) {
			swap(index, parent);
			index = parent;
			parent = (index - 1)/2;
		}
	}
	
	@Override
	public String toString() {
		String str = "[";
		str = str + this.heap[0];
		for(int i = 1; i < top; i++) {
			str = str + ", " + this.heap[i];
		}
		str = str + "]";
		return str;
	}	
}
