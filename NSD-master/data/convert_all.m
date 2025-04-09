files = {'hsa', 'mm', 'dme', 'cel', 'sce'};

mkdir('data');

for i = 1:length(files)
    name = files{i};
    [A, nodes] = net2mat_edgelist([name '.net']);  % ← nodes 포함
    fprintf('%s adjacency matrix size: %d x %d\n', name, size(A,1), size(A,2));
    save(['data/' name '.mat'], 'A', 'nodes', '-v7.3');  % ← nodes도 저장
end
