networks = {'hsa', 'mm', 'dme', 'cel', 'sce'};
n = length(networks);

preiters = 2;
iters = 10;
alpha = 0.8;

if ~exist('results', 'dir')
    mkdir('results');
end

for i = 1:n
    for j = i+1:n
        nameA = networks{i};
        nameB = networks{j};

        fprintf('Running NSD for %s vs %s...\n', nameA, nameB);

        dataA = load(['data/' nameA '.mat']);
        dataB = load(['data/' nameB '.mat']);
        A = dataA.A;
        B = dataB.A;

        [M, G, sim_sparsity, dt] = NSD_greedy(A, B, preiters, iters, alpha);

        % 저장
        save(['results/matching_' nameA '_' nameB '.mat'], 'M', 'G', 'sim_sparsity', 'dt');

        % 매칭 간단히 출력
        fprintf('-> Match size: %d\n', nnz(M));
    end
end
